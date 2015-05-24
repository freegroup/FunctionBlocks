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
package de.netallied.functionblock.model;

import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;
import de.netallied.functionblock.Activator;

public abstract class AbstractNamedModel extends ObjectModel implements INamedModel
{
  public IPropertyDescriptor[] getPropertyDescriptors()
  {
    IPropertyDescriptor[] superDescriptors = super.getPropertyDescriptors();
    IPropertyDescriptor[] descriptors = new IPropertyDescriptor[superDescriptors.length + 2];
    for (int i = 0; i < superDescriptors.length; i++)
      descriptors[i] = superDescriptors[i];
    descriptors[superDescriptors.length]   = new TextPropertyDescriptor(ID_PROPERTY_NAME,    "Name");
    descriptors[superDescriptors.length+1] = new TextPropertyDescriptor(ID_PROPERTY_COMMENT, "Comment");
    
    return descriptors;
  }
  
  public void setPropertyValue(Object propName, Object val)
  {
    try 
    {
      if (propName instanceof String && ((String) propName).equals(ID_PROPERTY_NAME))
        setName((String) val);
      else if (propName instanceof String && ((String) propName).equals(ID_PROPERTY_COMMENT))
        setComment((String) val);
      else
        super.setPropertyValue(propName, val);
    } 
    catch (Exception e) 
    {
      Activator.getDefault().showException(e);
    }
  }
  
  public Object getPropertyValue(Object propName)
  {
    if (propName instanceof String && ((String) propName).equals(ID_PROPERTY_NAME))
      return getName();
    if (propName instanceof String && ((String) propName).equals(ID_PROPERTY_COMMENT))
      return getComment();
    else
      return super.getPropertyValue(propName);
  }
}
