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
import de.netallied.functionblock.modeleditor.fbt.basicinterface.commands.CreateWithTransitionOutCommand;
import de.netallied.functionblock.modeleditor.fbt.basicinterface.editpart.anchor.LeftWithAnchor;
import de.netallied.functionblock.modeleditor.fbt.basicinterface.editpart.anchor.RightWithAnchor;
import de.netallied.functionblock.modeleditor.fbt.basicinterface.editpolicies.OutputValueEditPolicy;
import de.netallied.functionblock.modeleditor.fbt.basicinterface.figures.OutputEventFigure;
import de.netallied.functionblock.modeleditor.fbt.basicinterface.util.EditableLabelEditPart;
import de.netallied.functionblock.model.InputValueModel;
import de.netallied.functionblock.model.ObjectModel;
import de.netallied.functionblock.model.OutputValueModel;
import de.netallied.functionblock.model.BasisFunctionBlockModel;

/**
 * Represents the editable/resizable table which can have columns added,
 * removed, renamed etc.
 * 
 */
public class OutputValueEditPart extends EditableLabelEditPart implements NodeEditPart
{

  public String getLabelText()
  {
    return getOutputValueModel().getName();
  }

  /**
	 * Returns the Table model object represented by this EditPart
	 */
	public OutputValueModel getOutputValueModel()
	{
		return (OutputValueModel) getModel();
	}
  

  /**
   * Returns the Table model object represented by this EditPart
   */
  public BasisFunctionBlockModel getTypedFunctionBlockModel()
  {
    return (BasisFunctionBlockModel) getOutputValueModel().getAbstractFunctionBlockModel();
  }  
  
  
  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.NodeEditPart#getSourceConnectionAnchor(org.eclipse.gef.ConnectionEditPart)
   */
  public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection)
  {
    return new RightWithAnchor(getFigure(),(WithTransitionOutEditPart)connection);
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
    return new RightWithAnchor(getFigure(),(WithTransitionOutEditPart)connection);
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

  
  public void performRequest(Request req)
  {
    super.performRequest(req);
  }


  /**
   * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
   */
  @Override
  public void propertyChange(PropertyChangeEvent ev)
  {
      super.propertyChange(ev);
      if (ObjectModel.PROPERTY_WITH_ADDED.equals(ev.getPropertyName()))
      {
        refreshTargetConnections();
        refreshVisuals();
      }
      else if (ObjectModel.PROPERTY_WITH_REMOVED.equals(ev.getPropertyName()))
      {
        refreshTargetConnections();
        refreshVisuals();
      }
      else if (ObjectModel.PROPERTY_POSITION_CHANGED.equals(ev.getPropertyName()))
      {
        refreshTargetConnections();
        refreshVisuals();
      }
  }

	/**
	 * Creates edit policies and associates these with roles
	 */
	public void createEditPolicies()
	{
    super.createEditPolicies();
    installEditPolicy(EditPolicy.COMPONENT_ROLE, new OutputValueEditPolicy());
    installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new GraphicalNodeEditPolicy()
    {
      protected Command getConnectionCompleteCommand(CreateConnectionRequest request)
      {
        CreateWithTransitionOutCommand cmd = (CreateWithTransitionOutCommand) request.getStartCommand();

        // Event   ------> Value
        // (source)        (target)
        //
        // Target muss immer vorher mit InputValueModel gesetzt worden sein
        //
        if(cmd.getSource() ==null)
            return null;
        
        cmd.setTarget((OutputValueModel) getHost().getModel());
        return cmd;
      }

      protected Command getConnectionCreateCommand(CreateConnectionRequest request)
      {
        OutputValueModel target = (OutputValueModel) getHost().getModel();
        CreateWithTransitionOutCommand cmd = new CreateWithTransitionOutCommand(target);
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
        return null;
      }
      
      /*
       * (non-Javadoc)
       * 
       * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getReconnectTargetCommand(org.eclipse.gef.requests.ReconnectRequest)
       */
      protected Command getReconnectTargetCommand(ReconnectRequest request)
      {
        return null;
      }
    });
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#getModelTargetConnections()
   */
  @Override
  protected List getModelTargetConnections()
  {
    return getTypedFunctionBlockModel().getWithTransitionOutModels(getOutputValueModel());
  }

	/**
	 * Creates a figure which represents the table
	 */
	protected IFigure createFigure()
	{
		return new OutputEventFigure();
	}

	/**
	 * Reset the layout constraint, and revalidate the content pane
	 */
	protected void refreshVisuals()
	{
    OutputEventFigure tableFigure = (OutputEventFigure) getFigure();
		tableFigure.setText(getOutputValueModel().getName());
	}
}