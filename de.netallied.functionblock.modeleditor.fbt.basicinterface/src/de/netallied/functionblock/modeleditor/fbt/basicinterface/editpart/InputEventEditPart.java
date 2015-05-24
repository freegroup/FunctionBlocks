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
 * Created on Jul 13, 2004
 */
package de.netallied.functionblock.modeleditor.fbt.basicinterface.editpart;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import de.netallied.functionblock.modeleditor.fbt.basicinterface.commands.CreateWithTransitionInCommand;
import de.netallied.functionblock.modeleditor.fbt.basicinterface.editpart.anchor.LeftWithAnchor;
import de.netallied.functionblock.modeleditor.fbt.basicinterface.editpolicies.InputEventEditPolicy;
import de.netallied.functionblock.modeleditor.fbt.basicinterface.figures.InputEventFigure;
import de.netallied.functionblock.modeleditor.fbt.basicinterface.util.EditableLabelEditPart;
import de.netallied.functionblock.model.InputEventModel;
import de.netallied.functionblock.model.ObjectModel;
import de.netallied.functionblock.model.BasisFunctionBlockModel;

/**
 * Represents the editable/resizable table which can have columns added,
 * removed, renamed etc.
 * 
 */
public class InputEventEditPart extends EditableLabelEditPart implements NodeEditPart
{
  public String getLabelText()
  {
    return getInputEventModel().getName();
  }

  /**
	 */
	public InputEventModel getInputEventModel()
	{
		return (InputEventModel) getModel();
	}
  
  
  /**
   * Returns the Table model object represented by this EditPart
   */
  public BasisFunctionBlockModel getTypedFunctionBlockModel()
  {
    return (BasisFunctionBlockModel) getInputEventModel().getAbstractFunctionBlockModel();
  }

  public void performRequest(Request request)
  {
    super.performRequest(request);
  }


  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.NodeEditPart#getSourceConnectionAnchor(org.eclipse.gef.ConnectionEditPart)
   */
  public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection)
  {
    return new LeftWithAnchor(getFigure(),(WithTransitionInEditPart)connection);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.NodeEditPart#getSourceConnectionAnchor(org.eclipse.gef.Request)
   */
  public ConnectionAnchor getSourceConnectionAnchor(Request request)
  {
    return new ChopboxAnchor(getFigure());
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.NodeEditPart#getTargetConnectionAnchor(org.eclipse.gef.ConnectionEditPart)
   */
  public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection)
  {
    return new LeftWithAnchor(getFigure(),(WithTransitionInEditPart)connection);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.NodeEditPart#getTargetConnectionAnchor(org.eclipse.gef.Request)
   */
  public ConnectionAnchor getTargetConnectionAnchor(Request request)
  {
    return new ChopboxAnchor(getFigure());
  }

  @Override
  protected List getModelSourceConnections()
  {
    return getTypedFunctionBlockModel().getWithTransitionInModels(getInputEventModel());
  }

  /**
	 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
	 */
  @Override
	public void propertyChange(PropertyChangeEvent ev)
	{
    super.propertyChange(ev);
    refreshSourceConnections();
    if (ObjectModel.PROPERTY_WITH_ADDED.equals(ev.getPropertyName()))
    {
      refreshSourceConnections();
      refreshVisuals();
    }
    else if (ObjectModel.PROPERTY_WITH_REMOVED.equals(ev.getPropertyName()))
    {
      refreshSourceConnections();
      refreshVisuals();
    }
    else if (ObjectModel.PROPERTY_POSITION_CHANGED.equals(ev.getPropertyName()))
    {
      refreshSourceConnections();
      refreshVisuals();
    }
	}
	

	/**
	 * Creates edit policies and associates these with roles
	 */
  @Override
	public void createEditPolicies()
	{    
    super.createEditPolicies();
    installEditPolicy(EditPolicy.COMPONENT_ROLE, new InputEventEditPolicy());
    installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new GraphicalNodeEditPolicy()
    {
      protected Command getConnectionCompleteCommand(CreateConnectionRequest request)
      {
        CreateWithTransitionInCommand cmd = (CreateWithTransitionInCommand) request.getStartCommand();

        // Event   ------> Value
        // (source)        (target)
        //
        // Target muss immer vorher mit InputValueModel gesetzt worden sein
        //
        if(cmd.getTarget() == null )
            return null;
        
        cmd.setSource((InputEventModel) getHost().getModel());
        return cmd;
      }

      protected Command getConnectionCreateCommand(CreateConnectionRequest request)
      {
        InputEventModel source = (InputEventModel) getHost().getModel();
        System.out.println(source.getName());
        CreateWithTransitionInCommand cmd = new CreateWithTransitionInCommand(source);
        request.setStartCommand(cmd);
        return cmd;
      }
      
      /*
       * (non-Javadoc)
       * 
       * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getReconnectSourceCommand(org.eclipse.gef.requests.ReconnectRequest)
       */
      protected Command getReconnectSourceCommand(ReconnectRequest request)
      {
        /*
        ECCTransitionModel conn = (ECCTransitionModel) request.getConnectionEditPart().getModel();
        ECCAbstractStateModel newSource = (ECCAbstractStateModel) getHost().getModel();
        ConnectionReconnectCommand cmd = new ConnectionReconnectCommand(conn);
        cmd.setNewSource(newSource);
        return cmd;
        */
        return null;
      }
      
      /*
       * (non-Javadoc)
       * 
       * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getReconnectTargetCommand(org.eclipse.gef.requests.ReconnectRequest)
       */
      protected Command getReconnectTargetCommand(ReconnectRequest request)
      {
        /*
        ECCTransitionModel conn = (ECCTransitionModel) request.getConnectionEditPart().getModel();
        ECCAbstractStateModel newTarget = (ECCAbstractStateModel) getHost().getModel();
        ConnectionReconnectCommand cmd = new ConnectionReconnectCommand(conn);
        cmd.setNewTarget(newTarget);
        return cmd;
        */
        return null;
      }
    });
	}


	/**
	 * Creates a figure which represents the table
	 */
  @Override
	protected IFigure createFigure()
	{
		return new InputEventFigure();
	}

	/**
	 * Reset the layout constraint, and revalidate the content pane
	 */
  @Override
	protected void refreshVisuals()
	{
		InputEventFigure tableFigure = (InputEventFigure) getFigure();
		tableFigure.setText(getInputEventModel().getName());
	}
  
 
  /**
   * Liefert den Index des Models in der Menge aller InputEventsModels welche "WITH"-Elemente haben.
   * 
   * @return
   */
  private int getOffset()
  {
    List<InputEventModel> inputs = getInputEventModel().getAbstractFunctionBlockModel().getInputEventModels();
    List<InputEventModel> inputsWith = new ArrayList<InputEventModel>();
    
    for (InputEventModel model : inputs)
    {
      if(model.getWithElements().size()>0)
        inputsWith.add(model);
    }
    return inputsWith.indexOf(getModel());
  }
}