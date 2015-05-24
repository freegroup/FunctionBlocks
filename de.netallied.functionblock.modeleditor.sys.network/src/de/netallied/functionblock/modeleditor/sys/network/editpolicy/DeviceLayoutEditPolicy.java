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
package de.netallied.functionblock.modeleditor.sys.network.editpolicy;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.FlowLayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import de.netallied.functionblock.model.AbstractPortModel;
import de.netallied.functionblock.model.DeviceTypeModel;
import de.netallied.functionblock.model.InputEventSegmentModel;
import de.netallied.functionblock.model.ResourceModel;
import de.netallied.functionblock.modeleditor.sys.network.command.MoveResourceModelCommand;

/**
 * Handles moving of columns within and between tables
 * @author Phil Zoio
 */
public class DeviceLayoutEditPolicy extends FlowLayoutEditPolicy
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
      ResourceModel childModel = (ResourceModel) child.getModel();
      ResourceModel afterModel = (ResourceModel) after.getModel();

      DeviceTypeModel parentModel = (DeviceTypeModel) getHost().getModel();
			int oldIndex = getHost().getChildren().indexOf(child);
			int newIndex = getHost().getChildren().indexOf(after);

			return new MoveResourceModelCommand(childModel, parentModel,oldIndex, newIndex);
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
      InputEventSegmentModel parentModel = (InputEventSegmentModel) getHost().getModel();
      
 //     return new CreateInputEventCommand(parentModel.getFunctionBlockModel(),0);
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