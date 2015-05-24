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
import de.netallied.functionblock.model.castor.InterfaceList;

public class ValueSegmentModel extends ObjectModel 
{
  private final AbstractFunctionBlockModel functionBlockModel;

  InputValueSegmentModel  inputValues;
	OutputValueSegmentModel outputValues;
	
	public ValueSegmentModel(AbstractFunctionBlockModel functionBlockModel, InterfaceList il) throws Exception 
	{
    this.functionBlockModel = functionBlockModel;
    
    inputValues = new InputValueSegmentModel(this.functionBlockModel, il.getInputVars());
    outputValues = new OutputValueSegmentModel(this.functionBlockModel, il.getOutputVars());
	}

	public List getElements()
	{
		return Arrays.asList(new Object[]{inputValues,outputValues});
	}

  public AbstractFunctionBlockModel getFunctionBlockModel()
  {
    return functionBlockModel;
  }
  public List<OutputValueModel> getOutputModels()
  {
    return outputValues.getElements();
  }

  public List<InputValueModel> getInputModels()
  {
    return inputValues.getElements();
  }

  public InputValueModel getInputModel(String name)
  {
    return inputValues.getElement(name);
  }

  public OutputValueModel getOutputModel(String name)
  {
    return outputValues.getElement(name);
  }

  protected void addElement(int index, OutputValueModel value)
  {
    outputValues.addElement(index,value);
  }

  protected void removeElement(OutputValueModel value)
  {
    outputValues.removeElement(value);
  }
  
  protected void addElement(int index, InputValueModel value)
  {
    inputValues.addElement(index,value);
  }

  protected void removeElement(InputValueModel value)
  {
    inputValues.removeElement(value);
  }  
}
