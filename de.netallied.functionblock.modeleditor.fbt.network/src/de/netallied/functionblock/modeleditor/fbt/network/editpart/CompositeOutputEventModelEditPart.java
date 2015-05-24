package de.netallied.functionblock.modeleditor.fbt.network.editpart;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Iterator;
import java.util.List;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import de.netallied.functionblock.model.CompositeOutputEventModel;
import de.netallied.functionblock.model.EventTransitionModel;
import de.netallied.functionblock.model.NetworkModel;
import de.netallied.functionblock.modeleditor.fbt.network.editpart.anchor.LeftMiddleAnchor;
import de.netallied.functionblock.modeleditor.fbt.network.editpolicy.ObjectModelComponentEditPolicy;
import de.netallied.functionblock.modeleditor.fbt.network.figure.CompositeOutputEventFigure;


public class CompositeOutputEventModelEditPart extends AbstractGraphicalEditPart implements PropertyChangeListener, NodeEditPart
{
  /**
   * Upon activation, attach to the model element as a property change listener.
   */
  public final void activate()
  {
    if (!isActive())
    {
      super.activate();
      getCompositeOutputEventModel().addPropertyChangeListener(this);
    }
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
      getCompositeOutputEventModel().removePropertyChangeListener(this);
    }
  }

  public void createEditPolicies()
  {
//    super.createEditPolicies();
    // allow removal of the associated model element
    installEditPolicy(EditPolicy.COMPONENT_ROLE, new ObjectModelComponentEditPolicy());
  }

  public NetworkModel getNetworkModel()
  {
     return (NetworkModel)getParent().getModel();
  }


  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.NodeEditPart#getSourceConnectionAnchor(org.eclipse.gef.ConnectionEditPart)
   */
  public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection)
  {
    return new LeftMiddleAnchor(getFigure());
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.NodeEditPart#getSourceConnectionAnchor(org.eclipse.gef.Request)
   */
  public ConnectionAnchor getTargetConnectionAnchor(Request request)
  {
    return new LeftMiddleAnchor(getFigure());
  }

  public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart arg0)
  {
    return null;
  }

  public ConnectionAnchor getSourceConnectionAnchor(Request arg0)
  {
    return null;
  }

  protected CompositeOutputEventModel getCompositeOutputEventModel()
  {
    return (CompositeOutputEventModel) getModel();
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#getModelSourceConnections()
   */
  @Override
  protected List getModelTargetConnections()
  {
    return getNetworkModel().getTargetTransitions(getCompositeOutputEventModel());
  }
  
  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
   */
	@Override
  protected IFigure createFigure()
  {
    return new CompositeOutputEventFigure();
  }

  @Override
  protected void refreshChildren() 
  {
    super.refreshChildren();
    refreshVisuals();
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
   */
  public void propertyChange(PropertyChangeEvent evt)
  {
    if (evt.getSource()==getModel())
      refreshVisuals();
  }

	
  protected void refreshVisuals()
  {
    super.refreshVisuals();
    EventTransitionModel obj =(EventTransitionModel)getModelTargetConnections().get(0);

    EditPart part = getEditPart( this.getParent(), obj.getFromObjectModel());
    
    CompositeOutputEventFigure figure = (CompositeOutputEventFigure)getFigure();
    Point pos = new Point(100,100);
    if(part instanceof InterfaceModelEditPart)
      pos = ((InterfaceModelEditPart)part).getFigure().getBounds().getLocation();
    // einen gewissen Abstand zum Objekt halten
    //
    pos = pos.getTranslated(50,0);
    
    // Die Breite des Source Labels berücksichtigen
    //
    pos = pos.getTranslated(((InterfaceModelEditPart)part).getFigure().getPreferredSize().width,0);

    figure.setText(getCompositeOutputEventModel().getName());
    Dimension rect = figure.getPreferredSize();
    figure.setBounds(new Rectangle(pos,rect));
  }
  
  protected EditPart getEditPart( EditPart part, Object model)
  {
    if(part.getModel()==model)
       return part;
    for(Iterator iter= part.getChildren().iterator(); iter.hasNext();)
    {
      EditPart editPart = getEditPart((EditPart)iter.next(),model);
      if(editPart !=null)
         return editPart;
    }
    return null;
  }
}