package de.netallied.functionblock.model;

import de.netallied.functionblock.model.castor.VarDeclaration;
import de.netallied.functionblock.model.castor.types.VarDeclarationTypeType;

public class InputValueModel extends AbstractValueModel implements AbstractTargetModel
{
  public InputValueModel(AbstractFunctionBlockModel parent, String name)
  {
    super(parent, new VarDeclaration());
    getCastor().setName(name);
    getCastor().setType(VarDeclarationTypeType.INT);
  }

  public InputValueModel(AbstractFunctionBlockModel parent, VarDeclaration var)
	{
    super(parent, var);
	}

  public String getIdentifierName(NetworkModel networkModel)
  {
    // get the parent of this node
    //
    InstanceFunctionBlockModel fromFB = networkModel.getInstanceElement(this);
    
    return fromFB.getName()+"."+this.getName();
  }
}
