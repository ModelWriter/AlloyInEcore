package eu.modelwriter.core.alloyinecore.ui.editor.instance.visualization;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.prefs.Preferences;
import java.util.stream.Collectors;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import edu.mit.csail.sdg.alloy4.Util;
import edu.mit.csail.sdg.alloy4.Util.BooleanPref;
import eu.modelwriter.core.alloyinecore.ui.editor.instance.visualization.model.Atom;
import eu.modelwriter.core.alloyinecore.ui.editor.instance.visualization.model.Relation;
import eu.modelwriter.core.alloyinecore.ui.editor.instance.visualization.model.Tuple;
import eu.modelwriter.core.alloyinecore.ui.editor.instance.visualization.model.Universe;

public class Test {
  private static final String CodeSource = null;
  public static JPanel panel;
  public static JScrollPane scroll;
  public static Universe universe;

  public static File file;
  public static File currentOpenReqInstance;
  public static File currentOpenReqXML;

  static List<String> requirementNames = new ArrayList<>();

  public static final String moduleRequirementsModel =
      "module RequirementsModel open util/relation sig Requirement { requires: set Requirement, refines: set Requirement, contains: set Requirement, partially_refines: set Requirement, conflicts: set Requirement, equals: set Requirement } fact functional_facts { no requires & refines no requires & contains no requires & partially_refines no requires & conflicts no requires & equals no refines & contains no refines & partially_refines no refines & conflicts no refines & equals no contains & partially_refines no contains & conflicts no contains & equals no partially_refines & conflicts no partially_refines & equals no conflicts & equals no requires & ~refines no requires & ~contains no requires & ~partially_refines no requires & ~conflicts no requires & ~equals no refines & ~contains no refines & ~partially_refines no refines & ~conflicts no refines & ~equals no contains & ~partially_refines no contains & ~conflicts no contains & ~equals no partially_refines & ~conflicts no partially_refines & ~equals no conflicts & ~equals } fact relation_properties { irreflexive[requires] antisymmetric[requires] irreflexive[Requirement<:refines] antisymmetric[Requirement<:refines] irreflexive[contains] antisymmetric[contains] irreflexive[partially_refines] antisymmetric[partially_refines] transitive[partially_refines] irreflexive[conflicts] symmetric[equals] } -- Reason@Requirement.equals fact { transitive[equals] } -- Reason@Requirement.contains fact{ transitive[contains] } -- Reason@Requirement.requires fact{ transitive[requires] } -- Reason@Requirement.refines fact{ transitive[Requirement<:refines] } -- Reason@Requirement.partially_refines fact{ transitive[partially_refines] } fact equals_facts { all a,b: Requirement { b in a.equals => a.conflicts = b.conflicts b in a.equals => a.requires = b.requires b in a.equals => a.equals = b.equals b in a.equals => a.refines = b.refines b in a.equals => a.partially_refines = b.partially_refines b in a.equals => a.contains = b.contains b in a.equals => a.~conflicts = b.~conflicts b in a.equals => a.~requires = b.~requires b in a.equals => a.~equals = b.~equals b in a.equals => a.~refines = b.~refines b in a.equals => a.~partially_refines = b.~partially_refines b in a.equals => a.~contains = b.~contains } } -- Reason@Requirement.requires fact infer_requires_facts { all a,b,c: Requirement { b in a.requires && c in b.refines && c !in a.contains => c in a.requires b in a.refines && c in b.requires && c !in a.contains => c in a.requires b in a.requires && c in b.contains && c !in a.contains => c in a.requires b in a.contains && c in b.requires && c !in a.contains => c in a.requires } } -- Reason@Requirement.partially_refines fact infer_partially_refines_facts { all a,b,c: Requirement { b in a.contains && c in b.refines => c in a.partially_refines b in a.refines && c in b.contains => c in a.partially_refines b in a.partially_refines && c in b.contains => c in a.partially_refines b in a.contains && c in b.partially_refines => c in a.partially_refines b in a.refines && c in b.partially_refines => c in a.partially_refines b in a.partially_refines && c in b.refines => c in a.partially_refines } } -- Reason@Requirement.conflicts fact infer_conflicts_facts { all a,b,c: Requirement { b in a.(requires + refines + contains) && c in b.conflicts => c in a.conflicts } symmetric[conflicts] } pred show {} run show for 3";
  public static final String moduleRelation =
      "module util/relation /* * Utilities for some common operations and constraints * on binary relations. The keyword 'univ' represents the * top-level type, which all other types implicitly extend. * Therefore, all the functions and predicates in this model * may be applied to binary relations of any type. * * author: Greg Dennis */ /** returns the domain of a binary relation */ fun dom [r: univ->univ] : set (r.univ) { r.univ } /** returns the range of a binary relation */ fun ran [r: univ->univ] : set (univ.r) { univ.r } /** r is total over the domain s */ pred total [r: univ->univ, s: set univ] { all x: s | some x.r } /** r is a partial function over the domain s */ pred functional [r: univ->univ, s: set univ] { all x: s | lone x.r } /** r is a total function over the domain s */ pred function [r: univ->univ, s: set univ] { all x: s | one x.r } /** r is surjective over the codomain s */ pred surjective [r: univ->univ, s: set univ] { all x: s | some r.x } /** r is injective */ pred injective [r: univ->univ, s: set univ] { all x: s | lone r.x } /** r is bijective over the codomain s */ pred bijective[r: univ->univ, s: set univ] { all x: s | one r.x } /** r is a bijection over the domain d and the codomain c */ pred bijection[r: univ->univ, d, c: set univ] { function[r, d] && bijective[r, c] } /** r is reflexive over the set s */ pred reflexive [r: univ -> univ, s: set univ] {s<:iden in r} /** r is irreflexive */ pred irreflexive [r: univ -> univ] {no iden & r} /** r is symmetric */ pred symmetric [r: univ -> univ] {~r in r} /** r is anti-symmetric */ pred antisymmetric [r: univ -> univ] {~r & r in iden} /** r is transitive */ pred transitive [r: univ -> univ] {r.r in r} /** r is acyclic over the set s */ pred acyclic[r: univ->univ, s: set univ] { all x: s | x !in x.^r } /** r is complete over the set s */ pred complete[r: univ->univ, s: univ] { all x,y:s | (x!=y => x->y in (r + ~r)) } /** r is a preorder (or a quasi-order) over the set s */ pred preorder [r: univ -> univ, s: set univ] { reflexive[r, s] transitive[r] } /** r is an equivalence relation over the set s */ pred equivalence [r: univ->univ, s: set univ] { preorder[r, s] symmetric[r] } /** r is a partial order over the set s */ pred partialOrder [r: univ -> univ, s: set univ] { preorder[r, s] antisymmetric[r] } /** r is a total order over the set s */ pred totalOrder [r: univ -> univ, s: set univ] { partialOrder[r, s] complete[r, s] }";
  public static final String moduleInteger =
      "module util/integer /* * A collection of utility functions for using Integers in Alloy. * Note that integer overflows are silently truncated to the current bitwidth * using the 2's complement arithmetic, unless the \"forbid overfows\" option is * turned on, in which case only models that don't have any overflows are * analyzed. */ fun add [n1, n2: Int] : Int { this/plus[n1, n2] } fun plus [n1, n2: Int] : Int { n1 fun/add n2 } fun sub [n1, n2: Int] : Int { this/minus[n1, n2] } fun minus [n1, n2: Int] : Int { n1 fun/sub n2 } fun mul [n1, n2: Int] : Int { n1 fun/mul n2 } /** * Performs the division with \"round to zero\" semantics, except the following 3 cases * 1) if a is 0, then it returns 0 * 2) else if b is 0, then it returns 1 if a is negative and -1 if a is positive * 3) else if a is the smallest negative integer, and b is -1, then it returns a */ fun div [n1, n2: Int] : Int { n1 fun/div n2 } /** answer is defined to be the unique integer that satisfies \"a = ((a/b)*b) + remainder\" */ fun rem [n1, n2: Int] : Int { n1 fun/rem n2 } /** negate */ fun negate [n: Int] : Int { 0 fun/sub n } /** equal to */ pred eq [n1, n2: Int] { int[n1] = int[n2] } /** greater than */ pred gt [n1, n2: Int] { n1 > n2 } /** less then */ pred lt [n1, n2: Int] { n1 < n2 } /** greater than or equal */ pred gte [n1, n2: Int] { n1 >= n2 } /** less than or equal */ pred lte [n1, n2: Int] { n1 <= n2 } /** integer is zero */ pred zero [n: Int] { n = 0 } /** positive */ pred pos [n: Int] { n > 0 } /** negative */ pred neg [n: Int] { n < 0 } /** non-positive */ pred nonpos [n: Int] { n <= 0 } /** non-negative */ pred nonneg [n: Int] { n >= 0 } /** signum (aka sign or sgn) */ fun signum [n: Int] : Int { n<0 => (0 fun/sub 1) else (n>0 => 1 else 0) } /** * returns the ith element (zero-based) from the set s * in the ordering of 'next', which is a linear ordering * relation like that provided by util/ordering */ fun int2elem[i: Int, next: univ->univ, s: set univ] : lone s { {e: s | #^next.e = int i } } /** * returns the index of the element (zero-based) in the * ordering of next, which is a linear ordering relation * like that provided by util/ordering */ fun elem2int[e: univ, next: univ->univ] : lone Int { Int[#^next.e] } /** returns the largest integer in the current bitwidth */ fun max:one Int { fun/max } /** returns the smallest integer in the current bitwidth */ fun min:one Int { fun/min } /** maps each integer (except max) to the integer after it */ fun next:Int->Int { fun/next } /** maps each integer (except min) to the integer before it */ fun prev:Int->Int { ~next } /** given a set of integers, return the largest element */ fun max [es: set Int]: lone Int { es - es.^prev } /** given a set of integers, return the smallest element */ fun min [es: set Int]: lone Int { es - es.^next } /** given an integer, return all integers prior to it */ fun prevs [e: Int]: set Int { e.^prev } /** given an integer, return all integers following it */ fun nexts [e: Int]: set Int { e.^next } /** returns the larger of the two integers */ fun larger [e1, e2: Int]: Int { let a=int[e1], b=int[e2] | (a<b => b else a) } /** returns the smaller of the two integers */ fun smaller [e1, e2: Int]: Int { let a=int[e1], b=int[e2] | (a<b => a else b) }";

