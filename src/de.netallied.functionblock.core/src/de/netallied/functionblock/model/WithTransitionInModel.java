
package de.netallied.functionblock.model;

import java.util.ArrayList;
import java.util.List;
import de.netallied.functionblock.model.castor.Connection;

public class WithTransitionInModel extends ObjectModel
{
  private final InputEventModel fromModel;
  private final InputValueModel toModel;
  
  private int sortIndex=0;
  
	public WithTransitionInModel( InputEventModel from, InputValueModel to) 
	{
    this.fromModel = from;
    this.toModel   = to;
	}

  public InputEventModel getFromObjectModel()
  {
    return fromModel;
  }

  public InputValueModel getToObjectModel()
  {
    return toModel;
  }

  public int getSortIndex()
  {
      List<InputEventModel> inputs     = fromModel.getAbstractFunctionBlockModel().getInputEventModels();
      List<InputEventModel> inputsWith = new ArrayList<InputEventModel>();
      
      for (InputEventModel model : inputs)
      {
        if(model.getWithElements().size()>0)
          inputsWith.add(model);
      }
      return inputsWith.indexOf(fromModel);
  }

}

