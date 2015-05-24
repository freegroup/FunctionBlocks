package de.netallied.functionblock.model;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import de.netallied.functionblock.model.castor.ECAction;
import de.netallied.functionblock.model.castor.ECState;
import de.netallied.functionblock.util.IntegerPropertyGroupingDescriptor;

/**
 */

public abstract class ECCAbstractStateModel extends ObjectModel implements INamedModel
{
  private final ECState castor;
  private final List<ECCStateActionModel> elements;

  private ECCDiagramModel parentModel;
  private BasisFunctionBlockModel functionBlockModel;
  
  
  public ECCAbstractStateModel()
  {
    castor = new ECState();
    elements = new ArrayList<ECCStateActionModel>();
  }

  public ECCAbstractStateModel(ECCDiagramModel parent, ECState state)
  {
    this.castor = state;
    this.parentModel = parent;
    this.functionBlockModel = parent.getFunctionBlockModel();
    
    elements = new ArrayList<ECCStateActionModel>();
    for (int i = 0; i < state.getECActionCount(); i++)
    {
      ECAction castorAction = state.getECAction(i);
      ECCStateActionModel action = new ECCStateActionModel(this.functionBlockModel, castorAction);
      elements.add(action);
    }
  }

  /**
   * Return the Location of this shape.
   * 
   * @return a non-null location instance
   */
  public Point getLocation()
  {
    return new Point(castor.getX(), castor.getY());
  }

  public IPropertyDescriptor[] getPropertyDescriptors()
  {
    IPropertyDescriptor[] superDescriptors = super.getPropertyDescriptors();
    IPropertyDescriptor[] descriptors = new IPropertyDescriptor[superDescriptors.length + 2];
    for (int i = 0; i < superDescriptors.length; i++)
      descriptors[i] = superDescriptors[i];
    descriptors[superDescriptors.length] = new IntegerPropertyGroupingDescriptor(ID_PROPERTY_X, "X", "Position");
    descriptors[superDescriptors.length + 1] = new IntegerPropertyGroupingDescriptor(ID_PROPERTY_Y, "Y", "Position");
    return descriptors;
  }

  /**
   * Return the property value for the given propertyId, or null.
   * <p>
   * The property view uses the IDs from the IPropertyDescriptors array to
   * obtain the value of the corresponding properties.
   * </p>
   * 
   * @see #descriptors
   * @see #getPropertyDescriptors()
   */
  public Object getPropertyValue(Object propertyId)
  {
    if (ID_PROPERTY_X == propertyId)
      return Integer.toString(getLocation().x);
    if (ID_PROPERTY_Y == propertyId)
      return Integer.toString(getLocation().y);
    return super.getPropertyValue(propertyId);
  }

  /**
   * Set the property value for the given property id. If no matching id is
   * found, the call is forwarded to the superclass.
   * <p>
   * The property view uses the IDs from the IPropertyDescriptors array to set
   * the values of the corresponding properties.
   * </p>
   * 
   * @see #descriptors
   * @see #getPropertyDescriptors()
   */
  public void setPropertyValue(Object propertyId, Object value)
  {
    if (ID_PROPERTY_X.equals(propertyId))
    {
      int x = Integer.parseInt((String) value);
      setLocation(new Point(x, getLocation().y));
    }
    else if (ID_PROPERTY_Y.equals(propertyId))
    {
      int y = Integer.parseInt((String) value);
      setLocation(new Point(getLocation().x, y));
    }
    else
    {
      super.setPropertyValue(propertyId, value);
    }
  }

  /**
   * Return a List of outgoing Connections.
   */
  public List<ECCTransitionModel> getSourceConnections()
  {
    List<ECCTransitionModel> result = new ArrayList<ECCTransitionModel>();
    for (ECCTransitionModel transition : getParentModel().getTransitionModels())
    {
      if(transition.getSource()==this)
        result.add(transition);
    }
    return result;
  }

  /**
   * Return a List of incoming Connections.
   */
  public List<ECCTransitionModel> getTargetConnections()
  {
    List<ECCTransitionModel> result = new ArrayList<ECCTransitionModel>();
    for (ECCTransitionModel transition : getParentModel().getTransitionModels())
    {
      if(transition.getTarget()==this)
        result.add(transition);
    }
    return result;
  }

