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
 * Created on Jul 17, 2004
 */
package de.netallied.functionblock.modeleditor.fbt.compositeinterface.commands;

import org.eclipse.gef.commands.Command;
import de.netallied.functionblock.model.AbstractFunctionBlockModel;
import de.netallied.functionblock.model.InputValueModel;
import de.netallied.functionblock.model.InputValueSegmentModel;

/**
 * Command to delete a event object
 * 
 */
public class DeleteInputValueCommand extends Command
{
	private AbstractFunctionBlockModel parent;
	private InputValueModel        event;
	
  private int index = -1;

  public DeleteInputValueCommand(InputValueModel event)
  {
    this.parent = event.getAbstractFunctionBlockModel();
    this.event  = event;
    this.index  = this.parent.getInputValueModels().indexOf(event);
  }
  
	/**
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	public void execute()
	{
    parent.removeElement(event);
	}

	/**
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	public void undo()
	{
		parent.addElement(index,event);
	}

}

