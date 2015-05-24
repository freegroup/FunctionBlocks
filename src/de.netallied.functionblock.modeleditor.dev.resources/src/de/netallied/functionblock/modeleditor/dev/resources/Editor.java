package de.netallied.functionblock.modeleditor.dev.resources;


import java.util.Collection;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.EditorPart;
import de.netallied.functionblock.cache.DeviceTypeModelCache;
import de.netallied.functionblock.cache.ResourceTypeModelCache;
import de.netallied.functionblock.contribution.deveditor.IDeviceEditorInput;
import de.netallied.functionblock.contribution.deveditor.IDeviceEditorPart;
import de.netallied.functionblock.model.DeviceTypeModel;
import de.netallied.functionblock.model.ResourceModel;
import de.netallied.functionblock.model.ResourceTypeModel;


/**
 * This sample class demonstrates how to plug-in a new
 * workbench view. The view shows data obtained from the
 * model. The sample creates a dummy model on the fly,
 * but a real implementation would connect to the model
 * available either in this or another plug-in (e.g. the workspace).
 * The view is connected to the model using a content provider.
 * <p>
 * The view uses a label provider to define how model
 * objects should be presented in the view. Each
 * view can present the same model objects using
 * different labels and icons, if needed. Alternatively,
 * a single label provider can be shared between views
 * in order to ensure that objects of the same type are
 * presented in the same way everywhere.
 * <p>
 */

public class Editor extends EditorPart implements IDeviceEditorPart
{
  private   boolean dirty;

  private TableViewer resourceList;

  private Text  nameText;
  private Label nameLabel;
  
  private Combo typeCombo;
  private Label typeLabel;

  private Label commentLabel;

  private Text commentText;
  

  /**
   * The constructor.
   */
  public Editor() 
  {
  }

  @Override
  public void init(IEditorSite site, IEditorInput input) throws PartInitException
  {
    setInput(input);
    setSite(site);
    setPartName(Messages.Editor_Resource);
    setTitleImage(Activator.getDefault().getImage("editor.png"));
  }

  @Override
  public void doSave(IProgressMonitor monitor)
  {
    dirty = false;
  }

  @Override
  public void doSaveAs()
  {
    dirty = false;
  }

  @Override
  public boolean isDirty()
  {
    return dirty;
  }
  
  private void setDirty()
  {
    dirty = true;
    firePropertyChange(IEditorPart.PROP_DIRTY);
  }
  

  @Override
  public boolean isSaveAsAllowed()
  {
    return false;
  }


	/**
	 * This is a callback that will allow us
	 * to create the resourceList and initialize it.
	 */
	public void createPartControl(Composite parent) 
  {
    SashForm sashForm = new SashForm(parent, SWT.HORIZONTAL);

    Composite leftSide = new Composite(sashForm, SWT.NORMAL);
    leftSide.setLayout(new GridLayout(1, false));
    
    Composite rightSide = new Composite(sashForm, SWT.NORMAL);
    rightSide.setLayout(new GridLayout(2, false));

    createResourceComposite(leftSide);
    
    createNameComposite(rightSide);
    createTypeComposite(rightSide);
    createCommentComposite(rightSide);

    if(getDeviceTypeModel().getElements().size()>0)
    {
      ResourceModel var = getDeviceTypeModel().getElements().get(0);
      resourceList.setSelection(new StructuredSelection(var),true);
    }
    
    sashForm.setWeights(new int[]{3, 7});
  }

