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
package de.netallied.functionblock.modeleditor.fbt.basicinterface.figures;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import de.netallied.functionblock.modeleditor.fbt.basicinterface.Constants;
import de.netallied.functionblock.modeleditor.fbt.basicinterface.util.ShadowBorder;


/**
 */
public class FunctionBlockWaistFigure extends Figure
{
  ShadowBorder border = new ShadowBorder();
  
	public FunctionBlockWaistFigure()
	{
    setSize(-1,30);
	}
  
  protected void paintFigure(Graphics graphics) 
  {
    // die linke und rechte Seite mit der Hintergrundfarbe einrücken
    Rectangle r1 = getBounds().getCopy();
    Rectangle r2 = getBounds().getCopy();
    
    r1.width=20;
    r1.height=r1.height-1;
    r2.x = r2.x+r2.width-20;
    r2.width=20;
    
    graphics.setBackgroundColor(Constants.COLOR_WORKAREA);
    graphics.setForegroundColor(Constants.COLOR_FONT);
    graphics.fillRectangle(r1);
    graphics.drawRectangle(r1);
    graphics.fillRectangle(r2);

    graphics.setForegroundColor(Constants.COLOR_WORKAREA);
    graphics.drawLine(r1.getTopLeft().getTranslated(0,1),r1.getBottomLeft().getTranslated(0,-1));

    
    // an der Oberkante der linken Seite den Schatten einfügen
    //
    int width =border.getWidth();
    Point left = r1.getTopLeft();
    Point right = r1.getTopRight().getTranslated(-1,0);
    for(int i=(width-1); i>=0; --i)
    {
      graphics.setForegroundColor(border.getColors()[i]);
      graphics.drawLine(left, right);
      left.translate(1,1);
      right.translate(0,1);
    }

    // an der oberkante der rechten Seite den Schatten einfügen
    //
    left = r2.getTopLeft();
    right = r2.getTopRight().getTranslated(-width,0);
    for(int i=(width-1); i>=0; --i)
    {
      graphics.setForegroundColor(border.getColors()[i]);
      graphics.drawLine(left, right);
      left.translate(1,1);
      right.translate(1,1);
    }

    // Linke Kante von der rechten Seite mit Schatten versehene
    //
    Point top    = r2.getTopRight().getTranslated(-width,0);
    Point bottom = r2.getTopRight().getTranslated(-width,0);
    for(int i=(width-1); i>=0; --i)
    {
      graphics.setForegroundColor(border.getColors()[i]);
      graphics.drawLine(top, bottom);
      top.translate(1,0);
      bottom.translate(1,1);
    }
  
    // Eckeanschluss von der Rechten Seite
    //
    top    = r2.getTopLeft();
    bottom = r2.getBottomLeft();
    for(int i=(width-1); i>=0; --i)
    {
      graphics.setForegroundColor(border.getColors()[i]);
      graphics.drawLine(top, bottom);
      top.translate(1,1);
      bottom.translate(1,0);
    }

    graphics.setForegroundColor(Constants.COLOR_FONT);
    graphics.drawLine(r2.getBottomLeft().getTranslated(0,-1),r2.getBottomRight().getTranslated(-width,-1));

    super.paintFigure(graphics);
  }
}