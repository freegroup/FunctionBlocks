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
import org.eclipse.gef.commands.Command;
import de.netallied.functionblock.model.DeviceModel;
import de.netallied.functionblock.model.LinkModel;
import de.netallied.functionblock.model.SegmentModel;


/**
 * A command to create a linkModel between two shapes.
 * The command can be undone or redone.
 * <p>
 * This command is designed to be used together with a GraphicalNodeEditPolicy.
 * To use this command properly, following steps are necessary:
 * </p>
 * <ol>
 * <li>Create a subclass of GraphicalNodeEditPolicy.</li>
 * <li>Override the <tt>getConnectionCreateCommand(...)</tt> method, 
 * to create a new instance of this class and put it into the CreateConnectionRequest.</li>
 * <li>Override the <tt>getConnectionCompleteCommand(...)</tt>  method,
 * to obtain the Command from the ConnectionRequest, call setTarget(...) to set the
 * target endpoint of the linkModel and return this command instance.</li>
 * </ol>
 * @see de.netallied.functionblock.modeleditor.sys.network.editpart.SegmentEditPart#createEditPolicies() for an
 * 			 example of the above procedure.
 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy
 * @author Elias Volanakis
 */
public class CreateLinkCommand extends Command 
{
  /** The linkModel instance. */
  private LinkModel linkModel;
  
  /** Start endpoint for the linkModel. */
  private DeviceModel source;
  private SegmentModel target;

  /**
   *	Instantiate a command that can create a linkModel between two shapes.
   * @param source the source endpoint (a non-null Shape instance)
   * @param lineStyle the desired line style. See LinkModel#setLineStyle(int) for details
   * @throws IllegalArgumentException if source is null
   * @see LinkModel#setLineStyle(int)
   */
  public CreateLinkCommand(SegmentModel target) 
  {
  	if (target == null) 
    {
  		throw new IllegalArgumentException();
  	}
  	setLabel("linkModel creation");
  	this.target = target;
  }
  
  public CreateLinkCommand(DeviceModel source) 
  {
    if (source == null) 
    {
      throw new IllegalArgumentException();
    }
    setLabel("linkModel creation");
    this.source = source;
  }

  /* (non-Javadoc)
   * @see org.eclipse.gef.commands.Command#canExecute()
   */
  public boolean canExecute() 
  {/*
  	// disallow source -> source connections
  	if (source.equals(target)) 
    {
  		return false;
  	}
  	// return false, if the source -> target linkModel exists already
  	for (Iterator iter = source.getSourceConnections().iterator(); iter.hasNext();) 
    {
  		LinkModel conn = (LinkModel) iter.next();
  		if (conn.getTarget().equals(target)) {
  			return false;
  		}
  	}
    */
  	return true;
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.gef.commands.Command#execute()
   */
  public void execute() 
  {
  	// create a new linkModel between source and target
  	linkModel = new LinkModel(source, target);
    source.getSystemModel().addElement(linkModel);
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.gef.commands.Command#redo()
   */
  public void redo() 
  {
  	source.getSystemModel().addElement(linkModel);
  }
  
  /**
   * Set the target endpoint for the linkModel.
   * @param target that target endpoint (a non-null Shape instance)
   * @throws IllegalArgumentException if target is null
   */
  public void setTarget(SegmentModel target) 
  {
  	if (target == null) {
  		throw new IllegalArgumentException();
  	}
  	this.target = target;
  }
  
  public void setSource(DeviceModel source) 
  {
    if (source == null) {
      throw new IllegalArgumentException();
    }
    this.source = source;
  }
  /* (non-Javadoc)
   * @see org.eclipse.gef.commands.Command#undo()
   */
  public void undo() 
  {
  	source.getSystemModel().removeElement(linkModel);
  }
}
