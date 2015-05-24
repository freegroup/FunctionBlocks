/*
 * Created on 08.11.2004
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package de.netallied.functionblock.modeleditor.fbt.properties;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.part.EditorPart;
import de.netallied.functionblock.contribution.fbteditor.IFbtEditorInput;
import de.netallied.functionblock.contribution.fbteditor.IFunctionBlockEditorPart;
import de.netallied.functionblock.model.AbstractFunctionBlockModel;
import de.netallied.functionblock.model.BasisFunctionBlockModel;

/**
 * @author Andreas
 * 
 * To change the template for this generated type comment go to Window - Preferences - Java - Code Generation - Code and
 * Comments
 */
public class Editor extends EditorPart implements IFunctionBlockEditorPart
{
  private   Text  nameText;
  private   Text  classificationText;
  private   Text  commentText;
  
  private   boolean dirty;
  private Label commentLabel;
	
	public Editor()
  {
  }
  
  @Override
  public void init(IEditorSite site, IEditorInput input) throws PartInitException
  {
    setInput(input);
    setSite(site);
    setPartName("Properties");
    setTitleImage(Activator.getDefault().getImage("editor.png"));
  }

  @Override
  public void doSave(IProgressMonitor monitor)
  {
    dirty = false;
  }

  @Override
  public boolean isSaveAsAllowed()
  {
    return false;
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
  public void setFocus()
  {
    nameText.setFocus();
  }
  
  @Override
  public void createPartControl(Composite parent)
  {
    GridLayout layout = new GridLayout(2,false);
    parent.setLayout(layout);
    
    
    // create name text field
    //
    GridData textGridData = new GridData(GridData.FILL_HORIZONTAL | GridData.VERTICAL_ALIGN_BEGINNING);
    new Label(parent,SWT.NO_FOCUS).setText("Name:");
    nameText = new Text(parent, SWT.SINGLE | SWT.BORDER);
    nameText.setText(getAbstractFunctionBlockModel().getName());
    nameText.addModifyListener(new ModifyListener()
    {
      public void modifyText(ModifyEvent e)
      {
        try
        {
          getAbstractFunctionBlockModel().setName(nameText.getText());
          setDirty();
        }
        catch (Exception e1)
        {
          nameText.setText(getAbstractFunctionBlockModel().getName());
        }
      }
    });
    nameText.setLayoutData(textGridData);
    
    // Classification
    //
    textGridData = new GridData(GridData.FILL_HORIZONTAL | GridData.VERTICAL_ALIGN_BEGINNING);
    new Label(parent,SWT.NO_FOCUS).setText("Classification:");
    classificationText = new Text(parent, SWT.SINGLE | SWT.BORDER);
    classificationText.setText(getAbstractFunctionBlockModel().getClassification());
    classificationText.addModifyListener(new ModifyListener()
    {
      public void modifyText(ModifyEvent e)
      {
        String c = classificationText.getText();
        if(!getAbstractFunctionBlockModel().getClassification().equals(c))
        {
          getAbstractFunctionBlockModel().setClassification(c);
          setDirty();
        }
      }
    });
    classificationText.setLayoutData(textGridData);
    
    commentLabel = new Label(parent,SWT.NO_FOCUS);
    commentLabel.setText("Comment:");
    textGridData = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING |GridData.VERTICAL_ALIGN_BEGINNING);
    commentLabel.setLayoutData(textGridData);
    
    textGridData = new GridData(GridData.FILL_HORIZONTAL | GridData.FILL_VERTICAL |GridData.VERTICAL_ALIGN_BEGINNING);
    commentText = new Text(parent, SWT.MULTI | SWT.BORDER);
    commentText.setText(getAbstractFunctionBlockModel().getComment());
    commentText.addModifyListener(new ModifyListener()
    {
      public void modifyText(ModifyEvent e)
      {
        String c = commentText.getText();
        if(!getAbstractFunctionBlockModel().getComment().equals(c))
        {
          getAbstractFunctionBlockModel().setComment(c);
          setDirty();
        }
      }
    });
    commentText.setLayoutData(textGridData);
  }

	
	private void createSpacer(FormToolkit toolkit, Composite parent, int span)
  {
    Label spacer = toolkit.createLabel(parent, "");
    GridData gd = new GridData();
    gd.horizontalSpan = span;
    spacer.setLayoutData(gd);
  }
  

  public void markSaveLocation()
  {
    dirty=false;
  }
  
  public void selectionChanged(IWorkbenchPart part, ISelection selection)
  {
  }
  
  public AbstractFunctionBlockModel getAbstractFunctionBlockModel()
  {
     return ((IFbtEditorInput)getEditorInput()).getModel().getFunctionBlockModel();
  }
}