package eu.modelwriter.core.alloyinecore.ui.editor.instance.visualization;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ui.IEditorInput;
import edu.mit.csail.sdg.alloy4.ErrorFatal;
import eu.modelwriter.core.alloyinecore.KodKodFrontEnd_Test.UnderlineListener;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreLexer;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser;
import eu.modelwriter.core.alloyinecore.structure.base.Element;
import eu.modelwriter.core.alloyinecore.structure.base.Repository;
import eu.modelwriter.core.alloyinecore.structure.instance.BooleanValue;
import eu.modelwriter.core.alloyinecore.structure.instance.EnumValue;
import eu.modelwriter.core.alloyinecore.structure.instance.Instance;
import eu.modelwriter.core.alloyinecore.structure.instance.IntegerValue;
import eu.modelwriter.core.alloyinecore.structure.instance.ModelImport;
import eu.modelwriter.core.alloyinecore.structure.instance.Object;
import eu.modelwriter.core.alloyinecore.structure.instance.ObjectValue;
import eu.modelwriter.core.alloyinecore.structure.instance.RealValue;
import eu.modelwriter.core.alloyinecore.structure.instance.Slot;
import eu.modelwriter.core.alloyinecore.structure.instance.StringValue;
import eu.modelwriter.core.alloyinecore.structure.model.Attribute;
import eu.modelwriter.core.alloyinecore.structure.model.Class;
import eu.modelwriter.core.alloyinecore.structure.model.GenericElementType;
import eu.modelwriter.core.alloyinecore.structure.model.Model;
import eu.modelwriter.core.alloyinecore.structure.model.PrimitiveType;
import eu.modelwriter.core.alloyinecore.structure.model.Reference;
import eu.modelwriter.core.alloyinecore.structure.model.RootPackage;
import eu.modelwriter.core.alloyinecore.structure.model.StructuralFeature;
import eu.modelwriter.core.alloyinecore.translator.EcoreInstanceTranslator;
import eu.modelwriter.core.alloyinecore.ui.editor.instance.visualization.model.Atom;
import eu.modelwriter.core.alloyinecore.ui.editor.instance.visualization.model.Relation;
import eu.modelwriter.core.alloyinecore.ui.editor.instance.visualization.model.Universe;
import eu.modelwriter.core.alloyinecore.visitor.BaseVisitorImpl;

@SuppressWarnings({"deprecation", "rawtypes", "unchecked"})
public class ParserInstanceVisualizer extends InstanceVisualizer {

  private Map<Element<?>, Relation> relationMap;
  private Map<String, Atom> name2atom;

  public ParserInstanceVisualizer(IEditorInput input) throws ErrorFatal, IOException {
    super(input);
  }

  protected void createUniverse() {
    relationMap = new HashMap<>();
    name2atom = new HashMap<>();

    this.universe = new Universe();

    Instance instance = getInstance(input.getAdapter(File.class));

    getRelations(instance);

    AtomCollector atomCollector = new AtomCollector();
    atomCollector.visitInstance(instance);

    TupleCollector tupleCollector = new TupleCollector();
    tupleCollector.visit(instance);

    relationMap.values().forEach(e -> universe.addRelation(e));
  }

  protected void getRelations(Instance instance) {
    RootPackage rootPackage = instance.getOwnedElement(ModelImport.class)
        .getOwnedElement(Model.class).getOwnedElement(RootPackage.class);

    rootPackage.getAllOwnedElements(PrimitiveType.class, true)
        .forEach(c -> relationMap.put(c, new Relation(c.getLabel())));
    rootPackage.getAllOwnedElements(Class.class, true)
        .forEach(c -> relationMap.put(c, new Relation(c.getLabel())));
    rootPackage.getAllOwnedElements(StructuralFeature.class, true).forEach(sf -> {
      Relation relation = new Relation(sf.getLabel());

      GenericElementType type = (GenericElementType) sf.getOwnedElement(GenericElementType.class);

      Relation relA = relationMap.get(sf.getOwner());
      Relation relB = null;

      if (type.getTarget() != null) { // If sf is an instance of Reference
        relB = relationMap.get(type.getTarget().asElement());
      } else { // If sf is an instance of Attribute
        relB = relationMap.get(type.getOwnedElement(PrimitiveType.class));
      }

      if (relB != null) { // If range is not a generic type
        relation.addTypes(relA, relB);
      }

      relation.setParent(relA);

      relationMap.put(sf, relation);
    });
  }

  private static Instance getInstance(File file) {
    URI uri = URI.createDeviceURI(file.getAbsolutePath());
    Repository repository = new Repository(uri);
    EcoreInstanceTranslator translator = new EcoreInstanceTranslator(repository);
    ANTLRInputStream input = null;
    try {
      input = new ANTLRInputStream(translator.translate(file.getAbsolutePath()));
    } catch (final IOException e) {
      e.printStackTrace();
    }

    final AlloyInEcoreLexer lexer = new AlloyInEcoreLexer(input);
    final CommonTokenStream tokens = new CommonTokenStream(lexer);
    final AlloyInEcoreParser parser = new AlloyInEcoreParser(tokens, uri, false);
    parser.removeErrorListeners();
    parser.addErrorListener(new UnderlineListener());
    parser.instance(null);

    return parser.instance;
  }

