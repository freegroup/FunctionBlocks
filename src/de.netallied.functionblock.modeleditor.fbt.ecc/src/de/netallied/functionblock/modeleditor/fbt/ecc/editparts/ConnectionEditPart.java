package de.netallied.functionblock.modeleditor.fbt.ecc.editparts;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.draw2d.AbsoluteBendpoint;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.RelativeBendpoint;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gef.editpolicies.ConnectionEditPolicy;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;
import org.eclipse.gef.requests.GroupRequest;
import de.netallied.functionblock.modeleditor.fbt.ecc.commands.ConnectionDeleteCommand;
import de.netallied.functionblock.modeleditor.fbt.ecc.editpolicies.WireBendpointEditPolicy;
import de.netallied.functionblock.modeleditor.fbt.ecc.figures.TransitionFigure;
import de.netallied.functionblock.model.ECCTransitionModel;
import de.netallied.functionblock.model.ObjectModel;

/**
 * Edit part for ECCTransitionModel model elements.
 * <p>
 * This edit part must implement the PropertyChangeListener interface, so it can
 * be notified of property changes in the corresponding model element.
 * </p>
 */
public class ConnectionEditPart extends AbstractConnectionEditPart implements PropertyChangeListener
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
    // Allows the removal of the connection model element
    installEditPolicy(EditPolicy.CONNECTION_ROLE, new ConnectionEditPolicy()
    {
      protected Command getDeleteCommand(GroupRequest request)
      {
        ECCTransitionModel t = getCastedModel();
        return new ConnectionDeleteCommand(t.getParentModel(),t);
      }
    });
    installEditPolicy(EditPolicy.CONNECTION_BENDPOINTS_ROLE, new WireBendpointEditPolicy());
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
   */
  protected IFigure createFigure()
  {
    return new TransitionFigure(getRoot(), "LABEL");
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
      ((ObjectModel) getModel()).removePropertyChangeListener(this);
    }
  }

  private ECCTransitionModel getCastedModel()
  {
    return (ECCTransitionModel) getModel();
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
   */
  public void propertyChange(PropertyChangeEvent event)
  {
    if(event.getPropertyName() == ObjectModel.PROPERTY_POSITION_CHANGED)
      refreshVisuals();
    if(event.getPropertyName() == ObjectModel.PROPERTY_CONDITION_CHANGED)
      refreshVisuals();
  }

  @Override
  protected void refreshVisuals()
  {    
    TransitionFigure figure = (TransitionFigure)getFigure();
    figure.setFulcrum(getCastedModel().getFulcrum());
    figure.setText(getCastedModel().getCondition());
  }
  
}