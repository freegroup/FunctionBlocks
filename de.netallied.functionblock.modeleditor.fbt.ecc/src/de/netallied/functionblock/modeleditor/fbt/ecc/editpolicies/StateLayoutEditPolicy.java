package de.netallied.functionblock.modeleditor.fbt.ecc.editpolicies;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.FlowLayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import de.netallied.functionblock.modeleditor.fbt.ecc.commands.CreateStateActionCommand;
import de.netallied.functionblock.model.ECCStateActionModel;
import de.netallied.functionblock.model.ECCStateModel;

/**
 * Handles moving of columns within and between tables
 */
public class StateLayoutEditPolicy extends FlowLayoutEditPolicy
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
      /*
      ECCStateActionModel childModel = (ECCStateActionModel) child.getModel();
      ECCStateActionModel afterModel = (ECCStateActionModel) after.getModel();

      InputEventSegmentModel parentModel = (InputEventSegmentModel) getHost().getModel();
			int oldIndex = getHost().getChildren().indexOf(child);
			int newIndex = getHost().getChildren().indexOf(after);

			return new MoveInputEventCommand(childModel, parentModel,oldIndex, newIndex);
      */
		}
		return null;
	}

	/**
	 * @param request
	 * @return
	 */
	protected Command getCreateCommand(CreateRequest request)
	{
    Object childClass = request.getNewObjectType();
    if (childClass == ECCStateActionModel.class)
    {
      return new CreateStateActionCommand( (ECCStateModel) getHost().getModel(), (ECCStateActionModel) request.getNewObject());
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