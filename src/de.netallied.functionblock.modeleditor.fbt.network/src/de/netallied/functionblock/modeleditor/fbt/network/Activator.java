package de.netallied.functionblock.modeleditor.fbt.network;

import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import de.netallied.functionblock.util.AbstractActivator;
import de.netallied.functionblock.util.StringUtil;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractActivator
{
	public static final String PLUGIN_ID = "de.netallied.functionblock.modeleditor.fbt.network";

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
   * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
   */
  public void stop(BundleContext context) throws Exception 
  {
    plugin = null;
    super.stop(context);
  }
}
