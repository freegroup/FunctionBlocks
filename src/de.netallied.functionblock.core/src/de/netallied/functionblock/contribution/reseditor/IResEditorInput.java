/*
 * Created on 11.01.2007
 *
 */
package de.netallied.functionblock.contribution.reseditor;

import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IPersistableElement;
import de.netallied.functionblock.model.ResourceTypeModel;

public interface IResEditorInput extends IFileEditorInput, IPersistableElement
{
  public ResourceTypeModel getModel();
}
