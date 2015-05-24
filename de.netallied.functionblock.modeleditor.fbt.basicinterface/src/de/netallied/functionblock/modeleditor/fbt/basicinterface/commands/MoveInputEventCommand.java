package de.netallied.functionblock.modeleditor.fbt.basicinterface.commands;

import org.eclipse.gef.commands.Command;
import de.netallied.functionblock.model.InputEventModel;
import de.netallied.functionblock.model.InputEventSegmentModel;

/**
 * Command to move a InputEventPort to a different index location within the InputEventSegment
 * 
 */
public class MoveInputEventCommand extends Command
{
	private int oldIndex;
  private int newIndex;
	private InputEventModel childColumn;
	private InputEventSegmentModel parentTable;

	public MoveInputEventCommand(InputEventModel child, InputEventSegmentModel parent, int oldIndex, int newIndex)
	{
		this.childColumn = child;
		this.parentTable = parent;
		this.oldIndex = oldIndex;
		this.newIndex = newIndex;
    
    if (this.newIndex > this.oldIndex)
      this.newIndex--; //this is because the column is deleted before it is
	}

  @Override
	public void execute()
	{
		parentTable.setFieldPosition(childColumn, newIndex);
	}

  @Override
	public void undo()
	{
		parentTable.setFieldPosition(childColumn, oldIndex);
	}

}