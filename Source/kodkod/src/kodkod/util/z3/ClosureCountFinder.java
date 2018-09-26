package kodkod.util.z3;

import kodkod.instance.Tuple;
import kodkod.instance.TupleFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by harun on 7/16/18.
 */
public class ClosureCountFinder {

    public static int find(TupleFactory factory, Set<Tuple> bounds) {
        int count = 0;

        Set<Tuple> newOnes = new HashSet<>(bounds);
        Set<Tuple> allTuples = new HashSet<>();
        Set<Tuple> current = new HashSet<>();

        do {
            count++;

            allTuples.addAll(newOnes);

            for (Tuple t1 : newOnes) {
                for (Tuple t2 : allTuples) {
                    current.add(factory.tuple(t1.atom(1), t2.atom(0)));
                }
            }

            newOnes = new HashSet<>(current);
            current.clear();

        } while (!allTuples.containsAll(newOnes));

        return count;
    }

}
