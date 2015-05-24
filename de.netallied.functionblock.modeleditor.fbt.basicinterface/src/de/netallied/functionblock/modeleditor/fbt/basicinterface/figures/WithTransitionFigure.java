/*
 * Created on 23.02.2005
 *
 */
package de.netallied.functionblock.modeleditor.fbt.basicinterface.figures;

import org.eclipse.draw2d.BendpointConnectionRouter;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FanRouter;
import org.eclipse.draw2d.ManhattanConnectionRouter;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.ShortestPathConnectionRouter;
import org.eclipse.draw2d.geometry.PointList;
import de.netallied.functionblock.modeleditor.fbt.basicinterface.Constants;

/**
 *
 */
public class WithTransitionFigure extends PolylineConnection
{
  private static final double SCALE = 0.2;
  
  public WithTransitionFigure()
  {
    setConnectionRouter(new BendpointConnectionRouter());
    setLineWidth(2);
    setForegroundColor(Constants.COLOR_FONT);

    //                                   
    // Construct point list similar to: 
    //   _
    //  |_|
    //
    PointList to1PointList = new PointList();
    int h = Constants.WITH_CARET_SIZE/2;
    to1PointList.addPoint(-h, -h);
    to1PointList.addPoint(-h,  h);
    to1PointList.addPoint( h,  h);
    to1PointList.addPoint( h, -h);
    to1PointList.addPoint(-h, -h);
    PolygonDecoration sourceDecoration = new PolygonDecoration();
    PolygonDecoration targetDecoration = new PolygonDecoration();
    sourceDecoration.setBackgroundColor(ColorConstants.white);
    sourceDecoration.setScale(SCALE, SCALE);
    sourceDecoration.setTemplate(to1PointList.getCopy());
    sourceDecoration.setOpaque(false);

    targetDecoration.setBackgroundColor(ColorConstants.white);
    targetDecoration.setScale(SCALE, SCALE);
    targetDecoration.setTemplate(to1PointList.getCopy());
    targetDecoration.setOpaque(false);

    setTargetDecoration(targetDecoration);
    setSourceDecoration(sourceDecoration);
  }
}
