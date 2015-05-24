/*
 * Created on 24.10.2006
 *
 */
package de.netallied.functionblock.model;

import org.eclipse.swt.graphics.Image;
import de.netallied.functionblock.contribution.codeeditor.CodeEditorManager;
import de.netallied.functionblock.model.castor.FBD;
import de.netallied.functionblock.model.castor.FBDDescriptor;
import de.netallied.functionblock.model.castor.LD;
import de.netallied.functionblock.model.castor.Other;
import de.netallied.functionblock.model.castor.ST;

public class Algorithm
{
  public final static String CODETYPE_ST   = "st"; 
  
  de.netallied.functionblock.model.castor.Algorithm castor;
  
  public Algorithm(String name)
  {
    this.castor = new de.netallied.functionblock.model.castor.Algorithm();
    this.castor.setName(name);
    this.castor.setComment("");
    this.castor.setST(new ST());
    this.castor.getST().setText("");
  }
  

  public Algorithm(de.netallied.functionblock.model.castor.Algorithm alg)
  {
    this.castor = alg;
  }
  
  public String getName()
  {
    return castor.getName();
  }

  public void setName(String newName)
  {
    castor.setName(newName);
  }
  
  public Image getImage()
  {
    return CodeEditorManager.getImage(getType());
  }
  
  public String getType()
  {
    if(castor.getST()!=null)
      return CODETYPE_ST;
    else
      return castor.getOther().getLanguage();
  }
  
  public void setType(String type)
  {
    String oldCode=getCode();
    if(!getType().equals(type))
      resetCodeType();
    
    if(CODETYPE_ST.equals(type))
    {
      castor.setST(new ST());
    }
    else
    {
      castor.setOther(new Other());
      castor.getOther().setLanguage(type);
    }
    
    setCode(oldCode);
  }
  
  public String getCode()
  {
    if(castor.getST()!=null)
      return castor.getST().getText();
    else
      return castor.getOther().getText();
  }

  public void setCode(String text)
  {
    if(castor.getST()!=null)
      castor.getST().setText(text);
    else
      castor.getOther().setText(text);
  }


  public de.netallied.functionblock.model.castor.Algorithm getCastor()
  {
    return castor;
  }
  
  private void resetCodeType()
  {
    castor.setFBD(null);
    castor.setLD(null);
    castor.setOther(null);
    castor.setST(null);
  }


}
