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
import java.util.Collections;
import java.util.List;
import de.netallied.functionblock.model.castor.InputVars;
import de.netallied.functionblock.model.castor.VarDeclaration;

public class InputValueSegmentModel extends ObjectModel 
{
	private final InputVars castor;
  private final AbstractFunctionBlockModel functionBlockModel;

	List<InputValueModel> inputs;
  
	public InputValueSegmentModel(AbstractFunctionBlockModel functionBlockModel, InputVars ei) throws Exception 
	{
		this.castor = ei;
    this.functionBlockModel = functionBlockModel;
	}

	public InputVars getCastor() 
	{
		return castor;
	}
	
	public List<InputValueModel> getElements()
	{
    if(castor==null)
      return Collections.EMPTY_LIST;

    if(inputs==null)
		{
			inputs = new ArrayList<InputValueModel>();
			for (int i = 0; i < castor.getVarDeclarationCount(); i++)
			{
				VarDeclaration event = castor.getVarDeclaration(i);
				inputs.add(new InputValueModel(functionBlockModel, event));
			}
		}
		return inputs;
	}


  public void setFieldPosition(InputValueModel field, int newIndex)
  {
    int oldIndex = inputs.indexOf(field);
    
    inputs.remove(field);
    VarDeclaration event = castor.removeVarDeclaration(oldIndex);
    
    inputs.add(newIndex,field);
    castor.addVarDeclaration(newIndex,event);
    
    firePropertyChange(PROPERTY_CHILD_REORDER,  null, field);
    
    // Es müssen alle WithTransistion benachrichtigt werden, dass sich ein Eingang
    // geändert hat. Dies ist wichtig für die Darstellung der WithTransistion, da diese
    // den Sortierindex des Einganges berücksichtigen müssen
    //
    AbstractFunctionBlockModel afb = getAbstractFunctionBlockModel();
    if(afb instanceof BasisFunctionBlockModel)
    {
      BasisFunctionBlockModel tfb = (BasisFunctionBlockModel)afb;
      for (WithTransitionInModel trans : tfb.getWithTransitionInModels())
      {
        trans.firePropertyChange(PROPERTY_CHILD_REORDER,null,field);
      }
    }
  }
  

  protected void addElement(int index, InputValueModel eventModel)
  {
    inputs.add(index, eventModel);
    castor.addVarDeclaration(index, eventModel.getCastor());
    
    firePropertyChange(PROPERTY_ELEMENT_ADDED, null, eventModel);
  }

  
  protected void removeElement(InputValueModel eventModel)
  {
    int index = inputs.indexOf(eventModel);
    if(index!=-1)
    {
      inputs.remove(eventModel);
      castor.removeVarDeclaration(index);
      
      // Es müssen eventuell alle WithTransitionModels entfernt werden
      // welche zu diesen InputEvent gehören
      //
      AbstractFunctionBlockModel afb = getAbstractFunctionBlockModel();
      if(afb instanceof BasisFunctionBlockModel)
      {
        BasisFunctionBlockModel tfb = (BasisFunctionBlockModel)afb;
         tfb.removeWithTransitionInModels(eventModel);
      }
      
      firePropertyChange(PROPERTY_ELEMENT_REMOVED, eventModel, null);
    }
  }
  
  public AbstractFunctionBlockModel getAbstractFunctionBlockModel()
  {
    return functionBlockModel;
  }

  public InputValueModel getElement(String name)
  {
    for (InputValueModel inputModel : getElements())
    {
      if(inputModel.getName().equals(name))
        return inputModel;
      
    }
    return null;
  }
}
