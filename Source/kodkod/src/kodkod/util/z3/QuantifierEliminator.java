package kodkod.util.z3;

import com.microsoft.z3.Expr;
import kodkod.ast.Variable;

import java.util.*;

/**
 * Created by harun on 7/16/18.
 */
public class QuantifierEliminator {

    public static Set<Map<Variable, Expr>> getQuantifiers(Map<Object, Expr> objectExprMap, UpperBoundFinder upperBoundFinder, Variable... variables) {
        return get(objectExprMap, upperBoundFinder, 0, variables);
    }

    private static Set<Map<Variable, Expr>> get(Map<Object, Expr> objectExprMap, UpperBoundFinder upperBoundFinder, int index, Variable... variables) {
        if (index == variables.length) {
            Set<Map<Variable, Expr>> set = new HashSet<>();
            set.add(new HashMap<>());
            return set;
        }

        Set<Map<Variable, Expr>> set = get(objectExprMap, upperBoundFinder, index + 1, variables);

        Set<Map<Variable, Expr>> newSet = new HashSet<>();

        set.forEach(map -> {
            variables[index].accept(upperBoundFinder).forEach(tuple -> {
                Map<Variable, Expr> newMAp = new HashMap<>(map);
                newMAp.put(variables[index], objectExprMap.get(tuple.atom(0)));
                newSet.add(newMAp);
            });
        });

        return newSet;
    }

}
