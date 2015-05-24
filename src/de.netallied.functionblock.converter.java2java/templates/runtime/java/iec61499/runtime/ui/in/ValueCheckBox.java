/*
 * Created on 24.10.2006
 *
 */
package iec61499.runtime.ui.in;

import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import iec61499.runtime.datatype.BOOL;
import iec61499.runtime.datatype.EVENT;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ValueCheckBox extends JCheckBox  
{
  BOOL value;
  public ValueCheckBox(BOOL value)
  {
    this.value = value;
    this.addChangeListener(new ChangeListener()
    {
      public void stateChanged(ChangeEvent e)
      {
        boolean s = ValueCheckBox.this.isSelected();
        ((BOOL)(ValueCheckBox.this.value)).setValue(s);
        if(s)
          setIcon(createImageIcon("green.png","High"));
        else
          setIcon(createImageIcon("red.png","High"));
      }
    });
    setIcon(createImageIcon("red.png","High"));
    setBackground(Color.white);
  }

  protected static ImageIcon createImageIcon(String path,String description) 
  {
    java.net.URL imgURL = ValueCheckBox.class.getResource(path);
    if (imgURL != null) 
    {
        return new ImageIcon(imgURL, description);
    } 
    else 
    {
      System.err.println("Couldn't find file: " + path);
      return null;
    }
  }
  
}
