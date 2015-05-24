/*******************************************************************************
 * Copyright (c) 2005, 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
/*
 * Created on Jul 15, 2004
 */
package de.netallied.functionblock.modeleditor.fbt.compositeinterface.editpolicies;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.FlowLayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;

/**
 * Handles moving of columns within and between tables
 */
public class TableLayoutEditPolicy extends FlowLayoutEditPolicy
{

	/**
	 * Creates command to transfer child column to after column (in another
	 * table)
	 */
	protected Command createAddCommand(EditPart child, EditPart after)
	{
		return null;
/*
		if (!(child instanceof ColumnPart))
			return null;
		if (!(after instanceof ColumnPart))
			return null;

		Column toMove = (Column) child.getModel();
		Column afterModel = (Column) after.getModel();

		TablePart originalTablePart = (TablePart) child.getParent();
		Table originalTable = (Table) originalTablePart.getModel();
		TablePart newTablePart = (TablePart) after.getParent();
		Table newTable = newTablePart.getTable();

		int oldIndex = originalTablePart.getChildren().indexOf(child);
		int newIndex = newTablePart.getChildren().indexOf(after);

		ColumnTransferCommand command = new ColumnTransferCommand(toMove, afterModel, originalTable, newTable,
				oldIndex, newIndex);
		return command;
*/
	}

	/**
	 * Creates command to transfer child column to after specified column
	 * (within table)
	 */
	protected Command createMoveChildCommand(EditPart child, EditPart after)
	{
		/*
		if (after != null)
		{
			Column childModel = (Column) child.getModel();
			Column afterModel = (Column) after.getModel();

			Table parentTable = (Table) getHost().getModel();
			int oldIndex = getHost().getChildren().indexOf(child);
			int newIndex = getHost().getChildren().indexOf(after);

			MoveInputEventCommand command = new MoveInputEventCommand(childModel, parentTable, oldIndex, newIndex);
			return command;
		}
		*/
		return null;
	}

	/**
	 * @param request
	 * @return
	 */
	protected Command getCreateCommand(CreateRequest request)
	{
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