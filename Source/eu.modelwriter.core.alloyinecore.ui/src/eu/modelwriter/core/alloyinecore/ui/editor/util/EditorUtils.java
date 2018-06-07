package eu.modelwriter.core.alloyinecore.ui.editor.util;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.jface.text.IDocument;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.FileStoreEditorInput;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.FileEditorInput;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreLexer;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser;
import eu.modelwriter.core.alloyinecore.structure.base.Element;
import eu.modelwriter.core.alloyinecore.structure.instance.Instance;
import eu.modelwriter.core.alloyinecore.structure.model.Import;
import eu.modelwriter.core.alloyinecore.structure.model.Model;
import eu.modelwriter.core.alloyinecore.ui.editor.AIEEditor;
import eu.modelwriter.core.alloyinecore.ui.editor.instance.AIEInstanceEditor;

public final class EditorUtils {

  /**
   * Parses the given document's text.
   * 
   * @param document
   * @param errorListener
   * @return Parsed {@linkplain eu.modelwriter.core.alloyinecore.structure.Module} object
   * @throws Exception
   */
  public static Model parseDocument(final IDocument document, final URI uri,
      final BaseErrorListener errorListener) throws Exception {
    return EditorUtils.parseString(document.get(), uri, errorListener);
  }

  /**
   * Parses the given text.
   * 
   * @param text
   * @param errorListener
   * @return Parsed {@link eu.modelwriter.core.alloyinecore.structure.Module} object
   * @throws Exception
   */
  public static Model parseString(final String text, final URI uri,
      final BaseErrorListener errorListener) throws Exception {
    final AlloyInEcoreLexer lexer = new AlloyInEcoreLexer(new ANTLRInputStream(text));
    final CommonTokenStream tokens = new CommonTokenStream(lexer);
    final AlloyInEcoreParser parser = new AlloyInEcoreParser(tokens, uri);
    parser.removeErrorListeners();
    parser.addErrorListener(errorListener);
    parser.model(null);
    return parser.model;
  }

  /**
   * 
   * @param element Root element to start the search
   * @param line
   * @param offset
   * @return
   */
  @SuppressWarnings({"rawtypes"})
  public static Element findElement(final Element<?> element, final int line, final int offset) {
    for (final Element object : element.getOwnedElements()) {
      if (EditorUtils.inContext(object.getContext(), offset)) {
        if (object instanceof Import)
          return object;
        else
          return EditorUtils.findElement(object, line, offset);
      } else if (EditorUtils.isInSameLine(object.getContext(), line)) {
        return object;
      }
    }
    return element;
  }

  /**
   * 
   * @param context
   * @param offset
   * @return if given offset is in given context, true; otherwise false
   */
  public static boolean inContext(final ParserRuleContext context, final int offset) {
    return context.start.getStartIndex() <= offset && context.stop.getStopIndex() + 1 >= offset;
  }

  public static boolean isInSameLine(final ParserRuleContext context, final int line) {
    ParserRuleContext parent = context.getParent();
    // To get ride of wrappers
    parent = parent != null && parent.start.getStartIndex() == context.start.getStartIndex()
        ? parent.getParent() : parent;
    // if its same line with context and
    // context is not same line with its parent, 'cus we need parent if same line
    return line >= context.start.getLine() && line <= context.stop.getLine() && parent != null
        && parent.start.getLine() != context.start.getLine();
  }

  public static Instance parseInstanceDocument(IDocument document, URI uri,
      BaseErrorListener baseErrorListener) {
    return EditorUtils.parseInstanceString(document.get(), uri, baseErrorListener);
  }

  public static Instance parseInstanceString(String text, URI uri,
      BaseErrorListener baseErrorListener) {
    final AlloyInEcoreLexer lexer = new AlloyInEcoreLexer(new ANTLRInputStream(text));
    final CommonTokenStream tokens = new CommonTokenStream(lexer);
    final AlloyInEcoreParser parser = new AlloyInEcoreParser(tokens, uri);
    parser.removeErrorListeners();
    parser.addErrorListener(baseErrorListener);
    parser.instance(null);
    return parser.instance;
  }

  public static EcoreEditor openEcoreEditor(IEditorInput input) throws PartInitException {
    IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
    return (EcoreEditor) page.openEditor(input, "org.eclipse.emf.ecore.presentation.EcoreEditorID",
        true, IWorkbenchPage.MATCH_ID | IWorkbenchPage.MATCH_INPUT);
  }

  public static AIEEditor openAIEEditor(IEditorInput input) throws PartInitException {
    IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
    if (input instanceof FileStoreEditorInput) {
      return (AIEEditor) IDE.openEditor(page, ((FileStoreEditorInput) input).getURI(),
          AIEEditor.EDITOR_ID, true);
    }
    return (AIEEditor) page.openEditor(input, AIEEditor.EDITOR_ID, true,
        IWorkbenchPage.MATCH_ID | IWorkbenchPage.MATCH_INPUT);
  }

  public static AIEInstanceEditor openAIEInstanceEditor(IEditorInput input)
      throws PartInitException {
    IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
    return (AIEInstanceEditor) page.openEditor(input, AIEInstanceEditor.editorID, true,
        IWorkbenchPage.MATCH_ID | IWorkbenchPage.MATCH_INPUT);
  }

  public static IEditorInput getIEditorInput(String pathName, IFile baseFile) {
    java.net.URI uri = baseFile.getLocationURI().resolve(pathName);
    IFile iFile =
        ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(new Path(uri.getPath()));
    // if iFile is null it means it is on local file system, get it from EFS
    if (iFile == null) {
      IFileStore iFileStore = EFS.getLocalFileSystem().fromLocalFile(new File(pathName));
      return new FileStoreEditorInput(iFileStore);
    }
    return new FileEditorInput(iFile);
  }

  /**
   * If path is open one of active editors, refresh the file so that editor reloads
   * 
   * @param path
   * @throws Exception
   */
  public static void refreshEditor(java.nio.file.Path path) throws Exception {
    Display.getDefault().syncExec(new Runnable() {

      @Override
      public void run() {
        try {
          IEditorReference[] editorReferences = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
              .getActivePage().getEditorReferences();
          for (int i = 0; i < editorReferences.length; i++) {
            IEditorReference reference = editorReferences[i];
            IEditorInput input = reference.getEditorInput();
            if (input instanceof FileEditorInput) {
              IFile file = ((FileEditorInput) input).getFile();
              if (file.getLocation().toOSString().equals(path.toString())) {
                file.refreshLocal(IResource.DEPTH_ONE, null);
              }
            }
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * 
   * @return {@link IFile} of each active Editor
   */
  public static List<IFile> getActiveEditorsFiles() {
    IEditorReference[] editorReferences =
        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getEditorReferences();
    return Arrays.stream(editorReferences).filter(er -> {
      try {
        return (er.getEditorInput() instanceof FileEditorInput);
      } catch (PartInitException e) {
        return false;
      }
    }).map(er2 -> {
      try {
        return ((FileEditorInput) er2.getEditorInput()).getFile();
      } catch (PartInitException e) {
        return null;
      }
    }).collect(Collectors.toList());
  }
}
