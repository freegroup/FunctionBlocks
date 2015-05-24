package de.netallied.functionblock.modeleditor.fbt.basicinterface.editpolicies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;
import de.netallied.functionblock.modeleditor.fbt.basicinterface.commands.DeleteOutputValueCommand;
import de.netallied.functionblock.model.OutputValueModel;
import de.netallied.functionblock.model.OutputValueSegmentModel;

/**
 * Column component EditPolicy - handles column deletion
 * @author Phil Zoio
 */
public class OutputValueEditPolicy extends ComponentEditPolicy
{

	protected Command createDeleteCommand(GroupRequest request)
	{
    return new DeleteOutputValueCommand((OutputValueModel) (getHost().getModel()));
	}
}