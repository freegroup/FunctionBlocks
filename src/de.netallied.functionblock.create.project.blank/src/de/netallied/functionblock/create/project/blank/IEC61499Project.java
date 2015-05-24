package de.netallied.functionblock.create.project.blank;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IPluginDescriptor;
import org.eclipse.core.runtime.IPluginRegistry;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.ITypeNameRequestor;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.launching.JavaRuntime;
import de.netallied.functionblock.builder.IEC61499Nature;
import de.netallied.functionblock.create.project.blank.util.Directory;
import de.netallied.functionblock.create.project.blank.util.FileUtil;

public class IEC61499Project
{

  private IProject project;
  private IJavaProject javaProject;

  private final String appName ;
  private final String projectName;
  
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
  
  public IEC61499Project( String name, IProgressMonitor monitor) throws CoreException 
  {
    monitor.beginTask("Creating project:" + name, 9);

    this.appName      = name;
    this.projectName  = "iec61499."+name;
    
    IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
    project = root.getProject(projectName);
    project.create(null);
    
    monitor.worked(1);//--------------------------------------------------------------------
    monitor.setTaskName("Open new project");
    project.open(null);
    javaProject = JavaCore.create(project);

    monitor.worked(1);//--------------------------------------------------------------------
    monitor.setTaskName("creating bin folder");
    IFolder binFolder = createBinFolder();

    monitor.worked(1);//--------------------------------------------------------------------
    monitor.setTaskName("setting java nature");
    setNature();
    
    monitor.worked(1);//--------------------------------------------------------------------
    monitor.setTaskName("setting class path");
    javaProject.setRawClasspath(new IClasspathEntry[0], null);

    monitor.worked(1);//--------------------------------------------------------------------
    monitor.setTaskName("creating output folder");
    createOutputFolder(binFolder);

    monitor.worked(1);//--------------------------------------------------------------------
    monitor.setTaskName("creating source folder");
    createSourceFolder();
    
    monitor.worked(1);//--------------------------------------------------------------------
    monitor.setTaskName("adding system libraries");
    addSystemLibraries();
    
    monitor.worked(1);//--------------------------------------------------------------------
    monitor.setTaskName("adding project libraries");
    addProjectLibraries("lib");

    monitor.worked(1);//--------------------------------------------------------------------
    monitor.setTaskName("adding common java setup files");
    addFiles();
    
    monitor.worked(1);//--------------------------------------------------------------------
  }

  public IProject getProject()
  {
    return project;
  }

  public IJavaProject getJavaProject()
  {
    return javaProject;
  }

  public void addProjectLibraries(String subPath) throws CoreException
  {
    try
    {
      String templateProjectPath="templates"+File.separator+subPath+File.separator;
      
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
	        int index = file.getParentFile().getAbsolutePath().indexOf(templateProjectPath)+templateProjectPath.length()-1;
	        String projectPath = file.getParentFile().getAbsolutePath().substring(index);
	        try
	        {
	          FileUtil.createFolder(project.getFolder(projectPath));
	        }
	        catch (Exception e1)
	        {
	        }
	        IFile newFile = getProject().getFile(pluginFilePath);
	        newFile.create(new FileInputStream(file), false, null);
	        IEC61499Project.addJar(javaProject, newFile.getFullPath());
        }
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  
  public void addFiles() throws CoreException
  {
    try
    {
      String templateProjectPath="templates"+File.separator+"project"+File.separator;
      
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
		        IFile newFile = getProject().getFile(pluginFilePath);
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

  private String replaceKeyWords(String template)
  {
    template = StringUtils.replace(template, "{date}", new Date().toString());
    template = StringUtils.replace(template, "{author}", System.getProperty("user.name"));
    template = StringUtils.replace(template, "{applicationName}", appName);
    
    return template;
  }
  
  public static void addJar(IJavaProject javaProject, IPath jar) throws MalformedURLException, IOException, JavaModelException
  {
    IClasspathEntry[] oldEntries = javaProject.getRawClasspath();
    IClasspathEntry[] newEntries = new IClasspathEntry[oldEntries.length + 1];
    System.arraycopy(oldEntries, 0, newEntries, 0, oldEntries.length);
    newEntries[oldEntries.length] = JavaCore.newLibraryEntry(jar, null, null);
    javaProject.setRawClasspath(newEntries, null);
  }

  public void dispose() throws CoreException
  {
    waitForIndexer();
    project.delete(true, true, null);
  }

  private IFolder createBinFolder() throws CoreException
  {
    IFolder binFolder = project.getFolder("classes");
    binFolder.create(false, true, null);
    return binFolder;
  }


  private void setNature() throws CoreException
  {
    IProjectDescription description = project.getDescription();
    description.setNatureIds(new String[] { IEC61499Nature.NATURE_ID,JavaCore.NATURE_ID });
    project.setDescription(description, null);
  }
  
  private void createOutputFolder(IFolder binFolder) throws JavaModelException
  {
    IPath outputLocation = binFolder.getFullPath();
    javaProject.setOutputLocation(outputLocation, null);
  }

  private IPackageFragmentRoot createSourceFolder() throws CoreException
  {
    IFolder folder = project.getFolder("java");
    folder.create(false, true, null);
    IPackageFragmentRoot root = javaProject.getPackageFragmentRoot(folder);

    IClasspathEntry[] oldEntries = javaProject.getRawClasspath();
    IClasspathEntry[] newEntries = new IClasspathEntry[oldEntries.length + 1];
    System.arraycopy(oldEntries, 0, newEntries, 0, oldEntries.length);
    newEntries[oldEntries.length] = JavaCore.newSourceEntry(root.getPath());
    javaProject.setRawClasspath(newEntries, null);
    return root;
  }

  private void addSystemLibraries() throws JavaModelException
  {
    IClasspathEntry[] oldEntries = javaProject.getRawClasspath();
    IClasspathEntry[] newEntries = new IClasspathEntry[oldEntries.length + 1];
    System.arraycopy(oldEntries, 0, newEntries, 0, oldEntries.length);
    newEntries[oldEntries.length] = JavaRuntime.getDefaultJREContainerEntry();
    javaProject.setRawClasspath(newEntries, null);
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

  private void waitForIndexer() throws JavaModelException
  {
    new SearchEngine().searchAllTypeNames(ResourcesPlugin.getWorkspace(), null, null, IJavaSearchConstants.EXACT_MATCH, IJavaSearchConstants.CASE_SENSITIVE,
        IJavaSearchConstants.CLASS, SearchEngine.createJavaSearchScope(new IJavaElement[0]), new ITypeNameRequestor()
        {
          public void acceptClass(char[] packageName, char[] simpleTypeName, char[][] enclosingTypeNames, String path)
          {
          }

          public void acceptInterface(char[] packageName, char[] simpleTypeName, char[][] enclosingTypeNames, String path)
          {
          }
        }, IJavaSearchConstants.WAIT_UNTIL_READY_TO_SEARCH, null);
  }
}