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
import java.util.Enumeration;
import java.util.List;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.ui.views.properties.ComboBoxPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;
import de.netallied.functionblock.model.castor.ECAction;
import de.netallied.functionblock.model.castor.VarDeclaration;
import de.netallied.functionblock.model.castor.types.VarDeclarationTypeType;
import de.netallied.functionblock.util.IntegerPropertyGroupingDescriptor;

public class ECCStateActionModel extends  ObjectModel
{
  private final ECAction castor;
  private BasisFunctionBlockModel functionBlockModel;

  public ECCStateActionModel()
  {
    this.castor = new ECAction();
  }
  
	public ECCStateActionModel(BasisFunctionBlockModel functionBlockModel, ECAction action)
	{
		this.castor = action;
    this.functionBlockModel = functionBlockModel;
	}

  protected ECAction getCastor()
  {
    return castor;
  }

  public Algorithm getAlgorithm()
  {
    return functionBlockModel.getAlgorithm(getAlgorithmName());
  }
  
  public String getAlgorithmName()
  {
    return castor.getAlgorithm()==null?"":castor.getAlgorithm();
  }


  private void setAlgorithm(String string)
  {
    String save = getAlgorithmName();
    if(save.equals(string))
      return;

    if(string!=null && string.length()==0)
      string=null;
    castor.setAlgorithm(string);
    firePropertyChange(PROPERTY_ALGORITHM_CHANGED, save, string);
  }

  public String getOutput()
  {
    return castor.getOutput()==null?"":castor.getOutput();
  }

  public OutputEventModel getOutputModel()
  {
    return getFunctionBlockModel().getOutputEventModel(getOutput());
  }


  public void setOutput(String outputEvent)
  {
    String save = getOutput();
    if(save.equals(outputEvent))
      return;
    
    if(outputEvent !=null && outputEvent.length()==0)
      outputEvent=null;
    castor.setOutput(outputEvent);
    firePropertyChange(PROPERTY_EVENT_CHANGED, save,outputEvent);
  }
  
  public IPropertyDescriptor[] getPropertyDescriptors()
  {
    IPropertyDescriptor[] superDescriptors = super.getPropertyDescriptors();
    IPropertyDescriptor[] descriptors = new IPropertyDescriptor[superDescriptors.length + 2];
    for (int i = 0; i < superDescriptors.length; i++)
      descriptors[i] = superDescriptors[i];
    descriptors[superDescriptors.length  ] = new ComboBoxPropertyDescriptor(ID_PROPERTY_ALGORITHM, "Algorithm",(String[])getAlgorithmNames().toArray(new String[0]));
    descriptors[superDescriptors.length+1] = new ComboBoxPropertyDescriptor(ID_PROPERTY_ACTIONEVENT, "Event",(String[])getOutEventNames().toArray(new String[0]));
    
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
    if (ID_PROPERTY_ALGORITHM == propertyId)
      return new Integer(getAlgorithmNames().indexOf(getAlgorithmName()));
    if (propertyId == ID_PROPERTY_ACTIONEVENT)
      return new Integer(getOutEventNames().indexOf(getOutput()));
    return super.getPropertyValue(propertyId);
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
    if(ID_PROPERTY_ALGORITHM == propertyId)
      setAlgorithm((String)(getAlgorithmNames().get(((Integer)value).intValue())));
    else if (ID_PROPERTY_ACTIONEVENT.equals(propertyId))
      setOutput((String)(getOutEventNames().get(((Integer)value).intValue())));
    else
      super.setPropertyValue(propertyId, value);
  }


  private List<String> getOutEventNames()
  {
    List<OutputEventModel> events = getFunctionBlockModel().getOutputEventModels();
    List<String>           result = new ArrayList<String>();
    result.add("");
    for (OutputEventModel event : events)
    {
      result.add(event.getName());
    }
    return result;
  }

  private List<String> getAlgorithmNames()
  {
    List<Algorithm> algorithms = getFunctionBlockModel().getAlgorithms();
    List<String>           result = new ArrayList<String>();
    result.add("");
    for (Algorithm algorithm : algorithms)
    {
      result.add(algorithm.getName());
    }
    return result;
  }

  public BasisFunctionBlockModel getFunctionBlockModel()
  {
    return functionBlockModel;
  }

  public void setFunctionBlockModel(BasisFunctionBlockModel functionBlockModel)
  {
    this.functionBlockModel = functionBlockModel;
  }
}
