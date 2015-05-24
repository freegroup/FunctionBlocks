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
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import de.netallied.functionblock.model.OutputValueModel;
import de.netallied.functionblock.modeleditor.fbt.compositeinterface.editpolicies.OutputValueEditPolicy;
import de.netallied.functionblock.modeleditor.fbt.compositeinterface.figures.OutputEventFigure;
import de.netallied.functionblock.modeleditor.fbt.compositeinterface.util.EditableLabelEditPart;

/**
 * Represents the editable/resizable table which can have columns added,
 * removed, renamed etc.
 * 
 */
public class OutputValueEditPart extends EditableLabelEditPart
{

  public String getLabelText()
  {
    return getOutputValueModel().getName();
  }

  /**
	 * Returns the Table model object represented by this EditPart
	 */
	public OutputValueModel getOutputValueModel()
	{
		return (OutputValueModel) getModel();
	}
  
  public void performRequest(Request req)
  {
    super.performRequest(req);
  }


	/**
	 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
	 */
	public void propertyChange(PropertyChangeEvent ev)
	{
      super.propertyChange(ev);
	}
	

	/**
	 * Creates edit policies and associates these with roles
	 */
	public void createEditPolicies()
	{
    super.createEditPolicies();
    installEditPolicy(EditPolicy.COMPONENT_ROLE, new OutputValueEditPolicy());
	}


	/**
	 * Creates a figure which represents the table
	 */
	protected IFigure createFigure()
	{
		return new OutputEventFigure();
	}

	/**
	 * Reset the layout constraint, and revalidate the content pane
	 */
	protected void refreshVisuals()
	{
    OutputEventFigure tableFigure = (OutputEventFigure) getFigure();
		tableFigure.setText(getOutputValueModel().getName());
	}
}