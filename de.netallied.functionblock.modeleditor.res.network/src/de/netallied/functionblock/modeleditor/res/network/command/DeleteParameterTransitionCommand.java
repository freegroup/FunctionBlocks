package de.netallied.functionblock.modeleditor.res.network.command;

import org.eclipse.gef.commands.Command;

import de.netallied.functionblock.model.AbstractTransitionModel;
import de.netallied.functionblock.model.EventTransitionModel;
import de.netallied.functionblock.model.ParameterTransitionModel;


public class DeleteParameterTransitionCommand extends Command
{
  private final ParameterTransitionModel connection;
  
  /**
   * Create a command that will disconnect a connection from its endpoints.
   * 
   * @param conn
   *          the connection instance to disconnect (non-null)
   * @throws IllegalArgumentException
   *           if conn is null
   */
  public DeleteParameterTransitionCommand(ParameterTransitionModel conn)
  {
    setLabel("connection deletion");
    this.connection = conn;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.commands.Command#execute()
   */
  public void execute()
  {
    connection.getNetworkFunctionBlockModel().removeElement(connection);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.commands.Command#undo()
   */
  public void undo()
  {
    connection.getNetworkFunctionBlockModel().addElement(connection);
  }
}
