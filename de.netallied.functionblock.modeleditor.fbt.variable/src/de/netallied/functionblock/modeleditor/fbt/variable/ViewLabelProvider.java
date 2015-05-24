/*
 * Created on 04.01.2007
 *
 */
package de.netallied.functionblock.modeleditor.fbt.variable;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import de.netallied.functionblock.model.InternalVariableModel;

class ViewLabelProvider extends LabelProvider implements ITableLabelProvider 
{

  private final Editor labelProvider;
  /**
   * @param view
   */
  ViewLabelProvider(Editor view)
  {
    labelProvider = view;
  }
  
  public String getColumnText(Object obj, int index) 
  {
    System.out.println(index);
    switch(index)
    {
    case 0:
      return ((InternalVariableModel)obj).getName();
    case 1:
      return ((InternalVariableModel)obj).getType();
    default:
      return null;
    }
	}
  
	public Image getColumnImage(Object obj, int index) 
  {
    if(index==0)
      return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT);
    return null;
	}

}