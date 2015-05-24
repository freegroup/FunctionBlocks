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
package de.netallied.functionblock.modeleditor.fbt.compositeinterface.editpart;


import java.util.List;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import de.netallied.functionblock.model.FBTypeModel;
import de.netallied.functionblock.modeleditor.fbt.compositeinterface.editpolicies.SchemaXYLayoutPolicy;
import de.netallied.functionblock.modeleditor.fbt.compositeinterface.figures.DiagramFigure;
import de.netallied.functionblock.modeleditor.fbt.compositeinterface.util.PropertyAwareEditPart;


/**
 * Edit part for Schema object, and uses a SchemaDiagram figure as
 * the container for all graphical objects
 * 
 * @author Phil Zoio
 */
public class DiagramEditPart extends PropertyAwareEditPart
{
	protected IFigure createFigure()
	{
		return new DiagramFigure();
	}

	public FBTypeModel getFunctionBlockDiagramModel()
	{
		return (FBTypeModel) getModel();
	}

	/**
	 * @return the children Model objects as a new ArrayList
	 */
	protected List getModelChildren()
	{
		return getFunctionBlockDiagramModel().getElements();
	}

	/**
	 * @see org.eclipse.gef.editparts.AbstractEditPart#isSelectable()
	 */
	public boolean isSelectable()
	{
		return false;
	}

	/**
	 * Creates EditPolicy objects for the EditPart. The LAYOUT_ROLE policy is
	 * left to the delegating layout manager
	 */
	protected void createEditPolicies()
	{
    installEditPolicy(EditPolicy.CONTAINER_ROLE, new SchemaXYLayoutPolicy());
    installEditPolicy(EditPolicy.LAYOUT_ROLE, null);
	}

}