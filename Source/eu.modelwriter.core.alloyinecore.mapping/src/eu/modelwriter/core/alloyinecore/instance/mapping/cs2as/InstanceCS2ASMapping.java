package eu.modelwriter.core.alloyinecore.instance.mapping.cs2as;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import eu.modelwriter.core.alloyinecore.internal.AIEConstants;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreBaseVisitor;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreLexer;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.BooleanValueContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.DataValueContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EObjectContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EnumValueContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.InstanceContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.IntegerValueContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.LiteralValueContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ModelImportContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.MultiValueDataContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.NullValueContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.PackageImportContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.PathNameContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.RealValueContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.SlotContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.StringValueContext;
import eu.modelwriter.core.alloyinecore.ui.mapping.AIEImport;
import eu.modelwriter.core.alloyinecore.ui.mapping.EcoreUtilities;
import eu.modelwriter.core.alloyinecore.ui.mapping.cs2as.CS2ASRepository;

public class InstanceCS2ASMapping extends AlloyInEcoreBaseVisitor<Object> {
  private final CS2ASRepository repository;
  private String modelName;
  private final Map<ParseTree, EObject> ctx2Obj;

  public InstanceCS2ASMapping() {
    repository = new CS2ASRepository();
    ctx2Obj = new HashMap<>();
  }

  /**
   *
   * @param fileInput : alloy in ecore instance program input.
   * @param saveURI : save location for ecore instance file.
   */
  public EObject parseAndSave(final String fileInput, final URI saveURI) {

    final ANTLRInputStream inputStream = new ANTLRInputStream(fileInput);
    final AlloyInEcoreLexer lexer = new AlloyInEcoreLexer(inputStream);
    final CommonTokenStream tokens = new CommonTokenStream(lexer);
    final AlloyInEcoreParser parser = new AlloyInEcoreParser(tokens, saveURI, false);
    parser.removeErrorListeners();
    final ParseTree instance = parser.instance(null);

    final EObject oldRoot = repository.loadAndClearAIEResource(saveURI);

    isRoot = true;
    try {
      visit(instance);
      final EObject newRoot = repository.getRootObject();
      repository.saveResource(newRoot, saveURI);
      return newRoot;
    } catch (final Exception e) {
      e.printStackTrace();
      repository.saveResource(oldRoot, saveURI);
      return oldRoot;
    }
  }

  @Override
  public Object visitInstance(final InstanceContext ctx) {
    return super.visitInstance(ctx);
  }

  @Override
  public Object visitPackageImport(final PackageImportContext ctx) {
    String path = null;
    if (ctx.ownedPathName != null) {
      path = ctx.ownedPathName.getText().replace("'", "");
    }

    final Resource resource = repository.loadResource(path);

    final String name = ctx.name != null ? ctx.name.getText()
        : resource.getContents().get(0) instanceof ENamedElement
        ? ((ENamedElement) resource.getContents().get(0)).getName() : null;

        final AIEImport aieImport =
            AIEImport.newInstance().setName(name).setPath(path).setResource(resource);
        repository.name2Import.put(name, aieImport);
        return null;
  }

  @Override
  public Object visitModelImport(final ModelImportContext ctx) {
    String path = null;
    if (ctx.ownedPathName != null) {
      path = ctx.ownedPathName.getText().replace("'", "");
    }

    final Resource resource = repository.loadResource(path);

    modelName = ctx.name != null ? ctx.name.getText()
        : resource.getContents().get(0) instanceof ENamedElement
        ? ((ENamedElement) resource.getContents().get(0)).getName() : null;

        final AIEImport aieImport =
            AIEImport.newInstance().setName(modelName).setPath(path).setResource(resource);
        repository.name2Import.put(modelName, aieImport);
        return null;
  }

  @Override
  public EObject visitPathName(final PathNameContext ctx) {
    String rootElementName;
    final List<String> relativePathFragments =
        new ArrayList<>(Arrays.asList(ctx.getText().split(AIEConstants.SEPARATOR)));

    if (repository.name2Import.containsKey(ctx.firstSegment.getText())) { // full path
      rootElementName = ctx.firstSegment.getText();
      relativePathFragments.remove(0); // root is unnecessary.

      return repository.getEObject(rootElementName, relativePathFragments);
    } else { // relative path
      rootElementName = modelName;
      return repository.getEObject(rootElementName, relativePathFragments);
    }
  }

  private boolean isRoot;

