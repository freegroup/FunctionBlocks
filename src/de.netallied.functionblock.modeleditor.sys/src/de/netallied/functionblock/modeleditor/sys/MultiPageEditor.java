package de.netallied.functionblock.modeleditor.sys;


import java.io.InputStream;
import java.util.Collection;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.views.contentoutline.ContentOutline;
import de.netallied.functionblock.contribution.syseditor.ISystemEditorPart;
import de.netallied.functionblock.contribution.syseditor.SystemEditorManager;
import de.netallied.functionblock.model.SystemModel;

/**
 * An example showing how to create a multi-page editorDiagram.
 * This example has 3 pages:
 * <ul>
 * <li>page 0 contains a nested editorXML editorDiagram.
 * <li>page 1 allows you to change the font used in page 2
 * <li>page 2 shows the words in page 0 in sorted order
 * </ul>
 */
public class MultiPageEditor extends FormEditor implements IResourceChangeListener, ISelectionListener
{
  public static final String ID = "de.netallied.functionblock.modeleditor.sys.editor.MultiPageEditor";
  
  private SystemModel  model;
  Collection<ISystemEditorPart> editors;
  
  
  /**
	 * Creates a multi-page editorDiagram example.
	 */
	public MultiPageEditor() 
  {
		super();
		ResourcesPlugin.getWorkspace().addResourceChangeListener(this);
	}

  
	/**
	 * Creates the pages of the multi-page editorDiagram.
	 */
	protected void addPages() 
  {
    editors = SystemEditorManager.createEditors();

    IEditorInput input = getEditorInput();
    
    if (input instanceof IFileEditorInput)
    {
      IFileEditorInput fileInput = (IFileEditorInput) input;
      IFile modelFile = fileInput.getFile();
      for (ISystemEditorPart part : editors)
      {
        try
        {
          int index = addPage(part, new CommonEditorInput(modelFile, model));
          setPageText(index, part.getTitle());
          setPageImage(index,part.getTitleImage());
        }
        catch (PartInitException e)
        {
          e.printStackTrace();
        }
      }
    }
	}
  
	/**
	 * The <algorithm>MultiPageEditorPart</algorithm> implementation of this 
	 * <algorithm>IWorkbenchPart</algorithm> method disposes all nested editors.
	 * Subclasses may extend.
	 */
	public void dispose() 
  {
    getSite().getWorkbenchWindow().getSelectionService().removeSelectionListener(this);    
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
		super.dispose();
	}
  
	public Object getAdapter(Class adapter)
  {
    return super.getAdapter(adapter);
  }

  /**
	 * Saves the multi-page editorDiagram's document.
	 */
	public void doSave(IProgressMonitor monitor) 
  {
    try
    {
      IEditorInput input = getEditorInput();
      
      if (input instanceof IFileEditorInput)
      {
        IFileEditorInput fileInput = (IFileEditorInput) input;
        IFile modelFile = fileInput.getFile();
        model.doSave(modelFile,monitor);
      }
      for (ISystemEditorPart editor : editors)
      {
        editor.markSaveLocation();
      }
    }
    catch (Exception e)
    {
      Activator.getDefault().showException(e);
    }
	}
  
	/**
	 * Saves the multi-page editorDiagram's document as another file.
	 * Also updates the editorXML for page 0's tab, and updates this multi-page editorDiagram's input
	 * to correspond to the nested editorDiagram's.
	 */
	public void doSaveAs() 
  {
	}

  /**
	 * The <algorithm>MultiPageEditorExample</algorithm> implementation of this method
	 * checks that the input is an instance of <algorithm>IFileEditorInput</algorithm>.
	 */
	public void init(IEditorSite site, IEditorInput editorInput)throws PartInitException 
  {
		if (!(editorInput instanceof IFileEditorInput))
			throw new PartInitException("Invalid Input: Must be IFileEditorInput");
    
    site.getWorkbenchWindow().getSelectionService().addSelectionListener(this);    

    if (editorInput instanceof IFileEditorInput)
    {
      try
      {
        IFileEditorInput fileInput = (IFileEditorInput) editorInput;
        IFile file = fileInput.getFile();
        file.refreshLocal(IResource.DEPTH_ONE,null);
        InputStream is = fileInput.getFile().getContents();
      	IProject project = fileInput.getFile().getProject();
        
        model = new SystemModel(project, is);
        is.close();
        setPartName(fileInput.getName());
      }
      catch (Exception e)
      {
        Activator.getDefault().showException(e);
      }
    }
		super.init(site, editorInput);
	}
  
	/* (non-Javadoc)
	 * Method declared on IEditorPart.
	 */
	public boolean isSaveAsAllowed() 
  {
		return false;
	}
  
	/**
	 * Calculates the contents of page 2 when the it is activated.
	 */
  @Override
	protected void pageChange(int newPageIndex) 
  {
		super.pageChange(newPageIndex);
    try
    {
      ContentOutline outlineView = (ContentOutline)PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView("org.eclipse.ui.views.ContentOutline");
      outlineView.partActivated(getActiveEditor());
    }
    catch (Exception e)
    {
    }    
	}
  /*
   * @see ITextEditor#close
   */
  public void close(final boolean save) 
  {
    super.close(save);
  }
  
	/**
	 * Closes all project files on project close.
	 */
	public void resourceChanged(final IResourceChangeEvent event)
  {
  System.out.println(event);
  /*
		if(event.getType() == IResourceChangeEvent.PRE_CLOSE){
			Display.getDefault().asyncExec(new Runnable(){
				public void run(){
					IWorkbenchPage[] pages = getSite().getWorkbenchWindow().getPages();
					for (int i = 0; i<pages.length; i++)
          {
            if(editorTypedDiagram!=null)
            {
  						if(((FileEditorInput)editorTypedDiagram.getEditorInput()).getFile().getProject().equals(event.getResource()))
              {
  							IEditorPart editorPart = pages[i].findEditor(editorTypedDiagram.getEditorInput());
  							pages[i].closeEditor(editorPart,true);
  						}
            }
            else
            {
              if(((FileEditorInput)editorCompositDiagram.getEditorInput()).getFile().getProject().equals(event.getResource()))
              {
                IEditorPart editorPart = pages[i].findEditor(editorCompositDiagram.getEditorInput());
                pages[i].closeEditor(editorPart,true);
              }
              
            }
					}
				}            
			});
		}
    */
	}

  /**
   * In eine MultipageEditor hat man das Problem, dass die Selection NICHT
   * an die einzelnen editoren weitergereicht wird. dieses muss man vdummerweise
   * von Hand machen. Tut man die snicht, dann wird z.B. das "Delete" Command nicht
   * enabled
   */
  public void selectionChanged(IWorkbenchPart part, ISelection selection)
  {
    if (this.equals(getSite().getPage().getActiveEditor())) 
    {
      for (ISystemEditorPart editor : editors)
      {
        editor.selectionChanged(getActiveEditor(),selection);
      }
     }
  }

}
