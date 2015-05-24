/*******************************************************************************
 * Copyright (c) 2004, 2005 Elias Volanakis and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Elias Volanakis - initial API and implementation
 *******************************************************************************/
package de.netallied.functionblock.modeleditor.sys.network.editpart;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import de.netallied.functionblock.model.LinkModel;
import de.netallied.functionblock.model.DeviceModel;
import de.netallied.functionblock.model.ResourceModel;
import de.netallied.functionblock.model.SegmentModel;
import de.netallied.functionblock.model.SystemModel;

/**
 * Factory that maps model elements to edit parts.
 * @author Elias Volanakis
 */
public class NetworkElementEditPartFactory implements EditPartFactory 
{

  /*
   * (non-Javadoc)
   * @see org.eclipse.gef.EditPartFactory#createEditPart(org.eclipse.gef.EditPart, java.lang.Object)
   */
  public EditPart createEditPart(EditPart context, Object modelElement) 
  {
  	// get EditPart for model element
  	EditPart part = getPartForElement(modelElement);
  	// store model element in EditPart
  	part.setModel(modelElement);
  	return part;
  }
  
  /**
   * Maps an object to an EditPart. 
   * @throws RuntimeException if no match was found (programming error)
   */
  private EditPart getPartForElement(Object modelElement) 
  {
  	if (modelElement instanceof SystemModel)
  		return new SystemEditPart();
  	if (modelElement instanceof SegmentModel)
  		return new SegmentEditPart();
    if (modelElement instanceof DeviceModel)
      return new DeviceEditPart();
    if (modelElement instanceof LinkModel)
      return new LinkEditPart();
    if (modelElement instanceof ResourceModel)
      return new ResourceEditPart();
  	throw new RuntimeException("Can't create part for model element: "	+ ((modelElement != null) ? modelElement.getClass().getName() : "null"));
  }

}