package eu.modelwriter.core.alloyinecore.ui;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.SimpleMarkerAnnotation;
import eu.modelwriter.core.alloyinecore.KodKodFrontEnd_Test.UnderlineListener;
import eu.modelwriter.core.alloyinecore.interpreter.FormulaInfo;
import eu.modelwriter.core.alloyinecore.interpreter.typesystem.KodKodUniverse;
import eu.modelwriter.core.alloyinecore.interpreter.typesystem.structures.Atom;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreLexer;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser;
import eu.modelwriter.core.alloyinecore.structure.base.Repository;
import eu.modelwriter.core.alloyinecore.structure.constraints.IntExpression.Expr;
import eu.modelwriter.core.alloyinecore.translator.EcoreInstanceTranslator;
import eu.modelwriter.core.alloyinecore.ui.editor.AIEEditor;
import eu.modelwriter.core.alloyinecore.ui.editor.instance.AIEVisualizationEditor;
import eu.modelwriter.core.alloyinecore.ui.editor.instance.visualization.InstanceState;
import eu.modelwriter.core.alloyinecore.ui.editor.instance.visualization.PreferencesInstanceState;
import eu.modelwriter.core.alloyinecore.ui.preferences.PrefConstants;
import kodkod.ast.Formula;
import kodkod.engine.Proof;
import kodkod.engine.Solution;
import kodkod.engine.Solution.Outcome;
import kodkod.engine.Solver;
import kodkod.engine.fol2sat.TranslationRecord;
import kodkod.engine.satlab.ReductionStrategy;
import kodkod.engine.satlab.SATFactory;
import kodkod.engine.ucore.RCEStrategy;
import kodkod.instance.Bounds;
import kodkod.util.nodes.Nodes;
import kodkod.util.nodes.PrettyPrinter;

class ModelExtenderTask extends Thread {
  private SubMonitor subMonitor;
  private URI uri;
  private IFile iFile;
  private IEditorInput editorInput;
  private Repository repository;
  private boolean hasErrorWhileReasoning = false;
  private Solution solution = null;
  final Solver solver = new Solver();
  private String newBoundsInfo = new String();

  private int job;
  public static final int NEW_SOLUTION = 0;
  public static final int NEXT_SOLUTION = 1;
  public static final int PREV_SOLUTION = 2;
  public static final int CLEAR_MEMORY = 3;

  public ModelExtenderTask(SubMonitor subMonitor, final IFile iFile, IEditorInput editorInput,
      final URI uri, int job) {
    repository = new Repository(uri);
    this.subMonitor = subMonitor;
    this.iFile = iFile;
    this.editorInput = editorInput;
    this.uri = uri;
    this.job = job;
  }

