/*
 * Created on 04.01.2007
 *
 */
package de.netallied.functionblock.modeleditor.fbt.code;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import de.netallied.functionblock.contribution.codeeditor.CodeEditorManager;
import de.netallied.functionblock.model.Algorithm;

class ViewLabelProvider extends LabelProvider implements ITableLabelProvider 
{
  /**
   * @param view
   */
  ViewLabelProvider()
  {
  }
  
  public String getColumnText(Object obj, int index) 
  {
    switch(index)
    {
    case 0:
      return ((Algorithm)obj).getName();
    case 1:
      return ((Algorithm)obj).getType();
    default:
      return null;
    }
	}
  
	public Image getColumnImage(Object obj, int index) 
  {
    if(index==0)
    {
      return ((Algorithm)obj).getImage();
    }
    return null;
	}

}