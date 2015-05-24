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
import de.netallied.functionblock.model.DeviceTypeModel;
import de.netallied.functionblock.model.ResourceTypeModel;
import de.netallied.functionblock.util.FileUtil;

/**
 * Caching Id to file or model
 *
 */
public class ResourceTypeModelCache
{
  private static final Map<IProject,ResourceTypeCacheEntry> cache = new HashMap<IProject, ResourceTypeCacheEntry>();

  private ResourceTypeModelCache()
  {
  }
  
  public static Collection<ResourceTypeModel> getModels(IProject project)
  {
  	if(!cache.containsKey(project))
  		scan(project);

    return cache.get(project).getModels();
  }

  public static ResourceTypeModel getModel( IFile file) throws Exception
  {
    if(!cache.containsKey(file.getProject()))
      scan( file.getProject());

    // Aus irgend einem Grund ist eventuell das Model nicht mehr im Cache.
    //
    ResourceTypeModel model = cache.get( file.getProject()).getModel(file);
    if(model==null)
    {
      InputStream stream = file.getContents();
      model = new ResourceTypeModel(file.getProject(),stream);
      stream.close();
      ResourceTypeCacheEntry entry = cache.get(file.getProject());
      entry.add(model.getName(),file,model);
    }
    return cache.get( file.getProject()).getModel(file);
  }

  public static ResourceTypeModel getModel(IProject project, String name)
  {
  	if(!cache.containsKey(project))
  		scan(project);
  	return cache.get(project).getModel(name);
  }
  
  public static void scan(IProject project)
  {
    try
    {
      cache.remove(project);
      ResourceTypeCacheEntry entry = new ResourceTypeCacheEntry();
      cache.put(project, entry);
      List<IFile> files =  FileUtil.getChildren(project);
      for (IFile resource : files)
      {
        if(resource.getFileExtension().equalsIgnoreCase("res"))
        {
          try
          {
             resource.refreshLocal(IResource.DEPTH_ONE,null);
             InputStream stream = resource.getContents();
            
             ResourceTypeModel model = new ResourceTypeModel(project, stream);
             String name = model.getName();
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

	public static IFile getIFile(IProject project, ResourceTypeModel model) 
	{
  	if(!cache.containsKey(project))
  		scan(project);

  	return cache.get(project).getIFile(model);
	}

  public static void invalidate(IPath filepath) throws Exception
  {
    String projectName = filepath.segment(0);
    for (IProject project : cache.keySet())
    {
      if(project.getName().equals(projectName))
      {
        ResourceTypeCacheEntry entry = cache.get(project);
        entry.reload(filepath);
      }
    } 
  }
}
