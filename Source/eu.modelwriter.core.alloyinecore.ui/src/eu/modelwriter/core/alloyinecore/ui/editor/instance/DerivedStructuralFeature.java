package eu.modelwriter.core.alloyinecore.ui.editor.instance;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Internal.SettingDelegate;
import org.eclipse.emf.ecore.EStructuralFeature.Internal.SettingDelegate.Factory;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.BasicSettingDelegate;

public class DerivedStructuralFeature implements Factory {

  public DerivedStructuralFeature() {}

  @Override
  public SettingDelegate createSettingDelegate(EStructuralFeature eStructuralFeature) {
    return new BasicSettingDelegate.Stateless(eStructuralFeature) {

      @Override
      protected Object get(InternalEObject owner, boolean resolve, boolean coreType) {
        return null;
      }

      @Override
      protected boolean isSet(InternalEObject owner) {
        // TODO Auto-generated method stub
        return false;
      }

      @Override
      protected void set(InternalEObject owner, Object newValue) {
        // TODO Auto-generated method stub
        super.set(owner, newValue);
      }

    };
  }

}
