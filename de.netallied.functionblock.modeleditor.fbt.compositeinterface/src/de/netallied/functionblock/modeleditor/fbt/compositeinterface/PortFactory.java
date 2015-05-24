package de.netallied.functionblock.modeleditor.fbt.compositeinterface;

import org.eclipse.gef.requests.CreationFactory;

import de.netallied.functionblock.model.AbstractPortModel;

public class PortFactory  implements CreationFactory
{
  public PortFactory()
  {
  }

  public Object getNewObject()
  {
  	throw new RuntimeException("unable to create new object from interface");
  }

	public Object getObjectType() 
	{
		return AbstractPortModel.class;
	}
}
