/*
 * Created on 01.12.2005
 *
 */
package de.netallied.functionblock.modeleditor.fbt.network.editpart.anchor;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;

/**
*
*/
public class LeftMiddleAnchor extends ChopboxAnchor
{
 public LeftMiddleAnchor( IFigure owner) 
 {
  super(owner);
 }

 public Point getLocation(Point reference)
 {
    Point center = getBox().getCenter().getCopy();
    Point left   = getBox().getLeft().getCopy();
    
    getOwner().translateToAbsolute(center);
    getOwner().translateToAbsolute(left);
    
    return new Point(left.x,center.y);
 }
}
