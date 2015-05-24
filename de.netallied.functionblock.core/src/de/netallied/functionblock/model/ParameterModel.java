/*
 * Created on 31.01.2007
 *
 */
package de.netallied.functionblock.model;

import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;
import de.netallied.functionblock.model.castor.Parameter;
import de.netallied.functionblock.util.StringUtil;

public class ParameterModel extends ObjectModel implements AbstractSourceModel
{
  Parameter castor;
  InstanceFunctionBlockModel parent;
  
  public ParameterModel(InstanceFunctionBlockModel parent, InputValueModel port)
  {
    this.castor = new Parameter();
    this.castor.setName(port.getName());
    this.castor.setValue("");
    this.parent = parent;
  }

  public ParameterModel(InstanceFunctionBlockModel parent, Parameter param)
  {
    this.castor = param;
    this.parent = parent;
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



  public String getComment()
  {
    return StringUtil.toSaveString(castor.getComment());
  }

  public String getName()
  {
    return castor.getName();
  }

  public String getValue()
  {
    return StringUtil.toSaveString(castor.getValue());
  }

  public InstanceFunctionBlockModel getInstanceFunctionBlockModel()
  {
    return parent;
  }
  
  public void setComment(String comment)
  {
    String save = getComment();
    if(save.equals(comment))
      return;
    castor.setComment(comment);
    
    firePropertyChange(PROPERTY_COMMENT_CHANGED,save,comment);
  }


  public void setValue(String value)
  {
    String save = getValue();
    if(save.equals(value))
      return;

    castor.setValue(value);
    firePropertyChange(PROPERTY_VALUE_CHANGED,save,value);
  }

  public AbstractFunctionBlockModel getAbstractFunctionBlockModel()
  {
    // unused
    return null;
  }

  public String getIdentifierName(NetworkModel networkModel)
  {
    // unused
    return null;
  }

  public Parameter getCastor()
  {
    return castor;
  }
}
