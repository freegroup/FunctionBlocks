/*
 * Created on Oct 18, 2004
 *
 */
package de.netallied.functionblock.modeleditor.fbt;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPersistableElement;
import de.netallied.functionblock.contribution.fbteditor.IFbtEditorInput;
import de.netallied.functionblock.model.FBTypeModel;

public final class CommonEditorInput implements IFbtEditorInput
{
  FBTypeModel  model ;
  IFile          file;
  
  public CommonEditorInput(IFile file, FBTypeModel model)
  {
    this.file = file;
    this.model=model;
  }

  public IStorage getStorage() throws CoreException
  {
    // TODO Auto-generated method stub
    return null;
  }

  public IFile getFile()
  {
    return file;
  }

  public String getName()
  {
    return null;
  }

  public boolean exists()
  {
    return true;
  }

  public ImageDescriptor getImageDescriptor()
  {
    return null;
  }

  public IPersistableElement getPersistable()
  {
    return null;
  }

  public String getToolTipText()
  {
    return null;
  }

  public Object getAdapter(Class adapter)
  {
    return null;
  }

  public String getFactoryId()
  {
    return null;
  }

  public void saveState(IMemento memento)
  {
//    memento.putString(MEMENTO_KEY, getId());
  }


  public final FBTypeModel getModel()
  {
    return model;
  }
  
  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  public boolean equals(Object obj)
  {
    if (obj instanceof CommonEditorInput)
    {
      CommonEditorInput other = (CommonEditorInput) obj;
      return this.model.equals(other.model);
    }
    
    return false;
  }
}