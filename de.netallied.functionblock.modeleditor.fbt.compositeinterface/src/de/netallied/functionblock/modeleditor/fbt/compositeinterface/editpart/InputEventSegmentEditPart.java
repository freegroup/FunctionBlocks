package de.netallied.functionblock.modeleditor.fbt.compositeinterface.editpart;

import java.beans.PropertyChangeEvent;
import java.util.List;
import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import de.netallied.functionblock.model.InputEventSegmentModel;
import de.netallied.functionblock.model.ObjectModel;
import de.netallied.functionblock.modeleditor.fbt.compositeinterface.editpolicies.InputEventContainerLayoutEditPolicy;
import de.netallied.functionblock.modeleditor.fbt.compositeinterface.figures.CompartmentFigure;
import de.netallied.functionblock.modeleditor.fbt.compositeinterface.figures.InputEventSegmentFigure;
import de.netallied.functionblock.modeleditor.fbt.compositeinterface.util.PropertyAwareEditPart;


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
  
	protected List getModelChildren()
	{
		return getInputSignalSegmentModel().getElements();
	}

	/**
	 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
	 */
	public void propertyChange(PropertyChangeEvent ev)
	{
    if (ev.getPropertyName()==ObjectModel.PROPERTY_CHILD_REORDER && ev.getSource()==getModel())
      refreshChildren();
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
	public void createEditPolicies()
	{
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new InputEventContainerLayoutEditPolicy());
	}


	/**
	 * Creates a figure which represents the table
	 */
	protected IFigure createFigure()
	{
		return new InputEventSegmentFigure();
	}


  
	/**
	 * Reset the layout constraint, and revalidate the content pane
	 */
	protected void refreshVisuals()
	{
    EventSegmentEditPart parent = (EventSegmentEditPart) getParent();
    ((CompartmentFigure)getFigure()).higlight(getModelChildren().size()==0);
    parent.setLayoutConstraint(this, getFigure(), BorderLayout.LEFT);
	}
}