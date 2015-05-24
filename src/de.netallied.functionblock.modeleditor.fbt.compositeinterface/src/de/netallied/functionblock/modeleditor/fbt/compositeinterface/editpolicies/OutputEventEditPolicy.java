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
package de.netallied.functionblock.modeleditor.fbt.compositeinterface.editpolicies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;
import de.netallied.functionblock.modeleditor.fbt.compositeinterface.commands.DeleteOutputEventCommand;
import de.netallied.functionblock.model.OutputEventModel;
import de.netallied.functionblock.model.OutputEventSegmentModel;

/**
 * Column component EditPolicy - handles column deletion
 * @author Phil Zoio
 */
public class OutputEventEditPolicy extends ComponentEditPolicy
{

	protected Command createDeleteCommand(GroupRequest request)
	{
    return new DeleteOutputEventCommand((OutputEventModel) (getHost().getModel()));
	}
}