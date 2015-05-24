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

import org.eclipse.core.resources.IProject;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;
import de.netallied.functionblock.cache.ResourceTypeModelCache;
import de.netallied.functionblock.model.castor.Resource;
import de.netallied.functionblock.util.StringUtil;

public class ResourceModel extends  ObjectModel
{
  private final Resource castor;
  private ResourceTypeModel resourceType;
  private IProject project ;
  
  public ResourceModel()
  {
    this.castor = new Resource();
    this.castor.setName("any");
    this.castor.setType("anyType");
  }
  
  public ResourceModel(IProject project, ResourceTypeModel resourceType)
  {
    this.castor = new Resource();
    this.castor.setName(resourceType.getName());
    this.castor.setType(resourceType.getName());
    this.project = project;
    this.resourceType = resourceType;
  }
  

  public ResourceModel(IProject project, Resource device)
	{
		this.castor = device;
    this.project = project;
    this.resourceType = ResourceTypeModelCache.getModel(project,device.getType());
	}

  protected Resource getCastor()
  {
    return castor;
  }

  public IPropertyDescriptor[] getPropertyDescriptors()
  {
    IPropertyDescriptor[] superDescriptors = super.getPropertyDescriptors();
    IPropertyDescriptor[] descriptors = new IPropertyDescriptor[superDescriptors.length + 3];
    for (int i = 0; i < superDescriptors.length; i++)
      descriptors[i] = superDescriptors[i];
    descriptors[superDescriptors.length  ] = new TextPropertyDescriptor(ID_PROPERTY_NAME, "Name");
    descriptors[superDescriptors.length+1] = new TextPropertyDescriptor(ID_PROPERTY_TYPE, "Type");
    descriptors[superDescriptors.length+2] = new TextPropertyDescriptor(ID_PROPERTY_COMMENT, "Comment");
    
    return descriptors;
  }

  /**
   * Return the property value for the given propertyId, or null.
   * <p>
   * The property view uses the IDs from the IPropertyDescriptors array to
   * obtain the value of the corresponding properties.
   * </p>
   * 
   * @see #descriptors
   * @see #getPropertyDescriptors()
   */
  public Object getPropertyValue(Object propertyId)
  {
    if (ID_PROPERTY_NAME == propertyId)
      return getName();
    if (propertyId == ID_PROPERTY_TYPE)
      return getType();
    if (propertyId == ID_PROPERTY_COMMENT)
      return getComment();
    return super.getPropertyValue(propertyId);
  }

  public String getComment()
  {
    return StringUtil.toSaveString(castor.getComment());
  }

  public String getType()
  {
    return castor.getType();
  }

  public String getName()
  {
    return castor.getName();
  }

  /**
   * Set the property value for the given property id. If no matching id is
   * found, the call is forwarded to the superclass.
   * <p>
   * The property view uses the IDs from the IPropertyDescriptors array to set
   * the values of the corresponding properties.
   * </p>
   * 
   * @see #descriptors
   * @see #getPropertyDescriptors()
   */
  public void setPropertyValue(Object propertyId, Object value)
  {
    if(ID_PROPERTY_NAME == propertyId)
      setName((String)value);
    else if (ID_PROPERTY_ACTIONEVENT.equals(propertyId))
      setType((String)value);
    else
      super.setPropertyValue(propertyId, value);
  }

  public void setComment(String comment)
  {
    String save = getComment();
    if(save.equals(comment))
      return;
    
    castor.setComment(comment);
    firePropertyChange(PROPERTY_COMMENT_CHANGED, save,comment);
  }

  public void setType(String string)
  {
    String save = getType();
    if(save.equals(string))
      return;

    this.resourceType = ResourceTypeModelCache.getModel(project,string);
    castor.setType(string);
    firePropertyChange(PROPERTY_TYPE_CHANGED, save,string);
  }

  public void setName(String string)
  {
    String save = getName();
    
    // name doesn't changed.
    if(save.equals(string))
      return;


    castor.setName(string);
    firePropertyChange(PROPERTY_NAME_CHANGED, save,string);
  }


  public ResourceTypeModel getResourceTypeModel()
  {
    return resourceType;
  }
}
