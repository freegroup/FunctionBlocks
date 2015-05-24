package de.netallied.functionblock.modeleditor.res.network.editpart;

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
import de.netallied.functionblock.model.NetworkModel;
import de.netallied.functionblock.model.ParameterModel;
import de.netallied.functionblock.model.ParameterTransitionModel;
import de.netallied.functionblock.modeleditor.res.network.editpart.anchor.RightMiddleAnchor;
import de.netallied.functionblock.modeleditor.res.network.editpart.anchor.YAlignAnchor;
import de.netallied.functionblock.modeleditor.res.network.editpolicies.ObjectModelComponentEditPolicy;
import de.netallied.functionblock.modeleditor.res.network.figures.ParameterFigure;


public class ParameterModelEditPart extends AbstractGraphicalEditPart implements PropertyChangeListener, NodeEditPart
{
  /**
   * Upon activation, attach to the model element as a property change listener.
   */
  public final void activate()
  {
    if (!isActive())
    {
      super.activate();
      getParameteModel().addPropertyChangeListener(this);
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
      getParameteModel().removePropertyChangeListener(this);
    }
  }

  public void createEditPolicies()
  {
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
  public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection)
  {
    return new YAlignAnchor(getFigure());
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.NodeEditPart#getSourceConnectionAnchor(org.eclipse.gef.Request)
   */
  public ConnectionAnchor getSourceConnectionAnchor(Request request)
  {
    return new YAlignAnchor(getFigure());
  }

  public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart arg0)
  {
    return null;
  }

  public ConnectionAnchor getTargetConnectionAnchor(Request arg0)
  {
    return null;
  }

  protected ParameterModel getParameteModel()
  {
    return (ParameterModel) getModel();
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#getModelSourceConnections()
   */
  @Override
  protected List getModelSourceConnections()
  {
    return getNetworkModel().getSourceTransitions(getParameteModel());
  }
  
  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
   */
	@Override
  protected IFigure createFigure()
  {
    return new ParameterFigure("any");
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
    ParameterFigure figure = (ParameterFigure)getFigure();
    
    ParameterTransitionModel trans =(ParameterTransitionModel)getModelSourceConnections().get(0);

    EditPart part = getEditPart( this.getParent(), trans.getToObjectModel());
    
    Point pos = new Point(100,100);
    if(part instanceof InterfaceModelEditPart)
      pos = ((InterfaceModelEditPart)part).getFigure().getBounds().getLocation();
    // einen gewissen Abstand zum Objekt halten
    //
    pos = pos.getTranslated(-50,0);
    
    // Die Breite des Labels berücksichtigen
    //
    pos = pos.getTranslated(-figure.getPreferredSize().width,0);
    
    figure.setText(getParameteModel().getValue());
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