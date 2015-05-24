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

import de.netallied.functionblock.model.DeviceTypeModel;
import de.netallied.functionblock.model.FBTypeModel;
import de.netallied.functionblock.model.InstanceFunctionBlockModel;

public class DeviceTypeCacheEntry 
{
  private Map<IFile, DeviceTypeModel> modelCache = new HashMap<IFile, DeviceTypeModel>();
  long timestamp = -1;
    
  protected DeviceTypeModel getModel(String name)
  {
    for (Entry<IFile,DeviceTypeModel> entry : modelCache.entrySet())
    {
      if(entry.getValue().getName().equals(name))
        return entry.getValue();
    }
    return null;
  }
  
  public DeviceTypeModel getModel(IFile file)
  {
    return modelCache.get(file);
  }

  protected void add(String name, IFile resource, DeviceTypeModel model) throws Exception
  {
  	modelCache.put(resource, model);
    resource.refreshLocal(IFile.DEPTH_ONE,null);
    timestamp = resource.getLocalTimeStamp();
  }

	public Collection<DeviceTypeModel> getModels() 
	{
		return modelCache.values();
	}

	public IFile getIFile(DeviceTypeModel instanceFunctionBlockModel) 
	{
    for (Entry<IFile,DeviceTypeModel> entry : modelCache.entrySet())
    {
      if(entry.getValue().getName().equals(instanceFunctionBlockModel.getName()))
        return entry.getKey();
    }
		return null;
	}

  public void reload(IPath filepath) throws Exception
  {
    // TODO Auto-generated method stub
  }
}
