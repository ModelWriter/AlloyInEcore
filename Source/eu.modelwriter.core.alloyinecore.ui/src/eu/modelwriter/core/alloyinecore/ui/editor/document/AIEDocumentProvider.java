package eu.modelwriter.core.alloyinecore.ui.editor.document;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.editors.text.FileDocumentProvider;
import org.eclipse.ui.ide.FileStoreEditorInput;
import org.eclipse.ui.part.FileEditorInput;

import eu.modelwriter.core.alloyinecore.internal.AIEConstants;
import eu.modelwriter.core.alloyinecore.internal.AnnotationSources;
import eu.modelwriter.core.alloyinecore.translator.EcoreTranslator;
import eu.modelwriter.core.alloyinecore.ui.TextEditorInput;
import eu.modelwriter.core.alloyinecore.ui.mapping.EcoreUtilities;

public class AIEDocumentProvider extends FileDocumentProvider {
  private final EcoreTranslator translator;

  public AIEDocumentProvider() {
    translator = new EcoreTranslator();
  }

  @Override
  protected IDocument createDocument(final Object element) throws CoreException {
    final IDocument document = createEmptyDocument();
    if (document != null) {
      setContent(document, element);
    }
    return document;
  }

  private boolean setContent(final IDocument document, final Object editorInput) {
    try {
      IFile iFile = null;
      if (editorInput instanceof FileEditorInput)
        iFile = ((FileEditorInput) editorInput).getFile();
      if (editorInput instanceof FileStoreEditorInput) {
        String path = ((FileStoreEditorInput) editorInput).getURI().getPath();
        iFile = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(path));
      }
      if (editorInput instanceof TextEditorInput) {
        document.set(((TextEditorInput) editorInput).getText());
        if (document instanceof AIEDocument) {
          ((AIEDocument) document).setFile(((TextEditorInput) editorInput).getFile());
        }
        return true;
      }
      // No file, no content
      if (iFile == null)
        return false;

      String path = iFile.getFullPath().toOSString();
      final EModelElement ecoreRoot = (EModelElement) EcoreUtilities.getRootObject(path);
      // No ecoreRoot, no content
      if (ecoreRoot == null) {
        return false;
      }

      EAnnotation sourceAnno = ecoreRoot.getEAnnotation(AnnotationSources.SOURCE);
      // Check hash
      if (sourceAnno != null
          && sourceAnno.getDetails().get(AIEConstants.SOURCE_HASH.toString()) != null) {
        ecoreRoot.getEAnnotations().remove(sourceAnno);
        String string = getString(ecoreRoot,
            URI.createPlatformResourceURI(iFile.getFullPath().toString(), true));
        ecoreRoot.getEAnnotations().add(sourceAnno);
        // If hashes are different, ask if user wants to reset
        if (!sourceAnno.getDetails().get(AIEConstants.SOURCE_HASH.toString())
            .equals(string.hashCode() + "")) {
          return translate(document, iFile, ecoreRoot);
        }
      }
      // Reload from source annotation
      if (sourceAnno != null
          && sourceAnno.getDetails().get(AIEConstants.SOURCE.toString()) != null) {
        document.set(sourceAnno.getDetails().get(AIEConstants.SOURCE.toString()));
        if (document instanceof AIEDocument) {
          ((AIEDocument) document).setEcoreRoot(ecoreRoot);
          ((AIEDocument) document).setFile(iFile);
        }
        return true;
      }
      return translate(document, iFile, ecoreRoot);
    } catch (final Exception e) {
      e.printStackTrace();
      document.set("");
    }
    return false;
  }

  private boolean translate(final IDocument document, final IFile iFile,
      final EModelElement ecoreRoot) {
    ecoreRoot.getEAnnotations().removeIf(a -> a.getSource().equals(AnnotationSources.SOURCE));
    document.set(translator.translate(ecoreRoot));
    if (document instanceof AIEDocument) {
      ((AIEDocument) document).setEcoreRoot(ecoreRoot);
      ((AIEDocument) document).setFile(iFile);
    }
    return true;
  }

  @Override
  protected IDocument createEmptyDocument() {
    return new AIEDocument();
  }

  @Override
  protected boolean setDocumentContent(final IDocument document, final IEditorInput editorInput,
      final String encoding) throws CoreException {
    return setContent(document, editorInput);
  }

  @Override
  protected void doSaveDocument(final IProgressMonitor monitor, final Object element,
      final IDocument document, final boolean overwrite) throws CoreException {
    if (document instanceof AIEDocument) {
      ((AIEDocument) document).saveInEcore(element, overwrite);
    }
  }

  public static String getString(final EObject root, final URI saveURI) {
    ResourceSetImpl resourceSet = new ResourceSetImpl();
    resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
        .put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
    final Resource resource = resourceSet.getResource(saveURI, true);
    resource.getContents().clear();
    resource.getContents().add(root);
    ByteArrayOutputStream stream = new ByteArrayOutputStream();
    try {
      resource.save(stream, null);
      return new String(stream.toByteArray());
    } catch (final IOException e) {
      e.printStackTrace();
    }
    return "";
  }

}
