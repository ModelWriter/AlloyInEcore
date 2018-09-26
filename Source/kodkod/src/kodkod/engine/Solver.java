/*
 * Kodkod -- Copyright (c) 2005-present, Emina Torlak
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package kodkod.engine;

import kodkod.ast.*;
import kodkod.engine.config.Options;
import kodkod.engine.fol2sat.*;
import kodkod.engine.satlab.*;
import kodkod.instance.*;

import java.util.*;
import java.util.stream.Collectors;


/**
 * A computational engine for solving relational satisfiability problems. 
 * Such a problem is described by a {@link kodkod.ast.Formula formula} in
 * first order relational logic; finite {@link kodkod.instance.Bounds bounds} on
 * the value of each {@link Relation relation} constrained by the formula; and
 * a set of {@link kodkod.engine.config.Options options} specifying, among other global
 * parameters, the length of bitvectors that describe the meaning of
 * {@link IntExpression integer expressions} in the given formula.  The options are
 * usually reused between invocations to the {@linkplain #solve(Formula, Bounds) solve}
 * methods, so they are specified as a part of the {@linkplain KodkodSolver solver} state.
 *
 * <p>
 * A {@link Solver} takes as input a relational problem and produces a
 * satisfying model or an {@link Instance instance} of it, if one exists.  It can also
 * produce a {@link Proof proof} of unsatisfiability for problems with no models,
 * if the {@link kodkod.engine.config.Options options} specify the use of a
 * {@linkplain SATProver proof logging SAT solver}.
 * </p>
 *
 * @specfield options: Options
 * @author Emina Torlak
 */
public final class Solver implements KodkodSolver {
	private final Options options;

	/**
	 * Constructs a new Solver with the default options.
	 * @ensures this.options' = new Options()
	 */
	public Solver() {
		this.options = new Options();
	}

	/**
	 * Constructs a new Solver with the given options.
	 * @ensures this.options' = options
	 * @throws NullPointerException  options = null
	 */
	public Solver(Options options) {
		if (options == null)
			throw new NullPointerException();
		this.options = options;
	}

	/**
	 * Returns the Options object used by this Solver
	 * to guide translation of formulas from first-order
	 * logic to cnf.
	 * @return this.options
	 */
	public Options options() {
		return options;
	}

	/**
	 * {@inheritDoc}
	 * @see kodkod.engine.KodkodSolver#free()
	 */
	public void free() {}

	/**
	 * Attempts to satisfy the given {@code formula} and {@code bounds} with respect to
	 * {@code this.options} or, optionally, prove the problem's unsatisfiability. If the method
	 * completes normally, the result is a  {@linkplain Solution solution} containing either an
	 * {@linkplain Instance instance} of the given problem or, optionally, a {@linkplain Proof proof} of
	 * its unsatisfiability. An unsatisfiability
	 * proof will be constructed iff {@code this.options.solver} specifies a {@linkplain SATProver} and
	 * {@code this.options.logTranslation > 0}.
	 *
	 * @return some sol:  {@link Solution} |
	 *           some sol.instance() =>
	 *            sol.instance() in MODELS(formula, bounds, this.options) else
	 *            UNSAT(formula, bound, this.options)
	 *
	 * @throws NullPointerException  formula = null || bounds = null
	 * @throws UnboundLeafException  the formula contains an undeclared variable or a relation not mapped by the given bounds
	 * @throws HigherOrderDeclException  the formula contains a higher order declaration that cannot
	 * be skolemized, or it can be skolemized but {@code this.options.skolemDepth} is insufficiently large
	 * @throws AbortedException  this solving task was aborted
	 * @see Options
	 * @see Solution
	 * @see Instance
	 * @see Proof
	 */
	private Proof makeProof(Set<Formula> formulaSet, Set<Map.Entry<Relation, Tuple>> tupleSet) {
	    return new Proof(null) {
            @Override
            public void minimize(ReductionStrategy strategy) {}

            @Override
            public Iterator<TranslationRecord> core() {
                Set<TranslationRecord> translationRecords = tupleSet.stream().map(relationTupleEntry -> new TranslationRecord() {

                    @Override
                    public Node node() {
                        return relationTupleEntry.getKey();
                    }

                    @Override
                    public Formula translated() {
                        return null;
                    }

                    @Override
                    public int literal() {
                        return relationTupleEntry.getKey().arity();
                    }

                    @Override
                    public Map<Variable, TupleSet> env() {
                        Map<Variable, TupleSet> map = new HashMap<>();
                        TupleFactory tf = relationTupleEntry.getValue().universe().factory();
                        for (int i = 0; i < relationTupleEntry.getKey().arity(); i++) {
                            Variable variable = Variable.nary("v" + i, relationTupleEntry.getKey().arity());
                            map.put(variable, tf.setOf(tf.tuple(relationTupleEntry.getValue().atom(i))));
                        }
                        return map;
                    }
                }).collect(Collectors.toSet());

                return translationRecords.iterator();
            }

            @Override
            public Map<Formula, Node> highLevelCore() {
                return formulaSet.stream().collect(Collectors.toMap(f -> f, f -> f));
            }
        };
    }

