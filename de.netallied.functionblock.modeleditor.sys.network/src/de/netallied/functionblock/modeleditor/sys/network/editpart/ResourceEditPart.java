/*******************************************************************************
 *    This file is part of Open-jACOB
 *    Copyright (C) 2005-2006 Tarragon GmbH
 * 
 *    This program is free software; you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation; version 2 of the License.
 * 
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 * 
 *    You should have received a copy of the GNU General Public License     
 *    along with this program; if not, write to the Free Software
 *    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  
 *    USA
 *******************************************************************************/
/*
 * Created on Jul 13, 2004
 */
package de.netallied.functionblock.modeleditor.sys.network.editpart;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import de.netallied.functionblock.cache.DeviceTypeModelCache;
import de.netallied.functionblock.cache.ResourceTypeModelCache;
import de.netallied.functionblock.model.ObjectModel;
import de.netallied.functionblock.model.ResourceModel;
import de.netallied.functionblock.model.ResourceTypeModel;
import de.netallied.functionblock.modeleditor.sys.network.figure.ResourceFigure;

/**
 * Represents the editable/resizable table which can have columns added,
 * removed, renamed etc.
 * 
 * @author Phil Zoio
 */
public class ResourceEditPart extends PropertyAwareEditPart
{
	/**
	 * Returns the Table model object represented by this EditPart
	 */
	public ResourceModel getResourceModel()
	{
		return (ResourceModel) getModel();
	}
  
  public void performRequest(Request req)
  {
		if(req.getType() == RequestConstants.REQ_OPEN)
		{
			ResourceTypeModel model = getResourceModel().getResourceTypeModel();
      IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();

      final IWorkbenchPage page = window.getActivePage();
      try {
        IProject project = model.getProject();
        IFile file =ResourceTypeModelCache.getIFile(project,model);
        IDE.openEditor(page, file, true);
      } catch (final PartInitException e) {
        e.printStackTrace();
      }
      
		}
  }


	/**
	 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
	 */
	public void propertyChange(PropertyChangeEvent ev)
	{
    if (ev.getPropertyName()==ObjectModel.PROPERTY_NAME_CHANGED)
      refreshVisuals();
    else
      super.propertyChange(ev);
	}
	
	//******************* Editing related methods *********************/

	/**
	 * Creates edit policies and associates these with roles
	 */
	public void createEditPolicies()
	{
//		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new TableNodeEditPolicy());
//		installEditPolicy(EditPolicy.LAYOUT_ROLE, new TableLayoutEditPolicy());
//		installEditPolicy(EditPolicy.CONTAINER_ROLE, new TableContainerEditPolicy());
//		installEditPolicy(EditPolicy.COMPONENT_ROLE, new TableAliasEditPolicy());
	}


	/**
	 * @see org.eclipse.gef.editparts.AbstractEditPart#toString()
	 */
	public String toString()
	{
		return getModel().toString();
	}

	/**
	 * Creates a figure which represents the table
	 */
	protected IFigure createFigure()
	{
//	  TableAliasModel alias = getTableAliasModel();
		return new ResourceFigure();
	}

	/**
	 * Reset the layout constraint, and revalidate the content pane
	 */
	protected void refreshVisuals()
	{
		ResourceFigure tableFigure = (ResourceFigure) getFigure();
		Point location = tableFigure.getLocation();
//		tableFigure.setImage(getFieldModel().getImage());
		tableFigure.setText(getResourceModel().getName());
	}
}