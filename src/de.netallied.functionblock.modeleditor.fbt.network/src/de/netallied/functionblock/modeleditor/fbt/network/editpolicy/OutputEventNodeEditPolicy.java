package de.netallied.functionblock.modeleditor.fbt.network.editpolicy;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateConnectionRequest;
import de.netallied.functionblock.model.NetworkModel;
import de.netallied.functionblock.model.OutputEventModel;
import de.netallied.functionblock.modeleditor.fbt.network.command.CreateEventTransitionCommand;

public class OutputEventNodeEditPolicy extends AbstractInterfaceNodeEditPart 
{

	@Override
	protected Command getConnectionCreateCommand(CreateConnectionRequest request) 
	{
		OutputEventModel source = (OutputEventModel)getHost().getModel();

    NetworkModel ifb= getNetworkFunctionBlockModel();
		CreateEventTransitionCommand cmd = new CreateEventTransitionCommand(ifb,source);
  	request.setStartCommand(cmd);
  	
  	return cmd;
	}
}
