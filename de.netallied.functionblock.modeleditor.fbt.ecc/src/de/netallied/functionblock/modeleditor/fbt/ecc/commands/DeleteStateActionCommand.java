package de.netallied.functionblock.modeleditor.fbt.ecc.commands;

import java.util.Iterator;
import java.util.List;
import org.eclipse.gef.commands.Command;
import de.netallied.functionblock.model.ECCAbstractStateModel;
import de.netallied.functionblock.model.ECCDiagramModel;
import de.netallied.functionblock.model.ECCStateActionModel;
import de.netallied.functionblock.model.ECCStateModel;
import de.netallied.functionblock.model.ECCTransitionModel;

/**
 * A command to remove a shape from its parent. The command can be undone or
 * redone.
 * 
 */
public class DeleteStateActionCommand extends Command
{
  private final ECCStateActionModel child;
  private final ECCStateModel       parent;

  public DeleteStateActionCommand(ECCStateModel parent, ECCStateActionModel child)
  {
    if (parent == null || child == null)
    {
      throw new IllegalArgumentException();
    }
    setLabel("action deletion");
    this.parent = parent;
    this.child = child;
  }


  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.commands.Command#execute()
   */
  public void execute()
  {
    parent.removeElement(child);
  }


  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.commands.Command#undo()
   */
  public void undo()
  {
    parent.addElement(child);
  }

}