package de.netallied.functionblock.modeleditor.fbt.network.editpart;

import java.util.List;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPolicy;
import org.eclipse.ui.IActionFilter;
import de.netallied.functionblock.model.InstanceFunctionBlockModel;
import de.netallied.functionblock.model.OutputEventModel;
import de.netallied.functionblock.modeleditor.fbt.network.Constants;
import de.netallied.functionblock.modeleditor.fbt.network.editpolicy.OutputEventNodeEditPolicy;
import de.netallied.functionblock.modeleditor.fbt.network.figure.OutputEventFigure;

public class OutputEventModelEditPart extends InterfaceModelEditPart
{

  @Override
  protected void createEditPolicies()
  {
  	// allow the creation of connections and
    // and the reconnection of connections between Shape instances
    installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new OutputEventNodeEditPolicy());
  }

  @Override
  public IFigure createFigure()
  {
  	return new OutputEventFigure(getInterfaceModel().getName());
  }
  
  public OutputEventModel getOutputEventModel()
  {
    return (OutputEventModel) getModel();
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#getModelSourceConnections()
   */
  @Override
  protected List getModelSourceConnections()
  {
		return getNetworkModel().getSourceTransitions(getOutputEventModel());
  }

  protected void refreshVisuals()
  {
    InstanceFunctionBlockModelEditPart parent = (InstanceFunctionBlockModelEditPart)getParent();
    InstanceFunctionBlockModel parentModel = parent.getInstanceFunctionBlockModel();
    
    Point topLeft = parent.getFigure().getBounds().getTopLeft();
    
    int offset = Constants.RULE_GRID_HEIGHT;
    int w = getFigure().getPreferredSize().width;
    int h = getFigure().getPreferredSize().height;
    
    int index = parentModel.getOutputEventModels().indexOf(getModel());
    int xTrans = parent.getFigure().getSize().width- w;
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
            int count = ((OutputEventModelEditPart) target).getModelSourceConnections().size();
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
