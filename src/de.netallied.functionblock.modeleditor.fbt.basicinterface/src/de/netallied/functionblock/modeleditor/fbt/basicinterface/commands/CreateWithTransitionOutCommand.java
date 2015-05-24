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
package de.netallied.functionblock.modeleditor.fbt.basicinterface.commands;
import org.eclipse.gef.commands.Command;
import de.netallied.functionblock.model.OutputEventModel;
import de.netallied.functionblock.model.OutputValueModel;
import de.netallied.functionblock.model.BasisFunctionBlockModel;
import de.netallied.functionblock.model.WithTransitionOutModel;
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
public class CreateWithTransitionOutCommand extends Command
{
  private WithTransitionOutModel connection;
  private OutputEventModel source;
  private OutputValueModel target;

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
  public CreateWithTransitionOutCommand(OutputEventModel source)
  {
    setLabel("WITH creation");
    this.source = source;
  }

  public CreateWithTransitionOutCommand(OutputValueModel target)
  {
    setLabel("WITH creation");
    this.target = target;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.commands.Command#execute()
   */
  public void execute()
  {
    // create a new connection between source and target
    if(connection==null)
      connection = new WithTransitionOutModel(source, target);
    
    ((BasisFunctionBlockModel)source.getAbstractFunctionBlockModel()).addElement(connection);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.commands.Command#undo()
   */
  public void undo()
  {
    ((BasisFunctionBlockModel)source.getAbstractFunctionBlockModel()).removeElement(connection);
  }
  
  /**
   * Set the target endpoint for the connection.
   * 
   * @param target
   *          that target endpoint (a non-null Shape instance)
   * @throws IllegalArgumentException
   *           if target is null
   */
  public void setTarget(OutputValueModel target)
  {
    this.target = target;
  }

  public void setSource(OutputEventModel source)
  {
    this.source = source;
  }

  public OutputEventModel getSource()
  {
    return source;
  }

  public OutputValueModel getTarget()
  {
    return target;
  }
}
