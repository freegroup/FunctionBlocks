package de.netallied.functionblock.modeleditor.res.network.editpart;

import java.util.List;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPolicy;
import org.eclipse.ui.IActionFilter;
import de.netallied.functionblock.model.InputEventModel;
import de.netallied.functionblock.model.InstanceFunctionBlockModel;
import de.netallied.functionblock.modeleditor.res.network.Constants;
import de.netallied.functionblock.modeleditor.res.network.editpolicies.InputEventNodeEditPolicy;
import de.netallied.functionblock.modeleditor.res.network.figures.InputEventFigure;

public class InputEventModelEditPart extends InterfaceModelEditPart
{

  @Override
  public IFigure createFigure()
  {
  	return new InputEventFigure(getInterfaceModel().getName());
  }

  public InputEventModel getInputEventModel()
  {
    return (InputEventModel) getModel();
  }

  @Override
	protected List getModelTargetConnections() 
  {
 		return getNetworkModel().getTargetTransitions(getInputEventModel());
	}

 
  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
   */
  @Override
  protected void createEditPolicies()
  {
  	// allow the creation of connections and
    // and the reconnection of connections between Shape instances
    installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new InputEventNodeEditPolicy());
  }
  
  @Override
  protected void refreshVisuals()
  {
      InstanceFunctionBlockModelEditPart parent = (InstanceFunctionBlockModelEditPart)getParent();
      InstanceFunctionBlockModel parentModel = parent.getInstanceFunctionBlockModel();
      
      Point topLeft = parent.getFigure().getBounds().getTopLeft();
      
      int offset = Constants.RULE_GRID_HEIGHT;
  //    int w = getFigure().getPreferredSize().width;
      int h = getFigure().getPreferredSize().height;
      
      int index = parentModel.getInputEventModels().indexOf(getModel());
      int xTrans = 0;//parent.getFigure().getSize().width- w;
      int yTrans = Constants.RULE_GRID_HEIGHT*index+offset- (h/2);
      getFigure().setLocation(topLeft.getTranslated(xTrans,yTrans));
  }

  @Override
  public Object getAdapter(Class adapter)
  {
    if (adapter == org.eclipse.ui.IActionFilter.class)
    {
      IActionFilter filter = new IActionFilter()
      {
        public boolean testAttribute(Object target, String name, String v)
        {
          if(name.equals("fanIn"))
          {
            int count = ((InputEventModelEditPart) target).getModelTargetConnections().size();
            int value = Integer.parseInt(v);
            return count<value;
          }
          return false;
        }
      };
      return filter;
    }
    return super.getAdapter(adapter);
  }
}
