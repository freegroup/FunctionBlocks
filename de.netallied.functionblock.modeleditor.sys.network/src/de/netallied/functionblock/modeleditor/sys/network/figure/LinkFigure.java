/*
 * Created on 25.01.2007
 *
 */
package de.netallied.functionblock.modeleditor.sys.network.figure;

import org.eclipse.draw2d.ManhattanConnectionRouter;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.PolylineConnection;

public class LinkFigure extends PolylineConnection
{
  public LinkFigure()
  {
    PolygonDecoration deco= new PolygonDecoration();
    deco.setScale(7,3);
    setTargetDecoration(deco); // arrow at target
    setConnectionRouter(new ManhattanConnectionRouter());
  //  setConnectionRouter(new FanRouter());
    setLineWidth(1);
   // setForegroundColor(Constants.COLOR_FONT);
  }
}
