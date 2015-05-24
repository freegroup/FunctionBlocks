/*
 * Created on 09.01.2007
 *
 */
package de.netallied.functionblock.modeleditor.fbt.ecc.figures;

import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Insets;
import de.netallied.functionblock.modeleditor.fbt.ecc.Constants;
import de.netallied.functionblock.modeleditor.fbt.ecc.util.DoubleLineShadowBorder;
import de.netallied.functionblock.modeleditor.fbt.ecc.util.GradientLabel;

public class StartFigure extends StateFigure
{

  public StartFigure()
  {
    super();
  }
  
  protected Label createLabel()
  {
    // top, left, botom, right
    Insets insets = new Insets(7,10,10,14);
    
    GradientLabel l = new GradientLabel();
    l.setBorder(new DoubleLineShadowBorder());
    l.setInsets(insets);
    l.setTextAlignment(PositionConstants.TOP);
    return l;
  }
}
