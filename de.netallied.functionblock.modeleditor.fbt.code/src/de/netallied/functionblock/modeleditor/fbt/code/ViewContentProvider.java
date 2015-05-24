/*
 * Created on 04.01.2007
 *
 */
package de.netallied.functionblock.modeleditor.fbt.code;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import de.netallied.functionblock.model.Algorithm;
import de.netallied.functionblock.model.InternalVariableModel;

public class ViewContentProvider implements IStructuredContentProvider 
{
  private final Editor contentProvider;

  /**
   * @param view
   */
  ViewContentProvider(Editor view)
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
    return contentProvider.getTypedFunctionBlockModel().getAlgorithms().toArray(new Algorithm[0]);
	}
}