package de.netallied.functionblock.modeleditor.res.network.editpolicies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateConnectionRequest;
import de.netallied.functionblock.model.InputValueModel;
import de.netallied.functionblock.model.InstanceInputValueModel;
import de.netallied.functionblock.modeleditor.res.network.command.CreateValueTransitionCommand;

public class InputValueNodeEditPolicy extends AbstractInterfaceNodeEditPart 
{

	@Override
	protected Command getConnectionCompleteCommand(CreateConnectionRequest request) 
	{
    InstanceInputValueModel target = (InstanceInputValueModel)getHost().getModel();
		if(request.getStartCommand() instanceof CreateValueTransitionCommand)
		{
			CreateValueTransitionCommand cmd = (CreateValueTransitionCommand) request.getStartCommand();
			cmd.setTargetModel((InstanceInputValueModel)target);
			return cmd;
		}
  	return null;
	}
}
