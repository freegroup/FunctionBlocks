package de.netallied.functionblock.model;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.IStructuredSelection;
import de.netallied.functionblock.model.castor.Connection;
import de.netallied.functionblock.model.castor.DataConnections;
import de.netallied.functionblock.model.castor.EventConnections;
import de.netallied.functionblock.model.castor.FB;
import de.netallied.functionblock.model.castor.FBType;
public class CompositeFunctionBlockModel extends AbstractFunctionBlockModel
{
  private final IProject     project;
  private final NetworkModel network;
  
  private List<CompositeInputEventModel>       compositeInputEvent;
  private List<CompositeOutputEventModel>      compositeOutputEvent;
  private ArrayList<CompositeInputValueModel>  compositeInputValues;
  private ArrayList<CompositeOutputValueModel> compositeOutputValues;

  public CompositeFunctionBlockModel(IProject project, FBType type) throws Exception
  {
    super(type);
    this.project = project;
    this.network = new CompositeNetworkModel(project,this,type.getFBTypeChoice().getFBNetwork());
  }


  public NetworkModel getNetwork()
  {
    return network;
  }


  @Override
  public void addElement(int index, OutputValueModel event)
  {
    getCompositeOutputValueModels().add(new CompositeOutputValueModel(event));
    super.addElement(index, event);
  }

  @Override
  public void removeElement(OutputValueModel value)
  {
    Iterator iter = getCompositeOutputValueModels().iterator();
    while (iter.hasNext())
    {
      CompositeOutputValueModel model = (CompositeOutputValueModel) iter.next();
      if (model.getOutputValueModel() == value)
      {
        // Alle CompositeTransitions entfernen (Zuordnung Innere Elemente zum Äusseren Composite Element)
        //
        for (ValueTransitionModel transistion : network.getTargetTransitions(model))
          network.removeElement(transistion);
        iter.remove();
        break;
      }
    }
    super.removeElement(value);
  }

  @Override
  public void addElement(int index, OutputEventModel event)
  {
    getCompositeOutputEventModels().add(new CompositeOutputEventModel(event));
    super.addElement(index, event);
  }

  @Override
  public void removeElement(OutputEventModel value)
  {
    Iterator iter = getCompositeOutputEventModels().iterator();
    while (iter.hasNext())
    {
      CompositeOutputEventModel model = (CompositeOutputEventModel) iter.next();
      if (model.getOutputEventModel() == value)
      {
        // Alle CompositeTransitions entfernen (Zuordnung Innere Elemente zum Äusseren Composite Element)
        //
        for (EventTransitionModel transistion : network.getTargetTransitions(model))
          network.removeElement(transistion);
        iter.remove();
        break;
      }
    }
    super.removeElement(value);
  }

  @Override
  public void addElement(int index, InputValueModel event)
  {
    getCompositeInputValueModels().add(new CompositeInputValueModel(event));
    super.addElement(index, event);
  }

  @Override
  public void removeElement(InputValueModel value)
  {
    Iterator iter = getCompositeInputValueModels().iterator();
    while (iter.hasNext())
    {
      CompositeInputValueModel model = (CompositeInputValueModel) iter.next();
      if (model.getInputValueModel() == value)
      {
        // Alle CompositeTransitions entfernen (Zuordnung Innere Elemente zum Äusseren Composite Element)
        //
        for (ValueTransitionModel transistion : network.getSourceTransitions(model))
          network.removeElement(transistion);
        iter.remove();
        break;
      }
    }
    super.removeElement(value);
  }

  @Override
  public void addElement(int index, InputEventModel event)
  {
    getCompositeInputEventModels().add(new CompositeInputEventModel(event));
    super.addElement(index, event);
  }

  @Override
  public void removeElement(InputEventModel value)
  {
    Iterator iter = getCompositeInputEventModels().iterator();
    while (iter.hasNext())
    {
      CompositeInputEventModel model = (CompositeInputEventModel) iter.next();
      if (model.getInputEventModel() == value)
      {
        // Alle CompositeTransitions entfernen (Zuordnung Innere Elemente zum Äusseren Composite Element)
        //
        for (EventTransitionModel transistion : network.getSourceTransitions(model))
          network.removeElement(transistion);
        iter.remove();
        break;
      }
    }
    super.removeElement(value);
  }
 


