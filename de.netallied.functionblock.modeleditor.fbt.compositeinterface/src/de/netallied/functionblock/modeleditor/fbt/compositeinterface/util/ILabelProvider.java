/*
 * Created on 02.08.2006
 *
 */
package de.netallied.functionblock.modeleditor.fbt.compositeinterface.util;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;

public interface ILabelProvider extends IFigure
{
  public Label getLabel();
}
