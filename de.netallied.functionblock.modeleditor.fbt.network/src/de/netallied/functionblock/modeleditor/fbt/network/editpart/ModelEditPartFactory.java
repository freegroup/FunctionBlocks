package de.netallied.functionblock.modeleditor.fbt.network.editpart;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import de.netallied.functionblock.model.CompositeInputEventModel;
import de.netallied.functionblock.model.CompositeInputValueModel;
import de.netallied.functionblock.model.CompositeOutputEventModel;
import de.netallied.functionblock.model.CompositeOutputValueModel;
import de.netallied.functionblock.model.EventTransitionModel;
import de.netallied.functionblock.model.InputEventModel;
import de.netallied.functionblock.model.InputValueModel;
import de.netallied.functionblock.model.InstanceFunctionBlockModel;
import de.netallied.functionblock.model.NetworkModel;
import de.netallied.functionblock.model.OutputEventModel;
import de.netallied.functionblock.model.OutputValueModel;
import de.netallied.functionblock.model.ParameterTransitionModel;
import de.netallied.functionblock.model.ValueTransitionModel;

public class ModelEditPartFactory implements EditPartFactory
{
  public EditPart createEditPart(EditPart context, Object modelElement)
  {
    EditPart part=null;
    
    if (modelElement instanceof NetworkModel)
      part=new NetworkModelEditPart();
    else if (modelElement instanceof InstanceFunctionBlockModel)
      part = new InstanceFunctionBlockModelEditPart();
    else if (modelElement instanceof InputEventModel)
      part = new InputEventModelEditPart();
    else if (modelElement instanceof OutputEventModel)
      part = new OutputEventModelEditPart();
    else if (modelElement instanceof InputValueModel)
      part = new InputValueModelEditPart();
    else if (modelElement instanceof OutputValueModel)
      part = new OutputValueModelEditPart();
    else if (modelElement instanceof EventTransitionModel)
      part = new EventTransitionEditPart();
    else if (modelElement instanceof ValueTransitionModel)
      part = new ValueTransitionEditPart();
    else if(modelElement instanceof CompositeInputEventModel)
      part = new CompositeInputEventModelEditPart();
    else if(modelElement instanceof CompositeOutputEventModel)
      part = new CompositeOutputEventModelEditPart();
    else if(modelElement instanceof CompositeInputValueModel)
      part = new CompositeInputValueModelEditPart();
    else if(modelElement instanceof CompositeOutputValueModel)
      part = new CompositeOutputValueModelEditPart();

    if(part!=null)
      part.setModel(modelElement);
    return part;
  }

}