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
public class YAlignAnchor extends ChopboxAnchor
{
 public YAlignAnchor( IFigure owner) 
 {
  super(owner);
 }

 public Point getLocation(Point reference)
 {
    Point center = getBox().getCenter().getCopy();
    Point right = getBox().getRight().getCopy();
    getOwner().translateToAbsolute(center);
    getOwner().translateToAbsolute(right);
    
    return new Point(right.x,reference.y);
 }
 
}
