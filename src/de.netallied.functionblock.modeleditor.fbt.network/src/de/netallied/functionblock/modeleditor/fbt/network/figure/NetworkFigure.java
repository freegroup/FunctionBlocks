package de.netallied.functionblock.modeleditor.fbt.network.figure;

import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.MarginBorder;

public class NetworkFigure extends FreeformLayer
{
	public NetworkFigure()
	{
    setBorder(new MarginBorder(3));
    setLayoutManager(new FreeformLayout());
    setOpaque(true);
	}
}
