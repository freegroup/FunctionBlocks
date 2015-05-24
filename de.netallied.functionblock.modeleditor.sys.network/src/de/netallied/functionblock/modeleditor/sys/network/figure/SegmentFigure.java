/*
 * Created on 25.01.2007
 *
 */
package de.netallied.functionblock.modeleditor.sys.network.figure;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;
import de.netallied.functionblock.modeleditor.sys.network.Constants;
import de.netallied.functionblock.modeleditor.sys.network.util.GradientLabel;

public class SegmentFigure extends GradientLabel
{
  private final int ARROW_WIDTH = 5;
  
  public SegmentFigure()
  {
    super("name des segment");
    setBorder(new PipeBorder());
    
    setInsets(new Insets(10,30,10,30));
  }
}
