/*******************************************************************************
 * Copyright (c) 2004, 2005 Elias Volanakis and others.
  * All rights reserved. This program and the accompanying materials
  * are made available under the terms of the Eclipse Public License v1.0
  * which accompanies this distribution, and is available at
  * http://www.eclipse.org/legal/epl-v10.html
  *
  * Contributors:
  *    Elias Volanakis - initial API and implementation
  *******************************************************************************/
package de.netallied.functionblock.modeleditor.fbt.ecc.commands;
import java.util.Iterator;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;
import de.netallied.functionblock.model.ECCAbstractStateModel;
import de.netallied.functionblock.model.ECCTransitionModel;
/**
 * A command to create a eCCTransition between two shapes. The command can be
 * undone or redone.
 * <p>
 * This command is designed to be used together with a GraphicalNodeEditPolicy.
 * To use this command properly, following steps are necessary:
 * </p>
 * <ol>
 * <li>Create a subclass of GraphicalNodeEditPolicy.</li>
 * <li>Override the <tt>getConnectionCreateCommand(...)</tt> method, to
 * create a new instance of this class and put it into the
 * CreateConnectionRequest.</li>
 * <li>Override the <tt>getConnectionCompleteCommand(...)</tt> method, to
 * obtain the Command from the ConnectionRequest, call setTarget(...) to set the
 * target endpoint of the eCCTransition and return this command instance.</li>
 * </ol>
 * 
 * @see org.eclipse.gef.examples.shapes.parts.StateEditPart#createEditPolicies()
 *      for an example of the above procedure.
 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy
 * @author Elias Volanakis
 */
public class ConnectionCreateCommand extends Command
{
  private ECCTransitionModel connection;
  private final ECCAbstractStateModel source;
  private ECCAbstractStateModel target;

  /**
   * Instantiate a command that can create a connection between two shapes.
   * 
   * @param source
   *          the source endpoint (a non-null Shape instance)
   * @param lineStyle
   *          the desired line style. See LinkModel#setLineStyle(int) for
   *          details
   * @throws IllegalArgumentException
   *           if source is null
   */
  public ConnectionCreateCommand(ECCAbstractStateModel source)
  {
    if (source == null)
    {
      throw new IllegalArgumentException();
    }
    setLabel("connection creation");
    this.source = source;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.commands.Command#canExecute()
   */
  public boolean canExecute()
  {
    // disallow source -> source connections
    if (source.equals(target))
    {
      return false;
    }
    // return false, if the source -> target connection exists already
    for (Iterator iter = source.getSourceConnections().iterator(); iter.hasNext();)
    {
      ECCTransitionModel conn = (ECCTransitionModel) iter.next();
      if (conn.getTarget().equals(target))
      {
        return false;
      }
    }
    return true;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.commands.Command#execute()
   */
  public void execute()
  {
    // create a new connection between source and target
    connection = new ECCTransitionModel(source, target);
    source.getParentModel().addElement(connection);
    connection.connect(source, target); // hack
    Point fulcrum = new Point();
    fulcrum.x = (source.getLocation().x+target.getLocation().x)/2;
    fulcrum.y = (source.getLocation().y+target.getLocation().y)/2;
    connection.setFulcrum(fulcrum);
  }

  /**
   * Set the target endpoint for the connection.
   * 
   * @param target
   *          that target endpoint (a non-null Shape instance)
   * @throws IllegalArgumentException
   *           if target is null
   */
  public void setTarget(ECCAbstractStateModel target)
  {
    if (target == null)
    {
      throw new IllegalArgumentException();
    }
    this.target = target;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.commands.Command#undo()
   */
  public void undo()
  {
    source.getParentModel().removeElement(connection);
  }
}
