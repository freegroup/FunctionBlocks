package de.netallied.functionblock.modeleditor.fbt.ecc.commands;
import java.util.Iterator;
import java.util.List;
import org.eclipse.gef.commands.Command;
import de.netallied.functionblock.model.ECCAbstractStateModel;
import de.netallied.functionblock.model.ECCDiagramModel;
import de.netallied.functionblock.model.ECCTransitionModel;

public class DeleteStateCommand extends Command
{
  private final ECCAbstractStateModel child;
  private final ECCDiagramModel parent;
  private final List<ECCTransitionModel>  sourceConnections;
  private final List<ECCTransitionModel>  targetConnections;

  public DeleteStateCommand(ECCDiagramModel parent, ECCAbstractStateModel child)
  {
    if (parent == null || child == null)
    {
      throw new IllegalArgumentException();
    }
    setLabel("state deletion");
    this.parent = parent;
    this.child = child;
    // store a copy of incoming & outgoing connections before proceeding
    sourceConnections = child.getSourceConnections();
    targetConnections = child.getTargetConnections();
  }


  @Override
  public boolean canExecute()
  {
    if(child.isStartNode())
      return false;
    return super.canExecute();
  }


  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.commands.Command#execute()
   */
  public void execute()
  {
    removeConnections(sourceConnections);
    removeConnections(targetConnections);
    parent.removeElement(child);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.commands.Command#undo()
   */
  public void undo()
  {
    parent.addElement(child);
    addConnections(sourceConnections);
    addConnections(targetConnections);
  }

  /**
   * Disconnects a List of Connections from their endpoints.
   * 
   * @param connections
   *          a non-null List of connections
   */
  private void removeConnections(List<ECCTransitionModel> connections)
  {
    for (ECCTransitionModel model : connections)
    {
      parent.removeElement(model);
    }
  }
  
  private void addConnections(List<ECCTransitionModel> connections)
  {
    for (ECCTransitionModel model : connections)
    {
      parent.addElement(model);
      model.connect(model.getSource(), model.getTarget());
    }
  }
}