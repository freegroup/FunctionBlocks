package de.netallied.functionblock.modeleditor.fbt.compositeinterface.commands;

import org.eclipse.gef.commands.Command;

import de.netallied.functionblock.model.AbstractFunctionBlockModel;
import de.netallied.functionblock.model.InputEventModel;
import de.netallied.functionblock.model.InputEventSegmentModel;
import de.netallied.functionblock.model.InputValueModel;
import de.netallied.functionblock.model.InputValueSegmentModel;


public class CreateInputValueCommand extends Command
{
	private AbstractFunctionBlockModel parent;
	private InputValueModel        event;
	private int                    index;
	
  public CreateInputValueCommand(AbstractFunctionBlockModel parent, int index)
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
      String template = "I_VALUE";
      String newName  = template;
      int counter =1;
      while(parent.getInputValueModel(newName)!=null)
        newName = template+"_"+counter++;
  		event = new InputValueModel(parent, newName);
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