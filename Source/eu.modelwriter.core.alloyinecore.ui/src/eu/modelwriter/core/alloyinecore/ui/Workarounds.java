/**
 * 
 */
package eu.modelwriter.core.alloyinecore.ui;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.eclipse.swt.widgets.Display;

/**
 * @author ferhat
 *
 */
public final class Workarounds {
  public static void doubleAltKeyPressed() {
    Robot r = null;
    try {
      r = new Robot();
    } catch (AWTException e) {
      e.printStackTrace();
    }
    int keyCode = KeyEvent.VK_ALT; // the ALT key
    r.keyPress(keyCode);
    r.keyRelease(keyCode);
    r.keyPress(keyCode);
    r.keyRelease(keyCode);

    if (Display.getDefault() != null) {
      if (Display.getDefault().getActiveShell() != null)
        Display.getDefault().getActiveShell().setFocus();
      else
        System.err.println("Display.getDefault().getActiveShell() is null!");
    } else
      System.err.println("Display.getDefault() is null!");
  }
}
