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

import de.netallied.functionblock.model.castor.VarDeclaration;
import de.netallied.functionblock.model.castor.types.VarDeclarationTypeType;

public class OutputValueModel extends AbstractValueModel implements AbstractSourceModel
{
  public OutputValueModel(AbstractFunctionBlockModel parent, String name)
  {
    super(parent, new VarDeclaration());
    getCastor().setName(name);
    getCastor().setType(VarDeclarationTypeType.INT);
  }
  
  public OutputValueModel(AbstractFunctionBlockModel parent,VarDeclaration var)
	{
    super(parent, var);
	}

  public String getIdentifierName(NetworkModel compositeModel)
  {
    // get the parent of this node
    //
    InstanceFunctionBlockModel fromFB = compositeModel.getInstanceElement(this);
    
    return fromFB.getName()+"."+this.getName();
  }
}
