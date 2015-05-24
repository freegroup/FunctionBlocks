package de.netallied.functionblock.perspective;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.IPerspectiveRegistry;
import org.eclipse.ui.IWorkbenchPreferenceConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 *
 */
public class Programming implements IPerspectiveFactory 
{
  public static final String ID="de.netallied.functionblock.perspective.Programming";
  
  /* 
   * @see org.eclipse.ui.IPerspectiveFactory#createInitialLayout(org.eclipse.ui.IPageLayout)
   */
  public void createInitialLayout(IPageLayout layout) 
  {
    // Editors are placed for free.
    String editorArea = layout.getEditorArea();

    IFolderLayout left = layout.createFolder("left", IPageLayout.LEFT, (float) 0.23, editorArea);
    left.addView("de.netallied.functionblock.workspace.views.ProjectView");
    
    IFolderLayout bottom = layout.createFolder("bottom", IPageLayout.BOTTOM, (float) 0.66, editorArea);
    bottom.addView("org.eclipse.ui.views.PropertySheet");
  }

  public static void open() 
  {
    // Get "Open Behavior" preference.
    AbstractUIPlugin plugin = (AbstractUIPlugin)Platform.getPlugin(PlatformUI.PLUGIN_ID);
    IPreferenceStore store = plugin.getPreferenceStore();
    String pref = store.getString(IWorkbenchPreferenceConstants.OPEN_NEW_PERSPECTIVE);
                    
    // Implement open behavior.
    try 
    {
        if (pref.equals(IWorkbenchPreferenceConstants.OPEN_PERSPECTIVE_WINDOW))
        {
          PlatformUI.getWorkbench().openWorkbenchWindow(ID, ResourcesPlugin.getWorkspace());
        }
        else if (pref.equals(IWorkbenchPreferenceConstants.OPEN_PERSPECTIVE_PAGE))
        {
          PlatformUI.getWorkbench().getActiveWorkbenchWindow().openPage(ID, ResourcesPlugin.getWorkspace());
        }
        else if (pref.equals(IWorkbenchPreferenceConstants.OPEN_PERSPECTIVE_REPLACE)) 
        {
          IPerspectiveRegistry reg = PlatformUI.getWorkbench().getPerspectiveRegistry();
          PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().setPerspective(reg.findPerspectiveWithId(ID));
        }
    } 
    catch (Exception e) 
    {
            e.printStackTrace();
    }
  }
}
