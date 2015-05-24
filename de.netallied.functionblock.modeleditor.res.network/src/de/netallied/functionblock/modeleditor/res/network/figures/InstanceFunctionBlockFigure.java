package de.netallied.functionblock.modeleditor.res.network.figures;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.jface.action.Action;

import de.netallied.functionblock.modeleditor.res.network.Constants;
import de.netallied.functionblock.modeleditor.res.network.util.ILabelProvider;
import de.netallied.functionblock.modeleditor.res.network.util.ShadowBorder;

/**
 *
 */
public class InstanceFunctionBlockFigure extends Figure implements ILabelProvider
{
	ShadowBorder border = new ShadowBorder();
  int waistPos;
  Label label;
  Label type;
  public InstanceFunctionBlockFigure(int waistPos)
  {
    setLayoutManager(new FreeformLayout());
    setPreferredSize(50,50);
    
    this.waistPos = waistPos;
//    setBorder(border);
    label =new Label("asdf");
    label.setTextAlignment(PositionConstants.CENTER);
    label.setLabelAlignment(PositionConstants.CENTER);
    add(label);
    type =new Label("asdf");
    type.setTextAlignment(PositionConstants.CENTER);
    type.setLabelAlignment(PositionConstants.CENTER);
    add(type);
  }
  
  @Override
	public void setBounds(Rectangle arg0) 
  {
  	label.setLocation(arg0.getTopLeft());
  	label.setSize(arg0.width, label.getPreferredSize().height);
  	
  	type.setLocation(arg0.getTopLeft().getTranslated(border.getWidth(), waistPos));
  	type.setSize(arg0.width, label.getPreferredSize().height);
		super.setBounds(arg0);
	}

	public void paintFigure(Graphics graphics) 
  {
  	super.paintFigure(graphics);
//  	new Label("asdf").paint(graphics);
		// die linke und rechte Seite mit der Hintergrundfarbe einrücken
    Rectangle leftRect = getBounds().getCopy();
    Rectangle rightRect = getBounds().getCopy();
    leftRect.y      = leftRect.y+waistPos-Constants.RULE_GRID_HEIGHT/2;
    leftRect.x      = leftRect.x+border.getWidth();
    leftRect.height = Constants.RULE_GRID_HEIGHT;
    leftRect.width  = 20;
    
    rightRect.y      = rightRect.y+waistPos-Constants.RULE_GRID_HEIGHT/2;
    rightRect.x      = rightRect.x+rightRect.width-20;
    rightRect.height = Constants.RULE_GRID_HEIGHT;
    rightRect.width  = 20;
    

    // den äusseren Rahmen zeichnen
  	//
    graphics.setForegroundColor(Constants.COLOR_PANE);
    graphics.setBackgroundColor(Constants.COLOR_HEADER);
    Rectangle b = getBounds().getCopy();
    b.width=b.width-border.getWidth()*2;
    b.height=b.height-border.getWidth();
    b.x     =b.x+border.getWidth();
    graphics.fillGradient(b,true);
    
    graphics.setBackgroundColor(Constants.COLOR_WORKAREA);
    graphics.setForegroundColor(Constants.COLOR_FONT);
    graphics.drawRectangle(b);
  	
    // Linke und rechte Seite mit der Hintergrundfarbe löschen
    //
    graphics.fillRectangle(leftRect);
    graphics.drawRectangle(leftRect);
    graphics.fillRectangle(rightRect);

    // Linke Kante der linken Seite löschen
    //
    graphics.setForegroundColor(Constants.COLOR_WORKAREA);
    graphics.drawLine(leftRect.getTopLeft().getTranslated(0,1),leftRect.getBottomLeft().getTranslated(0,-1));
    
    // an der Oberkante der linken Seite den Schatten einfügen
    //
    int width =border.getWidth();
    Point left = leftRect.getTopLeft();
    Point right = leftRect.getTopRight().getTranslated(-1,0);
    for(int i=(width-1); i>=0; --i)
    {
      graphics.setForegroundColor(border.getColors()[i]);
      graphics.drawLine(left, right);
      left.translate(1,1);
      right.translate(0,1);
    }

    // An der Oberkante der rechten Seite den Schatten einfügen
    //
    left = rightRect.getTopLeft();
    right = rightRect.getTopRight().getTranslated(-width,0);
    for(int i=(width-1); i>=0; --i)
    {
      graphics.setForegroundColor(border.getColors()[i]);
      graphics.drawLine(left, right);
      left.translate(1,1);
      right.translate(1,1);
    }

    // Linke Kante von der rechten Seite mit Schatten versehene
    //
    Point top    = rightRect.getTopLeft();
    Point bottom = rightRect.getBottomLeft();
    for(int i=(width-1); i>=0; --i)
    {
      graphics.setForegroundColor(border.getColors()[i]);
      graphics.drawLine(top, bottom);
      top.translate(1,1);
      bottom.translate(1,0);
    }

    // Untere Kante der rechtens Seite zeichnen
    //
    graphics.setForegroundColor(Constants.COLOR_FONT);
    graphics.drawLine(rightRect.getBottomLeft(),rightRect.getBottomRight().getTranslated(-width,0));
    
    
    // SCHATTEN VOM HAUPTELEMENT ZEICHNEN
    // Unten!
    Rectangle rectExt = getBounds();
		right  = rectExt.getBottomRight();
		left = rectExt.getBottomLeft().getTranslated(border.getWidth()*2, 0);

		for(int i = 0; i<border.getWidth();++i)
		{
			graphics.setForegroundColor(border.getColors()[i]);
      graphics.drawLine(right, left);
      right.translate(-1,-1);
      left.translate(-1,-1);
		}

		// und die beiden rechten Seiten
		//
		top    = rectExt.getTopRight().getTranslated(0,border.getWidth());
		bottom = top.getTranslated(0, waistPos-Constants.RULE_GRID_HEIGHT/2-1); 
		for(int i = 0; i<border.getWidth();++i)
		{
			graphics.setForegroundColor(border.getColors()[i]);
      graphics.drawLine(top, bottom);
      top.translate(-1,-1);
      bottom.translate(-1,-1);
		}
		
		top    = rectExt.getTopRight().getTranslated(0,border.getWidth()+waistPos+Constants.RULE_GRID_HEIGHT/2);
		bottom = rectExt.getBottomRight().getTranslated(0, 0); 
		for(int i = 0; i<border.getWidth();++i)
		{
			graphics.setForegroundColor(border.getColors()[i]);
      graphics.drawLine(top, bottom);
      top.translate(-1,-1);
      bottom.translate(-1,-1);
		}
    
  }

	public void setWaistPos(int i) 
	{
		this.waistPos = i;
	}
	
  public Label getLabel() 
  {
		return label;
	}

	public Label getType() 
	{
		return type;
	}

}
