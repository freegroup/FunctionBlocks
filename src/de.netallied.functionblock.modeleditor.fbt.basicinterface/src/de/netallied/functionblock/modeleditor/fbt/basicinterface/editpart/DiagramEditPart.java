package de.netallied.functionblock.modeleditor.fbt.basicinterface.editpart;


import java.beans.PropertyChangeEvent;
import java.util.List;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import de.netallied.functionblock.modeleditor.fbt.basicinterface.editpolicies.SchemaXYLayoutPolicy;
import de.netallied.functionblock.modeleditor.fbt.basicinterface.figures.DiagramFigure;
import de.netallied.functionblock.modeleditor.fbt.basicinterface.util.PropertyAwareEditPart;
import de.netallied.functionblock.model.FBTypeModel;
public class DiagramEditPart extends PropertyAwareEditPart
{
	protected IFigure createFigure()
	{
		return new DiagramFigure();
	}

	public FBTypeModel getFunctionBlockDiagramModel()
	{
		return (FBTypeModel) getModel();
	}

	/**
	 * @return the children Model objects as a new ArrayList
	 */
	protected List getModelChildren()
	{
		return getFunctionBlockDiagramModel().getElements();
	}

	/**
	 * @see org.eclipse.gef.editparts.AbstractEditPart#isSelectable()
	 */
	public boolean isSelectable()
	{
		return false;
	}

	/**
	 * Creates EditPolicy objects for the EditPart. The LAYOUT_ROLE policy is
	 * left to the delegating layout manager
	 */
	protected void createEditPolicies()
	{
    installEditPolicy(EditPolicy.CONTAINER_ROLE, new SchemaXYLayoutPolicy());
    installEditPolicy(EditPolicy.LAYOUT_ROLE, null);
	}
  
}