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
import de.netallied.functionblock.modeleditor.fbt.basicinterface.figures.FunctionBlockFigure;
import de.netallied.functionblock.modeleditor.fbt.basicinterface.util.PropertyAwareEditPart;
import de.netallied.functionblock.model.AbstractFunctionBlockModel;
import de.netallied.functionblock.model.ObjectModel;


/**
 * Represents the editable/resizable table which can have columns added,
 * removed, renamed etc.
 * 
 */
public class FunctionBlockEditPart extends PropertyAwareEditPart
{

	/**
	 * Returns the Table model object represented by this EditPart
	 */
	public AbstractFunctionBlockModel getFunctionBlockModel()
	{
		return (AbstractFunctionBlockModel) getModel();
	}


  /**
	 * @return the children Model objects as a new ArrayList
	 */
  @Override
	protected List getModelChildren()
	{
		return getFunctionBlockModel().getElements();
	}


	/**
	 * Creates edit policies and associates these with roles
	 */
  @Override
	public void createEditPolicies()
	{
	}


	/**
	 * Creates a figure which represents the table
	 */
  @Override
	protected IFigure createFigure()
	{
	  return new FunctionBlockFigure();
	}


  /**
	 * Reset the layout constraint, and revalidate the content pane
	 */
  @Override
	protected void refreshVisuals()
	{
		FunctionBlockFigure figure = (FunctionBlockFigure) getFigure();
		super.refreshVisuals();
	}
}