  @Override
  public void run() {
    // the real process begins
    if (job == NEW_SOLUTION) {
      System.out.println("reasoning about the partial instance...");
      try {
        solution = reasonXMI();
      } catch (final Exception e) {
        e.printStackTrace();
        hasErrorWhileReasoning = true;
        // build the error message and include the current stack trace
        MultiStatus status = createMultiStatus(e.getLocalizedMessage(), e);
        // show error dialog
        Display.getDefault().syncExec(new Runnable() {
          public void run() {
            ErrorDialog.openError(Activator.getShell(), "AlloyInEcore Back-end Error",
                "Reasoning Error throwed!", status);
          }
        });
      }
      Display.getDefault().asyncExec(new Runnable() {

        public void run() {
          IEditorPart editor =
              Activator.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
          IEditorInput input = editor.getEditorInput();
          IFile iFile = ResourceUtil.getFile(input);
          editor.setFocus();
          ISelection selection =
              Activator.getActiveWorkbenchWindow().getSelectionService().getSelection();
          TreeSelection treeSelection = null;
          if (editor instanceof EcoreEditor) {
            Viewer viewer = ((EcoreEditor) editor).getViewer();
            TreeViewer treeViewer = null;
            if (viewer instanceof TreeViewer) {
              treeViewer = (TreeViewer) viewer;
            }
            if (selection instanceof TreeSelection) {
              treeSelection = (TreeSelection) selection;
              Iterator<?> iter = treeSelection.iterator();
              while (iter.hasNext()) {
                Object object = iter.next();
                treeViewer.expandToLevel(object, TreeViewer.ALL_LEVELS);
              }
            } else {
              treeViewer.expandAll();
            }
            try {
              iFile.refreshLocal(IResource.DEPTH_ONE, null);
            } catch (CoreException e) {
              e.printStackTrace();
              hasErrorWhileReasoning = true;
              // build the error message and include the current stack trace
              MultiStatus status = createMultiStatus(e.getLocalizedMessage(), e);
              // show error dialog
              Display.getDefault().syncExec(new Runnable() {
                public void run() {
                  ErrorDialog.openError(Activator.getShell(), "AlloyInEcore Back-end Error",
                      "Reasoning Error throwed!", status);
                }
              });
            }
          }

          if (solution.sat())
            Display.getDefault().asyncExec(new Runnable() {

              public void run() {
                for (IEditorReference ref : Activator.getActiveWorkbenchWindow().getActivePage()
                    .getEditorReferences()) {
                  IEditorPart editor = ref.getEditor(false);
                  if (editor instanceof AIEVisualizationEditor) {
                    ((AIEVisualizationEditor) editor).refreshEditor();
                  }
                }
              }
            });

          MessageDialog.openInformation(Activator.getShell(), "Model Extending Process ",
              "Your job has finished" + (hasErrorWhileReasoning ? " with errors."
                  : "." + (solution.sat() ? " (SATISFIABLE)" : " (UNSATISFIABLE)")));
        }

      });
      System.out.println("reasoning is finished ...");
    } else if (job == NEXT_SOLUTION) {
      SolutionHolder holder =
          SolutionHolder.getSolutionMap().get(iFile.getLocation().toFile().getAbsolutePath());

      boolean iterateForSat = (holder == null) ? true : holder.iterateForSat();

      if (iterateForSat)
        System.out.println("next instance process about the partial instance...");

      try {
        solution = nextSolution();
      } catch (final Exception e) {
        e.printStackTrace();
        hasErrorWhileReasoning = true;
        // build the error message and include the current stack trace
        MultiStatus status = createMultiStatus(e.getLocalizedMessage(), e);
        // show error dialog
        Display.getDefault().syncExec(new Runnable() {
          public void run() {
            if (iterateForSat)
              ErrorDialog.openError(Activator.getShell(), "AlloyInEcore Back-end Error",
                  "Next Solution Error throwed!", status);
            else
              ErrorDialog.openError(Activator.getShell(), "AlloyInEcore Back-end Error",
                  "Next Unsat Core Error throwed!", status);
          }
        });
      }
      Display.getDefault().asyncExec(new Runnable() {

        public void run() {
          IEditorPart editor =
              Activator.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
          IEditorInput input = editor.getEditorInput();
          IFile iFile = ResourceUtil.getFile(input);
          editor.setFocus();
          ISelection selection =
              Activator.getActiveWorkbenchWindow().getSelectionService().getSelection();
          TreeSelection treeSelection = null;
          if (editor instanceof EcoreEditor) {
            Viewer viewer = ((EcoreEditor) editor).getViewer();
            TreeViewer treeViewer = null;
            if (viewer instanceof TreeViewer) {
              treeViewer = (TreeViewer) viewer;
            }
            if (selection instanceof TreeSelection) {
              treeSelection = (TreeSelection) selection;
              Iterator<?> iter = treeSelection.iterator();
              while (iter.hasNext()) {
                Object object = iter.next();
                treeViewer.expandToLevel(object, TreeViewer.ALL_LEVELS);
              }
            } else {
              treeViewer.expandAll();
            }
            try {
              iFile.refreshLocal(IResource.DEPTH_ONE, null);
            } catch (CoreException e) {
              e.printStackTrace();
              hasErrorWhileReasoning = true;
              // build the error message and include the current stack trace
              MultiStatus status = createMultiStatus(e.getLocalizedMessage(), e);
              // show error dialog
              Display.getDefault().syncExec(new Runnable() {
                public void run() {
                  if (iterateForSat)
                    ErrorDialog.openError(Activator.getShell(), "AlloyInEcore Back-end Error",
                        "Next Solution Error throwed!", status);
                  else
                    ErrorDialog.openError(Activator.getShell(), "AlloyInEcore Back-end Error",
                        "Next Unsat Core Error throwed!", status);
                }
              });
            }
          }

          if (solution != null && solution.sat())
            Display.getDefault().asyncExec(new Runnable() {
              public void run() {
                for (IEditorReference ref : Activator.getActiveWorkbenchWindow().getActivePage()
                    .getEditorReferences()) {
                  IEditorPart editor = ref.getEditor(false);
                  if (editor instanceof AIEVisualizationEditor) {
                    ((AIEVisualizationEditor) editor).refreshEditor();
                  }
                }
              }
            });

          if (!hasErrorWhileReasoning && (solution == null || !solution.sat())) {
            if (iterateForSat)
              MessageDialog.openInformation(Activator.getShell(), "Next Instance Process ",
                  "There is no more solution.");
            else
              MessageDialog.openInformation(Activator.getShell(), "Next Unsat Core Process ",
                  "There is no more unsat core.");
          }
        }

      });
      if (iterateForSat)
        System.out.println("next instance process is finished ...");
    } else if (job == PREV_SOLUTION) {
      SolutionHolder holder =
          SolutionHolder.getSolutionMap().get(iFile.getLocation().toFile().getAbsolutePath());

      boolean iterateForSat = (holder == null) ? true : holder.iterateForSat();

      if (iterateForSat)
        System.out.println("previous instance process about the partial instance...");

      try {
        solution = previousSolution();
      } catch (final Exception e) {
        e.printStackTrace();
        hasErrorWhileReasoning = true;
        // build the error message and include the current stack trace
        MultiStatus status = createMultiStatus(e.getLocalizedMessage(), e);
        // show error dialog
        Display.getDefault().syncExec(new Runnable() {
          public void run() {
            if (iterateForSat)
              ErrorDialog.openError(Activator.getShell(), "AlloyInEcore Back-end Error",
                  "Previous Solution Error throwed!", status);
            else
              ErrorDialog.openError(Activator.getShell(), "AlloyInEcore Back-end Error",
                  "Previous Unsat Core Error throwed!", status);
          }
        });
      }
      Display.getDefault().asyncExec(new Runnable() {

        public void run() {
          IEditorPart editor =
              Activator.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
          IEditorInput input = editor.getEditorInput();
          IFile iFile = ResourceUtil.getFile(input);
          editor.setFocus();
          ISelection selection =
              Activator.getActiveWorkbenchWindow().getSelectionService().getSelection();
          TreeSelection treeSelection = null;
          if (editor instanceof EcoreEditor) {
            Viewer viewer = ((EcoreEditor) editor).getViewer();
            TreeViewer treeViewer = null;
            if (viewer instanceof TreeViewer) {
              treeViewer = (TreeViewer) viewer;
            }
            if (selection instanceof TreeSelection) {
              treeSelection = (TreeSelection) selection;
              Iterator<?> iter = treeSelection.iterator();
              while (iter.hasNext()) {
                Object object = iter.next();
                treeViewer.expandToLevel(object, TreeViewer.ALL_LEVELS);
              }
            } else {
              treeViewer.expandAll();
            }
            try {
              iFile.refreshLocal(IResource.DEPTH_ONE, null);
            } catch (CoreException e) {
              e.printStackTrace();
              hasErrorWhileReasoning = true;
              // build the error message and include the current stack trace
              MultiStatus status = createMultiStatus(e.getLocalizedMessage(), e);
              // show error dialog
              Display.getDefault().syncExec(new Runnable() {
                public void run() {
                  if (iterateForSat)
                    ErrorDialog.openError(Activator.getShell(), "AlloyInEcore Back-end Error",
                        "Previous Solution Error throwed!", status);
                  else
                    ErrorDialog.openError(Activator.getShell(), "AlloyInEcore Back-end Error",
                        "Previous Unsat Core Error throwed!", status);
                }
              });
            }
          }

          if (solution != null && solution.sat())
            Display.getDefault().asyncExec(new Runnable() {

              public void run() {
                for (IEditorReference ref : Activator.getActiveWorkbenchWindow().getActivePage()
                    .getEditorReferences()) {
                  IEditorPart editor = ref.getEditor(false);
                  if (editor instanceof AIEVisualizationEditor) {
                    ((AIEVisualizationEditor) editor).refreshEditor();
                  }
                }
              }
            });

          if (!hasErrorWhileReasoning && solution == null) {
            if (iterateForSat)
              MessageDialog.openInformation(Activator.getShell(), "Previous Unsat Core Process ",
                  "There is no previous solution.");
            else
              MessageDialog.openInformation(Activator.getShell(), "Previous Unsat Core Process ",
                  "There is no previous unsat core.");
          }
        }

      });
      if (iterateForSat)
        System.out.println("previous instance process is finished ...");
    } else if (job == CLEAR_MEMORY) {

      final File file = iFile.getLocation().toFile();
      SolutionHolder holder = SolutionHolder.getSolutionMap().remove(file.getAbsolutePath());

      MessageDialog.openInformation(Activator.getShell(), "Clear Memory Process",
          "Memory has been cleared for this instance.");
    }
  }

