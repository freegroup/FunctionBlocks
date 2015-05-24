package de.netallied.functionblock.cache;

import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;

import de.netallied.functionblock.model.FBTypeModel;
import de.netallied.functionblock.model.InstanceFunctionBlockModel;

public class FBTypeCacheEntry 
{
  private Map<IFile, FBTypeModel> modelCache = new HashMap<IFile, FBTypeModel>();
  long timestamp = -1;
    
  protected FBTypeModel getModel(String name)
  {
    for (Entry<IFile,FBTypeModel> entry : modelCache.entrySet())
    {
      if(entry.getValue().getFunctionBlockModel().getName().equals(name))
        return entry.getValue();
    }
    return null;
  }
  
  public FBTypeModel getModel(IFile file)
  {
    return modelCache.get(file);
  }

  protected void add(String name, IFile resource, FBTypeModel model) throws Exception
  {
  	modelCache.put(resource, model);
    resource.refreshLocal(IFile.DEPTH_ONE,null);
    timestamp = resource.getLocalTimeStamp();
  }

	public Collection<FBTypeModel> getModels() 
	{
		return modelCache.values();
	}

	public IFile getIFile(InstanceFunctionBlockModel instanceFunctionBlockModel) 
	{
    for (Entry<IFile,FBTypeModel> entry : modelCache.entrySet())
    {
      if(entry.getValue().getFunctionBlockModel().getName().equals(instanceFunctionBlockModel.getType()))
        return entry.getKey();
    }
		return null;
	}

  public void reload(IPath filepath) throws Exception
  {
    // TODO Auto-generated method stub
  }
}
