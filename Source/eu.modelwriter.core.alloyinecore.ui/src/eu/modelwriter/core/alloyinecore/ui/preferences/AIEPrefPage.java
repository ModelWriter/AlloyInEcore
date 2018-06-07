package eu.modelwriter.core.alloyinecore.ui.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import eu.modelwriter.core.alloyinecore.ui.Activator;

public class AIEPrefPage extends PreferencePage implements IWorkbenchPreferencePage {

  private Button typeCheckSave;
  private Button checkMinimalCore;
  private Button newUnsatCoreStrategy;
  private Button useZ3Solver;
  private Text symmetryBreaking;

  public AIEPrefPage() {}

  public AIEPrefPage(String title) {
    super(title);
  }

  public AIEPrefPage(String title, ImageDescriptor image) {
    super(title, image);
  }

  @Override
  public void init(IWorkbench workbench) {

  }

  @Override
  public boolean performOk() {
    storeValues();
    return super.performOk();
  }

  @Override
  protected void performApply() {
    storeValues();
    super.performApply();
  }

  @Override
  protected void performDefaults() {
    IPreferenceStore store = getPreferenceStore();
    typeCheckSave
        .setSelection(store.getDefaultBoolean(PrefConstants.TYPECHECK_SAVE_IN_JAVA_PROJECT));
    checkMinimalCore.setSelection(store.getDefaultBoolean(PrefConstants.CHECK_MINIMAL_CORE));
    newUnsatCoreStrategy
        .setSelection(store.getDefaultBoolean(PrefConstants.NEW_UNSAT_CORE_STRATEGY));
    useZ3Solver.setSelection(store.getDefaultBoolean(PrefConstants.USE_Z3_SOLVER));
    symmetryBreaking.setText(store.getDefaultString(PrefConstants.SYMMETRY_BREAKING));
    super.performDefaults();
  }

  @Override
  protected IPreferenceStore doGetPreferenceStore() {
    return Activator.getDefault().getPreferenceStore();
  }

  @Override
  protected Control createContents(Composite parent) {
    IPreferenceStore store = getPreferenceStore();
    Composite container = new Composite(parent, SWT.NULL);
    container.setLayout(new RowLayout(SWT.VERTICAL));

    Label labelTypeCheckInJavaProject = new Label(container, SWT.NONE);
    labelTypeCheckInJavaProject.setText("Type Checking");
    typeCheckSave = new Button(container, SWT.CHECK);
    typeCheckSave.setText("Save type checking outputs into a Java project");
    typeCheckSave.setSelection(store.getBoolean(PrefConstants.TYPECHECK_SAVE_IN_JAVA_PROJECT));

    Label labelCheckMinimalCore = new Label(container, SWT.NONE);
    labelCheckMinimalCore.setText("Check Minimal Core");
    checkMinimalCore = new Button(container, SWT.CHECK);
    checkMinimalCore.setText("Check minimality of the unsat core");
    checkMinimalCore.setSelection(store.getBoolean(PrefConstants.CHECK_MINIMAL_CORE));

    Label labelSymmetryBreaking = new Label(container, SWT.NONE);
    labelSymmetryBreaking.setText("Symmetry Breaking [0..Integer.MAX]");
    symmetryBreaking = new Text(container, SWT.BORDER);
    symmetryBreaking.setText(store.getString(PrefConstants.SYMMETRY_BREAKING));

    Label labelNewUnsatCoreStrategy = new Label(container, SWT.NONE);
    labelNewUnsatCoreStrategy.setText("New Unsat Core Strategy");
    newUnsatCoreStrategy = new Button(container, SWT.CHECK);
    newUnsatCoreStrategy.setText("Use new unsat core strategy");
    newUnsatCoreStrategy.setSelection(store.getBoolean(PrefConstants.NEW_UNSAT_CORE_STRATEGY));
    
    Label labelUseZ3Solver = new Label(container, SWT.NONE);
    labelUseZ3Solver.setText("Z3 Solver");
    useZ3Solver = new Button(container, SWT.CHECK);
    useZ3Solver.setText("Use Z3 Solver");
    useZ3Solver.setSelection(store.getBoolean(PrefConstants.USE_Z3_SOLVER));

    return container;
  }

  public void storeValues() {
    IPreferenceStore store = getPreferenceStore();
    store.setValue(PrefConstants.TYPECHECK_SAVE_IN_JAVA_PROJECT, typeCheckSave.getSelection());
    store.setValue(PrefConstants.CHECK_MINIMAL_CORE, checkMinimalCore.getSelection());
    store.setValue(PrefConstants.SYMMETRY_BREAKING, symmetryBreaking.getText());
    store.setValue(PrefConstants.NEW_UNSAT_CORE_STRATEGY, newUnsatCoreStrategy.getSelection());
    store.setValue(PrefConstants.USE_Z3_SOLVER, useZ3Solver.getSelection());
  }

}
