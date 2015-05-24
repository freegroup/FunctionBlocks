package de.netallied.functionblock.modeleditor.fbt.network.figure;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.jface.action.Action;

import de.netallied.functionblock.modeleditor.fbt.network.Constants;

/**
 *
 */
public class CompositeInputEventFigure extends Label// Figure implements ILabelProvider
{
  public CompositeInputEventFigure()
  {
    super("DDDDDDDDDDDDDDDD");
    setFont(Constants.FONT_SMALL);    
  }
  
}
