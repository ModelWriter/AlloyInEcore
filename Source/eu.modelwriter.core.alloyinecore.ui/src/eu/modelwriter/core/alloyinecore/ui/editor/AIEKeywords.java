package eu.modelwriter.core.alloyinecore.ui.editor;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public interface AIEKeywords {

  public static final String[] KEYWORDS =
      new String[] {"package", "class", "import", "abstract", "interface", "attribute", "operation",
          "enum", "annotation", "datatype", "reference", "literal", "property", "throws"};

  public static final String[] PRIMITIVES =
      new String[] {"Boolean", "Integer", "String", "Real", "UnlimitedNatural"};

  public static final String[] AIE = new String[] {"module", "body", "requires", "precondition",
      "ensures", "postcondition", "invariant", "ghost", "model", "initial", "derivation", "no",
      "lone", "some", "one", "not", "transitive", "reflexive", "irreflexive", "symmetric",
      "asymmetric", "antisymmetric", "total", "functional", "surjective", "injective", "bijective",
      "complete", "bijection", "preorder", "equivalence", "partialorder", "totalorder", "in",
      "acyclic", "ord", "function", "and", "or", "if", "iff", "implies", "all", "let", "true",
      "false", "iden", "none", "univ", "ints", "plus", "minus", "then", "else", "modulo", "div",
      "mul", "sum", "disj", "set", "reason"};

  public static final String[] VISIBILITY = new String[] {"public", "private", "protected"};

  public static final String[] QUALIFIERS = new String[] {"static", "extends", "super", "readonly",
      "!readonly", "composes", "!composes", "acyclic", "transitive", "reflexive", "irreflexive",
      "symmetric", "asymmetric", "antisymmetric", "total", "functional", "surjective", "injective",
      "bijective", "complete", "bijection", "preorder", "equivalence", "partialorder", "totalorder",
      "nullable", "!nullable", "transient", "!transient", "volatile", "!volatile", "resolve",
      "!resolve", "ordered", "!ordered", "callable", "!callable", "unsettable", "!unsettable",
      "derived", "!derived", "unique", "!unique", "id", "!id", "serializable", "!serializable"};

  public static final Set<String> ALL_BUT_AIE = AIEKeywords.getAll(AIEKeywords.KEYWORDS,
      AIEKeywords.VISIBILITY, AIEKeywords.QUALIFIERS, AIEKeywords.PRIMITIVES);

  public static Set<String> getAll(final String[]... arrays) {
    final Set<String> hashSet = new HashSet<>();
    for (int i = 0; i < arrays.length; i++) {
      hashSet.addAll(Arrays.asList(arrays[i]));
    }
    return hashSet;
  }
}
