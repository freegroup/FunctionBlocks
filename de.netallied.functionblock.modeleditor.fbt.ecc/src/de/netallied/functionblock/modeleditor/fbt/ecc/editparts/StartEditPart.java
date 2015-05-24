/*
 * Created on 09.01.2007
 *
 */
package de.netallied.functionblock.modeleditor.fbt.ecc.editparts;

import org.eclipse.draw2d.IFigure;
import de.netallied.functionblock.modeleditor.fbt.ecc.figures.StartFigure;
import de.netallied.functionblock.modeleditor.fbt.ecc.figures.StateFigure;

public class StartEditPart extends StateEditPart
{

  public StartEditPart()
  {
    super();
  }

  @Override
  protected IFigure createFigure()
  {
    return new StartFigure();
  }
  
  
  
}
