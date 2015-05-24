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

import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;

/**
 * 
 */
public class DeltaPrinter implements IResourceDeltaVisitor 
{
  
  /**
   * 
   * 
   * @param delta 
   * 
   * @return 
   */
  public boolean visit(IResourceDelta delta) 
  {/*
     IResource res = delta.getResource();
     switch (delta.getKind()) {
        case IResourceDelta.ADDED:
           System.out.print("Resource ");
           System.out.print(res.getFullPath());
           if(delta.getMovedFromPath()!=null)
             System.out.println(" was moved from:"+delta.getMovedFromPath());
           else
             System.out.println(" was added.");
           break;
        case IResourceDelta.REMOVED:
           System.out.print("Resource ");
           System.out.print(res.getFullPath());
           if(delta.getMovedToPath()!=null)
             System.out.println(" was moved to:"+delta.getMovedToPath());
           else
             System.out.println(" was removed.");
           break;
        case IResourceDelta.CHANGED:
          System.out.print("Resource ");
          System.out.print(delta.getFullPath());
          System.out.println(" has changed.");
          int flags = delta.getFlags();
          if ((flags & IResourceDelta.CONTENT) != 0) {
                System.out.println("--> Content Change");
          }
          if ((flags & IResourceDelta.REPLACED) != 0) {
                System.out.println("--> Content Replaced");
          }
          if ((flags & IResourceDelta.MARKERS) != 0) {
            System.out.println("--> Marker Change");
            IMarkerDelta[] markers = delta.getMarkerDeltas();
            // if interested in markers, check these deltas
          }
          break;     
       }
       */
     return true; // visit the children
  }
}
