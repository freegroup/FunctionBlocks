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
 * Created on 10.12.2004
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package de.netallied.functionblock.modeleditor.fbt.compositeinterface;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import de.netallied.functionblock.modeleditor.fbt.compositeinterface.editpart.DiagramEditPart;
import de.netallied.functionblock.modeleditor.fbt.compositeinterface.editpart.EventSegmentEditPart;
import de.netallied.functionblock.modeleditor.fbt.compositeinterface.editpart.FunctionBlockEditPart;
import de.netallied.functionblock.modeleditor.fbt.compositeinterface.editpart.FunctionBlockNameEditPart;
import de.netallied.functionblock.modeleditor.fbt.compositeinterface.editpart.FunctionBlockWaistEditPart;
import de.netallied.functionblock.modeleditor.fbt.compositeinterface.editpart.InputEventEditPart;
import de.netallied.functionblock.modeleditor.fbt.compositeinterface.editpart.InputEventSegmentEditPart;
import de.netallied.functionblock.modeleditor.fbt.compositeinterface.editpart.InputValueEditPart;
import de.netallied.functionblock.modeleditor.fbt.compositeinterface.editpart.InputValueSegmentEditPart;
import de.netallied.functionblock.modeleditor.fbt.compositeinterface.editpart.OutputEventEditPart;
import de.netallied.functionblock.modeleditor.fbt.compositeinterface.editpart.OutputEventSegmentEditPart;
import de.netallied.functionblock.modeleditor.fbt.compositeinterface.editpart.OutputValueEditPart;
import de.netallied.functionblock.modeleditor.fbt.compositeinterface.editpart.OutputValueSegmentEditPart;
import de.netallied.functionblock.modeleditor.fbt.compositeinterface.editpart.ValueSegmentEditPart;
import de.netallied.functionblock.model.AbstractFunctionBlockModel;
import de.netallied.functionblock.model.EventSegmentModel;
import de.netallied.functionblock.model.FunctionBlockNameModel;
import de.netallied.functionblock.model.FunctionBlockWaistModel;
import de.netallied.functionblock.model.FBTypeModel;
import de.netallied.functionblock.model.InputEventModel;
import de.netallied.functionblock.model.InputEventSegmentModel;
import de.netallied.functionblock.model.InputValueModel;
import de.netallied.functionblock.model.InputValueSegmentModel;
import de.netallied.functionblock.model.OutputEventModel;
import de.netallied.functionblock.model.OutputEventSegmentModel;
import de.netallied.functionblock.model.OutputValueModel;
import de.netallied.functionblock.model.OutputValueSegmentModel;
import de.netallied.functionblock.model.ValueSegmentModel;

/**
 * @author Andreas
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class EditPartFactoryImpl implements EditPartFactory
{
	public EditPart createEditPart(EditPart context, Object model)
	{
		EditPart part = null;
		
    if (model instanceof FBTypeModel)
      part = new DiagramEditPart();
    else if (model instanceof AbstractFunctionBlockModel)
      part = new FunctionBlockEditPart();
    else if (model instanceof FunctionBlockWaistModel)
      part = new FunctionBlockWaistEditPart();
    else if (model instanceof FunctionBlockNameModel)
      part = new FunctionBlockNameEditPart();
		else if (model instanceof EventSegmentModel)
			part = new EventSegmentEditPart();
		else if (model instanceof ValueSegmentModel)
			part = new ValueSegmentEditPart();
		else if (model instanceof InputEventSegmentModel)
			part = new InputEventSegmentEditPart();
		else if (model instanceof OutputEventSegmentModel)
			part = new OutputEventSegmentEditPart();
    else if (model instanceof InputValueSegmentModel)
      part = new InputValueSegmentEditPart();
    else if (model instanceof OutputValueSegmentModel)
      part = new OutputValueSegmentEditPart();
    else if (model instanceof InputEventModel)
      part = new InputEventEditPart();
    else if (model instanceof OutputEventModel)
      part = new OutputEventEditPart();
    else if (model instanceof InputValueModel)
      part = new InputValueEditPart();
    else if (model instanceof OutputValueModel)
      part = new OutputValueEditPart();

    part.setModel(model);
		return part;
	}
}