  /**
   * 
   * @param parent
   */
  private void createResourceComposite(Composite parent)
  {
    resourceList = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
    GridData gridData = new GridData();
    gridData.verticalAlignment = GridData.FILL;
    gridData.grabExcessVerticalSpace = true;
    gridData.horizontalAlignment = GridData.FILL;
    gridData.grabExcessHorizontalSpace = true;
    resourceList.getControl().setLayoutData(gridData);
    
    TableColumn column = new TableColumn(resourceList.getTable(), SWT.LEFT);
    column.setText(Messages.Editor_Name);
    column.setWidth(150);

    column = new TableColumn(resourceList.getTable(), SWT.LEFT);
    column.setText(Messages.Editor_Type);
    column.setWidth(100);
    resourceList.getTable().setHeaderVisible(true);

    resourceList.setContentProvider(new EditorContentProvider(this));
    resourceList.setLabelProvider(new EditorLabelProvider(this));
    resourceList.setInput(getEditorSite());
    
    resourceList.addSelectionChangedListener(new ISelectionChangedListener()
    {
      public void selectionChanged(SelectionChangedEvent event)
      {
        if(event.getSelection() instanceof StructuredSelection)
        {
          StructuredSelection selection = (StructuredSelection)event.getSelection();
          select((ResourceModel)selection.getFirstElement());
        }
      }
    });
    
    resourceList.getTable().addMouseListener(new MouseAdapter()
    {
      public void mouseDoubleClick(MouseEvent event)
      {
        final IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();

        final IWorkbenchPage page = window.getActivePage();
        try {
          IProject project = getDeviceTypeModel().getProject();
          IFile file =ResourceTypeModelCache.getIFile(project,getSelection().getResourceTypeModel());
          IDE.openEditor(page, file, true);
        } catch (final PartInitException e) {
          e.printStackTrace();
        }
      }
    });

    // Add popup menu
    Menu menu = new Menu(parent);
    MenuItem createItem = new MenuItem(menu, SWT.PUSH);
    createItem.setText(Messages.Editor_Add);
//    renameItem.setImage(JacobDesigner.getImage("rename.png"));
    createItem.addSelectionListener(new SelectionAdapter()
    {
      public void widgetSelected(SelectionEvent e)
      {
        addResource();
      }
    });

    MenuItem deleteItem = new MenuItem(menu, SWT.PUSH);
    deleteItem.setText(Messages.Editor_Delete);
//    deleteItem.setImage("delete.png"));
    deleteItem.addSelectionListener(new SelectionAdapter()
    {
      public void widgetSelected(SelectionEvent e)
      {
        try
        {
          ResourceModel var = getSelection();
          if(var!=null)
          {
            int selIndex =resourceList.getTable().getSelectionIndex();
            getDeviceTypeModel().removeElement(var);
            resourceList.refresh();
            if(selIndex>=1)
              resourceList.getTable().setSelection(selIndex-1);
            else if(resourceList.getTable().getItemCount()>0)
              resourceList.getTable().setSelection(0);
            select(getSelection());
            setDirty();
          }
        }
        catch (Exception e1)
        {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }
      }
    });
    resourceList.getControl().setMenu(menu);
  }
  

  /**
   * 
   * @param parent
   */
  private void createNameComposite(Composite parent)
  {
    GridData textGridData = new GridData(GridData.FILL_HORIZONTAL | GridData.VERTICAL_ALIGN_BEGINNING);
    nameLabel = new Label(parent,SWT.NO_FOCUS);
    nameLabel.setText(Messages.Editor_Name);
    
    nameText = new Text(parent, SWT.SINGLE | SWT.BORDER);
    nameText.setText(""); //$NON-NLS-1$
    nameText.addModifyListener(new ModifyListener()
    {
      public void modifyText(ModifyEvent e)
      {
        String newText = nameText.getText();
        if(getSelection()!=null && !getSelection().getName().equals(newText))
        {
          getSelection().setName(newText);
          setDirty();
          resourceList.refresh();
        }
      }
    });
    nameText.setLayoutData(textGridData);
  }

  /**
   * 
   * @param parent
   */
  private void createTypeComposite(Composite parent)
  {
    typeLabel = new Label(parent,SWT.NO_FOCUS);
    typeLabel.setText(Messages.Editor_Type);
    
    GridData textGridData = new GridData( GridData.VERTICAL_ALIGN_BEGINNING);
    typeCombo = new Combo(parent, SWT.NORMAL);
    typeCombo.setLayoutData(textGridData);
//    typeCombo.setItems(InternalVariableModel.DATA_TYPES.toArray(new String[0]));
    typeCombo.addSelectionListener(new SelectionAdapter()
    {
      public void widgetSelected(SelectionEvent e)
      {
        if(getSelection()!=null && !getSelection().getType().equals(typeCombo.getText()))
        {
          getSelection().setType(typeCombo.getText());
          setDirty();
          resourceList.refresh();
        }
      }
    });
  }