	public Solution solve(Formula formula, Bounds bounds) throws HigherOrderDeclException, UnboundLeafException, AbortedException {

		final long startTransl = System.currentTimeMillis();

		try {
			if (options.solver().instance() instanceof AssertionChecker) {
				if (!bounds.lowerBounds().equals(bounds.upperBounds()))
					throw new AbortedException("Bounds must be exact while using Assertion Checker.");
				AssertionChecker assertionChecker = (AssertionChecker) options.solver().instance();
				final long startSolve = System.currentTimeMillis();
				final boolean isSat = assertionChecker.solve(formula, bounds);
				final long endSolve = System.currentTimeMillis();

				final Statistics stats = new Statistics(0, 0, 0
						, 0
						, endSolve - startSolve);

				if (isSat) {
					Instance instance = new Instance(bounds.universe());
					bounds.lowerBounds().forEach(instance::add);
					return Solution.satisfiable(stats, instance);
				}
				else {
					return Solution.unsatisfiable(stats,
							makeProof(assertionChecker.getUnsatFormulaSet(), assertionChecker.getUnsatTupleSet()));
				}
			}
            else if (options.solver().instance() instanceof Z3Solver) {
                Z3Solver z3Solver = (Z3Solver) options.solver().instance();

                z3Solver.setBitSize(options.bitwidth());

                final long startSolve = System.currentTimeMillis();
                final boolean isSat = z3Solver.solve(formula, bounds);
                final long endSolve = System.currentTimeMillis();

                final Statistics stats = new Statistics(0, 0, 0
                        , endSolve - startSolve - z3Solver.getSolvingTimeInMilis()
                        , z3Solver.getSolvingTimeInMilis());

                if (isSat) {
                    final Solution sol = Solution.satisfiable(stats, z3Solver.getInstance());
                    return sol;
                }
                else {
                    // TODO: Get proof
                    final Solution sol = Solution.unsatisfiable(stats, makeProof(z3Solver.getUnsatFormulaSet(), z3Solver.getUnsatTupleSet()));
                    return sol;
                }
            }
            else {
                final Translation.Whole translation = Translator.translate(formula, bounds, options);
                final long endTransl = System.currentTimeMillis();

                if (translation.trivial())
                    return trivial(translation, endTransl - startTransl);

                final SATSolver cnf = translation.cnf();

                options.reporter().solvingCNF(translation.numPrimaryVariables(), cnf.numberOfVariables(), cnf.numberOfClauses());
                final long startSolve = System.currentTimeMillis();
                final boolean isSat = cnf.solve();
                final long endSolve = System.currentTimeMillis();

                final Statistics stats = new Statistics(translation, endTransl - startTransl, endSolve - startSolve);
                return isSat ? sat(translation, stats) : unsat(translation, stats);
            }
		} catch (SATAbortedException sae) {
			throw new AbortedException(sae);
		}
	}