  private String getAtomName(Element<?> object) {
    if (object instanceof ObjectValue)
      object = ((ObjectValue) object).getObject();
    int line = object.getStart();
    return object.getLabel() + line;
  }

  private class AtomCollector extends BaseVisitorImpl<Object> {

    @Override
    public Object visitStringValue(StringValue stringValue) {
      String relName = "EString";
      PrimitiveType pt = (PrimitiveType) relationMap.entrySet().stream()
          .filter(e -> e.getValue().getName().equals(relName)).map(Map.Entry::getKey).findFirst()
          .orElse(null);
      Relation relation = relationMap.get(pt);
      if (relation != null) {
        Atom atom = new Atom(stringValue.getLabel());
        atom.setLocatedIn(relation);
        name2atom.put(atom.getText(), atom);
        relation.addAtomWithTuple(atom);
      } else
        System.err.println("Relation not found for " + relName);
      return super.visitStringValue(stringValue);
    }

    @Override
    public Object visitIntegerValue(IntegerValue integerValue) {
      String relName = "EInt";
      PrimitiveType pt = (PrimitiveType) relationMap.entrySet().stream()
          .filter(e -> e.getValue().getName().equals(relName)).map(Map.Entry::getKey).findFirst()
          .orElse(null);
      Relation relation = relationMap.get(pt);
      if (relation != null) {
        Atom atom = new Atom(integerValue.getLabel());
        atom.setLocatedIn(relation);
        name2atom.put(atom.getText(), atom);
        relation.addAtomWithTuple(atom);
      } else
        System.err.println("Relation not found for " + relName);
      return super.visitIntegerValue(integerValue);
    }

    @Override
    public Object visitBooleanValue(BooleanValue booleanValue) {
      String relName = "EBoolean";
      PrimitiveType pt = (PrimitiveType) relationMap.entrySet().stream()
          .filter(e -> e.getValue().getName().equals(relName)).map(Map.Entry::getKey).findFirst()
          .orElse(null);
      Relation relation = relationMap.get(pt);
      if (relation != null) {
        Atom atom = new Atom(booleanValue.getLabel());
        atom.setLocatedIn(relation);
        name2atom.put(atom.getText(), atom);
        relation.addAtomWithTuple(atom);
      } else
        System.err.println("Relation not found for " + relName);
      return super.visitBooleanValue(booleanValue);
    }

    @Override
    public Object visitRealValue(RealValue realValue) {
      String relName = "EBigDecimal";
      PrimitiveType pt = (PrimitiveType) relationMap.entrySet().stream()
          .filter(e -> e.getValue().getName().equals(relName)).map(Map.Entry::getKey).findFirst()
          .orElse(null);
      Relation relation = relationMap.get(pt);
      if (relation != null) {
        Atom atom = new Atom(realValue.getLabel());
        atom.setLocatedIn(relation);
        name2atom.put(atom.getText(), atom);
        relation.addAtomWithTuple(atom);
      } else
        System.err.println("Relation not found for " + relName);
      return super.visitRealValue(realValue);
    }

    @Override
    public Object visitObject(Object object) {
      Class classifier = object.getClassifier();

      Relation relation = relationMap.get(classifier);
      if (relation != null) {
        Atom atom = new Atom(getAtomName(object));
        atom.setLocatedIn(relation);
        name2atom.put(atom.getText(), atom);
        relation.addAtomWithTuple(atom);
      } else
        System.err.println("Relation not found for " + classifier.getFullSegment());
      return super.visitObject(object);
    }
  }

  private class TupleCollector extends BaseVisitorImpl<Object> {

    TupleCollector() {}

    @Override
    public Object visitSlot(Slot slot) {
      StructuralFeature key = slot.getDefiningFeature();

      Relation rel = relationMap.get(key);

      String domainAtom = getAtomName(slot.getOwner());

      List<Element<?>> elements = new ArrayList<>();

      if (key instanceof Reference) {
        elements.addAll(slot.getOwnedElements(Object.class));
        elements.addAll(slot.getOwnedElements(ObjectValue.class));

        List<String> rangeAtoms =
            elements.stream().map(e -> getAtomName(e)).collect(Collectors.toList());

        rangeAtoms.addAll(slot.getOwnedElements(BooleanValue.class).stream().map(Element::getLabel)
            .collect(Collectors.toList()));

        for (String rangeAtom : rangeAtoms) {
          rel.addAtomWithTuple(name2atom.get(domainAtom), name2atom.get(rangeAtom));
        }

      } else if (key instanceof Attribute) {
        elements.addAll(slot.getOwnedElements(StringValue.class));
        elements.addAll(slot.getOwnedElements(IntegerValue.class).stream()
            .filter(e -> !e.getLabel().equals("0")).collect(Collectors.toList()));
        elements.addAll(slot.getOwnedElements(BooleanValue.class));
        elements.addAll(slot.getOwnedElements(EnumValue.class));
        elements.addAll(slot.getOwnedElements(RealValue.class));
        List<String> rangeAtoms =
            elements.stream().map(Element::getLabel).collect(Collectors.toList());
        for (String rangeAtom : rangeAtoms) {
          rel.addAtomWithTuple(name2atom.get(domainAtom), name2atom.get(rangeAtom));
        }
      }
      return super.visitSlot(slot);
    }
  }

  @Override
  protected void doubleClickedOn(Atom obj) {

  }

}
