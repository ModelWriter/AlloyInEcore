
/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017, Ferhat Erata <ferhat@computer.org>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package eu.modelwriter.core.alloyinecore;

import eu.modelwriter.core.alloyinecore.interpreter.FormulaInfo;
import eu.modelwriter.core.alloyinecore.interpreter.KodKodUniverse;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreLexer;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser;
import eu.modelwriter.core.alloyinecore.translator.EcoreInstanceTranslator;
import kodkod.ast.Formula;
import kodkod.engine.Proof;
import kodkod.engine.Solution;
import kodkod.engine.Solver;
import kodkod.engine.fol2sat.TranslationRecord;
import kodkod.engine.satlab.ReductionStrategy;
import kodkod.engine.satlab.SATFactory;
import kodkod.engine.ucore.RCEStrategy;
import kodkod.engine.ucore.SCEStrategy;
import kodkod.instance.Bounds;
import org.antlr.v4.runtime.*;

import java.io.File;
import java.io.IOException;
import java.util.*;


public class KodKodFrontEnd_Test {

    public static Solution reasonXMI(String filePath) throws Exception {
        ANTLRInputStream input = null;
        final File file = new File(filePath);
        EcoreInstanceTranslator translator = new EcoreInstanceTranslator();
        try {
            input = new ANTLRInputStream(translator.translate(file.getAbsolutePath()));
        } catch (final IOException e) {
            e.printStackTrace();
        }

        final AlloyInEcoreLexer lexer = new AlloyInEcoreLexer(input);
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final AlloyInEcoreParser parser = new AlloyInEcoreParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new UnderlineListener());
        parser.instance(null);

        KodKodUniverse universe = new KodKodUniverse(parser.instance);

        Formula formula = universe.getFormula();
        Bounds bounds = universe.getBounds();

        final Solver solver = new Solver();
        solver.options().setSolver(SATFactory.MiniSatProver);
        solver.options().setCoreGranularity(3);
        solver.options().setLogTranslation(2);
        solver.options().setSymmetryBreaking(20);
        //final Solution solution = solver.solve(formula, bounds);
        final Iterator<Solution> iterator = solver.solveAll(formula, bounds);
        final Solution solution = iterator.next();

        universe.save(file.getAbsoluteFile().getParentFile().getAbsolutePath(), file.getName() + ".kodkod", bounds, formula, solution);

        if (solution.sat()){
            universe.updateWithInstance(solution.instance());
            universe.saveToXMI(filePath);
        }