  private static MultiStatus createMultiStatus(String msg, Throwable t) {

    List<Status> childStatuses = new ArrayList<>();
    StackTraceElement[] stackTraces = Thread.currentThread().getStackTrace();

    for (StackTraceElement stackTrace : stackTraces) {
      Status status =
          new Status(IStatus.ERROR, "eu.modelwriter.alloyinecore", stackTrace.toString());
      childStatuses.add(status);
    }

    MultiStatus ms = new MultiStatus("eu.modelwriter.alloyinecore", IStatus.ERROR,
        childStatuses.toArray(new Status[] {}), t.toString(), t);
    return ms;
  }

  private Solution nextSolution() throws Exception {
    final File file = iFile.getLocation().toFile();

    InstanceState instanceState = new PreferencesInstanceState(iFile.getLocation().toString());

    if (!SolutionHolder.getSolutionMap().containsKey(file.getAbsolutePath())) {
      throw new Exception("Reason this instance first!");
    }

    SolutionHolder holder = SolutionHolder.getSolutionMap().get(file.getAbsolutePath());

    final Solution solution = holder.nextSolution();

    if (solution == null)
      return null;

    KodKodUniverse universe = holder.getUniverse();

    if (holder.iterateForSat()) {
      Formula formula = universe.getFormula();
      Bounds bounds = universe.getBounds();

      ResourceSet rs = new ResourceSetImpl();
      rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore",
          new EcoreResourceFactoryImpl());
      rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi",
          new XMIResourceFactoryImpl());
      // https://wiki.eclipse.org/EMF/FAQ#How_do_I_map_between_an_EMF_Resource_and_an_Eclipse_IFile.3F
      Resource res =
          rs.getResource(URI.createPlatformResourceURI(iFile.getFullPath().toString(), true), true);
      res.load(Collections.emptyMap());

