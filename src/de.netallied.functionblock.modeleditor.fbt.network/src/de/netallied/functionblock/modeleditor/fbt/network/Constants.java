/*
 * Created on 09.11.2005
 *
 */
package de.netallied.functionblock.modeleditor.fbt.network;

import org.eclipse.draw2d.SchemeBorder;
import org.eclipse.draw2d.SchemeBorder.Scheme;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;

public class Constants
{
  public static Font  FONT_SMALL          = new Font(null, "Arial", 7,  SWT.NORMAL);
  public static Font  FONT_NORMAL         = new Font(null, "Arial", 8,  SWT.NORMAL);
  public static Font  FONT_NORMAL_BOLD    = new Font(null, "Arial", 8,  SWT.BOLD);
  public static Font  FONT_BIG            = new Font(null, "Arial", 12, SWT.NORMAL);
  public static Font  FONT_BIG_BOLD       = new Font(null, "Arial", 14, SWT.BOLD);
	
  public static Color COLOR_PANE          = new Color(null, 238, 238, 238);
  public static Color COLOR_HEADER        = new Color(null, 224, 224, 224);
  public static Color COLOR_BORDER        = new Color(null, 152, 152, 152);
  public static Color COLOR_BORDER_DARK   = new Color(null, 93,  93,  94);
  public static Color COLOR_BORDER_BRIGHT = new Color(null, 152, 152, 152);
  public static Color COLOR_FONT          = new Color(null, 33,  33,  44);
  public static Color COLOR_WORKAREA      = new Color(null, 255,  255,  255);
  public static Color COLOR_STICKYNOTE    = new Color(null, 255, 255, 153);
  
  public static final int RULE_GRID_WIDTH     = 25;
  public static final int RULE_GRID_HEIGHT    = 25;
	public static final int RULE_ELEMENT_HEIGHT = RULE_GRID_HEIGHT*2;
  
  public static int   WITH_CARET_SIZE = 30;

  public static final SchemeBorder BORDER= new SchemeBorder(new Scheme(
      new Color[]{Constants.COLOR_BORDER_DARK},
      new Color[]{Constants.COLOR_BORDER_BRIGHT}));
}
