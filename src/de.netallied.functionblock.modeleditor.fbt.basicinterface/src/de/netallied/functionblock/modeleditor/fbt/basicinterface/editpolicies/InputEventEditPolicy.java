package de.netallied.functionblock.modeleditor.fbt.basicinterface.editpolicies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;
import de.netallied.functionblock.modeleditor.fbt.basicinterface.commands.DeleteInputEventCommand;
import de.netallied.functionblock.model.InputEventModel;
import de.netallied.functionblock.model.InputEventSegmentModel;

/**
 * Column component EditPolicy - handles column deletion
 * @author Phil Zoio
 */
public class InputEventEditPolicy extends ComponentEditPolicy
{

	protected Command createDeleteCommand(GroupRequest request)
	{
    return new DeleteInputEventCommand((InputEventModel) (getHost().getModel()));
	}
}