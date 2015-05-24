package de.netallied.functionblock.modeleditor.res.network.command;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;

import de.netallied.functionblock.model.CompositeFunctionBlockModel;
import de.netallied.functionblock.model.CompositeInputEventModel;
import de.netallied.functionblock.model.CompositeInputValueModel;
import de.netallied.functionblock.model.CompositeOutputEventModel;
import de.netallied.functionblock.model.CompositeOutputValueModel;
import de.netallied.functionblock.model.InstanceFunctionBlockModel;
import de.netallied.functionblock.model.ObjectModel;
import de.netallied.functionblock.model.ParameterModel;


public class MoveInstanceFunctionBlockCommand extends Command
{
	final private InstanceFunctionBlockModel model;
	final private Point oldConstraint;
	final private Point newConstraint;
	
	public MoveInstanceFunctionBlockCommand(InstanceFunctionBlockModel element, Point newConstraint)
	{
		this.newConstraint = newConstraint;
    this.oldConstraint = element.getLocation();
		this.model = element;		
	}
	
	public void execute()
	{
		model.setLocation(newConstraint);
    addjustParameters();
	}
	
	public void undo()
	{
		model.setLocation(oldConstraint);
    addjustParameters();
	}
  
  private CompositeFunctionBlockModel getParentFunctionBlock()
  {
    return (CompositeFunctionBlockModel)model.getNetworkModel().getParent();
  }
  
  private void addjustParameters()
  {
    for (ParameterModel event : model.getParameters())
    {
      event.firePropertyChange(ObjectModel.PROPERTY_POSITION_CHANGED,oldConstraint,newConstraint);
    }
  }
}
