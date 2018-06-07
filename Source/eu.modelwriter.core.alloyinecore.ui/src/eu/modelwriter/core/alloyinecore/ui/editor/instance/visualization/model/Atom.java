package eu.modelwriter.core.alloyinecore.ui.editor.instance.visualization.model;

public class Atom {
  private final String text;
  private Relation locatedIn;
  private boolean inferred;
  private boolean witness;
  private boolean hidden;
  private boolean forcedAttribute;

  public Atom(final String text) {
    this.text = text;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (obj == this) {
      return true;
    }

    return this.getText().equals(((Atom) obj).getText());
  }

  public String getText() {
    return this.text;
  }

  public Relation getLocatedIn() {
    return this.locatedIn;
  }

  public void setLocatedIn(final Relation locatedIn) {
    this.locatedIn = locatedIn;
  }

  public void setInferred(boolean inferred) {
    this.inferred = inferred;
  }

  public boolean isInferred() {
    return inferred;
  }

  public void setWitness(boolean witness) {
    this.witness = witness;
  }

  public boolean isWitness() {
    return witness;
  }

  public void setHidden(boolean hidden) {
    this.hidden = hidden;
  }

  public boolean isHidden() {
    return hidden;
  }

  public void setForcedAttribute(boolean b) {
    this.forcedAttribute = b;
  }

  public boolean isForcedAttribute() {
    return forcedAttribute;
  }
}
