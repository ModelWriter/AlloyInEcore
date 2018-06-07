package eu.modelwriter.core.alloyinecore.ui.editor.instance.visualization.model;

import java.util.ArrayList;

public class Tuple {
  private String text;
  private ArrayList<Atom> atoms;
  private int arity;
  private boolean inferred;
  private boolean witness;
  private Relation relation;
  private boolean forcedAttribute;

  public Tuple() {
    this.atoms = new ArrayList<Atom>();
    this.arity = 0;
    this.inferred = false;
  }

  public Tuple(String text) {
    this.text = text;
    this.atoms = new ArrayList<Atom>();
    this.arity = 0;
    this.inferred = false;
  }

  public boolean isInferred() { // is added
    return inferred;
  }

  public void setInferred(boolean inferred) { // is added
    this.inferred = inferred;
  }

  public boolean isWitness() {
    return witness;
  }

  public void setWitness(boolean witness) {
    this.witness = witness;
  }

  public void addAtom(Atom newAtom) {
    this.atoms.add(newAtom);
    this.arity++;
  }

  public boolean contains(Atom atom) {
    for (Atom a : this.atoms) {
      if (a.getText().equals(atom.getText())) {
        return true;
      }
    }
    return false;
  }

  public int getArity() {
    return this.arity;
  }

  public Atom getAtom(int index) {
    return this.atoms.get(index);
  }

  public int getAtomCount() {
    return this.atoms.size();
  }

  public ArrayList<Atom> getAtoms() {
    return this.atoms;
  }

  public String getText() {
    return this.text;
  }

  @Override
  public String toString() {
    String as = "";
    for (Atom atom : this.atoms) {
      as += atom.getText() + " ";
    }
    return "(" + as + ")";
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null)
      return false;
    if (obj instanceof Tuple) {
      Tuple t = (Tuple) obj;
      return getAtoms().equals(t.getAtoms());
    }

    return false;
  }

  public Tuple reverse() {
    Tuple t = new Tuple();
    for (int i = getArity(); i > 0; i--) {
      t.addAtom(getAtom(i - 1));
    }
    return t;
  }

  public void setRelation(Relation relation) {
    this.relation = relation;
  }

  public Relation getRelation() {
    return relation;
  }

  public void setForcedAttribute(boolean b) {
    this.forcedAttribute = b;
  }

  public boolean isForcedAttribute() {
    return forcedAttribute;
  }
}
