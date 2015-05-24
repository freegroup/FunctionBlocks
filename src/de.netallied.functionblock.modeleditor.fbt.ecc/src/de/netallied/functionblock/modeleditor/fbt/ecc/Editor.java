package de.netallied.functionblock.modeleditor.fbt.ecc;

import java.util.EventObject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.AutoexposeHelper;
import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.GEFPlugin;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.dnd.TemplateTransferDragSourceListener;
import org.eclipse.gef.dnd.TemplateTransferDropTargetListener;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.editparts.ViewportAutoexposeHelper;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.requests.CreationFactory;
import org.eclipse.gef.requests.SimpleFactory;
import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.gef.ui.palette.PaletteViewerProvider;
import org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette;
import org.eclipse.gef.ui.parts.GraphicalViewerKeyHandler;
import org.eclipse.jface.util.TransferDropTargetListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheetPage;
import de.netallied.functionblock.contribution.fbteditor.IFbtEditorInput;
import de.netallied.functionblock.contribution.fbteditor.IFunctionBlockEditorPart;
import de.netallied.functionblock.modeleditor.fbt.ecc.editparts.ShapesEditPartFactory;
import de.netallied.functionblock.model.ECCDiagramModel;
import de.netallied.functionblock.model.BasisFunctionBlockModel;

/**
 */
public class Editor extends GraphicalEditorWithFlyoutPalette implements IFunctionBlockEditorPart
{
  public static final String  ID  = "de.netallied.functionblock.ecc.ECCEditor";
  
  private PropertySheetPage   propPage;
  private OverviewOutlinePage overviewOutlinePage;

  /** This is the root of the editor's model. */
  private ECCDiagramModel diagram;
  /** Palette component, holding the tools and shapes. */
  private static PaletteRoot PALETTE_MODEL;

  /** Create a new Editor instance. This is called by the Workspace. */
  public Editor()
  {
  }

  /**
   * Configure the graphical viewer before it receives contents.
   * <p>
   * This is the place to choose an appropriate RootEditPart and EditPartFactory
   * for your editor. The RootEditPart determines the behavior of the editor's
   * "work-area". For example, GEF includes zoomable and scrollable root edit
   * parts. The EditPartFactory maps model elements to edit parts (controllers).
   * </p>
   * 
   * @see org.eclipse.gef.ui.parts.GraphicalEditor#configureGraphicalViewer()
   */
  protected void configureGraphicalViewer()
  {
    super.configureGraphicalViewer();
    GraphicalViewer viewer = getGraphicalViewer();
    viewer.setEditPartFactory(new ShapesEditPartFactory());
    ScalableFreeformRootEditPart rootEditPart = new ScalableFreeformRootEditPart()
    {
      public Object getAdapter(Class key)
      {
        if (key == AutoexposeHelper.class)
          return new ViewportAutoexposeHelper(this);
        return super.getAdapter(key);
      }
    };
    viewer.setRootEditPart(rootEditPart);
    viewer.setKeyHandler(new GraphicalViewerKeyHandler(viewer));
    // configure the context menu provider
    ContextMenuProvider cmProvider = new EditorContextMenuProvider(viewer, getActionRegistry());
    viewer.setContextMenu(cmProvider);
    getSite().registerContextMenu(cmProvider, viewer);
  }
  
  
  @Override
  public void init(IEditorSite site, IEditorInput input) throws PartInitException
  {
    setInput(input);
    setSite(site);
    setEditDomain(new DefaultEditDomain(this));
    setPartName("ECC");
    setTitleImage(Activator.getDefault().getImage("editor.png"));
    super.init(site, input);
  }

  
  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.ui.parts.GraphicalEditor#commandStackChanged(java.util.EventObject)
   */
  @Override
  public void commandStackChanged(EventObject event)
  {
    firePropertyChange(IEditorPart.PROP_DIRTY);
    super.commandStackChanged(event);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette#createPaletteViewerProvider()
   */
  @Override
  protected PaletteViewerProvider createPaletteViewerProvider()
  {
    return new PaletteViewerProvider(getEditDomain())
    {
      protected void configurePaletteViewer(PaletteViewer viewer)
      {
        super.configurePaletteViewer(viewer);
        // create a drag source listener for this palette viewer
        // together with an appropriate transfer drop target listener, this will
        // enable
        // model element creation by dragging a
        // CombinatedTemplateCreationEntries
        // from the palette into the editor
        // @see Editor#createTransferDropTargetListener()
        viewer.addDragSourceListener(new TemplateTransferDragSourceListener(viewer));
      }
    };
  }

  /**
   * Create a transfer drop target listener. When using a
   * CombinedTemplateCreationEntry tool in the palette, this will enable model
   * element creation by dragging from the palette.
   * 
   * @see #createPaletteViewerProvider()
   */
  private TransferDropTargetListener createTransferDropTargetListener()
  {
    return new TemplateTransferDropTargetListener(getGraphicalViewer())
    {
      @Override
      protected CreationFactory getFactory(Object template)
      {
        return new SimpleFactory((Class) template);
      }
    };
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.ISaveablePart#doSave(org.eclipse.core.runtime.IProgressMonitor)
   */
  public void doSave(IProgressMonitor monitor)
  {
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.ISaveablePart#doSaveAs()
   */
  @Override
  public void doSaveAs()
  {
  }

  
  @Override
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

  ECCDiagramModel getModel()
  {
    return diagram;
  }

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
  
  
  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette#getPaletteRoot()
   */
  protected PaletteRoot getPaletteRoot()
  {
    if (PALETTE_MODEL == null)
      PALETTE_MODEL = EditorPaletteFactory.createPalette();
    return PALETTE_MODEL;
  }

  /**
   * Set up the editor's inital content (after creation).
   * 
   * @see org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette#initializeGraphicalViewer()
   */
  @Override
  protected void initializeGraphicalViewer()
  {
    super.initializeGraphicalViewer();
    GraphicalViewer viewer = getGraphicalViewer();
    viewer.setContents(getModel()); // set the contents of this editor
    // listen for dropped parts
    viewer.addDropTargetListener(createTransferDropTargetListener());
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.ISaveablePart#isSaveAsAllowed()
   */
  @Override
  public boolean isSaveAsAllowed()
  {
    return false;
  }

  @Override
  public boolean isDirty() 
  {
    return getCommandStack().isDirty();
  }
  
  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.part.EditorPart#setInput(org.eclipse.ui.IEditorInput)
   */
  @Override
  protected void setInput(IEditorInput input)
  {
    super.setInput(input);
    IFbtEditorInput eccInput = (IFbtEditorInput)input;
    diagram = ((BasisFunctionBlockModel)eccInput.getModel().getFunctionBlockModel()).getECCDiagramModel();
  }
  
  @Override
  public void selectionChanged(IWorkbenchPart part, ISelection selection) 
  {
    super.selectionChanged(part, selection);
    if (this.equals(part))// Propagated from MyMultiPageEditor. 
    { 
        updateActions(getSelectionActions());
    }
  }
  
  @Override
  public CommandStack getCommandStack()
  {
    return super.getCommandStack();
  }

  public void markSaveLocation()
  {
    getCommandStack().markSaveLocation();
  }
}