/*******************************************************************************
 * Copyright (c) 2004 Elias Volanakis.
 �* All rights reserved. This program and the accompanying materials
 �* are made available under the terms of the Common Public License v1.0
 �* which accompanies this distribution, and is available at
 �* http://www.eclipse.org/legal/cpl-v10.html
 �*
 �* Contributors:
 �*����Elias Volanakis - initial API and implementation
 �*******************************************************************************/
package de.netallied.functionblock.modeleditor.fbt.network.editpart;

import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ConnectionEditPolicy;
import org.eclipse.gef.requests.GroupRequest;
import de.netallied.functionblock.model.EventTransitionModel;
import de.netallied.functionblock.modeleditor.fbt.network.command.DeleteEventTransitionCommand;


/**
 * Edit part for LinkModel model elements.
 * <p>
 * This edit part must implement the PropertyChangeListener interface, so it can
 * be notified of property changes in the corresponding model element.
 * </p>
 * 
 */
public class EventTransitionEditPart extends TransitionEditPart
{

  public EventTransitionModel getEventTransitionModel()
  {
    return (EventTransitionModel)getModel();
  }
  
  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
   */
  @Override
  protected void createEditPolicies()
  {
  	super.createEditPolicies();

  	installEditPolicy(EditPolicy.CONNECTION_ROLE, new ConnectionEditPolicy()
    {
      protected Command getDeleteCommand(GroupRequest request)
      {
        return new DeleteEventTransitionCommand(getEventTransitionModel());
      }
    });
  }
 
}