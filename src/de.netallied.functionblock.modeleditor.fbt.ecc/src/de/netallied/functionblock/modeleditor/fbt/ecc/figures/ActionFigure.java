/*
 * Created on 01.08.2006
 *
 */
package de.netallied.functionblock.modeleditor.fbt.ecc.figures;

import java.util.List;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Insets;
import de.netallied.functionblock.modeleditor.fbt.ecc.util.GradientLabel;
import de.netallied.functionblock.modeleditor.fbt.ecc.util.ShadowBorder;

public class ActionFigure extends Figure
{
  final Label algorithm;
  final Label event;
  
  public ActionFigure()
  {
    FlowLayout layout = new FlowLayout();
    layout.setMinorAlignment(ToolbarLayout.ALIGN_TOPLEFT);
    layout.setStretchMinorAxis(true);
    layout.setMajorSpacing(0);
    layout.setMinorSpacing(0);
    layout.setHorizontal(true);
    setLayoutManager(layout);
    setBorder(new ShadowBorder());
    
    algorithm = new GradientLabel();
    event  = new GradientLabel();
  
    Label codeTooltip = new Label("Algorithm");
    codeTooltip.setBorder(new LineBorder());
    algorithm.setToolTip(codeTooltip);
    
    Label eventTooltip = new Label("Event");
    eventTooltip.setBorder(new LineBorder());
    event.setToolTip(eventTooltip);
    
    algorithm.setBorder(new LineBorder());
    event.setBorder(new LineBorder());
    
    add(algorithm);
    add(event);
  }


  public void setCode(String nameOfcode)
  {
    algorithm.setText(nameOfcode);
  }
  
  public void setOut(String outName)
  {
    event.setText(outName);
  }
}
