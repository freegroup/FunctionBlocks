package de.netallied.functionblock.modeleditor.fbt.network.command;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.commands.Command;

import de.netallied.functionblock.model.AbstractTransitionModel;
import de.netallied.functionblock.model.CompositeInputEventModel;
import de.netallied.functionblock.model.CompositeOutputEventModel;
import de.netallied.functionblock.model.CompositeOutputValueModel;
import de.netallied.functionblock.model.EventTransitionModel;
import de.netallied.functionblock.model.InputEventModel;
import de.netallied.functionblock.model.InputValueModel;
import de.netallied.functionblock.model.InstanceFunctionBlockModel;
import de.netallied.functionblock.model.CompositeFunctionBlockModel;
import de.netallied.functionblock.model.NetworkModel;
import de.netallied.functionblock.model.OutputEventModel;
import de.netallied.functionblock.model.OutputValueModel;
import de.netallied.functionblock.model.ValueTransitionModel;


public class DeleteCompositeOutputValueCommand extends Command
{
  private final NetworkModel   parent;
  private final CompositeOutputValueModel  child;
  
  private final List<ValueTransitionModel> valueTransistions= new ArrayList<ValueTransitionModel>();

  public DeleteCompositeOutputValueCommand(NetworkModel parent, CompositeOutputValueModel model) 
  {
  	this.parent = parent;
  	this.child = model;
	}

	/*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.commands.Command#execute()
   */
  public void execute()
  {
    valueTransistions.addAll(parent.getTargetTransitions(child));
  	// ...so - jetzt kann auch das eigentliche Element entfernt werden
  	//
    for(ValueTransitionModel trans : valueTransistions)
    {
      parent.removeElement(trans);
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.commands.Command#undo()
   */
  public void undo()
  {
    // ...so - jetzt kann auch das eigentliche Element entfernt werden
    //
    for(ValueTransitionModel trans : valueTransistions)
    {
      parent.addElement(trans);
    }
  }
}
