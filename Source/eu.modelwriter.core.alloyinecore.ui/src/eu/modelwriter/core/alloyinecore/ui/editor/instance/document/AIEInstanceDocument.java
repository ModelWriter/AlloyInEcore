package eu.modelwriter.core.alloyinecore.ui.editor.instance.document;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.text.rules.FastPartitioner;
import org.eclipse.ui.part.FileEditorInput;

import eu.modelwriter.core.alloyinecore.instance.mapping.cs2as.InstanceCS2ASMapping;
import eu.modelwriter.core.alloyinecore.ui.editor.document.AIEDocument;
import eu.modelwriter.core.alloyinecore.ui.editor.instance.scanner.KeywordListener;
import eu.modelwriter.core.alloyinecore.ui.editor.partition.IAIEPartitions;
import eu.modelwriter.core.alloyinecore.ui.editor.scanner.AIEPartitionScanner;

public class AIEInstanceDocument extends AIEDocument {
  private EObject instanceRoot;
  private IFile iFile;
  private final Set<String> sfKeywords = new HashSet<>();
  private final Set<String> keywords = new HashSet<>();
  private final InstanceCS2ASMapping mapping;
  private final FastPartitioner partitioner;

  public AIEInstanceDocument() {
    mapping = new InstanceCS2ASMapping();
    partitioner = new FastPartitioner(new AIEPartitionScanner(), IAIEPartitions.ALL_PARTITIONS);
    partitioner.connect(this);
    this.setDocumentPartitioner(IAIEPartitions.AIE_PARTITIONING, partitioner);
  }

  public void setInstanceRoot(final EObject instanceRoot, final KeywordListener keywordListener) {
    this.instanceRoot = instanceRoot;
    collectKeywords(instanceRoot);
    keywordListener.onKeywordsCollected(keywords, sfKeywords);
  }

  private void collectKeywords(final EObject eObject) {
    final TreeIterator<EObject> iterator = eObject.eAllContents();
    while (iterator.hasNext()) {
      final EObject next = iterator.next();
      keywords.add(next.eClass().getName());
      for (final EStructuralFeature sf : next.eClass().getEAllStructuralFeatures()) {
        sfKeywords.add(sf.getName());
      }
      final ENamedElement container = (ENamedElement) next.eClass().eContainer();
      if (container != null) {
        keywords.add(container.getName());
      }
    }
    keywords.add(eObject.eClass().getName());
    for (final EStructuralFeature sf : eObject.eClass().getEAllStructuralFeatures()) {
      sfKeywords.add(sf.getName());
    }
  }

  /**
   * 
   * @return current ecore object
   */
  @Override
  public EObject getEcoreRoot() {
    return instanceRoot;
  }

  @Override
  public IFile getiFile() {
    return iFile;
  }

  /**
   * Saves editor input to current ecore instance file.
   * 
   * @param overwrite
   * @param element
   * 
   * @return true if succeed.
   */
  @Override
  public EObject saveInEcore(final Object element, final boolean overwrite) {
    if (overwrite) { // Save as
      if (element instanceof FileEditorInput) {
        return mapping.parseAndSave(get(),
            URI.createFileURI(((FileEditorInput) element).getFile().getFullPath().toString()));
      }
    } else { // Save
      return mapping.parseAndSave(get(),
          URI.createPlatformResourceURI(iFile.getFullPath().toString(), true));
    }
    return null;
  }

  @Override
  public void setFile(final IFile iFile) {
    this.iFile = iFile;
  }
}
