package de.netallied.functionblock.modeleditor.res.network.editpart;

import java.beans.PropertyChangeEvent;
import java.util.Iterator;
import java.util.List;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import de.netallied.functionblock.cache.FBTypeModelCache;
import de.netallied.functionblock.model.InstanceFunctionBlockModel;
import de.netallied.functionblock.modeleditor.res.network.Constants;
import de.netallied.functionblock.modeleditor.res.network.editpolicies.ObjectModelComponentEditPolicy;
import de.netallied.functionblock.modeleditor.res.network.figures.InstanceFunctionBlockFigure;
import de.netallied.functionblock.modeleditor.res.network.util.EditableLabelEditPart;


public class InstanceFunctionBlockModelEditPart extends EditableLabelEditPart
{
  public InstanceFunctionBlockModelEditPart()
  {
  }


  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
   */
	@Override
  public void createEditPolicies()
  {
		super.createEditPolicies();
    // allow removal of the associated model element
    installEditPolicy(EditPolicy.COMPONENT_ROLE, new ObjectModelComponentEditPolicy());
  }

  @Override
  public void performRequest(Request request)
  {
		if(request.getType() == RequestConstants.REQ_OPEN)
		{
			final IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();

			final IWorkbenchPage page = window.getActivePage();
			try {
				IProject project = getInstanceFunctionBlockModel().getNetworkModel().getProject();
				IFile file =FBTypeModelCache.getIFile(project,getInstanceFunctionBlockModel());
				IDE.openEditor(page, file, true);
			} catch (final PartInitException e) {
				e.printStackTrace();
			}
		}
		else
			super.performDirectEdit();
  }

	@Override
  protected void addChildVisual(EditPart arg0, int arg1)
  {
    // erste Element ist der Name des Objektes
		// zweite Stelle ist der Typ
    // Die Kinder kommen dann erst zwei Stelle danach.
    //
    super.addChildVisual(arg0, arg1+2);
  }

	@Override
	protected List getModelChildren() 
	{
		return getInstanceFunctionBlockModel().getElements();
	}

	/*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
   */
	@Override
  protected IFigure createFigure()
  {
    return new InstanceFunctionBlockFigure(25);
  }

  public InstanceFunctionBlockModel getInstanceFunctionBlockModel()
  {
    return (InstanceFunctionBlockModel) getModel();
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
   */
	@Override
  public void propertyChange(PropertyChangeEvent evt)
  {
    if (evt.getSource()==getModel())
      refreshVisuals();

    super.propertyChange(evt);
  }

	@Override
	protected void refreshChildren() 
	{
		super.refreshChildren();
		refreshVisuals();
	}


	@Override
  protected void refreshVisuals()
  {
    InstanceFunctionBlockModel model = getInstanceFunctionBlockModel();
    InstanceFunctionBlockFigure figure = (InstanceFunctionBlockFigure)getFigure();
    
  	Dimension dim = new Dimension(50,50);//figure.getPreferredSize();
    figure.setBounds(new Rectangle( model.getLocation(), dim));
    figure.getLabel().setText(model.getName());
    figure.getType().setText(model.getType());

    
    Rectangle rect = figure.getBounds();
    
    // Das breiteste Label der linken und rechten Seite bestimmen
    //
    int leftMax  = 0;
    int rightMax = 0;
    Iterator iter = getChildren().iterator();
    while(iter.hasNext())
    {
      AbstractGraphicalEditPart part= (AbstractGraphicalEditPart)iter.next();
      part.refresh();
      if(part instanceof InputEventModelEditPart || part instanceof InputValueModelEditPart)
      	leftMax = Math.max(leftMax, part.getFigure().getPreferredSize().width);
      else
      	rightMax = Math.max(rightMax, part.getFigure().getPreferredSize().width);
    }
    rect.width = Math.max(Constants.RULE_GRID_WIDTH*3,Constants.RULE_GRID_WIDTH+leftMax+rightMax);
    rect.width = Math.max(rect.width, figure.getType().getPreferredSize().width+50);
    // die Höhe des Elementes bestimmen
    //
    int inValue=model.getInputValueModels().size();
    int inEvent=model.getInputEventModels().size();
    int outValue=model.getOutputValueModels().size();
    int outEvent=model.getOutputEventModels().size();
    
    int inCount  = inValue+inEvent; 
    int outCount = outValue+outEvent; 
    int inHeight = inCount*Constants.RULE_GRID_HEIGHT+Constants.RULE_GRID_HEIGHT*2;
    int outHeight = outCount*Constants.RULE_GRID_HEIGHT+Constants.RULE_GRID_HEIGHT*2;

    rect.height=Math.max(inHeight,outHeight);
    
    figure.setWaistPos(Math.max(inEvent,outEvent)*Constants.RULE_GRID_HEIGHT+Constants.RULE_GRID_HEIGHT);
    figure.setBounds(rect);
    // den Kindern mitteilen, dass diese sich neu Ausrichten sollen
    //
    iter = getChildren().iterator();
    while(iter.hasNext())
    {
      AbstractGraphicalEditPart part= (AbstractGraphicalEditPart)iter.next();
      part.refresh();
    }
  }
}