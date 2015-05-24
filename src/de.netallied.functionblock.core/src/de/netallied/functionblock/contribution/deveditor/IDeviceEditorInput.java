/*
 * Created on 11.01.2007
 *
 */
package de.netallied.functionblock.contribution.deveditor;

import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IPersistableElement;
import de.netallied.functionblock.model.DeviceTypeModel;
import de.netallied.functionblock.model.ResourceTypeModel;

public interface IDeviceEditorInput extends IFileEditorInput, IPersistableElement
{
  public DeviceTypeModel getModel();
}
