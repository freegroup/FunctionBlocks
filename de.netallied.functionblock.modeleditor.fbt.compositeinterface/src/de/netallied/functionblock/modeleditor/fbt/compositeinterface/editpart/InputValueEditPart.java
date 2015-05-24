package de.netallied.functionblock.modeleditor.fbt.compositeinterface.editpart;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import de.netallied.functionblock.model.InputValueModel;
import de.netallied.functionblock.modeleditor.fbt.compositeinterface.editpolicies.InputValueEditPolicy;
import de.netallied.functionblock.modeleditor.fbt.compositeinterface.figures.InputValueFigure;
import de.netallied.functionblock.modeleditor.fbt.compositeinterface.util.EditableLabelEditPart;

/**
 */
public class InputValueEditPart extends EditableLabelEditPart
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
	 * Creates edit policies and associates these with roles
	 */
  @Override
	public void createEditPolicies()
	{    
    super.createEditPolicies();
    installEditPolicy(EditPolicy.COMPONENT_ROLE, new InputValueEditPolicy());
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
}