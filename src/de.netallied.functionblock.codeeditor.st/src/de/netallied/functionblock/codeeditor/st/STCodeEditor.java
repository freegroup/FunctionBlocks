/*
 * Created on 04.01.2007
 *
 */
package de.netallied.functionblock.codeeditor.st;

import org.eclipse.jface.text.source.IOverviewRuler;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.swt.widgets.Composite;
import de.netallied.functionblock.contribution.codeeditor.ICodeEditor;

public class STCodeEditor extends SourceViewer implements ICodeEditor
{

  public STCodeEditor(Composite parent, IVerticalRuler ruler, int styles)
  {
    super(parent, ruler, styles);
  }

  public STCodeEditor(Composite parent, IVerticalRuler verticalRuler, IOverviewRuler overviewRuler, boolean showAnnotationsOverview, int styles)
  {
    super(parent, verticalRuler, overviewRuler, showAnnotationsOverview, styles);
  }
}
