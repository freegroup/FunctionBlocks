package de.netallied.functionblock.modeleditor.fbt.network.command;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;

import de.netallied.functionblock.model.CompositeFunctionBlockModel;
import de.netallied.functionblock.model.CompositeInputEventModel;
import de.netallied.functionblock.model.CompositeInputValueModel;
import de.netallied.functionblock.model.CompositeOutputEventModel;
import de.netallied.functionblock.model.CompositeOutputValueModel;
import de.netallied.functionblock.model.InstanceFunctionBlockModel;
import de.netallied.functionblock.model.ObjectModel;


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
    addjustCompositePorts();
	}
	
	public void undo()
	{
		model.setLocation(oldConstraint);
    addjustCompositePorts();
	}
  
  private CompositeFunctionBlockModel getParentFunctionBlock()
  {
    return (CompositeFunctionBlockModel)model.getNetworkModel().getParent();
  }
  
  private void addjustCompositePorts()
  {
    for (CompositeInputEventModel event : getParentFunctionBlock().getUsedCompositeInputEventModels())
    {
      event.firePropertyChange(ObjectModel.PROPERTY_POSITION_CHANGED,oldConstraint,newConstraint);
    }
    
    for (CompositeOutputEventModel event : getParentFunctionBlock().getUsedCompositeOutputEventModels())
    {
      event.firePropertyChange(ObjectModel.PROPERTY_POSITION_CHANGED,oldConstraint,newConstraint);
    }

    for (CompositeInputValueModel event : getParentFunctionBlock().getUsedCompositeInputValueModels())
    {
      event.firePropertyChange(ObjectModel.PROPERTY_POSITION_CHANGED,oldConstraint,newConstraint);
    }
    
    for (CompositeOutputValueModel event : getParentFunctionBlock().getUsedCompositeOutputValueModels())
    {
      event.firePropertyChange(ObjectModel.PROPERTY_POSITION_CHANGED,oldConstraint,newConstraint);
    }
  }
}
