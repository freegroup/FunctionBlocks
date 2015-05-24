package de.netallied.functionblock.modeleditor.res.network.command;

import org.eclipse.gef.commands.Command;

import de.netallied.functionblock.model.AbstractSourceModel;
import de.netallied.functionblock.model.AbstractTargetModel;
import de.netallied.functionblock.model.EventTransitionModel;
import de.netallied.functionblock.model.InputEventModel;
import de.netallied.functionblock.model.InputValueModel;
import de.netallied.functionblock.model.CompositeFunctionBlockModel;
import de.netallied.functionblock.model.NetworkModel;
import de.netallied.functionblock.model.OutputEventModel;
import de.netallied.functionblock.model.OutputValueModel;
import de.netallied.functionblock.model.TransitionModel;
import de.netallied.functionblock.model.ValueTransitionModel;


public class CreateEventTransitionCommand extends Command
{
  NetworkModel network;
  OutputEventModel start;
  InputEventModel target;
  EventTransitionModel     connection;
  
  /**
   * Instantiate a command that can create a connection between two shapes.
   * 
   * @param source
   *          the source endpoint (a non-null Shape instance)
   * @param lineStyle
   *          the desired line style. See LinkModel#setLineStyle(int) for
   *          details
   * @throws IllegalArgumentException
   *           if source is null
   * @see TransitionModel#setLineStyle(int)
   */
  public CreateEventTransitionCommand(NetworkModel ruleset, OutputEventModel start)
  {
    this.start   = start;
    this.network = ruleset;
  }

  public void execute()
  {
  	if(connection==null)
  		connection = new EventTransitionModel(network, start, target);
 		network.addElement(connection);
  }

  public void undo()
  {
  	network.removeElement(connection);
  }
  
  public void setTargetModel(InputEventModel target)
  {
    this.target = target;
  }
  
  public AbstractSourceModel getSourceModel()
  {
    return this.start;
  }
}
