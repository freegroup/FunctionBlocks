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
package de.netallied.functionblock.modeleditor.fbt.compositeinterface.figures;

import org.eclipse.draw2d.FreeformLayer;
import de.netallied.functionblock.modeleditor.fbt.compositeinterface.Constants;
import de.netallied.functionblock.modeleditor.fbt.compositeinterface.layout.GraphXYLayout;

public class DiagramFigure extends FreeformLayer
{
	public DiagramFigure()
	{
		setOpaque(true);
    setLayoutManager(new GraphXYLayout(this));
//    setLayoutManager(new StackLayout());
//    setLayoutManager(new CenterLayout());
    setBackgroundColor(Constants.COLOR_WORKAREA);
//    setSize(1000,1000);
	}
}
