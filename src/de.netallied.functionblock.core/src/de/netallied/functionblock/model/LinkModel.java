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
package de.netallied.functionblock.model;

import de.netallied.functionblock.model.castor.Link;


/**
 * A connection between two distinct shapes.
 * @author Elias Volanakis
 */
public class LinkModel extends ObjectModel
{
  private boolean isConnected;

  private SystemModel systemModel;

  private Link castor;
  
  public LinkModel()
  {
   this.castor = new Link();
   this.castor.setSegmentName("Any Segment");
  }
  
  public LinkModel(SystemModel system, Link link)
  {
    isConnected = false;
    this.castor = link;
    this.systemModel = system;
  }
  
  /** 
   * Create a (solid) connection between two distinct shapes.
   * @param source a source endpoint for this connection (non null)
   * @param target a target endpoint for this connection (non null)
   * @throws IllegalArgumentException if any of the parameters are null or source == target
   * @see #setLineStyle(int) 
   */
  public LinkModel(DeviceModel source, SegmentModel target) 
  {
    this.castor = new Link();
    this.castor.setSegmentName("Any Segment");
    this.systemModel = source.getSystemModel();
    this.castor.setCommResource(source.getName());
    this.castor.setSegmentName(target.getName());
  }
  
  
  /**
   * Returns the source endpoint of this connection.
   * @return a non-null Shape instance
   */
  public DeviceModel getSource() 
  {
  	return systemModel.getDeviceModel(this.castor.getCommResource());
  }
  
  /**
   * Returns the target endpoint of this connection.
   * @return a non-null Shape instance
   */
  public SegmentModel getTarget() 
  {
    return systemModel.getSegmentModel(this.castor.getSegmentName());
  }
  
  public Link getCastor()
  {
    return castor;
  }

  public SystemModel getSystemModel()
  {
    return systemModel;
  }

  public void setSystemModel(SystemModel systemModel)
  {
    this.systemModel = systemModel;
  }
}