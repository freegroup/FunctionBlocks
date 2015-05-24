/*
 * Created on 16.01.2007
 *
 */
package de.netallied.functionblock.model;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.core.resources.IProject;
import de.netallied.functionblock.model.castor.Connection;
import de.netallied.functionblock.model.castor.DataConnections;
import de.netallied.functionblock.model.castor.EventConnections;
import de.netallied.functionblock.model.castor.FB;
import de.netallied.functionblock.model.castor.FBNetwork;

public class NetworkModel extends ObjectModel
{
  private List<InstanceFunctionBlockModel> elements;
  private List<ValueTransitionModel> valueTransitions;
  private List<EventTransitionModel> eventTransitions;
  // Parameter an ein FB InputValue Port
  private List<ParameterTransitionModel> parameterTransitions;

  FBNetwork castor;
  Object    parent;
  IProject  project;
  
  public NetworkModel(IProject project,Object parent, FBNetwork network) throws Exception
  {
    this.castor = network;
    this.parent = parent;
    this.project = project;
    
    elements = new ArrayList<InstanceFunctionBlockModel>();
    for (int i = 0; i < network.getFBCount(); i++)
    {
      FB fb = network.getFB(i);
      elements.add(new InstanceFunctionBlockModel(this, fb));
    }
    valueTransitions = new ArrayList<ValueTransitionModel>();
    eventTransitions = new ArrayList<EventTransitionModel>();
    parameterTransitions = new ArrayList<ParameterTransitionModel>();

    // Alle Übergänge zwischen den FB finden
    //
    DataConnections dCons = network.getDataConnections();
    EventConnections eCons = network.getEventConnections();
    if (dCons != null)
    {
      for (int i = 0; i < dCons.getConnectionCount(); i++)
      {
        Connection con = dCons.getConnection(i);
        AbstractTargetModel destination = getAbstractTargetModel(con.getDestination());
        AbstractSourceModel source = getAbstractSourceModel(con.getSource());
        valueTransitions.add(new ValueTransitionModel(this, con, source, destination));
      }
    }
    if (eCons != null)
    {
      for (int i = 0; i < eCons.getConnectionCount(); i++)
      {
        Connection con = eCons.getConnection(i);
        AbstractTargetModel destination = getAbstractTargetModel(con.getDestination());
        AbstractSourceModel source = getAbstractSourceModel(con.getSource());
        eventTransitions.add(new EventTransitionModel(this, con, source, destination));
      }
    }
    
    // Alle FB analysieren ob diese einen Parameter enthalten, wenn ja wir im Network
    // eine Transistion eingefügt. Dies ist nur transient und wird berechnet und nicht im XML
    // abgespeichert.
    //
    for (InstanceFunctionBlockModel ifb : elements)
    {
      List<ParameterModel> params = ifb.getParameters();
      for (ParameterModel model : params)
      {
        parameterTransitions.add(new ParameterTransitionModel(this,model,ifb.getAbstractTargetModel(model.getName())));
      }
    }
  }
  
  public AbstractSourceModel getAbstractSourceModel(String id)
  {
    String[] parts = id.split("[.]");
    if (parts.length == 2)
    {
      InstanceFunctionBlockModel ifb = getInstanceElement(parts[0]);
      if (ifb != null)
        return ifb.getAbstractSourceModel(parts[1]);
    }
    return null;
  }
  
  public AbstractTargetModel getAbstractTargetModel(String id)
  {
    String[] parts = id.split("[.]");
    if (parts.length == 2)
    {
      InstanceFunctionBlockModel ifb = getInstanceElement(parts[0]);
      if (ifb != null)
        return ifb.getAbstractTargetModel(parts[1]);
    }
    return null;
  }

  public IProject getProject()
  {
    return project;
  }
  
  public Object getParent()
  {
    return parent;
  }
  
  public List<InstanceFunctionBlockModel> getElements()
  {
    return elements;
  }


  public InstanceFunctionBlockModel getInstanceElement(AbstractTargetModel target)
  {
    for (InstanceFunctionBlockModel fb : elements)
    {
      if (fb.getInputValueModels().contains(target))
        return fb;
      if (fb.getInputEventModels().contains(target))
        return fb;
    }
    return null;
  }

  public InstanceFunctionBlockModel getInstanceElement(AbstractSourceModel target)
  {
    for (InstanceFunctionBlockModel fb : elements)
    {
      if (fb.getOutputValueModels().contains(target))
        return fb;
      if (fb.getOutputEventModels().contains(target))
        return fb;
    }
    return null;
  }

  public InstanceFunctionBlockModel getInstanceElement(String name)
  {
    for (InstanceFunctionBlockModel fb : elements)
    {
      if (fb.getName().equals(name))
        return fb;
    }
    return null;
  }
  public void addElement(InstanceFunctionBlockModel model)
  {
    elements.add(model);
    model.setParent(this);
    castor.addFB(model.getCastor());
    firePropertyChange(PROPERTY_ELEMENT_ADDED, null, model);
  }

