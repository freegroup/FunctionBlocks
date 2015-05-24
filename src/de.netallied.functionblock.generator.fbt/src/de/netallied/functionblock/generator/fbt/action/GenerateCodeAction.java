/*
 * Created on 23.10.2006
 *
 */
package de.netallied.functionblock.generator.fbt.action;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import com.sun.org.apache.xalan.internal.xsltc.runtime.BasisLibrary;
import de.netallied.functionblock.contribution.generator.GeneratorManager;
import de.netallied.functionblock.contribution.generator.IGenerator;
import de.netallied.functionblock.generator.fbt.Activator;
import de.netallied.functionblock.model.Algorithm;
import de.netallied.functionblock.model.CompositeFunctionBlockModel;
import de.netallied.functionblock.model.FBTypeModel;
import de.netallied.functionblock.model.InstanceFunctionBlockModel;
import de.netallied.functionblock.model.BasisFunctionBlockModel;

public class GenerateCodeAction implements IObjectActionDelegate
{
  IFile file;
  
  public GenerateCodeAction()
  {
  }

  public void setActivePart(IAction action, IWorkbenchPart targetPart)
  {
  }

  /**
   * TODO : Im Moment wird der erste Codegenerator genommen welcher gefunden wird.
   *         Hier muss ein Wizard her, bei dem man die Zielsprache auswählen kann
   *        
   */
  public void run(IAction action)
  {
    if(file!=null)
    {
      IProgressMonitor monitor=null;
      try
      {
        InputStream is = file.getContents();
        
        FBTypeModel model = new FBTypeModel(file.getProject(), is);
        is.close();
        IGenerator generator = GeneratorManager.getGenerators().iterator().next();
        System.out.println(getAllSourceLanguages(model));
        generator.convert(file.getProject(), model, monitor);
      }
      catch (Exception e)
      {
        Activator.getDefault().showException(e);
      }
    }
  }


  public void selectionChanged(IAction action, ISelection selection)
  {
      if(((IStructuredSelection)selection).getFirstElement()!=null)
      {
        Object object =((IStructuredSelection)selection).getFirstElement();
        if(object instanceof IFile)
          file = (IFile)object;
      }
      else
        file=null;
  }
  
  private Set<String> getAllSourceLanguages(FBTypeModel model)
  {
    Set<String> result = new TreeSet<String>();
    
    if(model.getFunctionBlockModel() instanceof BasisFunctionBlockModel)
    {
      BasisFunctionBlockModel typed = (BasisFunctionBlockModel)model.getFunctionBlockModel();
      for (Algorithm alg : typed.getAlgorithms())
      {
        result.add(alg.getType());
      }
    }
    else if(model.getFunctionBlockModel() instanceof CompositeFunctionBlockModel)
    {
      CompositeFunctionBlockModel cmp = (CompositeFunctionBlockModel)model.getFunctionBlockModel();
      for (InstanceFunctionBlockModel ifb : cmp.getNetwork().getElements())
      {
        result.addAll(getAllSourceLanguages(ifb.getTypeModel()));
      } 
    }
    return result;
  }
}
