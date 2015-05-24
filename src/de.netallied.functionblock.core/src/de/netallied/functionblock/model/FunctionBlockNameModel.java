/*******************************************************************************
 * Copyright (c) 2005, 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package de.netallied.functionblock.model;

import de.netallied.functionblock.model.castor.FBType;

public class FunctionBlockNameModel extends ObjectModel implements INamedModel
{
  FBType castor;
	
	public FunctionBlockNameModel(FBType fb)
	{
		this.castor = fb;
		
	}
	
	public String getComment()
	{
		return castor.getComment();
	}
	
  public void setComment(String comment)
  {
    castor.setComment(comment);
    firePropertyChange(PROPERTY_COMMENT_CHANGED, null,this);
  }

  public String getName()
	{
		return castor.getName();
	}
	
  public void setName(String name)
  {
    castor.setName(name);
    firePropertyChange(PROPERTY_NAME_CHANGED, null,this);
  }
  
  protected FBType getCastor()
  {
    return castor;
  }

}
