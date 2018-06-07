package eu.modelwriter.core.alloyinecore.typechecking;

import eu.modelwriter.core.alloyinecore.structure.model.*;
import eu.modelwriter.core.alloyinecore.structure.model.Class;
import eu.modelwriter.core.alloyinecore.structure.model.Enum;
import eu.modelwriter.core.alloyinecore.structure.model.Package;
import eu.modelwriter.core.alloyinecore.visitor.BaseVisitorImpl;
import org.antlr.v4.runtime.Token;

import javax.tools.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class TypeChecker {

    private Set<TypeErrorListener> errorListeners;
    private Set<JavaSourceFromString> generatedJavaFiles;
    private JavaSourceGenerator javaSourceGenerator;
    private String outDir;
    private boolean saveJavaFiles;

    public TypeChecker(String outDir, boolean saveOutput) {
        this.saveJavaFiles = saveOutput;
        try {
            Path path = Paths.get(outDir);
            if (!Files.exists(path))
                Files.createDirectories(path);
            this.outDir = outDir;
        } catch (IOException e) {
            outDir = "";
            e.printStackTrace();
        }
        errorListeners = new HashSet<>();
        javaSourceGenerator = new JavaSourceGenerator();
    }

    public void addErrorListener(TypeErrorListener listener) {
        errorListeners.add(listener);
    }

    public void removeErrorListener(TypeErrorListener listener) {
        errorListeners.remove(listener);
    }

    public Set<JavaSourceFromString> getGeneratedJavaFiles() {
        return generatedJavaFiles;
    }

    public void check(Model model) {
        TypeCheckVisitor visitor = new TypeCheckVisitor();
        visitor.visit(model.getOwnedElement(RootPackage.class));

        generatedJavaFiles = javaSourceGenerator.getGeneratedFiles();
        if (saveJavaFiles) saveGeneratedFiles(generatedJavaFiles);

        // Don't compile if there is no generated file, it will fail
        if (generatedJavaFiles.isEmpty()) return;

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        if (compiler == null) return;

        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null, null);
        List<String> options = outDir.isEmpty() ? null : Arrays.asList("-Xlint:all", "-d", outDir); // -d: output dir
        compiler.getTask(null, fileManager, diagnostics, options, null, generatedJavaFiles).call();
        for (Diagnostic<? extends JavaFileObject> diagnostic : diagnostics.getDiagnostics()) {
            Set<Token> elements = javaSourceGenerator.findTokens(diagnostic);
            for (TypeErrorListener listener : errorListeners) {
                String message = diagnostic.getMessage(Locale.getDefault());
                message += System.getProperty("line.separator") + "(" + diagnostic.getCode() + ")";
                if (diagnostic.getKind() == Diagnostic.Kind.ERROR)
                    listener.onTypeError(message, elements);
                else if (diagnostic.getKind() == Diagnostic.Kind.WARNING || diagnostic.getKind() == Diagnostic.Kind.MANDATORY_WARNING)
                    listener.onTypeWarning(message, elements);
            }
            System.err.format("%s %nMapped to: %s %n%n", diagnostic.toString(), javaSourceGenerator.getTokensAsString(diagnostic));
        }
        try {
            // Try to close fileManager
            fileManager.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveGeneratedFiles(final Set<JavaSourceFromString> generatedJavaFiles) {
        new Thread(() -> {
            for (JavaSourceFromString generatedJavaFile : generatedJavaFiles) {
                saveFile(generatedJavaFile);
            }
        }).start();
    }

    private void saveFile(JavaSourceFromString generated) {
        try {
            Path path = Paths.get(outDir + "/" + generated.getRawName() + ".java");
            if (!Files.exists(path.getParent()))
                Files.createDirectories(path.getParent());
            Files.write(path, generated.code.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class TypeCheckVisitor extends BaseVisitorImpl {

        @Override
        public Object visitClass(Class _class) {
            if (_class.getOwner() instanceof Package) {
                javaSourceGenerator.generateInterface(_class);
            }
            return super.visitClass(_class);
        }

        @Override
        public Object visitInterface(Interface _interface) {
            if (_interface.getOwner() instanceof Package) {
                javaSourceGenerator.generateInterface(_interface);
            }
            return super.visitInterface(_interface);
        }

        @Override
        public Object visitEnum(Enum _enum) {
            if (_enum.getOwner() instanceof Package) {
                javaSourceGenerator.generateEnum(_enum);
            }
            return null;
        }

        @Override
        public Object visitDataType(DataType dataType) {
            if (dataType.getOwner() instanceof Package) {
                javaSourceGenerator.generateDataType(dataType);
            }
            return null;
        }

        @Override
        public Object visitReference(Reference reference) {
            if (reference.isImported()) return null;
            try {
                Reference opposite = reference.getOpposite();
                if (opposite != null) {
                    try {
                        // If has a type that has target, check if its same as this reference's class
                        if (!opposite.getOwnedElement(GenericElementType.class)
                                .getTarget()
                                .equals(reference.getOwner()))
                            throw new Exception("Opposite cannot be different type");
                    } catch (Exception e) {
                        // There might be NullPointerExceptions due to getTarget method and that means we have no target
                        throw new Exception("Opposite cannot be different type");
                    }
                    try {
                        // If Opposite does not have a opposite
                        if (opposite.getOpposite() == null) {
                            onOppositeError("This property has an opposite, there must be an opposite declaration", opposite.getToken());
                        }
                    } catch (Exception ignored) {
                        // These are ignored this because error will be created when opposite accept visitor
                    }
                }
            } catch (Exception e) {
                // Exceptions from getOpposite method
                onOppositeError(e.getLocalizedMessage(), reference.getContext().eOpposite.start);
            }
            return null;
        }

        private void onOppositeError(String message, Token token) {
            HashSet<Token> tokens = new HashSet<>();
            tokens.add(token);
            System.err.println(message + "\n" + token.getText());
            for (TypeErrorListener errorListener : errorListeners) {
                errorListener.onTypeError(message, tokens);
            }
        }
    }
}
