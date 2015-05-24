package de.netallied.functionblock.model;

import java.util.ArrayList;
import java.util.List;
import de.netallied.functionblock.model.castor.BasicFB;
import de.netallied.functionblock.model.castor.ECC;
import de.netallied.functionblock.model.castor.FBType;
import de.netallied.functionblock.model.castor.FBTypeChoice;
import de.netallied.functionblock.model.castor.InternalVars;
import de.netallied.functionblock.model.castor.VarDeclaration;
import de.netallied.functionblock.model.castor.With;

public class BasisFunctionBlockModel extends AbstractFunctionBlockModel 
{
  private final ECCDiagramModel   eccDiagram;
  private List<WithTransitionInModel>  transitionsIn;
  private List<WithTransitionOutModel>  transitionssOut;
  private List<Algorithm>               algorithms;
  private List<InternalVariableModel>   variables;

	public BasisFunctionBlockModel(FBType type) throws Exception 
	{
    super(type);

		// nur der basisFB hat ein ECC. CompositeFB hat diesen nicht.
    //
    if(getCastor().getFBTypeChoice()==null)
      getCastor().setFBTypeChoice(new FBTypeChoice());
    if(getCastor().getFBTypeChoice().getBasicFB()==null)
      getCastor().getFBTypeChoice().setBasicFB(new BasicFB());
    if(getCastor().getFBTypeChoice().getBasicFB().getECC()==null)
      getCastor().getFBTypeChoice().getBasicFB().setECC(new ECC());
    eccDiagram    = new ECCDiagramModel(this, getCastor().getFBTypeChoice().getBasicFB().getECC());
	}
  
  public void removeWithTransitionInModels(InputEventModel eventModel)
  {
    List<WithTransitionInModel> elements = new ArrayList<WithTransitionInModel>(getWithTransitionInModels());
    for (WithTransitionInModel trans : elements)
    {
      if(trans.getFromObjectModel() == eventModel)
        removeElement(trans);
    }
  }

  public void removeWithTransitionInModels(InputValueModel eventModel)
  {
    List<WithTransitionInModel> elements = new ArrayList<WithTransitionInModel>(getWithTransitionInModels());
    for (WithTransitionInModel trans : elements)
    {
      if(trans.getToObjectModel() == eventModel)
        removeElement(trans);
    }
  }

  public void removeWithTransitionInModels(OutputEventModel eventModel)
  {
    List<WithTransitionOutModel> elements = new ArrayList<WithTransitionOutModel>(getWithTransitionOutModels());
    for (WithTransitionOutModel trans : elements)
    {
      if(trans.getFromObjectModel() == eventModel)
        removeElement(trans);
    }
  }

  public void removeWithTransitionInModels(OutputValueModel eventModel)
  {
    List<WithTransitionOutModel> elements = new ArrayList<WithTransitionOutModel>(getWithTransitionOutModels());
    for (WithTransitionOutModel trans : elements)
    {
      if(trans.getToObjectModel() == eventModel)
        removeElement(trans);
    }
  }
  

  public List<WithTransitionInModel> getWithTransitionInModels(InputEventModel eventModel)
  {
    List<WithTransitionInModel> result = new ArrayList<WithTransitionInModel>();
    for (WithTransitionInModel trans : getWithTransitionInModels())
    {
      if(trans.getFromObjectModel()==eventModel)
        result.add(trans);
    }
    return result;
  }
  
  public List<WithTransitionOutModel> getWithTransitionOutModels(OutputEventModel eventModel)
  {
    List<WithTransitionOutModel> result = new ArrayList<WithTransitionOutModel>();
    for (WithTransitionOutModel trans : getWithTransitionOutModels())
    {
      if(trans.getFromObjectModel()==eventModel)
        result.add(trans);
    }
    return result;
  }
  

  public List<WithTransitionInModel> getWithTransitionInModels()
  {
    if(transitionsIn!=null)
      return transitionsIn;
    // Alle WITH-Transitions von diesem Functionsblock zusammen suchen
    //
    transitionsIn = new ArrayList<WithTransitionInModel>();
    for (InputEventModel eventModel : getInputEventModels())
    {
      for(int i = 0;i< eventModel.getCastor().getWithCount();i++)
      {
        With with = eventModel.getCastor().getWith(i);
        InputValueModel valueModel = getInputValueModel(with.getVar());
        transitionsIn.add( new WithTransitionInModel(eventModel, valueModel));
      }
    }
    return transitionsIn;
  }

  
  public List<WithTransitionOutModel> getWithTransitionOutModels()
  {
    if(transitionssOut!=null)
      return transitionssOut;
    // Alle WITH-Transitions von diesem Functionsblock zusammen suchen
    //
    transitionssOut = new ArrayList<WithTransitionOutModel>();
    for (OutputEventModel eventModel : getOutputEventModels())
    {
      for(int i = 0;i< eventModel.getCastor().getWithCount();i++)
      {
        With with = eventModel.getCastor().getWith(i);
        OutputValueModel valueModel = getOutputValueModel(with.getVar());
        transitionssOut.add( new WithTransitionOutModel(eventModel, valueModel));
      }
    }
    return transitionssOut;
  }

  public List<WithTransitionOutModel> getWithTransitionOutModels(OutputValueModel valueModel)
  {
    List<WithTransitionOutModel> result = new ArrayList<WithTransitionOutModel>();
    for (WithTransitionOutModel trans : getWithTransitionOutModels())
    {
      if(trans.getToObjectModel()==valueModel)
        result.add(trans);
    }
    return result;
  }
  
