package de.netallied.functionblock.modeleditor.fbt;

import org.osgi.framework.BundleContext;
import de.netallied.functionblock.util.AbstractActivator;

/**
 * The main plugin class to be used in the desktop.
 */
public class Activator extends AbstractActivator
{
  public final static String PLUGIN_ID = "de.netallied.functionblock.modeleditor.fbt";
  
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
