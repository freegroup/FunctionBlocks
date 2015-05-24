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
import de.netallied.functionblock.model.castor.OutputVars;
import de.netallied.functionblock.model.castor.VarDeclaration;

public class OutputValueSegmentModel extends ObjectModel 
{
	private final OutputVars castor;
  private final AbstractFunctionBlockModel functionBlockModel;

  List<OutputValueModel> inputs;

	public OutputValueSegmentModel(AbstractFunctionBlockModel functionBlockModel, OutputVars eo) throws Exception 
	{
		this.castor = eo;
    this.functionBlockModel = functionBlockModel;
	}

	public OutputVars getCastor() 
	{
		return castor;
	}
	
	public List<OutputValueModel> getElements()
	{
    if(castor==null)
      return Collections.EMPTY_LIST;
    
		if(inputs==null )
		{
			inputs = new ArrayList<OutputValueModel>();
			for (int i = 0; i < castor.getVarDeclarationCount(); i++)
			{
        VarDeclaration event = castor.getVarDeclaration(i);
				inputs.add(new OutputValueModel(functionBlockModel, event));
			}
		}
		return inputs;
	}


  public void setFieldPosition(OutputValueModel field, int newIndex)
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
    AbstractFunctionBlockModel afb = getFunctionBlockModel();
    if(afb instanceof BasisFunctionBlockModel)
    {
      BasisFunctionBlockModel tfb = (BasisFunctionBlockModel)afb;
      for (WithTransitionOutModel trans : tfb.getWithTransitionOutModels())
      {
        trans.firePropertyChange(PROPERTY_CHILD_REORDER,null,field);
      }
    }  
  }

  
  protected void addElement(int index, OutputValueModel eventModel)
  {
    inputs.add(index, eventModel);
    castor.addVarDeclaration(index, eventModel.getCastor());
    
    firePropertyChange(PROPERTY_ELEMENT_ADDED, null, eventModel);
    // Das Layout der OutTransistions kann sich dadurch eventuell geändert haben
    //
    AbstractFunctionBlockModel afb = getFunctionBlockModel();
    if(afb instanceof BasisFunctionBlockModel)
    {
      BasisFunctionBlockModel tfb = (BasisFunctionBlockModel)afb;
      for (WithTransitionOutModel trans : tfb.getWithTransitionOutModels())
      {
        trans.firePropertyChange(PROPERTY_CHILD_REORDER,null,eventModel);
      }
    }
  }

  
  protected void removeElement(OutputValueModel eventModel)
  {
    int index = inputs.indexOf(eventModel);
    if(index!=-1)
    {
      inputs.remove(eventModel);
      castor.removeVarDeclaration(index);

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
    }
    // Das Layout der OutTransistions kann sich dadurch eventuell geändert haben
    //
    AbstractFunctionBlockModel afb = getFunctionBlockModel();
    if(afb instanceof BasisFunctionBlockModel)
    {
      BasisFunctionBlockModel tfb = (BasisFunctionBlockModel)afb;
      for (WithTransitionOutModel trans : tfb.getWithTransitionOutModels())
      {
        trans.firePropertyChange(PROPERTY_CHILD_REORDER,null,eventModel);
      }
    }
  }

  public AbstractFunctionBlockModel getFunctionBlockModel()
  {
    return functionBlockModel;
  }

  public OutputValueModel getElement(String name)
  {
    for (OutputValueModel model : getElements())
    {
      if(model.getName().equals(name))
        return model;
    }
    return null;
  }
}
