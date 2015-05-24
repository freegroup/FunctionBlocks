package de.netallied.functionblock.modeleditor.res.network.action;

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
import de.netallied.functionblock.model.InstanceFunctionBlockModel;
import de.netallied.functionblock.model.InstanceInputValueModel;
import de.netallied.functionblock.model.NetworkModel;
import de.netallied.functionblock.model.ParameterModel;
import de.netallied.functionblock.model.ParameterTransitionModel;
import de.netallied.functionblock.model.ValueTransitionModel;
import de.netallied.functionblock.modeleditor.res.network.editpart.InputValueModelEditPart;
import de.netallied.functionblock.modeleditor.res.network.editpart.InstanceFunctionBlockModelEditPart;

public class SetParameterAction implements IObjectActionDelegate 
{
  InstanceFunctionBlockModel parentModel;
  InstanceInputValueModel    inputValue;
  NetworkModel               network;
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
      InstanceFunctionBlockModelEditPart parent = (InstanceFunctionBlockModelEditPart)actionPart.getParent();
      parentModel = parent.getInstanceFunctionBlockModel();
      inputValue  = actionPart.getInstanceInputValueModel();
      network     = parentModel.getNetworkModel();
    }
    else
    {
      this.parentModel = null;
      this.inputValue  = null;
      this.network     = null;
    }
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action)
  {
    try
    {
      ParameterModel param = new ParameterModel(parentModel,inputValue);
      network.addElement(new ParameterTransitionModel(network,param,inputValue));
    }
    catch(Exception exc)
    {
      exc.printStackTrace();
    }
  }
}
