package de.netallied.functionblock.modeleditor.fbt.ecc.util;

import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.swt.graphics.Image;

public class InsetsLabel extends Label
{
  private Insets insets = new Insets(2,8,2,8);
  
  public InsetsLabel()
  {
    super();
  }

  public InsetsLabel(Image arg0)
  {
    super(arg0);
  }

  public InsetsLabel(String arg0, Image arg1)
  {
    super(arg0, arg1);
  }

  public InsetsLabel(String arg0)
  {
    super(arg0);
  }

  @Override
  public Insets getInsets()
  {
    return insets;
  }
  
  public void setInsets(Insets insets)
  {
    this.insets = insets;
  }
  
}
