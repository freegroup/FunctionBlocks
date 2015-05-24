/*
 * Created on 04.01.2007
 *
 */
package de.netallied.functionblock.modeleditor.dev.resources;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import de.netallied.functionblock.model.InternalVariableModel;
import de.netallied.functionblock.model.ResourceModel;

public class EditorContentProvider implements IStructuredContentProvider 
{
  private final Editor contentProvider;

  /**
   * @param view
   */
  EditorContentProvider(Editor view)
  {
    contentProvider = view;
  }
  
  public void inputChanged(Viewer v, Object oldInput, Object newInput) 
  {
	}
  
	public void dispose() 
  {
	}
  
	public Object[] getElements(Object parent) 
  {
    return contentProvider.getDeviceTypeModel().getElements().toArray(new ResourceModel[0]);
	}
}