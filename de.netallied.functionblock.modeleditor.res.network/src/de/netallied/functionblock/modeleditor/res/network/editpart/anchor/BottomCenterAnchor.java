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
public class BottomCenterAnchor extends ChopboxAnchor
{
 public BottomCenterAnchor( IFigure owner) 
 {
  super(owner);
 }

 public Point getLocation(Point reference)
 {
    Point center = getBox().getCenter().getCopy();
    Point bottom = getBox().getBottom().getCopy();
    getOwner().translateToAbsolute(center);
    getOwner().translateToAbsolute(bottom);
    
    return new Point(center.x,bottom.y);
 }
}
