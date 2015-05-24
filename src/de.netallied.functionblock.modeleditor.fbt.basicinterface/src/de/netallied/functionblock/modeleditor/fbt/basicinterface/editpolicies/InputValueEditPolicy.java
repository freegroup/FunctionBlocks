package de.netallied.functionblock.modeleditor.fbt.basicinterface.editpolicies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;
import de.netallied.functionblock.modeleditor.fbt.basicinterface.commands.DeleteInputValueCommand;
import de.netallied.functionblock.model.InputValueModel;
import de.netallied.functionblock.model.InputValueSegmentModel;

/**
 * Column component EditPolicy - handles column deletion
 */
public class InputValueEditPolicy extends ComponentEditPolicy
{

	protected Command createDeleteCommand(GroupRequest request)
	{
    return new DeleteInputValueCommand((InputValueModel) (getHost().getModel()));
	}
}