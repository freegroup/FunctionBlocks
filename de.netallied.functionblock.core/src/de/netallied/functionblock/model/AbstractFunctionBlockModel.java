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
import org.eclipse.draw2d.geometry.Point;
import de.netallied.functionblock.model.castor.ECC;
import de.netallied.functionblock.model.castor.FBType;
import de.netallied.functionblock.model.castor.FBTypeChoice;
import de.netallied.functionblock.model.castor.Identification;
import de.netallied.functionblock.model.castor.Service;

public abstract class AbstractFunctionBlockModel extends ObjectModel implements INamedModel
{
	private final FBType castor;

	private final EventSegmentModel signalSegment;
  private final FunctionBlockWaistModel waistSegment;
  private final FunctionBlockNameModel nameSegment;
	private final ValueSegmentModel valueSegment;
 	
	public AbstractFunctionBlockModel(FBType type) throws Exception 
	{
		castor = type;

		signalSegment = new EventSegmentModel(this, type, type.getInterfaceList());
    waistSegment  = new FunctionBlockWaistModel();
    nameSegment   = new FunctionBlockNameModel(type);
		valueSegment  = new ValueSegmentModel(this, type.getInterfaceList());
	}

	public FBType getCastor() 
	{
		return castor;
	}

	public final List<ObjectModel> getElements()
	{
		return Arrays.asList(new ObjectModel[]{signalSegment, waistSegment, nameSegment, valueSegment});
	}


  public Point getPosition()
	{
    return new Point(100,100);
	}

	public String getComment() 
	{
		return castor.getComment();
	}

  public void setComment(String comment)
  {
    castor.setComment(comment);
  }
  
	public Identification getIdentification() 
	{
		return castor.getIdentification();
	}

	public String getName() 
	{
		return castor.getName();
	}

  public void setName(String name)
  {
    castor.setName(name);
  }
  
	public String getClassification()
	{
		if(castor.getIdentification()==null)
			return "Common";
		if(castor.getIdentification().getClassification()==null)
			return "Common";

		return castor.getIdentification().getClassification();
	}
	
  public void setClassification(String c)
  {
    if(castor.getIdentification()==null)
      castor.setIdentification(new Identification());
    
    castor.getIdentification().setClassification(c);
  }
  
	public Service getService() 
	{
		return castor.getService();
	}
	
  
  public void renameEventModel(String oldName, String newName)
  {
  }
  
  public void renameValueModel(String save, String name)
  {
  }

  public List<OutputEventModel> getOutputEventModels()
  {
    return signalSegment.getOutputModels();
  }
  
  public OutputEventModel getOutputEventModel(String name)
  {
    return signalSegment.getOutputModel(name);
  }

  public List<InputEventModel> getInputEventModels()
  {
    return signalSegment.getInputModels();
  }

  public InputEventModel getInputEventModel(String name)
  {
    return signalSegment.getInputModel(name);
  }
    
  public List<OutputValueModel> getOutputValueModels()
  {
    return valueSegment.getOutputModels();
  }

  public OutputValueModel getOutputValueModel(String name)
  {
    return valueSegment.getOutputModel(name);
  }
  
  public List<InputValueModel> getInputValueModels()
  {
    return valueSegment.getInputModels();
  }

  public InputValueModel getInputValueModel(String name)
  {
    return valueSegment.getInputModel(name);
  }
  
  public EventSegmentModel getSignalSegment()
  {
    return signalSegment;
  }

  public ValueSegmentModel getValueSegment()
  {
    return valueSegment;
  }

  public void addElement(int index, OutputValueModel event)
  {
    getValueSegment().addElement(index, event);
  }

  public void removeElement(OutputValueModel value)
  {
    getValueSegment().removeElement(value);
  }

  public void addElement(int index, OutputEventModel event)
  {
    getSignalSegment().addElement(index, event);
  }

  public void removeElement(OutputEventModel value)
  {
    getSignalSegment().removeElement(value);
  }


  public void addElement(int index, InputValueModel event)
  {
    getValueSegment().addElement(index, event);
  }

  public void removeElement(InputValueModel value)
  {
    getValueSegment().removeElement(value);
  }

  public void addElement(int index, InputEventModel event)
  {
    getSignalSegment().addElement(index, event);
  }

  public void removeElement(InputEventModel value)
  {
    getSignalSegment().removeElement(value);
  }

}
