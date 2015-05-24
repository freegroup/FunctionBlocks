package de.netallied.functionblock.create.project.digitallogic;

import java.lang.reflect.InvocationTargetException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;

/**
 * This is a sample new wizard. Its role is to create a new file resource in the
 * provided container. If the container resource (a folder or a project) is
 * selected in the workspace when the wizard is opened, it will accept it as the
 * target container. The wizard creates one file with the extension "txt". If a
 * sample multi-page editor (also available as a template) is registered for the
 * same extension, it will be able to open it.
 */
public class NewProjectWizard extends Wizard implements INewWizard
{
  private static final String DEFAULT_NAME = "digitallogic";
  
  private NewProjectWizardPage page;

  /**
   * Constructor for NewProjectWizard.
   */
  public NewProjectWizard() 
  {
    super();
    setNeedsProgressMonitor(true);
  }

  /**
   * Adding the page to the wizard.
   */
  public void addPages()
  {
    page = new NewProjectWizardPage(DEFAULT_NAME);
    addPage(page);
  }

  /**
   * This method is called when 'Finish' button is pressed in the wizard. We
   * will create an operation and run it using wizard as execution context.
   */
  public boolean performFinish()
  {
    final String fileName = page.getFileName();
    IRunnableWithProgress op = new IRunnableWithProgress()
    {
      public void run(IProgressMonitor monitor) throws InvocationTargetException
      {
        try
        {
          doFinish(fileName, monitor);
        }
        catch (CoreException e)
        {
          throw new InvocationTargetException(e);
        }
        finally
        {
          monitor.done();
        }
      }
    };
    try
    {
      getContainer().run(true, false, op);
    }
    catch (InterruptedException e)
    {
      return false;
    }
    catch (InvocationTargetException e)
    {
      Throwable realException = e.getTargetException();
      MessageDialog.openError(getShell(), "Error", realException.getMessage());
      return false;
    }
    return true;
  }

  /**
   * The worker method. It will find the container, create the file if missing
   * or just replace its contents, and open the editor on the newly created
   * file.
   */

  private void doFinish(String projectName, IProgressMonitor monitor) throws CoreException
  {
    // create a sample file
    IEC61499Project project = new IEC61499Project(projectName, monitor);
  }

  /**
   * We will accept the selection in the workbench to see if we can initialize
   * from it.
   * 
   * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
   */
  public void init(IWorkbench workbench, IStructuredSelection selection)
  {
  }
}