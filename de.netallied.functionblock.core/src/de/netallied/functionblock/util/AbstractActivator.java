/*
 * Created on 12.01.2007
 *
 */
package de.netallied.functionblock.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

public abstract class AbstractActivator extends AbstractUIPlugin   
{
  // The shared instance
  private ImageRegistry registry   = new ImageRegistry(Display.getDefault());

  public abstract String getPluginID();
  
  public AbstractActivator()
  {
  }
  
  public ImageDescriptor getImageDescriptor(String key)
  {
    ImageDescriptor descriptor = registry.getDescriptor(key);
    if (descriptor == null)
    {
      descriptor = createImageDescriptor(key);
      registry.put(key, descriptor);
    }
    return descriptor;
  }

  
  public Image getImage(String key)
  {
    Image img = registry.get(key);
    if (img == null)
    {
      ImageDescriptor desc = createImageDescriptor(key);
      registry.put(key, desc);
      img = registry.get(key);
    }
    return img;
  }

  private ImageDescriptor createImageDescriptor(String filename) 
  {
    return imageDescriptorFromPlugin(getPluginID(),"icons/"+filename);
  }


  public final void showException(Throwable e)
  {
    MultiStatus errorStatus = getServiceInfo(e);

    // Write to the error log
    getLog().log(errorStatus);
    // Show an Error Dialog
    ErrorDialog.openError(null,"Error","Unexpected Error!.\nSelect Details>> for more information.\nSee the Error Log for more information.",errorStatus);
    // print the exception to the debugger console
    e.printStackTrace();
  }
  
  public final MultiStatus getServiceInfo(Throwable exception) 
  {
    Bundle bundle = getBundle();
    String symbolicName  = bundle.getSymbolicName();
    String bundleName    = ""+bundle.getHeaders().get("Bundle-Name");
    String bundleVendor  = ""+bundle.getHeaders().get("Bundle-Vendor");
    String bundleVersion = ""+bundle.getHeaders().get("Bundle-Version");
    MultiStatus status = new MultiStatus(symbolicName,Status.ERROR, StringUtil.toSaveString( exception.getMessage()), exception);
    
    // Put the information into their own status containers because this
    // forces new lines in the details section of the ErrorDialog
    //
    status.add(createStatus(Status.ERROR, "Plug-in Vendor: " + bundleVendor));
    status.add(createStatus(Status.ERROR, "Plug-in Name: " + bundleName));
    status.add(createStatus(Status.ERROR, "Plug-in ID: " + symbolicName));
    status.add(createStatus(Status.ERROR, "Version: " + bundleVersion));
    status.add(createStatus(Status.ERROR, "Exception:"+ExceptionUtils.getStackTrace(exception)));
    return status;
  }

  /**
   * Method createStatus is helper method that creates a Status object.
   */
  protected final Status createStatus(int severity, String msg) 
  {
    return new Status(severity, getBundle().getSymbolicName(), IStatus.OK, msg, null);
  }
  
}
