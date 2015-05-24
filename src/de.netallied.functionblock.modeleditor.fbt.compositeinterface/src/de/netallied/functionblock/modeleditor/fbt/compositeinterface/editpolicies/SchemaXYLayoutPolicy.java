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
 * Created on Jul 20, 2004
 */
package de.netallied.functionblock.modeleditor.fbt.compositeinterface.editpolicies;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;

/**
 * Handles manual layout editing for schema diagram. Only available for
 * XYLayoutManagers, not for automatic layout
 * 
 */
public class SchemaXYLayoutPolicy extends XYLayoutEditPolicy
{

  public SchemaXYLayoutPolicy()
  {
  }
  
	protected Command createAddCommand(EditPart child, Object constraint)
	{
		return null;
	}

	/**
	 * Creates command to move table. Does not allow table to be resized
	 */
	protected Command createChangeConstraintCommand(EditPart child, Object constraint)
	{
/*
		if (!(child instanceof TablePart))
			return null;
		if (!(constraint instanceof Rectangle))
			return null;

		TablePart tablePart = (TablePart) child;
		Table table = tablePart.getTable();
		TableFigure figure = (TableFigure) tablePart.getFigure();
		Rectangle oldBounds = figure.getBounds();
		Rectangle newBounds = (Rectangle) constraint;

		if (oldBounds.width != newBounds.width && newBounds.width != -1)
			return null;
		if (oldBounds.height != newBounds.height && newBounds.height != -1)
			return null;

		SchemaDiagramPart schemaPart = (SchemaDiagramPart) tablePart.getParent();

		TableMoveCommand command = new TableMoveCommand(table, oldBounds.getCopy(), newBounds.getCopy());
		return command;
		*/
		return null;
	}

	/**
	 * Returns the current bounds as the constraint if none can be found in the
	 * figures Constraint object
	 */
	public Rectangle getCurrentConstraintFor(GraphicalEditPart child)
	{
		IFigure fig = child.getFigure();
		Rectangle rectangle = (Rectangle) fig.getParent().getLayoutManager().getConstraint(fig);
		if (rectangle == null)
		{
			rectangle = fig.getBounds();
		}
		return rectangle;
	}

	protected Command getCreateCommand(CreateRequest request)
	{
		return null;
	}

	protected Command getDeleteDependantCommand(Request request)
	{
		return null;
	}

}