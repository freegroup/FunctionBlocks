package de.netallied.functionblock.modeleditor.fbt.ecc.util;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.jface.viewers.CellEditor;
import de.netallied.functionblock.model.INamedModel;

/**
 * EditPolicy for the direct editing of Column names
 * 
 */
public class EditableLabelDirectEditPolicy extends DirectEditPolicy
{
	private String oldValue;

	/**
	 * @see DirectEditPolicy#getDirectEditCommand(org.eclipse.gef.requests.DirectEditRequest)
	 */
	protected Command getDirectEditCommand(DirectEditRequest request)
	{
    INamedModel model = (INamedModel) getHost().getModel();
    ChangeNameCommand cmd = new ChangeNameCommand(model);
		cmd.setOldName(model.getName());
		CellEditor cellEditor = request.getCellEditor();
		cmd.setName((String) cellEditor.getValue());
		return cmd;
	}

	/**
	 * @see DirectEditPolicy#showCurrentEditValue(org.eclipse.gef.requests.DirectEditRequest)
	 */
	protected void showCurrentEditValue(DirectEditRequest request)
	{
		String value = (String) request.getCellEditor().getValue();
    EditableLabelEditPart columnPart = (EditableLabelEditPart) getHost();
    columnPart.handleNameChange(value);
	}

	/**
	 * @param to
	 *            Revert request
	 */
	protected void storeOldEditValue(DirectEditRequest request)
	{
		CellEditor cellEditor = request.getCellEditor();
		oldValue = (String) cellEditor.getValue();
	}

	/**
	 * @param request
	 */
	protected void revertOldEditValue(DirectEditRequest request)
	{
		CellEditor cellEditor = request.getCellEditor();
		cellEditor.setValue(oldValue);
    EditableLabelEditPart columnPart = (EditableLabelEditPart) getHost();
    columnPart.revertNameChange(oldValue);
	}
}