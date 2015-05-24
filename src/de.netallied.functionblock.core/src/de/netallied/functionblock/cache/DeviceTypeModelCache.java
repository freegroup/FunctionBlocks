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
import de.netallied.functionblock.util.FileUtil;

/**
 * Caching Id to file or model
 *
 */
public class DeviceTypeModelCache
{
  private static final Map<IProject,DeviceTypeCacheEntry> cache = new HashMap<IProject, DeviceTypeCacheEntry>();

  public DeviceTypeModelCache()
  {
  }
  
  public static Collection<DeviceTypeModel> getModels(IProject project)
  {
  	if(!cache.containsKey(project))
  		scan(project);
  	return cache.get(project).getModels();
  }

  public static DeviceTypeModel getModel( IFile file) throws Exception
  {
    if(!cache.containsKey(file.getProject()))
      scan( file.getProject());
    // Aus irgend einem Grund ist eventuell das Model nicht mehr im Cache.
    //
    DeviceTypeModel model = cache.get( file.getProject()).getModel(file);
    if(model==null)
    {
      InputStream stream = file.getContents();
      model = new DeviceTypeModel(file.getProject(),stream);
      stream.close();
      DeviceTypeCacheEntry entry = cache.get(file.getProject());
      entry.add(model.getName(),file,model);
    }
    return model;
  }

  public static DeviceTypeModel getModel(IProject project, String name)
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
      DeviceTypeCacheEntry entry = new DeviceTypeCacheEntry();
      cache.put(project, entry);
      List<IFile> files =  FileUtil.getChildren(project);
      for (IFile resource : files)
      {
        if(resource.getFileExtension().equalsIgnoreCase("dev"))
        {
          try
          {
             resource.refreshLocal(IResource.DEPTH_ONE,null);
             InputStream stream = resource.getContents();
            
             DeviceTypeModel model = new DeviceTypeModel(project, stream);
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

	public static IFile getIFile(IProject project, DeviceTypeModel instanceFunctionBlockModel) 
	{
  	if(!cache.containsKey(project))
  		scan(project);

  	return cache.get(project).getIFile(instanceFunctionBlockModel);
	}

  public static void invalidate(IPath filepath) throws Exception
  {
    String projectName = filepath.segment(0);
    System.out.println("segment:"+projectName);
    for (IProject project : cache.keySet())
    {
      if(project.getName().equals(projectName))
      {
        DeviceTypeCacheEntry entry = cache.get(project);
        entry.reload(filepath);
      }
    } 
  }
}