        return solution;
    }

    public static void main(final String[] args) {
        newMethod();
    }

    public static void oldMethod() {
        String filename = "Memory1.xmi";
        ANTLRInputStream input = null;
        final File file = new File(filename);
        EcoreInstanceTranslator translator = new EcoreInstanceTranslator();
        try {
            input = new ANTLRInputStream(translator.translate(file.getAbsolutePath()));
        } catch (final IOException e) {
            e.printStackTrace();
        }

        final AlloyInEcoreLexer lexer = new AlloyInEcoreLexer(input);
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final AlloyInEcoreParser parser = new AlloyInEcoreParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new UnderlineListener());
        parser.instance(null);

        try {
            new eu.modelwriter.core.alloyinecore.interpreter.typesystem.KodKodUniverse(parser.instance).saveToXMI(filename);
            KodKodUniverse universe = new KodKodUniverse(parser.instance);

            Formula formula = universe.getFormula();
            System.out.println("Formula = " + formula);
            Bounds bounds = universe.getBounds();
            System.out.println("Bounds = " + bounds);

            final Solver solver = new Solver();
            solver.options().setSolver(SATFactory.MiniSatProver);
            solver.options().setCoreGranularity(3);
            solver.options().setLogTranslation(2);
            solver.options().setSymmetryBreaking(20);
            solver.options().setBitwidth(universe.getBitwidth());
            final Solution solution = solver.solve(formula, bounds);
            System.out.println(solution);
            universe.save(file.getAbsoluteFile().getParentFile().getAbsolutePath(), file.getName() + "_bounds.txt", bounds, formula, solution);

            if (solution.sat()){
                universe.updateWithInstance(solution.instance());
                universe.saveToXMI(filename);

                System.out.println(universe.getInstanceString());
            }
            else if (solution.proof() != null){
                Proof proof = solution.proof();

                System.out.println("Invariants causing the conflict: \n");

                ReductionStrategy strategy = new SCEStrategy(proof.log());
                proof.minimize(strategy);

                proof.highLevelCore().keySet().forEach(f -> {
                    Set<FormulaInfo> fis = universe.getFormulaInfos(f);
                    if (fis.isEmpty()) {
                        System.out.println(f);
                    }
                    else {
                        for (FormulaInfo fi : fis) {
                            System.out.println(fi.getLine() +
                                    " (" + fi.getFirstIndexInLine() + "-" + fi.getLastIndexInLine() + "): " + f);
                        }
                    }
                });

                System.out.println(printProof(solution.proof()));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void newMethod() {
        String filename = "Memory.xmi";
        ANTLRInputStream input = null;
        final File file = new File(filename);
        EcoreInstanceTranslator translator = new EcoreInstanceTranslator();
        try {
            input = new ANTLRInputStream(translator.translate(file.getAbsolutePath()));
        } catch (final IOException e) {
            e.printStackTrace();
        }

        final AlloyInEcoreLexer lexer = new AlloyInEcoreLexer(input);
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final AlloyInEcoreParser parser = new AlloyInEcoreParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new UnderlineListener());
        parser.instance(null);

        try {
            eu.modelwriter.core.alloyinecore.interpreter.typesystem.KodKodUniverse universe
                    = new eu.modelwriter.core.alloyinecore.interpreter.typesystem.KodKodUniverse(parser.instance);

            Bounds bounds = universe.getBounds();
            Formula formula = universe.getFormula();
            System.out.println("Formula = " + formula);
            System.out.println("Bounds = " + bounds);

            final Solver solver = new Solver();
            solver.options().setSolver(SATFactory.Z3Solver);
            solver.options().setCoreGranularity(3);
            solver.options().setLogTranslation(2);
            solver.options().setSymmetryBreaking(20);
            solver.options().setBitwidth(universe.getBitwidth());
            final Solution solution = solver.solve(formula, bounds);

            System.out.println("**********************************************" +
                    "\nInstance before solving: \n");
            System.out.println(universe.getInstanceString());
            System.out.println("**********************************************\n");

            System.out.println(solution);

            String proofString = printProof(solution.proof());

            universe.save(file.getAbsoluteFile().getParentFile().getAbsolutePath(), file.getName() + "_bounds.txt", bounds, formula, solution, proofString);

            if (solution.sat()){
                universe.updateWithInstance(solution.instance());
                universe.saveToXMI(filename);

                System.out.println(universe.getInstanceString());
            }
            else if (solution.proof() != null){
                Proof proof = solution.proof();

                System.out.println("Invariants causing the conflict: \n");

                ReductionStrategy strategy = new SCEStrategy(proof.log());
                proof.minimize(strategy);

                proof.highLevelCore().keySet().forEach(f -> {
                    Set<FormulaInfo> fis = universe.getFormulaInfos(f);
                    if (fis.isEmpty()) {
                        System.out.println(f);
                    }
                    else {
                        for (FormulaInfo fi : fis) {
                            System.out.println(fi.getLine() +
                                    " (" + fi.getFirstIndexInLine() + "-" + fi.getLastIndexInLine() + "): " + f);
                        }
                    }
                });

                System.out.println(proofString);
            }

            /*KodkodZ3Solver z3Solver = new KodkodZ3Solver();
            z3Solver.solve(formula, bounds);*/

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String printProof(Proof proof) {

        if (proof == null)
            return "";

        StringBuilder stringBuilder = new StringBuilder();

        List<String> lines = new ArrayList<>();

        ReductionStrategy strategy = new RCEStrategy(proof.log());
        proof.minimize(strategy);

        stringBuilder.append("Invariants causing the conflict: \n");

        proof.highLevelCore().keySet().forEach(stringBuilder::append);

        Iterator<TranslationRecord> iterator = proof.core();
        while (iterator.hasNext()){
            try{
                TranslationRecord tr = iterator.next();

                if (tr.env().size() == 0)
                    continue;

                StringBuilder sb = new StringBuilder();
                sb.append(tr.node().toString());
                tr.env().forEach((variable, tuples) -> sb.replace(0, sb.length(), sb.toString()
                        .replace(variable + " ", tuples.iterator().next().atom(0).toString() + " ")
                        .replace(variable + ")", tuples.iterator().next().atom(0).toString() + ")")
                ));

                lines.add(sb.toString());
            }
            catch (Exception e){}

        }
        stringBuilder.append("\nUnsat core:\n");
        lines.stream().distinct().forEach(stringBuilder::append);
        return stringBuilder.toString();
    }

    public static class VerboseListener extends BaseErrorListener {
        @Override
        public void syntaxError(Recognizer<?, ?> recognizer,
                                Object offendingSymbol,
                                int line, int charPositionInLine,
                                String msg,
                                RecognitionException e) {
            List<String> stack = ((Parser) recognizer).getRuleInvocationStack();
            Collections.reverse(stack);
            System.err.println("rule stack: " + stack);
            System.err.println("line " + line + ":" + charPositionInLine + " at " +
                    offendingSymbol + ": " + msg);
        }
    }

    public static class UnderlineListener extends BaseErrorListener {
        public void syntaxError(Recognizer<?, ?> recognizer,
                                Object offendingSymbol,
                                int line, int charPositionInLine,
                                String msg,
                                RecognitionException e) {
            underlineError(recognizer, (Token) offendingSymbol, line, charPositionInLine, msg);
        }

        protected void underlineError(Recognizer recognizer,
                                      Token offendingToken, int line,
                                      int charPositionInLine, String msg) {
            CommonTokenStream tokens = (CommonTokenStream) recognizer.getInputStream();
            String input = tokens.getTokenSource().getInputStream().toString();
            String[] lines = input.split("\n");
            String errorLine = lines[line - 1];
            System.err.println("line " + line + ":" + charPositionInLine + " " + msg);
            System.err.println(errorLine);


            for (int i = 0; i < charPositionInLine; i++) System.err.print(" ");

            int start = offendingToken.getStartIndex();
            int stop = offendingToken.getStopIndex();

            if (start >= 0 && stop >= 0) {
                for (int i = start; i <= stop; i++) System.err.print("^");
            }
            System.err.println();
        }
    }



}
