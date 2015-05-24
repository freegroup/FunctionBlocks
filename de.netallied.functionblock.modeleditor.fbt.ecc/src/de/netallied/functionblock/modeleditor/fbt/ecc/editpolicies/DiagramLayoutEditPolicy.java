/*
 * Created on 03.08.2006
 *
 */
package de.netallied.functionblock.modeleditor.fbt.ecc.editpolicies;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;
import de.netallied.functionblock.modeleditor.fbt.ecc.commands.CreateStateCommand;
import de.netallied.functionblock.modeleditor.fbt.ecc.commands.MoveStateCommand;
import de.netallied.functionblock.modeleditor.fbt.ecc.editparts.StateEditPart;
import de.netallied.functionblock.model.ECCAbstractStateModel;
import de.netallied.functionblock.model.ECCDiagramModel;
import de.netallied.functionblock.model.ECCStateModel;

public class DiagramLayoutEditPolicy extends XYLayoutEditPolicy
{
  protected Command createChangeConstraintCommand(ChangeBoundsRequest request, EditPart child, Object constraint)
  {
    if (child instanceof StateEditPart && constraint instanceof Rectangle)
    {
      // return a command that can move and/or resize a ECCAbstractStateModel
      return new MoveStateCommand((ECCAbstractStateModel) child.getModel(), ((Rectangle) constraint).getLocation());
    }
    return super.createChangeConstraintCommand(request, child, constraint);
  }
  
  
  
  /*
   * (non-Javadoc)
   * 
   * @see ConstrainedLayoutEditPolicy#createChangeConstraintCommand(EditPart,
   *      Object)
   */
  protected Command createChangeConstraintCommand(EditPart child, Object constraint)
  {
    // not used in this example
    return null;
  }
  
  
  
  /*
   * (non-Javadoc)
   * 
   * @see LayoutEditPolicy#getCreateCommand(CreateRequest)
   */
  protected Command getCreateCommand(CreateRequest request)
  {
    Object childClass = request.getNewObjectType();
    if (childClass == ECCStateModel.class)
    {
      // return a command that can add a ECCAbstractStateModel to a
      // ShapesDiagram
      try
      {
        Point pos = ((Rectangle) getConstraintFor(request)).getLocation();
        return new CreateStateCommand((ECCStateModel) request.getNewObject(), (ECCDiagramModel) getHost().getModel(), pos);
      }
      catch (RuntimeException e)
      {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    return null;
  }
}
