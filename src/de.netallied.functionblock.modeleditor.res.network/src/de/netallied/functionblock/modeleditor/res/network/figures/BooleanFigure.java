/*
 * Created on 22.02.2005
 *
 */
package de.netallied.functionblock.modeleditor.res.network.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import de.netallied.functionblock.modeleditor.res.network.Constants;


/**
 *
 */
public class BooleanFigure extends RectangleFigure
{
  private Insets insets = new Insets(2,2,2,2);

  public BooleanFigure()
  {
    setSize(new Dimension(8,8));
  	setForegroundColor(Constants.COLOR_FONT);
  }
  
  public void paintFigure(Graphics g) 
  {  	
  	//g.setAntialias(SWT.ON);
  	Rectangle r = getBounds().getCopy().crop(insets);
    PointList points = new PointList();
    
    points.addPoint(r.x+r.width/2,r.y);
    points.addPoint(r.right(),r.y+r.height/2);
    points.addPoint(r.x+r.width/2,r.bottom());
    points.addPoint(r.x,r.y+r.height/2);
    
    g.setLineWidth(1);
    g.setForegroundColor(getForegroundColor());
    g.setBackgroundColor(getBackgroundColor());
    g.fillPolygon(points);
    g.drawPolygon(points);
  }

  @Override
  public Insets getInsets()
  {
    return insets;
  }
}