  private enum Verbosity {
    /** Level 0. */
    DEFAULT("0", "low"),
    /** Level 1. */
    VERBOSE("1", "medium"),
    /** Level 2. */
    DEBUG("2", "high"),
    /** Level 3. */
    FULLDEBUG("3", "debug only");
    /** Returns true if it is greater than or equal to "other". */
    public boolean geq(Verbosity other) {
      return ordinal() >= other.ordinal();
    }

    /**
     * This is a unique String for this value; it should be kept consistent in future versions.
     */
    private final String id;
    /** This is the label that the toString() method will return. */
    private final String label;

    /** Constructs a new Verbosity value with the given id and label. */
    private Verbosity(String id, String label) {
      this.id = id;
      this.label = label;
    }

    /**
     * Given an id, return the enum value corresponding to it (if there's no match, then return
     * DEFAULT).
     */
    private static Verbosity parse(String id) {
      for (Verbosity vb : values())
        if (vb.id.equals(id))
          return vb;
      return DEFAULT;
    }

    /** Returns the human-readable label for this enum value. */
    @Override
    public final String toString() {
      return label;
    }

    /** Saves this value into the Java preference object. */
    private void set() {
      Preferences.userNodeForPackage(Util.class).put("Verbosity", id);
    }

    /**
     * Reads the current value of the Java preference object (if it's not set, then return DEFAULT).
     */
    private static Verbosity get() {
      return parse(Preferences.userNodeForPackage(Util.class).get("Verbosity", ""));
    }
  };

