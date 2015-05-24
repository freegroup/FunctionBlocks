/*
 * Created on 01.08.2006
 *
 */
package de.netallied.functionblock.modeleditor.fbt.ecc.figures;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Insets;
import de.netallied.functionblock.modeleditor.fbt.ecc.util.GradientLabel;
import de.netallied.functionblock.modeleditor.fbt.ecc.util.ILabelProvider;
import de.netallied.functionblock.modeleditor.fbt.ecc.util.ShadowBorder;

public class StateFigure extends Figure implements ILabelProvider
{
  Label label;
  IFigure       ruler = new HLineFigure(15);
  
  public StateFigure()
  {
    label = createLabel();
    
    FlowLayout layout = new FlowLayout();
    layout.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);
    layout.setStretchMinorAxis(true);
    layout.setMajorSpacing(0);
    layout.setMinorSpacing(0);
    layout.setHorizontal(true);
    setLayoutManager(layout);

    // top, left, bottom, right
    add(label);
    add(ruler);
    setChildrenDirection(PositionConstants.RIGHT);
  }

  public void setHasAction(boolean hasAction)
  {
    ruler.setVisible(hasAction);
  }
  
  public void setText(String text)
  {
    label.setText(text);
  }


  public Label getLabel()
  {
    return label;
  }
  
  protected Label createLabel()
  {
    Label l = new GradientLabel();
    l.setBorder(new ShadowBorder());
    return l;
  }
}
