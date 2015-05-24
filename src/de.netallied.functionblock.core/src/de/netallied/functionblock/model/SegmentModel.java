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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.ui.views.properties.ComboBoxPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;
import de.netallied.functionblock.model.castor.ECAction;
import de.netallied.functionblock.model.castor.Segment;
import de.netallied.functionblock.model.castor.VarDeclaration;
import de.netallied.functionblock.model.castor.types.VarDeclarationTypeType;
import de.netallied.functionblock.util.IntegerPropertyGroupingDescriptor;

public class SegmentModel extends  ObjectModel
{
  private final Segment castor;
  private SystemModel systemModel;
  
  public SegmentModel()
  {
    this.castor = new Segment();
    this.castor.setName("anySegment");
    this.castor.setType("anyType");
  }
  
	public SegmentModel(SystemModel systemModel, Segment segment)
	{
		this.castor = segment;
    this.systemModel = systemModel;
	}

  protected Segment getCastor()
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
    return castor.getComment();
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
    else if (ID_PROPERTY_TYPE.equals(propertyId))
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

    castor.setType(string);
    firePropertyChange(PROPERTY_TYPE_CHANGED, save,string);
  }

  public void setName(String string)
  {
    String save = getName();
    
    // name doesn't changed
    if(save.equals(string))
      return;

    // segment already exists.
    if(systemModel.getSegmentModel(string)!=null)
      return;
    
    // Es mussen VOR dem ändern des Namen alle Referenzen in den 
    // Links angepasst werden. Ansonsten finden die Link das Device nicht mehr.
    //
    for (LinkModel link : systemModel.getLinkModels(this))
    {
      link.getCastor().setSegmentName(string);
    }
    
    castor.setName(string);
    firePropertyChange(PROPERTY_NAME_CHANGED, save,string);
  }

  public Point getLocation()
  {
    return new Point(castor.getX(), castor.getY());
  }

  public Dimension getSize()
  {
    return new Dimension((int)castor.getDx1(),-1);
  }

  public List<LinkModel> getTargetConnections()
  {
    return systemModel.getLinkModels(this);
  }

  public void setSize(Dimension size)
  {
    Dimension save = getSize();
    if(save.equals(size))
      return;
    castor.setDx1(size.width);
    firePropertyChange(PROPERTY_DIMENSION_CHANGED, save,size);
  }

  public void setLocation(Point p) 
  {
    Point save = getLocation();
    if(save.equals(p))
      return;
    castor.setX(p.x);
    castor.setY(p.y);
    firePropertyChange(PROPERTY_POSITION_CHANGED, save,p);
  }

  public void removeConnection(LinkModel linkModel)
  {
    // TODO Auto-generated method stub
    
  }

  public void addConnection(LinkModel linkModel)
  {
    // TODO Auto-generated method stub
    
  }

  public SystemModel getSystemModel()
  {
    return systemModel;
  }

  public void setSystemModel(SystemModel systemModel)
  {
    this.systemModel = systemModel;
  }
}
