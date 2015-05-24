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

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.Figure;
import de.netallied.functionblock.modeleditor.fbt.compositeinterface.util.ShadowBorder;



/**
 * Figure used to hold the column labels
 */
public class ValueSegmentFigure extends Figure
{
	public ValueSegmentFigure()
	{
    setLayoutManager(new BorderLayout());

    Figure filler = new Figure();
    filler.setSize(80,100);
    add(filler, BorderLayout.CENTER);

    ShadowBorder border = new ShadowBorder();
    border.setTop(false);
    setBorder(border);
  }
}