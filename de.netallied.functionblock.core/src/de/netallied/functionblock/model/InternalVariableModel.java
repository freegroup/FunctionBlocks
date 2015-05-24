package de.netallied.functionblock.model;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import de.netallied.functionblock.model.castor.VarDeclaration;
import de.netallied.functionblock.model.castor.types.VarDeclarationTypeType;
import de.netallied.functionblock.util.StringUtil;

public class InternalVariableModel extends ObjectModel
{
  VarDeclaration castor;

  public final static List<String> DATA_TYPES;
  
  static
  {
    DATA_TYPES = new ArrayList<String>();
    Enumeration e = VarDeclarationTypeType.enumerate();  
    while(e.hasMoreElements())
    {
      DATA_TYPES.add(e.nextElement().toString());
    }
  }

  public InternalVariableModel(VarDeclaration castor)
  {
    this.castor = castor;
  }

  public InternalVariableModel(BasisFunctionBlockModel basisFunctionBlockModel)
  {
    castor = new VarDeclaration();
    castor.setType(VarDeclarationTypeType.BOOL);
    String name = "boolean";
    if(basisFunctionBlockModel.getVariable(name)!=null)
    {
      int counter = 1;
      while(basisFunctionBlockModel.getVariable(name+counter)!=null)
        counter++;
      castor.setName(name+counter);
    }
    else
    {
      castor.setName(name);
    }
  }
  
  public String getName()
  {
    return castor.getName();
  }

  public void setName(String name)
  {
    castor.setName(name);
  }
  
  public String getType()
  {
    return castor.getType().toString();
  }
  
  public void setType(String type)
  {
    castor.setType(VarDeclarationTypeType.valueOf(type));
  }
  
  public String getComment()
  {
    return StringUtil.toSaveString(castor.getComment());
  }
  
  public void setComment(String comment)
  {
    castor.setComment(comment);
  }
  
  public VarDeclaration getCastor()
  {
    return castor;
  }
}
