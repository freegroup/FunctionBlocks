/*
 * Created on 24.10.2006
 *
 */
package iec61499.runtime.ui.in;

import iec61499.runtime.datatype.BOOL;
import iec61499.runtime.datatype.VALUE;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class ValueTextField extends JTextField
{
  VALUE value;
  
  public ValueTextField(VALUE value)
  {
    this.value = value;
    this.addCaretListener(new CaretListener()
    {
      public void caretUpdate(CaretEvent e)
      {
        String s = ValueTextField.this.getText();
        try
        {
          Boolean b = new Boolean(s);
          ((BOOL)(ValueTextField.this.value)).setValue(b.booleanValue());
        }
        catch (Exception exc)
        {
          // TODO: handle exception
        }
      }
    });
  }
}
