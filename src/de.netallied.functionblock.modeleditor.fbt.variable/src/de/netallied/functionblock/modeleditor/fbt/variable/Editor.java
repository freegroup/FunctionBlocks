package de.netallied.functionblock.modeleditor.fbt.variable;


import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
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
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;
import de.netallied.functionblock.contribution.fbteditor.IFbtEditorInput;
import de.netallied.functionblock.contribution.fbteditor.IFunctionBlockEditorPart;
import de.netallied.functionblock.model.InternalVariableModel;
import de.netallied.functionblock.model.BasisFunctionBlockModel;


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

public class Editor extends EditorPart implements IFunctionBlockEditorPart
{
  private   boolean dirty;

  private TableViewer variableList;

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
    setPartName(Messages.Editor_Variable);
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
	 * to create the variableList and initialize it.
	 */
	public void createPartControl(Composite parent) 
  {
    SashForm sashForm = new SashForm(parent, SWT.HORIZONTAL);

    Composite leftSide = new Composite(sashForm, SWT.NORMAL);
    leftSide.setLayout(new GridLayout(1, false));
    
    Composite rightSide = new Composite(sashForm, SWT.NORMAL);
    rightSide.setLayout(new GridLayout(2, false));

    createVariableComposite(leftSide);
    
    createNameComposite(rightSide);
    createTypeComposite(rightSide);
    createCommentComposite(rightSide);

    if(getTypedFunctionBlockModel().getVariables().size()>0)
    {
      InternalVariableModel var = getTypedFunctionBlockModel().getVariables().get(0);
      variableList.setSelection(new StructuredSelection(var),true);
    }
    
    sashForm.setWeights(new int[]{3, 7});
  }

  /**
   * 
   * @param parent
   */
  private void createVariableComposite(Composite parent)
  {
    variableList = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
    GridData gridData = new GridData();
    gridData.verticalAlignment = GridData.FILL;
    gridData.grabExcessVerticalSpace = true;
    gridData.horizontalAlignment = GridData.FILL;
    gridData.grabExcessHorizontalSpace = true;
    variableList.getControl().setLayoutData(gridData);
    
    TableColumn column = new TableColumn(variableList.getTable(), SWT.LEFT);
    column.setText(Messages.Editor_Name);
    column.setWidth(150);

    column = new TableColumn(variableList.getTable(), SWT.LEFT);
    column.setText(Messages.Editor_Type);
    column.setWidth(100);
    variableList.getTable().setHeaderVisible(true);

    variableList.setContentProvider(new ViewContentProvider(this));
    variableList.setLabelProvider(new ViewLabelProvider(this));
    variableList.setInput(getEditorSite());
    
    variableList.addSelectionChangedListener(new ISelectionChangedListener()
    {
      public void selectionChanged(SelectionChangedEvent event)
      {
        if(event.getSelection() instanceof StructuredSelection)
        {
          StructuredSelection selection = (StructuredSelection)event.getSelection();
          select((InternalVariableModel)selection.getFirstElement());
        }
      }
    });
    
    // Add popup menu
    Menu menu = new Menu(parent);
    MenuItem createItem = new MenuItem(menu, SWT.PUSH);
    createItem.setText(Messages.Editor_Create);
//    renameItem.setImage(JacobDesigner.getImage("rename.png"));
    createItem.addSelectionListener(new SelectionAdapter()
    {
      public void widgetSelected(SelectionEvent e)
      {
        createVariable();
      }
    });

    MenuItem deleteItem = new MenuItem(menu, SWT.PUSH);
    deleteItem.setText(Messages.Editor_Delete);
//    deleteItem.setImage("delete.png"));
    deleteItem.addSelectionListener(new SelectionAdapter()
    {
      public void widgetSelected(SelectionEvent e)
      {
        InternalVariableModel var = getSelection();
        if(var!=null)
        {
          int selIndex =variableList.getTable().getSelectionIndex();
          getTypedFunctionBlockModel().removeElement(var);
          variableList.refresh();
          if(selIndex>=1)
            variableList.getTable().setSelection(selIndex-1);
          else if(variableList.getTable().getItemCount()>0)
            variableList.getTable().setSelection(0);
          select(getSelection());
        }
      }
    });
    variableList.getControl().setMenu(menu);
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
          variableList.refresh();
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
    typeCombo.setItems(InternalVariableModel.DATA_TYPES.toArray(new String[0]));
    typeCombo.addSelectionListener(new SelectionAdapter()
    {
      public void widgetSelected(SelectionEvent e)
      {
        if(getSelection()!=null && !getSelection().getType().equals(typeCombo.getText()))
        {
          getSelection().setType(typeCombo.getText());
          setDirty();
          variableList.refresh();
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
  
  protected void select(InternalVariableModel model)
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
  
  private void createVariable()
  {
    InternalVariableModel var = new InternalVariableModel(getTypedFunctionBlockModel());
    getTypedFunctionBlockModel().addElement(var);
    variableList.refresh();
    variableList.setSelection(new StructuredSelection(var),true);
    setDirty();
  }

  /**
	 * Passing the focus request to the variableList's control.
	 */
	public void setFocus() 
  {
		variableList.getControl().setFocus();
	}

  public void markSaveLocation()
  {
    dirty=false;
  }

  public void selectionChanged(IWorkbenchPart part, ISelection selection)
  {
  }
  
  private InternalVariableModel getSelection()
  {
    if(variableList.getSelection().isEmpty())
      return null;
    else
      return (InternalVariableModel)((StructuredSelection)variableList.getSelection()).getFirstElement();
  }
  
  public BasisFunctionBlockModel getTypedFunctionBlockModel()
  {
     return (BasisFunctionBlockModel)((IFbtEditorInput)getEditorInput()).getModel().getFunctionBlockModel();
  }
}