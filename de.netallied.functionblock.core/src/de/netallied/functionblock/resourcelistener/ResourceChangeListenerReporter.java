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
package de.netallied.functionblock.resourcelistener;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;

/**
 * 
 */
public class ResourceChangeListenerReporter implements IResourceChangeListener
{
  
  /**
   * 
   * 
   * @param event 
   */
  public void resourceChanged(IResourceChangeEvent event) 
  {
    try
    {
	    IResource res = event.getResource();
	    switch (event.getType()) 
	    {
	       case IResourceChangeEvent.PRE_CLOSE:
	          System.out.print("Project ");
	          System.out.print(res.getFullPath());
	          System.out.println(" is about to close.");
	          break;
	       case IResourceChangeEvent.PRE_DELETE:
	          System.out.print("Project ");
	          System.out.print(res.getFullPath());
	          System.out.println(" is about to be deleted.");
	          break;
	       case IResourceChangeEvent.POST_CHANGE:
	          System.out.println("Resources have changed.");
	          event.getDelta().accept(new DeltaPrinter());
            event.getDelta().accept(new CacheUpdater());
	          break;
	       case IResourceChangeEvent.PRE_AUTO_BUILD:
	          System.out.println("Auto build about to run.");
	          event.getDelta().accept(new DeltaPrinter());
            event.getDelta().accept(new CacheUpdater());
	          break;
	       case IResourceChangeEvent.POST_AUTO_BUILD:
	          System.out.println("Auto build complete.");
            event.getDelta().accept(new DeltaPrinter());
            event.getDelta().accept(new CacheUpdater());
	          break;
	    }
	  }
	  catch(Exception exc)
	  {
	    
	  }
   }
}
