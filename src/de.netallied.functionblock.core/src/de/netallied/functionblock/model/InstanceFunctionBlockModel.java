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
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.jdt.internal.core.util.WeakHashSet;

import de.netallied.functionblock.cache.FBTypeModelCache;
import de.netallied.functionblock.model.castor.FB;
import de.netallied.functionblock.model.castor.Parameter;

public class InstanceFunctionBlockModel extends AbstractNamedModel
{
  private final FB castor;
  private NetworkModel parent;
  private final FBTypeModel typeModel;
  
  List<InputEventModel>  inputEvents  = new ArrayList<InputEventModel>();
  List<OutputEventModel> outputEvents = new ArrayList<OutputEventModel>();
  List<InputValueModel>  inputValues  = new ArrayList<InputValueModel>();
  List<OutputValueModel> outputValues = new ArrayList<OutputValueModel>();
  List<ParameterModel>   parameters   = new ArrayList<ParameterModel>();
  
	public InstanceFunctionBlockModel(FBTypeModel typeModel) 
	{
		this.typeModel = typeModel;
		this.castor = new FB();
		this.castor.setType(typeModel.getFunctionBlockModel().getName());
		this.castor.setName("asdfg");
    // Alle Events/Value Ports muessen gecloned werden, da im Editor diese
    // für jede Instanz vorhanden sein müssen und nicht für jeden Typ
    //
    for (InputEventModel model : typeModel.getFunctionBlockModel().getInputEventModels()) 
    {
      inputEvents.add(new InstanceInputEventModel(this, model.getCastor()));
    }
    for (OutputEventModel model : typeModel.getFunctionBlockModel().getOutputEventModels()) 
    {
      outputEvents.add(new InstanceOutputEventModel(this, model.getCastor()));
    }
    for (InputValueModel model : typeModel.getFunctionBlockModel().getInputValueModels()) 
    {
      inputValues.add(new InstanceInputValueModel(this, model.getCastor()));
    }
    for (OutputValueModel model : typeModel.getFunctionBlockModel().getOutputValueModels()) 
    {
      outputValues.add(new InstanceOutputValueModel(this, model.getCastor()));
    }
	}
	
	public InstanceFunctionBlockModel(NetworkModel parent, FB instance) throws Exception 
	{
    this.castor=instance;
    this.parent= parent;
    this.typeModel=FBTypeModelCache.getModel(parent.getProject(), getType());
    
    // Alle Events/Value Ports muessen gecloned werden, da im Editor diese
    // für jede Instanz vorhanden sein müssen und nicht für jeden Typ
    //
    if(this.typeModel!=null)
    {
    	for (InputEventModel model : typeModel.getFunctionBlockModel().getInputEventModels()) 
    	{
    		inputEvents.add(new InstanceInputEventModel(this, model.getCastor()));
			}
    	for (OutputEventModel model : typeModel.getFunctionBlockModel().getOutputEventModels()) 
    	{
    		outputEvents.add(new InstanceOutputEventModel(this, model.getCastor()));
			}
    	for (InputValueModel model : typeModel.getFunctionBlockModel().getInputValueModels()) 
    	{
    		inputValues.add(new InstanceInputValueModel(this, model.getCastor()));
			}
    	for (OutputValueModel model : typeModel.getFunctionBlockModel().getOutputValueModels()) 
    	{
    		outputValues.add(new InstanceOutputValueModel(this, model.getCastor()));
			}
      
      for (Parameter param : this.castor.getParameter())
      {
        parameters.add(new ParameterModel(this, param));
      }
    }
  }

  public Point getLocation()
  {
    return new Point(castor.getX(), castor.getY());
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
    
    
    // Alle connections müssen angepasst werden, da diese 
    // die Id der AbstractFunctionBlock instanz als Source/Target Identifier
    // verwenden
    //
    getNetworkModel().calculateSourceTargetIdentifiert();

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
    return castor.getType();
  }
  
  public NetworkModel getNetworkModel()
  {
  	return parent;
  }


  public FB getCastor()
  {
    return castor;
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
	
  public boolean removeElement(ParameterModel param)  
  {
    int index = parameters.indexOf(param);
    if(index!=-1)
    {
      parameters.remove(index);
      castor.removeParameter(index);
      
      firePropertyChange(PROPERTY_ELEMENT_REMOVED, param,null);
      return true;
    }
    return false;
  }
  
  protected void addParameter(ParameterModel param)
  {
    parameters.add(param);
    castor.addParameter(param.getCastor());
    firePropertyChange(PROPERTY_ELEMENT_ADDED, null, param);
  }

	public List<AbstractInterfaceModel> getElements()
	{
		List<AbstractInterfaceModel> result = new ArrayList<AbstractInterfaceModel>();

		result.addAll(inputEvents);
		result.addAll(inputValues);
		result.addAll(outputEvents);
		result.addAll(outputValues);
		
		return result;
	}
	
	public AbstractSourceModel getAbstractSourceModel(String name)
	{
		for (AbstractSourceModel source : outputEvents) 
		{
			if(source.getName().equals(name))
				return source;
		}
		for (AbstractSourceModel source : outputValues) 
		{
			if(source.getName().equals(name))
				return source;
		}
		return null;
	}
	
	public AbstractTargetModel getAbstractTargetModel(String name)
	{
		for (AbstractTargetModel source : inputEvents) 
		{
			if(source.getName().equals(name))
				return source;
		}
		for (AbstractTargetModel source : inputValues) 
		{
			if(source.getName().equals(name))
				return source;
		}
		return null;
	}

	public List<InputEventModel> getInputEventModels()
	{
		return inputEvents;
	}

	public List<OutputEventModel> getOutputEventModels()
	{
		return outputEvents;
	}

	public List<InputValueModel> getInputValueModels()
	{
		return inputValues;
	}

	public List<OutputValueModel> getOutputValueModels()
	{
		return outputValues;
	}

	public FBTypeModel getTypeModel() 
	{
		return typeModel;
	}

	public void setParent(NetworkModel parent) 
	{
		this.parent = parent;
	}
  
  /**
   * HACK
   * @param newName
   */
  public void setCastorName(String newName)
  {
    getCastor().setName(newName);
  }

  public List<ParameterModel> getParameters()
  {
    return parameters;
  }

}