  private void createCommentComposite(Composite parent)
  {
    GridData textGridData = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING | GridData.VERTICAL_ALIGN_BEGINNING);
    commentLabel = new Label(parent,SWT.NO_FOCUS);
    commentLabel.setText(Messages.Editor_Comment);
    commentLabel.setLayoutData(textGridData);
    
    commentText = new Text(parent, SWT.MULTI | SWT.BORDER);
    commentText.setText(""); //$NON-NLS-1$
    commentText.addModifyListener(new ModifyListener()
    {
      public void modifyText(ModifyEvent e)
      {
        String newText = commentText.getText();
        if(getSelection()!=null && !getSelection().getComment().equals(newText))
        {
          getSelection().setComment(newText);
          setDirty();
        }
      }
    });
    textGridData = new GridData(GridData.FILL_HORIZONTAL | GridData.FILL_VERTICAL | GridData.VERTICAL_ALIGN_BEGINNING);
    commentText.setLayoutData(textGridData);
  }
  
  protected void select(ResourceModel model)
  {
    if(model!=null)
    {
      nameText.setText(model.getName());
      typeCombo.setText(model.getType());
      commentText.setText(model.getComment());
      nameText.setFocus();
      nameText.setSelection(nameText.getText().length());
    }
    else
    {
      nameText.setText(""); //$NON-NLS-1$
      typeCombo.setText(""); //$NON-NLS-1$
      commentText.setText(""); //$NON-NLS-1$
    }
  }
  
  private void addResource()
  {
    try
    {
      ElementListSelectionDialog dialog = new ElementListSelectionDialog(null, new LabelProvider()
      {
        public Image getImage(Object element)
        {
          return null;//((ResourceTypeModel)element).getImage();
        }

        public String getText(Object element)
        {
          return ((ResourceTypeModel)element).getName();
        }
      });

      Collection<ResourceTypeModel> x= ResourceTypeModelCache.getModels(getDeviceTypeModel().getProject());
      
      dialog.setElements(x.toArray());
      dialog.setTitle("Select the table alias for the GUI element");
      dialog.setMessage("Select the table alias for the GUI element.");
      dialog.setMultipleSelection(false);
      dialog.create();
      if(dialog.open()==Window.OK && dialog.getFirstResult()!=null)
      {
        ResourceTypeModel resourceType= (ResourceTypeModel)dialog.getFirstResult();
        ResourceModel resource = new ResourceModel(getDeviceTypeModel().getProject(),resourceType);
        String suggestedName = resourceType.getName();
        String newName = suggestedName;
        for (int i = 0; i < 1000; i++)
        {
          newName = suggestedName+i;
          if(getDeviceTypeModel().getElement(newName)==null)
             break;
        }
        resource.setName(newName);
        getDeviceTypeModel().addElement(resource);
        resourceList.refresh();
        setDirty();
      }
    }
    catch (Exception e)
    {
      Activator.getDefault().showException(e);
    }
  }

  /**
	 * Passing the focus request to the resourceList's control.
	 */
	public void setFocus() 
  {
		resourceList.getControl().setFocus();
	}

  public void markSaveLocation()
  {
    dirty=false;
  }

  public void selectionChanged(IWorkbenchPart part, ISelection selection)
  {
  }
  
  private ResourceModel getSelection()
  {
    if(resourceList.getSelection().isEmpty())
      return null;
    else
      return (ResourceModel)((StructuredSelection)resourceList.getSelection()).getFirstElement();
  }
  
  public DeviceTypeModel getDeviceTypeModel()
  {
     return ((IDeviceEditorInput)getEditorInput()).getModel();
  }
}