package de.netallied.functionblock.modeleditor.fbt.basicinterface.commands;

import org.eclipse.gef.commands.Command;
import de.netallied.functionblock.model.AbstractFunctionBlockModel;
import de.netallied.functionblock.model.InputValueModel;
import de.netallied.functionblock.model.InputValueSegmentModel;

/**
 * Command to delete a event object
 * 
 */
public class DeleteInputValueCommand extends Command
{
  private AbstractFunctionBlockModel parent;
  private InputValueModel        event;
  
  private int index = -1;

  public DeleteInputValueCommand(InputValueModel event)
  {
    this.parent = event.getAbstractFunctionBlockModel();
    this.event  = event;
    this.index  = this.parent.getInputValueModels().indexOf(event);
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

