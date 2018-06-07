package eu.modelwriter.core.alloyinecore.ui;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import kodkod.ast.Formula;

public class FormulaSelectionDialog extends TitleAreaDialog {

  private Collection<Formula> formulas;
  private Formula formula;
  private Map<Button, Formula> checkBoxFormulaMap;

  public FormulaSelectionDialog(Shell parentShell, Collection<Formula> formulas) {
    super(parentShell);
    this.formulas = formulas;
    checkBoxFormulaMap = new HashMap<>();
    formula = Formula.TRUE;
  }

  @Override
  public void create() {
    super.create();
    setTitle("Formula Selection Dialog");
    setMessage("Check formulas that you think as the reason of the unsatisfiability.",
        IMessageProvider.INFORMATION);
  }

  @Override
  protected Control createDialogArea(Composite parent) {
    Composite area = (Composite) super.createDialogArea(parent);
    Composite container = new Composite(area, SWT.NONE);
    container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    GridLayout layout = new GridLayout(1, false);
    container.setLayout(layout);

    for (Formula formula : formulas) {
      Button checkBox = new Button(container, SWT.CHECK);
      checkBox.setText(formula.toString());
      checkBoxFormulaMap.put(checkBox, formula);
    }

    this.formula = Formula.and(checkBoxFormulaMap.entrySet().stream()
        .map(f -> f.getKey().getSelection() ? f.getValue().not() : f.getValue())
        .collect(Collectors.toList()));

    // Label formulaLabel = new Label(container, SWT.NONE);
    // formulaLabel.setText(formula.toString());

    SelectionAdapter selectionAdapter = new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
        FormulaSelectionDialog.this.formula = Formula.and(checkBoxFormulaMap.entrySet().stream()
            .map(f -> f.getKey().getSelection() ? f.getValue().not() : f.getValue())
            .collect(Collectors.toList()));
        // formulaLabel.setText(formula.toString());
      }
    };

    checkBoxFormulaMap.keySet().forEach(c -> c.addSelectionListener(selectionAdapter));

    return area;
  }

  @Override
  protected boolean isResizable() {
    return true;
  }

  public Formula getFormula() {
    return formula;
  }
}
