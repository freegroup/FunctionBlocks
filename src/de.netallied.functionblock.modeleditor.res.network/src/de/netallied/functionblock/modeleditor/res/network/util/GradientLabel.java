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
 * Created on 09.11.2005
 *
 */
package de.netallied.functionblock.modeleditor.res.network.util;

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.swt.graphics.Image;
import de.netallied.functionblock.modeleditor.res.network.Constants;

public class GradientLabel extends InsetsLabel
{
	
  public GradientLabel(Image i) 
  {
		super(i);
    setOpaque(false);
	}

	public GradientLabel(String s) 
  {
		super(s);
    setOpaque(false);
	}

	public GradientLabel()
  {
    setOpaque(false);
  }
  
  
	
	@Override
  public void setBorder(Border arg0)
  {
    if(arg0 instanceof ShadowBorder)
    {
      ShadowBorder sb = (ShadowBorder)arg0;
      setInsets( new Insets(2,8,2+sb.getWidth(),8));
    }
    super.setBorder(arg0);
  }

  protected void paintFigure(Graphics graphics) 
  {
    graphics.pushState();
    graphics.setForegroundColor(Constants.COLOR_PANE);
    graphics.setBackgroundColor(Constants.COLOR_HEADER);
    graphics.fillGradient(getBounds(),true);
    graphics.popState();
    graphics.setForegroundColor(Constants.COLOR_FONT);
    super.paintFigure(graphics);
  }
}
