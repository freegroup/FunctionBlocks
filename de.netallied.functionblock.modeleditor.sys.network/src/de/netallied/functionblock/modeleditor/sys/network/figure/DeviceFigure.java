/*
 * Created on 25.01.2007
 *
 */
package de.netallied.functionblock.modeleditor.sys.network.figure;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.SchemeBorder;
import org.eclipse.draw2d.geometry.Insets;
import de.netallied.functionblock.modeleditor.sys.network.Activator;
import de.netallied.functionblock.modeleditor.sys.network.Constants;
import de.netallied.functionblock.modeleditor.sys.network.util.GradientLabel;
import de.netallied.functionblock.modeleditor.sys.network.util.ILabelProvider;
import de.netallied.functionblock.modeleditor.sys.network.util.InsetsLabel;

public class DeviceFigure extends Figure implements ILabelProvider
{
  private final InsetsLabel nameLabel;
  private final Label typeLabel;
  
  public DeviceFigure()
  {
//    setPreferredSize(50,50);
    
    FlowLayout layout = new FlowLayout();
//    layout.setMinorAlignment(alignment);
    layout.setStretchMinorAxis(true);
    layout.setMajorSpacing(0);
    layout.setMinorSpacing(0);
    layout.setHorizontal(false);
    setLayoutManager(layout);

    setBorder(new ShadowBorder());
    
    this.nameLabel = new InsetsLabel();
    this.typeLabel = new Label();
    
    this.nameLabel.setFont(Constants.FONT_NORMAL_BOLD);
    this.nameLabel.setIcon(Activator.getDefault().getImage("figure_device.png"));
    this.nameLabel.setInsets(new Insets(8,5,0,0));
    this.typeLabel.setFont(Constants.FONT_SMALL);
    
    add(nameLabel);
    add(typeLabel);
  }
  
  public void setName(String text)
  {
   this.nameLabel.setText(text); 
  }
  
  public void setType(String text)
  {
   this.typeLabel.setText("<"+text+">"); 
  }
  
  public Label getLabel()
  {
    return nameLabel;
  }
}
