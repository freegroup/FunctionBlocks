package de.netallied.functionblock.modeleditor.fbt.compositeinterface.commands;

import org.eclipse.gef.commands.Command;

import de.netallied.functionblock.model.AbstractFunctionBlockModel;
import de.netallied.functionblock.model.InputEventModel;
import de.netallied.functionblock.model.InputEventSegmentModel;
import de.netallied.functionblock.model.OutputEventModel;
import de.netallied.functionblock.model.OutputEventSegmentModel;
import de.netallied.functionblock.model.OutputValueModel;
import de.netallied.functionblock.model.OutputValueSegmentModel;


public class CreateOutputValueCommand extends Command
{
	private AbstractFunctionBlockModel parent;
	private OutputValueModel        event;
	private int                    index;
	
  public CreateOutputValueCommand(AbstractFunctionBlockModel model, int index)
  {
    this.parent = model;
    this.index  = index;
    setLabel("port creation");
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.commands.Command#execute()
   */
  public void execute()
  {
  	if(event==null)
    {
      String template = "O_VALUE";
      String newName  = template;
      int counter =1;
      while(parent.getOutputValueModel(newName)!=null)
        newName = template+"_"+counter++;
  		event = new OutputValueModel(parent, newName);
    }
    parent.addElement(index,event);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.commands.Command#undo()
   */
  public void undo()
  {
    parent.removeElement(event);
  }
}