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
import org.eclipse.draw2d.geometry.Point;
import de.netallied.functionblock.model.castor.Event;
import de.netallied.functionblock.model.castor.With;

/**
 * WICHTIG:
 * Ein CompositeInputEventModel ist ein "Source" und kein "Target", da man von
 * einem CompositeInputEventModel eine LinkModel zu einem InputEvent eines InstanceTypedFB..ziehen kann.
 *
 */
public class CompositeOutputValueModel extends AbstractInterfaceModel implements AbstractTargetModel
{
  private final OutputValueModel output;

  public CompositeOutputValueModel(OutputValueModel output)
  {
     this.output = output;
  }

  public OutputValueModel getOutputValueModel()
  {
    return this.output;
  }
  
  public AbstractFunctionBlockModel getAbstractFunctionBlockModel()
  {
    return output.getAbstractFunctionBlockModel();
  }

  public String getName()
  {
    return output.getName();
  }

  public String getIdentifierName(NetworkModel copositeModel)
  {
    return getName();
  }

  public String getComment()
  {
    return output.getComment();
  }

  public void setComment(String comment)
  {
    output.setComment(comment);
  }

  public void setName(String name)
  {
    output.setName(name);
  }

  /**
   * Note: used in velocity templates for code generation
   * @return 
   */
  public INamedModel getParentNameProvider()
  {
    return output.getAbstractFunctionBlockModel();
  }
}
