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
package de.netallied.functionblock.modeleditor.fbt.basicinterface.editpart;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gef.editpolicies.ConnectionEditPolicy;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;
import org.eclipse.gef.requests.GroupRequest;
import de.netallied.functionblock.modeleditor.fbt.basicinterface.commands.DeleteWithTransitionInCommand;
import de.netallied.functionblock.modeleditor.fbt.basicinterface.figures.WithTransitionFigure;
import de.netallied.functionblock.model.BasisFunctionBlockModel;
import de.netallied.functionblock.model.WithTransitionInModel;


/**
 * Edit part for LinkModel model elements.
 * <p>
 * This edit part must implement the PropertyChangeListener interface, so it can
 * be notified of property changes in the corresponding model element.
 * </p>
 * 
 */
public class WithTransitionInEditPart extends AbstractConnectionEditPart implements PropertyChangeListener
{

  public WithTransitionInEditPart()
  {
  }
  
  /**
   * Upon activation, attach to the model element as a property change listener.
   */
  public void activate()
  {
    if (!isActive())
    {
      super.activate();
      getWithTransitionModel().addPropertyChangeListener(this);
    }
  }

  /**
   * Upon deactivation, detach from the model element as a property change
   * listener.
   */
  @Override
  public void deactivate()
  {
    if (isActive())
    {
      super.deactivate();
      getWithTransitionModel().removePropertyChangeListener(this);
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
   */
  @Override
  protected void createEditPolicies()
  {
    // Selection handle edit policy.
    // Makes the connection show a feedback, when selected by the user.
    installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE, new ConnectionEndpointEditPolicy());
    installEditPolicy(EditPolicy.CONNECTION_ROLE, new ConnectionEditPolicy()
    {
      protected Command getDeleteCommand(GroupRequest request)
      {
        WithTransitionInModel t = getWithTransitionModel();
        BasisFunctionBlockModel fb= (BasisFunctionBlockModel)t.getFromObjectModel().getAbstractFunctionBlockModel();
        return new DeleteWithTransitionInCommand(fb,t);
       
      }
    });
  }

  public WithTransitionInModel getWithTransitionModel()
  {
    return (WithTransitionInModel)getModel();
  }
  
  
  @Override
	public void performRequest(Request request)
	{
		if (request.getType() == RequestConstants.REQ_DIRECT_EDIT)
		{
      System.out.println("direct edit of transition");
		}
		else
		  super.performRequest(request);
	}
  
  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
   */
  @Override
  protected IFigure createFigure()
  {
    return new WithTransitionFigure();
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
   */
  public void propertyChange(PropertyChangeEvent evt)
  {
    if (evt.getSource() == getModel())
      refreshVisuals();
  }
}