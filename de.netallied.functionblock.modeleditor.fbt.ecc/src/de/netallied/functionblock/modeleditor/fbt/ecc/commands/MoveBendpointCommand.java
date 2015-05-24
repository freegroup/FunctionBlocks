/*
 * Created on 01.08.2006
 *
 */
package de.netallied.functionblock.modeleditor.fbt.ecc.commands;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;
import de.netallied.functionblock.model.ECCTransitionModel;

public class MoveBendpointCommand extends Command
{
  private final Point newFulcrum;
  private final Point oldFulcrum;
  private final ECCTransitionModel model;
  
  public MoveBendpointCommand(ECCTransitionModel model, Point fulcrum)
  {
    this.model = model;
    this.newFulcrum = fulcrum;
    this.oldFulcrum = model.getFulcrum();
  }
  
  public void execute() 
  {
    model.setFulcrum(newFulcrum);
  }

  public void undo() 
  {
    model.setFulcrum(oldFulcrum);
  }
}

