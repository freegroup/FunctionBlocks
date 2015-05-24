package de.netallied.functionblock.modeleditor.fbt.compositeinterface.editpart;

import java.beans.PropertyChangeEvent;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import de.netallied.functionblock.model.OutputEventModel;
import de.netallied.functionblock.modeleditor.fbt.compositeinterface.editpolicies.OutputEventEditPolicy;
import de.netallied.functionblock.modeleditor.fbt.compositeinterface.figures.OutputEventFigure;
import de.netallied.functionblock.modeleditor.fbt.compositeinterface.util.EditableLabelEditPart;

/**
 * Represents the editable/resizable table which can have columns added,
 * removed, renamed etc.
 * 
 */
public class OutputEventEditPart extends EditableLabelEditPart
{
  
  public String getLabelText()
  {
    return getOutputEventModel().getName();
  }

  /**
	 * Returns the Table model object represented by this EditPart
	 */
	public OutputEventModel getOutputEventModel()
	{
		return (OutputEventModel) getModel();
	}
  
  
  public void performRequest(Request req)
  {
    super.performRequest(req);
  }


	/**
	 */
	public void propertyChange(PropertyChangeEvent ev)
	{
      super.propertyChange(ev);
	}
	
	/**
	 * Creates edit policies and associates these with roles
	 */
	public void createEditPolicies()
	{
    super.createEditPolicies();
    installEditPolicy(EditPolicy.COMPONENT_ROLE, new OutputEventEditPolicy());
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
		tableFigure.setText(getOutputEventModel().getName());
	}
}