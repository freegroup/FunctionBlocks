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

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;
import de.netallied.functionblock.model.SegmentModel;
import de.netallied.functionblock.model.SystemModel;


/**
 * A command to add a Shape to a ShapeDiagram.
 * The command can be undone or redone.
 * @author Elias Volanakis
 */
public class CreateSegmentCommand	extends Command 
{
  private SegmentModel model;
  private final SystemModel parent;
  private Rectangle bounds;

  /**
   * Create a command that will add a new Shape to a SystemModel.
   * @param model the new Shape that is to be added
   * @param parent the SystemModel that will hold the new element
   * @param bounds the bounds of the new shape; the size can be (-1, -1) if not known
   * @throws IllegalArgumentException if any parameter is null, or the request
   * 						  does not provide a new Shape instance
   */
  public CreateSegmentCommand(SegmentModel model, SystemModel parent, Rectangle bounds) 
  {
  	this.model = model;
  	this.parent = parent;
  	this.bounds = bounds;
    this.bounds.width = Math.max(this.bounds.width,100);
  	setLabel("segment creation");
  }
  
  /**
   * Can execute if all the necessary information has been provided. 
   * @see org.eclipse.gef.commands.Command#canExecute()
   */
  public boolean canExecute() 
  {
  	return model != null && parent != null && bounds != null;
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.gef.commands.Command#execute()
   */
  public void execute() 
  {
  	model.setLocation(bounds.getLocation());
    model.setSize(new Dimension(bounds.width,bounds.height));
    parent.addElement(model);
    String suggestedName = "Segment_";
    String newName = suggestedName;
    for (int i = 0; i < 1000; i++)
    {
      newName = suggestedName+i;
      if(parent.getSegmentModel(newName)==null)
         break;
    }
    model.setName(newName);
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.gef.commands.Command#redo()
   */
  public void redo() 
  {
  	parent.addElement(model);
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.gef.commands.Command#undo()
   */
  public void undo() 
  {
  	parent.removeElement(model);
  }

}