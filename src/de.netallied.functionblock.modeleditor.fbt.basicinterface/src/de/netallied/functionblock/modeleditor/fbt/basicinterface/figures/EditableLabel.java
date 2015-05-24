package de.netallied.functionblock.modeleditor.fbt.basicinterface.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import de.netallied.functionblock.modeleditor.fbt.basicinterface.util.ILabelProvider;

/**
 * A customized Label based on the label used in the flow example. 
 * Primary selection is denoted by highlight and focus rectangle. 
 * Normal selection is denoted by highlight only. Borrowed from the Flow Editor example
 */
public class EditableLabel extends Label implements ILabelProvider
{
  Insets INSETS = new Insets(2,8,2,8);
	private boolean selected;
	
	public EditableLabel(String text)
	{
		super(text);
	}
	
  public Label getLabel()
  {
    return this;
  }
  
	private Rectangle getSelectionRectangle()
	{
		Rectangle bounds = getTextBounds().getCopy();
		bounds.expand(new Insets(2, 2, 0, 0));
		translateToParent(bounds);
		bounds.intersect(getBounds());
		return bounds;
	}

  public Insets getInsets() 
  {
    return INSETS;
  }

	/**
	 * paints figure differently depends on the whether the figure has focus or is selected 
	 */
  
	protected void paintFigure(Graphics graphics)
	{
		if (selected)
		{
			graphics.pushState();
			graphics.setBackgroundColor(ColorConstants.menuBackgroundSelected);
			graphics.fillRectangle(getSelectionRectangle());
			graphics.popState();
			graphics.setForegroundColor(ColorConstants.white);
		}
		super.paintFigure(graphics);
	}

  
	/**
	 * Sets the selection state of this SimpleActivityLabel
	 * 
	 * @param b
	 *            true will cause the label to appear selected
	 */
	public void setSelected(boolean b)
	{
		selected = b;
		repaint();
	}
}
