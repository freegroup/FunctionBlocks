/*
 * Created on 31.07.2006
 *
 */
package de.netallied.functionblock.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import de.netallied.functionblock.model.castor.ECC;
import de.netallied.functionblock.model.castor.ECState;
import de.netallied.functionblock.model.castor.ECTransition;

public class ECCDiagramModel extends ObjectModel 
{
  
  ECC castor;
  
  private final List<ECCAbstractStateModel> elements;
  private final List<ECCTransitionModel>    transitions;

  private final BasisFunctionBlockModel functionBlockModel;
  
  public ECCDiagramModel(BasisFunctionBlockModel functionBlockModel, ECC ecc)
  {
    this.castor = ecc;
    this.functionBlockModel = functionBlockModel;
    
    elements = new ArrayList<ECCAbstractStateModel>();
    for(int i=0; i<castor.getECStateCount();i++)
    {
      ECState state = castor.getECState(i);
      if(START_NODE_ID.equalsIgnoreCase(state.getName()))
        elements.add(new ECCStartModel(this, state));
      else
        elements.add(new ECCStateModel(this, state));
    }
    
    transitions = new ArrayList<ECCTransitionModel>();
    for (int i = 0; i < castor.getECTransitionCount(); i++)
    {
      ECTransition castorTransition = castor.getECTransition(i);
      transitions.add(new ECCTransitionModel(this,castorTransition));
    }
  }
  
  
  public ECC getCastor()
  {
    return castor;
  }
  
  public List<ECCAbstractStateModel> getElements()
  {
    return elements;
  }

  public ECCAbstractStateModel getElement(String name)
  {
    for(ECCAbstractStateModel model : elements)
    {
      if(model.getName().equals(name))
        return model;
    }
    return null;
  }
  
  public boolean addElement(ECCAbstractStateModel obj)
  {
    if (elements.add(obj)) 
    {
      castor.addECState(obj.getCastor());
      // Falls das Element noch keinen vernünftigen Namen hat, dann wird dieser jetzt
      // gesetzt.
      if(obj.getCastor().getName()==null)
      {
        String defaultName = "state";
        int i=1;
        while(getElement(defaultName+i)!=null)
        {
          i++;
        }
        obj.getCastor().setName(defaultName+i);
      }
      obj.setParentModel(this);
      firePropertyChange(PROPERTY_ELEMENT_ADDED, null, obj);
      return true;
    }
    return false;
  }
  
  /** 
   * Add a shape to this diagram.
   * @param transition a non-null shape instance
   * @return true, if the shape was added, false otherwise
   */
  public boolean addElement(ECCTransitionModel transition) 
  {
    if(transitions.add(transition)) 
    {
      castor.addECTransition(transition.getCastor());
      firePropertyChange(PROPERTY_ELEMENT_ADDED, null, transition);
      return true;
    }
    return false;
  }

  public boolean removeElement(ECCAbstractStateModel obj)
  {
    int i=elements.indexOf(obj);
    if (i != -1) 
    {
      elements.remove(obj);
      castor.removeECState(i);
      firePropertyChange(PROPERTY_ELEMENT_REMOVED, obj,null);
      return true;
    }
    return false;
  }

  /**
   * Remove a shape from this diagram.
   * @param s a non-null shape instance;
   * @return true, if the shape was removed, false otherwise
   */
  public boolean removeElement(ECCTransitionModel t) 
  {
    int i=transitions.indexOf(t);
    if (i != -1) 
    {
      transitions.remove(t);
      t.getSource().removeConnection(t);
      t.getTarget().removeConnection(t);
      castor.removeECTransition(i);
      firePropertyChange(PROPERTY_ELEMENT_REMOVED, t,null);
      return true;
    }
    return false;
  }

  public List<ECCTransitionModel> getTransitionModels()
  {
    return transitions;
  }


  public void renameEventModel(String oldName, String newName)
  {
    // Allen Zuständen mitteilen, dass sich ein Eventname geändert hat
    //
    for (ECCAbstractStateModel state : getElements())
    {
      state.renameEventModel(oldName, newName);
    }
    
    // Allen Übergängen mitteilen, dass sich ein Eventname geändert hat
    //
    for (ECCTransitionModel transition : getTransitionModels())
    {
      transition.renameEventModel(oldName, newName);
    }
  }


  public BasisFunctionBlockModel getFunctionBlockModel()
  {
    return functionBlockModel;
  }
}
