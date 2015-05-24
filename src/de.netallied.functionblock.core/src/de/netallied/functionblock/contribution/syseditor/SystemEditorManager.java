/*
 * Created on 11.01.2007
 *
 */
package de.netallied.functionblock.contribution.syseditor;

import java.util.Collection;
import java.util.SortedMap;
import java.util.TreeMap;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import de.netallied.functionblock.Activator;

public class SystemEditorManager
{
  public static final String ID = "de.netallied.functionblock.core.sysEditorParts";
  
  public static Collection<ISystemEditorPart> createEditors()
  {
    SortedMap<Integer,ISystemEditorPart> editors = new TreeMap<Integer, ISystemEditorPart>();
    
    IExtensionRegistry registry = Platform.getExtensionRegistry();
    IExtensionPoint point =registry.getExtensionPoint(ID);
    IExtension[] extensions = point.getExtensions();
    for (int i = 0; i < extensions.length; i++)
    {
      IExtension extension = extensions[i];
      IConfigurationElement[] elements = extension.getConfigurationElements();
      for (int j = 0; j < elements.length; j++)
      {
        IConfigurationElement element = elements[j];
        try
        {
          Object obj = element.createExecutableExtension("class");
          if(obj instanceof ISystemEditorPart)
          {
            Integer sortIndex   = new Integer( element.getAttribute("sortIndex"));
            editors.put(sortIndex, (ISystemEditorPart)obj);
          }
        }
        catch (Exception e)
        {
          Activator.getDefault().showException(e);
        }
      }
    }
    return editors.values();
  }
}
