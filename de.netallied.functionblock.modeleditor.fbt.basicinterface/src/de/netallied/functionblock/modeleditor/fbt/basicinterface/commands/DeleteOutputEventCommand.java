package de.netallied.functionblock.modeleditor.fbt.basicinterface.commands;

import org.eclipse.gef.commands.Command;
import de.netallied.functionblock.model.AbstractFunctionBlockModel;
import de.netallied.functionblock.model.OutputEventModel;
import de.netallied.functionblock.model.OutputEventSegmentModel;

/**
 * Command to delete a event object
 * 
 * @author Phil Zoio
 */
public class DeleteOutputEventCommand extends Command
{
  private AbstractFunctionBlockModel parent;
  private OutputEventModel        event;
  
  private int index = -1;

  public DeleteOutputEventCommand(OutputEventModel event)
  {
    this.parent = event.getAbstractFunctionBlockModel();
    this.event  = event;
    this.index  = this.parent.getOutputEventModels().indexOf(event);
  }
  
  /**
   * @see org.eclipse.gef.commands.Command#execute()
   */
  public void execute()
  {
    parent.removeElement(event);
  }

  /**
   * @see org.eclipse.gef.commands.Command#undo()
   */
  public void undo()
  {
    parent.addElement(index,event);
  }
}

