package eu.modelwriter.core.alloyinecore.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import eu.modelwriter.core.alloyinecore.interpreter.typesystem.KodKodUniverse;
import kodkod.engine.Solution;

public class SolutionHolder {

  private static Map<String, SolutionHolder> solutionMap = null;

  private Iterator<Solution> iterator;
  private KodKodUniverse universe;
  private List<Solution> solutions;
  private boolean sat;

  private int position;

  public SolutionHolder(KodKodUniverse universe, Iterator<Solution> iterator, boolean sat) {
    this.iterator = iterator;
    this.universe = universe;
    this.solutions = new ArrayList<>();
    this.sat = sat;

    position = -1;
  }

  public SolutionHolder(KodKodUniverse universe, List<Solution> solutions, boolean sat) {
    this.iterator = new ArrayList<Solution>().iterator();
    this.universe = universe;
    this.solutions = solutions;
    this.sat = sat;

    position = -1;
  }

  public boolean iterateForSat() {
    return sat;
  }

  public static Map<String, SolutionHolder> getSolutionMap() {
    if (solutionMap == null)
      solutionMap = new HashMap<>();
    return solutionMap;
  }

  public KodKodUniverse getUniverse() {
    return universe;
  }

  public Solution nextSolution() {
    position++;
    if (position == solutions.size()) {
      if (iterator.hasNext())
        solutions.add(iterator.next());
      else {
        position--;
        return null;
      }
    }
    return solutions.get(position);
  }

  public Solution previousSolution() {
    position--;
    if (position <= -1) {
      position++;
      return null;
    }
    return solutions.get(position);
  }

  public Solution currentSolution() {
    if (position == -1) {
      return null;
    }
    return solutions.get(position);
  }

}
