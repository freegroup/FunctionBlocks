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
import org.eclipse.gef.commands.Command;
import de.netallied.functionblock.model.ECCAbstractStateModel;
import de.netallied.functionblock.model.ECCTransitionModel;


/**
 * A command to reconnect a eCCTransition to a different start point or end point.
 * The command can be undone or redone.
 * <p>
 * This command is designed to be used together with a GraphicalNodeEditPolicy.
 * To use this command propertly, following steps are necessary:
 * </p>
 * <ol>
 * <li>Create a subclass of GraphicalNodeEditPolicy.</li>
 * <li>Override the <tt>getReconnectSourceCommand(...)</tt> method.
 * Here you need to obtain the ECCTransitionModel model element from the ReconnectRequest,
 * create a new ConnectionReconnectCommand, set the new eCCTransition <i>source</i> by calling
 * the <tt>setNewSource(ECCAbstractStateModel)</tt> method and return the command instance.
 * <li>Override the <tt>getReconnectTargetCommand(...)</tt> method.</li>
 * Here again you need to obtain the ECCTransitionModel model element from the ReconnectRequest,
 * create a new ConnectionReconnectCommand, set the new eCCTransition <i>target</i> by calling
 * the <tt>setNewTarget(ECCAbstractStateModel)</tt> method and return the command instance.</li>
 * </ol>
 * @see org.eclipse.gef.examples.shapes.parts.StateEditPart#createEditPolicies() for an
 * 			 example of the above procedure.
 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy
 * @see #setNewSource(ECCAbstractStateModel)
 * @see #setNewTarget(ECCAbstractStateModel)
 * @author Elias Volanakis
 */
public class ConnectionReconnectCommand extends Command {

/** The eCCTransition instance to reconnect. */
private ECCTransitionModel eCCTransition;
/** The new source endpoint. */
private ECCAbstractStateModel newSource;
/** The new target endpoint. */
private ECCAbstractStateModel newTarget;
/** The original source endpoint. */
private final ECCAbstractStateModel oldSource;
/** The original target endpoint. */
private final ECCAbstractStateModel oldTarget;

/**
 * Instantiate a command that can reconnect a ECCTransitionModel instance to a different source
 * or target endpoint.
 * @param conn the eCCTransition instance to reconnect (non-null)
 * @throws IllegalArgumentException if conn is null
 */
public ConnectionReconnectCommand(ECCTransitionModel conn) {
	if (conn == null) {
		throw new IllegalArgumentException();
	}
	this.eCCTransition = conn;
	this.oldSource = conn.getSource();
	this.oldTarget = conn.getTarget();
}

/* (non-Javadoc)
 * @see org.eclipse.gef.commands.Command#canExecute()
 */
public boolean canExecute() {
	if (newSource != null) {
		return checkSourceReconnection();
	} else if (newTarget != null) {
		return checkTargetReconnection();
	}
	return false;
}

/**
 * Return true, if reconnecting the eCCTransition-instance to newSource is allowed.
 */
private boolean checkSourceReconnection() {
	// eCCTransition endpoints must be different Shapes
	if (newSource.equals(oldTarget)) {
		return false;
	}
	// return false, if the eCCTransition exists already
	for (Iterator iter = newSource.getSourceConnections().iterator(); iter.hasNext();) {
		ECCTransitionModel conn = (ECCTransitionModel) iter.next();
		// return false if a newSource -> oldTarget eCCTransition exists already
		// and it is a different instance than the eCCTransition-field
		if (conn.getTarget().equals(oldTarget) &&  !conn.equals(eCCTransition)) {
			return false;
		}
	}
	return true;
}

/**
 * Return true, if reconnecting the eCCTransition-instance to newTarget is allowed. 
 */
private boolean checkTargetReconnection() {
	// eCCTransition endpoints must be different Shapes
	if (newTarget.equals(oldSource)) {
		return false;
	}
	// return false, if the eCCTransition exists already
	for (Iterator iter = newTarget.getTargetConnections().iterator(); iter.hasNext();) {
		ECCTransitionModel conn = (ECCTransitionModel) iter.next();
		// return false if a oldSource -> newTarget eCCTransition exists already
		// and it is a differenct instance that the eCCTransition-field
		if (conn.getSource().equals(oldSource) && !conn.equals(eCCTransition)) {
			return false;
		}
	}
	return true;
}

/**
 * Reconnect the eCCTransition to newSource (if setNewSource(...) was invoked before)
 * or newTarget (if setNewTarget(...) was invoked before).
 */
public void execute() {
	if (newSource != null) {
		eCCTransition.connect(newSource, oldTarget);
	} else if (newTarget != null) {
		eCCTransition.connect(oldSource, newTarget);
	} else {
		throw new IllegalStateException("Should not happen");
	}
}

/**
 * Set a new source endpoint for this eCCTransition.
 * When execute() is invoked, the source endpoint of the eCCTransition will be attached
 * to the supplied ECCAbstractStateModel instance.
 * <p>
 * Note: Calling this method, deactivates reconnection of the <i>target</i> endpoint.
 * A single instance of this command can only reconnect either the source or the target 
 * endpoint.
 * </p>
 * @param connectionSource a non-null ECCAbstractStateModel instance, to be used as a new source endpoint
 * @throws IllegalArgumentException if connectionSource is null
 */
public void setNewSource(ECCAbstractStateModel connectionSource) {
	if (connectionSource == null) {
		throw new IllegalArgumentException();
	}
	setLabel("move eCCTransition startpoint");
	newSource = connectionSource;
	newTarget = null;
}

/**
 * Set a new target endpoint for this eCCTransition
 * When execute() is invoked, the target endpoint of the eCCTransition will be attached
 * to the supplied ECCAbstractStateModel instance.
 * <p>
 * Note: Calling this method, deactivates reconnection of the <i>source</i> endpoint.
 * A single instance of this command can only reconnect either the source or the target 
 * endpoint.
 * </p>
 * @param connectionTarget a non-null ECCAbstractStateModel instance, to be used as a new target endpoint
 * @throws IllegalArgumentException if connectionTarget is null
 */
public void setNewTarget(ECCAbstractStateModel connectionTarget) {
	if (connectionTarget == null) {
		throw new IllegalArgumentException();
	}
	setLabel("move Transition endpoint");
	newSource = null;
	newTarget = connectionTarget;
}

/**
 * Reconnect the eCCTransition to its original source and target endpoints.
 */
public void undo() {
	eCCTransition.connect(oldSource, oldTarget);
}
	
}
