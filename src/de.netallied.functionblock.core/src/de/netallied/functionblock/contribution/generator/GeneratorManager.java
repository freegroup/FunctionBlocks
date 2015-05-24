/*
 * Created on 08.01.2007
 *
 */
package de.netallied.functionblock.contribution.generator;

import java.util.Set;
import java.util.TreeSet;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import de.netallied.functionblock.Activator;
import de.netallied.functionblock.contribution.codeeditor.ICodeEditor;
import de.netallied.functionblock.contribution.codeeditor.ICodeEditorFactory;

public class GeneratorManager
{
  public static final String ID = "de.netallied.functionblock.core.generators";

  public static Set<IGenerator> getGenerators()
  {
    Set<IGenerator> result = new TreeSet<IGenerator>();
    
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
          if(obj instanceof IGeneratorFactory)
          {
            IGenerator generator = ((IGeneratorFactory)obj).createGenerator();
            result.add(generator);
          }
        }
        catch (Exception e)
        {
          e.printStackTrace();
          Activator.getDefault().showException(e);
        }
      }
    }
    return result;
  }


  public static Set<String> getAllSources()
  {
    Set<String> result = new TreeSet<String>();
    
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
        result.add(element.getAttribute("sourceLanguage"));
      }
    }
    return result;
  }
  
  public static Set<String> getAllTargets()
  {
    Set<String> result = new TreeSet<String>();
    
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
        result.add(element.getAttribute("targetLanguage"));
      }
    }
    return result;
  }
}
