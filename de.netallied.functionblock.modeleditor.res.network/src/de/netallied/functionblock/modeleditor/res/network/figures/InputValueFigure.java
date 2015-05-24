package de.netallied.functionblock.modeleditor.res.network.figures;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Rectangle;

import de.netallied.functionblock.modeleditor.res.network.Constants;


public class InputValueFigure extends Figure 
{
	public InputValueFigure(String s ) 
	{
    ToolbarLayout layout = new ToolbarLayout(true);
    layout.setStretchMinorAxis(true);
		setLayoutManager(layout);
    Label label = new Label(s);
    label.setFont(Constants.FONT_SMALL);
//    label.setBorder(new LineBorder(1));
    add(new PortFigure());
		add(label);
	}
  
  public void setBounds(Rectangle rect) 
  {
    rect.setSize(getPreferredSize());
    super.setBounds(rect);
  }
}
