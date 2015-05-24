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
import de.netallied.functionblock.model.DeviceModel;
import de.netallied.functionblock.model.SystemModel;
import de.netallied.functionblock.modeleditor.sys.network.command.DeleteDeviceCommand;
import de.netallied.functionblock.modeleditor.sys.network.editpart.SegmentEditPart;

/**
 * This edit policy enables the removal of a Shapes instance from its container. 
 * @see SegmentEditPart#createEditPolicies()
 * @see ShapeTreeEditPart#createEditPolicies()
 * @author Elias Volanakis
 */
public class DeviceEditPolicy extends ComponentEditPolicy 
{

  /* (non-Javadoc)
   * @see org.eclipse.gef.editpolicies.ComponentEditPolicy#createDeleteCommand(org.eclipse.gef.requests.GroupRequest)
   */
  public Command createDeleteCommand(GroupRequest deleteRequest) 
  {
  	Object parent = getHost().getParent().getModel();
  	Object child = getHost().getModel();
  	if (parent instanceof SystemModel && child instanceof DeviceModel) 
  		return new DeleteDeviceCommand((SystemModel) parent, (DeviceModel) child);
  
    return super.createDeleteCommand(deleteRequest);
  }
}