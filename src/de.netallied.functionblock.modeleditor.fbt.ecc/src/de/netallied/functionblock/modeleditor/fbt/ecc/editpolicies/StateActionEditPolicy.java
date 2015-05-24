/*******************************************************************************
 * Copyright (c) 2005, 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
/*
 * Created on Jul 15, 2004
 */
package de.netallied.functionblock.modeleditor.fbt.ecc.editpolicies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;
import de.netallied.functionblock.modeleditor.fbt.ecc.commands.DeleteStateActionCommand;
import de.netallied.functionblock.model.ECCStateActionModel;
import de.netallied.functionblock.model.ECCStateModel;

/**
 * Column component EditPolicy - handles column deletion
 */
public class StateActionEditPolicy extends ComponentEditPolicy
{

	protected Command createDeleteCommand(GroupRequest request)
	{
    System.out.println("createDeleteCommand StateAction");
    ECCStateModel parent = (ECCStateModel) (getHost().getParent().getModel());
    return new DeleteStateActionCommand(parent, (ECCStateActionModel) (getHost().getModel()));
	}
}