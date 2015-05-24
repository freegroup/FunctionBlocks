package de.netallied.functionblock.modeleditor.fbt.network.command;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.commands.Command;

import de.netallied.functionblock.model.AbstractTransitionModel;
import de.netallied.functionblock.model.CompositeInputEventModel;
import de.netallied.functionblock.model.CompositeInputValueModel;
import de.netallied.functionblock.model.EventTransitionModel;
import de.netallied.functionblock.model.InputEventModel;
import de.netallied.functionblock.model.InputValueModel;
import de.netallied.functionblock.model.InstanceFunctionBlockModel;
import de.netallied.functionblock.model.CompositeFunctionBlockModel;
import de.netallied.functionblock.model.NetworkModel;
import de.netallied.functionblock.model.OutputEventModel;
import de.netallied.functionblock.model.OutputValueModel;
import de.netallied.functionblock.model.ValueTransitionModel;


public class DeleteCompositeInputValueCommand extends Command
{
  private final NetworkModel   parent;
  private final CompositeInputValueModel  child;
  
  private final List<ValueTransitionModel>  valueTransistions= new ArrayList<ValueTransitionModel>();

  public DeleteCompositeInputValueCommand(NetworkModel parent, CompositeInputValueModel model) 
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
    valueTransistions.addAll(parent.getSourceTransitions(child));
  	// ...so - jetzt kann auch das eigentliche Element entfernt werden
  	//
    for (ValueTransitionModel trans : valueTransistions)
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
    for (ValueTransitionModel trans : valueTransistions)
    {
      parent.addElement(trans);
    }
  }
}