	/**
	 * Attempts to find all solutions to the given formula with respect to the specified bounds or
	 * to prove the formula's unsatisfiability.
	 * If the operation is successful, the method returns an iterator over n Solution objects. The outcome
	 * of the first n-1 solutions is SAT or trivially SAT, and the outcome of the nth solution is UNSAT
	 * or trivially  UNSAT.  Note that an unsatisfiability
	 * proof will be constructed for the last solution iff this.options specifies the use of a core extracting SATSolver.
	 * Additionally, the CNF variables in the proof can be related back to the nodes in the given formula
	 * iff this.options has variable tracking enabled.  Translation logging also requires that
	 * there are no subnodes in the given formula that are both syntactically shared and contain free variables.
	 *
	 * @return an iterator over all the Solutions to the formula with respect to the given bounds
	 * @throws NullPointerException  formula = null || bounds = null
	 * @throws kodkod.engine.fol2sat.UnboundLeafException  the formula contains an undeclared variable or
	 * a relation not mapped by the given bounds
	 * @throws kodkod.engine.fol2sat.HigherOrderDeclException  the formula contains a higher order declaration that cannot
	 * be skolemized, or it can be skolemized but this.options.skolemize is false.
	 * @throws AbortedException  this solving task was interrupted with a call to Thread.interrupt on this thread
	 * @throws IllegalStateException  !this.options.solver().incremental()
	 * @see Solution
	 * @see Options
	 * @see Proof
	 */
	public Iterator<Solution> solveAll(final Formula formula, final Bounds bounds)
		throws HigherOrderDeclException, UnboundLeafException, AbortedException {

        if (options.solver().instance() instanceof AssertionChecker)
            throw new AbortedException("Use 'solve' method with AssertionChecker.");

		if (options.solver().instance() instanceof Z3Solver) {
		    Z3Solver z3Solver = (Z3Solver) options.solver().instance();
		    Iterator<Instance> instanceIterator = z3Solver.solveAll(formula, bounds);
		    return new Iterator<Solution>() {
                @Override
                public boolean hasNext() {
                    return instanceIterator.hasNext();
                }

                @Override
                public Solution next() {
                    final long startSolve = System.currentTimeMillis();
                    Instance instance = instanceIterator.next();
                    final long endSolve = System.currentTimeMillis();

                    final Statistics stats = new Statistics(0, 0, 0
                            , endSolve - startSolve - z3Solver.getSolvingTimeInMilis()
                            , z3Solver.getSolvingTimeInMilis());

                    if (instance == null) {
                        return Solution.unsatisfiable(stats, makeProof(z3Solver.getUnsatFormulaSet(), z3Solver.getUnsatTupleSet()));
                    }
                    else {
                        return Solution.satisfiable(stats, instance);
                    }
                }
            };
        }

		if (!options.solver().incremental())
			throw new IllegalArgumentException("cannot enumerate solutions without an incremental solver.");

		return new SolutionIterator(formula, bounds, options);

	}

	/**
	 * {@inheritDoc}
	 * @see Object#toString()
	 */
	public String toString() {
		return options.toString();
	}

	/**
	 * Returns the result of solving a sat formula.
	 * @param translation the translation
	 * @param stats translation / solving stats
	 * @return the result of solving a sat formula.
	 */
	private static Solution sat(Translation.Whole translation, Statistics stats) {
		final Solution sol = Solution.satisfiable(stats, translation.interpret());
		translation.cnf().free();
		return sol;
	}

	/**
	 * Returns the result of solving an unsat formula.
	 * @param translation the translation
	 * @param stats translation / solving stats
	 * @return the result of solving an unsat formula.
	 */
	private static Solution unsat(Translation.Whole translation, Statistics stats) {
		final SATSolver cnf = translation.cnf();
		final TranslationLog log = translation.log();
		if (cnf instanceof SATProver && log != null) {
			return Solution.unsatisfiable(stats, new ResolutionBasedProof((SATProver) cnf, log));
		} else { // can free memory
			final Solution sol = Solution.unsatisfiable(stats, null);
			cnf.free();
			return sol;
		}
	}

	/**
	 * Returns the result of solving a trivially (un)sat formula.
	 * @param translation trivial translation produced as the result of {@code translation.formula}
	 * simplifying to a constant with respect to {@code translation.bounds}
	 * @param translTime translation time
	 * @return the result of solving a trivially (un)sat formula.
	 */
	private static Solution trivial(Translation.Whole translation, long translTime) {
		final Statistics stats = new Statistics(0, 0, 0, translTime, 0);
		final Solution sol;
		if (translation.cnf().solve()) {
			sol = Solution.triviallySatisfiable(stats, translation.interpret());
		} else {
			sol = Solution.triviallyUnsatisfiable(stats, trivialProof(translation.log()));
		}
		translation.cnf().free();
		return sol;
	}

	/**
	 * Returns a proof for the trivially unsatisfiable log.formula,
	 * provided that log is non-null.  Otherwise returns null.
	 * @requires log != null => log.formula is trivially unsatisfiable
	 * @return a proof for the trivially unsatisfiable log.formula,
	 * provided that log is non-null.  Otherwise returns null.
	 */
	private static Proof trivialProof(TranslationLog log) {
		return log==null ? null : new TrivialProof(log);
	}

	/**
	 * An iterator over all solutions of a model.
	 * @author Emina Torlak
	 */
	private static final class SolutionIterator implements Iterator<Solution> {
		private Translation.Whole translation;
		private long translTime;
		private int trivial;

		/**
		 * Constructs a solution iterator for the given formula, bounds, and options.
		 */
		SolutionIterator(Formula formula, Bounds bounds, Options options) {
			this.translTime = System.currentTimeMillis();
			this.translation = Translator.translate(formula, bounds, options);
			this.translTime = System.currentTimeMillis() - translTime;
			this.trivial = 0;
		}

