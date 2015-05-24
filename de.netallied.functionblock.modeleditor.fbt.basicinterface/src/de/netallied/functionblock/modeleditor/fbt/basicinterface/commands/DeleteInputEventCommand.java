package de.netallied.functionblock.modeleditor.fbt.basicinterface.commands;

import org.eclipse.gef.commands.Command;
import de.netallied.functionblock.model.AbstractFunctionBlockModel;
import de.netallied.functionblock.model.InputEventModel;
import de.netallied.functionblock.model.InputEventSegmentModel;

/**
 * Command to delete a event object
 * 
 */
public class DeleteInputEventCommand extends Command
{
  private AbstractFunctionBlockModel parent;
  private InputEventModel            event;
  
  private int index = -1;

  public DeleteInputEventCommand(InputEventModel event)
  {
    this.parent = event.getAbstractFunctionBlockModel();
    this.event  = event;
    this.index  = this.parent.getInputEventModels().indexOf(event);
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

