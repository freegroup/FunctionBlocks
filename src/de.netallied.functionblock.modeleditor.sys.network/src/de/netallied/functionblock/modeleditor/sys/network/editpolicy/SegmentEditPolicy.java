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
package de.netallied.functionblock.modeleditor.sys.network.editpolicy;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;
import de.netallied.functionblock.model.SegmentModel;
import de.netallied.functionblock.model.SystemModel;
import de.netallied.functionblock.modeleditor.sys.network.command.DeleteSegmentCommand;

public class SegmentEditPolicy extends ComponentEditPolicy 
{

  /* (non-Javadoc)
   * @see org.eclipse.gef.editpolicies.ComponentEditPolicy#createDeleteCommand(org.eclipse.gef.requests.GroupRequest)
   */
  public Command createDeleteCommand(GroupRequest deleteRequest) 
  {
  	Object parent = getHost().getParent().getModel();
  	Object child = getHost().getModel();

    if (parent instanceof SystemModel && child instanceof SegmentModel) 
  		return new DeleteSegmentCommand((SystemModel) parent, (SegmentModel) child);
  	return super.createDeleteCommand(deleteRequest);
  }
}