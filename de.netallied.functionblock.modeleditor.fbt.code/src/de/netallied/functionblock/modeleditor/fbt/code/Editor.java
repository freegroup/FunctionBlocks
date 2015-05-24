/*
 * Created on 08.11.2004
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package de.netallied.functionblock.modeleditor.fbt.code;

import java.util.HashMap;
import java.util.Map;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.ITextListener;
import org.eclipse.jface.text.TextEvent;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
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
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.part.EditorPart;
import de.netallied.functionblock.contribution.codeeditor.CodeEditorManager;
import de.netallied.functionblock.contribution.codeeditor.ICodeEditor;
import de.netallied.functionblock.contribution.fbteditor.IFbtEditorInput;
import de.netallied.functionblock.contribution.fbteditor.IFunctionBlockEditorPart;
import de.netallied.functionblock.model.Algorithm;
import de.netallied.functionblock.model.BasisFunctionBlockModel;


/**
 * @author Andreas
 * 
 * To change the template for this generated type comment go to Window - Preferences - Java - Code Generation - Code and
 * Comments
 */
public class Editor extends EditorPart implements IFunctionBlockEditorPart
{
  private TableViewer functionList;
//  private List functionList;
  private ICodeEditor visibleCodeEditor;
  
  private boolean dirty=false;
  private Text  nameText;
  private Label nameLabel;
  
  Algorithm selectedAlgorithm;
  private Text      addTextBox;
  private Combo     languageSelect;
  private Composite editorStack;
  private Map<String, ICodeEditor> editors = new HashMap<String, ICodeEditor>();
  private StackLayout codeLayout;
  private Label codeLabel;
  
	public Editor()
  {
  }
  
  
  @Override
  public void init(IEditorSite site, IEditorInput input) throws PartInitException
  {
    setInput(input);
    setSite(site);
    setPartName(Messages.Editor_Title);
    setTitleImage(Activator.getDefault().getImage("editor.png")); //$NON-NLS-1$
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


  @Override
  public void setFocus()
  {
  }
  

  /**
   *     +-----------------+------------------+
   *     |                 | LANGUAGE COMBO   |
   *     |                 +------------------+
   *     |                 |                  |
   *     |                 |                  |
   *     |                 |                  |
   *     |                 |                  |
   *     |                 |                  |
   *     |                 |                  |
   *     +-----------------+                  +
   *     | INPUT       ADD |                  |
   *     +-----------------+------------------+
   */
  @Override
  public void createPartControl(Composite parent)
  {
    SashForm sashForm = new SashForm(parent, SWT.HORIZONTAL);

    Composite leftSide = new Composite(sashForm, SWT.NORMAL);
    leftSide.setLayout(new GridLayout(1, false));
    
    Composite rightSide = new Composite(sashForm, SWT.NORMAL);
    rightSide.setLayout(new GridLayout(2, false));

    createListSection(leftSide);

    
    createNameComposite(rightSide);
    createTypeComposite(rightSide);
    createCodeSection(rightSide);

    if(getTypedFunctionBlockModel().getAlgorithms().size()>0)
    {
      Algorithm alg = getTypedFunctionBlockModel().getAlgorithms().get(0);
      functionList.setSelection(new StructuredSelection(alg),true);
    }
    
    sashForm.setWeights(new int[]{3, 7});
  }

  private void createTypeComposite(Composite parent)
  {
    Label label =new Label(parent,SWT.NORMAL);
    label.setText(Messages.Editor_Type);
    languageSelect = new Combo(parent, SWT.NORMAL);
    languageSelect.setItems(CodeEditorManager.getAvailableLanguages().toArray(new String[0]));
    languageSelect.addSelectionListener(new SelectionAdapter()
    {
      public void widgetSelected(SelectionEvent e)
      {
        selectedAlgorithm.setType(languageSelect.getText());
        select(selectedAlgorithm);
        functionList.refresh();
        setDirty();
      }
    });
  }

  /**
   * 
   * @param parent
   */
  private void createNameComposite(Composite parent)
  {
    nameLabel = new Label(parent,SWT.NO_FOCUS);
    nameLabel.setText(Messages.Editor_Name);
    
    nameText = new Text(parent, SWT.SINGLE | SWT.BORDER);
    nameText.addModifyListener(new ModifyListener()
    {
      public void modifyText(ModifyEvent e)
      {
        String newText = nameText.getText();
        if(getSelection()!=null && !getSelection().getName().equals(newText))
        {
          getSelection().setName(newText);
          setDirty();
          functionList.refresh();
        }
      }
    });
    GridData textGridData = new GridData(GridData.FILL_HORIZONTAL | GridData.VERTICAL_ALIGN_BEGINNING);
    nameText.setLayoutData(textGridData);
  }

  
  /**
   * 
   * @param parent
   */
  private void createListSection(Composite parent)
  {
    functionList = new TableViewer(parent, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL);
    GridData gridData = new GridData();
    gridData.verticalAlignment = GridData.FILL;
    gridData.grabExcessVerticalSpace = true;
    gridData.horizontalAlignment = GridData.FILL;
    gridData.grabExcessHorizontalSpace = true;
    functionList.getControl().setLayoutData(gridData);

    TableColumn column = new TableColumn(functionList.getTable(), SWT.LEFT);
    column.setText(Messages.Editor_Name); //$NON-NLS-1$
    column.setWidth(150);

    column = new TableColumn(functionList.getTable(), SWT.LEFT);
    column.setText(Messages.Editor_Type); //$NON-NLS-1$
    column.setWidth(100);
    functionList.getTable().setHeaderVisible(true);

    functionList.setContentProvider(new ViewContentProvider(this));
    functionList.setLabelProvider(new ViewLabelProvider());
    functionList.setInput(getEditorSite());

    functionList.addSelectionChangedListener(new ISelectionChangedListener()
    {
      public void selectionChanged(SelectionChangedEvent event)
      {
        if(event.getSelection() instanceof StructuredSelection)
        {
          StructuredSelection selection = (StructuredSelection)event.getSelection();
          select((Algorithm)selection.getFirstElement());
        }
      }
    });

  
    // Add popup menu
    Menu menu = new Menu(parent);
    MenuItem createItem = new MenuItem(menu, SWT.PUSH);
    createItem.setText(Messages.Editor_New);
//    renameItem.setImage(JacobDesigner.getImage("rename.png"));
    createItem.addSelectionListener(new SelectionAdapter()
    {
      public void widgetSelected(SelectionEvent e)
      {
        createAlgorithm("newFunction"); //$NON-NLS-1$
      }
    });

    MenuItem deleteItem = new MenuItem(menu, SWT.PUSH);
    deleteItem.setText(Messages.Editor_Delete);
//    deleteItem.setImage("delete.png"));
    deleteItem.addSelectionListener(new SelectionAdapter()
    {
      public void widgetSelected(SelectionEvent e)
      {
        Algorithm var = getSelection();
        if(var!=null)
        {
          int selIndex =functionList.getTable().getSelectionIndex();
          getTypedFunctionBlockModel().removeElement(var);
          functionList.refresh();
          if(selIndex>=1)
            functionList.getTable().setSelection(selIndex-1);
          else if(functionList.getTable().getItemCount()>0)
            functionList.getTable().setSelection(0);
          select(getSelection());
        }
      }
    });
    functionList.getControl().setMenu(menu);
  }
  
  /**
   * 
   * @param parent
   */
  private void createCodeSection(Composite parent)
  {
    GridData textGridData = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING | GridData.VERTICAL_ALIGN_BEGINNING);
    codeLabel = new Label(parent,SWT.NO_FOCUS);
    codeLabel.setText(Messages.Editor_Code);
    codeLabel.setLayoutData(textGridData);
    
    codeLayout = new StackLayout();
    editorStack = new Composite(parent, SWT.NONE);
    editorStack.setLayout(codeLayout);
    GridData gridData = new GridData(GridData.FILL_HORIZONTAL | GridData.FILL_VERTICAL | GridData.VERTICAL_ALIGN_BEGINNING);
    editorStack.setLayoutData(gridData);
    
    this.editors = CodeEditorManager.createCodeEditors(editorStack,getTypedFunctionBlockModel());
    for (ICodeEditor editor : this.editors.values())
    {
      editor.addTextListener(new ITextListener()
      {
        public void textChanged(TextEvent event)
        {
          if(selectedAlgorithm!=null)
          {
            String code =  visibleCodeEditor.getDocument().get();
            if(!selectedAlgorithm.getCode().equals(code))
            {
              selectedAlgorithm.setCode( code);
              setDirty();
            }
          }
        }
      });
    }

    visibleCodeEditor = editors.values().iterator().next();
    codeLayout.topControl = visibleCodeEditor.getControl();
    editorStack.layout();
    visibleCodeEditor.setDocument(new Document ());
  }
  
	
	private void createSpacer(FormToolkit toolkit, Composite parent, int span)
  {
    Label spacer = toolkit.createLabel(parent, ""); //$NON-NLS-1$
    GridData gd = new GridData();
    gd.horizontalSpan = span;
    spacer.setLayoutData(gd);
  }
  


