package eu.modelwriter.core.alloyinecore.typechecking;

import eu.modelwriter.core.alloyinecore.structure.base.Element;
import eu.modelwriter.core.alloyinecore.structure.base.INavigable;
import eu.modelwriter.core.alloyinecore.structure.base.ITarget;
import eu.modelwriter.core.alloyinecore.structure.model.*;
import eu.modelwriter.core.alloyinecore.structure.model.Class;
import eu.modelwriter.core.alloyinecore.structure.model.Enum;
import eu.modelwriter.core.alloyinecore.structure.model.Package;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

import javax.tools.Diagnostic;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class JavaSourceGenerator {

    private JavaSourceGenerator importGenerator;
    private Set<JavaSourceFromString> generatedFiles = new HashSet<>();

    private Set<Trace> traces = new HashSet<>();
    private String currentFileName = "";
    private int currentLineNumber = 0;
    private StringBuilder builder;
    private List<String> javaKeywords = new ArrayList<>(Arrays.asList(new String[]{"abstract", "assert", "boolean", "break", "byte",
            "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else",
            "enum", "extends", "final", "finally", "float",
            "for", "goto", "if", "implements", "import",
            "instanceof", "int", "interface", "long", "native",
            "new", "package", "private", "protected", "public",
            "return", "short", "static", "strictfp", "super",
            "switch", "synchronized", "this",
            "throw", "throws",
            "transient",
            "try",
            "void",
            "volatile",
            "while"}));

    public JavaSourceGenerator() {
    }

    private void setGeneratedFiles(Set<JavaSourceFromString> generatedFiles) {
        this.generatedFiles = generatedFiles;
    }

    private JavaSourceGenerator getImportGenerator() {
        if (importGenerator == null) importGenerator = new JavaSourceGenerator();
        importGenerator.setGeneratedFiles(generatedFiles);
        return importGenerator;
    }

    public Set<JavaSourceFromString> getGeneratedFiles() {
        return generatedFiles;
    }

    public Set<Trace> getTraces() {
        return traces;
    }

    public Set<Token> findTokens(Diagnostic diagnostic) {
        for (Trace trace : getTraces()) {
            if (trace.overlaps(diagnostic))
                return trace.getTokens();
        }
        return Collections.emptySet();
    }

    public String getTokensAsString(Diagnostic diagnostic) {
        return findTokens(diagnostic).stream()
                .filter(Objects::nonNull)
                .map(token -> token.getText() + " at line " + token.getLine())
                .collect(Collectors.joining(", "));
    }

    public void clearTraces() {
        traces.clear();
    }

    private void setup(Element<? extends ParserRuleContext> element) {
        builder = new StringBuilder();
        currentLineNumber = 0;
        currentFileName = getJavaPath(element, "/", true);
    }

    private JavaSourceFromString finish() {
        String code2 = builder.toString();
        JavaSourceFromString generated = new JavaSourceFromString(currentFileName, code2);
        System.out.println(generated.getCode() + "\n\n");
        generatedFiles.add(generated);
        return generated;
    }

    public JavaSourceFromString generateInterface(Element<? extends ParserRuleContext> claz) {
        setup(claz);
        classToJavaInterface(claz);
        return finish();
    }

    public JavaSourceFromString generateEnum(Element<? extends ParserRuleContext> _enum) {
        setup(_enum);
        enumToJavaEnum(_enum);
        return finish();
    }


    public JavaSourceFromString generateDataType(Element<? extends ParserRuleContext> dataType) {
        setup(dataType);
        dataTypeToJavaDataType(dataType);
        return finish();
    }

    private void enumToJavaEnum(Element<? extends ParserRuleContext> anEnum) {
        appendPackage(anEnum);
        builder.append(newLine());
        builder.append(newLine());
        appendImports(anEnum);
        builder.append(newLine());
        appendEnum(anEnum);
    }

    private void appendEnumLiterals(Element<? extends ParserRuleContext> anEnum) {
        List<EnumLiteral> literals = anEnum.getOwnedElements(EnumLiteral.class);
        boolean hasValue = false;
        for (Iterator<EnumLiteral> iterator = literals.iterator(); iterator.hasNext(); ) {
            EnumLiteral literal = iterator.next();
            builder.append("\t");
            appendWithToken(literal.getToken().getText(), literal.getToken());
            builder.append("(");
            if (literal.getContext().value != null) {
                hasValue = true;
                appendWithToken(literal.getContext().value.getText(), literal.getContext().value);
            }
            builder.append(")");
            if (iterator.hasNext())
                builder.append(",");
            else
                builder.append(";");
            builder.append(newLine());
        }
        if (hasValue) {
            builder.append(newLine());
            builder.append("\tprivate int value;");
            builder.append(newLine());
            builder.append("\t");
            builder.append(anEnum.getToken().getText());
            builder.append("(int value) { this.value = value; }");
            builder.append(newLine());
            builder.append("\t");
            builder.append(anEnum.getToken().getText());
            builder.append("(){}");
            builder.append(newLine());
        }
    }

    private void appendEnum(Element<? extends ParserRuleContext> anEnum) {
        appendVisibility(anEnum);
        appendWithToken("enum " + checkName(anEnum.getToken().getText()), anEnum.getToken());

        builder.append(newLine());
        builder.append("{");
        builder.append(newLine());

        appendEnumLiterals(anEnum);
        builder.append("}");
    }

    private void dataTypeToJavaDataType(Element<? extends ParserRuleContext> dataType) {
        appendPackage(dataType);
        builder.append(newLine());
        builder.append(newLine());
        appendImports(dataType);
        builder.append(newLine());
        appendDataType(dataType);
    }

    private void appendDataType(Element<? extends ParserRuleContext> dataType) {
        appendVisibility(dataType);
        String className = checkName(dataType.getToken().getText());
        appendWithToken("class " + className, dataType.getToken());
        appendTypeParameters(dataType.getOwnedElements(TypeParameter.class));
        builder.append(newLine());
        builder.append("{");
        String instanceClsName = ((DataType) dataType).getInstanceClassName();
        if (instanceClsName != null && (instanceClsName.startsWith("java.") || !instanceClsName.contains("."))) {
            builder.append(newLine());
            builder.append("\t");
            builder.append(className);
            builder.append("(");
            String typeParams = dataType.getLabel().replace(dataType.getToken().getText(), "");
            appendWithToken(instanceClsName + typeParams, ((DataType) dataType).getContext().instanceClassName);
            builder.append(" arg");
            builder.append("){}");
        }
        builder.append(newLine());
        builder.append("}");
    }

    private void classToJavaInterface(Element<? extends ParserRuleContext> element) {
        appendPackage(element);
        builder.append(newLine());
        builder.append(newLine());
        appendImports(element);
        builder.append(newLine());
        appendInterface(element);

        System.out.println("INavigables: " + element.getAllOwnedElements(INavigable.class, true)
                .stream().map(INavigable::getPathName).collect(Collectors.joining(", ")));
    }

    private void appendPackage(Element<? extends ParserRuleContext> element) {
        builder.append("package ");
        builder.append(getJavaPath(element, ".", false));
        builder.append(";");
        Trace packageTrace = new Trace(currentFileName, 0, 0, builder.length() - 1);
        packageTrace.addToken(element.getOwner().getToken());
        traces.add(packageTrace);
    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    private void appendImports(Element<? extends ParserRuleContext> element) {
        element.getAllOwnedElements(INavigable.class, true).stream()
                .filter(distinctByKey(INavigable::getPathName))
                .forEach(this::appendImport);
    }

    private void appendImport(INavigable navigable) {
        String pathName = navigable.getPathName();
        String importText = "";
        if (isPrimitive(pathName) || isTypeParameter(navigable, pathName) || pathName.equals("?") || pathName.isEmpty())
            return;
        ITarget target = navigable.getTarget();
        if (target == null) return;
        if (target.asElement().isImported()) {
            String javaPath = getJavaPath(target.asElement(), "/", true);
            if (!isGenerated(javaPath)) {
                JavaSourceFromString generatedImport = null;
                if (target instanceof Class)
                    generatedImport = getImportGenerator().generateInterface(target.asElement());
                else if (target instanceof Enum)
                    generatedImport = getImportGenerator().generateEnum(target.asElement());
                else if (target instanceof DataType)
                    generatedImport = getImportGenerator().generateDataType(target.asElement());
                if (generatedImport != null) {
                    generatedFiles.add(generatedImport);
                    // And use its path for import
                    importText = generatedImport.getRawName().replaceAll("/", ".");
                }
            } else {
                importText = javaPath.replaceAll("/", ".");
            }
        } else if (!(target instanceof TypeParameter)) {
            importText = target.getFullSegment().replaceAll("::", ".");
        }
        if (!importText.isEmpty()) {
            builder.append("import ");
            appendWithToken(importText, navigable.asElement().getToken());
            builder.append(";");
            builder.append(newLine());
        }
    }

    private boolean isTypeParameter(INavigable navigable, final String pathName) {
        if (pathName.length() != 1 || pathName.equals("?")) return false;

        Element<?> op = ((Element) navigable).getOwner(Operation.class);
        if (op != null && op.getOwnedElements(TypeParameter.class).stream()
                .anyMatch(tp -> tp.getContext().start.getText().equals(pathName))) {
            return true;
        } else {
            Element<?> cls = ((Element) navigable).getOwner(Class.class);
            return cls != null && cls.getOwnedElements(TypeParameter.class).stream()
                    .anyMatch(tp -> tp.getContext().start.getText().equals(pathName));
        }
    }

    private void appendInterface(Element<? extends ParserRuleContext> element) {
        appendVisibility(element);
        // Append Class label as interface name
        appendInterfaceName(element);
        appendSuperTypes(element);

        builder.append(newLine());
        builder.append("{");
        builder.append(newLine());
        appendStructuralFeatures(element);
        appendOperations(element);
        builder.append("}");
    }

    private void appendOperations(Element<? extends ParserRuleContext> element) {
        for (Operation op : element.getOwnedElements(Operation.class)) {
            builder.append("\t");
            appendVisibility(op);
            TypeParameter typeParameter = op.getOwnedElement(TypeParameter.class);
            if (typeParameter != null) {
                appendTypeParameters(Collections.singletonList(typeParameter));
            }
            GenericElementType elementType = op.getOwnedElement(GenericElementType.class);
            if (elementType != null) {
                appendGenericElementType(elementType);
                Multiplicity mul = op.getOwnedElement(Multiplicity.class);
                if (mul != null && mul.isMany())
                    builder.append("[]");

            } else builder.append("void");
            builder.append(" ");
            appendWithToken(checkName(op.getToken().getText()), op.getToken());
            builder.append("(");
            appendParameters(op);
            builder.append(")");
            // FIXME Operation: exception throw
            // appendGenericException(op);
            builder.append(";");
            builder.append(newLine());
        }
    }

    private void appendGenericException(Operation op) {
        List<GenericException> exceptions = op.getOwnedElements(GenericException.class);
        if (!exceptions.isEmpty()) {
            builder.append(" throws ");
            for (Iterator<GenericException> iterator = exceptions.iterator(); iterator.hasNext(); ) {
                GenericException exception = iterator.next();
                appendWithToken(exception.getPathName(), exception.getToken());
                // appendGenericTypeArgument(exception);
                if (iterator.hasNext()) builder.append(", ");
            }
        }
    }

    private void appendTypeParameters(List<TypeParameter> typeParameters) {
        if (typeParameters.isEmpty()) return;
        builder.append("<");
        for (Iterator<TypeParameter> iterator = typeParameters.iterator(); iterator.hasNext(); ) {
            TypeParameter tp = iterator.next();
            appendWithToken(tp.getToken().getText(), tp.getContext().start);
            List<GenericType> genericTypes = tp.getOwnedElements(GenericType.class);
            if (!genericTypes.isEmpty()) {
                builder.append(" extends ");
                for (Iterator<GenericType> gtIterator = genericTypes.iterator(); gtIterator.hasNext(); ) {
                    GenericType gt = gtIterator.next();
                    String text = gt.getPathName();
                    if (text.contains("::")) text = text.substring(text
                            .lastIndexOf("::") + 2);
                    appendWithToken(text, gt.getToken());
                    appendGenericTypeArgument(gt);
                    if (gtIterator.hasNext()) builder.append(" & ");
                }
            }
            if (iterator.hasNext()) builder.append(", ");
        }
        builder.append("> ");
    }

    private void appendGenericTypeArgument(Element<? extends ParserRuleContext> element) {
        List<GenericTypeArgument> genericTypeArguments = element.getOwnedElements(GenericTypeArgument.class);
        if (!genericTypeArguments.isEmpty()) {
            builder.append("<");
            for (Iterator<GenericTypeArgument> iterator = genericTypeArguments.iterator(); iterator.hasNext(); ) {
                GenericTypeArgument next = iterator.next();
                String pathName = next.getPathName();
                if (pathName.isEmpty()) {
                    GenericWildcard wildcard = next.getOwnedElement(GenericWildcard.class);
                    String wildcardPathName = wildcard != null ? wildcard.getPathName() : "?";
                    if (wildcardPathName.equals("?"))
                        builder.append("?");
                    else {
                        builder.append("? extends ");
                        appendWithToken(wildcardPathName.contains("::") ?
                                        wildcardPathName.substring(wildcardPathName.lastIndexOf("::") + 2) :
                                        wildcardPathName,
                                wildcard.getToken());
                    }
                    if (wildcard != null) appendGenericTypeArgument(wildcard);
                } else {
                    appendWithToken(pathName, next.getToken());
                }
                if (iterator.hasNext()) builder.append(", ");
            }
            builder.append(">");
        }
    }

    private void appendParameters(Operation op) {
        for (Iterator<Parameter> iterator = op.getOwnedElements(Parameter.class).iterator(); iterator.hasNext(); ) {
            Parameter param = iterator.next();
            appendGenericElementType(param.getOwnedElement(GenericElementType.class));
            builder.append(" ");
            appendWithToken(param.getToken().getText(), param.getToken());
            if (iterator.hasNext()) builder.append(", ");
        }
    }

    private void appendGenericElementType(INavigable type) {
        String typeName = type.getPathName();
        if (typeName.contains("::")) typeName = typeName.substring(typeName.lastIndexOf("::") + 2);
        appendWithToken(handlePrimitives(typeName), ((Element) type).getToken());
        appendGenericTypeArgument((Element<?>) type);
    }

    private String handlePrimitives(String typeName) {
        if (typeName.equals("Real"))
            return "double";
        if (typeName.equals("UnlimitedNatural"))
            return "int";
        if (typeName.equals("Integer"))
            return "int";
        if (typeName.equals("Boolean"))
            return "boolean";
        return typeName;
    }

    private void appendStructuralFeatures(Element<? extends ParserRuleContext> element) {
        List<StructuralFeature> sfs = new ArrayList<>();
        sfs.addAll(element.getOwnedElements(Attribute.class));
        sfs.addAll(element.getOwnedElements(Reference.class));
        for (StructuralFeature<?, ?> sf : sfs) {
            builder.append("\t");
            appendVisibility(sf);
            appendGenericElementType(sf.getOwnedElement(GenericElementType.class));
            Multiplicity mul = sf.getOwnedElement(Multiplicity.class);
            if (mul != null && mul.isMany())
                builder.append("[]");
            builder.append(" ");
            appendWithToken(checkName(sf.getLabel()), sf.getToken());
            builder.append("();");
            builder.append(newLine());
        }
    }

    private void appendInterfaceName(Element<? extends ParserRuleContext> element) {
        appendWithToken("interface " + checkName(element.getToken().getText()), element.getToken());
        appendTypeParameters(element.getOwnedElements(TypeParameter.class));
    }

    private void appendVisibility(Element element) {
        if (element instanceof IVisibility) {
            Visibility value = ((IVisibility) element).getVisibility();
            if (value == Visibility.PUBLIC || (value == Visibility.PROTECTED && !(element instanceof Class))) {
                appendWithToken(value.name().toLowerCase(), element.getToken());
                builder.append(" ");
            }
        }
    }

    private void appendSuperTypes(Element<? extends ParserRuleContext> element) {
        List<GenericSuperType> supers = element.getOwnedElements(GenericSuperType.class);
        if (!supers.isEmpty()) {
            builder.append(" extends ");
            for (Iterator<GenericSuperType> iterator = supers.iterator(); iterator.hasNext(); ) {
                GenericSuperType superType = iterator.next();
                String typeName = superType.getPathName();
                if (typeName.contains("::")) typeName = typeName.substring(typeName.lastIndexOf("::") + 2);
                appendWithToken(typeName, superType.getToken());
                appendGenericTypeArgument(superType);
                if (iterator.hasNext()) builder.append(", ");
            }
        }
    }

    private void appendWithToken(String text, Token token) {
        int start = builder.length() - 1;
        Trace trace = new Trace(currentFileName, currentLineNumber, start, start + text.length());
        trace.addToken(token);
        traces.add(trace);
        builder.append(text);
    }

    private boolean isPrimitive(String text) {
        return text.equals("String") || text.equals("Boolean") || text.equals("Integer") || text.equals("Real") || text.equals("UnlimitedNatural");
    }

    private boolean isGenerated(String path) {
        return generatedFiles.stream().anyMatch(gf -> gf.getRawName().equals(path));
    }

    private String newLine() {
        currentLineNumber++;
        return System.getProperty("line.separator");
    }

    private String checkName(String name) {
        return javaKeywords.contains(name) ? "_aie_" + name : name;
    }

    private String getJavaPath(Element<? extends ParserRuleContext> element, String separator, boolean includeItself) {
        Element ownerPackage = element.getOwner();
        String result = ownerPackage.getToken().getText();
        if (includeItself) result += separator + element.getToken().getText();
        while (ownerPackage.getOwner() != null &&
                (ownerPackage.getOwner() instanceof Package) && !(ownerPackage.getOwner() instanceof Import)) {
            ownerPackage = ownerPackage.getOwner();
            result = ownerPackage.getToken().getText() + separator + result;
        }
        return result;
    }
}
