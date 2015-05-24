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
import java.util.List;
import org.eclipse.draw2d.ConnectionLayer;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ShortestPathConnectionRouter;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.RootComponentEditPolicy;
import de.netallied.functionblock.model.ObjectModel;
import de.netallied.functionblock.model.SystemModel;
import de.netallied.functionblock.modeleditor.sys.network.editpolicy.ModelXYLayoutEditPolicy;
import de.netallied.functionblock.modeleditor.sys.network.figure.SystemFigure;

/**
 * EditPart for the a SystemModel instance.
 * <p>This edit part server as the main diagram container, the white area where
 * everything else is in. Also responsible for the container's layout (the
 * way the container rearanges is contents) and the container's capabilities
 * (edit policies).
 * </p>
 * <p>This edit part must implement the PropertyChangeListener interface, 
 * so it can be notified of property changes in the corresponding model element.
 * </p>
 * 
 * @author Elias Volanakis
 */
public class SystemEditPart extends AbstractGraphicalEditPart implements PropertyChangeListener  
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
  	// disallows the removal of this edit part from its parent
  	installEditPolicy(EditPolicy.COMPONENT_ROLE, new RootComponentEditPolicy());
  	// handles constraint changes (e.g. moving and/or resizing) of model elements
  	// and creation of new model elements
  	installEditPolicy(EditPolicy.LAYOUT_ROLE,  new ModelXYLayoutEditPolicy());
  }

  /* (non-Javadoc)
   * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
   */
  protected IFigure createFigure() 
  {
  	Figure f = new SystemFigure();
  
  	// Create the static router for the connection layer
  	ConnectionLayer connLayer = (ConnectionLayer)getLayer(LayerConstants.CONNECTION_LAYER);
  	connLayer.setConnectionRouter(new ShortestPathConnectionRouter(f));
  	
  	return f;
  }

  /**
   * Upon deactivation, detach from the model element as a property change listener.
   */
  public void deactivate() 
  {
  	if (isActive()) 
    {
  		super.deactivate();
  		((ObjectModel) getModel()).removePropertyChangeListener(this);
  	}
  }
  
  private SystemModel getCastedModel() 
  {
  	return (SystemModel) getModel();
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.gef.editparts.AbstractEditPart#getModelChildren()
   */
  protected List getModelChildren() 
  {
  	return getCastedModel().getElements(); // return a list of shapes
  }

  /* (non-Javadoc)
   * @see java.beans.PropertyChangeListener#propertyChange(PropertyChangeEvent)
   */
  public void propertyChange(PropertyChangeEvent evt) 
  {
  	String prop = evt.getPropertyName();
  	// these properties are fired when Shapes are added into or removed from 
  	// the ShapeDiagram instance and must cause a call of refreshChildren()
  	// to update the diagram's contents.
    if (ObjectModel.PROPERTY_ELEMENT_REMOVED == prop) 
      refreshChildren();
    else if (ObjectModel.PROPERTY_ELEMENT_ADDED == prop) 
      refreshChildren();
  }

}