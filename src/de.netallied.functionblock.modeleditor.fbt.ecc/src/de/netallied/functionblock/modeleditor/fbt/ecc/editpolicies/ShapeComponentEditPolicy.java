package de.netallied.functionblock.modeleditor.fbt.ecc.editpolicies;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;
import de.netallied.functionblock.modeleditor.fbt.ecc.commands.DeleteStateCommand;
import de.netallied.functionblock.model.ECCAbstractStateModel;
import de.netallied.functionblock.model.ECCDiagramModel;


public class ShapeComponentEditPolicy extends ComponentEditPolicy
{
  
  protected Command createDeleteCommand(GroupRequest deleteRequest)
  {
    Object parent = getHost().getParent().getModel();
    Object child = getHost().getModel();
    if (parent instanceof ECCDiagramModel && child instanceof ECCAbstractStateModel)
    {
      return new DeleteStateCommand((ECCDiagramModel) parent, (ECCAbstractStateModel) child);
    }
    return super.createDeleteCommand(deleteRequest);
  }
  
}