/*
 * Created on 24.10.2006
 *
 */
package iec61499.runtime.ui.out;

import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import iec61499.runtime.datatype.BOOL;
import iec61499.runtime.datatype.EVENT;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

public class ValueCheckBox extends JCheckBox implements PropertyChangeListener
{
  BOOL value;
  public ValueCheckBox(BOOL value)
  {
    this.value = value;
    this.value.addPropertyChangeListener(this);
    setIcon(createImageIcon("red.png","High"));
    setBackground(Color.white);
  }

  public void propertyChange(PropertyChangeEvent evt)
  {
    if(value.getValue())
      setIcon(createImageIcon("green.png","High"));
    else
      setIcon(createImageIcon("red.png","High"));
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
