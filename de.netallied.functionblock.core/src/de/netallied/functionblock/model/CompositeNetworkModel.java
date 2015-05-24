/*
 * Created on 16.01.2007
 *
 */
package de.netallied.functionblock.model;

import org.eclipse.core.resources.IProject;
import de.netallied.functionblock.model.castor.FBNetwork;

public class CompositeNetworkModel extends NetworkModel
{

  public CompositeNetworkModel(IProject project, Object parent, FBNetwork network) throws Exception
  {
    super(project, parent, network);
  }
  
  public CompositeFunctionBlockModel getCompositeFunctionBlockModel()
  {
    return (CompositeFunctionBlockModel)getParent();
  }
  
  public AbstractSourceModel getAbstractSourceModel(String id)
  {
    String[] parts = id.split("[.]");
    if (parts.length == 1)
    {
      for (AbstractSourceModel source : getCompositeFunctionBlockModel().getCompositeInputEventModels())
      {
        if (source.getName().equals(parts[0]))
          return source;
      }
      for (AbstractSourceModel source : getCompositeFunctionBlockModel().getCompositeInputValueModels())
      {
        if (source.getName().equals(parts[0]))
          return source;
      }
    }
    return super.getAbstractSourceModel(id);
  }
  
  public AbstractTargetModel getAbstractTargetModel(String id)
  {
    String[] parts = id.split("[.]");
    if (parts.length == 1)
    {
      for (AbstractTargetModel target : getCompositeFunctionBlockModel().getCompositeOutputEventModels())
      {
        if (target.getName().equals(parts[0]))
          return target;
      }
      for (AbstractTargetModel target : getCompositeFunctionBlockModel().getCompositeOutputValueModels())
      {
        if (target.getName().equals(parts[0]))
          return target;
      }
    }
    return super.getAbstractTargetModel(id);
  }
  
}
