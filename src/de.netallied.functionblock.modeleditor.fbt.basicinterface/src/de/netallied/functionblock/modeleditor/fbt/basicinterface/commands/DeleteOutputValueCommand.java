package de.netallied.functionblock.modeleditor.fbt.basicinterface.commands;

import org.eclipse.gef.commands.Command;
import de.netallied.functionblock.model.AbstractFunctionBlockModel;
import de.netallied.functionblock.model.OutputValueModel;
import de.netallied.functionblock.model.OutputValueSegmentModel;

/**
 * Command to delete a event object
 * 
 */
public class DeleteOutputValueCommand extends Command
{
	private AbstractFunctionBlockModel parent;
	private OutputValueModel           value;
	
  private int index = -1;

  public DeleteOutputValueCommand(OutputValueModel value)
  {
    this.parent = value.getAbstractFunctionBlockModel();
    this.value  = value;
    this.index  = this.parent.getOutputValueModels().indexOf(value);
  }
  
	/**
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	public void execute()
	{
    parent.removeElement(value);
	}

	/**
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	public void undo()
	{
		parent.addElement(index,value);
	}

}