  public void removeElement(InstanceFunctionBlockModel model)
  {
    int index = elements.indexOf(model);
    if (index >= 0)
    {
      castor.removeFB(index);
      elements.remove(model);
      firePropertyChange(PROPERTY_ELEMENT_REMOVED, model, null);
    }
  }
  
  public boolean removeElement(AbstractTransitionModel model)
  {
    if(model instanceof ValueTransitionModel)
      return removeElement((ValueTransitionModel)model);
    
    if(model instanceof ParameterTransitionModel)
      return removeElement((ParameterTransitionModel)model);
    
    if(model instanceof EventTransitionModel)
      return removeElement((EventTransitionModel)model);

    return false;
  }

  private boolean removeElement(ParameterTransitionModel model)
  {
    int index = parameterTransitions.indexOf(model);
    if (index >= 0)
    {
      parameterTransitions.remove(model);
      ParameterModel from = (ParameterModel)model.getFromObjectModel();
      InstanceFunctionBlockModel ifb= from.getInstanceFunctionBlockModel();
      ifb.removeElement(from);
      firePropertyChange(PROPERTY_ELEMENT_REMOVED, model, null);
      return true;
    }
    return false;
  }

  private boolean removeElement(ValueTransitionModel model)
  {
    int index = valueTransitions.indexOf(model);
    if (index >= 0)
    {
      valueTransitions.remove(model);
      castor.getDataConnections().removeConnection(index);
      if (!(model.getFromObjectModel() instanceof CompositeInputValueModel))
        model.getFromObjectModel().firePropertyChange(SOURCE_CONNECTIONS_PROP, model, null);
      if (!(model.getToObjectModel() instanceof CompositeOutputValueModel))
        model.getToObjectModel().firePropertyChange(TARGET_CONNECTIONS_PROP, model, null);
      firePropertyChange(PROPERTY_ELEMENT_REMOVED, model, null);
      if (valueTransitions.size() == 0)
        castor.setDataConnections(null);
      return true;
    }
    return false;
  }

  private boolean removeElement(EventTransitionModel model)
  {
    int index = eventTransitions.indexOf(model);
    if (index >= 0)
    {
      eventTransitions.remove(model);
      castor.getEventConnections().removeConnection(index);
      if (!(model.getFromObjectModel() instanceof CompositeInputEventModel))
        model.getFromObjectModel().firePropertyChange(SOURCE_CONNECTIONS_PROP, model, null);
      if (!(model.getToObjectModel() instanceof CompositeOutputEventModel))
        model.getToObjectModel().firePropertyChange(TARGET_CONNECTIONS_PROP, model, null);
      firePropertyChange(PROPERTY_ELEMENT_REMOVED, model, null);
      // Falls keine LinkModel mehr vorhanden sind, dann werden diese auch
      // komplett
      // aus dem XML entfernt
      //
      if (eventTransitions.size() == 0)
        castor.setEventConnections(null);
      return true;
    }
    return false;
  }

  public boolean addElement(AbstractTransitionModel model)
  {
    if(model instanceof EventTransitionModel)
      return addElement((EventTransitionModel)model);

    if(model instanceof ParameterTransitionModel)
      return addElement((ParameterTransitionModel)model);

    if(model instanceof ValueTransitionModel)
      return addElement((ValueTransitionModel)model);

    return false;
  }
  
  private boolean addElement(ValueTransitionModel model)
  {
    if (castor.getDataConnections() == null)
      castor.setDataConnections(new DataConnections());
    valueTransitions.add(model);
    AbstractSourceModel from = model.getFromObjectModel();
    AbstractTargetModel to = model.getToObjectModel();
    from.firePropertyChange(SOURCE_CONNECTIONS_PROP, null, from);
    to.firePropertyChange(TARGET_CONNECTIONS_PROP, null, to);
    castor.getDataConnections().addConnection(model.getCastor());
    firePropertyChange(PROPERTY_ELEMENT_ADDED, null, model);
    return true;
  }


  private boolean addElement(ParameterTransitionModel model)
  {
    parameterTransitions.add(model);
    ParameterModel from = (ParameterModel)model.getFromObjectModel();
    AbstractTargetModel to = model.getToObjectModel();
    InstanceFunctionBlockModel ifb= from.getInstanceFunctionBlockModel();
    ifb.addParameter(from);
    from.firePropertyChange(SOURCE_CONNECTIONS_PROP, null, from);
    to.firePropertyChange(TARGET_CONNECTIONS_PROP, null, to);
    firePropertyChange(PROPERTY_ELEMENT_ADDED, null, model);
    return true;
  }

  
  private boolean addElement(EventTransitionModel model)
  {
    if (castor.getEventConnections() == null)
      castor.setEventConnections(new EventConnections());
    eventTransitions.add(model);
    AbstractSourceModel from = model.getFromObjectModel();
    AbstractTargetModel to = model.getToObjectModel();
    from.firePropertyChange(SOURCE_CONNECTIONS_PROP, null, from);
    to.firePropertyChange(TARGET_CONNECTIONS_PROP, null, to);
    castor.getEventConnections().addConnection(model.getCastor());
    firePropertyChange(PROPERTY_ELEMENT_ADDED, null, model);
    return true;
  }

