/*
 * Created on 11.01.2007
 *
 */
package de.netallied.functionblock.contribution.fbteditor;

import org.eclipse.ui.*;
import org.eclipse.ui.IPersistableElement;
import de.netallied.functionblock.model.FBTypeModel;

public interface IFbtEditorInput extends IFileEditorInput, IPersistableElement
{
  public FBTypeModel getModel();
}
