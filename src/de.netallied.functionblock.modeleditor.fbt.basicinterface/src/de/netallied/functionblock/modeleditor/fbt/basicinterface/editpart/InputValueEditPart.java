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
import de.netallied.functionblock.modeleditor.fbt.basicinterface.editpolicies.InputValueEditPolicy;
import de.netallied.functionblock.modeleditor.fbt.basicinterface.figures.InputValueFigure;
import de.netallied.functionblock.modeleditor.fbt.basicinterface.util.EditableLabelEditPart;
import de.netallied.functionblock.model.InputEventModel;
import de.netallied.functionblock.model.InputValueModel;
import de.netallied.functionblock.model.ObjectModel;
import de.netallied.functionblock.model.BasisFunctionBlockModel;

/**
 */
public class InputValueEditPart extends EditableLabelEditPart implements NodeEditPart
{
  
  public String getLabelText()
  {
    return getInputValueModel().getName();
  }


  /**
	 * Returns the Table model object represented by this EditPart
	 */
	public InputValueModel getInputValueModel()
	{
		return (InputValueModel) getModel();
	}
  
  /**
   * Returns the Table model object represented by this EditPart
   */
  public BasisFunctionBlockModel getTypedFunctionBlockModel()
  {
    return (BasisFunctionBlockModel) getInputValueModel().getAbstractFunctionBlockModel();
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
  @Override
	public void createEditPolicies()
	{    
    super.createEditPolicies();
    installEditPolicy(EditPolicy.COMPONENT_ROLE, new InputValueEditPolicy());
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
        if(cmd.getSource() ==null)
            return null;
        
        cmd.setTarget((InputValueModel) getHost().getModel());
        return cmd;
      }

      protected Command getConnectionCreateCommand(CreateConnectionRequest request)
      {
        InputValueModel target = (InputValueModel) getHost().getModel();
        CreateWithTransitionInCommand cmd = new CreateWithTransitionInCommand(target);
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

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#getModelTargetConnections()
   */
  @Override
  protected List getModelTargetConnections()
  {
    return getTypedFunctionBlockModel().getWithTransitionInModels(getInputValueModel());
  }

  /**
	 * Creates a figure which represents the table
	 */
  @Override
	protected IFigure createFigure()
	{
		return new InputValueFigure();
	}

	/**
	 * Reset the layout constraint, and revalidate the content pane
	 */
  @Override
	protected void refreshVisuals()
	{
    InputValueFigure tableFigure = (InputValueFigure) getFigure();
		tableFigure.setText(getInputValueModel().getName());
	}
  
  /**
   * Liefert den Index des Models in der Menge aller InputEventsModels welche "WITH"-Elemente haben.
   * 
   * @return
   */
  private int getOffset(ConnectionEditPart con)
  {
    InputEventEditPart source =(InputEventEditPart)con.getSource();
    List<InputEventModel> inputs = source.getInputEventModel().getAbstractFunctionBlockModel().getInputEventModels();
    List<InputEventModel> inputsWith = new ArrayList<InputEventModel>();
    
    for (InputEventModel model : inputs)
    {
      if(model.getWithElements().size()>0)
        inputsWith.add(model);
    }
    return Math.max(0, inputsWith.indexOf(source.getModel()));
  }  
}