/*
 * Created on 25.01.2007
 *
 */
package de.netallied.functionblock.modeleditor.sys.network.figure;

import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.MarginBorder;
import de.netallied.functionblock.modeleditor.sys.network.Constants;

public class SystemFigure extends FreeformLayer
{
  public SystemFigure()
  {
    setBorder(new MarginBorder(3));
    setLayoutManager(new FreeformLayout());
    setBackgroundColor(Constants.COLOR_WORKAREA);
    setOpaque(true);
  }
}
