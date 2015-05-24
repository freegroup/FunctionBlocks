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
import java.util.List;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;
import de.netallied.functionblock.model.castor.Event;
import de.netallied.functionblock.model.castor.With;

public abstract class AbstractEventModel extends AbstractInterfaceModel
{
	private final Event castor;
  private final AbstractFunctionBlockModel functionBlockModel;
  
	public AbstractEventModel(AbstractFunctionBlockModel parent, Event event)
	{
		this.castor = event;
    this.functionBlockModel = parent;
	}
	
  public abstract List<AbstractValueModel> getWithElements();
  
  public IPropertyDescriptor[] getPropertyDescriptors()
  {
    IPropertyDescriptor[] superDescriptors = super.getPropertyDescriptors();
    IPropertyDescriptor[] descriptors = new IPropertyDescriptor[superDescriptors.length + 1];
    for (int i = 0; i < superDescriptors.length; i++)
      descriptors[i] = superDescriptors[i];
    descriptors[superDescriptors.length]   = new TextPropertyDescriptor(ID_PROPERTY_TYPE, "Type");
    
    return descriptors;
  }
  
  public void addWithElement(AbstractValueModel valueModel)
  {
    With with = new With();
    with.setVar(valueModel.getName());
    castor.addWith(with);

    firePropertyChange(PROPERTY_WITH_ADDED, null,valueModel);
    valueModel.firePropertyChange(PROPERTY_WITH_ADDED, null,valueModel);
  }
  
  public void removeWithElement(AbstractValueModel valueModel)
  {
    for (int i = 0; i < castor.getWithCount(); i++)
    {
      With with = castor.getWith(i);
      if(with.getVar().equals(valueModel.getName()))
      {
        castor.removeWith(i);
        firePropertyChange(PROPERTY_WITH_REMOVED, valueModel,null);
        valueModel.firePropertyChange(PROPERTY_WITH_REMOVED, valueModel,null);
      }
    }
  }
  
  /**
   * Falls dieses Event eine Referenz auf ein ValueModel hat (z.b. "With" ),
   * müssen diese mit umbenannt werden.
   * Wird vom Framework gerufen.
   * 
   * @param oldName
   * @param newName
   */
  protected void renameValueModel(String oldName, String newName)
  {
    for (int i = 0; i < castor.getWithCount(); i++)
    {
      With with = castor.getWith(i);
      if(with.getVar().equals(oldName))
      {
         with.setVar(newName);
      }
    }
  }
  
  public void setPropertyValue(Object propName, Object val)
  {
     super.setPropertyValue(propName, val);
  }
  
  public Object getPropertyValue(Object propName)
  {
    if (propName instanceof String && ((String) propName).equals(ID_PROPERTY_TYPE))
      return getType();
    else
      return super.getPropertyValue(propName);
  }

  public String getName()
	{
		return castor.getName()==null?"":castor.getName();
	}
	
  public void setName(String name)
  {
    String save = getName();
    if(save.equals(name))
      return;
    
    castor.setName(name);
    
    // Falls das Event umbenannt wird, dann müssen auch alle Referenzen
    // angepasst werden
    //
    getAbstractFunctionBlockModel().renameEventModel(save,name);
    
    firePropertyChange(PROPERTY_NAME_CHANGED, save,name);
  }
  
  public String getComment()
  {
    return castor.getComment()==null?"":castor.getComment();
  }
  
  public void setComment(String comment)
  {
    String save = getComment();
    if(save.equals(comment))
      return;
    
    castor.setComment(comment);
    firePropertyChange(PROPERTY_COMMENT_CHANGED, save,comment);
  }

  public String getType()
	{
		return "EVENT";//castor.getType();
	}

  protected Event getCastor()
  {
    return castor;
  }

  public AbstractFunctionBlockModel getAbstractFunctionBlockModel()
  {
    return functionBlockModel;
  }
  

}
