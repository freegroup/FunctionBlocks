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
import de.netallied.functionblock.modeleditor.fbt.compositeinterface.commands.CreateOutputValueCommand;
import de.netallied.functionblock.modeleditor.fbt.compositeinterface.commands.MoveOutputValueCommand;
import de.netallied.functionblock.model.AbstractPortModel;
import de.netallied.functionblock.model.OutputValueModel;
import de.netallied.functionblock.model.OutputValueSegmentModel;

/**
 * Handles moving of columns within and between tables
 * @author Phil Zoio
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