  @Override
  public Object visitEObject(final EObjectContext ctx) {
    if (ctx2Obj.containsKey(ctx)) {
      return ctx2Obj.get(ctx);
    }

    final EObject modelObject = visitPathName(ctx.name);

    String literalValue = null;
    if (ctx.literalValue() != null) {
      literalValue = ctx.literalValue().getText();
      literalValue = removeStartEndQuotes(literalValue);
    }

    EObject instanceObject = null;
    if (modelObject instanceof EClass) {
      instanceObject = EcoreUtil.create((EClass) modelObject);
      if (literalValue != null) {
        final EAttribute eidAttribute = ((EClass) modelObject).getEIDAttribute();
        EcoreUtilities.eSetAttributeByName(instanceObject, eidAttribute.getName(), literalValue);
      }
    } else if (modelObject instanceof EDataType) {
      instanceObject = (EObject) EcoreUtil.createFromString((EDataType) modelObject, literalValue);
    }

    if (isRoot) {
      repository.aieResource.getContents().add(instanceObject);
      isRoot = false;
    }

    ctx2Obj.put(ctx, instanceObject);
    super.visitEObject(ctx);
    return instanceObject;
  }

  @Override
  public Object visitSlot(final SlotContext ctx) {
    final String slotName = ctx.name.getText();
    final EObject sourceObject = ctx2Obj.get(ctx.parent);

    if (ctx.eObject() != null) {
      ctx.eObject().forEach(o -> {
        final EObject targetObject = (EObject) visitEObject(o);
        EcoreUtilities.eSetStructuralFeatureByName(sourceObject, slotName, targetObject);
      });
    }

    if (ctx.eObjectValue() != null) {
      ctx.eObjectValue().forEach(eov -> {
        final EObject targetObject = visitPathName(eov.pathName());
        EcoreUtilities.eSetStructuralFeatureByName(sourceObject, slotName, targetObject);
      });
    }

    if (ctx.dataValue() != null) {
      final List<Object> targetObjects = visitDataValue(ctx.dataValue());
      for (final Object targetObject : targetObjects) {
        EcoreUtilities.eSetStructuralFeatureByName(sourceObject, slotName, targetObject);
      }
    }

    return super.visitSlot(ctx);
  }

  @Override
  public List<Object> visitDataValue(final DataValueContext ctx) {
    final List<Object> list = new ArrayList<>();
    if (ctx.literalValue() != null) {
      list.add(visitLiteralValue(ctx.literalValue()));
    } else if (ctx.multiValueData() != null) {
      list.addAll(visitMultiValueData(ctx.multiValueData()));
    }
    return list;
  }

  @Override
  public Object visitLiteralValue(final LiteralValueContext ctx) {
    if (ctx.enumValue() != null) {
      return visitEnumValue(ctx.enumValue());
    } else if (ctx.integerValue() != null) {
      return visitIntegerValue(ctx.integerValue());
    } else if (ctx.realValue() != null) {
      return visitRealValue(ctx.realValue());
    } else if (ctx.stringValue() != null) {
      return visitStringValue(ctx.stringValue());
    } else if (ctx.booleanValue() != null) {
      return visitBooleanValue(ctx.booleanValue());
    } else if (ctx.nullValue() != null) {
      return visitNullValue(ctx.nullValue());
    }
    return null;
  }

  // FIXME enumvalue ambiguity !
  @Override
  public Object visitEnumValue(final EnumValueContext ctx) {
    final String value = ctx.getText();
    final EDataType eString = EcorePackage.eINSTANCE.getEString();
    final Object instanceObject = EcoreUtil.createFromString(eString, value);
    return instanceObject;
  }

  @Override
  public Object visitIntegerValue(final IntegerValueContext ctx) {
    final String value = ctx.getText();
    final EDataType eInt = EcorePackage.eINSTANCE.getEInt();
    final Object instanceObject = EcoreUtil.createFromString(eInt, value);
    return instanceObject;
  }

  @Override
  public Object visitRealValue(final RealValueContext ctx) {
    final String value = ctx.getText();
    final EDataType eReal = EcorePackage.eINSTANCE.getEBigDecimal();
    final Object instanceObject = EcoreUtil.createFromString(eReal, value);
    return instanceObject;
  }

  @Override
  public Object visitStringValue(final StringValueContext ctx) {
    String value = ctx.getText();
    value = removeStartEndQuotes(value);
    final EDataType eString = EcorePackage.eINSTANCE.getEString();
    final Object instanceObject = EcoreUtil.createFromString(eString, value);
    return instanceObject;
  }

  @Override
  public Object visitBooleanValue(final BooleanValueContext ctx) {
    final String value = ctx.getText();
    final EDataType eBoolean = EcorePackage.eINSTANCE.getEBoolean();
    final Object instanceObject = EcoreUtil.createFromString(eBoolean, value);
    return instanceObject;
  }

  @Override
  public Object visitNullValue(final NullValueContext ctx) {
    return null;
  }

  @Override
  public List<Object> visitMultiValueData(final MultiValueDataContext ctx) {
    final List<Object> list = new ArrayList<>();
    if (ctx.dataValue() != null) {
      ctx.dataValue().forEach(dv -> {
        list.addAll(visitDataValue(dv));
      });
    }
    return list;
  }

  private String removeStartEndQuotes(String value) {
    value = value.startsWith("\"") ? value.substring(1) : value;
    value = value.endsWith("\"") ? value.substring(0, value.length() - 1) : value;
    return value;
  }
}
