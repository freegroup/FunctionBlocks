package de.netallied.functionblock.modeleditor.fbt.ecc.commands;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import de.netallied.functionblock.model.ECCAbstractStateModel;

/**
 */
public class MoveStateCommand extends Command
{
	private final Point									newPoint;
	private final Point									oldPos;
	private final ECCAbstractStateModel	model;
	
	
	
	
	/**
	 * Create a command that can resize and/or move a model.
	 * 
	 * @param model
	 *          the model to manipulate
	 * @param req
	 *          the move and resize request
	 * @param newBounds
	 *          the new size and location
	 * @throws IllegalArgumentException
	 *           if any of the parameters is null
	 */
	public MoveStateCommand(ECCAbstractStateModel model, Point newPoint)
	{
		this.model    = model;
		this.newPoint = newPoint.getCopy();
		this.oldPos   = model.getLocation().getCopy();
		
		setLabel("move / resize");
	}
	
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	public void execute()
	{
		redo();
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#redo()
	 */
	public void redo()
	{
		model.setLocation(newPoint);
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	public void undo()
	{
		model.setLocation(oldPos);
	}
}
