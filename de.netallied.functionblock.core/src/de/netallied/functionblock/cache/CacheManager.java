/*
 * Created on 01.02.2007
 *
 */
package de.netallied.functionblock.cache;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;

public class CacheManager
{
  public static void scan(IProject project)
  {
    FBTypeModelCache.scan(project);
    DeviceTypeModelCache.scan(project);
    ResourceTypeModelCache.scan(project);
  }
  
  public static void invalidate(IPath filepath) throws Exception
  {
    FBTypeModelCache.invalidate(filepath);
    DeviceTypeModelCache.invalidate(filepath);
    ResourceTypeModelCache.invalidate(filepath);
  }
}




