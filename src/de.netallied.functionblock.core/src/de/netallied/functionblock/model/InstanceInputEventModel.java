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

import de.netallied.functionblock.model.castor.Event;

public class InstanceInputEventModel extends InputEventModel
{
  InstanceFunctionBlockModel instanceFunctionBlock;
  
  public InstanceInputEventModel(InstanceFunctionBlockModel parent, Event event)
  {
    super(parent.getTypeModel().getFunctionBlockModel(), event);
    instanceFunctionBlock = parent;
  }

  /**
   * Note: used in velocity templates for code generation
   * @return 
   */
  public INamedModel getParentNameProvider()
  {
    return instanceFunctionBlock;
  }

}
