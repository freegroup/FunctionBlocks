package de.netallied.functionblock.modeleditor.fbt.network.util;

import java.beans.PropertyChangeEvent;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.jface.viewers.TextCellEditor;
import de.netallied.functionblock.model.INamedModel;

public abstract class EditableLabelEditPart extends PropertyAwareEditPart
{
  protected DirectEditManager manager;


  @Override
  public void performRequest(Request request)
  {
		if(request.getType() == RequestConstants.REQ_DIRECT_EDIT)
		{
      if (request instanceof DirectEditRequest  && !directEditHitTest(((DirectEditRequest) request).getLocation().getCopy()))
        return;
      performDirectEdit();
		}
  }

  protected final boolean directEditHitTest(Point requestLoc)
  {
    IFigure figure = getFigure();
    figure.translateToRelative(requestLoc);
    if (figure.containsPoint(requestLoc))
      return true;
    return false;
  }
  
  protected final void performDirectEdit()
  {
    if (manager == null)
    {
      GraphicalViewer viewer = (GraphicalViewer) getViewer();
//      ValidationMessageHandler handler = viewer.getValidationHandler();

      ILabelProvider f = (ILabelProvider)getFigure();
//      ColumnNameTypeCellEditorValidator columnNameTypeCellEditorValidator = new ColumnNameTypeCellEditorValidator(handler);

      manager = new ExtendedDirectEditManager(this, TextCellEditor.class, new LabelCellEditorLocator(f.getLabel()), f.getLabel(), null);
    }
    manager.show();
  }

	/**
	 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
	 */
  @Override
	public void propertyChange(PropertyChangeEvent ev)
	{
    if (ev.getSource()==getModel())
      refreshVisuals();
    else
      super.propertyChange(ev);
	}
	
	//******************* Editing related methods *********************/

	/**
	 * Creates edit policies and associates these with roles
	 */
	public void createEditPolicies()
	{
    installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new EditableLabelDirectEditPolicy());
	}

  
  /**
   * @param Handles
   *            name change during direct edit
   */
  public final void handleNameChange(String textValue)
  {
    ILabelProvider f = (ILabelProvider) getFigure();
//    f.getLabel().setVisible(false);
    setSelected(EditPart.SELECTED_NONE);
    f.getLabel().revalidate();
  }

  /**
   * Handles when successfully applying direct edit
   */
  protected final void commitNameChange(PropertyChangeEvent evt)
  {
    ILabelProvider f = (ILabelProvider) getFigure();
    f.getLabel().setText(((INamedModel)getModel()).getName());
    setSelected(EditPart.SELECTED_PRIMARY);
    f.getLabel().revalidate();
  }
  
  /**
   * Reverts state back to prior edit state
   */
  public final void revertNameChange(String oldValue)
  {
    ILabelProvider f = (ILabelProvider) getFigure();
//    f.getLabel().setVisible(true);
    setSelected(EditPart.SELECTED_PRIMARY);
    f.getLabel().revalidate();
  }

}