package de.netallied.functionblock.modeleditor.fbt.basicinterface.util;

import org.eclipse.draw2d.AbstractBorder;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;
import de.netallied.functionblock.modeleditor.fbt.basicinterface.Constants;

public class DoubleLineShadowBorder extends AbstractBorder
{
	private int shadowWidth = 4;
  private int innerlineDist =2;
  
	private Color [] colors; 
	
  
	public void setWidth(int width)
	{
		this.shadowWidth = width;
		colors = null;
	}
  
	public Color [] getColors()
	{
		if(colors == null)
			createColors();
		return colors;
	}
  
	private void createColors()
	{
		Color ref1 = Constants.COLOR_WORKAREA;
		Color ref2 = Constants.COLOR_BORDER_DARK;
		colors = new Color[shadowWidth];
		for(int i = 0; i<shadowWidth; ++i)
			colors[shadowWidth-1-i] = new Color(null, ref2.getRed()+ (ref1.getRed()-ref2.getRed())*i/(shadowWidth-1),
				ref2.getGreen()+ (ref1.getGreen()-ref2.getGreen())*i/(shadowWidth-1),
				ref2.getBlue()+ (ref1.getBlue()-ref2.getBlue())*i/(shadowWidth-1));
	}
	public Insets getInsets(IFigure arg0)
	{ 
    return new Insets(innerlineDist,innerlineDist,innerlineDist+shadowWidth,innerlineDist+shadowWidth);
	}
  
	public void paint(IFigure figure, Graphics graphics, Insets arg2)
	{
		Rectangle bounds = figure.getBounds();
		Rectangle rectExt = bounds.getCropped(arg2);

		graphics.setBackgroundColor(Constants.COLOR_WORKAREA);
		graphics.setForegroundColor(Constants.COLOR_FONT);
    graphics.fillRectangle(rectExt.x+rectExt.width-shadowWidth, rectExt.y, shadowWidth, shadowWidth);
    graphics.fillRectangle(rectExt.x, rectExt.y+rectExt.height-shadowWidth, shadowWidth, shadowWidth);
		
    
		int lVert = (rectExt.height-shadowWidth-1);
		int lHor =  (rectExt.width-shadowWidth-1);
		Point bottomRight  = new Point(rectExt.x+rectExt.width-1, rectExt.y+rectExt.height-1);
		Point topRight = bottomRight.getCopy().translate(0,-lVert);
		Point bottomLeft = bottomRight.getCopy().translate(-lHor,0);

		for(int i = 0; i<shadowWidth;++i)
		{
			graphics.setForegroundColor(getColors()[i]);
      graphics.drawLine(bottomRight, topRight);
      bottomRight.translate(-1,0);

      graphics.drawLine(bottomRight, bottomLeft);
      bottomRight.translate(0,-1);

      topRight.translate(-1,-1);
      bottomLeft.translate(-1,-1);
		}
    
    graphics.setForegroundColor(Constants.COLOR_FONT);
    graphics.setLineWidth(1);
    
    graphics.drawLine(bounds.getTopLeft(), bounds.getTopRight().getTranslated(-shadowWidth,0));
    graphics.drawLine(bounds.getTopLeft(), bounds.getBottomLeft().getTranslated(0,-shadowWidth));
    graphics.drawLine(bounds.getTopRight().getTranslated(-shadowWidth,0),bounds.getBottomRight().getTranslated(-shadowWidth,-shadowWidth));
    graphics.drawLine(bounds.getBottomRight().getTranslated(-shadowWidth,-shadowWidth),bounds.getBottomLeft().getTranslated(0,-shadowWidth));

    graphics.drawLine(bounds.getTopLeft().getTranslated(innerlineDist,innerlineDist), bounds.getTopRight().getTranslated(-shadowWidth-innerlineDist,innerlineDist));
    graphics.drawLine(bounds.getTopLeft().getTranslated(innerlineDist,innerlineDist), bounds.getBottomLeft().getTranslated(innerlineDist,-shadowWidth-innerlineDist));
    graphics.drawLine(bounds.getTopRight().getTranslated(-shadowWidth-innerlineDist,innerlineDist),bounds.getBottomRight().getTranslated(-shadowWidth-innerlineDist,-shadowWidth-innerlineDist));
    graphics.drawLine(bounds.getBottomRight().getTranslated(-shadowWidth-innerlineDist,-shadowWidth-innerlineDist),bounds.getBottomLeft().getTranslated(innerlineDist,-shadowWidth-innerlineDist));
	}


  public int getWidth()
  {
    return shadowWidth;
  }
}
