package de.netallied.functionblock.modeleditor.res.network.editpart;

import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ConnectionEditPolicy;
import org.eclipse.gef.requests.GroupRequest;
import de.netallied.functionblock.model.ValueTransitionModel;
import de.netallied.functionblock.modeleditor.res.network.command.DeleteValueTransitionCommand;


/**
 */
public class ValueTransitionEditPart extends TransitionEditPart
{

  public ValueTransitionModel getValueTransitionModel()
  {
    return (ValueTransitionModel)getModel();
  }
  
  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
   */
  @Override
  protected void createEditPolicies()
  {
  	super.createEditPolicies();

  	installEditPolicy(EditPolicy.CONNECTION_ROLE, new ConnectionEditPolicy()
    {
      protected Command getDeleteCommand(GroupRequest request)
      {
        return new DeleteValueTransitionCommand(getValueTransitionModel());
      }
    });
  }
 
}