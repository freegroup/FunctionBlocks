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
import de.netallied.functionblock.modeleditor.fbt.network.editpart.OutputValueModelEditPart;
import de.netallied.functionblock.model.CompositeFunctionBlockModel;
import de.netallied.functionblock.model.CompositeOutputEventModel;
import de.netallied.functionblock.model.CompositeOutputValueModel;
import de.netallied.functionblock.model.EventTransitionModel;
import de.netallied.functionblock.model.NetworkModel;
import de.netallied.functionblock.model.OutputValueModel;
import de.netallied.functionblock.model.ValueTransitionModel;

public class ConnectOutputValueWithParentPortAction implements IObjectActionDelegate 
{
  OutputValueModel instanceOutputValue;
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
    if(anyObj instanceof OutputValueModelEditPart)
    {
      OutputValueModelEditPart actionPart = (OutputValueModelEditPart)anyObj;
      instanceOutputValue = actionPart.getOutputValueModel();
      network = actionPart.getNetworkModel();
    }
    else
    {
      instanceOutputValue = null;
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
          return ((CompositeOutputValueModel) element).getName();
        }
      });
      dialog.setElements(((CompositeFunctionBlockModel)network.getParent()).getCompositeOutputValueModels().toArray());
      
      dialog.create();
      if(dialog.open()==Window.OK)
      {
        try
        {
          // The selected InputEvent Port of the composite element
          //
          CompositeOutputValueModel cout =  (CompositeOutputValueModel)dialog.getFirstResult();
          
          // Eventuell zuvor bestehenden Zuordnungen entfernen
          //
          List<ValueTransitionModel> transistions = network.getTargetTransitions(cout);
          for (ValueTransitionModel model : transistions)
          {
            network.removeElement(model);
          }

          ValueTransitionModel transition= new ValueTransitionModel(network,instanceOutputValue, cout);
          network.addElement(transition);
        }
        catch(Exception exc)
        {
          exc.printStackTrace();
        }
      }
  }
}
