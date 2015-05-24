/*
 * Created on 11.01.2007
 *
 */
package de.netallied.functionblock.contribution.fbteditor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.commons.lang.NumberUtils;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.widgets.Composite;
import de.netallied.functionblock.Activator;
import de.netallied.functionblock.contribution.codeeditor.ICodeEditor;
import de.netallied.functionblock.contribution.codeeditor.ICodeEditorFactory;

public class FunctionBlockEditorManager
{
  public static final String ID = "de.netallied.functionblock.core.fbtEditorParts";
  
  public static final String TYPE_COMPOSITE       = "composite";
  public static final String TYPE_BASIC           = "basic";
  public static final String TYPE_SYSTEMINTERFACE = "systeminterface";
  
  public static Collection<IFunctionBlockEditorPart> createEditors(String type)
  {
    SortedMap<Integer,IFunctionBlockEditorPart> editors = new TreeMap<Integer, IFunctionBlockEditorPart>();
    
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
        String clazz = element.getAttribute("class");
        try
        {
          Object obj = element.createExecutableExtension("class");
          if(obj instanceof IFunctionBlockEditorPart)
          {
            String elementType = element.getAttribute("type");
            Integer sortIndex   = new Integer( element.getAttribute("sortIndex"));
            if(elementType.equals(type))
              editors.put(sortIndex, (IFunctionBlockEditorPart)obj);
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
