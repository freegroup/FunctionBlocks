package de.netallied.functionblock.model;

import de.netallied.functionblock.model.castor.Connection;

public class ValueTransitionModel extends TransitionModel
{
	public ValueTransitionModel(NetworkModel networkModel, Connection connection, AbstractSourceModel from, AbstractTargetModel to) 
	{
		super(networkModel, connection, from, to);
	}

	public ValueTransitionModel(NetworkModel networkModel, AbstractSourceModel from, AbstractTargetModel to) 
	{
		super(networkModel, from, to);
	}
}
