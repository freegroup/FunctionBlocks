/*
 * Created on 23.10.2006
 *
 */
package iec61499.runtime;

import iec61499.runtime.datatype.EVENT;
import iec61499.runtime.datatype.VALUE;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractFunctionBlock
{
  List<EVENT> inputEvents  = new ArrayList<EVENT>();
  List<EVENT> outputEvents = new ArrayList<EVENT>();
  List<VALUE> inputValues  = new ArrayList<VALUE>();
  List<VALUE> outputValues = new ArrayList<VALUE>();
  
  String name;
  public AbstractFunctionBlock(String name)
  {
    this.name = name;
  }
  
  /**
   * Calculate one step in the simulation mode
   *
   */
  public abstract void tick();
  
  public void registerInputEvent(EVENT event)
  {
    inputEvents.add( event);
  }

  public void registerOutputEvent(EVENT event)
  {
    outputEvents.add( event);
  }

  
  public void registerInputValue(VALUE value)
  {
    inputValues.add(value);
  }

  public void registerOutputValue(VALUE value)
  {
    outputValues.add(value);
  }

  public Collection<EVENT> getInputEvents()
  {
    return inputEvents;
  }

  public EVENT getEvent(String string)
  {
    for (EVENT event : inputEvents)
    {
      if(event.getName().equals(string))
        return event;
    }
    for (EVENT event : outputEvents)
    {
      if(event.getName().equals(string))
        return event;
    }
    return null;
  }
  
  public Collection<EVENT> getOutputEvents()
  {
    return outputEvents;
  }

  
  public VALUE getValue(String string)
  {
    for (VALUE value : inputValues)
    {
      if(value.getName().equals(string))
        return value;
    }
    for (VALUE value : outputValues)
    {
      if(value.getName().equals(string))
        return value;
    }
    return null;
  }

  public Collection<VALUE> getInputValues()
  {
    return inputValues;
  }
  
  public VALUE getOutputValue(String string)
  {
    for (VALUE value : outputValues)
    {
      if(value.getName().equals(string))
        return value;
    }
    return null;
  }
  
  public Collection<VALUE> getOutputValues()
  {
    return outputValues;
  }
  
  protected final void resetInputEvents()
  {
    for (EVENT in : getInputEvents())
    {
      in.setValue(false);
    }
  }
  
}
