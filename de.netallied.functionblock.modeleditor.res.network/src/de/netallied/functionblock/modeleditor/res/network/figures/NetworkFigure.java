package de.netallied.functionblock.modeleditor.res.network.figures;

import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.MarginBorder;
import de.netallied.functionblock.modeleditor.res.network.Constants;

public class NetworkFigure extends FreeformLayer
{
	public NetworkFigure()
	{
    setBorder(new MarginBorder(3));
    setLayoutManager(new FreeformLayout());
    setOpaque(true);
    setBackgroundColor(Constants.COLOR_WORKAREA);
	}
}
