package eu.modelwriter.core.alloyinecore.ui.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import eu.modelwriter.core.alloyinecore.ui.Activator;

public class AIEPrefInitializer extends AbstractPreferenceInitializer {

  public AIEPrefInitializer() {}

  @Override
  public void initializeDefaultPreferences() {
    IPreferenceStore store = Activator.getDefault().getPreferenceStore();
    store.setDefault(PrefConstants.TYPECHECK_SAVE_IN_JAVA_PROJECT, false);
    store.setDefault(PrefConstants.CHECK_MINIMAL_CORE, true);
    store.setDefault(PrefConstants.SYMMETRY_BREAKING, "20");
    store.setDefault(PrefConstants.NEW_UNSAT_CORE_STRATEGY, true);
    store.setDefault(PrefConstants.USE_Z3_SOLVER, false);
  }

}
