package de.netallied.functionblock.modeleditor.res.network.editpolicies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateConnectionRequest;
import de.netallied.functionblock.model.InputEventModel;
import de.netallied.functionblock.modeleditor.res.network.command.CreateEventTransitionCommand;

public class InputEventNodeEditPolicy extends AbstractInterfaceNodeEditPart 
{

	@Override
	protected Command getConnectionCompleteCommand(CreateConnectionRequest request) 
	{
		InputEventModel target = (InputEventModel)getHost().getModel();
		if(request.getStartCommand() instanceof CreateEventTransitionCommand)
		{
			CreateEventTransitionCommand cmd = (CreateEventTransitionCommand) request.getStartCommand();
			cmd.setTargetModel((InputEventModel)target);
			return cmd;
		}
  	return null;
	}
}
