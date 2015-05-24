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
import de.netallied.functionblock.model.FunctionBlockWaistModel;
import de.netallied.functionblock.modeleditor.fbt.compositeinterface.figures.FunctionBlockWaistFigure;
import de.netallied.functionblock.modeleditor.fbt.compositeinterface.util.PropertyAwareEditPart;

/**
 * Represents the editable/resizable table which can have columns added,
 * removed, renamed etc.
 * 
 */
public class FunctionBlockWaistEditPart extends PropertyAwareEditPart
{

  /**
	 */
	public FunctionBlockWaistModel getFunctionBlockWaistModel()
	{
		return (FunctionBlockWaistModel) getModel();
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
		return new FunctionBlockWaistFigure();
	}
}