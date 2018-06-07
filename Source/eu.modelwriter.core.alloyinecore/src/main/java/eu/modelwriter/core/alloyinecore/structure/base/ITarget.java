package eu.modelwriter.core.alloyinecore.structure.base;

import eu.modelwriter.core.alloyinecore.structure.model.Import;
import eu.modelwriter.core.alloyinecore.structure.model.Model;
import eu.modelwriter.core.alloyinecore.structure.model.Package;
import eu.modelwriter.core.alloyinecore.structure.model.RootPackage;

import java.util.List;
import java.util.stream.Collectors;

public interface ITarget extends ISegment {

    default List<ISource> getSources() {
        Element<?> model = this.getOwner().getOwner(Model.class);
        return model.getAllOwnedElements().stream()
                .filter(e -> e instanceof ISource)
                .map(ISource.class::cast)
                .collect(Collectors.toList());
    }

    @Deprecated
    default String getRelativeSegment() {
        return this.getFullSegment();
    }

    /**
     * Skips root imported package for imported class and data types.
     *
     * @return Import relative segment if object is imported else full segment
     */
    default String getImportedSegment() {
        String path = this.getSegment();
        if (!asElement().isImported())
            return this.getFullSegment();

        for (Element parent = this.getOwner(); parent != null; parent = parent.getOwner()) {
            if (parent instanceof ISegment) {
                // Skip root package, we don't use it in imported paths (segments)
                if (parent instanceof RootPackage)
                    continue;
                String parentsPathName = ((ISegment) parent).getSegment();
                if (!parentsPathName.isEmpty())
                    path = parentsPathName + "::" + path;
                if (parent instanceof Import) break;
            }
        }
        return path;
    }

    /**
     * @return root package relative segment
     */
    default String getRootRelativeSegment() {
        String path = this.getSegment();
        for (Element parent = this.getOwner();
             parent != null && !(parent instanceof RootPackage);
             parent = parent.getOwner()) {
            if (parent instanceof ISegment) {
                String parentsPathName = ((ISegment) parent).getSegment();
                if (!parentsPathName.isEmpty()) {
                    path = parentsPathName + "::" + path;
                }
            }
        }
        return path;
    }

    /**
     * @return full segment to the root package (including root package)
     */
    default String getFullSegment() {
        String path = this.getSegment();
        for (Element parent = this.getOwner(); parent != null && !(parent instanceof Model); parent = parent.getOwner()) {
            if (parent instanceof ISegment) {
                String parentsPathName = ((ISegment) parent).getSegment();
                if (!parentsPathName.isEmpty()) {
                    path = parentsPathName + "::" + path;
                }
            }
        }
        return path;
    }

    /**
     * If ITarget and element are in same package returns last segment, if ITarget's package is subpackage of element's
     * returns
     *
     * @param element to get relative segment to
     * @return relative segment to given element
     */
    default String getRelativeSegment(Element element) {
        if (asElement().isImported())
            return this.getImportedSegment();

        Element elementPack = element.getOwner(Package.class);
        Element thisPack = ((Element) this).getOwner(Package.class);
        if (thisPack != null && elementPack != null) {
            if (elementPack.equals(thisPack))
                return this.getSegment();
            if (elementPack.getAllOwnedElements(Package.class, true).contains(thisPack))
                return this.getRootRelativeSegment();
        }
        return this.getFullSegment();
    }

    default boolean isEquals(String pathName) {
        return this.getSegment().equals(pathName) ||
                this.getImportedSegment().equals(pathName) ||
                this.getRootRelativeSegment().equals(pathName) ||
                this.getFullSegment().equals(pathName);
    }
}
