package de.netallied.functionblock.modeleditor.fbt.ecc.editparts;

import java.beans.PropertyChangeEvent;
import java.util.List;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.editpolicies.RootComponentEditPolicy;
import de.netallied.functionblock.modeleditor.fbt.ecc.editpolicies.DiagramLayoutEditPolicy;
import de.netallied.functionblock.modeleditor.fbt.ecc.figures.DiagramFigure;
import de.netallied.functionblock.modeleditor.fbt.ecc.util.PropertyAwareEditPart;
import de.netallied.functionblock.model.ECCDiagramModel;
import de.netallied.functionblock.model.ObjectModel;

/**
 * EditPart for the a ShapesDiagram instance.
 * <p>
 * This edit part server as the main diagram container, the white area where
 * everything else is in. Also responsible for the container's layout (the way
 * the container rearanges is contents) and the container's capabilities (edit
 * policies).
 * </p>
 * <p>
 * This edit part must implement the PropertyChangeListener interface, so it can
 * be notified of property changes in the corresponding model element.
 * </p>
 * 
 */
public class DiagramEditPart extends PropertyAwareEditPart implements LayerConstants 
{
	protected void createEditPolicies()
	{
		// disallows the removal of this edit part from its parent
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new RootComponentEditPolicy());
		// handles constraint changes (e.g. moving and/or resizing) of model
		// elements and creation of new model elements
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new DiagramLayoutEditPolicy());
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
	 */
  @Override
	protected IFigure createFigure()
	{
    return new DiagramFigure();
	}
	
	
	private ECCDiagramModel getECCDiagramModel()
	{
		return (ECCDiagramModel) getModel();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractEditPart#getModelChildren()
	 */
	protected List getModelChildren()
	{
		return getECCDiagramModel().getElements(); // return a list of shapes
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.beans.PropertyChangeListener#propertyChange(PropertyChangeEvent)
	 */
	public void propertyChange(PropertyChangeEvent evt)
	{
		String prop = evt.getPropertyName();
		// these properties are fired when Shapes are added into or removed from
		// the ShapeDiagram instance and must cause a call of refreshChildren()
		// to update the diagram's contents.
		
		if (ObjectModel.PROPERTY_ELEMENT_ADDED.equals(prop))
			refreshChildren();
		else if (ObjectModel.PROPERTY_ELEMENT_REMOVED.equals(prop))
			refreshChildren();
    else
      super.propertyChange(evt);
	}
}
