/*
 * Created on 27.11.2005
 *
 */
package de.netallied.functionblock.model;

import de.netallied.functionblock.model.castor.Connection;


public abstract class TransitionModel extends AbstractTransitionModel
{
  private final AbstractSourceModel fromModel;
  private final AbstractTargetModel toModel;
  private NetworkModel networkModel;
  
  private final Connection castor;
  
  public TransitionModel(NetworkModel networkModel,Connection connection, AbstractSourceModel from, AbstractTargetModel to)
  {
  	this.castor = connection;
    this.fromModel = from;
    this.toModel   = to;
    this.networkModel = networkModel;
  }
  
  public TransitionModel(NetworkModel networkModel, AbstractSourceModel from, AbstractTargetModel to)
  {
    this.fromModel = from;
    this.toModel   = to;
    this.networkModel = networkModel;

    this.castor = new Connection();

    this.castor.setSource(fromModel.getIdentifierName(networkModel));
    this.castor.setDestination(toModel.getIdentifierName(networkModel));
  }

  @Override
  public AbstractSourceModel getFromObjectModel()
  {
    return fromModel;
  }

  @Override
  public AbstractTargetModel getToObjectModel()
  {
    return toModel;
  }
 
  @Override
  public NetworkModel getNetworkFunctionBlockModel()
  {
    return networkModel;
  }

	public Connection getCastor() 
	{
		return castor;
	}
	
	public void calculateSourceTargetIdentifiert()
	{
    castor.setSource(fromModel.getIdentifierName(getNetworkFunctionBlockModel()));
    castor.setDestination(toModel.getIdentifierName(getNetworkFunctionBlockModel()));
	}
}
