
package de.netallied.functionblock.model;

import java.util.ArrayList;
import java.util.List;
import de.netallied.functionblock.model.castor.Connection;

public class WithTransitionOutModel extends ObjectModel
{
  private final OutputEventModel fromModel;
  private final OutputValueModel toModel;
  
  private int sortIndex=0;
  
	public WithTransitionOutModel( OutputEventModel from, OutputValueModel to) 
	{
    this.fromModel = from;
    this.toModel   = to;
	}

  public OutputEventModel getFromObjectModel()
  {
    return fromModel;
  }

  public OutputValueModel getToObjectModel()
  {
    return toModel;
  }

  public int getSortIndex()
  {
      List<OutputEventModel> outputs     = fromModel.getAbstractFunctionBlockModel().getOutputEventModels();
      List<OutputEventModel> outputsWith = new ArrayList<OutputEventModel>();
      
      for (OutputEventModel model : outputs)
      {
        if(model.getWithElements().size()>0)
          outputsWith.add(model);
      }
      return outputsWith.indexOf(fromModel);
  }

}

