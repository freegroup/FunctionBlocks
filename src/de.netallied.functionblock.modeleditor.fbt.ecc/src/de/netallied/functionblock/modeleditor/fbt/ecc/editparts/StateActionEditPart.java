package de.netallied.functionblock.modeleditor.fbt.ecc.editparts;


import java.beans.PropertyChangeEvent;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import de.netallied.functionblock.model.ECCStateActionModel;
import de.netallied.functionblock.modeleditor.fbt.ecc.editpolicies.StateActionEditPolicy;
import de.netallied.functionblock.modeleditor.fbt.ecc.figures.ActionFigure;
import de.netallied.functionblock.modeleditor.fbt.ecc.util.PropertyAwareEditPart;

public class StateActionEditPart extends PropertyAwareEditPart
{
  public StateActionEditPart()
  {
  }

  
  @Override
	public void createEditPolicies()
	{
    installEditPolicy(EditPolicy.COMPONENT_ROLE, new StateActionEditPolicy());
	}

	@Override
  protected IFigure createFigure()
  {
     return new ActionFigure();
  }

  @Override
	public void propertyChange(PropertyChangeEvent ev)
	{
		super.propertyChange(ev);

		if(ev.getSource()==getModel())
			refreshVisuals();
	}

  @Override
  public void refreshVisuals()
	{
		super.refreshVisuals();
    
		ActionFigure figure = (ActionFigure)getFigure();
    ECCStateActionModel model = getECCStateActionModel();
    
    figure.setCode(model.getAlgorithmName());
    figure.setOut(model.getOutput());
	}
  
  public ECCStateActionModel getECCStateActionModel()
  {
    return (ECCStateActionModel)getModel();
  }
}
