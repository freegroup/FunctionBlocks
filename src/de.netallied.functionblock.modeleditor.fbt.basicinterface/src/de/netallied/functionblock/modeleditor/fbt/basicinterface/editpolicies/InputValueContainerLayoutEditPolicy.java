package de.netallied.functionblock.modeleditor.fbt.basicinterface.editpolicies;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.FlowLayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;

import de.netallied.functionblock.modeleditor.fbt.basicinterface.commands.CreateInputValueCommand;
import de.netallied.functionblock.modeleditor.fbt.basicinterface.commands.MoveInputValueCommand;
import de.netallied.functionblock.model.AbstractPortModel;
import de.netallied.functionblock.model.InputValueModel;
import de.netallied.functionblock.model.InputValueSegmentModel;

public class InputValueContainerLayoutEditPolicy extends FlowLayoutEditPolicy
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
      InputValueModel childModel = (InputValueModel) child.getModel();
      InputValueModel afterModel = (InputValueModel) after.getModel();

      InputValueSegmentModel parentModel = (InputValueSegmentModel) getHost().getModel();
			int oldIndex = getHost().getChildren().indexOf(child);
			int newIndex = getHost().getChildren().indexOf(after);

			return new MoveInputValueCommand(childModel, parentModel,oldIndex, newIndex);
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
      InputValueSegmentModel parentModel = (InputValueSegmentModel) getHost().getModel();
      
			return new CreateInputValueCommand(parentModel.getAbstractFunctionBlockModel(),0);
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