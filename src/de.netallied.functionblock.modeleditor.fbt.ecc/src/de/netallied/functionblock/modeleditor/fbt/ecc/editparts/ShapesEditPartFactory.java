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
package de.netallied.functionblock.modeleditor.fbt.ecc.editparts;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import de.netallied.functionblock.model.ECCDiagramModel;
import de.netallied.functionblock.model.ECCStartModel;
import de.netallied.functionblock.model.ECCStateActionModel;
import de.netallied.functionblock.model.ECCStateModel;
import de.netallied.functionblock.model.ECCTransitionModel;
/**
 * Factory that maps model elements to edit parts.
 * 
 * @author Elias Volanakis
 */
public class ShapesEditPartFactory implements EditPartFactory
{
  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.EditPartFactory#createEditPart(org.eclipse.gef.EditPart,
   *      java.lang.Object)
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
   * 
   * @throws RuntimeException
   *           if no match was found (programming error)
   */
  private EditPart getPartForElement(Object modelElement)
  {
    if (modelElement instanceof ECCDiagramModel)
      return new DiagramEditPart();
    if (modelElement instanceof ECCStartModel)
      return new StartEditPart();
    if (modelElement instanceof ECCStateModel)
      return new StateEditPart();
    if (modelElement instanceof ECCTransitionModel)
      return new ConnectionEditPart();
    if (modelElement instanceof ECCStateActionModel)
      return new StateActionEditPart();
    throw new RuntimeException("Can't create part for model element: " + ((modelElement != null) ? modelElement.getClass().getName() : "null"));
  }
}