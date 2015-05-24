package de.netallied.functionblock.modeleditor.fbt.basicinterface.commands;
import org.eclipse.gef.commands.Command;
import de.netallied.functionblock.model.BasisFunctionBlockModel;
import de.netallied.functionblock.model.WithTransitionInModel;
/**
 * A command to disconnect (remove) a eCCTransition from its endpoints. The
 * command can be undone or redone.
 */
public class DeleteWithTransitionInCommand extends Command
{
  private final WithTransitionInModel connection;
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
  public DeleteWithTransitionInCommand(BasisFunctionBlockModel fb, WithTransitionInModel conn)
  {
    if (conn == null)
    {
      throw new IllegalArgumentException();
    }
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
