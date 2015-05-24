/*
 * Created on 01.08.2006
 *
 */
package de.netallied.functionblock.modeleditor.fbt.ecc.editpolicies;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.BendpointRequest;
import de.netallied.functionblock.modeleditor.fbt.ecc.commands.MoveBendpointCommand;
import de.netallied.functionblock.model.ECCTransitionModel;

public class WireBendpointEditPolicy extends org.eclipse.gef.editpolicies.BendpointEditPolicy
{
  protected Command getCreateBendpointCommand(BendpointRequest request)
  {
    return createCommand(request);
  }

  protected Command getMoveBendpointCommand(BendpointRequest request)
  {
    return createCommand(request);
  }

  protected Command getDeleteBendpointCommand(BendpointRequest request)
  {
    return createCommand(request);
  }
  
  private Command createCommand(BendpointRequest request)
  {
    Point p = request.getLocation();
    Connection conn = getConnection();
    conn.translateToRelative(p);
    return new MoveBendpointCommand((ECCTransitionModel) request.getSource().getModel(),p);
  }
}
