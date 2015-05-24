package de.netallied.functionblock.modeleditor.fbt.basicinterface.editpolicies;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.FlowLayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;

import de.netallied.functionblock.modeleditor.fbt.basicinterface.commands.CreateOutputValueCommand;
import de.netallied.functionblock.modeleditor.fbt.basicinterface.commands.MoveOutputValueCommand;
import de.netallied.functionblock.model.AbstractPortModel;
import de.netallied.functionblock.model.OutputValueModel;
import de.netallied.functionblock.model.OutputValueSegmentModel;

/**
 * Handles moving of columns within and between tables
 */
public class OutputValueContainerLayoutEditPolicy extends FlowLayoutEditPolicy
{

	/**
	 * Creates command to transfer child column to after column (in another
	 * table)
	 */
	protected Command createAddCommand(EditPart child, EditPart after)
	{
    return null;
	}

	/**
	 * Creates command to transfer child column to after specified column
	 * (within table)
	 */
	protected Command createMoveChildCommand(EditPart child, EditPart after)
	{
		if (after != null)
		{
      OutputValueModel childModel = (OutputValueModel) child.getModel();
      OutputValueModel afterModel = (OutputValueModel) after.getModel();

      OutputValueSegmentModel parentModel = (OutputValueSegmentModel) getHost().getModel();
			int oldIndex = getHost().getChildren().indexOf(child);
			int newIndex = getHost().getChildren().indexOf(after);

			return new MoveOutputValueCommand(childModel, parentModel,oldIndex, newIndex);
		}
		return null;
	}

	/**
	 * @param request
	 * @return
	 */
	protected Command getCreateCommand(CreateRequest request)
	{
		if(request.getNewObjectType() == AbstractPortModel.class)
		{
      OutputValueSegmentModel parentModel = (OutputValueSegmentModel) getHost().getModel();
      
			return new CreateOutputValueCommand(parentModel.getFunctionBlockModel(),0);
		}
		return null;
	}

	/**
	 * @param request
	 * @return
	 */
	protected Command getDeleteDependantCommand(Request request)
	{
		return null;
	}

}