  public List<EventTransitionModel> getSourceTransitions(CompositeInputEventModel model)
  {
    ArrayList<EventTransitionModel> result = new ArrayList<EventTransitionModel>();
    // Nur wenn es für diesen Port ein Gegenport gibt, wird dieser
    // zurückgeliefert
    //
    for (EventTransitionModel transition : eventTransitions)
    {
      if (transition.getFromObjectModel() == model)
        result.add(transition);
    }
    return result;
  }


  public List<ParameterTransitionModel> getSourceTransitions(ParameterModel model)
  {
    ArrayList<ParameterTransitionModel> result = new ArrayList<ParameterTransitionModel>();
    // Nur wenn es für diesen Port ein Gegenport gibt, wird dieser
    // zurückgeliefert
    //
    for (ParameterTransitionModel transition : parameterTransitions)
    {
      if (transition.getFromObjectModel() == model)
        result.add(transition);
    }
    return result;
  }

  public List<ValueTransitionModel> getValueTransitions()
  {
    return valueTransitions;
  }
  
  public List<ValueTransitionModel> getSourceTransitions(CompositeInputValueModel model)
  {
    ArrayList<ValueTransitionModel> result = new ArrayList<ValueTransitionModel>();
    // Nur wenn es für diesen Port ein Gegenport gibt, wird dieser
    // zurückgeliefert
    //
    for (ValueTransitionModel transition : valueTransitions)
    {
      if (transition.getFromObjectModel() == model)
        result.add(transition);
    }
    return result;
  }

  public List<EventTransitionModel> getTargetTransitions(InputEventModel model)
  {
    List<EventTransitionModel> result = new ArrayList<EventTransitionModel>();
    for (EventTransitionModel transition : eventTransitions)
    {
      if (transition.getToObjectModel() == model)
        result.add(transition);
    }
    return result;
  }

  public List<EventTransitionModel> getTargetTransitions(CompositeOutputEventModel model)
  {
    ArrayList<EventTransitionModel> result = new ArrayList<EventTransitionModel>();
    // Nur wenn es für diesen Port ein Gegenport gibt, wird dieser
    // zurückgeliefert
    //
    for (EventTransitionModel transition : eventTransitions)
    {
      if (transition.getToObjectModel() == model)
        result.add(transition);
    }
    return result;
  }

  public List<ValueTransitionModel> getTargetTransitions(CompositeOutputValueModel model)
  {
    ArrayList<ValueTransitionModel> result = new ArrayList<ValueTransitionModel>();
    // Nur wenn es für diesen Port ein Gegenport gibt, wird dieser
    // zurückgeliefert
    //
    for (ValueTransitionModel transition : valueTransitions)
    {
      if (transition.getToObjectModel() == model)
        result.add(transition);
    }
    return result;
  }
  public List<ValueTransitionModel> getSourceTransitions(OutputValueModel model)
  {
    List<ValueTransitionModel> result = new ArrayList<ValueTransitionModel>();
    for (ValueTransitionModel transition : valueTransitions)
    {
      if (transition.getFromObjectModel() == model)
        result.add(transition);
    }
    return result;
  }

  public List<AbstractTransitionModel> getTargetTransitions(InputValueModel model)
  {
    List<AbstractTransitionModel> result = new ArrayList<AbstractTransitionModel>();
    for (ValueTransitionModel transition : valueTransitions)
    {
      if (transition.getToObjectModel() == model)
        result.add(transition);
    }
    for (ParameterTransitionModel transition : parameterTransitions)
    {
      if (transition.getToObjectModel() == model)
        result.add(transition);
    }
    return result;
  }

  public List<EventTransitionModel> getSourceTransitions(OutputEventModel model)
  {
    List<EventTransitionModel> result = new ArrayList<EventTransitionModel>();
    for (EventTransitionModel transition : eventTransitions)
    {
      if (transition.getFromObjectModel() == model)
        result.add(transition);
    }
    return result;
  }
  
  public List<EventTransitionModel> getEventTransitions()
  {
    return eventTransitions;
  }
  
  public void calculateSourceTargetIdentifiert()
  {
    for (EventTransitionModel transition : getEventTransitions())
    {
      transition.calculateSourceTargetIdentifiert();
    }
    for (ValueTransitionModel transition : getValueTransitions())
    {
      transition.calculateSourceTargetIdentifiert();
    }
  }
}