  static JFrame frame;
  static JCheckBoxMenuItem menuItemAutoReason;

  public static void main(final String[] args) {

    BooleanPref ImplicitThis = new BooleanPref("ImplicitThis");

    frame = new JFrame("");

    menuItemAutoReason = new JCheckBoxMenuItem("Auto-Reason");

    BorderLayout experimentLayout = new BorderLayout();

    frame.setLayout(experimentLayout);

    panel = new JPanel();
    scroll = new JScrollPane(panel);

    frame.getContentPane().add(panel, BorderLayout.EAST);

    Runnable runnable = new Runnable() {

      @Override
      public void run() {
        // TODO Auto-generated method stub
        try {
          frame.getContentPane().remove(scroll);

          universe = modifyUniverse(universe, "");

          // createXMLFile(universe);

          // currentOpenReqXML = new File(file.getPath() + "/" +
          // currentOpenReqInstance.getName() + ".xml");

          panel = GraphMaker.produceGraph(universe);

          scroll = new JScrollPane(panel);
          frame.getContentPane().add(scroll);

          frame.validate();

          // evaluator.compute(currentOpenReqXML);

        } catch (Exception e1) {
          e1.printStackTrace();
        }
      }
    };

    frame.setVisible(true);
  }

  public static Universe modifyUniverse(Universe univ, String input) throws Exception {
    boolean autoReason = false;
    if (univ == null) {
      univ = createRequirementModelInstance("");
    }

    String command = "";

    for (String line : input.split("\n")) {
      if (line.contains("UNSATISFIABLE while") || line.contains("is no such")) { // UNSATISFIABLE
                                                                                 // while... ||
                                                                                 // There is no
                                                                                 // such...
        JOptionPane.showMessageDialog(frame, line);
      } else if (line.replace(" ", "").replace("\t", "").contains("/auto-reason")) { // /auto-reason
        String s = line.replace("/auto-reason", "").replace(" ", "").replace("\t", "");
        autoReason = s.equals("true") || s.equals("false") ? s.equals("true") : autoReason;
        menuItemAutoReason.setSelected(autoReason);
      } else if (line.replace(" ", "").replace("\t", "").equals("/reason")) { // /reason
        command += univ
            .getRelations().stream().filter(ex -> ex.getArity() == 1).map(ex -> ex.getTuples()
                .stream().map(f -> f.getAtom(0).getText() + "\n").collect(Collectors.joining("")))
            .collect(Collectors.joining(""));
        command += univ.getRelations().stream().filter(ex -> ex.getArity() == 2)
            .map(ex -> ex.getTuples().stream().filter(f -> !f.isInferred())
                .map(f -> ex.getName() + "(" + f.getAtom(0).getText() + ", "
                    + f.getAtom(1).getText() + ")" + "\n")
                .collect(Collectors.joining("")))
            .collect(Collectors.joining(""));
        univ = createRequirementModelInstance(command);
      } else if (line.replace(" ", "").replace("\t", "").equals("/clear")) { // /clear
        univ = createRequirementModelInstance("");
      } else if (line.replace(" ", "").replace("\t", "").equals("/clear-reasoned")) { // /clear-reasoned
        for (Relation rel : univ.getRelations()) {
          Iterator<Tuple> iter = rel.getTuples().iterator();

          while (iter.hasNext()) {
            Tuple t = iter.next();
            if (t.isInferred())
              iter.remove();
          }
        }
      } else if (line.contains("/delete")) { // /delete x
        String s = line.replace("/delete", "").replace(" ", "").replace("\t", "");

        if (s.contains("(")) {
          if (!s.contains("(") || !s.contains(",")) {
            JOptionPane.showMessageDialog(frame, "Parsing error!\n" + line);
          } else {
            String relationName = s.substring(0, s.indexOf('('));
            String req1 = s.substring(s.indexOf('(') + 1, s.indexOf(','));
            String req2 = s.substring(s.indexOf(",") + 1, s.indexOf(')'));

            if (relationName.length() == 0 || req1.length() == 0 || req2.length() == 0) {
              JOptionPane.showMessageDialog(frame, "Parsing error!\n" + line);
            } else {
              Relation rel = null;

              if (relationName.equals("equals"))
                rel = univ.getRelations().get(6);
              if (relationName.equals("conflicts"))
                rel = univ.getRelations().get(5);
              if (relationName.equals("requires"))
                rel = univ.getRelations().get(1);
              if (relationName.equals("refines"))
                rel = univ.getRelations().get(2);
              if (relationName.equals("contains"))
                rel = univ.getRelations().get(3);
              if (relationName.equals("partially_refines"))
                rel = univ.getRelations().get(4);

              if (rel == null) {
                JOptionPane.showMessageDialog(frame, "Unknown trace type!\n" + relationName);
              } else {
                Iterator<Tuple> iter = rel.getTuples().iterator();

                while (iter.hasNext()) {
                  Tuple t = iter.next();
                  if (t.getAtoms().get(0).getText().equals(req1)
                      && t.getAtoms().get(1).getText().equals(req2))
                    iter.remove();
                }
              }
            }
          }
        } else { // x
          for (Relation rel : univ.getRelations()) {

            if (rel.getArity() == 1) {
              Iterator<Tuple> iter = rel.getTuples().iterator();

              while (iter.hasNext()) {
                Tuple t = iter.next();
                if (t.getAtoms().get(0).getText().equals(s))
                  iter.remove();
              }
            } else if (rel.getArity() == 2) {
              Iterator<Tuple> iter = rel.getTuples().iterator();

              while (iter.hasNext()) {
                Tuple t = iter.next();
                if (t.getAtoms().get(0).getText().equals(s)
                    || t.getAtoms().get(1).getText().equals(s))
                  iter.remove();
              }
            }
          }
        }
      } else if (autoReason) {
        command += line + "\n";
      } else {
        String s = line.replace(" ", "").replace("\t", "");

        if (s.contains("(")) {
          if (!s.contains("(") || !s.contains(",")) {
            JOptionPane.showMessageDialog(frame, "Parsing error!\n" + line);
          } else {
            String relationName = s.substring(0, s.indexOf('('));
            String req1 = s.substring(s.indexOf('(') + 1, s.indexOf(','));
            String req2 = s.substring(s.indexOf(",") + 1, s.indexOf(')'));

            if (relationName.length() == 0 || req1.length() == 0 || req2.length() == 0) {
              JOptionPane.showMessageDialog(frame, "Parsing error!\n" + line);
            } else {
              Relation rel = null;

              if (relationName.equals("equals"))
                rel = univ.getRelations().get(6);
              if (relationName.equals("conflicts"))
                rel = univ.getRelations().get(5);
              if (relationName.equals("requires"))
                rel = univ.getRelations().get(1);
              if (relationName.equals("refines"))
                rel = univ.getRelations().get(2);
              if (relationName.equals("contains"))
                rel = univ.getRelations().get(3);
              if (relationName.equals("partially_refines"))
                rel = univ.getRelations().get(4);

              if (rel == null) {
                JOptionPane.showMessageDialog(frame, "Unknown trace type!\n" + relationName);
              } else {
                Optional<Tuple> ot = rel.getTuples().stream().filter(
                    e -> e.getAtom(0).getText().equals(req1) && e.getAtom(1).getText().equals(req2))
                    .findFirst();
                if (ot.isPresent()) {
                  ot.get().setInferred(s.contains("+"));
                } else {
                  Atom atom1;
                  Optional<Atom> oa1 = univ.getRelations().get(0).getTuples().stream()
                      .filter(e -> e.getAtom(0).getText().equals(req1)).map(e -> e.getAtom(0))
                      .findFirst();
                  if (oa1.isPresent()) {
                    atom1 = oa1.get();
                  } else {
                    atom1 = new Atom(req1);
                    univ.getRelations().get(0).addAtomWithTuple(atom1);
                  }

                  Atom atom2;
                  Optional<Atom> oa2 = univ.getRelations().get(0).getTuples().stream()
                      .filter(e -> e.getAtom(0).getText().equals(req2)).map(e -> e.getAtom(0))
                      .findFirst();
                  if (oa2.isPresent()) {
                    atom2 = oa2.get();
                  } else {
                    atom2 = new Atom(req2);
                    univ.getRelations().get(0).addAtomWithTuple(atom2);
                  }

                  rel.addAtomWithTuple(atom1, atom2);
                  rel.getTuples().get(rel.getTuples().size() - 1).setInferred(s.contains("+"));
                }
              }
            }
          }
        } else {
          if (!s.isEmpty()) {
            Optional<Atom> oa1 = univ.getRelations().get(0).getTuples().stream()
                .filter(e -> e.getAtom(0).getText().equals(s)).map(e -> e.getAtom(0)).findFirst();
            if (!oa1.isPresent()) {
              univ.getRelations().get(0).addAtomWithTuple(new Atom(s));
            }
          }
        }
      }
    }

    if (autoReason) {
      String cmd = "";
      cmd += univ
          .getRelations().stream().filter(ex -> ex.getArity() == 1).map(ex -> ex.getTuples()
              .stream().map(f -> f.getAtom(0).getText() + "\n").collect(Collectors.joining("")))
          .collect(Collectors.joining(""));
      cmd +=
          univ.getRelations().stream().filter(ex -> ex.getArity() == 2)
              .map(ex -> ex.getTuples().stream().filter(f -> !f.isInferred())
                  .map(f -> ex.getName() + "(" + f.getAtom(0).getText() + ", "
                      + f.getAtom(1).getText() + ")" + "\n")
                  .collect(Collectors.joining("")))
              .collect(Collectors.joining(""));
      cmd += command;
      univ = createRequirementModelInstance(cmd);
    }

    return univ;
  }

