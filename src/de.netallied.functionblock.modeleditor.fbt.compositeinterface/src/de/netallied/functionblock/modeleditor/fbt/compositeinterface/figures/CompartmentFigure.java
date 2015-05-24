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

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.swt.graphics.Color;
import de.netallied.functionblock.modeleditor.fbt.compositeinterface.Constants;

public class CompartmentFigure extends Figure
{
	public CompartmentFigure(boolean vertical, int alignment)
	{
    FlowLayout layout = new FlowLayout();
		layout.setMinorAlignment(alignment);
		layout.setStretchMinorAxis(true);
		layout.setMajorSpacing(0);
    layout.setMinorSpacing(0);
    layout.setHorizontal(!vertical);
		setLayoutManager(layout);
	}
  
  public void higlight(boolean flag)
  {
    if(flag)
      setBorder(new LineBorder(Constants.COLOR_PANE,8));
    else
      setBorder(null);
  }    
}
