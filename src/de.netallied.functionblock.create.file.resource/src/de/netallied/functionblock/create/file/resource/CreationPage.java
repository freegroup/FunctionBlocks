package de.netallied.functionblock.create.file.resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.util.Date;
import org.apache.commons.io.IOUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.ide.IDE;
import de.netallied.functionblock.util.StringUtil;

/**
 * This WizardPage can create an empty .shapes file for the ECCEditor.
 */
class CreationPage extends WizardNewFileCreationPage 
{
  private final NewWizard page;
  private static final String DEFAULT_EXTENSION = ".res";
  private final IWorkbench workbench;

  /**
   * Create a new wizard page instance.
   * 
   * @param workbench
   *          the current workbench
   * @param selection
   *          the current object selection
   * @param wizard TODO
   * @see ShapesCreationWizard#init(IWorkbench, IStructuredSelection)
   */
  CreationPage(NewWizard wizard, IWorkbench workbench, IStructuredSelection selection) 
  {
    super("ResourceCreationPage", selection);
    page = wizard;
    this.workbench = workbench;
    setTitle("Create a new " + DEFAULT_EXTENSION + " file");
    setDescription("Create a new " + DEFAULT_EXTENSION + " file");
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.dialogs.WizardNewFileCreationPage#createControl(org.eclipse.swt.widgets.Composite)
   */
  public void createControl(Composite parent) 
  {
    super.createControl(parent);
    setFileName("NewResource" + NewWizard.fileCount + DEFAULT_EXTENSION);
    setPageComplete(validatePage());
  }

  /**
   * This method will be invoked, when the "Finish" button is pressed.
   * 
   * @see ShapesCreationWizard#performFinish()
   */
  boolean finish() 
  {
    // create a new file, result != null if successful
    IFile newFile = createNewFile();
    NewWizard.fileCount++;

    
    // open newly created file in the editor
    IWorkbenchPage page = workbench.getActiveWorkbenchWindow().getActivePage();
    if (newFile != null && page != null) 
    {
      try 
      {
        IDE.openEditor(page, newFile, true);
      } 
      catch (PartInitException e) 
      {
        e.printStackTrace();
        return false;
      }
    }
    return true;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.dialogs.WizardNewFileCreationPage#getInitialContents()
   */
  protected InputStream getInitialContents() 
  {
    try 
    {
      InputStream stream = Activator.getDefault().find(new Path("templates/functionblock/ResourceType.res")).openStream();
      String data = IOUtils.toString(stream);
      stream.close();
      data = replaceKeyWords(data);
      return new StringBufferInputStream(data);
    } 
    catch (IOException e) 
    {
      Activator.getDefault().showException(e);
    }
    return null;
  }

  /**
   * Return true, if the file name entered in this page is valid.
   */
  private boolean validateFilename() 
  {
    if (getFileName() != null && getFileName().endsWith(DEFAULT_EXTENSION)) 
    {
      return true;
    }
    setErrorMessage("The 'file' name must end with " + DEFAULT_EXTENSION);
    return false;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.dialogs.WizardNewFileCreationPage#validatePage()
   */
  protected boolean validatePage() 
  {
    return super.validatePage() && validateFilename();
  }
  
  private String replaceKeyWords(String template)
  {
    String filename = getFileName();
    filename = StringUtil.replace(filename,DEFAULT_EXTENSION,"");
    template = StringUtil.replace(template, "{date}", new Date().toString());
    template = StringUtil.replace(template, "{author}", System.getProperty("user.name"));
    template = StringUtil.replace(template, "{name}", filename);
    
    return template;
  }
  
}