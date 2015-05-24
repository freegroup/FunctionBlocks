/*******************************************************************************
 * Copyright (c) 2004, 2005 Elias Volanakis and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Elias Volanakis - initial API and implementation
 *******************************************************************************/
package de.netallied.functionblock.modeleditor.sys.network;

import java.beans.PropertyChangeEvent;
import java.util.EventObject;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.GEFPlugin;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.dnd.TemplateTransferDragSourceListener;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.gef.ui.palette.PaletteViewerProvider;
import org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette;
import org.eclipse.gef.ui.parts.GraphicalViewerKeyHandler;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheetPage;
import de.netallied.functionblock.contribution.fbteditor.IFbtEditorInput;
import de.netallied.functionblock.contribution.syseditor.ISystemEditorInput;
import de.netallied.functionblock.contribution.syseditor.ISystemEditorPart;
import de.netallied.functionblock.model.SystemModel;
import de.netallied.functionblock.modeleditor.sys.network.editpart.NetworkElementEditPartFactory;

/**
 * A graphical editor with flyout palette that can edit .shapes files.
 * The binding between the .shapes file extension and this editor is done in plugin.xml
 * @author Elias Volanakis
 */
public class Editor 	extends GraphicalEditorWithFlyoutPalette implements ISystemEditorPart 
{
  private SystemModel model;
  private PaletteRoot palette;
  private PropertySheetPage propPage;

  /** Create a new Editor instance. This is called by the Workspace. */
  public Editor() 
  {
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette#getPaletteRoot()
   */
  protected PaletteRoot getPaletteRoot()
  {
    if (palette == null)
    {
      ISystemEditorInput input = (ISystemEditorInput)getEditorInput();
      palette = EditorPaletteFactory.createPalette();
    }
    
    return palette;
  }


  /**
   * Configure the graphical viewer before it receives contents.
   * <p>This is the place to choose an appropriate RootEditPart and EditPartFactory
   * for your editor. The RootEditPart determines the behavior of the editor's "work-area".
   * For example, GEF includes zoomable and scrollable root edit parts. The EditPartFactory
   * maps model elements to edit parts (controllers).</p>
   * @see org.eclipse.gef.ui.parts.GraphicalEditor#configureGraphicalViewer()
   */
  protected void configureGraphicalViewer() 
  {
  	super.configureGraphicalViewer();
  	
  	GraphicalViewer viewer = getGraphicalViewer();
  	viewer.setEditPartFactory(new NetworkElementEditPartFactory());
  	viewer.setRootEditPart(new ScalableFreeformRootEditPart());
  	viewer.setKeyHandler(new GraphicalViewerKeyHandler(viewer));
  
  	// configure the context menu provider
  	ContextMenuProvider cmProvider =new EditorContextMenuProvider(viewer, getActionRegistry());
  	viewer.setContextMenu(cmProvider);
  	getSite().registerContextMenu(cmProvider, viewer);
  }
  
  
  /* (non-Javadoc)
   * @see org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette#createPaletteViewerProvider()
   */
  protected PaletteViewerProvider createPaletteViewerProvider() {
  	return new PaletteViewerProvider(getEditDomain()) {
  		protected void configurePaletteViewer(PaletteViewer viewer) {
  			super.configurePaletteViewer(viewer);
  			// create a drag source listener for this palette viewer
  			// together with an appropriate transfer drop target listener, this will enable
  			// model element creation by dragging a CombinatedTemplateCreationEntries 
  			// from the palette into the editor
  			// @see Editor#createTransferDropTargetListener()
  			viewer.addDragSourceListener(new TemplateTransferDragSourceListener(viewer));
  		}
  	};
  }

  @Override
  public void init(IEditorSite site, IEditorInput input) throws PartInitException
  {
    setInput(input);
    setSite(site);
    setEditDomain(new DefaultEditDomain(this));
    setPartName("Network");
    setTitleImage(Activator.getDefault().getImage("editor.png"));
    super.init(site, input);
  }

  
  @Override
  public boolean isDirty() 
  {
    return getCommandStack().isDirty();
  }

  
  protected void initializeGraphicalViewer()
  {
    getGraphicalViewer().setContents(getContents());
  }

  protected SystemModel getContents()
  {
    if (model == null)
      model = createContents();
    return model;
  }
  
  
  protected SystemModel createContents()
  {
    IEditorInput input = getEditorInput();
    
    if (input instanceof ISystemEditorInput)
    {
      ISystemEditorInput fileInput = (ISystemEditorInput) input;
      return ((SystemModel)fileInput.getModel());
    }
    return null;
  }
  public void createPartControl(Composite parent)
  {
    super.createPartControl(parent);
    getEditorSite().getActionBars().setGlobalActionHandler(ActionFactory.UNDO.getId(), getActionRegistry().getAction(GEFActionConstants.UNDO));
    getEditorSite().getActionBars().setGlobalActionHandler(ActionFactory.REDO.getId(), getActionRegistry().getAction(GEFActionConstants.REDO));
    getEditorSite().getActionBars().setGlobalActionHandler(ActionFactory.DELETE.getId(), getActionRegistry().getAction(GEFActionConstants.DELETE));
  }



  public Object getAdapter(Class aClass)
  {
    if (aClass == IContentOutlinePage.class)
      return getOverviewOutlinePage();
      if (aClass == CommandStack.class)
        return getCommandStack();
      else if (aClass == IPropertySheetPage.class)
        return getPropertySheetPage();
      return super.getAdapter(aClass);
  }

  /** the overview outline page */
  private OverviewOutlinePage overviewOutlinePage;

  /**
   * Returns the overview for the outline view.
   * 
   * @return the overview
   */
  protected OverviewOutlinePage getOverviewOutlinePage()
  {
      if (null == overviewOutlinePage && null != getGraphicalViewer())
      {
          RootEditPart rootEditPart = getGraphicalViewer().getRootEditPart();
          if (rootEditPart instanceof ScalableFreeformRootEditPart)
          {
              overviewOutlinePage = new OverviewOutlinePage((ScalableFreeformRootEditPart) rootEditPart);
          }
      }

      return overviewOutlinePage;
  }

  public PropertySheetPage getPropertySheetPage()
  {
    if (propPage == null)
    {
      propPage = new PropertySheetPage();
      propPage.setRootEntry(GEFPlugin.createUndoablePropertySheetEntry(getCommandStack()));
    }
    return propPage;
  }



  public void doSave(IProgressMonitor monitor)
  {
    getCommandStack().markSaveLocation();
    firePropertyChange(IEditorPart.PROP_DIRTY);
  }
  
  public void doSaveAs()
  {
  }

  public boolean isSaveAsAllowed()
  {
    return true;
  }

  public void commandStackChanged(EventObject event) 
  {
    super.commandStackChanged(event);
    if (isDirty())
    {
        firePropertyChange(IEditorPart.PROP_DIRTY);
    }
  }
  
  public void propertyChange(PropertyChangeEvent ev)
  {
    firePropertyChange(IEditorPart.PROP_DIRTY);
  }

  public CommandStack getCommandStack()
  {
    return super.getCommandStack();
  }

  public void selectionChanged(IWorkbenchPart part, ISelection selection) 
  {
    super.selectionChanged(part, selection);
    if (this.equals(part))// Propagated from MyMultiPageEditor. 
    { 
        updateActions(getSelectionActions());
    }
  }

  public void markSaveLocation()
  {
    getCommandStack().markSaveLocation();
  }

}