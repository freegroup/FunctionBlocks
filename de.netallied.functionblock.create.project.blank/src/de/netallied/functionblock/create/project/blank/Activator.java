package de.netallied.functionblock.create.project.blank;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import de.netallied.functionblock.util.AbstractActivator;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractActivator
{
	public static final String PLUGIN_ID = "de.netallied.functionblock.create.project.blank";
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
