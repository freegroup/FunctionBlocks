/*
 * Created on 09.01.2007
 *
 */
package de.netallied.functionblock.model;

import de.netallied.functionblock.model.castor.ECState;

public class ECCStartModel extends ECCStateModel
{
  public ECCStartModel()
  {
  }

  public ECCStartModel(ECCDiagramModel parent, ECState state)
  {
    super(parent, state);
  }

  /**
   * It is not possible to change the name of the start node
   * 
   */
  @Override
  public void setName(String name)
  {
    super.setName(ECCDiagramModel.START_NODE_ID);
  }
  
  
}
