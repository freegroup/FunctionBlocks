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
 * Created on Jul 21, 2004
 */
package de.netallied.functionblock.modeleditor.fbt.compositeinterface.layout;

import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import de.netallied.functionblock.modeleditor.fbt.compositeinterface.figures.DiagramFigure;

/**
 * Subclass of XYLayout which can use the child figures actual bounds as a constraint
 * when doing manual layout (XYLayout)
 */
public class GraphXYLayout extends FreeformLayout
{
  private final DiagramFigure parent;
  
	public GraphXYLayout(DiagramFigure parent)
	{
    this.parent = parent;
	}

	public void layout(IFigure parent)
  {
    super.layout(parent);
  }

  public Object getConstraint(IFigure child)
	{
		Object constraint = constraints.get(child);
		if (constraint != null || constraint instanceof Rectangle)
		{
			return (Rectangle)constraint;
		}
		else
		{
			Rectangle currentBounds = child.getBounds();
//      return new Rectangle(currentBounds.x, currentBounds.y, -1,-1);
      return new Rectangle(100,100, -1,-1);
		}
	}
}
