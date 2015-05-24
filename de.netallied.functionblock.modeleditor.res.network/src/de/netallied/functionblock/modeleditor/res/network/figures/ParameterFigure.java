/*
 * Created on 31.01.2007
 *
 */
package de.netallied.functionblock.modeleditor.res.network.figures;

import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import de.netallied.functionblock.modeleditor.res.network.Constants;
import de.netallied.functionblock.modeleditor.res.network.util.GradientLabel;
import de.netallied.functionblock.modeleditor.res.network.util.ShadowBorder;

public class ParameterFigure extends GradientLabel
{
  public ParameterFigure(String arg0)
  {
    super(arg0);
    this.setFont(Constants.FONT_SMALL);
    this.setBorder(new ShadowBorder());
    this.setTextAlignment(PositionConstants.TOP);
  }
}
