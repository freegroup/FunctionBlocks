package de.netallied.functionblock.modeleditor.fbt.basicinterface.commands;
import org.eclipse.gef.commands.Command;
import de.netallied.functionblock.model.BasisFunctionBlockModel;
import de.netallied.functionblock.model.WithTransitionInModel;
import de.netallied.functionblock.model.WithTransitionOutModel;
/**
 * A command to disconnect (remove) a eCCTransition from its endpoints. The
 * command can be undone or redone.
 */
public class DeleteWithTransitionOutCommand extends Command
{
  private final WithTransitionOutModel connection;
  private final BasisFunctionBlockModel fb;
  /**
   * Create a command that will disconnect a eCCTransition from its endpoints.
   * @param fb 
   * 
   * @param conn
   *          the eCCTransition instance to disconnect (non-null)
   * @throws IllegalArgumentException
   *           if conn is null
   */
  public DeleteWithTransitionOutCommand(BasisFunctionBlockModel fb, WithTransitionOutModel conn)
  {
    setLabel("WITH deletion");
    this.connection = conn;
    this.fb = fb;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.commands.Command#execute()
   */
  public void execute()
  {
    fb.removeElement(connection);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.commands.Command#undo()
   */
  public void undo()
  {
    fb.addElement(connection);
  }
}
