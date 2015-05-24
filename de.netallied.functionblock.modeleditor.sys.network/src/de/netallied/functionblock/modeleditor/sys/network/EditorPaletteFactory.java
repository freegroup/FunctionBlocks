/*******************************************************************************
 * Copyright (c) 2004, 2005 Elias Volanakis and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Elias Volanakis - initial API and implementation
 *******************************************************************************/
package de.netallied.functionblock.modeleditor.sys.network;

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
import de.netallied.functionblock.model.DeviceModel;
import de.netallied.functionblock.model.LinkModel;
import de.netallied.functionblock.model.SegmentModel;
import de.netallied.functionblock.model.TransitionModel;

/**
 * Utility class that can create a GEF Palette.
 * @see #createPalette() 
 * @author Elias Volanakis
 */
final class EditorPaletteFactory 
{

/** Preference ID used to persist the palette location. */
private static final String PALETTE_DOCK_LOCATION = "EditorPaletteFactory.Location";
/** Preference ID used to persist the palette size. */
private static final String PALETTE_SIZE = "EditorPaletteFactory.Size";
/** Preference ID used to persist the flyout palette's state. */
private static final String PALETTE_STATE = "EditorPaletteFactory.State";

/** Create the "Shapes" drawer. */
private static PaletteContainer createShapesDrawer() {
	PaletteDrawer componentsDrawer = new PaletteDrawer("Elements");

	CombinedTemplateCreationEntry component = new CombinedTemplateCreationEntry(
			"Device", 
			"Create an device", 
			DeviceModel.class,
			new SimpleFactory(DeviceModel.class), 
			Activator.getDefault().getImageDescriptor("device16.png"), 
      Activator.getDefault().getImageDescriptor("device24.png"));
	componentsDrawer.add(component);

	component = new CombinedTemplateCreationEntry(
			"Network Segment",
			"Create a network segment", 
			SegmentModel.class,
			new SimpleFactory(SegmentModel.class), 
      Activator.getDefault().getImageDescriptor("segment16.png"), 
      Activator.getDefault().getImageDescriptor("segment24.png"));
	componentsDrawer.add(component);

	return componentsDrawer;
}
	
/**
 * Creates the PaletteRoot and adds all palette elements.
 * Use this factory method to create a new palette for your graphical editor.
 * @return a new PaletteRoot
 */
static PaletteRoot createPalette() {
	PaletteRoot palette = new PaletteRoot();
	palette.add(createToolsGroup(palette));
	palette.add(createShapesDrawer());
	return palette;
}

/** Create the "Tools" group. */
private static PaletteContainer createToolsGroup(PaletteRoot palette) {
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
  tool = new ConnectionCreationToolEntry(
      "Link", 
      "Create a Link", 
      new SimpleFactory(LinkModel.class),
      Activator.getDefault().getImageDescriptor("link16.png"), 
      Activator.getDefault().getImageDescriptor("link24.png"));
  toolGroup.add(tool);

	return toolGroup;
}

/** Utility class. */
private EditorPaletteFactory() {
	// Utility class
}

}