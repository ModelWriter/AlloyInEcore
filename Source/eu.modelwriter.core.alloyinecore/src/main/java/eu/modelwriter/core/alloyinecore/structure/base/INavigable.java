package eu.modelwriter.core.alloyinecore.structure.base;

import java.util.List;

public interface INavigable {

    default Element<?> asElement() {
        return (Element<?>) this;
    }

    Element getOwner();

    String getPathName();

    default ITarget getTarget() {
        String pathName = this.getPathName();
        Element<?> owner = this.getOwner();
        ITarget target = null;
        while (owner != null && target == null) {
            List<ITarget> ownedElements = owner.getAllOwnedElements(ITarget.class, true);
            target = ownedElements.stream()
                    .filter(t -> t.isEquals(pathName))
                    .findFirst()
                    .orElse(null);
            owner = owner.getOwner();
        }
        return target;
    }
}
