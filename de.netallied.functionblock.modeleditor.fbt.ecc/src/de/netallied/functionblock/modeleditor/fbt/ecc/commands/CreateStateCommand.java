package de.netallied.functionblock.modeleditor.fbt.ecc.commands;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;
import de.netallied.functionblock.model.ECCAbstractStateModel;
import de.netallied.functionblock.model.ECCDiagramModel;
/**
 * A command to add a ECCAbstractStateModel to a ShapeDiagram. The command can
 * be undone or redone.
 * 
 */
public class CreateStateCommand extends Command
{
  private ECCAbstractStateModel child;
  private final ECCDiagramModel parent;
  private final Point pos ;
  public CreateStateCommand(ECCAbstractStateModel newShape, ECCDiagramModel parent, Point pos)
  {
    this.parent= parent;
    this.child = newShape;
    this.pos   = pos;
    setLabel("state creation");
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.commands.Command#execute()
   */
  public void execute()
  {
    parent.addElement(child);
    this.child.setLocation(pos);
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