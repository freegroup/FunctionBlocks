/*
 * Created on 04.08.2006
 *
 */
package de.netallied.functionblock.cache;

import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import de.netallied.functionblock.model.FBTypeModel;
import de.netallied.functionblock.model.InstanceFunctionBlockModel;
import de.netallied.functionblock.model.ResourceTypeModel;
import de.netallied.functionblock.util.FileUtil;

/**
 * Caching Id to file or model
 *
 */
public class FBTypeModelCache
{
  private static final Map<IProject,FBTypeCacheEntry> cache = new HashMap<IProject, FBTypeCacheEntry>();

  
  private FBTypeModelCache()
  {
  }
  
  public static Collection<FBTypeModel> getModels(IProject project)
  {
  	if(!cache.containsKey(project))
  		scan(project);
  	return cache.get(project).getModels();
  }

  public static FBTypeModel getModel( IFile file) throws Exception
  {
    if(!cache.containsKey(file.getProject()))
      scan( file.getProject());

    // Aus irgend einem Grund ist eventuell das Model nicht mehr im Cache.
    //
    FBTypeModel model = cache.get( file.getProject()).getModel(file);
    if(model==null)
    {
      InputStream stream = file.getContents();
      model = new FBTypeModel(file.getProject(),stream);
      stream.close();
      FBTypeCacheEntry entry = cache.get(file.getProject());
      entry.add(model.getFunctionBlockModel().getName(),file,model);
    }
    return cache.get( file.getProject()).getModel(file);
  }

  public static FBTypeModel getModel(IProject project, String name)
  {
  	if(!cache.containsKey(project))
  		scan(project);
  	return cache.get(project).getModel(name);
  }
  
  protected static void scan(IProject project)
  {
    try
    {
      cache.remove(project);
      FBTypeCacheEntry entry = new FBTypeCacheEntry();
      cache.put(project, entry);
      List<IFile> files =  FileUtil.getChildren(project);
      for (IFile resource : files)
      {
        if(resource.getFileExtension().equalsIgnoreCase("fbt"))
        {
          try
          {
             resource.refreshLocal(IResource.DEPTH_ONE,null);
             InputStream stream = resource.getContents();
            
             FBTypeModel model = new FBTypeModel(project, stream);
             String name = model.getFunctionBlockModel().getName();
             entry.add(name, resource, model);
             stream.close();
          }
          catch(Exception exc)
          {
            System.out.println("ERROR: unable to load ["+resource.getFullPath()+"] "+exc.getMessage());
          }
        }
      }
    }
    catch (CoreException e)
    {
      e.printStackTrace();
    }
  }

	public static IFile getIFile(IProject project, InstanceFunctionBlockModel instanceFunctionBlockModel) 
	{
  	if(!cache.containsKey(project))
  		scan(project);

  	return cache.get(project).getIFile(instanceFunctionBlockModel);
	}

  protected static void invalidate(IPath filepath) throws Exception
  {
    String projectName = filepath.segment(0);
    System.out.println("segment:"+projectName);
    for (IProject project : cache.keySet())
    {
      if(project.getName().equals(projectName))
      {
        FBTypeCacheEntry entry = cache.get(project);
        entry.reload(filepath);
      }
    } 
  }
}
