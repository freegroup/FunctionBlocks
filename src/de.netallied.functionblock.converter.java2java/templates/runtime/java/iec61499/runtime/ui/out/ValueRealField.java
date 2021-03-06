/*
 * Created on 24.10.2006
 *
 */
package iec61499.runtime.ui.out;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import iec61499.runtime.datatype.BOOL;
import iec61499.runtime.datatype.REAL;
import iec61499.runtime.datatype.VALUE;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class ValueRealField extends JTextField implements PropertyChangeListener
{
  REAL value;
  
  public ValueRealField(REAL value)
  {
    this.value = value;
    this.value.addPropertyChangeListener(this); 
    this.setEditable(false);
  }

  public void propertyChange(PropertyChangeEvent evt)
  {
    setText(value.toString());
  }
}
