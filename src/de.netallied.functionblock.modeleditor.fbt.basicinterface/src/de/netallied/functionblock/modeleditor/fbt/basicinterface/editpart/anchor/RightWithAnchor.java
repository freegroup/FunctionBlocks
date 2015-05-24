/*
 * Created on 01.12.2005
 *
 */
package de.netallied.functionblock.modeleditor.fbt.basicinterface.editpart.anchor;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import de.netallied.functionblock.modeleditor.fbt.basicinterface.Constants;
import de.netallied.functionblock.modeleditor.fbt.basicinterface.editpart.WithTransitionOutEditPart;
import de.netallied.functionblock.model.WithTransitionOutModel;
/**
 * 
 */
public class RightWithAnchor extends ChopboxAnchor implements PropertyChangeListener
{
  int xOffset;
  int yOffset;

  public RightWithAnchor(IFigure figure, WithTransitionOutEditPart connection)
  {
    super(figure);
    this.yOffset = figure.getPreferredSize().height/2;
    this.xOffset = 10+Constants.WITH_CARET_SIZE/2*connection.getWithTransitionModel().getSortIndex();
    
    connection.getWithTransitionModel().addPropertyChangeListener(this);
  }

  public Point getLocation(Point reference)
  {
    Point p = getBox().getTopRight().getCopy();
    getOwner().translateToAbsolute(p);
    return new Point(p.x + xOffset, p.y + yOffset);
  }

  public int getXOffset()
  {
    return xOffset;
  }

  public void setXOffset(int offset)
  {
    xOffset = offset;
  }

  public void propertyChange(PropertyChangeEvent evt)
  {
    WithTransitionOutModel trans= (WithTransitionOutModel)evt.getSource();
    this.xOffset =  10+Constants.WITH_CARET_SIZE/2*trans.getSortIndex();
    fireAnchorMoved();
  }

}
