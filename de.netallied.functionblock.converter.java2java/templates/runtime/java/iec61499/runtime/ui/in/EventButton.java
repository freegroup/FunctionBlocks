/*
 * Created on 24.10.2006
 *
 */
package iec61499.runtime.ui.in;

import iec61499.runtime.datatype.EVENT;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class EventButton extends JButton
{
  public EventButton(final EVENT event)
  {
    this.addMouseListener(new MouseAdapter() 
    {
      public void mouseReleased(MouseEvent e) 
      {
            event.setValue(false);
      }
    
      public void mousePressed(MouseEvent e) 
      {
            event.setValue(true);
      }
    });
  }
}
