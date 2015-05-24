package de.netallied.functionblock.modeleditor.fbt.network.editpart;

import java.util.List;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPolicy;
import org.eclipse.ui.IActionFilter;
import de.netallied.functionblock.model.InstanceFunctionBlockModel;
import de.netallied.functionblock.model.OutputValueModel;
import de.netallied.functionblock.modeleditor.fbt.network.Constants;
import de.netallied.functionblock.modeleditor.fbt.network.editpolicy.OutputValueNodeEditPolicy;
import de.netallied.functionblock.modeleditor.fbt.network.figure.OutputValueFigure;

public class OutputValueModelEditPart extends InterfaceModelEditPart
{

  @Override
  protected void createEditPolicies()
  {
  	// allow the creation of connections and
    // and the reconnection of connections between Shape instances
    installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new OutputValueNodeEditPolicy());
  }

  @Override
  public IFigure createFigure()
  {
  	return new OutputValueFigure(getInterfaceModel().getName());
  }
  
  public OutputValueModel getOutputValueModel()
  {
    return (OutputValueModel) getModel();
  }

  @Override
  protected List getModelSourceConnections()
  {
		return getNetworkModel().getSourceTransitions(getOutputValueModel());
  }
  
  @Override
  protected void refreshVisuals()
  {
    InstanceFunctionBlockModelEditPart parent = (InstanceFunctionBlockModelEditPart)getParent();
    InstanceFunctionBlockModel parentModel = parent.getInstanceFunctionBlockModel();

    int count = Math.max(parentModel.getInputEventModels().size(),parentModel.getOutputEventModels().size());
    int offset = count*Constants.RULE_GRID_HEIGHT+Constants.RULE_GRID_HEIGHT*2;
    
    Point topLeft = parent.getFigure().getBounds().getTopLeft();
    
    int w = getFigure().getPreferredSize().width;
    int h = getFigure().getPreferredSize().height;
    
    int index = parentModel.getOutputValueModels().indexOf(getModel());
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
            int count = ((OutputValueModelEditPart) target).getModelSourceConnections().size();
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
