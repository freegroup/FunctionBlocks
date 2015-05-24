/*
 * Created on 04.01.2007
 *
 */
package de.netallied.functionblock.contribution.codeeditor;

import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.ISourceViewerExtension2;
import org.eclipse.swt.widgets.Control;

public interface ICodeEditor extends ISourceViewer, ISourceViewerExtension2
{
  
  /**
   * Returns the primary control associated with this viewer.
   *
   * @return the SWT control which displays this viewer's content
   */
  public Control getControl();
}
