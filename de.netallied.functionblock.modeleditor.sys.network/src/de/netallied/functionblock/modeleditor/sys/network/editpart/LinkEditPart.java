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
package de.netallied.functionblock.modeleditor.sys.network.editpart;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gef.editpolicies.ConnectionEditPolicy;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;
import org.eclipse.gef.requests.GroupRequest;
import de.netallied.functionblock.model.LinkModel;
import de.netallied.functionblock.model.ObjectModel;
import de.netallied.functionblock.modeleditor.sys.network.command.DeleteLinkCommand;
import de.netallied.functionblock.modeleditor.sys.network.figure.LinkFigure;

/**
 * Edit part for LinkModel model elements.
 * <p>This edit part must implement the PropertyChangeListener interface, 
 * so it can be notified of property changes in the corresponding model element.
 * </p>
 * @author Elias Volanakis
 */
public class LinkEditPart extends AbstractConnectionEditPart 	implements PropertyChangeListener 
{

  /**
   * Upon activation, attach to the model element as a property change listener.
   */
  public void activate() 
  {
  	if (!isActive()) 
    {
  		super.activate();
  		((ObjectModel) getModel()).addPropertyChangeListener(this);
  	}
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
   */
  protected void createEditPolicies() 
  {
  	// Selection handle edit policy. 
  	// Makes the connection show a feedback, when selected by the user.
  	installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE,	new ConnectionEndpointEditPolicy());
  	// Allows the removal of the connection model element
  	installEditPolicy(EditPolicy.CONNECTION_ROLE, new ConnectionEditPolicy() 
    {
  		protected Command getDeleteCommand(GroupRequest request) 
      {
  			return new DeleteLinkCommand(getCastedModel());
  		}
  	});
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
   */
  protected IFigure createFigure() 
  {
  	return new LinkFigure();
  }
  
  /**
   * Upon deactivation, detach from the model element as a property change listener.
   */
  public void deactivate() 
  {
  	if (isActive()) {
  		super.deactivate();
  		((ObjectModel) getModel()).removePropertyChangeListener(this);
  	}
  }
  
  public LinkModel getCastedModel() 
  {
  	return (LinkModel) getModel();
  }
  
  /* (non-Javadoc)
   * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
   */
  public void propertyChange(PropertyChangeEvent event) 
  {
  }
}