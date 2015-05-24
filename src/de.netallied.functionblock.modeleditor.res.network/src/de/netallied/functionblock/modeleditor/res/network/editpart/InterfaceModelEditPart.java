package de.netallied.functionblock.modeleditor.res.network.editpart;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import de.netallied.functionblock.model.AbstractInterfaceModel;
import de.netallied.functionblock.model.NetworkModel;
import de.netallied.functionblock.model.ObjectModel;
import de.netallied.functionblock.modeleditor.res.network.editpart.anchor.LeftMiddleAnchor;
import de.netallied.functionblock.modeleditor.res.network.editpart.anchor.RightMiddleAnchor;


public abstract class InterfaceModelEditPart extends AbstractGraphicalEditPart implements PropertyChangeListener, NodeEditPart
{
  public InterfaceModelEditPart()
  {
  }
  
  /**
   * Upon activation, attach to the model element as a property change listener.
   */
  public final void activate()
  {
    if (!isActive())
    {
      super.activate();
      getInterfaceModel().addPropertyChangeListener(this);
    }
  }

  public IFigure getFigure()
  {
    return super.getFigure();
  }
  
  /**
   * Upon deactivation, detach from the model element as a property change
   * listener.
   */
  public final void deactivate()
  {
    if (isActive())
    {
      super.deactivate();
      getInterfaceModel().removePropertyChangeListener(this);
    }
  }

	public void performRequest(Request request)
	{
	  if(request.getType()== RequestConstants.REQ_OPEN)
    {
//      org.eclipse.swt.widgets.Display display = org.eclipse.swt.widgets.Display.getDefault();   
//      new SelectBusinessMethodDialog(display.getActiveShell(),(BusinessObjectModel)getModel()).open();
    }
	  else
	  {
		  super.performRequest(request);
	  }
	}

	/*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
   */
  public abstract IFigure createFigure();


 
  protected AbstractInterfaceModel getInterfaceModel()
  {
    return (AbstractInterfaceModel) getModel();
  }

  public NetworkModel getNetworkModel()
  {
    // ....or of an InstanceFunctionBlock
    //
  	// this=>InstanceFunctionBlock=>CompositeFunctionBlockModel
  	return (NetworkModel)getParent().getParent().getModel();
  }
  

	/*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.NodeEditPart#getSourceConnectionAnchor(org.eclipse.gef.ConnectionEditPart)
   */
  public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection)
  {
    return new RightMiddleAnchor(getFigure());
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.NodeEditPart#getSourceConnectionAnchor(org.eclipse.gef.Request)
   */
  public ConnectionAnchor getSourceConnectionAnchor(Request request)
  {
    return new RightMiddleAnchor(getFigure());
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.NodeEditPart#getTargetConnectionAnchor(org.eclipse.gef.ConnectionEditPart)
   */
  public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection)
  {
    return new LeftMiddleAnchor(getFigure());
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.NodeEditPart#getTargetConnectionAnchor(org.eclipse.gef.Request)
   */
  public ConnectionAnchor getTargetConnectionAnchor(Request request)
  {
    return new LeftMiddleAnchor(getFigure());
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
   */
  public void propertyChange(PropertyChangeEvent evt)
  {
    String prop = evt.getPropertyName();
    if (ObjectModel.PROPERTY_POSITION_CHANGED==prop)
      refreshVisuals();
    else if (ObjectModel.SOURCE_CONNECTIONS_PROP==prop)
      refreshSourceConnections();
    else if (ObjectModel.TARGET_CONNECTIONS_PROP==prop)
      refreshTargetConnections();
    else if(evt.getSource() == getModel()) // fall back
    	refreshVisuals();
  }
}