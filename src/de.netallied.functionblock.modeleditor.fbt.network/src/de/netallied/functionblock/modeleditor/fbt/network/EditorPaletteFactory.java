/*******************************************************************************
 * Copyright (c) 2004 Elias Volanakis.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Common Public License v1.0
 �* which accompanies this distribution, and is available at
 �* http://www.eclipse.org/legal/cpl-v10.html
 �*
 �* Contributors:
 �*����Elias Volanakis - initial API and implementation
 �*******************************************************************************/
package de.netallied.functionblock.modeleditor.fbt.network;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.gef.palette.ConnectionCreationToolEntry;
import org.eclipse.gef.palette.CreationToolEntry;
import org.eclipse.gef.palette.MarqueeToolEntry;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PaletteSeparator;
import org.eclipse.gef.palette.SelectionToolEntry;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.requests.SimpleFactory;
import org.eclipse.gef.ui.palette.FlyoutPaletteComposite.FlyoutPreferences;
import org.eclipse.jface.preference.IPreferenceStore;

import de.netallied.functionblock.cache.FBTypeModelCache;
import de.netallied.functionblock.model.FBTypeModel;
import de.netallied.functionblock.model.TransitionModel;

/**
 * Utility class that can create a GEF Palette.
 * 
 */
final class EditorPaletteFactory
{
  private static final int DEFAULT_PALETTE_SIZE = 125;
  private static final String PALETTE_DOCK_LOCATION = "EditorPaletteFactory.Location";
  private static final String PALETTE_SIZE = "EditorPaletteFactory.Size";
  private static final String PALETTE_STATE = "EditorPaletteFactory.State";

  
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
  static PaletteRoot createPalette(IProject project)
  {
    PaletteRoot palette = new PaletteRoot();
 
    createToolsGroup(project, palette);
    createShapesDrawer(project, palette);
    return palette;
  }

  /** Create the "Tools" group. */
  private static void createToolsGroup(IProject project, PaletteRoot palette)
  {
    PaletteGroup toolGroup = new PaletteGroup("Tools");

    // Add a selection tool to the group
    ToolEntry tool = new SelectionToolEntry();
    toolGroup.add(tool);
    palette.setDefaultEntry(tool);

    // Add a marquee tool to the group
    toolGroup.add(new MarqueeToolEntry());

    // Add a (unnamed) separator to the group
    toolGroup.add(new PaletteSeparator());

    // Add (solid-line) connection tool
    tool = new ConnectionCreationToolEntry(
        "Transition", 
        "Create a transition", 
        new SimpleFactory(TransitionModel.class),
        Activator.getDefault().getImageDescriptor("connection_s16.gif"), 
        Activator.getDefault().getImageDescriptor("connection_s24.gif"));
    toolGroup.add(tool);
    palette.add(toolGroup);
  }
  

  /**
   * 
   * @return
   */
  private static void createShapesDrawer(IProject project, PaletteRoot palette)
  {
    Map<String,PaletteDrawer> groups = new HashMap<String,PaletteDrawer>();
    for (FBTypeModel model : FBTypeModelCache.getModels(project)) 
    {
      PaletteDrawer group =groups.get(model.getFunctionBlockModel().getClassification());
      if(group==null)
      {
        group = new PaletteDrawer(model.getFunctionBlockModel().getClassification());
        group.setInitialState(PaletteDrawer.INITIAL_STATE_CLOSED);
        groups.put(model.getFunctionBlockModel().getClassification(), group);
        palette.add(group);
      }
      group.add( new CreationToolEntry(
          model.getFunctionBlockModel().getName(), 
          model.getFunctionBlockModel().getComment()!=null?model.getFunctionBlockModel().getComment():"Insert a "+model.getFunctionBlockModel().getName(), 
          new FBFactory(model), 
          Activator.getDefault().getImageDescriptor("toolbar_functionblock16.png"), 
          Activator.getDefault().getImageDescriptor("toolbar_functionblock32.png")));
    }
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