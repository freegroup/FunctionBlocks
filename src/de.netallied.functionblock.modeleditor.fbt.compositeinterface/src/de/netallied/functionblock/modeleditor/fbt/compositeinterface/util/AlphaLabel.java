/*
 * Created on 24.01.2005
 *
 */
package de.netallied.functionblock.modeleditor.fbt.compositeinterface.util;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.RootEditPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

/**
 *
 */
public class AlphaLabel extends Label
{

  private FigureCanvas canvas;
  private int width = 0, height = 0;
  private Image image=null;
  
  public AlphaLabel(RootEditPart editpart, String s) 
  {
    super(s);
    canvas = (FigureCanvas) editpart.getViewer().getControl();
    setLayoutManager(new XYLayout());
    setBorder(new LineBorder(ColorConstants.lightGray));
  }

  

  public void paint(Graphics graphics)
  {
    if((getText()!=null && getText().length()> 0 && isVisible()) || image==null)
    {
      super.paint(graphics);
    }
  }
  
  protected void paintFigure(Graphics g)
  {
	    if (image != null)
	    {
	      Rectangle r = getBounds();
	      g.drawImage(image, r.x, r.y); // draw picture of swt control onto figure
	    }
  }

  /*
   * (non-Javadoc)
   * WARNING: Memory leak. dispose wird nie aufgerufen!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
   * 
   * @see org.eclipse.draw2d.IFigure#removeNotify()
   */
  public void dispose()
  {
    if (image != null)
    {
      image.dispose();
      image = null;
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.draw2d.Figure#layout()
   */
  protected void layout()
  {
    width = getClientArea().width;
    height = getClientArea().height;
    if (image != null)
    {
      image.dispose();
      image = null;
    }
    // Create any SWT control here
    org.eclipse.swt.widgets.Label label = new org.eclipse.swt.widgets.Label(canvas, SWT.NONE);
    label.setBackground(ColorConstants.white);
    label.addPaintListener(new SWTPaintListener());
    Point p1 = new Point(0,0);
    translateToAbsolute(p1); // coordinates returned are negative if canvas is
                             // scrolled
    label.setText(getText());
   
    label.setBounds(0,0, width+3, height+3);
    label.moveAbove(null); // necessary
    
    super.layout();
  }

  private class SWTPaintListener implements PaintListener
  {
    public void paintControl(PaintEvent e)
    {
      if(width<=0 || height<=0)
        return;
      image = new Image(canvas.getDisplay(), width, height);
      ImageData data = image.getImageData();
      data.alpha=200;
      image = new Image(canvas.getDisplay(),data);
      e.gc.copyArea(image,0,0);
      final Control source = (Control) e.getSource();
      try
      {
        Display.getDefault().asyncExec(new Runnable()
        {
          public void run()
          {
            source.dispose();
          }
        });
      }
      catch (Exception e1)
      {
      }
      repaint();
    }
  } 
}
