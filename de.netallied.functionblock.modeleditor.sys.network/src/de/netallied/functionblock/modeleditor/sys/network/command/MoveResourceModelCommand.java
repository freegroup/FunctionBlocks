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
 * Created on Jul 19, 2004
 */
package de.netallied.functionblock.modeleditor.sys.network.command;

import org.eclipse.gef.commands.Command;
import de.netallied.functionblock.model.DeviceTypeModel;
import de.netallied.functionblock.model.InputEventModel;
import de.netallied.functionblock.model.InputEventSegmentModel;
import de.netallied.functionblock.model.ResourceModel;
import de.netallied.functionblock.model.ResourceTypeModel;

/**
 * Command to move a InputEventPort to a different index location within the InputEventSegment
 * 
 */
public class MoveResourceModelCommand extends Command
{

	private int oldIndex;
  private int newIndex;
	private ResourceModel resource;
	private DeviceTypeModel device;

	public MoveResourceModelCommand(ResourceModel child, DeviceTypeModel parent, int oldIndex, int newIndex)
	{
		this.resource = child;
		this.device = parent;
		this.oldIndex = oldIndex;
		this.newIndex = newIndex;
    if (this.newIndex > this.oldIndex)
      this.newIndex--; //this is because the column is deleted before it is
	}

	public void execute()
	{
//		device.setFieldPosition(resource, newIndex);
	}

	public void undo()
	{
//		device.setFieldPosition(resource, oldIndex);
	}

}