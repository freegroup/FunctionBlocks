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
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import de.netallied.functionblock.cache.DeviceTypeModelCache;
import de.netallied.functionblock.cache.FBTypeModelCache;
import de.netallied.functionblock.model.DeviceModel;
import de.netallied.functionblock.model.ObjectModel;
import de.netallied.functionblock.modeleditor.sys.network.command.CreateLinkCommand;
import de.netallied.functionblock.modeleditor.sys.network.editpart.anchor.TopOrBottomCenterAnchor;
import de.netallied.functionblock.modeleditor.sys.network.editpolicy.DeviceEditPolicy;
import de.netallied.functionblock.modeleditor.sys.network.editpolicy.DeviceLayoutEditPolicy;
import de.netallied.functionblock.modeleditor.sys.network.figure.DeviceFigure;
import de.netallied.functionblock.modeleditor.sys.network.util.EditableLabelEditPart;

/**
 * EditPart used for Shape instances (more specific for DeviceModel and
 * SegmentModel instances).
 * <p>This edit part must implement the PropertyChangeListener interface, 
 * so it can be notified of property changes in the corresponding model element.
 * </p>
 * 
 * @author Elias Volanakis
 */
public class DeviceEditPart extends EditableLabelEditPart implements NodeEditPart 
{
  private ConnectionAnchor anchor;
  
  
  @Override
  protected void addChildVisual(EditPart arg0, int arg1)
  {
    // Erste Element ist der Name des Objektes
    // Zweites ist der Typ.
    // Die Kinder kommen dann erst zwei Stellen danach.
    //
    super.addChildVisual(arg0, arg1+2);
  }

  @Override
  public void performRequest(Request request)
  {
    if(request.getType() == RequestConstants.REQ_OPEN)
    {
      final IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();

      final IWorkbenchPage page = window.getActivePage();
      try {
        IProject project = getDeviceModel().getSystemModel().getProject();
        IFile file =DeviceTypeModelCache.getIFile(project,getDeviceModel().getDeviceTypeModel());
        IDE.openEditor(page, file, true);
      } catch (final PartInitException e) {
        e.printStackTrace();
      }
    }
    else
      super.performRequest(request);
  }

  
  /* (non-Javadoc)
   * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
   */
  public void createEditPolicies() 
  {
    super.createEditPolicies();
  	// allow removal of the associated model element
//    installEditPolicy(EditPolicy.LAYOUT_ROLE, new DeviceLayoutEditPolicy());
    
  	installEditPolicy(EditPolicy.COMPONENT_ROLE, new DeviceEditPolicy());
  	// allow the creation of connections and 
  	// and the reconnection of connections between Shape instances
  	installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new GraphicalNodeEditPolicy() {
  		/* (non-Javadoc)
  		 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getConnectionCompleteCommand(org.eclipse.gef.requests.CreateConnectionRequest)
  		 */
  		protected Command getConnectionCompleteCommand(CreateConnectionRequest request) 
      {
  			CreateLinkCommand cmd = (CreateLinkCommand) request.getStartCommand();
  			cmd.setSource((DeviceModel) getHost().getModel());
  			return cmd;
  		}
  		/* (non-Javadoc)
  		 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getConnectionCreateCommand(org.eclipse.gef.requests.CreateConnectionRequest)
  		 */
  		protected Command getConnectionCreateCommand(CreateConnectionRequest request) 
      {
        DeviceModel source = (DeviceModel) getHost().getModel();
  			CreateLinkCommand cmd = new CreateLinkCommand(source);
  			request.setStartCommand(cmd);
  			return cmd;
  		}
  		/* (non-Javadoc)
  		 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getReconnectSourceCommand(org.eclipse.gef.requests.ReconnectRequest)
  		 */
  		protected Command getReconnectSourceCommand(ReconnectRequest request) 
      {
        /*
  			LinkModel conn = (LinkModel) request.getConnectionEditPart().getModel();
        DeviceModel newSource = (DeviceModel) getHost().getModel();
  			ConnectionReconnectCommand cmd = new ConnectionReconnectCommand(conn);
  			cmd.setNewSource(newSource);
  			return cmd;
        */
        return null;
  		}
  		/* (non-Javadoc)
  		 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getReconnectTargetCommand(org.eclipse.gef.requests.ReconnectRequest)
  		 */
  		protected Command getReconnectTargetCommand(ReconnectRequest request) 
      {
  			return null;
  		}
  	});
  }
  	
  /*(non-Javadoc)
   * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
   */
  protected IFigure createFigure() 
  {
  	return new DeviceFigure();
  }
  
  
  @Override
  protected List getModelChildren()
  {
    return getDeviceModel().getElements();
  }

  
  private DeviceModel getDeviceModel() 
  {
  	return (DeviceModel) getModel();
  }
  
  protected ConnectionAnchor getConnectionAnchor() 
  {
  	if (anchor == null) 
 			anchor = new TopOrBottomCenterAnchor(getFigure());
  	return anchor;
  }
  
  /*
   * (non-Javadoc)
   * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#getModelSourceConnections()
   */
  protected List getModelSourceConnections() 
  {
  	return getDeviceModel().getSourceConnections();
  }
  
  /*
   * (non-Javadoc)
   * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#getModelTargetConnections()
   */
  protected List getModelTargetConnections() 
  {
  	return Collections.EMPTY_LIST;
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

    // Falls sich noch eine Connection geändert hat, dann müssen diese
    // auch angepasst werden
    //
    if (ObjectModel.SOURCE_CONNECTIONS_PROP == prop) 
  		refreshSourceConnections();
  	else if (ObjectModel.TARGET_CONNECTIONS_PROP == prop) 
  		refreshTargetConnections();
  }

  protected void refreshVisuals() 
  {
  	// notify parent container of changed position & location
  	// if this line is removed, the XYLayoutManager used by the parent container 
  	// (the Figure of the ShapesDiagramEditPart), will not know the bounds of this figure
  	// and will not draw it correctly.
  	Rectangle bounds = new Rectangle(getDeviceModel().getLocation(),new Dimension(-1,-1));
  	((GraphicalEditPart) getParent()).setLayoutConstraint(this, getFigure(), bounds);
    ((DeviceFigure)getFigure()).setName(getDeviceModel().getName());
    if(getDeviceModel().getDeviceTypeModel()==null)
      ((DeviceFigure)getFigure()).setType("unknown");
    else
      ((DeviceFigure)getFigure()).setType(getDeviceModel().getDeviceTypeModel().getName());
  }
}