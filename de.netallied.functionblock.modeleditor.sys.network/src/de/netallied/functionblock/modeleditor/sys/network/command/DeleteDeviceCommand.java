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

import java.util.Iterator;
import java.util.List;
import org.eclipse.gef.commands.Command;
import de.netallied.functionblock.model.LinkModel;
import de.netallied.functionblock.model.DeviceModel;
import de.netallied.functionblock.model.SystemModel;

/**
 * A command to remove a shape from its parent.
 * The command can be undone or redone.
 * @author Elias Volanakis
 */
public class DeleteDeviceCommand extends Command 
{
  private final DeviceModel child;
  private final SystemModel parent;
  private List sourceConnections;
  
  /**
   * Create a command that will remove the shape from its parent.
   * @param parent the SystemModel containing the child
   * @param child    the Shape to remove
   * @throws IllegalArgumentException if any parameter is null
   */
  public DeleteDeviceCommand(SystemModel parent, DeviceModel child) 
  {
  	if (parent == null || child == null) 
    {
  		throw new IllegalArgumentException();
  	}
  	setLabel("device deletion");
  	this.parent = parent;
  	this.child = child;
  }


  /* (non-Javadoc)
   * @see org.eclipse.gef.commands.Command#canUndo()
   */
  public boolean canUndo() 
  {
  	return sourceConnections!=null;
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.gef.commands.Command#execute()
   */
  public void execute() 
  {
  	// store a copy of incoming & outgoing connections before proceeding 
  	sourceConnections = child.getSourceConnections();
    parent.removeElement(child);
  }
    
  /* (non-Javadoc)
   * @see org.eclipse.gef.commands.Command#redo()
   */
  public void redo() 
  {
  	parent.removeElement(child);
 		removeConnections(sourceConnections);
  }

  /* (non-Javadoc)
   * @see org.eclipse.gef.commands.Command#undo()
   */
  public void undo() 
  {
    parent.addElement(child); 
    addConnections(sourceConnections);
  }
  
  /**
   * Disconnects a List of Connections from their endpoints.
   * @param connections a non-null List of connections
   */
  private void removeConnections(List<LinkModel> connections) 
  {
  	for (LinkModel link : connections) 
    {
      parent.removeElement(link);
  	}
  }

  /**
   * Reconnects a List of Connections with their previous endpoints.
   * @param connections a non-null List of connections
   */
  private void addConnections(List<LinkModel> connections) 
  {
    for (LinkModel link : connections) 
    {
      parent.addElement(link);
    }
  }
}