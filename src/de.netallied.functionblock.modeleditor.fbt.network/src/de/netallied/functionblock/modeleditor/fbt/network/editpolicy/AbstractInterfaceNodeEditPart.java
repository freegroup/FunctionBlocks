package de.netallied.functionblock.modeleditor.fbt.network.editpolicy;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import de.netallied.functionblock.model.NetworkModel;

public abstract class AbstractInterfaceNodeEditPart extends GraphicalNodeEditPolicy 
{
  protected NetworkModel getNetworkFunctionBlockModel()
  {
  	// this=>InstanceFunctionBlock=>NetworkFunctionBlock
  	return (NetworkModel)getHost().getParent().getParent().getModel();
  }

	@Override
	protected Command getConnectionCompleteCommand(CreateConnectionRequest arg0) 
	{
		return null;
	}

	@Override
	protected Command getConnectionCreateCommand(CreateConnectionRequest arg0) 
	{
		return null;
	}

	@Override
	protected Command getReconnectSourceCommand(ReconnectRequest arg0) 
	{
		return null;
	}

	@Override
	protected Command getReconnectTargetCommand(ReconnectRequest arg0) 
	{
		return null;
	}

}
