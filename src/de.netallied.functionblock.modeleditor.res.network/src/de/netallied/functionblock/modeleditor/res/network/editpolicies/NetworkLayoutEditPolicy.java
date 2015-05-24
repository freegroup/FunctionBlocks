/*
 * Created on 22.02.2005
 *
 */
package de.netallied.functionblock.modeleditor.res.network.editpolicies;

import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;
import de.netallied.functionblock.model.InstanceFunctionBlockModel;
import de.netallied.functionblock.modeleditor.res.network.command.CreateInstanceFunctionBlockCommand;
import de.netallied.functionblock.modeleditor.res.network.command.MoveInstanceFunctionBlockCommand;
import de.netallied.functionblock.modeleditor.res.network.editpart.InstanceFunctionBlockModelEditPart;
import de.netallied.functionblock.modeleditor.res.network.editpart.NetworkModelEditPart;


/**
 * EditPolicy for the Figure used by this edit part. Children of
 * XYLayoutEditPolicy can be used in Figures with XYLayout.
 * 
 */
public class NetworkLayoutEditPolicy extends XYLayoutEditPolicy
{
  private final NetworkModelEditPart part;

  /**
   * Create a new instance of this edit policy.
   * 
   * @param layout
   *          a non-null XYLayout instance. This should be the layout of the
   *          editpart's figure where this instance is installed.
   * @param part TODO
   * @throws IllegalArgumentException
   *           if layout is null
   * @see NetworkModelEditPart#createEditPolicies()
   */
  public NetworkLayoutEditPolicy(NetworkModelEditPart part, XYLayout layout)
  {
    if (layout == null)
    {
      throw new IllegalArgumentException();
    }
    this.part = part;
    setXyLayout(layout);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.editpolicies.ConstrainedLayoutEditPolicy#createAddCommand(org.eclipse.gef.EditPart,
   *      java.lang.Object)
   */
  protected Command createAddCommand(EditPart child, Object constraint)
  {
    // not used in this example
    return null;
  }

  /*
   * (non-Javadoc)newDiagram
   * 
   * @see org.eclipse.gef.editpolicies.ConstrainedLayoutEditPolicy#createChangeConstraintCommand(org.eclipse.gef.requests.ChangeBoundsRequest,
   *      org.eclipse.gef.EditPart, java.lang.Object)
   */
  protected Command createChangeConstraintCommand(ChangeBoundsRequest request, EditPart child, Object constraint)
  {
    if (child instanceof InstanceFunctionBlockModelEditPart && constraint instanceof Rectangle)
      return new MoveInstanceFunctionBlockCommand((InstanceFunctionBlockModel) child.getModel(), ((Rectangle) constraint).getTopLeft());
    
    return super.createChangeConstraintCommand(request, child, constraint);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.editpolicies.ConstrainedLayoutEditPolicy#createChangeConstraintCommand(org.eclipse.gef.EditPart,
   *      java.lang.Object)
   */
  protected Command createChangeConstraintCommand(EditPart child, Object constraint)
  {
    // not used in this example
    return null;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#getCreateCommand(org.eclipse.gef.requests.CreateRequest)
   */
  protected Command getCreateCommand(CreateRequest request)
  {
    Object child = request.getNewObject();
    if (child instanceof InstanceFunctionBlockModel)
    {
      return new CreateInstanceFunctionBlockCommand(this.part.getNetworkModel(),(InstanceFunctionBlockModel) child,request.getLocation());
    }

    return null;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#getDeleteDependantCommand(org.eclipse.gef.Request)
   */
  protected Command getDeleteDependantCommand(Request request)
  {
    // not used in this example
    return null;
  }
}