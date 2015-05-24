package de.netallied.functionblock.create.file.composite;

import org.osgi.framework.BundleContext;
import de.netallied.functionblock.util.AbstractActivator;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractActivator
{

	// The plug-in ID
	public static final String PLUGIN_ID = "de.netallied.functionblock.create.file.composite";


  // The shared instance
  private static Activator plugin;
  
  /**
   * The constructor
   */
  public Activator() 
  {
    plugin = this;
  }

  public String getPluginID()
  {
    return PLUGIN_ID;    
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

  /**
   * Returns the shared instance
   *
   * @return the shared instance
   */
  public static Activator getDefault() 
  {
    return plugin;
  }
}
