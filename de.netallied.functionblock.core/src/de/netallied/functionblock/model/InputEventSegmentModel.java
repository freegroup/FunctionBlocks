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
 * Created on 20.07.2006
 *
 */
package de.netallied.functionblock.model;

import java.util.ArrayList;
import java.util.List;
import de.netallied.functionblock.model.castor.Event;
import de.netallied.functionblock.model.castor.EventInputs;

public class InputEventSegmentModel extends ObjectModel 
{
	private final EventInputs castor;
  private final AbstractFunctionBlockModel functionBlockModel;
  
	List<InputEventModel> inputs;
	public InputEventSegmentModel(AbstractFunctionBlockModel functionBlockModel, EventInputs ei) 
	{
		this.castor = ei;
    this.functionBlockModel = functionBlockModel;
    
    inputs = new ArrayList<InputEventModel>();
    for (int i = 0; i < castor.getEventCount(); i++)
    {
      Event event = castor.getEvent(i);
      inputs.add(new InputEventModel(functionBlockModel, event));
    }
	}

	public List<InputEventModel> getElements()
	{
		return inputs;
	}


  public void setFieldPosition(InputEventModel field, int newIndex)
  {
    int oldIndex = inputs.indexOf(field);
    
    inputs.remove(field);
    Event event = castor.removeEvent(oldIndex);
    
    inputs.add(newIndex,field);
    castor.addEvent(newIndex,event);
    for (InputEventModel model : getElements())
    {
      model.firePropertyChange(PROPERTY_POSITION_CHANGED,  null, model);
      firePropertyChange(PROPERTY_CHILD_REORDER,  null, model);
    }
    
    // Es müssen alle WithTransistion benachrichtigt werden, dass sich ein Eingang
    // geändert hat. Dies ist wichtig für die Darstellung der WithTransistion, da diese
    // den Sortierindex des Einganges berücksichtigen müssen
    //
    AbstractFunctionBlockModel afb = getFunctionBlockModel();
    if(afb instanceof BasisFunctionBlockModel)
    {
      BasisFunctionBlockModel tfb = (BasisFunctionBlockModel)afb;
      for (WithTransitionInModel trans : tfb.getWithTransitionInModels())
      {
        trans.firePropertyChange(PROPERTY_CHILD_REORDER,null,field);
      }
    }
  }
  
  
  protected void addElement(InputEventModel eventModel)
  {
    inputs.add(eventModel);
    castor.addEvent(eventModel.getCastor());
    
    firePropertyChange(PROPERTY_ELEMENT_ADDED, null, eventModel);
  }
  
  
  protected void addElement(int index, InputEventModel eventModel)
  {
    inputs.add(index, eventModel);
    castor.addEvent(index, eventModel.getCastor());
    
    firePropertyChange(PROPERTY_ELEMENT_ADDED, null, eventModel);
  }

  
  protected void removeElement(InputEventModel eventModel)
  {
    int index = inputs.indexOf(eventModel);
    if(index!=-1)
    {
      inputs.remove(eventModel);
      castor.removeEvent(index);
      
      // Es müssen eventuell alle WithTransitionModels entfernt werden
      // welche zu diesen InputEvent gehören
      //
      AbstractFunctionBlockModel afb = getFunctionBlockModel();
      if(afb instanceof BasisFunctionBlockModel)
      {
        BasisFunctionBlockModel tfb = (BasisFunctionBlockModel)afb;
         tfb.removeWithTransitionInModels(eventModel);
      }
      firePropertyChange(PROPERTY_ELEMENT_REMOVED, eventModel, null);
      getFunctionBlockModel().firePropertyChange(PROPERTY_ELEMENT_REMOVED, eventModel, null);
    }
    // Es müssen alle WithTransistion benachrichtigt werden, dass sich ein Eingang
    // geändert hat. Dies ist wichtig für die Darstellung der WithTransistion, da diese
    // den Sortierindex des Einganges berücksichtigen müssen
    //
    AbstractFunctionBlockModel afb = getFunctionBlockModel();
    if(afb instanceof BasisFunctionBlockModel)
    {
      BasisFunctionBlockModel tfb = (BasisFunctionBlockModel)afb;
      for (WithTransitionInModel trans : tfb.getWithTransitionInModels())
      {
        trans.firePropertyChange(PROPERTY_CHILD_REORDER,null,eventModel);
      }
    }
  }
  
  public EventInputs getCastor() 
  {
    return castor;
  }

  public AbstractFunctionBlockModel getFunctionBlockModel()
  {
    return functionBlockModel;
  }

  public InputEventModel getElement(String name)
  {
    for (InputEventModel model : getElements())
    {
      if(model.getName().equals(name))
        return model;
    }
    return null;
  }
}
