/*
 * Created on 11.01.2007
 *
 */
package de.netallied.functionblock.contribution.reseditor;

import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISelectionListener;

public interface IResourceEditorPart extends IEditorPart,ISelectionListener
{
  public void markSaveLocation();
}
