/*******************************************************************************
 * Copyright (c) 2005, 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
/*
 * Created on Jul 13, 2004
 */
package de.netallied.functionblock.modeleditor.fbt.basicinterface.editpart;

import java.beans.PropertyChangeEvent;
import java.util.List;
import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import de.netallied.functionblock.modeleditor.fbt.basicinterface.editpolicies.InputValueContainerLayoutEditPolicy;
import de.netallied.functionblock.modeleditor.fbt.basicinterface.figures.CompartmentFigure;
import de.netallied.functionblock.modeleditor.fbt.basicinterface.figures.InputValueSegmentFigure;
import de.netallied.functionblock.modeleditor.fbt.basicinterface.util.PropertyAwareEditPart;
import de.netallied.functionblock.model.InputValueSegmentModel;
import de.netallied.functionblock.model.ObjectModel;

/**
 * Represents the editable/resizable table which can have columns added,
 * removed, renamed etc.
 * 
 * @author Phil Zoio
 */
public class InputValueSegmentEditPart extends PropertyAwareEditPart
{
	/**
	 * Returns the Table model object represented by this EditPart
	 */
	public InputValueSegmentModel getInputValueSegmentModel()
	{
		return (InputValueSegmentModel) getModel();
	}
  
  /**
	 * @return the children Model objects as a new ArrayList
	 */
  
	protected List getModelChildren()
	{
		return getInputValueSegmentModel().getElements();
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
	
	//******************* Editing related methods *********************/

	/**
	 * Creates edit policies and associates these with roles
	 */
	public void createEditPolicies()
	{
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new InputValueContainerLayoutEditPolicy());
	}


	/**
	 * Creates a figure which represents the table
	 */
	protected IFigure createFigure()
	{
		return new InputValueSegmentFigure();
	}

	/**
	 * Reset the layout constraint, and revalidate the content pane
	 */
	protected void refreshVisuals()
	{
    ValueSegmentEditPart parent = (ValueSegmentEditPart) getParent();
    parent.setLayoutConstraint(this, getFigure(), BorderLayout.LEFT);
    ((CompartmentFigure)getFigure()).higlight(getModelChildren().size()==0);
	}
}