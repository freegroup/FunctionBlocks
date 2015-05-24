package de.netallied.functionblock.modeleditor.sys.network.editpolicy;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;
import de.netallied.functionblock.model.DeviceModel;
import de.netallied.functionblock.model.SegmentModel;
import de.netallied.functionblock.model.SystemModel;
import de.netallied.functionblock.modeleditor.sys.network.command.CreateDeviceCommand;
import de.netallied.functionblock.modeleditor.sys.network.command.CreateSegmentCommand;
import de.netallied.functionblock.modeleditor.sys.network.command.MoveDeviceCommand;
import de.netallied.functionblock.modeleditor.sys.network.command.MoveSegmentCommand;
import de.netallied.functionblock.modeleditor.sys.network.editpart.DeviceEditPart;
import de.netallied.functionblock.modeleditor.sys.network.editpart.SegmentEditPart;

public class ModelXYLayoutEditPolicy extends XYLayoutEditPolicy 
{
	
	/* (non-Javadoc)
	 * @see ConstrainedLayoutEditPolicy#createChangeConstraintCommand(ChangeBoundsRequest, EditPart, Object)
	 */
	protected Command createChangeConstraintCommand(ChangeBoundsRequest request, EditPart child, Object constraint) 
  {
		if (child instanceof SegmentEditPart && constraint instanceof Rectangle) 
			return new MoveSegmentCommand((SegmentModel) child.getModel(), request, (Rectangle) constraint);
		
    if (child instanceof DeviceEditPart && constraint instanceof Rectangle) 
      return new MoveDeviceCommand((DeviceModel) child.getModel(), request, (Rectangle) constraint);
    
		return super.createChangeConstraintCommand(request, child, constraint);
	}
	
	/* (non-Javadoc)
	 * @see ConstrainedLayoutEditPolicy#createChangeConstraintCommand(EditPart, Object)
	 */
	protected Command createChangeConstraintCommand(EditPart child,Object constraint) 
  {
		return null;
	}
	
	/* (non-Javadoc)
	 * @see LayoutEditPolicy#getCreateCommand(CreateRequest)
	 */
	protected Command getCreateCommand(CreateRequest request) 
  {
		Object childClass = request.getNewObjectType();
		
    if (childClass == DeviceModel.class) 
			return new CreateDeviceCommand((DeviceModel)request.getNewObject(), (SystemModel)getHost().getModel(), (Rectangle)getConstraintFor(request));

    if (childClass == SegmentModel.class) 
      return new CreateSegmentCommand((SegmentModel)request.getNewObject(), (SystemModel)getHost().getModel(), (Rectangle)getConstraintFor(request));

    return null;
	}
	
}