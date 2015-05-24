/*
 * Created on 04.01.2007
 *
 */
package de.netallied.functionblock.contribution.codeeditor;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import de.netallied.functionblock.Activator;
import de.netallied.functionblock.model.BasisFunctionBlockModel;

public class CodeEditorManager
{
  public static final String ID = "de.netallied.functionblock.core.codeEditors";

  // Don't dispose these images. This will be done by the plugin which has
  // provide the image.
  //
  private static Map<String,Image> images = new HashMap<String,Image>();
  
  public static Set<String> getAvailableLanguages()
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
        try
        {
          Object obj = element.createExecutableExtension("class");
          if(obj instanceof ICodeEditorFactory)
          {
            String lang   = element.getAttribute("language").toLowerCase();
            result.add(lang);
          }
        }
        catch (Exception e)
        {
          // ignore
        }
      }
    }
    return result;
  }


  public static Map<String, ICodeEditor> createCodeEditors(Composite parent, BasisFunctionBlockModel model)
  {
    Map<String, ICodeEditor> result = new HashMap<String, ICodeEditor>();
    
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
          if(obj instanceof ICodeEditorFactory)
          {
            ICodeEditor editor = ((ICodeEditorFactory)obj).createCodeEditor(parent, model);
            String      lang   = element.getAttribute("language").toLowerCase();
            result.put(lang,editor);
          }
        }
        catch (Exception e)
        {
          Activator.getDefault().showException(e);
        }
      }
    }
    return result;
  }


  public static Image getImage(String type)
  {
    Image img= images.get(type);
    if(img!=null)
      return img;
    
    // load all images the first time
    //
    
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
          if(obj instanceof ICodeEditorFactory)
          {
            Image  image = ((ICodeEditorFactory)obj).getImage();
            String lang  = element.getAttribute("language").toLowerCase();
            images.put(lang,image);
          }
        }
        catch (Exception e)
        {
          Activator.getDefault().showException(e);
        }
      }
    }
    return images.get(type);
  }
}

