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
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.Request;
import de.netallied.functionblock.modeleditor.fbt.basicinterface.figures.FunctionBlockWaistFigure;
import de.netallied.functionblock.modeleditor.fbt.basicinterface.util.PropertyAwareEditPart;
import de.netallied.functionblock.model.FunctionBlockWaistModel;

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
  
  public void performRequest(Request request)
  {
    super.performRequest(request);
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
	}


	/**
	 * Creates a figure which represents the table
	 */
	protected IFigure createFigure()
	{
		return new FunctionBlockWaistFigure();
	}

	/**
	 * Reset the layout constraint, and revalidate the content pane
	 */
	protected void refreshVisuals()
	{
    FunctionBlockWaistFigure figure = (FunctionBlockWaistFigure) getFigure();
	}
}