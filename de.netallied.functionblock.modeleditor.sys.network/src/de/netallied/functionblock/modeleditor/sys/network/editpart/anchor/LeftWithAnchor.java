/*
 * Created on 01.12.2005
 *
 */
package de.netallied.functionblock.modeleditor.sys.network.editpart.anchor;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import de.netallied.functionblock.modeleditor.sys.network.editpart.LinkEditPart;
/**
 * 
 */
public class LeftWithAnchor extends ChopboxAnchor
{
  public LeftWithAnchor(IFigure figure)
  {
    super(figure);
  }

  public Point getLocation(Point reference)
  {
    Point p = new Point();
    Rectangle r = getOwner().getBounds().getCopy();
    getOwner().translateToAbsolute(r);
    
    if(r.x< reference.x && (r.x+r.width)>reference.x)
      p.x = reference.x;
    else if(r.x>reference.x)
      p.x= r.x;
    else
      p.x = r.getTopRight().x;
    
    if (r.contains(reference) || r.y < reference.y)
      p.y = r.getBottom().y;
    else
      p.y = r.getTop().y;
    
    return p;
  }
}
