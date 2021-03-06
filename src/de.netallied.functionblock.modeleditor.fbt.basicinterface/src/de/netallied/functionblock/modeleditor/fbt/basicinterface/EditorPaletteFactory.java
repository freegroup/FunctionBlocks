package de.netallied.functionblock.modeleditor.fbt.basicinterface;

import org.eclipse.gef.palette.ConnectionCreationToolEntry;
import org.eclipse.gef.palette.CreationToolEntry;
import org.eclipse.gef.palette.MarqueeToolEntry;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.SelectionToolEntry;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.requests.SimpleFactory;
import org.eclipse.gef.ui.palette.FlyoutPaletteComposite.FlyoutPreferences;
import org.eclipse.jface.preference.IPreferenceStore;
import de.netallied.functionblock.model.WithTransitionInModel;
import de.netallied.functionblock.model.WithTransitionOutModel;

/**
 * Utility class that can create a GEF Palette.
 * 
 */
final class EditorPaletteFactory
{
  private static final int DEFAULT_PALETTE_SIZE = 125;
  private static final String PALETTE_DOCK_LOCATION = "FBTEditorPaletteFactory.Location";
  private static final String PALETTE_SIZE = "FBTEditorPaletteFactory.Size";
  private static final String PALETTE_STATE = "FBTEditorPaletteFactory.State";

  
  /** Utility class. */
  private EditorPaletteFactory()
  {
    // Utility class
  }


  /**
   * Creates the PaletteRoot and adds all palette elements. Use this factory
   * method to create a new palette for your graphical editor.
   * 
   * @return a new PaletteRoot
   */
  static PaletteRoot createPalette()
  {
    PaletteRoot palette = new PaletteRoot();

    palette.add(createToolsGroup(palette));
    palette.add(createShapesDrawer(palette));
    
    return palette;
  }

  /** Create the "Tools" group. */
  private static PaletteContainer createToolsGroup( PaletteRoot palette)
  {
    PaletteGroup toolGroup = new PaletteGroup("Tools");

    // Add a selection tool to the group
    ToolEntry tool = new SelectionToolEntry();
    toolGroup.add(tool);
    palette.setDefaultEntry(tool);

    // Add a marquee tool to the group
    toolGroup.add(new MarqueeToolEntry());

    tool = new ConnectionCreationToolEntry("IN With", "Create a WITH in", new SimpleFactory(WithTransitionInModel.class), Activator.getDefault().getImageDescriptor("connection_s16.gif"), Activator.getDefault().getImageDescriptor("connection_s24.gif"));
    toolGroup.add(tool);
    
    tool = new ConnectionCreationToolEntry("Out WITH", "Create a WITH event", new SimpleFactory(WithTransitionOutModel.class), Activator.getDefault().getImageDescriptor("connection_s16.gif"), Activator.getDefault().getImageDescriptor("connection_s24.gif"));
    toolGroup.add(tool);
    
    return toolGroup;
  }
  

  /**
   * 
   * @return
   */
  private static PaletteContainer createShapesDrawer( PaletteRoot palette)
  {
    PaletteDrawer componentsDrawer = new PaletteDrawer("Ports");
    CreationToolEntry component = new CreationToolEntry("Port", "Create an new port", 
        new PortFactory(), 
        Activator.getDefault().getImageDescriptor("toolbar_port16.gif"), 
        Activator.getDefault().getImageDescriptor("toolbar_port32.gif"));
    componentsDrawer.add(component);
    
    return componentsDrawer;
  }

  /**
   * Returns the preference store for the ShapesPlugin.
   * 
   * @see org.eclipse.ui.plugin.AbstractUIPlugin#getPreferenceStore()
   */
  private static IPreferenceStore getPreferenceStore()
  {
    return Activator.getDefault().getPreferenceStore();
  }

  /**
   * Return a FlyoutPreferences instance used to save/load the preferences of a
   * flyout palette.
   */
  static FlyoutPreferences createPalettePreferences()
  {
    // set default flyout palette preference values, in case the preference
    // store
    // does not hold stored values for the given preferences
    getPreferenceStore().setDefault(PALETTE_DOCK_LOCATION, -1);
    getPreferenceStore().setDefault(PALETTE_STATE, -1);
    getPreferenceStore().setDefault(PALETTE_SIZE, DEFAULT_PALETTE_SIZE);

    return new FlyoutPreferences()
    {
      public int getDockLocation()
      {
        return getPreferenceStore().getInt(PALETTE_DOCK_LOCATION);
      }

      public int getPaletteState()
      {
        return getPreferenceStore().getInt(PALETTE_STATE);
      }

      public int getPaletteWidth()
      {
        return getPreferenceStore().getInt(PALETTE_SIZE);
      }

      public void setDockLocation(int location)
      {
        getPreferenceStore().setValue(PALETTE_DOCK_LOCATION, location);
      }

      public void setPaletteState(int state)
      {
        getPreferenceStore().setValue(PALETTE_STATE, state);
      }

      public void setPaletteWidth(int width)
      {
        getPreferenceStore().setValue(PALETTE_SIZE, width);
      }
    };
  }

}