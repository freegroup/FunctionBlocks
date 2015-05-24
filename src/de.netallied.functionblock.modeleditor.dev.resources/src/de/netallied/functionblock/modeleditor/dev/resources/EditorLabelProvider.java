/*
 * Created on 04.01.2007
 *
 */
package de.netallied.functionblock.modeleditor.dev.resources;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import de.netallied.functionblock.model.InternalVariableModel;
import de.netallied.functionblock.model.ResourceModel;

class EditorLabelProvider extends LabelProvider implements ITableLabelProvider 
{

  private final Editor labelProvider;
  /**
   * @param view
   */
  EditorLabelProvider(Editor view)
  {
    labelProvider = view;
  }
  
  public String getColumnText(Object obj, int index) 
  {
    switch(index)
    {
    case 0:
      return ((ResourceModel)obj).getName();
    case 1:
      return ((ResourceModel)obj).getType();
    default:
      return null;
    }
	}
  
	public Image getColumnImage(Object obj, int index) 
  {
    if(index==0)
      return Activator.getDefault().getImage("figure_resource.png");
    return null;
	}

}