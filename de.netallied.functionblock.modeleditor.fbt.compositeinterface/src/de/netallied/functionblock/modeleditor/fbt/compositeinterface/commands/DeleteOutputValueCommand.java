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
import de.netallied.functionblock.model.OutputValueModel;
import de.netallied.functionblock.model.OutputValueSegmentModel;

/**
 * Command to delete a event object
 * 
 */
public class DeleteOutputValueCommand extends Command
{
  private AbstractFunctionBlockModel parent;
  private OutputValueModel           value;
  
  private int index = -1;

  public DeleteOutputValueCommand(OutputValueModel value)
  {
    this.parent = value.getAbstractFunctionBlockModel();
    this.value  = value;
    this.index  = this.parent.getOutputValueModels().indexOf(value);
  }
  
  /**
   * @see org.eclipse.gef.commands.Command#execute()
   */
  public void execute()
  {
    parent.removeElement(value);
  }

  /**
   * @see org.eclipse.gef.commands.Command#undo()
   */
  public void undo()
  {
    parent.addElement(index,value);
  }
}

