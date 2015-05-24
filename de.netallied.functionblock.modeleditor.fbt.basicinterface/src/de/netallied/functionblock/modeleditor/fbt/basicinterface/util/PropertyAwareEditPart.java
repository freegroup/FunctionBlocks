package de.netallied.functionblock.modeleditor.fbt.basicinterface.util;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import de.netallied.functionblock.model.ObjectModel;

/**
 * An abstract EditPart implementation which is property aware and responds to
 * PropertyChangeEvents fired from the model
 */
public abstract class PropertyAwareEditPart extends AbstractGraphicalEditPart implements PropertyChangeListener
{
	/**
	 * @see org.eclipse.gef.EditPart#activate()
	 */
	public void activate()
	{
		super.activate();
		ObjectModel propertyAwareObject = (ObjectModel) getModel();
		propertyAwareObject.addPropertyChangeListener(this);
	}

	/**
	 * @see org.eclipse.gef.EditPart#deactivate()
	 */
	public void deactivate()
	{
		super.deactivate();
		ObjectModel propertyAwareObject = (ObjectModel) getModel();
		propertyAwareObject.removePropertyChangeListener(this);
	}

	/**
	 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
	 */
	public void propertyChange(PropertyChangeEvent evt)
	{
		if (evt.getPropertyName() == ObjectModel.PROPERTY_POSITION_CHANGED)
		{
			handleBoundsChange(evt);
		}
	}

	protected void handleBoundsChange(PropertyChangeEvent evt)
	{
	}
}