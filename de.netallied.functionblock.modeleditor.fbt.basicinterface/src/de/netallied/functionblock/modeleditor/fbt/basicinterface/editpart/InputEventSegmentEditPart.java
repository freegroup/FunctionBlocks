package de.netallied.functionblock.modeleditor.fbt.basicinterface.editpart;

import java.beans.PropertyChangeEvent;
import java.util.Iterator;
import java.util.List;
import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.editparts.AbstractEditPart;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import de.netallied.functionblock.modeleditor.fbt.basicinterface.editpolicies.InputEventContainerLayoutEditPolicy;
import de.netallied.functionblock.modeleditor.fbt.basicinterface.figures.CompartmentFigure;
import de.netallied.functionblock.modeleditor.fbt.basicinterface.figures.InputEventSegmentFigure;
import de.netallied.functionblock.modeleditor.fbt.basicinterface.util.PropertyAwareEditPart;
import de.netallied.functionblock.model.InputEventSegmentModel;
import de.netallied.functionblock.model.ObjectModel;


public class InputEventSegmentEditPart extends PropertyAwareEditPart
{
	/**
	 * Returns the Table model object represented by this EditPart
	 */
	public InputEventSegmentModel getInputSignalSegmentModel()
	{
		return (InputEventSegmentModel) getModel();
	}
  
  /**
	 * @return the children Model objects as a new ArrayList
	 */
  @Override
	protected List getModelChildren()
	{
		return getInputSignalSegmentModel().getElements();
	}

	/**
	 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
	 */
  @Override
	public void propertyChange(PropertyChangeEvent ev)
	{
    if (ev.getPropertyName()==ObjectModel.PROPERTY_CHILD_REORDER && ev.getSource()==getModel())
    {
      refreshChildren();
      refreshVisuals();
      refreshSourceConnections();
    }
    else if (ev.getPropertyName()==ObjectModel.PROPERTY_ELEMENT_ADDED && ev.getSource()==getModel())
      refreshChildren();
    else if (ev.getPropertyName()==ObjectModel.PROPERTY_ELEMENT_REMOVED && ev.getSource()==getModel())
      refreshChildren();
    else
      super.propertyChange(ev);
    refreshVisuals();
	}
	

	/**
	 * Creates edit policies and associates these with roles
	 */
  @Override
	public void createEditPolicies()
	{
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new InputEventContainerLayoutEditPolicy());
	}


	/**
	 * Creates a figure which represents the table
	 */
  @Override
	protected IFigure createFigure()
	{
		return new InputEventSegmentFigure();
	}


  
	/**
	 * Reset the layout constraint, and revalidate the content pane
	 */
  @Override
	protected void refreshVisuals()
	{
    EventSegmentEditPart parent = (EventSegmentEditPart) getParent();
    parent.setLayoutConstraint(this, getFigure(), BorderLayout.LEFT);
    ((CompartmentFigure)getFigure()).higlight(getModelChildren().size()==0);
	}
}