  private void createAlgorithm(String text)
  {
    Algorithm alg = new Algorithm(text);
    getTypedFunctionBlockModel().addElement(alg);
    functionList.refresh();
    functionList.setSelection(new StructuredSelection(alg),true);
    setDirty();
  }

  public void select(Algorithm alg)
  {
    try
    {
      selectedAlgorithm = alg;

      if(selectedAlgorithm!=null)
      {
        nameText.setText(selectedAlgorithm.getName());
        nameText.setEditable(true);
        visibleCodeEditor = editors.get(selectedAlgorithm.getType());
        codeLayout.topControl=visibleCodeEditor.getControl();
        editorStack.layout();
        visibleCodeEditor.setDocument(new Document(selectedAlgorithm.getCode()));
        languageSelect.select(languageSelect.indexOf(selectedAlgorithm.getType()));
        languageSelect.setEnabled(true);
        visibleCodeEditor.setEditable(true);
      }
      else
      {
        nameText.setText(""); //$NON-NLS-1$
        nameText.setEditable(false);
        visibleCodeEditor.setDocument(new Document("")); //$NON-NLS-1$
        visibleCodeEditor.setEditable(false);
        languageSelect.setEnabled(false);
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  private Algorithm getSelection()
  {
    if(functionList.getSelection().isEmpty())
      return null;
    else
      return (Algorithm)((StructuredSelection)functionList.getSelection()).getFirstElement();
  }

  public void markSaveLocation()
  {
    dirty=false;
  }

  public void selectionChanged(IWorkbenchPart part, ISelection selection)
  {
  }

  public BasisFunctionBlockModel getTypedFunctionBlockModel()
  {
     return (BasisFunctionBlockModel)((IFbtEditorInput)getEditorInput()).getModel().getFunctionBlockModel();
  }
}