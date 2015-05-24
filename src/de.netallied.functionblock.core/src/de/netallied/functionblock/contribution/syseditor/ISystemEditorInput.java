/*
 * Created on 11.01.2007
 *
 */
package de.netallied.functionblock.contribution.syseditor;

import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IPersistableElement;
import de.netallied.functionblock.model.SystemModel;

public interface ISystemEditorInput extends IFileEditorInput, IPersistableElement
{
  public SystemModel getModel();
}
