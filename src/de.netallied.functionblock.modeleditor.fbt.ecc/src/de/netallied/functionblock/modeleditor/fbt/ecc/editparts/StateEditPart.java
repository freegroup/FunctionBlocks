package de.netallied.functionblock.modeleditor.fbt.ecc.editparts;

import java.beans.PropertyChangeEvent;
import java.util.List;
import org.eclipse.draw2d.ChopboxAnchor;
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
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import de.netallied.functionblock.model.ECCAbstractStateModel;
import de.netallied.functionblock.model.ECCTransitionModel;
import de.netallied.functionblock.modeleditor.fbt.ecc.commands.ConnectionCreateCommand;
import de.netallied.functionblock.modeleditor.fbt.ecc.commands.ConnectionReconnectCommand;
import de.netallied.functionblock.modeleditor.fbt.ecc.editpolicies.ShapeComponentEditPolicy;
import de.netallied.functionblock.modeleditor.fbt.ecc.editpolicies.StateLayoutEditPolicy;
import de.netallied.functionblock.modeleditor.fbt.ecc.figures.StateFigure;
import de.netallied.functionblock.modeleditor.fbt.ecc.util.EditableLabelEditPart;

/**
 * EditPart used for ECCAbstractStateModel instances (more specific for
 * EllipticalShape and ECCStateModel instances).
 * <p>
 * This edit part must implement the PropertyChangeListener interface, so it can
 * be notified of property changes in the corresponding model element.
 * </p>
 * 
 */
public class StateEditPart extends EditableLabelEditPart implements NodeEditPart
{
  /*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
	 */
  @Override
	public void createEditPolicies()
	{
    super.createEditPolicies();
    installEditPolicy(EditPolicy.LAYOUT_ROLE, new StateLayoutEditPolicy());
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new ShapeComponentEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new GraphicalNodeEditPolicy()
		{
			protected Command getConnectionCompleteCommand(CreateConnectionRequest request)
			{
				ConnectionCreateCommand cmd = (ConnectionCreateCommand) request.getStartCommand();
				cmd.setTarget((ECCAbstractStateModel) getHost().getModel());
				return cmd;
			}

			protected Command getConnectionCreateCommand(CreateConnectionRequest request)
			{
				ECCAbstractStateModel source = (ECCAbstractStateModel) getHost().getModel();
				ConnectionCreateCommand cmd = new ConnectionCreateCommand(source);
				request.setStartCommand(cmd);
				return cmd;
			}
			
			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getReconnectSourceCommand(org.eclipse.gef.requests.ReconnectRequest)
			 */
			protected Command getReconnectSourceCommand(ReconnectRequest request)
			{
				ECCTransitionModel conn = (ECCTransitionModel) request.getConnectionEditPart().getModel();
				ECCAbstractStateModel newSource = (ECCAbstractStateModel) getHost().getModel();
				ConnectionReconnectCommand cmd = new ConnectionReconnectCommand(conn);
				cmd.setNewSource(newSource);
				return cmd;
			}
			
			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getReconnectTargetCommand(org.eclipse.gef.requests.ReconnectRequest)
			 */
			protected Command getReconnectTargetCommand(ReconnectRequest request)
			{
				ECCTransitionModel conn = (ECCTransitionModel) request.getConnectionEditPart().getModel();
				ECCAbstractStateModel newTarget = (ECCAbstractStateModel) getHost().getModel();
				ConnectionReconnectCommand cmd = new ConnectionReconnectCommand(conn);
				cmd.setNewTarget(newTarget);
				return cmd;
			}
		});
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
	 */
  @Override
	protected IFigure createFigure()
	{
		return new StateFigure();
	}
	
  protected StateFigure getCastetFigure()
  {
    return (StateFigure)getFigure();
  }
  
	@Override
  public List getModelChildren()
  {
    return getCastedModel().getElements();
  }

  private ECCAbstractStateModel getCastedModel()
	{
		return (ECCAbstractStateModel) getModel();
	}
	
	@Override
  protected void addChildVisual(EditPart arg0, int arg1)
  {
    // erste Element ist der Name des State, welcher kein Kind des Models ist
    // Die Kinder kommen dann erst eine Stelle danach.
    //
    super.addChildVisual(arg0, arg1+2);
  }

  @Override
  public void performRequest(Request request)
  {
    super.performRequest(request);
  }

  /*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#getModelSourceConnections()
	 */
  @Override
	protected List getModelSourceConnections()
	{
		return getCastedModel().getSourceConnections();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#getModelTargetConnections()
	 */
  @Override
	protected List getModelTargetConnections()
	{
		return getCastedModel().getTargetConnections();
	}
	
  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.NodeEditPart#getSourceConnectionAnchor(org.eclipse.gef.ConnectionEditPart)
   */
  public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection)
  {
    return new ChopboxAnchor(getCastetFigure().getLabel());
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.NodeEditPart#getSourceConnectionAnchor(org.eclipse.gef.Request)
   */
  public ConnectionAnchor getSourceConnectionAnchor(Request request)
  {
    return new ChopboxAnchor(getCastetFigure().getLabel());
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.NodeEditPart#getTargetConnectionAnchor(org.eclipse.gef.ConnectionEditPart)
   */
  public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection)
  {
    return new ChopboxAnchor(getCastetFigure().getLabel());
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.NodeEditPart#getTargetConnectionAnchor(org.eclipse.gef.Request)
   */
  public ConnectionAnchor getTargetConnectionAnchor(Request request)
  {
    return new ChopboxAnchor(getCastetFigure().getLabel());
  }

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
	 */
	public void propertyChange(PropertyChangeEvent evt)
	{
		String prop = evt.getPropertyName();
    if (ECCAbstractStateModel.PROPERTY_POSITION_CHANGED.equals(prop))
      refreshVisuals();
    else if (ECCAbstractStateModel.PROPERTY_NAME_CHANGED.equals(prop))
      refreshVisuals();
    else if (ECCAbstractStateModel.PROPERTY_ELEMENT_ADDED.equals(prop))
    {
      refreshChildren();
      refreshVisuals();
    }
    else if (ECCAbstractStateModel.PROPERTY_ELEMENT_REMOVED.equals(prop))
    {
      refreshChildren();
      refreshVisuals();
    }
		else if (ECCAbstractStateModel.SOURCE_CONNECTIONS_PROP.equals(prop))
			refreshSourceConnections();
		else if (ECCAbstractStateModel.TARGET_CONNECTIONS_PROP.equals(prop))
			refreshTargetConnections();
	}
	
	
	protected void refreshVisuals()
	{
		// notify parent container of changed position & location
		// if this line is removed, the XYLayoutManager used by the parent container
		// (the Figure of the ShapesDiagramEditPart), will not know the bounds of
		// this figure and will not draw it correctly.
    StateFigure figure = (StateFigure)getFigure();
    figure.setText(getCastedModel().getName());
    figure.setHasAction(getCastedModel().getElements().size()>0);
		Rectangle bounds = new Rectangle(getCastedModel().getLocation(), new Dimension(-1, -1));
		((GraphicalEditPart) getParent()).setLayoutConstraint(this, getFigure(), bounds);
	}
}
