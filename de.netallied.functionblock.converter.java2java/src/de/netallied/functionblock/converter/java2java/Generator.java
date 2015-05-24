/*
 * Created on 08.01.2007
 *
 */
package de.netallied.functionblock.converter.java2java;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IPluginDescriptor;
import org.eclipse.core.runtime.IPluginRegistry;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import de.netallied.functionblock.contribution.generator.IGenerator;
import de.netallied.functionblock.converter.java2java.util.Directory;
import de.netallied.functionblock.converter.java2java.util.FileUtil;
import de.netallied.functionblock.converter.java2java.util.JavaUtil;
import de.netallied.functionblock.model.CompositeFunctionBlockModel;
import de.netallied.functionblock.model.FBTypeModel;
import de.netallied.functionblock.model.InstanceFunctionBlockModel;
import de.netallied.functionblock.model.BasisFunctionBlockModel;

public class Generator implements IGenerator
{
  private static final String PATH    = File.separator+"test";
  private static final String TEMPLATE_TYPED     = "templates"+File.separator+"model"+File.separator+"BasicFunctionBlock.vm";
  private static final String TEMPLATE_COMPOSITE = "templates"+File.separator+"model"+File.separator+"CompositeFunctionBlock.vm";
  
  private static final Set<String> fileTypesToParse;
  
  static
  {
    Set<String> tmp = new HashSet<String>();
    tmp.add("java");
    tmp.add("xml");
    tmp.add("properties");
    tmp.add("jad");
    tmp.add("jsp");
    
    fileTypesToParse = Collections.unmodifiableSet(tmp);
  }
  

  public void convert(IProject project, FBTypeModel model, IProgressMonitor monitor) throws Exception
  {
    createFunctionBlock(project , model,monitor);
    addFiles(project);
  }


  private void createFunctionBlock(IProject project, FBTypeModel model,IProgressMonitor monitor) throws Exception
  {
    if(model.getFunctionBlockModel() instanceof BasisFunctionBlockModel)
    {
      createTypedFunctionBlock(project, model, monitor);
    }
    else
    {
      createCompositeFunctionBlock(project, model, monitor);
    }
  }

  private void createCompositeFunctionBlock(IProject project, FBTypeModel model,IProgressMonitor monitor) throws Exception
  {
    CompositeFunctionBlockModel composite =(CompositeFunctionBlockModel)model.getFunctionBlockModel();
    for (InstanceFunctionBlockModel ifb : composite.getNetwork().getElements())
    {
      createFunctionBlock(project, ifb.getTypeModel(),monitor);
    } 
    String content = generateCompositeClassContent(project, model,monitor);
    writeClassContent(project, content, model.getFunctionBlockModel().getName(),monitor);
  }
  
  private void createTypedFunctionBlock(IProject project, FBTypeModel model,IProgressMonitor monitor) throws Exception
  {
    String content = generateTypedClassContent(project, model,monitor);
    writeClassContent(project, content, model.getFunctionBlockModel().getName(),monitor);
  }
  
  /**
   * 
   * @param alias
   * @param monitor
   * @return
   * @throws Exception
   */
  private String generateTypedClassContent(IProject project, FBTypeModel model, IProgressMonitor monitor) throws Exception
  {
      URL pluginURL = Activator.getDefault().getBundle().getEntry("/");
      pluginURL = Platform.asLocalURL(pluginURL);
      File file = new File(pluginURL.getPath()+TEMPLATE_TYPED);

      String template = FileUtils.readFileToString(file,"ISO-8859-1");
      
      /* first, we init the runtime engine. Defaults are fine. */ 
      Velocity.init(); 
      /* lets make a Context and put data into it */ 
      VelocityContext context = new VelocityContext(); 
      context.put("model"  , model); 
      context.put("date"   , new Date()); 
      context.put("StringUtils",new StringUtils());
      context.put("JavaUtils",new JavaUtil());
      /* lets render a template */ 
      
      StringWriter w = new StringWriter(); 
      Velocity.evaluate( context, w, "mystring", template ); 

      // neue .java Datei im package jacob.common erzeugen
      //
      return w.toString();
  }
  