  public static void showUnsatCore(String title, String command) {
    boolean autoReason = false;
    boolean temp = autoReason;
    autoReason = false;

    Universe univ = null;
    try {
      univ = modifyUniverse(univ, command);
    } catch (Exception e) {
      e.printStackTrace();
    }


    autoReason = temp;

    JFrame coreFrame = new JFrame();
    JPanel corePanel;
    JScrollPane coreScroll;

    try {
      coreFrame.setTitle(title);
      coreFrame.setSize(700, 500);

      corePanel = GraphMaker.produceGraph(univ);
      corePanel.setSize(700, 500);

      coreScroll = new JScrollPane(corePanel);
      coreFrame.getContentPane().add(coreScroll);

      coreFrame.validate();

      coreFrame.setVisible(true);

    } catch (Exception e1) {
      e1.printStackTrace();
    }
  }

  public static Universe createRequirementModelInstance(String command) {
    command += "quit\n";

    requirementNames.clear();

    Universe universe = new Universe();

    Relation Requirement = new Relation("Requirement");

    Relation requires = new Relation("requires");
    Relation refines = new Relation("refines");
    Relation contains = new Relation("contains");
    Relation partially_refines = new Relation("partially_refines");
    Relation conflicts = new Relation("conflicts");
    Relation equals = new Relation("equals");

    requires.setParent(Requirement);
    refines.setParent(Requirement);
    contains.setParent(Requirement);
    partially_refines.setParent(Requirement);
    conflicts.setParent(Requirement);
    equals.setParent(Requirement);

    requires.addTypes(Requirement, Requirement);
    refines.addTypes(Requirement, Requirement);
    partially_refines.addTypes(Requirement, Requirement);
    contains.addTypes(Requirement, Requirement);
    conflicts.addTypes(Requirement, Requirement);
    equals.addTypes(Requirement, Requirement);

    BufferedReader br = null;
    String strLine = "";
    try {
      Process p = new ProcessBuilder("./traceability").start();

      OutputStream procIn = p.getOutputStream();
      procIn.write(command.getBytes());
      procIn.close();

      br = new BufferedReader(new InputStreamReader(p.getInputStream()));
      if (p.waitFor() != 0) {
        JOptionPane.showMessageDialog(frame, "Parsing error!");
        return null;
      }

      String lastUnsat = "";

      while ((strLine = br.readLine()) != null) {

        if (strLine.contains("UNSATISFIABLE while") || strLine.contains("is no such")) {
          JOptionPane.showMessageDialog(frame, strLine);
          lastUnsat = strLine;
          continue;
        }
        if (strLine.contains("==")) {
          String unsatCommand = "";
          String newLine;
          while (!(newLine = br.readLine()).contains("==")) {
            unsatCommand += newLine + "\n";
          }
          showUnsatCore(lastUnsat, unsatCommand);
          continue;
        }
        if (!strLine.contains("("))
          continue;
        String relationName = strLine.substring(0, strLine.indexOf('('));
        String req1 = strLine.substring(strLine.indexOf('(') + 1, strLine.indexOf(','));
        String req2 = strLine.substring(strLine.indexOf(" ") + 1, strLine.indexOf(')'));
        boolean isInferred = strLine.endsWith("+") ? true : false;

        if (!requirementNames.contains(req1)) {
          Requirement.addAtomWithTuple(new Atom(req1));
          requirementNames.add(req1);
        }

        if (!requirementNames.contains(req2)) {
          Requirement.addAtomWithTuple(new Atom(req2));
          requirementNames.add(req2);
        }

        for (int i = 0; i < Requirement.getTupleCount(); i++) {
          if (Requirement.getTuple(i).getAtom(0).getText().equals(req1)) {
            for (int j = 0; j < Requirement.getTupleCount(); j++) {
              if (Requirement.getTuple(j).getAtom(0).getText().equals(req2)) {
                switch (relationName) {
                  case "equals":
                    if (equals.getTuples().stream()
                        .anyMatch(e -> e.getAtom(0).getText().equals(req2)
                            && e.getAtom(1).getText().equals(req1)))
                      break;
                    equals.addAtomWithTuple(Requirement.getTuple(i).getAtom(0),
                        Requirement.getTuple(j).getAtom(0));
                    if (isInferred) {
                      equals.getTuple(equals.getTupleCount() - 1).setInferred(true);
                    }
                    break;
                  case "conflicts":
                    if (conflicts.getTuples().stream()
                        .anyMatch(e -> e.getAtom(0).getText().equals(req2)
                            && e.getAtom(1).getText().equals(req1)))
                      break;
                    conflicts.addAtomWithTuple(Requirement.getTuple(i).getAtom(0),
                        Requirement.getTuple(j).getAtom(0));
                    if (isInferred) {
                      conflicts.getTuple(conflicts.getTupleCount() - 1).setInferred(true);
                    }
                    break;
                  case "requires":
                    requires.addAtomWithTuple(Requirement.getTuple(i).getAtom(0),
                        Requirement.getTuple(j).getAtom(0));
                    if (isInferred) {
                      requires.getTuple(requires.getTupleCount() - 1).setInferred(true);
                    }
                    break;
                  case "refines":
                    refines.addAtomWithTuple(Requirement.getTuple(i).getAtom(0),
                        Requirement.getTuple(j).getAtom(0));
                    if (isInferred) {
                      refines.getTuple(refines.getTupleCount() - 1).setInferred(true);
                    }
                    break;
                  case "contains":
                    contains.addAtomWithTuple(Requirement.getTuple(i).getAtom(0),
                        Requirement.getTuple(j).getAtom(0));
                    if (isInferred) {
                      contains.getTuple(contains.getTupleCount() - 1).setInferred(true);
                    }
                    break;
                  case "partially_refines":
                    partially_refines.addAtomWithTuple(Requirement.getTuple(i).getAtom(0),
                        Requirement.getTuple(j).getAtom(0));
                    if (isInferred) {
                      partially_refines.getTuple(partially_refines.getTupleCount() - 1)
                          .setInferred(true);
                    }
                    break;
                }
                break;
              }
            }
            break;
          }
        }
      }

    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    universe.addRelation(Requirement);

    universe.addRelation(requires);
    universe.addRelation(refines);
    universe.addRelation(contains);
    universe.addRelation(partially_refines);
    universe.addRelation(conflicts);
    universe.addRelation(equals);

    return universe;
  }

}
