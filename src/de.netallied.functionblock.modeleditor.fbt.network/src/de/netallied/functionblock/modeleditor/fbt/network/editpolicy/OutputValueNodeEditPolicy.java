package de.netallied.functionblock.modeleditor.fbt.network.editpolicy;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateConnectionRequest;
import de.netallied.functionblock.model.NetworkModel;
import de.netallied.functionblock.model.OutputValueModel;
import de.netallied.functionblock.modeleditor.fbt.network.command.CreateValueTransitionCommand;

public class OutputValueNodeEditPolicy extends AbstractInterfaceNodeEditPart 
{

	@Override
	protected Command getConnectionCreateCommand(CreateConnectionRequest request) 
	{
  	OutputValueModel source = (OutputValueModel)getHost().getModel();

    NetworkModel ifb= getNetworkFunctionBlockModel();
		CreateValueTransitionCommand cmd = new CreateValueTransitionCommand(ifb,source);
  	request.setStartCommand(cmd);
  	
  	return cmd;
	}
}
