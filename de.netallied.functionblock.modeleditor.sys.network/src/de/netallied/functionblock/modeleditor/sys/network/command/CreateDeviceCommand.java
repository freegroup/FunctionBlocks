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
package de.netallied.functionblock.modeleditor.sys.network.command;

import java.util.Collection;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import de.netallied.functionblock.cache.DeviceTypeModelCache;
import de.netallied.functionblock.model.DeviceModel;
import de.netallied.functionblock.model.DeviceTypeModel;
import de.netallied.functionblock.model.SystemModel;
import de.netallied.functionblock.modeleditor.sys.network.Activator;

public class CreateDeviceCommand extends Command 
{
  private DeviceModel model;
  private final SystemModel parent;
  private Rectangle bounds;
  
  /**
   * Create a command that will add a new Shape to a SystemModel.
   * @param model the new Shape that is to be added
   * @param parent the SystemModel that will hold the new element
   * @param bounds the bounds of the new shape; the size can be (-1, -1) if not known
   * @throws IllegalArgumentException if any parameter is null, or the request
   * 						  does not provide a new Shape instance
   */
  public CreateDeviceCommand(DeviceModel model, SystemModel parent, Rectangle bounds) 
  {
  	this.model = model;
  	this.parent = parent;
  	this.bounds = bounds;
  	setLabel("device creation");
  }
  
  /**
   * Can execute if all the necessary information has been provided. 
   * @see org.eclipse.gef.commands.Command#canExecute()
   */
  public boolean canExecute() 
  {
  	return model != null && parent != null && bounds != null;
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.gef.commands.Command#execute()
   */
  public void execute() 
  {
    ElementListSelectionDialog dialog = new ElementListSelectionDialog(null, new LabelProvider()
    {
      public Image getImage(Object element)
      {
        return Activator.getDefault().getImage("figure_device.png");
      }

      public String getText(Object element)
      {
        return ((DeviceTypeModel)element).getName();
      }
    });

    Collection<DeviceTypeModel> x= DeviceTypeModelCache.getModels(parent.getProject());
    
    dialog.setElements(x.toArray());
    dialog.setTitle("Add a device to the system");
    dialog.setMessage("Select the device to add.");
    dialog.setMultipleSelection(false);
    dialog.create();
    if(dialog.open()==Window.OK && dialog.getFirstResult()!=null)
    {
      try
      {
        DeviceTypeModel alias= (DeviceTypeModel)dialog.getFirstResult();
      
        model.setLocation(bounds.getLocation());
        model.setSystemModel(parent);
        model.setType(alias.getName());
      	parent.addElement(model);
        String suggestedName = "Device_";
        String newName = suggestedName;
        for (int i = 0; i < 1000; i++)
        {
          newName = suggestedName+i;
          if(parent.getDeviceModel(newName)==null)
             break;
        }
        model.setName(newName);
      }
      catch(Exception exc)
      {
        Activator.getDefault().showException(exc);
      }
    }
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.gef.commands.Command#redo()
   */
  public void redo() 
  {
  	parent.addElement(model);
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.gef.commands.Command#undo()
   */
  public void undo() 
  {
  	parent.removeElement(model);
  }
	
}