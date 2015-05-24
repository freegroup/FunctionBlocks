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
package de.netallied.functionblock.modeleditor.fbt.basicinterface.commands;

import org.eclipse.gef.commands.Command;
import de.netallied.functionblock.model.OutputEventModel;
import de.netallied.functionblock.model.OutputEventSegmentModel;

/**
 * Command to move a InputEventPort to a different index location within the InputEventSegment
 * 
 */
public class MoveOutputEventCommand extends Command
{

	private int oldIndex;
  private int newIndex;
	private OutputEventModel childColumn;
	private OutputEventSegmentModel parentTable;

	public MoveOutputEventCommand(OutputEventModel child, OutputEventSegmentModel parent, int oldIndex, int newIndex)
	{
		this.childColumn = child;
		this.parentTable = parent;
		this.oldIndex = oldIndex;
		this.newIndex = newIndex;
		if (this.newIndex > this.oldIndex)
			this.newIndex--; //this is because the column is deleted before it is
						// added
	}

	public void execute()
	{
		parentTable.setFieldPosition(childColumn, newIndex);
	}

	public void undo()
	{
		parentTable.setFieldPosition(childColumn, oldIndex);
	}

}