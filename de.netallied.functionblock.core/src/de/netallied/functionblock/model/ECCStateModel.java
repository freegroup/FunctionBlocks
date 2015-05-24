package de.netallied.functionblock.model;

import org.eclipse.swt.graphics.Image;
import de.netallied.functionblock.model.castor.ECState;

public class ECCStateModel extends ECCAbstractStateModel
{

  public ECCStateModel()
  {
    super();
  }
  
  
  public ECCStateModel(ECCDiagramModel parent, ECState state)
  {
    super(parent, state);
  }

}
