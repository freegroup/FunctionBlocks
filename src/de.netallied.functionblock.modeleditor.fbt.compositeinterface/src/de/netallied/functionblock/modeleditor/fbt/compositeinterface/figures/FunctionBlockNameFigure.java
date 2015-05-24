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
package de.netallied.functionblock.modeleditor.fbt.compositeinterface.figures;

import org.eclipse.draw2d.PositionConstants;
import de.netallied.functionblock.modeleditor.fbt.compositeinterface.util.ShadowBorder;

/**
 */
public class FunctionBlockNameFigure extends EditableLabel
{
	
	public FunctionBlockNameFigure()
	{
    super("");
    setLabelAlignment(PositionConstants.CENTER);
    setSize(-1,100);

    ShadowBorder border = new ShadowBorder();
    border.setBottom(false);
    border.setTop(false);
    setBorder(border);
	}
}
