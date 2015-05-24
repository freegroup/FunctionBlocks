/*
 * Created on 03.01.2005
 *
 */
package de.netallied.functionblock.create.project.digitallogic.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.jface.operation.ModalContext;

/**
 *
 */
public class FileUtil
{
  
  /**
   * Creates a folder resource given the folder handle.
   * 
   * @param folderHandle
   *          the folder handle to create a folder resource for
   * @param monitor
   *          the progress monitor to show visual progress with
   * @exception CoreException
   *              if the operation fails
   * @exception OperationCanceledException
   *              if the operation is canceled
   */
  public static IFolder createFolder(IFolder folderHandle) throws Exception
  {
    // Create the folder resource in the workspace
    // Update: Recursive to create any folders which do not exist already
    if (!folderHandle.exists())
    {
      IContainer parent = folderHandle.getParent();
      if (parent instanceof IFolder && (!((IFolder) parent).exists()))
        createFolder((IFolder) parent);
      folderHandle.create(false, true, null);
    }
    return folderHandle;
  }

  /**
   *  Answer the total number of file resources that exist at or below self
   *  in the resources hierarchy.
   *
   *  @return int
   *  @param checkResource org.eclipse.core.resources.IResource
   */
  public static int countChildrenOf(IResource checkResource) throws CoreException 
  {
      if (checkResource.getType() == IResource.FILE)
          return 1;

      int count = 0;
      if (checkResource.isAccessible()) 
      {
          IResource[] children = ((IContainer) checkResource).members();
          for (int i = 0; i < children.length; i++)
              count += countChildrenOf(children[i]);
      }

      return count;
  }


  /**
   *  Export the passed resource to the destination .zip
   *
   *  @param exportResource org.eclipse.core.resources.IResource
   *  @param depth - the number of resource levels to be included in
   *          the path including the resourse itself.
   */
  public static List<IFile> getChildren(IResource resource) throws CoreException
  {
      if (!resource.isAccessible())
          return Collections.EMPTY_LIST;

      if (resource.getType() == IResource.FILE) 
        return Collections.singletonList((IFile)resource);
      else 
      {
        List<IFile> result = new ArrayList<IFile>();
        IResource[] children = ((IContainer) resource).members();
        for (int i = 0; i < children.length; i++)
           result.addAll(getChildren(children[i]));
        return result;
      }
  }
}
