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
package de.netallied.functionblock.modeleditor.sys.network.figure;

import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Insets;
import de.netallied.functionblock.modeleditor.sys.network.Activator;
import de.netallied.functionblock.modeleditor.sys.network.Constants;

/**
 * Figure used to hold the column labels
 * @author Phil Zoio
 */
public class ResourceFigure extends Label
{
	Insets INSETS = new Insets(8,5,0,0);
	
	public ResourceFigure()
	{
		setFont(Constants.FONT_NORMAL);
		setForegroundColor(Constants.COLOR_FONT);
    setIcon(Activator.getDefault().getImage("figure_resource.png"));
    setLabelAlignment(PositionConstants.LEFT);
	}

	public Insets getInsets() 
  {
		return INSETS;
	}
	
}