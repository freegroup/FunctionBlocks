/*******************************************************************************
 * Copyright (c) 2004 Elias Volanakis.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 *
 * Contributors:
 *����Elias Volanakis - initial API and implementation
 *******************************************************************************/
package de.netallied.functionblock.modeleditor.fbt.network.editpolicy;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;
import de.netallied.functionblock.model.CompositeInputEventModel;
import de.netallied.functionblock.model.CompositeInputValueModel;
import de.netallied.functionblock.model.CompositeOutputEventModel;
import de.netallied.functionblock.model.CompositeOutputValueModel;
import de.netallied.functionblock.model.InstanceFunctionBlockModel;
import de.netallied.functionblock.model.NetworkModel;
import de.netallied.functionblock.modeleditor.fbt.network.command.DeleteCompositeInputEventCommand;
import de.netallied.functionblock.modeleditor.fbt.network.command.DeleteCompositeInputValueCommand;
import de.netallied.functionblock.modeleditor.fbt.network.command.DeleteCompositeOutputEventCommand;
import de.netallied.functionblock.modeleditor.fbt.network.command.DeleteCompositeOutputValueCommand;
import de.netallied.functionblock.modeleditor.fbt.network.command.DeleteInstanceFunctionBlockCommand;


/**
 * This edit policy enables the removal of a Shapes instance from its container.
 */
public class ObjectModelComponentEditPolicy extends ComponentEditPolicy
{
	/*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.editpolicies.ComponentEditPolicy#createDeleteCommand(org.eclipse.gef.requests.GroupRequest)
   */
  protected Command createDeleteCommand(GroupRequest deleteRequest)
  {
    Object parent = getHost().getParent().getModel();
    Object child = getHost().getModel();

    if (parent instanceof NetworkModel && child instanceof InstanceFunctionBlockModel)
      return new DeleteInstanceFunctionBlockCommand((NetworkModel) parent, (InstanceFunctionBlockModel)child);

    if(parent instanceof NetworkModel && child instanceof CompositeInputEventModel)
      return new DeleteCompositeInputEventCommand((NetworkModel) parent, (CompositeInputEventModel)child);

    if(parent instanceof NetworkModel && child instanceof CompositeOutputEventModel)
      return new DeleteCompositeOutputEventCommand((NetworkModel) parent, (CompositeOutputEventModel)child);

    if(parent instanceof NetworkModel && child instanceof CompositeInputValueModel)
      return new DeleteCompositeInputValueCommand((NetworkModel) parent, (CompositeInputValueModel)child);

    if(parent instanceof NetworkModel && child instanceof CompositeOutputValueModel)
      return new DeleteCompositeOutputValueCommand((NetworkModel) parent, (CompositeOutputValueModel)child);

    return null;
  }
}