/*
 * Created on 23.10.2006
 *
 */
package iec61499.runtime.datatype;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;
import iec61499.runtime.AbstractFunctionBlock;

public class EVENT extends ANY
{
  public boolean value;
  public List<EVENT> listeners = new ArrayList<EVENT>();
  
  public EVENT(AbstractFunctionBlock fb, String name, boolean isInput)
  {
    super(name);
    if(isInput)
      fb.registerInputEvent(this);
    else
      fb.registerOutputEvent(this);
  }

  public synchronized boolean getValue()
  {
    return value;
  }
  
  public synchronized void setValue(boolean value)
  {
    boolean save = getValue();
    this.value= value;
    fireValueChange(new Boolean(save), new Boolean(value));
  }

  @Override
  public void propertyChange(PropertyChangeEvent evt)
  {
    this.setValue(((Boolean)evt.getNewValue()).booleanValue());
  }
}
