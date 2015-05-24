package de.netallied.functionblock.modeleditor.fbt.network.editpolicy;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateConnectionRequest;
import de.netallied.functionblock.model.InputValueModel;
import de.netallied.functionblock.modeleditor.fbt.network.command.CreateValueTransitionCommand;

public class InputValueNodeEditPolicy extends AbstractInterfaceNodeEditPart 
{

	@Override
	protected Command getConnectionCompleteCommand(CreateConnectionRequest request) 
	{
		InputValueModel target = (InputValueModel)getHost().getModel();
		if(request.getStartCommand() instanceof CreateValueTransitionCommand)
		{
			CreateValueTransitionCommand cmd = (CreateValueTransitionCommand) request.getStartCommand();
      // A InputPort can have only ONE Transsition
      //
      if(cmd.getNetworkModel().getTargetTransitions(target).size()!=0)
        return null;
      
			cmd.setTargetModel((InputValueModel)target);
			return cmd;
		}
  	return null;
	}
}
