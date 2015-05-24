/*
 * Created on 24.10.2006
 *
 */
package iec61499.runtime.ui.in;

import iec61499.runtime.datatype.BOOL;
import iec61499.runtime.datatype.REAL;
import iec61499.runtime.datatype.TIME;
import iec61499.runtime.datatype.VALUE;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ValueTimeField extends JTextField
{
  TIME value;
  
  public ValueTimeField(TIME value)
  {
    this.value = value;
    this.getDocument().addDocumentListener(new DocumentListener() 
    {
    public void removeUpdate(DocumentEvent e){updateREAL();}  
    public void insertUpdate(DocumentEvent e){updateREAL();}
    public void changedUpdate(DocumentEvent e){updateREAL();}
    
    private void updateREAL()
    {
          String s = ValueTimeField.this.getText();
          try
          {
            Long b = new Long(s);
            ((TIME)(ValueTimeField.this.value)).setValue(b);
          }
          catch (Exception exc)
          {
            // TODO: handle exception
          }
    }
  });
  }
}
