package de.netallied.functionblock.create.project.digitallogic;

import org.apache.commons.lang.StringUtils;
import org.eclipse.jface.dialogs.IDialogPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * The "New" wizard page allows setting the container for the new file as well
 * as the file name. The page will only accept file name without the extension
 * OR with the extension that matches the expected one (txt).
 */

public class NewProjectWizardPage extends WizardPage
{
  private Text projectNameText;
  private String defaultName;
  
  /**
   * Constructor for SampleNewWizardPage.
   * 
   * @param pageName
   */
  public NewProjectWizardPage(String defaultName) 
  {
    super("wizardPage");
    
    this.defaultName = defaultName;
    
    setTitle("IEC 61499 Project");
    setDescription("This wizard creates a project for the IEC 61499 Standart.");
  }

  /**
   * @see IDialogPage#createControl(Composite)
   */
  public void createControl(Composite parent)
  {
    Composite container = new Composite(parent, SWT.NULL);
    GridLayout layout = new GridLayout();
    container.setLayout(layout);
    layout.numColumns = 3;
    layout.verticalSpacing = 9;
    Label label = new Label(container, SWT.NULL);
    label.setText("&Project name:");

    projectNameText = new Text(container, SWT.BORDER | SWT.SINGLE);
    GridData gd = new GridData(GridData.FILL_HORIZONTAL);
    projectNameText.setLayoutData(gd);
    projectNameText.addModifyListener(new ModifyListener()
    {
      public void modifyText(ModifyEvent e)
      {
        dialogChanged();
      }
    });
    initialize();
    dialogChanged();
    setControl(container);
  }

  /**
   * Tests if the current workbench selection is a suitable container to use.
   */
  private void initialize()
  {
    projectNameText.setText(defaultName);
  }

  /**
   * Ensures that both text fields are set.
   */

  private void dialogChanged()
  {
    String fileName = getFileName();

    if (fileName.length() == 0)
    {
      updateStatus("Project name must be specified");
      return;
    }
    else if(!StringUtils.containsOnly(fileName,"abcdefghijklmnopqrstuvwxyzABCDEFGHJIKLMNOPQRSTUVWXYZ_".toCharArray()))
    {
      updateStatus("Project name can only contain [a-zA-Z_] as character.");
      return;
    }
    updateStatus(null);
  }

  private void updateStatus(String message)
  {
    setErrorMessage(message);
    setPageComplete(message == null);
  }

  public String getFileName()
  {
    return projectNameText.getText();
  }
}