  /**
   * Set the Location of thi * Copyright (c) 2005, 2006 IBM Corporation and others.
s shape.
   * 
   * @param newLocation
   *          a non-null Point instance
   * @throws IllegalArgumentException
   *           if the parameter is null
   */
  public void setLocation(Point newLocation)
  {
    Point save = getLocation();
    if (save.equals(newLocation))
      return;
    castor.setX(newLocation.x);
    castor.setY(newLocation.y);
    firePropertyChange(PROPERTY_POSITION_CHANGED, save, newLocation);
    
    // adjust the fulcrum of any transition which has this state as target.
    //
    int xDiff = newLocation.x-save.x;
    int yDiff = newLocation.y-save.y;
    
    for (ECCTransitionModel transistion : getTargetConnections())
    {
      transistion.setFulcrum(transistion.getFulcrum().getTranslated(xDiff,yDiff));
    } 
  }

  public List<ECCStateActionModel> getElements()
  {
    return elements;
  }
  

  public void removeElement(ECCStateActionModel child)
  {
    int index = elements.indexOf(child);
    if(index!=-1)
    {
      elements.remove(child);
      castor.removeECAction(index);
      
      firePropertyChange(PROPERTY_ELEMENT_REMOVED, child, null);
    }
  }


  public void addElement(ECCStateActionModel child)
  {
    elements.add(child);
    castor.addECAction(child.getCastor());
    child.setFunctionBlockModel(functionBlockModel);
    
    firePropertyChange(PROPERTY_ELEMENT_ADDED, null, child);
  }
  
  
  protected ECState getCastor()
  {
    return castor;
  }

  public void setName(String name)
  {
    String save = getName();
    if(save.equals(name))
      return;
    
    // Alle Verbindungen welche auf dieses Element zeigen abändern
    //
    for (ECCTransitionModel trans : getSourceConnections())
    {
      trans.getCastor().setSource(name);
    }
    
    for (ECCTransitionModel trans : getTargetConnections())
    {
      trans.getCastor().setDestination(name);
    }

    castor.setName(name);
    firePropertyChange(PROPERTY_NAME_CHANGED,save,name);
  }
  
  public String getName()
  {
    return castor.getName() == null ? "" : castor.getName();
  }

  public String getComment()
  {
    return castor.getComment()==null?"":castor.getComment();
  }
  
  public void setComment(String comment)
  {
    String save = getComment();
    if(save.equals(comment))
      return;
    
    castor.setComment(comment);
    firePropertyChange(PROPERTY_COMMENT_CHANGED, save,comment);
  }
  
  public ECCDiagramModel getParentModel()
  {
    return parentModel;
  }

  public void setParentModel(ECCDiagramModel parentModel)
  {
    this.parentModel = parentModel;
    this.functionBlockModel = parentModel.getFunctionBlockModel();
  }
  
  final void addConnection(ECCTransitionModel conn)
  {
      firePropertyChange(ObjectModel.SOURCE_CONNECTIONS_PROP, null, conn);
      firePropertyChange(ObjectModel.TARGET_CONNECTIONS_PROP, null, conn);
  }


  /**
   * Remove an incoming or outgoing connection from this shape.
   * 
   * @param conn
   *          a non-null connection instance
   * @throws IllegalArgumentException
   *           if the parameter is null
   */
  final void removeConnection(ECCTransitionModel conn)
  {
      firePropertyChange(ObjectModel.SOURCE_CONNECTIONS_PROP, null, conn);
      firePropertyChange(ObjectModel.TARGET_CONNECTIONS_PROP, null, conn);
  }

  public void renameEventModel(String oldName, String newName)
  {
    // Allen Aktionen mitteilen, dass sich ein Event geändert hat
    //
    for (ECCStateActionModel action : getElements())
    {
      if(action.getOutput().equals(oldName))
        action.setOutput(newName);
    }
  }

  public AbstractFunctionBlockModel getFunctionBlockModel()
  {
    return functionBlockModel;
  }

  public boolean isStartNode()
  {
    return START_NODE_ID.equals(getName());
  }
}