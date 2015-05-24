package de.netallied.functionblock.modeleditor.fbt.basicinterface.editpart;

import java.beans.PropertyChangeEvent;
import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import de.netallied.functionblock.modeleditor.fbt.basicinterface.editpolicies.InputEventEditPolicy;
import de.netallied.functionblock.modeleditor.fbt.basicinterface.figures.FunctionBlockNameFigure;
import de.netallied.functionblock.modeleditor.fbt.basicinterface.util.EditableLabelEditPart;
import de.netallied.functionblock.model.FunctionBlockNameModel;

/**
 * Represents the editable/resizable table which can have columns added,
 * removed, renamed etc.
 * 
 */
public class FunctionBlockNameEditPart extends EditableLabelEditPart
{

  public String getLabelText()
  {
    return getFunctionBlockNameModel().getName();
  }

  /**
	 */
	public FunctionBlockNameModel getFunctionBlockNameModel()
	{
		return (FunctionBlockNameModel) getModel();
	}
  
  public void performRequest(Request request)
  {
    super.performRequest(request);
  }


	/**
	 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
	 */
  @Override
	public void propertyChange(PropertyChangeEvent ev)
	{
      super.propertyChange(ev);
	}
	

	/**
	 * Creates edit policies and associates these with roles
	 */
  @Override
	public void createEditPolicies()
	{    
    super.createEditPolicies();
    installEditPolicy(EditPolicy.COMPONENT_ROLE, new InputEventEditPolicy());
	}


	/**
	 * Creates a figure which represents the table
	 */
	protected IFigure createFigure()
	{
		return new FunctionBlockNameFigure();
	}

	/**
	 * Reset the layout constraint, and revalidate the content pane
	 */
  @Override
	protected void refreshVisuals()
	{
		FunctionBlockNameFigure figure = (FunctionBlockNameFigure) getFigure();
		figure.setText(getLabelText());
    FunctionBlockEditPart parent = (FunctionBlockEditPart) getParent();
    parent.setLayoutConstraint(this, figure, BorderLayout.BOTTOM);
	}
}