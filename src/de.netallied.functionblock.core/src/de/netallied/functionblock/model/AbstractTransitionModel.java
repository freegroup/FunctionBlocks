/*
 * Created on 04.12.2005
 *
 */
package de.netallied.functionblock.model;


public abstract class AbstractTransitionModel extends ObjectModel
{
  public abstract AbstractTargetModel getToObjectModel();
  public abstract AbstractSourceModel getFromObjectModel();
  
  public abstract NetworkModel   getNetworkFunctionBlockModel();
}
