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

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import de.netallied.functionblock.model.InputEventModel;
import de.netallied.functionblock.modeleditor.fbt.compositeinterface.editpolicies.InputEventEditPolicy;
import de.netallied.functionblock.modeleditor.fbt.compositeinterface.figures.InputEventFigure;
import de.netallied.functionblock.modeleditor.fbt.compositeinterface.util.EditableLabelEditPart;

/**
 * Represents the editable/resizable table which can have columns added,
 * removed, renamed etc.
 * 
 */
public class InputEventEditPart extends EditableLabelEditPart
{

  public String getLabelText()
  {
    return getInputEventModel().getName();
  }

  /**
	 */
	public InputEventModel getInputEventModel()
	{
		return (InputEventModel) getModel();
	}
  


	/**
	 * Creates edit policies and associates these with roles
	 */
	public void createEditPolicies()
	{    
    super.createEditPolicies();
    installEditPolicy(EditPolicy.COMPONENT_ROLE, new InputEventEditPolicy());
	}


	/**
	 * Creates a figure which represents the table
	 */
	protected IFigure createFigure()
	{
		return new InputEventFigure();
	}

	/**
	 * Reset the layout constraint, and revalidate the content pane
	 */
	protected void refreshVisuals()
	{
		InputEventFigure tableFigure = (InputEventFigure) getFigure();
		tableFigure.setText(getInputEventModel().getName());
	}
}