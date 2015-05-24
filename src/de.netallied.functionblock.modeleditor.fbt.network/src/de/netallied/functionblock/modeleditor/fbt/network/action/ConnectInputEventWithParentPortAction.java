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
import de.netallied.functionblock.modeleditor.fbt.network.editpart.InputEventModelEditPart;
import de.netallied.functionblock.model.CompositeFunctionBlockModel;
import de.netallied.functionblock.model.CompositeInputEventModel;
import de.netallied.functionblock.model.EventTransitionModel;
import de.netallied.functionblock.model.InputEventModel;
import de.netallied.functionblock.model.NetworkModel;

public class ConnectInputEventWithParentPortAction implements IObjectActionDelegate 
{
  InputEventModel instanceInputEvent;
  NetworkModel   network;
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
    if(anyObj instanceof InputEventModelEditPart)
    {
      InputEventModelEditPart actionPart = (InputEventModelEditPart)anyObj;
      instanceInputEvent = actionPart.getInputEventModel();
      network = actionPart.getNetworkModel();
    }
    else
    {
      instanceInputEvent = null;
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
          return ((CompositeInputEventModel) element).getName();
        }
      });
      dialog.setElements(((CompositeFunctionBlockModel)network.getParent()).getCompositeInputEventModels().toArray());
      
      dialog.create();
      if(dialog.open()==Window.OK)
      {
        try
        {
          // The selected InputEvent Port of the composite element
          //
          CompositeInputEventModel cin =  (CompositeInputEventModel)dialog.getFirstResult();
          
          // Eventuell zuvor bestehenden Zuordnungen entfernen
          //
          List<EventTransitionModel> transistions = network.getSourceTransitions(cin);
          for (EventTransitionModel model : transistions)
          {
            network.removeElement(model);
          }
          
          EventTransitionModel transition= new EventTransitionModel(network,cin,instanceInputEvent);
          network.addElement(transition);
        }
        catch(Exception exc)
        {
          exc.printStackTrace();
        }
      }
  }
}
