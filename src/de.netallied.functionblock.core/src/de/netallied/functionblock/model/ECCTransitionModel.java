package de.netallied.functionblock.model;

import org.apache.oro.text.regex.MalformedPatternException;
import org.apache.oro.text.regex.Pattern;
import org.apache.oro.text.regex.PatternCompiler;
import org.apache.oro.text.regex.Perl5Compiler;
import org.apache.oro.text.regex.Perl5Matcher;
import org.apache.oro.text.regex.Perl5Substitution;
import org.apache.oro.text.regex.Util;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;
import de.netallied.functionblock.Activator;
import de.netallied.functionblock.model.castor.ECTransition;

public class ECCTransitionModel extends ObjectModel
{
  ECTransition castor;
  ECCDiagramModel parentModel;
  transient int id=0;
  private static int startCounter=0;

  public ECCTransitionModel(ECCAbstractStateModel source, ECCAbstractStateModel target)
  {
    castor = new ECTransition();
    castor.setCondition("1");
    connect(source, target);
    this.parentModel = source.getParentModel();
    this.id = startCounter++;
  }

  public ECCTransitionModel(ECCDiagramModel parent, ECTransition model)
  {
    this.castor      = model;
    this.parentModel = parent;
    this.id = startCounter++;
  }


  /**
   * Returns the descriptor for the lineStyle property
   * 
   * @see org.eclipse.ui.views.properties.IPropertySource#getPropertyDescriptors()
   */
  public IPropertyDescriptor[] getPropertyDescriptors()
  {
    IPropertyDescriptor[] superDescriptors = super.getPropertyDescriptors();
    IPropertyDescriptor[] descriptors = new IPropertyDescriptor[superDescriptors.length + 1];
    for (int i = 0; i < superDescriptors.length; i++)
      descriptors[i] = superDescriptors[i];
    descriptors[superDescriptors.length]   =  new TextPropertyDescriptor(ID_PROPERTY_CONDITION,"Condition");

    return descriptors;
  }

  /**
   * Returns the lineStyle as String for the Property Sheet
   * 
   * @see org.eclipse.ui.views.properties.IPropertySource#getPropertyValue(java.lang.Object)
   */
  public Object getPropertyValue(Object id)
  {
    if (id.equals(ID_PROPERTY_CONDITION))
      return getCondition();
    return super.getPropertyValue(id);
  }


  /**
   * Sets the lineStyle based on the String provided by the PropertySheet
   * 
   * @see org.eclipse.ui.views.properties.IPropertySource#setPropertyValue(java.lang.Object,
   *      java.lang.Object)
   */
  public void setPropertyValue(Object id, Object value)
  {
    if (id.equals(ID_PROPERTY_CONDITION))
      setCodition((String)value);
    else
      super.setPropertyValue(id, value);
  }

  /**
   * Returns the source endpoint of this connection.
   * 
   * @return a non-null ECCAbstractStateModel instance
   */
  public ECCAbstractStateModel getSource()
  {
    return parentModel.getElement(castor.getSource());
  }

  /**
   * Returns the target endpoint of this connection.
   * 
   * @return a non-null ECCAbstractStateModel instance
   */
  public ECCAbstractStateModel getTarget()
  {
    return parentModel.getElement(castor.getDestination());
  }

  public Point getFulcrum()
  {
    return new Point((int)castor.getX(), (int)castor.getY());
  }
  
  public void setFulcrum(Point newLocation)
  {
    Point save = getFulcrum();
    if (save.equals(newLocation))
      return;
    
    castor.setX(newLocation.x);
    castor.setY(newLocation.y);
    firePropertyChange(PROPERTY_POSITION_CHANGED, save, newLocation);
  }

  /**
   * Reconnect to a different source and/or target shape. The connection will
   * disconnect from its current attachments and reconnect to the new source and
   * target.
   * 
   */
  public void connect(ECCAbstractStateModel newSource, ECCAbstractStateModel newTarget)
  {
    castor.setSource(newSource.getName());
    castor.setDestination(newTarget.getName());
    newTarget.addConnection(this);
    newSource.addConnection(this);
  }


  public ECTransition getCastor()
  {
    return castor;
  }

  public ECCDiagramModel getParentModel()
  {
    return parentModel;
  }

  public String getCondition()
  {
    return castor.getCondition();
  }
  
  public void setCodition(String condition)
  {
    String save = getCondition();
    if(save.equals(condition))
      return;
    
    castor.setCondition(condition);
    firePropertyChange(PROPERTY_CONDITION_CHANGED, save,condition);
  }

  public void renameEventModel(String oldName, String newName)
  {
    try
    {
      String condition = this.castor.getCondition();
      
      if(condition!=null && condition.length()>0)
      {
        Perl5Matcher matcher     = new Perl5Matcher();
        PatternCompiler compiler = new Perl5Compiler();
        Pattern         pattern  = compiler.compile("(.*\\W|^)"+oldName+"(\\W|$.*)");

        setCodition(Util.substitute(matcher, pattern, new Perl5Substitution("$1"+newName+"$2"),condition,Util.SUBSTITUTE_ALL));
      }
      System.out.println("renamed transition condition from ["+condition+"] to ["+getCondition()+"]");
    }
    catch (MalformedPatternException e)
    {
      Activator.getDefault().showException(e);
    }
  }

  public int getId()
  {
    return id;
  }
}