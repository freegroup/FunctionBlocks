/*
 * Created on 23.02.2005
 *
 */
package de.netallied.functionblock.modeleditor.fbt.ecc.figures;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.draw2d.AbsoluteBendpoint;
import org.eclipse.draw2d.BendpointConnectionRouter;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.draw2d.ConnectionRouter;
import org.eclipse.draw2d.FanRouter;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.ManhattanConnectionRouter;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.RootEditPart;
import de.netallied.functionblock.modeleditor.fbt.ecc.util.AlphaLabel;

/**
 *
 */
public class TransitionFigure extends PolylineConnection
{
  Label description;
  
  private static class LabelLocator extends ConnectionLocator
  {
    public LabelLocator(Connection c)
    {
      super(c);
    }

    protected Point getReferencePoint()
    {
      Connection conn = getConnection();
      Point p = Point.SINGLETON;
      int index = (conn.getPoints().size() - 1) / 2;
      Point p1 = conn.getPoints().getPoint(index);
      Point p2 = conn.getPoints().getPoint(index + 1);
      conn.translateToAbsolute(p1);
      conn.translateToAbsolute(p2);
      p.x = (p2.x - p1.x) / 2 + p1.x;
      p.y = (p2.y - p1.y) / 2 + p1.y;

      // if the 2 points are on a horizontal line,
      // the label should be located a little bit below!
      if (p1.y == p2.y)
        p.y += 10;

      return p;
    }
  }  

  public TransitionFigure(RootEditPart root, String label)
  {
    
    setTargetDecoration(new PolygonDecoration()); // arrow at target
    description = new AlphaLabel(root, label);
    
    add(description, new LabelLocator(this));
    BendpointConnectionRouter router = new BendpointConnectionRouter();
    setConnectionRouter(router);
    System.out.println(getConnectionRouter());
    List figureConstraint = new ArrayList();
    AbsoluteBendpoint rbp = new AbsoluteBendpoint(100,100);
    figureConstraint.add(rbp);
    router.setConstraint(this,figureConstraint);
    
  }
  
  public Label getLabel()
  {
    return description;
  }
  
  public void setText(String text)
  {
    description.setText(text);
  }

  public void setFulcrum(Point fulcrum)
  {
    List figureConstraint = new ArrayList();
    AbsoluteBendpoint rbp = new AbsoluteBendpoint(fulcrum);
    figureConstraint.add(rbp);
    setRoutingConstraint(figureConstraint);
  }
}