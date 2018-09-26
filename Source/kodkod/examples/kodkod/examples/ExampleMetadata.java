package kodkod.examples;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ExampleMetadata {
    // example name
    String Name() default "";

    // example note
    String Note() default "";

    // "check" or "run"
    boolean IsCheck() default false;

    // partial models
    boolean PartialModel() default false;

    // decidable fragments, satisfiability with finite extension
    // TODO

    // number of binary, ternary, and n-ary relations
    int BinaryRelations() default 0;
    int TernaryRelations() default 0;
    int NaryRelations() default 0;

    // number of hierarchical types
    int HierarchicalTypes() default 0;

    // number of nested relational joins
    int NestedRelationalJoins() default 0;

    // number of transitive closure
    int TransitiveClosure() default 0;

    // number of nested quantifiers
    int NestedQuantifiers() default 0;

    // set cardinality
    int SetCardinality() default 0;

    // number of additions and subtractions
    int Additions() default 0;
    int Subtractions() default 0;

    // number of comparison operators
    int Comparison() default 0;

    // number of ordered relations
    int OrderedRelations() default 0;

    // number of constraints
    int Constraints() default 0;
}