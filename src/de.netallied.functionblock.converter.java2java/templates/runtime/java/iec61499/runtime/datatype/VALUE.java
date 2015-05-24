/*
 * Created on 24.10.2006
 *
 */
package iec61499.runtime.datatype;

import iec61499.runtime.AbstractFunctionBlock;

public abstract class VALUE extends ANY
{
  public VALUE(AbstractFunctionBlock fb, String name, boolean isInput)
  {
    super(name);
    if(isInput)
      fb.registerInputValue(this);
    else
      fb.registerOutputValue(this);
  }
  
  /**
   * Transfer the external value (which has been set with setValue(..)
   * to the internal state. NOW the getValue() return the new value.
   *
   */
  public abstract void commit();
  
}
