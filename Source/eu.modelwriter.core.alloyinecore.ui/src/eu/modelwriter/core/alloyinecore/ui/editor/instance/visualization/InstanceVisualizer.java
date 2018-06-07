package eu.modelwriter.core.alloyinecore.ui.editor.instance.visualization;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.JComponent;
import javax.swing.JPanel;
import org.eclipse.ui.IEditorInput;
import edu.mit.csail.sdg.alloy4.ErrorFatal;
import edu.mit.csail.sdg.alloy4graph.GraphViewer;
import eu.modelwriter.core.alloyinecore.ui.editor.instance.visualization.model.Atom;
import eu.modelwriter.core.alloyinecore.ui.editor.instance.visualization.model.Universe;

public abstract class InstanceVisualizer {

  protected JComponent component;
  protected GraphViewer panel;
  protected IEditorInput input;
  protected Universe universe;
  protected MouseAdapter mouseAdapter;

  public InstanceVisualizer(IEditorInput input) throws ErrorFatal, IOException {
    this.input = input;
    this.component = new JPanel();
    this.universe = null;

    createUniverse();
    createGraph();
  }

  protected abstract void createUniverse() throws IOException;

  protected void createGraph() throws ErrorFatal {
    this.panel = (GraphViewer) GraphMaker.produceGraph(universe);

    panel.addMouseListener(this.mouseAdapter = new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
          Object obj = panel.alloyGetAnnotationAtXY(e.getX(), e.getY());

          if (obj instanceof Atom)
            doubleClickedOn((Atom) obj);
        }
      }
    });
  }

  protected abstract void doubleClickedOn(Atom obj);

  public JComponent getComponent() {
    return panel;
  }
}