  /**
   * 
   */
  public List<CompositeInputEventModel> getCompositeInputEventModels()
  {
    if (this.compositeInputEvent == null)
    {
      this.compositeInputEvent = new ArrayList<CompositeInputEventModel>();
      for (InputEventModel model : getSignalSegment().getInputModels())
      {
        this.compositeInputEvent.add(new CompositeInputEventModel(model));
      }
    }
    return this.compositeInputEvent;
  }

  /**
   * 
   */
  public List<CompositeInputValueModel> getCompositeInputValueModels()
  {
    if (this.compositeInputValues == null)
    {
      this.compositeInputValues = new ArrayList<CompositeInputValueModel>();
      for (InputValueModel model : getValueSegment().getInputModels())
      {
        this.compositeInputValues.add(new CompositeInputValueModel(model));
      }
    }
    return this.compositeInputValues;
  }

  public List<CompositeOutputEventModel> getCompositeOutputEventModels()
  {
    if (this.compositeOutputEvent == null)
    {
      this.compositeOutputEvent = new ArrayList<CompositeOutputEventModel>();
      for (OutputEventModel model : getSignalSegment().getOutputModels())
      {
        this.compositeOutputEvent.add(new CompositeOutputEventModel(model));
      }
    }
    return this.compositeOutputEvent;
  }

  public List<CompositeOutputValueModel> getCompositeOutputValueModels()
  {
    if (this.compositeOutputValues == null)
    {
      this.compositeOutputValues = new ArrayList<CompositeOutputValueModel>();
      for (OutputValueModel model : getValueSegment().getOutputModels())
      {
        this.compositeOutputValues.add(new CompositeOutputValueModel(model));
      }
    }
    return this.compositeOutputValues;
  }

  public List<CompositeInputEventModel> getUsedCompositeInputEventModels()
  {
    ArrayList<CompositeInputEventModel> result = new ArrayList<CompositeInputEventModel>();
    for (CompositeInputEventModel model : getCompositeInputEventModels())
    {
      // Nur wenn es für diesen Port ein Gegenport gibt, wird dieser
      // zurückgeliefert
      //
      for (EventTransitionModel transition : network.getEventTransitions())
      {
        if (transition.getFromObjectModel() == model)
          result.add(model);
      }
    }
    return result;
  }

  public List<CompositeInputValueModel> getUsedCompositeInputValueModels()
  {
    ArrayList<CompositeInputValueModel> result = new ArrayList<CompositeInputValueModel>();
    for (CompositeInputValueModel model : getCompositeInputValueModels())
    {
      // Nur wenn es für diesen Port ein Gegenport gibt, wird dieser
      // zurückgeliefert
      //
      for (ValueTransitionModel transition : network.getValueTransitions())
      {
        if (transition.getFromObjectModel() == model)
          result.add(model);
      }
    }
    return result;
  }

  public List<CompositeOutputEventModel> getUsedCompositeOutputEventModels()
  {
    ArrayList<CompositeOutputEventModel> result = new ArrayList<CompositeOutputEventModel>();
    for (CompositeOutputEventModel model : getCompositeOutputEventModels())
    {
      // Nur wenn es für diesen Port ein Gegenport gibt, wird dieser
      // zurückgeliefert
      //
      for (EventTransitionModel transition : network.getEventTransitions())
      {
        if (transition.getToObjectModel() == model)
          result.add(model);
      }
    }
    return result;
  }

  public List<CompositeOutputValueModel> getUsedCompositeOutputValueModels()
  {
    ArrayList<CompositeOutputValueModel> result = new ArrayList<CompositeOutputValueModel>();
    for (CompositeOutputValueModel model : getCompositeOutputValueModels())
    {
      // Nur wenn es für diesen Port ein Gegenport gibt, wird dieser
      // zurückgeliefert
      //
      for (ValueTransitionModel transition : network.getValueTransitions())
      {
        if (transition.getToObjectModel() == model)
          result.add(model);
      }
    }
    return result;
  }

  public IProject getProject()
  {
    return project;
  }
}
