/*
 * Created on 31.01.2007
 *
 */
package de.netallied.functionblock.model;

import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;

public class ParameterTransitionModel extends AbstractTransitionModel
{
  ParameterModel from;
  AbstractTargetModel to;
  NetworkModel        network;
  
  public ParameterTransitionModel(NetworkModel network, ParameterModel from, AbstractTargetModel to)
  {
    this.from = from;
    this.to = to;
    this.network = network;
  }

  public IPropertyDescriptor[] getPropertyDescriptors()
  {
    IPropertyDescriptor[] superDescriptors = super.getPropertyDescriptors();
    IPropertyDescriptor[] descriptors = new IPropertyDescriptor[superDescriptors.length + 2];
    for (int i = 0; i < superDescriptors.length; i++)
      descriptors[i] = superDescriptors[i];
    descriptors[superDescriptors.length]   = new TextPropertyDescriptor(ID_PROPERTY_VALUE, "Value");
    descriptors[superDescriptors.length+1] = new TextPropertyDescriptor(ID_PROPERTY_COMMENT, "Comment");
    
    return descriptors;
  }
  
  public void setPropertyValue(Object propName, Object val)
  {
    if (propName instanceof String && ((String) propName).equals(ID_PROPERTY_VALUE))
      setValue((String) val);
    else if (propName instanceof String && ((String) propName).equals(ID_PROPERTY_COMMENT))
      setComment((String) val);
    else
      super.setPropertyValue(propName, val);
  }
  
  public Object getPropertyValue(Object propName)
  {
    if (propName instanceof String && ((String) propName).equals(ID_PROPERTY_VALUE))
      return getValue();
    if (propName instanceof String && ((String) propName).equals(ID_PROPERTY_COMMENT))
      return getComment();
    else
      return super.getPropertyValue(propName);
  }

  
  @Override
  public NetworkModel getNetworkFunctionBlockModel()
  {
    return network;
  }

  @Override
  public AbstractSourceModel getFromObjectModel()
  {
    return from;
  }

  @Override
  public AbstractTargetModel getToObjectModel()
  {
    return to;
  }
  
  public String getValue()
  {
    return from.getValue();
  }
  
  public void setValue(String value)
  {
    from.setValue(value);
  }
  
  public String getComment()
  {
    return from.getComment();
  }
  
  public void setComment(String value)
  {
    from.setComment(value);
  }
}
