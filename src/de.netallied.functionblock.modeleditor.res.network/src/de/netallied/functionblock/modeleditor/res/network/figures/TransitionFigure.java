/*
 * Created on 23.02.2005
 *
 */
package de.netallied.functionblock.modeleditor.res.network.figures;

import org.eclipse.draw2d.ManhattanConnectionRouter;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.PolylineConnection;

import de.netallied.functionblock.modeleditor.res.network.Constants;

/**
 *
 */
public class TransitionFigure extends PolylineConnection
{

  public TransitionFigure()
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
