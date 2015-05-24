package de.netallied.functionblock.modeleditor.fbt.ecc.commands;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;
import de.netallied.functionblock.model.ECCAbstractStateModel;
import de.netallied.functionblock.model.ECCDiagramModel;
import de.netallied.functionblock.model.ECCStateActionModel;
/**
 * A command to add a ECCAbstractStateModel to a ShapeDiagram. The command can
 * be undone or redone.
 * 
 */
public class CreateStateActionCommand extends Command
{
  private final ECCAbstractStateModel parent;
  private final ECCStateActionModel   child;

  public CreateStateActionCommand(ECCAbstractStateModel parent, ECCStateActionModel child)
  {
    this.parent= parent;
    this.child = child;
    setLabel("action creation");
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.commands.Command#execute()
   */
  public void execute()
  {
    parent.addElement(child);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.commands.Command#undo()
   */
  public void undo()
  {
    parent.removeElement(child);
  }
}