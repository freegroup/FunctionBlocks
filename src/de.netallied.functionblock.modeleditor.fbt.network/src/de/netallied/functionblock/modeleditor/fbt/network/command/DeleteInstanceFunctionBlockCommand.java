package de.netallied.functionblock.modeleditor.fbt.network.command;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.commands.Command;

import de.netallied.functionblock.model.AbstractTransitionModel;
import de.netallied.functionblock.model.EventTransitionModel;
import de.netallied.functionblock.model.InputEventModel;
import de.netallied.functionblock.model.InputValueModel;
import de.netallied.functionblock.model.InstanceFunctionBlockModel;
import de.netallied.functionblock.model.CompositeFunctionBlockModel;
import de.netallied.functionblock.model.NetworkModel;
import de.netallied.functionblock.model.OutputEventModel;
import de.netallied.functionblock.model.OutputValueModel;
import de.netallied.functionblock.model.ValueTransitionModel;


public class DeleteInstanceFunctionBlockCommand extends Command
{
  private final NetworkModel   parent;
  private final InstanceFunctionBlockModel  child;
  
  private final List<AbstractTransitionModel>  valueTransistions= new ArrayList<AbstractTransitionModel>();
  private final List<EventTransitionModel>  eventTransistions= new ArrayList<EventTransitionModel>();

  public DeleteInstanceFunctionBlockCommand(NetworkModel parent, InstanceFunctionBlockModel child) 
  {
  	this.parent = parent;
  	this.child = child;
	}
  
	/*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.commands.Command#execute()
   */
  public void execute()
  {
  	// Alle Verbindungen zu/weg von diesem Model aufsammeln
  	//
  	for (OutputValueModel port : child.getOutputValueModels()) 
  	{
			valueTransistions.addAll(parent.getSourceTransitions(port));
		}
  	for(InputValueModel port : child.getInputValueModels()) 
  	{
			valueTransistions.addAll(parent.getTargetTransitions(port));
		}
  	for (OutputEventModel port : child.getOutputEventModels()) 
  	{
			eventTransistions.addAll(parent.getSourceTransitions(port));
		}
  	for (InputEventModel port : child.getInputEventModels()) 
  	{
			eventTransistions.addAll(parent.getTargetTransitions(port));
		}
  	
  	// alle Verbindungen von dem Model löschen
  	//
  	for (AbstractTransitionModel transition : valueTransistions) 
  	{
  		parent.removeElement(transition);
		}
  	for (EventTransitionModel transition : eventTransistions) 
  	{
  		parent.removeElement(transition);
		}
  	// ...so - jetzt kann auch das eigentliche Element entfernt werden
  	//
  	parent.removeElement(child);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.commands.Command#undo()
   */
  public void undo()
  {
  	// Das model wieder einfügen
  	//
  	parent.addElement(child);
  	
  	// alle Verbindungen des Models wieder restaurieren
  	//
  	for (AbstractTransitionModel transition : valueTransistions) 
  	{
  		parent.addElement(transition);
		}
  	for (EventTransitionModel transition : eventTransistions) 
  	{
  		parent.addElement(transition);
		}
  }
}
