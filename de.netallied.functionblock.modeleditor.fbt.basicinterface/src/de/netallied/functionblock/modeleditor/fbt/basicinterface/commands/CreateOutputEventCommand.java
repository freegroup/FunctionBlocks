package de.netallied.functionblock.modeleditor.fbt.basicinterface.commands;

import org.eclipse.gef.commands.Command;

import de.netallied.functionblock.model.AbstractFunctionBlockModel;
import de.netallied.functionblock.model.InputEventModel;
import de.netallied.functionblock.model.InputEventSegmentModel;
import de.netallied.functionblock.model.OutputEventModel;
import de.netallied.functionblock.model.OutputEventSegmentModel;


public class CreateOutputEventCommand extends Command
{
	private AbstractFunctionBlockModel parent;
	private OutputEventModel        event;
	private int                    index;
	
  public CreateOutputEventCommand(AbstractFunctionBlockModel parent, int index)
  {
    this.parent= parent;
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
      String template = "O_EVENT";
      String newName  = template;
      int counter =1;
      while(parent.getOutputEventModel(newName)!=null)
        newName = template+"_"+counter++;
  		event = new OutputEventModel(parent, newName);
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