  /**
   * 
   * @param alias
   * @param monitor
   * @return
   * @throws Exception
   */
  private String generateCompositeClassContent(IProject project, FBTypeModel model, IProgressMonitor monitor) throws Exception
  {
      URL pluginURL = Activator.getDefault().getBundle().getEntry("/");
      pluginURL = Platform.asLocalURL(pluginURL);
      File file = new File(pluginURL.getPath()+TEMPLATE_COMPOSITE);

      String template = FileUtils.readFileToString(file,"ISO-8859-1");
      
      /* first, we init the runtime engine. Defaults are fine. */ 
      Velocity.init(); 
      /* lets make a Context and put data into it */ 
      VelocityContext context = new VelocityContext(); 
      context.put("model"  , model); 
      context.put("date"   , new Date()); 
      context.put("StringUtils",new StringUtils());
      /* lets render a template */ 
      
      StringWriter w = new StringWriter(); 
      Velocity.evaluate( context, w, "mystring", template ); 

      // neue .java Datei im package jacob.common erzeugen
      //
      return w.toString();
  }

  /**
   * 
   * @param content
   * @param className
   * @param monitor
   * @throws Exception
   */
  private void writeClassContent(IProject project, String content, String fileName, IProgressMonitor monitor) throws Exception
  {
    IJavaProject myJavaProject = JavaCore.create(project);
    IPackageFragmentRoot[] roots = myJavaProject.getAllPackageFragmentRoots();
    IPath path = roots[0].getPath();

    IFolder srcFolder = project.getFolder(path.lastSegment());
    FileUtil.createFolder(project.getFolder(srcFolder.getName() + PATH));
    
    IFile newLogo = srcFolder.getFile(PATH+File.separator+fileName+".java");
    if(newLogo.exists())
    {
     newLogo.refreshLocal(IResource.DEPTH_INFINITE,null);
     newLogo.setContents(new StringBufferInputStream(content),IFile.FORCE|IFile.KEEP_HISTORY,monitor);
    }
    else
    {
      newLogo.create(new StringBufferInputStream(content), false,monitor);
    }
  }


  public void addFiles(IProject project) throws CoreException
  {
    try
    {
      String templateProjectPath="templates"+File.separator+"runtime"+File.separator;
      
      IPluginRegistry registry = Platform.getPluginRegistry();
      IPluginDescriptor descriptor = registry.getPluginDescriptor(Activator.PLUGIN_ID);
      URL pluginURL = descriptor.getInstallURL();
      pluginURL = Platform.asLocalURL(pluginURL);
      Iterator iter = Directory.getAll(findFileInPlugin(Activator.PLUGIN_ID,templateProjectPath).toFile(),true).iterator();
      while(iter.hasNext())
      {
        File file = (File)iter.next();
        if(file.getAbsolutePath().indexOf("CVS")==-1)
        {
          String pluginFilePath   = file.getAbsolutePath().substring(pluginURL.getPath().length()-1+templateProjectPath.length());
          
          if(file.getParentFile().getAbsolutePath().indexOf(templateProjectPath)!=-1)
          {
          int index = file.getParentFile().getAbsolutePath().indexOf(templateProjectPath)+templateProjectPath.length()-1;
            String projectPath = file.getParentFile().getAbsolutePath().substring(index);
            try
            {
              FileUtil.createFolder(project.getFolder(projectPath));
            }
            catch (Exception e1)
            {
            }
          }
          try
          {
            IFile newFile = project.getFile(pluginFilePath);
            if(fileTypesToParse.contains(FilenameUtils.extension(file.getName())))
            {
              InputStream in = new FileInputStream(file);
              String template = IOUtils.toString(in);
              in.close();
              template = replaceKeyWords(template);
              newFile.create(new StringBufferInputStream(template), false, null);
            }
            else
            {
                newFile.create(new FileInputStream(file), false, null);
            }
          }
          catch(Exception e)
          {
            
          }
        }
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
  
  private Path findFileInPlugin(String plugin, String file) throws MalformedURLException, IOException
  {
    IPluginRegistry registry = Platform.getPluginRegistry();
    IPluginDescriptor descriptor = registry.getPluginDescriptor(plugin);
    URL pluginURL = descriptor.getInstallURL();
    URL jarURL = new URL(pluginURL, file);
    URL localJarURL = Platform.asLocalURL(jarURL);
    return new Path(localJarURL.getPath());
  }


  private String replaceKeyWords(String template)
  {
    template = StringUtils.replace(template, "{date}", new Date().toString());
    template = StringUtils.replace(template, "{author}", System.getProperty("user.name"));
    
    return template;
  }
}
