/*
 * Created on 23.10.2006
 *
 */
package iec61499.runtime.datatype;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public abstract class ANY implements PropertyChangeListener
{
  private PropertyChangeSupport listeners;
  protected final String name;
  
  public abstract void propertyChange(PropertyChangeEvent evt);

  public ANY(String name)
  {
    this.name = name;
    listeners = new PropertyChangeSupport(this);
  }
  
  public String getName()
  {
    return name;
  }

  public void addPropertyChangeListener(PropertyChangeListener listener)
  {
    listeners.addPropertyChangeListener(listener);
  }

  public void removePropertyChangeListener(PropertyChangeListener listener)
  {
    listeners.removePropertyChangeListener(listener);
  }

  protected void fireValueChange(Object oldValue, Object newValue)
  {
   listeners.firePropertyChange("ValueChanged", oldValue, newValue);
  }


}
