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
package de.netallied.functionblock.modeleditor.res.network.editpart;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;
import de.netallied.functionblock.model.ObjectModel;
import de.netallied.functionblock.model.TransitionModel;
import de.netallied.functionblock.modeleditor.res.network.figures.TransitionFigure;


/**
 * Edit part for LinkModel model elements.
 * <p>
 * This edit part must implement the PropertyChangeListener interface, so it can
 * be notified of property changes in the corresponding model element.
 * </p>
 * 
 */
public abstract class TransitionEditPart extends AbstractConnectionEditPart implements PropertyChangeListener
{

  public TransitionEditPart()
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
      getObjectModel().addPropertyChangeListener(this);
    }
  }

  /**
   * Upon deactivation, detach from the model element as a property change
   * listener.
   */
  public void deactivate()
  {
    if (isActive())
    {
      super.deactivate();
      getObjectModel().removePropertyChangeListener(this);
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
   */
  protected void createEditPolicies()
  {
    // Selection handle edit policy.
    // Makes the connection show a feedback, when selected by the user.
    installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE, new ConnectionEndpointEditPolicy());
  }

  public ObjectModel getObjectModel()
  {
    return (ObjectModel)getModel();
  }
  
  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
   */
  protected IFigure createFigure()
  {
    return new TransitionFigure();
  }


  /*
   * (non-Javadoc)
   * 
   * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
   */
  public void propertyChange(PropertyChangeEvent evt)
  {
  }
  
  
}