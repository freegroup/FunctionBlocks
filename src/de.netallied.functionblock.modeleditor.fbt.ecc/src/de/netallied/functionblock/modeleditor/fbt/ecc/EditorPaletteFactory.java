package de.netallied.functionblock.modeleditor.fbt.ecc;

import org.eclipse.gef.palette.CombinedTemplateCreationEntry;
import org.eclipse.gef.palette.ConnectionCreationToolEntry;
import org.eclipse.gef.palette.MarqueeToolEntry;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PaletteSeparator;
import org.eclipse.gef.palette.PanningSelectionToolEntry;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.requests.SimpleFactory;
import de.netallied.functionblock.model.ECCStateActionModel;
import de.netallied.functionblock.model.ECCStateModel;
import de.netallied.functionblock.model.ECCTransitionModel;
/**
 * Utility class that can create a GEF Palette.
 * 
 * @see #createPalette()
 */
final class EditorPaletteFactory
{
  private static final String PALETTE_DOCK_LOCATION = "EditorPaletteFactory.Location";
  private static final String PALETTE_SIZE = "EditorPaletteFactory.Size";
  private static final String PALETTE_STATE = "EditorPaletteFactory.State";

  /** Create the "Shapes" drawer. */
  private static PaletteContainer createShapesDrawer()
  {
    PaletteDrawer componentsDrawer = new PaletteDrawer("Elements");
    CombinedTemplateCreationEntry component = new CombinedTemplateCreationEntry("State", "Create a state", 
        ECCStateModel.class, 
        new SimpleFactory(ECCStateModel.class), 
        Activator.getDefault().getImageDescriptor("toolbar_state16.png"), 
        Activator.getDefault().getImageDescriptor("toolbar_state32.png"));
    componentsDrawer.add(component);
    
    component = new CombinedTemplateCreationEntry("Action", "Create an action", 
        ECCStateActionModel.class, 
        new SimpleFactory(ECCStateActionModel.class), 
        Activator.getDefault().getImageDescriptor("toolbar_action16.png"), 
        Activator.getDefault().getImageDescriptor("toolbar_action32.png"));
    componentsDrawer.add(component);
    
    return componentsDrawer;
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
    palette.add(createShapesDrawer());
    return palette;
  }

  /** Create the "Tools" group. */
  private static PaletteContainer createToolsGroup(PaletteRoot palette)
  {
    PaletteGroup toolGroup = new PaletteGroup("Tools");
    // Add a selection tool to the group
    ToolEntry tool = new PanningSelectionToolEntry();
    toolGroup.add(tool);
    palette.setDefaultEntry(tool);
    // Add a marquee tool to the group
    toolGroup.add(new MarqueeToolEntry());
    // Add a (unnamed) separator to the group
    toolGroup.add(new PaletteSeparator());
    // Add (solid-line) connection tool
    tool = new ConnectionCreationToolEntry("Transistion", "Create a transition", new SimpleFactory(ECCTransitionModel.class), Activator.getDefault().getImageDescriptor("connection_s16.gif"), Activator.getDefault().getImageDescriptor("connection_s24.gif"));
    toolGroup.add(tool);
    return toolGroup;
  }

  /** Utility class. */
  private EditorPaletteFactory()
  {
    // Utility class
  }
}