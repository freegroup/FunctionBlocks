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

import java.util.Arrays;
import java.util.List;
import de.netallied.functionblock.model.castor.EventInputs;
import de.netallied.functionblock.model.castor.EventOutputs;
import de.netallied.functionblock.model.castor.FBType;
import de.netallied.functionblock.model.castor.InterfaceList;

public class EventSegmentModel extends ObjectModel 
{
	private final InputEventSegmentModel  inputEvent;
  private final OutputEventSegmentModel outputEvent;
  private final AbstractFunctionBlockModel functionBlockModel;
	
	public EventSegmentModel(AbstractFunctionBlockModel functionBlockModel, FBType fb, InterfaceList il) throws Exception 
	{
    this.functionBlockModel = functionBlockModel;
    if(il.getEventInputs()==null)
      il.setEventInputs(new EventInputs());
    if(il.getEventOutputs()==null)
      il.setEventOutputs(new EventOutputs());
    
    inputEvent  = new InputEventSegmentModel(functionBlockModel, il.getEventInputs());
    outputEvent = new OutputEventSegmentModel(functionBlockModel, il.getEventOutputs());
	}

	public List getElements()
	{
		return Arrays.asList(new Object[]{inputEvent,outputEvent});
	}
  
  public AbstractFunctionBlockModel getAbstractFunctionBlockModel()
  {
    return functionBlockModel;
  }
  
  public List<OutputEventModel> getOutputModels()
  {
    return outputEvent.getElements();
  }

  public List<InputEventModel> getInputModels()
  {
    return inputEvent.getElements();
  }

  public InputEventModel getInputModel(String name)
  {
    return inputEvent.getElement(name);
  }

  public OutputEventModel getOutputModel(String name)
  {
    return outputEvent.getElement(name);
  }

  protected void addElement(int index, OutputEventModel value)
  {
    outputEvent.addElement(index,value);
  }

  protected void removeElement(OutputEventModel value)
  {
    outputEvent.removeElement(value);
  }
  
  protected void addElement(int index, InputEventModel value)
  {
    inputEvent.addElement(index,value);
  }

  protected void removeElement(InputEventModel value)
  {
    inputEvent.removeElement(value);
  }  
}
