package eu.modelwriter.core.alloyinecore.ui.editor.instance.document;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.editors.text.FileDocumentProvider;
import org.eclipse.ui.ide.FileStoreEditorInput;
import org.eclipse.ui.part.FileEditorInput;

import eu.modelwriter.core.alloyinecore.translator.EcoreInstanceTranslator;
import eu.modelwriter.core.alloyinecore.ui.TextEditorInput;
import eu.modelwriter.core.alloyinecore.ui.editor.document.AIEDocument;
import eu.modelwriter.core.alloyinecore.ui.editor.instance.scanner.KeywordListener;
import eu.modelwriter.core.alloyinecore.ui.mapping.EcoreUtilities;

public class AIEInstanceDocumentProvider extends FileDocumentProvider {
	private final EcoreInstanceTranslator translator;
	private KeywordListener keywordListener;

	public AIEInstanceDocumentProvider() {
		translator = new EcoreInstanceTranslator();
	}

	public void setKeywordListener(final KeywordListener keywordListener) {
		this.keywordListener = keywordListener;
	}

	@Override
	protected IDocument createDocument(final Object element) throws CoreException {
		final IDocument document = createEmptyDocument();
		if (document != null) {
			setContent(document, (FileEditorInput) element);
		}
		return document;
	}

	private boolean setContent(final IDocument document, final IEditorInput editorInput) {
		try {
			IFile iFile = null;
			if (editorInput instanceof FileEditorInput) {
				iFile = ((FileEditorInput) editorInput).getFile();
			}
			if (editorInput instanceof FileStoreEditorInput) {
				final String path = ((FileStoreEditorInput) editorInput).getURI().getPath();
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
			if (iFile == null) {
				return false;
			}

			final Resource resource = EcoreUtilities.loadInstanceModel(iFile.getFullPath().toString());
			if (resource != null && !resource.getContents().isEmpty()) {
				final EObject instanceRoot = resource.getContents().get(0);
				document.set(translator.translate(instanceRoot));
				if (document instanceof AIEInstanceDocument) {
					((AIEInstanceDocument) document).setInstanceRoot(instanceRoot, keywordListener);
					((AIEInstanceDocument) document).setFile(iFile);
				}
				return true;
			} else {
				throw new Exception("Resource is null or empty. " + resource.getErrors());
			}
		} catch (final Exception e) {
			e.printStackTrace();
			document.set("");
		}
		return false;
	}

	@Override
	protected IDocument createEmptyDocument() {
		return new AIEInstanceDocument();
	}

	@Override
	protected boolean setDocumentContent(final IDocument document, final IEditorInput editorInput,
			final String encoding) throws CoreException {
		setContent(document, editorInput);
		return true;
	}

	@Override
	protected void doSaveDocument(final IProgressMonitor monitor, final Object element, final IDocument document,
			final boolean overwrite) throws CoreException {
		if (document instanceof AIEInstanceDocument) {
			((AIEInstanceDocument) document).saveInEcore(element, overwrite);
		}
	}
}
