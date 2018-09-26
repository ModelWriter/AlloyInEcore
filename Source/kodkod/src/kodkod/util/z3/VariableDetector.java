package kodkod.util.z3;

import kodkod.ast.Node;
import kodkod.ast.Variable;
import kodkod.ast.visitor.AbstractVoidVisitor;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by harun on 7/13/18.
 */
public class VariableDetector extends AbstractVoidVisitor {
    private Set<Variable> variables = new HashSet<>();

    @Override
    protected boolean visited(Node n) {
        return false;
    }

    @Override
    public void visit(Variable variable) {
        variables.add(variable);
    }

    public Set<Variable> variables() {
        return variables;
    }
}
