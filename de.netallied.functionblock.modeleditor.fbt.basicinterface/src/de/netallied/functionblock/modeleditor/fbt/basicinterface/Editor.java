package de.netallied.functionblock.modeleditor.fbt.basicinterface;

import java.util.EventObject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.AutoexposeHelper;
import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.GEFPlugin;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.editparts.ViewportAutoexposeHelper;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette;
import org.eclipse.gef.ui.parts.GraphicalEditorWithPalette;
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
import de.netallied.functionblock.contribution.fbteditor.IFunctionBlockEditorPart;
import de.netallied.functionblock.modeleditor.fbt.basicinterface.actions.FbtContextMenuProvider;
import de.netallied.functionblock.model.FBTypeModel;

/**
 * A graphical editor with flyout palette that can edit .shapes files. The
 * binding between the .shapes file extension and this editor is done in
 * plugin.xml
 * 
 */
public class Editor extends  GraphicalEditorWithFlyoutPalette implements IFunctionBlockEditorPart
{
	private FBTypeModel	model;
	
	
	private PropertySheetPage		propPage;
  private PaletteRoot          palette;
	private OverviewOutlinePage	overviewOutlinePage;
	
	
	/** Create a new ECCEditor instance. This is called by the Workspace. */
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
      palette = EditorPaletteFactory.createPalette();
    
    return palette;
  }
	
  
  @Override
  public void init(IEditorSite site, IEditorInput input) throws PartInitException
  {
    setInput(input);
    setSite(site);
    setEditDomain(new DefaultEditDomain(this));
    setPartName("Interface");
    setTitleImage(Activator.getDefault().getImage("editor.png"));
    super.init(site, input);
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
 		GraphicalViewer viewer = getGraphicalViewer();
		
		viewer.setEditPartFactory(new EditPartFactoryImpl());
		viewer.setKeyHandler(new GraphicalViewerKeyHandler(viewer));
		
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
		
		// configure the context menu provider
		ContextMenuProvider cmProvider = new FbtContextMenuProvider(viewer, getActionRegistry());
		viewer.setContextMenu(cmProvider);
	}
	
	
	public boolean isDirty()
	{
		return getCommandStack().isDirty();
	}
	
	
	protected void initializeGraphicalViewer()
	{
		getGraphicalViewer().setContents(getContents());
	}
	
	
	protected FBTypeModel getContents()
	{
		if (model == null)
			model = createContents();
		return model;
	}
	
	
	protected FBTypeModel createContents()
	{
		IEditorInput input = getEditorInput();
		
		if (input instanceof IFbtEditorInput)
		{
      IFbtEditorInput fileInput = (IFbtEditorInput) input;
      return fileInput.getModel();
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
	}
	
	public void doSaveAs()
	{
	}
	
	public boolean isSaveAsAllowed()
	{
		return true;
	}


  public CommandStack getCommandStack()
  {
    return super.getCommandStack();
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