  public List<WithTransitionInModel> getWithTransitionInModels(InputValueModel valueModel)
  {
    List<WithTransitionInModel> result = new ArrayList<WithTransitionInModel>();
    for (WithTransitionInModel trans : getWithTransitionInModels())
    {
      if(trans.getToObjectModel()==valueModel)
        result.add(trans);
    }
    return result;
  }

  public List<Algorithm> getAlgorithms()
  {
    if(algorithms!=null)
      return algorithms;
    
    algorithms = new ArrayList<Algorithm>();
    for (de.netallied.functionblock.model.castor.Algorithm alg : getCastor().getFBTypeChoice().getBasicFB().getAlgorithm())
    {
      algorithms.add(new Algorithm(alg));
    }
    return algorithms;
  }
    
  public Algorithm getAlgorithm(String name)
  {
    for (Algorithm alg : getAlgorithms())
    {
      if(alg.getName().equals(name))
        return alg;
    }
    return null;
  }
   

  public void addElement(Algorithm algorithm)
  {
    getAlgorithms().add(algorithm);
    getCastor().getFBTypeChoice().getBasicFB().addAlgorithm(algorithm.getCastor());
    firePropertyChange(PROPERTY_ELEMENT_ADDED,null, algorithm);
  }
  
  
  public List<InternalVariableModel> getVariables()
  {
    if(variables!=null)
      return variables;
    
    variables = new ArrayList<InternalVariableModel>();
    
    // keine internen variblen vorhanden
    //
    if(getCastor().getFBTypeChoice().getBasicFB().getInternalVars()==null)
      return variables;
    
    for (VarDeclaration var : getCastor().getFBTypeChoice().getBasicFB().getInternalVars().getVarDeclaration())
    {
      variables.add(new InternalVariableModel( var));
    }
    return variables;
  }

  public InternalVariableModel getVariable(String name)
  {
    for (InternalVariableModel var : getVariables())
    {
      if(var.getName().equals(name))
        return var;
    }
    return null;
  }


  public void addElement(InternalVariableModel var)
  {
    getVariables().add(var);
    if(getCastor().getFBTypeChoice().getBasicFB().getInternalVars()==null)
      getCastor().getFBTypeChoice().getBasicFB().setInternalVars(new InternalVars());
    
    getCastor().getFBTypeChoice().getBasicFB().getInternalVars().addVarDeclaration(var.getCastor());
    firePropertyChange(PROPERTY_ELEMENT_ADDED,null, var);
  }
  
  public void addElement(WithTransitionInModel trans)
  {
    getWithTransitionInModels().add(trans);
    trans.getFromObjectModel().addWithElement(trans.getToObjectModel());
    
    for (int i=0;i<transitionsIn.size();i++)
    {
      transitionsIn.get(i).firePropertyChange(PROPERTY_CHILD_REORDER,null,trans); 
    }
    firePropertyChange(PROPERTY_ELEMENT_ADDED,null, trans);
  }
  
  public void addElement(WithTransitionOutModel trans)
  {
    getWithTransitionOutModels().add(trans);
    trans.getFromObjectModel().addWithElement(trans.getToObjectModel());
    
    for (int i=0;i<transitionssOut.size();i++)
    {
      transitionssOut.get(i).firePropertyChange(PROPERTY_CHILD_REORDER,null,trans); 
    }
    firePropertyChange(PROPERTY_ELEMENT_ADDED,null, trans);
  }
  
  public void removeElement(WithTransitionInModel trans)
  {
    getWithTransitionInModels().remove(trans);
    trans.getFromObjectModel().removeWithElement(trans.getToObjectModel());
    for (int i=0;i<transitionsIn.size();i++)
    {
     transitionsIn.get(i).firePropertyChange(PROPERTY_CHILD_REORDER,null,trans); 
    }
    
    firePropertyChange(PROPERTY_ELEMENT_REMOVED,trans, null);
  }

  public void removeElement(WithTransitionOutModel trans)
  {
    getWithTransitionOutModels().remove(trans);
    trans.getFromObjectModel().removeWithElement(trans.getToObjectModel());
    for (int i=0;i<transitionssOut.size();i++)
    {
     transitionssOut.get(i).firePropertyChange(PROPERTY_CHILD_REORDER,null,trans); 
    }
    
    firePropertyChange(PROPERTY_ELEMENT_REMOVED,trans, null);
  }

  public void removeElement(InternalVariableModel var)
  {
    int index = getVariables().indexOf(var);
    if(index!=-1)
    {
      getVariables().remove(var);
      getCastor().getFBTypeChoice().getBasicFB().getInternalVars().removeVarDeclaration(index);
    }
    if(getVariables().size()==0)
      getCastor().getFBTypeChoice().getBasicFB().setInternalVars(null);
    
    firePropertyChange(PROPERTY_ELEMENT_REMOVED,var, null);
  }

  public void removeElement(Algorithm var)
  {
    int index = getAlgorithms().indexOf(var);
    if(index!=-1)
    {
      getAlgorithms().remove(var);
      getCastor().getFBTypeChoice().getBasicFB().removeAlgorithm(index);
      firePropertyChange(PROPERTY_ELEMENT_REMOVED,var, null);
    }
  }

  
  
  public ECCDiagramModel getECCDiagramModel()
  {
    return eccDiagram;
  }

  public void renameEventModel(String oldName, String newName)
  {
    super.renameEventModel(oldName, newName);
    
    // dem ECC diagram mitteilen, dass sich ein Eventname geändert hat
    //
    eccDiagram.renameEventModel(oldName, newName);
  }

  public void renameValueModel(String oldName, String newName)
  {
    super.renameValueModel(oldName,newName);

    for (AbstractEventModel event : getInputEventModels())
      event.renameValueModel(oldName, newName);

    for (AbstractEventModel event : getOutputEventModels())
      event.renameValueModel(oldName, newName);
  }



}
