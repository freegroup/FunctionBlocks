package de.netallied.functionblock.modeleditor.fbt.ecc.commands;
import org.eclipse.gef.commands.Command;
import de.netallied.functionblock.model.ECCDiagramModel;
import de.netallied.functionblock.model.ECCTransitionModel;
/**
 * A command to disconnect (remove) a eCCTransition from its endpoints. The
 * command can be undone or redone.
 */
public class ConnectionDeleteCommand extends Command
{
  /** ECCTransitionModel instance to disconnect. */
  private final ECCTransitionModel connection;
  private final ECCDiagramModel diagram;

  /**
   * Create a command that will disconnect a eCCTransition from its endpoints.
   * 
   * @param conn
   *          the eCCTransition instance to disconnect (non-null)
   * @throws IllegalArgumentException
   *           if conn is null
   */
  public ConnectionDeleteCommand(ECCDiagramModel diagram, ECCTransitionModel conn)
  {
    if (conn == null)
    {
      throw new IllegalArgumentException();
    }
    setLabel("ECCTransition deletion");
    this.connection = conn;
    this.diagram = diagram;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.commands.Command#execute()
   */
  public void execute()
  {
    diagram.removeElement(connection);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.commands.Command#undo()
   */
  public void undo()
  {
    diagram.addElement(connection);
    connection.connect(connection.getSource(), connection.getTarget());
  }
}
