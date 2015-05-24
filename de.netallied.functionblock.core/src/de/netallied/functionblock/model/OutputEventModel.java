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

import java.util.ArrayList;
import java.util.List;
import de.netallied.functionblock.model.castor.Event;
import de.netallied.functionblock.model.castor.With;

public class OutputEventModel extends AbstractEventModel implements AbstractSourceModel
{

  public OutputEventModel(AbstractFunctionBlockModel parent, String name)
  {
    super(parent, new Event());
    getCastor().setName(name);
  }

  public OutputEventModel(AbstractFunctionBlockModel parent, Event event)
	{
    super(parent, event);
	}

  public List<AbstractValueModel> getWithElements()
  {
    List<AbstractValueModel> result = new ArrayList<AbstractValueModel>();
    
    for (int i = 0; i < getCastor().getWithCount(); i++)
    {
      With with = getCastor().getWith(i);
      result.add(getAbstractFunctionBlockModel().getOutputValueModel(with.getVar()));
    }
    return result;
  }

  public String getIdentifierName(NetworkModel compositeModel)
  {
    // get the parent of this node
    //
    InstanceFunctionBlockModel fromFB = compositeModel.getInstanceElement(this);
    
    return fromFB.getName()+"."+this.getName();
  }
  
}
