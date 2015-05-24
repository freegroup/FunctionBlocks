/*******************************************************************************
 * Copyright (c) 2004, 2005 Elias Volanakis and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Elias Volanakis - initial API and implementation
 *******************************************************************************/
package de.netallied.functionblock.modeleditor.sys.network.command;

import org.eclipse.gef.commands.Command;
import de.netallied.functionblock.model.LinkModel;
import de.netallied.functionblock.model.SystemModel;

/**
 * A command to disconnect (remove) a linkModel from its endpoints.
 * The command can be undone or redone.
 * @author Elias Volanakis
 */
public class DeleteLinkCommand extends Command 
{
  /** LinkModel instance to disconnect. */
  private final LinkModel linkModel;
  private final SystemModel systemModel;
  /** 
   * Create a command that will disconnect a linkModel from its endpoints.
   * @param conn the linkModel instance to disconnect (non-null)
   * @throws IllegalArgumentException if conn is null
   */ 
  public DeleteLinkCommand(LinkModel conn) 
  {
  	if (conn == null) 
    {
  		throw new IllegalArgumentException();
  	}
  	setLabel("linkModel deletion");
  	this.linkModel = conn;
    this.systemModel = conn.getSystemModel();
  }
  
  
  /* (non-Javadoc)
   * @see org.eclipse.gef.commands.Command#execute()
   */
  public void execute() 
  {
    this.systemModel.removeElement(linkModel);
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.gef.commands.Command#undo()
   */
  public void undo() 
  {
    this.systemModel.addElement(linkModel);
  }
}
