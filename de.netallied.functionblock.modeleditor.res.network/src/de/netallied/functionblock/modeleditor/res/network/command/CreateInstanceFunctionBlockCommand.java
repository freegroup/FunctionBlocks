package de.netallied.functionblock.modeleditor.res.network.command;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateRequest;
import de.netallied.functionblock.model.InstanceFunctionBlockModel;
import de.netallied.functionblock.model.CompositeFunctionBlockModel;
import de.netallied.functionblock.model.NetworkModel;


public class CreateInstanceFunctionBlockCommand extends Command
{
  private final InstanceFunctionBlockModel model;
  private final NetworkModel               parent;
  private final Point                      location;
  
  /**
   * Create a command that will add a new Shape to a ShapesDiagram.
   * 
   * @param parent
   *          the ShapesDiagram that will hold the new element
   * @param req
   *          a request to create a new Shape
   * @throws IllegalArgumentException
   *           if any parameter is null, or the request does not provide a new
   *           Shape instance
   */
  public CreateInstanceFunctionBlockCommand(NetworkModel parent, InstanceFunctionBlockModel child, Point location)
  {
    this.parent = parent;
    this.model  = child;
    this.location= location;
    
    setLabel("Function Block inserted");
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.commands.Command#execute()
   */
  public void execute()
  {
    try
    {
    String suggestedName = model.getType();
    String newName = suggestedName;
    for (int i = 0; i < 1000; i++)
    {
      newName = suggestedName+i;
      if(parent.getInstanceElement(newName)==null)
         break;
    }
    // avoid model.setName(). Thy will fire an property Change event and the name of the object 
    // not set correct => error
    //
    model.setCastorName(newName);
    parent.addElement(model);
    model.setLocation(location);
    }
    catch(Exception exc)
    {
      exc.printStackTrace();
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.commands.Command#undo()
   */
  public void undo()
  {
    parent.removeElement(model);
  }
}
