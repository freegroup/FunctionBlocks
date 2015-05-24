/*******************************************************************************
 * Copyright (c) 2004 Elias Volanakis.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 *
 * Contributors:
 *ï¿½ï¿½ï¿½ï¿½Elias Volanakis - initial API and implementation
 *******************************************************************************/
package de.netallied.functionblock.modeleditor.fbt.network.editpart;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.gef.CompoundSnapToHelper;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.SnapToGrid;
import org.eclipse.gef.SnapToHelper;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.RootComponentEditPolicy;
import de.netallied.functionblock.model.CompositeFunctionBlockModel;
import de.netallied.functionblock.model.NetworkModel;
import de.netallied.functionblock.model.ObjectModel;
import de.netallied.functionblock.modeleditor.fbt.network.editpolicy.NetworkLayoutEditPolicy;
import de.netallied.functionblock.modeleditor.fbt.network.figure.NetworkFigure;

/**
 * EditPart for the a ShapesDiagram instance.
 * <p>
 * This edit part server as the main diagram container, the white area where
 * everything else is in. Also responsible for the container's layout (the way
 * the container rearanges is contents) and the container's capabilities (edit
 * policies).
 * </p>
 * <p>
 * This edit part must implement the PropertyChangeListener interface, so it can
 * be notified of property changes in the corresponding model element.
 * </p>
 * 
 */
public class NetworkModelEditPart extends AbstractGraphicalEditPart implements PropertyChangeListener
{
  /**
   * Upon activation, attach to the model element as a property change listener.
   */
  @Override
  public void activate()
  {
    if (!isActive())
    {
      super.activate();
      ((ObjectModel) getModel()).addPropertyChangeListener(this);
    }
  }

 
  /**
   * Upon deactivation, detach from the model element as a property change
   * listener.
   */
  @Override
  public void deactivate()
  {
    if (isActive())
    {
      super.deactivate();
      ((ObjectModel) getModel()).removePropertyChangeListener(this);
    }
  }

	/*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
   */
  @Override
  protected void createEditPolicies()
  {
    // disallows the removal of this edit part from its parent
    installEditPolicy(EditPolicy.COMPONENT_ROLE, new RootComponentEditPolicy());
    // handles constraint changes (e.g. moving and/or resizing) of model
    // elements
    // and creation of new model elements
    XYLayout layout = (XYLayout) getContentPane().getLayoutManager();
    installEditPolicy(EditPolicy.LAYOUT_ROLE, new NetworkLayoutEditPolicy(this, layout));
   }
  
  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
   */
  @Override
  protected IFigure createFigure()
  {
    return new NetworkFigure();
  }


  public NetworkModel getNetworkModel()
  {
    return (NetworkModel) getModel();
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.editparts.AbstractEditPart#getModelChildren()
   */
  @Override
  protected List getModelChildren()
  {
    List result = new ArrayList();
    // Hier kommen die eigentliche mitglieder von dem Composit.
    //
    result.addAll(getNetworkModel().getElements());

    // Hier werden noch die Port des Composit Elements hinzugefügt.
    // Somit hat man die Möglichkeit von einem InstanceFunctionBlock zu
    // dem eigentlichen "Makro" Elementports Verbindungen zu ziehen.
    // (MÜSSEN NACH: getCompositeFunctionBlockModel().getInstanceElements() eingefügt werden
    // da diese Elemente bezug auf InstanceElemente nehmen)
    //
    result.addAll(((CompositeFunctionBlockModel)getNetworkModel().getParent()).getUsedCompositeInputEventModels());
    result.addAll(((CompositeFunctionBlockModel)getNetworkModel().getParent()).getUsedCompositeOutputEventModels());
    result.addAll(((CompositeFunctionBlockModel)getNetworkModel().getParent()).getUsedCompositeInputValueModels());
    result.addAll(((CompositeFunctionBlockModel)getNetworkModel().getParent()).getUsedCompositeOutputValueModels());
    
    return result;
  }

  @Override
  public Object getAdapter(Class adapter) 
  {
    if (adapter == SnapToHelper.class) 
    {
      List snapStrategies = new ArrayList();
      Boolean val = (Boolean)getViewer().getProperty(SnapToGrid.PROPERTY_GRID_ENABLED);
      if (val != null && val.booleanValue())
        snapStrategies.add(new SnapToGrid(this));
      
      if (snapStrategies.size() == 0)
        return null;
      if (snapStrategies.size() == 1)
        return (SnapToHelper)snapStrategies.get(0);

      SnapToHelper ss[] = new SnapToHelper[snapStrategies.size()];
      for (int i = 0; i < snapStrategies.size(); i++)
        ss[i] = (SnapToHelper)snapStrategies.get(i);
      return new CompoundSnapToHelper(ss);
    }
    return super.getAdapter(adapter);
  }
  
  /*
   * (non-Javadoc)
   * 
   * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
   */
  public void propertyChange(PropertyChangeEvent evt)
  {
    String prop =evt.getPropertyName();
    if (ObjectModel.PROPERTY_ELEMENT_ADDED==prop)
      refreshChildren();
    else if (ObjectModel.PROPERTY_ELEMENT_REMOVED==prop)
      refreshChildren();
  }
}