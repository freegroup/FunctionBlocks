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
 * Created on Jul 18, 2004
 */
package de.netallied.functionblock.modeleditor.res.network.util;

import org.eclipse.gef.commands.Command;
import de.netallied.functionblock.model.INamedModel;

/**
 * Command to change the name field
 * 
 */
public class ChangeNameCommand extends Command
{
	private INamedModel model;
	private String name, oldName;


  /**
   * @param table
   *            The table to set.
   */
  public ChangeNameCommand(INamedModel model)
  {
    this.model = model;
  }
  /**
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	public void execute()
	{
		model.setName(name);
	}


	/**
	 * Sets the new Column name
	 * 
	 * @param string
	 *            the new name
	 */
	public void setName(String string)
	{
		this.name = string;
	}

	/**
	 * Sets the old Column name
	 * 
	 * @param string
	 *            the old name
	 */
	public void setOldName(String string)
	{
		oldName = string;
	}


	/**
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	public void undo()
	{
		model.setName(oldName);
	}

}