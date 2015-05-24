/*
 * Created on 25.02.2005
 *
 */
package de.netallied.functionblock.modeleditor.fbt.network;

import org.eclipse.gef.requests.CreationFactory;

import de.netallied.functionblock.model.FBTypeModel;
import de.netallied.functionblock.model.InstanceFunctionBlockModel;

/**
 *
 */
public class FBFactory implements CreationFactory
{
  private final FBTypeModel type;
  
  public FBFactory(FBTypeModel type)
  {
    this.type=type;
  }

  public Object getNewObject()
  {
  	return new InstanceFunctionBlockModel(type);
  }

	public Object getObjectType() 
	{
		return InstanceFunctionBlockModel.class;
	}
 
}
