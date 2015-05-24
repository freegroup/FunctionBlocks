package de.netallied.functionblock.modeleditor.fbt.network.command;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.commands.Command;

import de.netallied.functionblock.model.AbstractTransitionModel;
import de.netallied.functionblock.model.CompositeInputEventModel;
import de.netallied.functionblock.model.CompositeOutputEventModel;
import de.netallied.functionblock.model.EventTransitionModel;
import de.netallied.functionblock.model.InputEventModel;
import de.netallied.functionblock.model.InputValueModel;
import de.netallied.functionblock.model.InstanceFunctionBlockModel;
import de.netallied.functionblock.model.CompositeFunctionBlockModel;
import de.netallied.functionblock.model.NetworkModel;
import de.netallied.functionblock.model.OutputEventModel;
import de.netallied.functionblock.model.OutputValueModel;
import de.netallied.functionblock.model.ValueTransitionModel;


public class DeleteCompositeOutputEventCommand extends Command
{
  private final NetworkModel   parent;
  private final CompositeOutputEventModel  child;
  
  private final List<EventTransitionModel>  eventTransistions= new ArrayList<EventTransitionModel>();

  public DeleteCompositeOutputEventCommand(NetworkModel parent, CompositeOutputEventModel model) 
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
		eventTransistions.addAll(parent.getTargetTransitions(child));
  	// ...so - jetzt kann auch das eigentliche Element entfernt werden
  	//
    for (EventTransitionModel trans : eventTransistions)
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
    for (EventTransitionModel trans : eventTransistions)
    {
      parent.addElement(trans);
    }
  }
}
