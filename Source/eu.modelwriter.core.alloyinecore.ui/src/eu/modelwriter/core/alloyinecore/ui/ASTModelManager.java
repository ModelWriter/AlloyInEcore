package eu.modelwriter.core.alloyinecore.ui;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.Token;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Display;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser;
import eu.modelwriter.core.alloyinecore.structure.base.Element;
import eu.modelwriter.core.alloyinecore.typechecking.JavaSourceFromString;
import eu.modelwriter.core.alloyinecore.typechecking.TypeChecker;
import eu.modelwriter.core.alloyinecore.typechecking.TypeErrorListener;
import eu.modelwriter.core.alloyinecore.ui.editor.AIEEditor;
import eu.modelwriter.core.alloyinecore.ui.editor.util.EditorUtils;
import eu.modelwriter.core.alloyinecore.ui.preferences.PrefConstants;

public class ASTModelManager extends ASTManager {

  public static final String JAVA_PROJECT_NAME = "eu.modelwriter.alloyinecore.java";
  private IFolder binDir;
  private IFolder srcDir;
  private IProject project;
  private IJavaProject javaProject;

  public ASTModelManager(AIEEditor aieEditor) {
    super(aieEditor);
  }

  @SuppressWarnings("rawtypes")
  @Override
  public Element parseString(String text, URI uri) throws Exception {
    hasSyntaxError = false;
    AlloyInEcoreParser parser = createParser(text, uri);
    parser.model(null);
    changeListeners.forEach(l -> l.onASTChange(parser.model));
    if (!hasSyntaxError) {
      String outDir = ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString()
          + File.separator + ".modelwriter" + File.separator + "java";

      boolean saveInJP = shouldSaveIntoJavaProject();
      TypeChecker checker = new TypeChecker(outDir, !saveInJP);
      checker.addErrorListener(new TypeErrorListener() {

        @Override
        public void onTypeWarning(String message, Set<Token> relatedElements) {
          errorListeners.forEach(l -> l.onTypeWarning(message, relatedElements));
        }

        @Override
        public void onTypeError(String message, Set<Token> relatedElements) {
          errorListeners.forEach(l -> l.onTypeError(message, relatedElements));
        }
      });
      checker.check(parser.model);
      if (saveInJP) {
        try {
          saveInJavaProject(checker.getGeneratedJavaFiles());
        } catch (CoreException e) {
          e.printStackTrace();
        }
      }
    }
    return parser.model;
  }

  private void saveInJavaProject(Set<JavaSourceFromString> filesToSave) throws CoreException {
    new Thread(new Runnable() {

      @Override
      public void run() {
        try {
          IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
          project = root.getProject(generateProjectName());
          if (!project.exists()) {
            createJavaProject(project);
          } else {
            binDir = project.getFolder("bin");
            srcDir = project.getFolder("src");
          }
          project.open(null);
          rewriteInSrcFolder(srcDir, filesToSave);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }).start();
  }

  protected void rewriteInSrcFolder(IFolder srcDir, Set<JavaSourceFromString> filesToSave) {
    Display.getDefault().asyncExec(new Runnable() {

      @Override
      public void run() {
        try {
          List<IFile> activeEditorsFiles = EditorUtils.getActiveEditorsFiles();
          // Empty out the src folder
          deleteFiles(srcDir, activeEditorsFiles);
        } catch (CoreException e) {
          e.printStackTrace();
        } finally {
          // Save new files
          filesToSave.forEach(js -> saveFile(js, srcDir.getLocation().toOSString()));
        }
      }

      private void deleteFiles(IFolder folder, List<IFile> activeEditorsFiles)
          throws CoreException {
        for (IResource iRes : folder.members()) {
          if (iRes instanceof IFolder) {
            deleteFiles((IFolder) iRes, activeEditorsFiles);
            // If no child left, delete the folder too
            if (((IFolder) iRes).members().length == 0)
              iRes.delete(true, null);
          } else if (iRes instanceof IFile && !activeEditorsFiles.contains(iRes)) {
            iRes.delete(true, null);
          }
        }
      }
    });
  }

  private void createJavaProject(IProject project) throws CoreException {
    IProgressMonitor progressMonitor = new NullProgressMonitor();
    project.create(progressMonitor);
    project.open(progressMonitor);

    IProjectDescription desc = project.getDescription();
    desc.setNatureIds(new String[] {JavaCore.NATURE_ID});
    project.setDescription(desc, progressMonitor);

    javaProject = JavaCore.create(project);
    binDir = project.getFolder("bin");
    IPath binPath = binDir.getFullPath();
    javaProject.setOutputLocation(binPath, progressMonitor);

    List<IClasspathEntry> entries = new ArrayList<IClasspathEntry>();
    entries.add(JavaRuntime.getDefaultJREContainerEntry());
    javaProject.setRawClasspath(entries.toArray(new IClasspathEntry[entries.size()]), null);

    srcDir = project.getFolder("src");
    srcDir.create(true, true, progressMonitor);
    IPackageFragmentRoot root = javaProject.getPackageFragmentRoot(srcDir);
    IClasspathEntry[] oldEntries = javaProject.getRawClasspath();
    IClasspathEntry[] newEntries = new IClasspathEntry[oldEntries.length + 1];
    System.arraycopy(oldEntries, 0, newEntries, 0, oldEntries.length);
    newEntries[oldEntries.length] = JavaCore.newSourceEntry(root.getPath());
    javaProject.setRawClasspath(newEntries, null);
  }

  private void saveFile(JavaSourceFromString generated, String outDir) {
    new Thread(new Runnable() {

      @Override
      public void run() {
        try {
          Path path = Paths.get(outDir + "/" + generated.getRawName() + ".java");
          if (!Files.exists(path.getParent()))
            Files.createDirectories(path.getParent());
          Files.write(path, generated.getCode().getBytes());
          IFile iFile = ResourcesPlugin.getWorkspace().getRoot()
              .getFileForLocation(new org.eclipse.core.runtime.Path(path.toString()));
          if (iFile != null)
            iFile.refreshLocal(IResource.DEPTH_ONE, null);
          else
            EditorUtils.refreshEditor(path);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }).start();
  }

  private boolean shouldSaveIntoJavaProject() {
    IPreferenceStore store = Activator.getDefault().getPreferenceStore();
    return store.getBoolean(PrefConstants.TYPECHECK_SAVE_IN_JAVA_PROJECT);
  }

  private String generateProjectName() {
    IFile iFile = editor.getIFile();
    String extension = "." + iFile.getFileExtension();
    String string = iFile.getFullPath().toString().replaceAll("/", ".").replace(extension, "");
    if (string.startsWith("."))
      string = string.replaceFirst(".", "");
    return string;
  }
}
