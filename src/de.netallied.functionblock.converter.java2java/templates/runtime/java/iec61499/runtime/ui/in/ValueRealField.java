/*
 * Created on 24.10.2006
 *
 */
package iec61499.runtime.ui.in;

import iec61499.runtime.datatype.BOOL;
import iec61499.runtime.datatype.REAL;
import iec61499.runtime.datatype.VALUE;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ValueRealField extends JTextField
{
  REAL value;
  
  public ValueRealField(REAL value)
  {
    this.value = value;
    this.getDocument().addDocumentListener(new DocumentListener() 
    {
    public void removeUpdate(DocumentEvent e){updateREAL();}  
    public void insertUpdate(DocumentEvent e){updateREAL();}
    public void changedUpdate(DocumentEvent e){updateREAL();}
    
    private void updateREAL()
    {
          String s = ValueRealField.this.getText();
          try
          {
            Float b = new Float(s);
            ((REAL)(ValueRealField.this.value)).setValue(b.floatValue());
          }
          catch (Exception exc)
          {
            // TODO: handle exception
          }
    }
  });
  }
}