      EPackage ep = res.getContents().get(0).eClass().getEPackage();
      IFile iFileModel = ResourcesPlugin.getWorkspace().getRoot()
          .getFile(new Path(ep.eResource().getURI().toPlatformString(true)));

      // Delete Unsat Error Markers if any
      iFileModel.deleteMarkers(AIEEditor.UNSAT_ERROR_MARKER, true, IResource.DEPTH_INFINITE);

      if (solution.instance() != null) { // SAT
        universe.updateWithInstance(solution.instance());
        universe.saveToXMI(file.getAbsolutePath());
        saveInferredObjects(universe, iFile.getLocation().toString());
      }

      universe.save(file.getAbsoluteFile().getParentFile().getAbsolutePath(),
          file.getName() + ".kodkod", bounds, formula, solution, printProof(solution.proof()));
    } else if (solution.sat()) {
      System.out.println(System.lineSeparator() + solution.instance());

      Set<EObject> witnessEObjects =
          universe.getWitnessAtoms(solution.instance().relationTuples().values().stream()
              .flatMap(e -> e.stream()).filter(e -> e.arity() == 1).map(e -> e.atom(0)).distinct()
              .filter(e -> e instanceof Atom).map(e -> (Atom) e).collect(Collectors.toSet()));

      Map<EObject, Map<EStructuralFeature, Set<EObject>>> witnessRelations =
          universe.getWitnessRelations(solution.instance().relationTuples());

      saveWitnessObjects(witnessEObjects, Collections.emptyMap(), witnessRelations,
          iFile.getLocation().toString());

    }

    return solution;
  }

  private Solution previousSolution() throws Exception {
    final File file = iFile.getLocation().toFile();

    InstanceState instanceState = new PreferencesInstanceState(iFile.getLocation().toString());

    if (!SolutionHolder.getSolutionMap().containsKey(file.getAbsolutePath())) {
      throw new Exception("Reason this instance first!");
    }

    SolutionHolder holder = SolutionHolder.getSolutionMap().get(file.getAbsolutePath());

    final Solution solution = holder.previousSolution();

    if (solution == null)
      return null;

    KodKodUniverse universe = holder.getUniverse();

    if (holder.iterateForSat()) {
      Formula formula = universe.getFormula();
      Bounds bounds = universe.getBounds();

      ResourceSet rs = new ResourceSetImpl();
      rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore",
          new EcoreResourceFactoryImpl());
      rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi",
          new XMIResourceFactoryImpl());
      // https://wiki.eclipse.org/EMF/FAQ#How_do_I_map_between_an_EMF_Resource_and_an_Eclipse_IFile.3F
      Resource res =
          rs.getResource(URI.createPlatformResourceURI(iFile.getFullPath().toString(), true), true);
      res.load(Collections.emptyMap());

      EPackage ep = res.getContents().get(0).eClass().getEPackage();
      IFile iFileModel = ResourcesPlugin.getWorkspace().getRoot()
          .getFile(new Path(ep.eResource().getURI().toPlatformString(true)));

      // Delete Unsat Error Markers if any
      iFileModel.deleteMarkers(AIEEditor.UNSAT_ERROR_MARKER, true, IResource.DEPTH_INFINITE);

      if (solution.instance() != null) { // SAT
        universe.updateWithInstance(solution.instance());
        universe.saveToXMI(file.getAbsolutePath());
        saveInferredObjects(universe, iFile.getLocation().toString());
      }

      universe.save(file.getAbsoluteFile().getParentFile().getAbsolutePath(),
          file.getName() + ".kodkod", bounds, formula, solution, printProof(solution.proof()));
    } else if (solution.sat()) {
      System.out.println(System.lineSeparator() + solution.instance());

      Set<EObject> witnessEObjects =
          universe.getWitnessAtoms(solution.instance().relationTuples().values().stream()
              .flatMap(e -> e.stream()).filter(e -> e.arity() == 1).map(e -> e.atom(0)).distinct()
              .filter(e -> e instanceof Atom).map(e -> (Atom) e).collect(Collectors.toSet()));

      Map<EObject, Map<EStructuralFeature, Set<EObject>>> witnessRelations =
          universe.getWitnessRelations(solution.instance().relationTuples());

      saveWitnessObjects(witnessEObjects, Collections.emptyMap(), witnessRelations,
          iFile.getLocation().toString());

    }

    return solution;
  }

  private Solution reasonXMI() throws Exception {
    ANTLRInputStream input = null;
    final File file = iFile.getLocation().toFile();
    EcoreInstanceTranslator translator = new EcoreInstanceTranslator(repository);
    try {
      input = new ANTLRInputStream(translator.translate(file.getAbsolutePath()));
    } catch (final IOException e) {
      e.printStackTrace();
    }

    final AlloyInEcoreLexer lexer = new AlloyInEcoreLexer(input);
    final CommonTokenStream tokens = new CommonTokenStream(lexer);
    final AlloyInEcoreParser parser = new AlloyInEcoreParser(tokens, uri, false);
    parser.removeErrorListeners();
    parser.addErrorListener(new UnderlineListener());
    parser.instance(null);

    KodKodUniverse universe = new KodKodUniverse(parser.instance);

    universe.setEObjects(file.getAbsolutePath());

    // Find and Open the Meta-model
    ResourceSet rs = new ResourceSetImpl();
    rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore",
        new EcoreResourceFactoryImpl());
    rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi",
        new XMIResourceFactoryImpl());
    // https://wiki.eclipse.org/EMF/FAQ#How_do_I_map_between_an_EMF_Resource_and_an_Eclipse_IFile.3F
    Resource res =
        rs.getResource(URI.createPlatformResourceURI(iFile.getFullPath().toString(), true), true);
    res.load(Collections.emptyMap());

    InstanceState instanceState = new PreferencesInstanceState(iFile.getLocation().toString());

    Set<EObject> set = new HashSet<>();

    TreeIterator<EObject> iteratorEo = res.getAllContents();

    while (iteratorEo.hasNext()) {
      set.add(iteratorEo.next());
    }

    universe.setModelReferences(instanceState.getModelReferences(set));
    universe.setModelAttributes(instanceState.getModelAttributes(set));

    Bounds bounds = universe.getBounds();
    Formula formula = universe.getFormula();

    IPreferenceStore store = Activator.getDefault().getPreferenceStore();
    
    boolean useZ3Solver = store.getBoolean(PrefConstants.USE_Z3_SOLVER);
    
    if (useZ3Solver) {
      solver.options().setSolver(SATFactory.Z3Solver);
    }
    else {
      solver.options().setSolver(SATFactory.MiniSatProver);
      solver.options().setCoreGranularity(3);
      solver.options().setLogTranslation(2);
      
      int symmetryBreaking;

      try {
        int sb = Integer.parseInt(store.getString(PrefConstants.SYMMETRY_BREAKING));
        if (sb >= 0)
          symmetryBreaking = sb;
        else
          symmetryBreaking = 20;
      } catch (NumberFormatException ex) {
        symmetryBreaking = 20;
      }
      System.out.println("Symmetry breaking is " + symmetryBreaking + ".");
      solver.options().setSymmetryBreaking(symmetryBreaking);
      solver.options().setBitwidth(universe.getBitwidth());
    }
    
    // final Solution solution = solver.solve(formula, bounds);
    final Iterator<Solution> iterator;
    /*if (useZ3Solver) {
      List<Solution> solutions = new ArrayList<>();
      solutions.add(solver.solve(formula, bounds));
      iterator = solutions.iterator();
    }
    else {*/
      iterator = solver.solveAll(formula, bounds);
    //}

    SolutionHolder holder = new SolutionHolder(universe, iterator, true);
    SolutionHolder.getSolutionMap().put(file.getAbsolutePath(), holder);

    final Solution solution = holder.nextSolution();

    EPackage ep = res.getContents().get(0).eClass().getEPackage();
    IFile iFileModel = ResourcesPlugin.getWorkspace().getRoot()
        .getFile(new Path(ep.eResource().getURI().toPlatformString(true)));

    // Delete Unsat Error Markers if any
    iFileModel.deleteMarkers(AIEEditor.UNSAT_ERROR_MARKER, true, IResource.DEPTH_INFINITE);

    String proofStr = "";

    if (solution.instance() != null) { // SAT
      universe.updateWithInstance(solution.instance());
      universe.saveToXMI(file.getAbsolutePath());
      saveInferredObjects(universe, iFile.getLocation().toString());
    } else if (solution.proof() != null) { // UNSAT
      universe.setEObjects(file.getAbsolutePath());

      final Proof proof = solution.proof();

      System.out.println("top-level formulas: " + proof.log().roots().size());
      System.out.println("initial core: " + proof.highLevelCore().size());
      System.out.println("minimizing core ... ");

      final long start = System.currentTimeMillis();
      proof.minimize(new RCEStrategy(proof.log()));
      final Set<Formula> core = Nodes.minRoots(formula, proof.highLevelCore().values());
      final long end = System.currentTimeMillis();

      System.out.println("done (" + (end - start) + " ms).");
      System.out.println("minimal core: " + core.size());

      for (Formula u : core) {
        System.out.println(PrettyPrinter.print(u, 2, 100));
      }

      IPreferenceStore preferenceStore = Activator.getDefault().getPreferenceStore();
      final Set<Formula> minCore = (preferenceStore.getBoolean(PrefConstants.CHECK_MINIMAL_CORE))
          ? checkMinimal(core, bounds)
          : core;

      Display.getDefault().syncExec(new Runnable() {

        public void run() {
          minCore.forEach(f -> {
            Set<FormulaInfo> fis = universe.getFormulaInfos(f);
            if (fis.isEmpty()) {
              System.out.println(f);
            } else {
              ITextEditor editor = null;
              for (FormulaInfo fi : fis) {
                try {

                  final IMarker m = iFileModel.createMarker(AIEEditor.UNSAT_ERROR_MARKER);
                  m.setAttribute(IMarker.MESSAGE, f.toString());
                  m.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_NORMAL);
                  m.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
                  m.setAttribute(IMarker.LINE_NUMBER, fi.getLine());
                  m.setAttribute(IMarker.CHAR_START, fi.getFirstIndex());
                  m.setAttribute(IMarker.CHAR_END, fi.getLastIndex() + 1);
                  m.setAttribute(IDE.EDITOR_ID_ATTR, AIEEditor.EDITOR_ID);

                  if (editor == null)
                    editor = (ITextEditor) IDE
                        .openEditor(Activator.getActiveWorkbenchWindow().getActivePage(), m);
                  IDocumentProvider idp = editor.getDocumentProvider();

                  // This is the document we want to connect to. This is taken from
                  // the current editor input.
                  IDocument document = idp.getDocument(editor.getEditorInput());

                  // The IannotationModel enables to add/remove/change annotation to a Document
                  // loaded in an Editor
                  IAnnotationModel iamf = idp.getAnnotationModel(editor.getEditorInput());

                  // Note: The annotation type id specify that you want to create one of your
                  // annotations
                  SimpleMarkerAnnotation ma =
                      new SimpleMarkerAnnotation(AIEEditor.UNSAT_ERROR_ANNOTATION, m);

                  // Finally add the new annotation to the model
                  iamf.connect(document);
                  iamf.addAnnotation(ma,
                      new Position(fi.getFirstIndex(), fi.getLastIndex() - fi.getFirstIndex() + 1));

                  // here we remove duplicated annotations that come from problemmarker creation and
                  // other type errors
                  Iterator<Annotation> annotatitonIterator = iamf.getAnnotationIterator();
                  while (annotatitonIterator.hasNext()) {
                    Annotation annotation = annotatitonIterator.next();
                    if (annotation.getType().equals("org.eclipse.ui.workbench.texteditor.error")) {
                      iamf.removeAnnotation(annotation);
                    }
                  }

                  iamf.disconnect(document);

                } catch (CoreException e) {
                  e.printStackTrace();
                }

              }

            }
          });
        }
      });

      Set<String> witnesses = new HashSet<>();
      Iterator<TranslationRecord> records = proof.core();
      while (records.hasNext()) {
        TranslationRecord record = records.next();
        witnesses.addAll(record.env().values().stream().flatMap(tuples -> tuples.stream())
            .map(tuple -> tuple.atom(0).toString()).collect(Collectors.toSet()));
      }

      saveWitnessObjects(universe.getEObjectsOfAtoms(witnesses),
          universe.getInferredsOfAtoms(witnesses), Collections.emptyMap(),
          iFile.getLocation().toString());

      proofStr = printProof(proof);

      boolean newerMethod = true;

      // Unsat core of trivially unsat
      if (solution.outcome().equals(Outcome.TRIVIALLY_UNSATISFIABLE)
          || (solution.outcome().equals(Outcome.UNSATISFIABLE) && Activator.getDefault()
              .getPreferenceStore().getBoolean(PrefConstants.NEW_UNSAT_CORE_STRATEGY))) {


        Bounds b = new Bounds(bounds.universe());
        bounds.lowerBounds().forEach(b::bound);

        Solution s = null;

        if (solution.outcome().equals(Outcome.TRIVIALLY_UNSATISFIABLE)) {
          Formula f = Formula.or(proof.highLevelCore().keySet()).not();
          final Iterator<Solution> ite = solver.solveAll(f, b);

          holder = new SolutionHolder(universe, ite, false);
          SolutionHolder.getSolutionMap().put(file.getAbsolutePath(), holder);

          s = holder.nextSolution();
        } else if (!newerMethod) {
          List<Formula> coreFormulaList = new ArrayList<>(proof.highLevelCore().keySet());

          Map<Formula, Iterator<Solution>> solutionIteratorMap =
              getCoreSolutions(solver, bounds, coreFormulaList);

          System.out.println("---------------------");
          System.out.println("- CORE COMBINATIONS -");
          System.out.println("---------------------");

          List<Solution> solutionList = new ArrayList<>();

          solutionIteratorMap.forEach((frml, itrtr) -> {

            List<Solution> temp = new ArrayList<>();
            int count = 0;

            System.out.println(System.lineSeparator() + "Formula: " + frml);
            while (itrtr.hasNext()) {
              Solution sol = itrtr.next();
              if (sol.sat()) {
                count++;
                System.out.println(System.lineSeparator() + sol.instance());
                temp.add(sol);
                if (count == 1)
                  solutionList.add(sol);
              } else {
                System.out.println(System.lineSeparator() + "Unsat");
              }
            }

            // En fazla tuple olanı seç
            temp.stream().filter(e -> e.sat()).reduce((e1, e2) -> {
              int e1Size = e1.instance().relationTuples().values().stream().map(e -> e.size())
                  .reduce((f1, f2) -> f1 + f2).orElse(0);
              int e2Size = e2.instance().relationTuples().values().stream().map(e -> e.size())
                  .reduce((f1, f2) -> f1 + f2).orElse(0);

              if (e1Size > e2Size)
                return e1;
              else
                return e2;
            }).ifPresent(e -> solutionList.add(e));

          });

          holder = new SolutionHolder(universe, solutionList, false);
          SolutionHolder.getSolutionMap().put(file.getAbsolutePath(), holder);

          s = holder.nextSolution();

          System.out.println("---------------------");
        } else {
          Formula[] ff = new Formula[1];

          Display.getDefault().syncExec(new Runnable() {

            @Override
            public void run() {
              FormulaSelectionDialog fsd =
                  new FormulaSelectionDialog(Activator.getShell(), proof.highLevelCore().keySet());

              fsd.open();

              ff[0] = fsd.getFormula();
            }
          });

          final Iterator<Solution> ite = solver.solveAll(ff[0], b);

          holder = new SolutionHolder(universe, ite, false);
          SolutionHolder.getSolutionMap().put(file.getAbsolutePath(), holder);

          s = holder.nextSolution();
        }

        if (s.sat()) {
          System.out.println(System.lineSeparator() + s.instance());
          proofStr += s.instance();

          Set<EObject> witnessEObjects = universe.getWitnessAtoms(
              s.instance().relationTuples().values().stream().flatMap(e -> e.stream())
                  .filter(e -> e.arity() == 1).map(e -> e.atom(0)).distinct()
                  .filter(e -> e instanceof Atom).map(e -> (Atom) e).collect(Collectors.toSet()));

          Map<EObject, Map<EStructuralFeature, Set<EObject>>> witnessRelations =
              universe.getWitnessRelations(s.instance().relationTuples());

          saveWitnessObjects(witnessEObjects, Collections.emptyMap(), witnessRelations,
              iFile.getLocation().toString());

        } else {
          printProof(s.proof());
        }
      }

      System.out.println();

      Display.getDefault().syncExec(new Runnable() {

        public void run() {
          IEditorReference[] editorReferences =
              Activator.getActiveWorkbenchWindow().getActivePage().findEditors(editorInput,
                  AIEVisualizationEditor.EDITOR_ID, org.eclipse.ui.IWorkbenchPage.MATCH_ID
                      | org.eclipse.ui.IWorkbenchPage.MATCH_INPUT);
          if (editorReferences.length > 0)
            try {
              ((AIEVisualizationEditor) editorReferences[0].getEditor(true)).refreshEditor();
            } catch (Exception e) {
              e.printStackTrace();
            }
        }

      });
    }

    universe.save(file.getAbsoluteFile().getParentFile().getAbsolutePath(),
        file.getName() + ".kodkod", bounds, formula, solution, proofStr);

    save(file.getAbsoluteFile().getParentFile().getAbsolutePath(), file.getName() + ".smt", solver.options().solver().toString());
    
    return solution;
  }
  
  public void save(String outDir, String fileName, String text) {
    try {
        java.nio.file.Path path = Paths.get(outDir + File.separator + fileName);
        if (!Files.exists(path.getParent()))
            Files.createDirectories(path.getParent());

        Files.write(path, text.getBytes());
    } catch (IOException e) {
        e.printStackTrace();
    }
}

  private static Map<Formula, Iterator<Solution>> getCoreSolutions(Solver solver, Bounds bounds,
      List<Formula> core) {
    Bounds b = new Bounds(bounds.universe());
    bounds.lowerBounds().forEach(b::bound);

    List<Formula> formulaList = new ArrayList<>();

    if (core.size() == 1) {
      Formula f = core.get(0).not();

      formulaList.add(f);
    } else {
      for (int i = 1; i < Math.pow(2, core.size()) - 1; i++) {
        Set<Formula> current = new HashSet<>();

        for (int j = 0; j < core.size(); j++) {
          if ((int) (i / Math.pow(2, j)) % 2 == 0) {
            current.add(core.get(j));
          } else {
            current.add(core.get(j).not());
          }
        }

        Formula f = Formula.and(current);

        formulaList.add(f);
      }
    }

    return formulaList.stream().collect(Collectors.toMap(f -> f, f -> solver.solveAll(f, b)));
  }

  private static Set<Formula> checkMinimal(Set<Formula> core, Bounds bounds) {
    System.out.print("checking minimality ... ");

    final long start = System.currentTimeMillis();
    final Set<Formula> minCore = new LinkedHashSet<Formula>(core);
    Solver solver = new Solver();
    solver.options().setSolver(SATFactory.MiniSatProver);
    for (Iterator<Formula> itr = minCore.iterator(); itr.hasNext();) {
      Formula f = itr.next();
      Formula noF = Formula.TRUE;
      for (Formula f1 : minCore) {
        if (f != f1)
          noF = noF.and(f1);
      }
      if (solver.solve(noF, bounds).instance() == null) {
        itr.remove();
      }
    }
    final long end = System.currentTimeMillis();

    if (minCore.size() == core.size()) {
      System.out.println("minimal (" + (end - start) + " ms).");
    } else {
      System.out.println("not minimal (" + (end - start) + " ms). The minimal core has these "
          + minCore.size() + " formulas:");
      for (Formula f : minCore) {
        System.out.println(" " + f);
      }
      // Solution sol = problem.solver.solve(Formula.and(minCore), problem.bounds);
      // System.out.println(sol);
      // sol.proof().highLevelCore();
    }

    return minCore;
  }

  private void saveInferredObjects(KodKodUniverse universe, String file) {

    InstanceState instanceState = new PreferencesInstanceState(file);

    instanceState.clearInferreds();
    instanceState.clearModels();
    instanceState.clearWitnesses();

    instanceState.saveSatisfiable(true);
    instanceState.saveVisualize(true);

    instanceState.saveInferredEObjects(universe.getInferredEObjects());
    instanceState.saveInferredRelations(universe.getInferredRelations());

    instanceState.saveModelReferences(universe.getModelReferences());
    instanceState.saveModelAttributes(universe.getModelAttributes());

    instanceState.flush();
  }

  private void saveWitnessObjects(Set<EObject> witnesses, Map<String, String> inferredWitnesses,
      Map<EObject, Map<EStructuralFeature, Set<EObject>>> witnessRelations, String file) {

    InstanceState instanceState = new PreferencesInstanceState(file);

    instanceState.clearInferreds();
    instanceState.clearWitnesses();

    instanceState.saveSatisfiable(false);
    instanceState.saveVisualize(true);

    instanceState.saveWitnesses(witnesses);
    instanceState.saveInferredWitnesses(inferredWitnesses);
    instanceState.saveWitnessRelations(witnessRelations);

    instanceState.flush();
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
    while (iterator.hasNext()) {
      try {
        TranslationRecord tr = iterator.next();

        if (tr.env().size() == 0)
          continue;

        StringBuilder sb = new StringBuilder();
        sb.append(tr.node().toString());
        tr.env()
            .forEach((variable, tuples) -> sb.replace(0, sb.length(),
                sb.toString()
                    .replace(variable + " ", tuples.iterator().next().atom(0).toString() + " ")
                    .replace(variable + ")", tuples.iterator().next().atom(0).toString() + ")")));

        lines.add(sb.toString());
      } catch (Exception e) {
      }

    }
    stringBuilder.append("\nUnsat core:\n");
    lines.stream().distinct().forEach(s -> {
      stringBuilder.append(s);
      stringBuilder.append(System.lineSeparator());
    });

    System.out.println(stringBuilder);

    return stringBuilder.toString();
  }
}
