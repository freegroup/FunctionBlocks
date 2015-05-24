/*
 * Created on 11.01.2007
 *
 */
package de.netallied.functionblock.contribution.syseditor;

import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISelectionListener;

public interface ISystemEditorPart extends IEditorPart,ISelectionListener
{
  public void markSaveLocation();
}
