/*
 * Created on 23.10.2006
 *
 */
package iec61499.runtime.datatype;

import java.beans.PropertyChangeEvent;
import iec61499.runtime.AbstractFunctionBlock;


public class TIME extends VALUE
{
  private Long externalValue=null;
  private Long internalValue=null;
  
  public TIME(AbstractFunctionBlock fb, String name, boolean isInput)
  {
    super(fb,name, isInput);
  }
  
  public synchronized void setValue(long value)
  {
    this.externalValue = value;
  }
  
  public synchronized float getValue()
  {
    if(internalValue==null)
      return 0;
    return internalValue;
  }

  @Override
  public void commit()
  {
    Long save = internalValue;
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
		this.setValue(((Long)evt.getNewValue()));
  }
  
}
