package de.netallied.functionblock.modeleditor.fbt.network.action;

import java.util.List;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import de.netallied.functionblock.model.CompositeFunctionBlockModel;
import de.netallied.functionblock.model.CompositeInputValueModel;
import de.netallied.functionblock.model.InputValueModel;
import de.netallied.functionblock.model.NetworkModel;
import de.netallied.functionblock.model.ValueTransitionModel;
import de.netallied.functionblock.modeleditor.fbt.network.editpart.InputValueModelEditPart;

public class ConnectInputValueWithParentPortAction implements IObjectActionDelegate 
{
  InputValueModel instanceInputValue;
  NetworkModel network;
  public String  getKey()
  {
    return null;
  }
  
	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public final void setActivePart(IAction action, IWorkbenchPart targetPart) 
	{
	}

	public void selectionChanged(IAction action, ISelection selection) 
	{
    Object anyObj = ((IStructuredSelection)selection).getFirstElement();
    if(anyObj instanceof InputValueModelEditPart)
    {
      InputValueModelEditPart actionPart = (InputValueModelEditPart)anyObj;
      instanceInputValue = actionPart.getInputValueModel();
      network = actionPart.getNetworkModel();
    }
    else
    {
      instanceInputValue = null;
      network = null;
    }
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action)
  {
    ElementListSelectionDialog dialog = new ElementListSelectionDialog(null, new LabelProvider()
    {
        public Image getImage(Object element)
        {
          return null;
        }
      
        public String getText(Object element)
        {
          return ((CompositeInputValueModel) element).getName();
        }
      });
      dialog.setElements(((CompositeFunctionBlockModel)network.getParent()).getCompositeInputValueModels().toArray());
      
      dialog.create();
      if(dialog.open()==Window.OK)
      {
        try
        {
          // The selected InputEvent Port of the composite element
          //
          CompositeInputValueModel cin =  (CompositeInputValueModel)dialog.getFirstResult();
          
          // Eventuell zuvor bestehenden Zuordnungen entfernen
          //
          List<ValueTransitionModel> transistions = network.getSourceTransitions(cin);
          for (ValueTransitionModel model : transistions)
          {
            network.removeElement(model);
          }

          ValueTransitionModel transition= new ValueTransitionModel(network, cin,instanceInputValue);
          network.addElement(transition);
        }
        catch(Exception exc)
        {
          exc.printStackTrace();
        }
      }
  }
}