		/**
		 * Returns true if there is another solution.
		 * @see Iterator#hasNext()
		 */
		public boolean hasNext() {  return translation != null; }

		/**
		 * Returns the next solution if any.
		 * @see Iterator#next()
		 */
		public Solution next() {
			if (!hasNext()) throw new NoSuchElementException();
			try {
				return translation.trivial() ? nextTrivialSolution() : nextNonTrivialSolution();
			} catch (SATAbortedException sae) {
				translation.cnf().free();
				throw new AbortedException(sae);
			}
		}

		/** @throws UnsupportedOperationException */
		public void remove() { throw new UnsupportedOperationException(); }

		/**
		 * Solves {@code translation.cnf} and adds the negation of the
		 * found model to the set of clauses.  The latter has the 
		 * effect of forcing the solver to come up with the next solution
		 * or return UNSAT. If {@code this.translation.cnf.solve()} is false, 
		 * sets {@code this.translation} to null.
		 * @requires this.translation != null
		 * @ensures this.translation.cnf is modified to eliminate
		 * the  current solution from the set of possible solutions
		 * @return current solution
		 */
		private Solution nextNonTrivialSolution() {
			final Translation.Whole transl = translation;

			final SATSolver cnf = transl.cnf();
			final int primaryVars = transl.numPrimaryVariables();

			transl.options().reporter().solvingCNF(primaryVars, cnf.numberOfVariables(), cnf.numberOfClauses());

			final long startSolve = System.currentTimeMillis();
			final boolean isSat = cnf.solve();
			final long endSolve = System.currentTimeMillis();

			final Statistics stats = new Statistics(transl, translTime, endSolve - startSolve);
			final Solution sol;

			if (isSat) {
				// extract the current solution; can't use the sat(..) method because it frees the sat solver
				sol = Solution.satisfiable(stats, transl.interpret());
				// add the negation of the current model to the solver
				final int[] notModel = new int[primaryVars];
				for(int i = 1; i <= primaryVars; i++) {
					notModel[i-1] = cnf.valueOf(i) ? -i : i;
				}
				cnf.addClause(notModel);
			} else {
				sol = unsat(transl, stats); // this also frees up solver resources, if any
				translation = null; // unsat, no more solutions
			}
			return sol;
		}

		/**
		 * Returns the trivial solution corresponding to the trivial translation stored in {@code this.translation},
		 * and if {@code this.translation.cnf.solve()} is true, sets {@code this.translation} to a new translation 
		 * that eliminates the current trivial solution from the set of possible solutions.  The latter has the effect 
		 * of forcing either the translator or the solver to come up with the next solution or return UNSAT.
		 * If {@code this.translation.cnf.solve()} is false, sets {@code this.translation} to null.
		 * @requires this.translation != null
		 * @ensures this.translation is modified to eliminate the current trivial solution from the set of possible solutions
		 * @return current solution
		 */
		private Solution nextTrivialSolution() {
			final Translation.Whole transl = this.translation;

			final Solution sol = trivial(transl, translTime); // this also frees up solver resources, if unsat

			if (sol.instance()==null) {
				translation = null; // unsat, no more solutions
			} else {
				trivial++;

				final Bounds bounds = transl.bounds();
				final Bounds newBounds = bounds.clone();
				final List<Formula> changes = new ArrayList<Formula>();

				for(Relation r : bounds.relations()) {
					final TupleSet lower = bounds.lowerBound(r);

					if (lower != bounds.upperBound(r)) { // r may change
						if (lower.isEmpty()) {
							changes.add(r.some());
						} else {
							final Relation rmodel = Relation.nary(r.name()+"_"+trivial, r.arity());
							newBounds.boundExactly(rmodel, lower);
							changes.add(r.eq(rmodel).not());
						}
					}
				}

				// nothing can change => there can be no more solutions (besides the current trivial one).
				// note that transl.formula simplifies to the constant true with respect to 
				// transl.bounds, and that newBounds is a superset of transl.bounds.
				// as a result, finding the next instance, if any, for transl.formula.and(Formula.or(changes)) 
				// with respect to newBounds is equivalent to finding the next instance of Formula.or(changes) alone.
				final Formula formula = changes.isEmpty() ? Formula.FALSE : Formula.or(changes);

				final long startTransl = System.currentTimeMillis();
				translation = Translator.translate(formula, newBounds, transl.options());
				translTime += System.currentTimeMillis() - startTransl;
			}
			return sol;
		}

	}
}
