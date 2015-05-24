/*******************************************************************************
 * Copyright (c) 2005, 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
/*
 * Created on 26.11.2005
 *
 */
package de.netallied.functionblock.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;

public abstract class ObjectModel  implements IPropertySource
{
  public static String START_NODE_ID ="START";

  public static final String PROPERTY_CHILD_REORDER      = "REORDER";
  public final static String PROPERTY_NAME_CHANGED       = "name changed";
  public final static String PROPERTY_WITH_ADDED         = "[with] added";
  public final static String PROPERTY_WITH_REMOVED       = "[with] removed";
  public final static String PROPERTY_COMMENT_CHANGED    = "commnet changed";
  public final static String PROPERTY_VALUE_CHANGED      = "value changed";
  public final static String PROPERTY_EVENT_CHANGED      = "event assignment changed";
  public final static String PROPERTY_ALGORITHM_CHANGED  = "algorithm changed";
  public final static String PROPERTY_TYPE_CHANGED       = "type changed";
  public final static String PROPERTY_CONDITION_CHANGED  = "condition changed";
  public final static String PROPERTY_PARAMETERS_CHANGED ="parameters of BO changed";
  public final static String SOURCE_CONNECTIONS_PROP = "ECCAbstractStateModel.SourceConn";
  public final static String TARGET_CONNECTIONS_PROP = "ECCAbstractStateModel.TargetConn";
  public final static String PROPERTY_POSITION_CHANGED = "position changed";
  public final static String PROPERTY_DIMENSION_CHANGED = "dimension changed";
  public final static String PROPERTY_ELEMENT_ADDED    = "element added";
  public final static String PROPERTY_ELEMENT_REMOVED  = "element removed";
  


  protected static final String ID_PROPERTY_X               = "x-pos";
  protected static final String ID_PROPERTY_Y               = "y-pos";
  protected static final String ID_PROPERTY_NAME            = "name";
  protected static final String ID_PROPERTY_CONDITION       = "condition";
  protected static final String ID_PROPERTY_TYPE            = "type";
  protected static final String ID_PROPERTY_VALUE           = "value";
  protected static final String ID_PROPERTY_COMMENT         = "comment";
  protected static final String ID_PROPERTY_ALGORITHM       = "algorithm";
  protected static final String ID_PROPERTY_ACTIONEVENT     = "action event";
  
  private PropertyChangeSupport listeners;
  private IPropertyDescriptor[] descriptors;
  
  public ObjectModel()
  {
    listeners = new PropertyChangeSupport(this);
    
  }
  
  public void addPropertyChangeListener(PropertyChangeListener listener)
  {
    listeners.addPropertyChangeListener(listener);
  }

  public void removePropertyChangeListener(PropertyChangeListener listener)
  {
    listeners.removePropertyChangeListener(listener);
  }

  public void firePropertyChange(String propertyName, Object oldValue, Object newValue)
  {
   listeners.firePropertyChange(propertyName, oldValue, newValue);
  }
  
  public IPropertyDescriptor[] getPropertyDescriptors()
  {
    if (descriptors == null)
      descriptors = new IPropertyDescriptor[0];
    return descriptors;
  }

  public Object getPropertyValue(Object propName)
  {
    return null;
  }

  /*
   * final Object getPropertyValue(String propName) { return null; }
   */
  public boolean isPropertySet(Object propName)
  {
    return true;
  }

  public Object getEditableValue()
  {
    return this;
  }
  
  /*
   * final boolean isPropertySet(String propName) { return true; }
   */
  public void resetPropertyValue(Object propName)
  {
  }

  public void setPropertyValue(Object propName, Object val)
  {
  }
}
