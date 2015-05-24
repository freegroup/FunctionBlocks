/*
 * Created on 23.10.2006
 *
 */
package iec61499.runtime.datatype;

import java.beans.PropertyChangeEvent;
import iec61499.runtime.AbstractFunctionBlock;


public class BOOL extends VALUE
{
  private Boolean externalValue=null;
  private Boolean internalValue=null;
  
  public BOOL(AbstractFunctionBlock fb, String name, boolean isInput)
  {
    super(fb,name, isInput);
  }
  
  public synchronized void setValue(boolean value)
  {
    this.externalValue = value;
  }
  
  public synchronized boolean getValue()
  {
    if(internalValue==null)
      return false;
    return internalValue.booleanValue();
  }

  @Override
  public void commit()
  {
    Boolean save = internalValue;
    internalValue = externalValue;
    fireValueChange(save, internalValue);
  }

  @Override
  public String toString()
  {
    return ""+internalValue;
  }

  @Override
  public void propertyChange(PropertyChangeEvent evt)
  {
	if(evt!=null && evt.getNewValue()!=null)
		this.setValue(((Boolean)evt.getNewValue()).booleanValue());
  }
  
}
