package de.netallied.functionblock.modeleditor.fbt.network.editpolicy;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateConnectionRequest;
import de.netallied.functionblock.model.InputEventModel;
import de.netallied.functionblock.modeleditor.fbt.network.command.CreateEventTransitionCommand;

public class InputEventNodeEditPolicy extends AbstractInterfaceNodeEditPart 
{

	@Override
	protected Command getConnectionCompleteCommand(CreateConnectionRequest request) 
	{
		InputEventModel target = (InputEventModel)getHost().getModel();
		if(request.getStartCommand() instanceof CreateEventTransitionCommand)
		{
			CreateEventTransitionCommand cmd = (CreateEventTransitionCommand) request.getStartCommand();
      
      // A InputPort can have only ONE Transsition
      //
      if(cmd.getNetworkModel().getTargetTransitions(target).size()!=0)
        return null;
      
			cmd.setTargetModel((InputEventModel)target);
			return cmd;
		}
  	return null;
	}
}
