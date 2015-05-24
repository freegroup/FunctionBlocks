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
import java.util.Collections;
import java.util.List;
import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import de.netallied.functionblock.model.LinkModel;
import de.netallied.functionblock.model.ObjectModel;
import de.netallied.functionblock.model.SegmentModel;
import de.netallied.functionblock.modeleditor.sys.network.command.CreateLinkCommand;
import de.netallied.functionblock.modeleditor.sys.network.editpart.anchor.LeftWithAnchor;
import de.netallied.functionblock.modeleditor.sys.network.editpolicy.SegmentEditPolicy;
import de.netallied.functionblock.modeleditor.sys.network.figure.SegmentFigure;

/**
 * EditPart used for Shape instances (more specific for DeviceModel and
 * SegmentModel instances).
 * <p>This edit part must implement the PropertyChangeListener interface, 
 * so it can be notified of property changes in the corresponding model element.
 * </p>
 * 
 * @author Elias Volanakis
 */
public class SegmentEditPart extends PropertyAwareEditPart 	implements  NodeEditPart 
{
  private ConnectionAnchor anchor;
  
  
  /* (non-Javadoc)
   * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
   */
  protected void createEditPolicies() 
  {
  	// allow removal of the associated model element
  	installEditPolicy(EditPolicy.COMPONENT_ROLE, new SegmentEditPolicy());
  	// allow the creation of connections and 
  	// and the reconnection of connections between Shape instances
  	installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new GraphicalNodeEditPolicy() {
  		/* (non-Javadoc)
  		 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getConnectionCompleteCommand(org.eclipse.gef.requests.CreateConnectionRequest)
  		 */
  		protected Command getConnectionCompleteCommand(CreateConnectionRequest request) {
  			CreateLinkCommand cmd = (CreateLinkCommand) request.getStartCommand();
  			cmd.setTarget((SegmentModel) getHost().getModel());
  			return cmd;
  		}
  		/* (non-Javadoc)
  		 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getConnectionCreateCommand(org.eclipse.gef.requests.CreateConnectionRequest)
  		 */
  		protected Command getConnectionCreateCommand(CreateConnectionRequest request) {
        SegmentModel target = (SegmentModel) getHost().getModel();
  			CreateLinkCommand cmd = new CreateLinkCommand(target);
  			request.setStartCommand(cmd);
  			return cmd;
  		}
  		/* (non-Javadoc)
  		 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getReconnectSourceCommand(org.eclipse.gef.requests.ReconnectRequest)
  		 */
  		protected Command getReconnectSourceCommand(ReconnectRequest request) {
  			return null;
  		}
  		/* (non-Javadoc)
  		 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getReconnectTargetCommand(org.eclipse.gef.requests.ReconnectRequest)
  		 */
  		protected Command getReconnectTargetCommand(ReconnectRequest request) 
      {
        /*
  			LinkModel conn = (LinkModel) request.getConnectionEditPart().getModel();
        SegmentModel newTarget = (SegmentModel) getHost().getModel();
  			ConnectionReconnectCommand cmd = new ConnectionReconnectCommand(conn);
  			cmd.setNewTarget(newTarget);
  			return cmd;
        */
        return null;
  		}
  	});
  }
  	
  /*(non-Javadoc)
   * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
   */
  protected IFigure createFigure() 
  {
  	return new SegmentFigure();
  }
  
  
  private SegmentModel getCastedModel() 
  {
  	return (SegmentModel) getModel();
  }

  protected ConnectionAnchor getConnectionAnchor() 
  {
  	if (anchor == null) 
  			anchor = new LeftWithAnchor(getFigure());
  	return anchor;
  }

  /*
   * (non-Javadoc)
   * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#getModelSourceConnections()
   */
  protected List getModelSourceConnections() 
  {
  	return Collections.EMPTY_LIST;
  }
  
  /*
   * (non-Javadoc)
   * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#getModelTargetConnections()
   */
  protected List getModelTargetConnections() 
  {
  	return getCastedModel().getTargetConnections();
  }
  
  /*
   * (non-Javadoc)
   * @see org.eclipse.gef.NodeEditPart#getSourceConnectionAnchor(org.eclipse.gef.ConnectionEditPart)
   */
  public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) 
  {
    return getConnectionAnchor();
  }
  
  /*
   * (non-Javadoc)
   * @see org.eclipse.gef.NodeEditPart#getSourceConnectionAnchor(org.eclipse.gef.Request)
   */
  public ConnectionAnchor getSourceConnectionAnchor(Request request) 
  {
  	return getConnectionAnchor();
  }
  
  /*
   * (non-Javadoc)
   * @see org.eclipse.gef.NodeEditPart#getTargetConnectionAnchor(org.eclipse.gef.ConnectionEditPart)
   */
  public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection) 
  {
    return getConnectionAnchor();
  }

  /*
   * (non-Javadoc)
   * @see org.eclipse.gef.NodeEditPart#getTargetConnectionAnchor(org.eclipse.gef.Request)
   */
  public ConnectionAnchor getTargetConnectionAnchor(Request request) 
  {
  	return getConnectionAnchor();
  }
  
  /* (non-Javadoc)
   * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
   */
  public void propertyChange(PropertyChangeEvent evt) 
  {
  	String prop = evt.getPropertyName();
  	if (getModel() == evt.getSource()) 
  	  refreshVisuals();
    // Falls sich noch die Connections geändert haben sollte, muessen diese
    // auch aktualiesiert werden
    //
    if (ObjectModel.SOURCE_CONNECTIONS_PROP.equals(prop)) 
  		refreshSourceConnections();
    else if (ObjectModel.TARGET_CONNECTIONS_PROP.equals(prop)) 
  		refreshTargetConnections();
  }
  
  protected void refreshVisuals() 
  {
  	// notify parent container of changed position & location
  	// if this line is removed, the XYLayoutManager used by the parent container 
  	// (the Figure of the ShapesDiagramEditPart), will not know the bounds of this figure
  	// and will not draw it correctly.
  	Rectangle bounds = new Rectangle(getCastedModel().getLocation(),	getCastedModel().getSize());
  	((GraphicalEditPart) getParent()).setLayoutConstraint(this, getFigure(), bounds);
    ((SegmentFigure)getFigure()).setText(getCastedModel().getName()+" : "+getCastedModel().getType());
  }
}