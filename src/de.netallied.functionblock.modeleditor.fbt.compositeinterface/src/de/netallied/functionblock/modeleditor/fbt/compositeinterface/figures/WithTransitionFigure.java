/*
 * Created on 23.02.2005
 *
 */
package de.netallied.functionblock.modeleditor.fbt.compositeinterface.figures;

import org.eclipse.draw2d.ManhattanConnectionRouter;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.PolylineConnection;
import de.netallied.functionblock.modeleditor.fbt.compositeinterface.Constants;

/**
 *
 */
public class WithTransitionFigure extends PolylineConnection
{

  public WithTransitionFigure()
  {
    PolygonDecoration deco= new PolygonDecoration();
    deco.setScale(7,3);
    setTargetDecoration(deco); // arrow at target
    setConnectionRouter(new ManhattanConnectionRouter());
//    setConnectionRouter(new FanRouter());
    setLineWidth(1);
    setForegroundColor(Constants.COLOR_FONT);
    
  }
}
