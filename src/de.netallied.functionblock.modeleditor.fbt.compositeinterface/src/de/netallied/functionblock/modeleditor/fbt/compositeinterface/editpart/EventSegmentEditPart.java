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
import org.eclipse.draw2d.IFigure;
import de.netallied.functionblock.model.EventSegmentModel;
import de.netallied.functionblock.modeleditor.fbt.compositeinterface.figures.EventSegmentFigure;
import de.netallied.functionblock.modeleditor.fbt.compositeinterface.util.PropertyAwareEditPart;


public class EventSegmentEditPart extends PropertyAwareEditPart
{
	/**
	 * Returns the Table model object represented by this EditPart
	 */
	public EventSegmentModel getEventSegmentModel()
	{
		return (EventSegmentModel) getModel();
	}

  /**
	 * @return the children Model objects as a new ArrayList
	 */
	protected List getModelChildren()
	{
		return getEventSegmentModel().getElements();
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

	/**
	 * Creates edit policies and associates these with roles
	 */
	public void createEditPolicies()
	{
	}

	/**
	 * Creates a figure which represents the table
	 */
	protected IFigure createFigure()
	{
		return new EventSegmentFigure();
	}

}