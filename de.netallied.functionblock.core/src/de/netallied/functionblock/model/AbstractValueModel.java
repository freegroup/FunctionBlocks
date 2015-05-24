package de.netallied.functionblock.model;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import org.eclipse.ui.views.properties.ComboBoxPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import de.netallied.functionblock.model.castor.VarDeclaration;
import de.netallied.functionblock.model.castor.types.VarDeclarationTypeType;

public class AbstractValueModel extends AbstractInterfaceModel
{
  VarDeclaration castor;
  private final AbstractFunctionBlockModel functionBlockModel;

  private final static List DATA_TYPES;
  
  static
  {
    DATA_TYPES = new ArrayList();
    Enumeration e = VarDeclarationTypeType.enumerate();  
    while(e.hasMoreElements())
    {
      DATA_TYPES.add(e.nextElement().toString());
    }
  }
  
	public AbstractValueModel(AbstractFunctionBlockModel parent, VarDeclaration var)
	{
		this.castor = var;
    this.functionBlockModel = parent;
	}

  public IPropertyDescriptor[] getPropertyDescriptors()
  {
    IPropertyDescriptor[] superDescriptors = super.getPropertyDescriptors();
    IPropertyDescriptor[] descriptors = new IPropertyDescriptor[superDescriptors.length + 1];
    for (int i = 0; i < superDescriptors.length; i++)
      descriptors[i] = superDescriptors[i];
    descriptors[superDescriptors.length] = new ComboBoxPropertyDescriptor(ID_PROPERTY_TYPE, "Type",(String[])DATA_TYPES.toArray(new String[0]));
    
    return descriptors;
  }
  
  public void setPropertyValue(Object propName, Object val)
  {
    if (propName == ID_PROPERTY_TYPE)
      setType((String)(DATA_TYPES.get(((Integer)val).intValue())));
    else
      super.setPropertyValue(propName, val);
  }
  
  public Object getPropertyValue(Object propName)
  {
    if (propName == ID_PROPERTY_TYPE)
      return new Integer(DATA_TYPES.indexOf(getType()));
    else
      return super.getPropertyValue(propName);
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
    firePropertyChange(PROPERTY_NAME_CHANGED, save,name);

    getAbstractFunctionBlockModel().renameValueModel(save,name);
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

  
  public void setType(String type)
  {
    castor.setType(VarDeclarationTypeType.valueOf(type));
    firePropertyChange(PROPERTY_TYPE_CHANGED, null,this);
  }

  public String getType()
	{
		return castor.getType().toString();
	}

  protected VarDeclaration getCastor()
  {
    return castor;
  }


  public AbstractFunctionBlockModel getAbstractFunctionBlockModel()
  {
    return functionBlockModel;
  }
}
