/*
 * Created on 01.12.2005
 *
 */
package de.netallied.functionblock.modeleditor.res.network.editpart.anchor;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;

/**
*
*/
public class OffsetAnchor extends ChopboxAnchor
{
	int xOffset;
	int yOffset;
 public OffsetAnchor( IFigure owner, int xOffset, int yOffset) 
 {
  super(owner);
  this.xOffset = xOffset;
  this.yOffset = yOffset;
 }

 public Point getLocation(Point reference)
 {
    Point p = getBox().getTopLeft().getCopy();
    getOwner().translateToAbsolute(p);
    
    return new Point(p.x+xOffset,p.y+yOffset);
 }
}
