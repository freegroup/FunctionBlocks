package de.netallied.functionblock.modeleditor.fbt.network.command;

import org.eclipse.gef.commands.Command;

import de.netallied.functionblock.model.AbstractSourceModel;
import de.netallied.functionblock.model.AbstractTargetModel;
import de.netallied.functionblock.model.EventTransitionModel;
import de.netallied.functionblock.model.InputValueModel;
import de.netallied.functionblock.model.CompositeFunctionBlockModel;
import de.netallied.functionblock.model.NetworkModel;
import de.netallied.functionblock.model.OutputValueModel;
import de.netallied.functionblock.model.TransitionModel;
import de.netallied.functionblock.model.ValueTransitionModel;


public class CreateValueTransitionCommand extends Command
{
  NetworkModel network;
  OutputValueModel start;
  InputValueModel target;
  ValueTransitionModel   connection;
  
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
  public CreateValueTransitionCommand(NetworkModel ruleset, OutputValueModel start)
  {
    this.start   = start;
    this.network = ruleset;
  }

  public void execute()
  {
  	if(connection==null)
  		connection = new ValueTransitionModel(network, start, target);
 		network.addElement(connection);
  }

  public void undo()
  {
  	network.removeElement(connection);
  }
  
  public void setTargetModel(InputValueModel target)
  {
    this.target = target;
  }
  
  public AbstractSourceModel getSourceModel()
  {
    return this.start;
  }
  
  public NetworkModel getNetworkModel()
  {
    return network;
  }
}
