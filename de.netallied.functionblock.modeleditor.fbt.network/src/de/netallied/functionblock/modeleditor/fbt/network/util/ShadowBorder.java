package de.netallied.functionblock.modeleditor.fbt.network.util;

import org.eclipse.draw2d.AbstractBorder;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;
import de.netallied.functionblock.modeleditor.fbt.network.Constants;

public class ShadowBorder extends AbstractBorder
{
	private int width = 4;
	private Color [] colors; 
	
  private boolean top    = true;
  private boolean right  = true;
  private boolean bottom = true;
  private boolean left   = true;
  
	public void setWidth(int width)
	{
		this.width = width;
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
		colors = new Color[width];
		for(int i = 0; i<width; ++i)
			colors[width-1-i] = new Color(null, ref2.getRed()+ (ref1.getRed()-ref2.getRed())*i/(width-1),
				ref2.getGreen()+ (ref1.getGreen()-ref2.getGreen())*i/(width-1),
				ref2.getBlue()+ (ref1.getBlue()-ref2.getBlue())*i/(width-1));
	}
	public Insets getInsets(IFigure arg0)
	{ 
    return new Insets(0,0,bottom?width:0,right?width:0);
	}
  
	public void paint(IFigure figure, Graphics graphics, Insets arg2)
	{
		Rectangle bounds = figure.getBounds();
		Rectangle rectExt = bounds.getCropped(arg2);

		graphics.setBackgroundColor(Constants.COLOR_WORKAREA);
		graphics.setForegroundColor(Constants.COLOR_FONT);
    if(right)
		  graphics.fillRectangle(rectExt.x+rectExt.width-width, rectExt.y, width, width);
    
    if(bottom)
      graphics.fillRectangle(rectExt.x, rectExt.y+rectExt.height-width, width, width);
		
    
		int lVert = top?(rectExt.height-width-1) :(rectExt.height);
		int lHor =  left?(rectExt.width-width-1) : (rectExt.width);
		Point bottomRight  = new Point(rectExt.x+rectExt.width-1, rectExt.y+rectExt.height-1);
		Point topRight = bottomRight.getCopy().translate(0,-lVert);
		Point bottomLeft = bottomRight.getCopy().translate(-lHor,0);

		for(int i = 0; i<width;++i)
		{
			graphics.setForegroundColor(getColors()[i]);
      if(right)
      {
        graphics.drawLine(bottomRight, topRight);
        bottomRight.translate(-1,0);
      }
      if(bottom)
      {
        graphics.drawLine(bottomRight, bottomLeft);
        bottomRight.translate(0,-1);
      }
      topRight.translate(-1,top?-1:0);
      bottomLeft.translate(left?-1:0,-1);
		}
    
    graphics.setForegroundColor(Constants.COLOR_FONT);
    graphics.setLineWidth(1);
    
    // obere Kante nur zeichenen wenn gewollt
    if(top)
      graphics.drawLine(bounds.getTopLeft(), bounds.getTopRight().getTranslated(right?-width:0,0));
    
    // linke Kante nur Zeichnen wenn gewollt
    if(left)
      graphics.drawLine(bounds.getTopLeft(), bounds.getBottomLeft().getTranslated(0,bottom?-width:0));

    // linke Kante nur Zeichnen wenn gewollt
    if(right)
      graphics.drawLine(bounds.getTopRight().getTranslated(-width,0),bounds.getBottomRight().getTranslated(-width,bottom?-width:0));

    // linke Kante nur Zeichnen wenn gewollt
    if(bottom)
      graphics.drawLine(bounds.getBottomRight().getTranslated(-width,bottom?-width:0),bounds.getBottomLeft().getTranslated(0,bottom?-width:0));
	}

  public void setBottom(boolean bottom)
  {
    this.bottom = bottom;
  }

  public void setLeft(boolean left)
  {
    this.left = left;
  }

  public void setRight(boolean right)
  {
    this.right = right;
  }

  public void setTop(boolean top)
  {
    this.top = top;
  }

  public int getWidth()
  {
    return width;
  }
}
