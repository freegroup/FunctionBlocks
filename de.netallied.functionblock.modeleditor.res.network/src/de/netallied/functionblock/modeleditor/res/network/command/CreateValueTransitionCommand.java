package de.netallied.functionblock.modeleditor.res.network.command;

import java.util.List;
import org.eclipse.gef.commands.Command;

import de.netallied.functionblock.model.AbstractSourceModel;
import de.netallied.functionblock.model.AbstractTargetModel;
import de.netallied.functionblock.model.AbstractTransitionModel;
import de.netallied.functionblock.model.EventTransitionModel;
import de.netallied.functionblock.model.InputValueModel;
import de.netallied.functionblock.model.CompositeFunctionBlockModel;
import de.netallied.functionblock.model.InstanceInputValueModel;
import de.netallied.functionblock.model.InstanceOutputValueModel;
import de.netallied.functionblock.model.NetworkModel;
import de.netallied.functionblock.model.OutputValueModel;
import de.netallied.functionblock.model.ParameterModel;
import de.netallied.functionblock.model.TransitionModel;
import de.netallied.functionblock.model.ValueTransitionModel;


public class CreateValueTransitionCommand extends Command
{
  NetworkModel network;
  InstanceOutputValueModel source;
  InstanceInputValueModel target;
  ValueTransitionModel   connection;
  
  List<AbstractTransitionModel> trans;
  
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
  public CreateValueTransitionCommand(NetworkModel ruleset, InstanceOutputValueModel start)
  {
    this.source  = start;
    this.network = ruleset;
  }

  public void execute()
  {
    // Ein Eingang kann nur von einer Seite "versorgt" werden. Allte Verbindungen kappen (z.B. Parameter)
    // und diese für das undo vormerken
    //
    trans= target.getInstanceFunctionBlockModel().getNetworkModel().getTargetTransitions(target);
    for (AbstractTransitionModel t : trans)
    {
      network.removeElement(t);
    }
    
  	if(connection==null)
  		connection = new ValueTransitionModel(network, source, target);
 		network.addElement(connection);
  }

  public void undo()
  {
  	network.removeElement(connection);
    for (AbstractTransitionModel t : trans)
    {
      network.addElement(t);
    }
  }
  
  public void setTargetModel(InstanceInputValueModel target)
  {
    this.target = target;
  }
  
  public AbstractSourceModel getSourceModel()
  {
    return this.source;
  }
}
