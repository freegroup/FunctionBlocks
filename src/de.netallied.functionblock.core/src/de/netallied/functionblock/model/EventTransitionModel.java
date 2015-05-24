package de.netallied.functionblock.model;

import de.netallied.functionblock.model.castor.Connection;

public class EventTransitionModel extends TransitionModel
{

	public EventTransitionModel(NetworkModel networkModel, Connection connection, AbstractSourceModel from, AbstractTargetModel to) 
	{
		super(networkModel, connection, from, to);
	}

	public EventTransitionModel(NetworkModel networkModel, AbstractSourceModel from, AbstractTargetModel to) 
	{
		super(networkModel, from, to);
	}
}
