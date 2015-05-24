/*
 * Created on 02.08.2006
 *
 */
package de.netallied.functionblock.modeleditor.fbt.ecc.figures;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

public class HLineFigure extends Figure
{
  public HLineFigure(int width)
  {
    setMaximumSize(new Dimension(width,-1));
    setMinimumSize(new Dimension(width,-1));
    setPreferredSize(width,-1);
  }
  
  public void paintFigure(Graphics g) 
  {
    Rectangle r = getBounds().getCopy();

    r.y = r.y+r.height/2;
    g.setLineWidth(2);
    g.drawLine(r.getTopLeft(),r.getTopRight());
  }
}
