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
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import de.netallied.functionblock.modeleditor.fbt.basicinterface.figures.ValueSegmentFigure;
import de.netallied.functionblock.modeleditor.fbt.basicinterface.util.PropertyAwareEditPart;
import de.netallied.functionblock.model.ObjectModel;
import de.netallied.functionblock.model.ValueSegmentModel;

/**
 * Represents the editable/resizable table which can have columns added,
 * removed, renamed etc.
 * 
 * @author Phil Zoio
 */
public class ValueSegmentEditPart extends PropertyAwareEditPart
{
	/**
	 * Returns the Table model object represented by this EditPart
	 */
	public ValueSegmentModel getOutputSegmentModel()
	{
		return (ValueSegmentModel) getModel();
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
		return getOutputSegmentModel().getElements();
	}
  

	/**
	 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
	 */
	public void propertyChange(PropertyChangeEvent ev)
	{
    if (ev.getSource()==getModel())
      refreshVisuals();
    else
      super.propertyChange(ev);
	}
	
	//******************* Editing related methods *********************/

	/**
	 * Creates edit policies and associates these with roles
	 */
	public void createEditPolicies()
	{
//		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new TableNodeEditPolicy());
//		installEditPolicy(EditPolicy.LAYOUT_ROLE, new InputEventContainerLayoutEditPolicy());
//		installEditPolicy(EditPolicy.CONTAINER_ROLE, new TableContainerEditPolicy());
//		installEditPolicy(EditPolicy.COMPONENT_ROLE, new TableAliasEditPolicy());
	}

	/**
	 * Creates a figure which represents the table
	 */
	protected IFigure createFigure()
	{
		return new ValueSegmentFigure();
	}

	/**
	 * Reset the layout constraint, and revalidate the content pane
	 */
	protected void refreshVisuals()
	{
    ValueSegmentFigure figure = (ValueSegmentFigure) getFigure();
	}
}