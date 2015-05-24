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
package de.netallied.functionblock.modeleditor.fbt.compositeinterface.editpart;

import java.beans.PropertyChangeEvent;
import java.util.List;
import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import de.netallied.functionblock.model.ObjectModel;
import de.netallied.functionblock.model.OutputEventSegmentModel;
import de.netallied.functionblock.modeleditor.fbt.compositeinterface.editpolicies.OutputEventContainerLayoutEditPolicy;
import de.netallied.functionblock.modeleditor.fbt.compositeinterface.figures.OutputEventSegmentFigure;
import de.netallied.functionblock.modeleditor.fbt.compositeinterface.util.PropertyAwareEditPart;

/**
 * Represents the editable/resizable table which can have columns added,
 * removed, renamed etc.
 * 
 * @author Phil Zoio
 */
public class OutputEventSegmentEditPart extends PropertyAwareEditPart
{
	/**
	 * Returns the Table model object represented by this EditPart
	 */
	public OutputEventSegmentModel getOutputSignalSegmentModel()
	{
		return (OutputEventSegmentModel) getModel();
	}
  
  public void performRequest(Request req)
  {
		if(req.getType() == RequestConstants.REQ_OPEN)
		{
		}
  }

  /**
	 * @return the children Model objects as a new ArrayList
	 */
  
	protected List getModelChildren()
	{
		return getOutputSignalSegmentModel().getElements();
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
    installEditPolicy(EditPolicy.LAYOUT_ROLE, new OutputEventContainerLayoutEditPolicy());
	}

	/**
	 * Creates a figure which represents the table
	 */
	protected IFigure createFigure()
	{
		return new OutputEventSegmentFigure();
	}

	/**
	 * Reset the layout constraint, and revalidate the content pane
	 */
	protected void refreshVisuals()
	{
		OutputEventSegmentFigure figure = (OutputEventSegmentFigure) getFigure();
    EventSegmentEditPart parent = (EventSegmentEditPart) getParent();
    figure.higlight(getModelChildren().size()==0);
    parent.setLayoutConstraint(this, figure, BorderLayout.RIGHT);
	}
}