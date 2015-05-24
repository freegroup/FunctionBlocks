package de.netallied.functionblock;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import de.netallied.functionblock.cache.CacheManager;
import de.netallied.functionblock.cache.FBTypeModelCache;
import de.netallied.functionblock.resourcelistener.ResourceChangeListenerReporter;
import de.netallied.functionblock.util.AbstractActivator;
import de.netallied.functionblock.util.StringUtil;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractActivator   implements ISelectionListener
{
	// The plug-in ID
	public static final String PLUGIN_ID = "de.netallied.functionblock.core";
  IProject selectedProject = null;

  private static AbstractActivator plugin;

  /**
   * The constructor.
   */
  public Activator() 
  {
    plugin = this;
  }

  public String getPluginID()
  {
    return PLUGIN_ID;    
  }
    
  /**
   * Returns the shared instance
   *
   * @return the shared instance
   */
  public static AbstractActivator getDefault() 
  {
    return plugin;
  }
  
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception 
  {
		super.start(context);
    
    // MUST be called in an UI Thread. In the case of a non UI-Thread startup call
    // of the plugin "getActiveWorkbenchWindow" returns "null"
    //
    PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() 
    {
      public void run() 
      {
        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().addSelectionListener(Activator.this);
      }
    });
    
    startResourceListener();
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception 
  {
    plugin = null;
		super.stop(context);
    PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() 
    {
      public void run() 
      {
        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().removeSelectionListener(Activator.this);
      }
    });
	}



  public void selectionChanged(IWorkbenchPart part, ISelection selection)
  {
    try
    {
      if (selection instanceof IStructuredSelection)
      {
        Object first = ((IStructuredSelection) selection).getFirstElement();
        if(first instanceof IProjectNature)
          first = ((IProjectNature)first).getProject();
        
        if (first instanceof IResource)
        {
          IResource file = (IResource) first;
          IProject newProject= file.getProject();
          if(newProject!=null && !newProject.equals(selectedProject))
          {
            CacheManager.scan(newProject);
          }
          selectedProject = newProject;
        }
      }
    }
    catch (Throwable e)
    {
      showException(e);
    }
  }
  
  public IProject getSelectedProject()
  {
    return  selectedProject;
  }
  
  public final void startResourceListener()
  {
    IWorkspace workspace = ResourcesPlugin.getWorkspace();
    workspace.addResourceChangeListener(new ResourceChangeListenerReporter());
  }
  
  public final void stopResourceListener()
  {
    IWorkspace workspace = ResourcesPlugin.getWorkspace();
  }
}
