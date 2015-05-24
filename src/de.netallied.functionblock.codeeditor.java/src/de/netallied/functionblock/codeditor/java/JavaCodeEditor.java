/*
 * Created on 04.01.2007
 *
 */
package de.netallied.functionblock.codeditor.java;

import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jdt.ui.text.IJavaPartitions;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.source.IOverviewRuler;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.swt.widgets.Composite;
import de.netallied.functionblock.contribution.codeeditor.ICodeEditor;

public class JavaCodeEditor extends SourceViewer implements ICodeEditor
{
  public JavaCodeEditor(Composite parent, IVerticalRuler ruler, int styles)
  {
    super(parent, ruler, styles);
  }

  public JavaCodeEditor(Composite parent, IVerticalRuler verticalRuler, IOverviewRuler overviewRuler, boolean showAnnotationsOverview, int styles)
  {
    super(parent, verticalRuler, overviewRuler, showAnnotationsOverview, styles);
  }


  
  public void setDocument(IDocument document)
  {
    if(document!=null)
      JavaPlugin.getDefault().getJavaTextTools().setupJavaDocumentPartitioner(document, IJavaPartitions.JAVA_PARTITIONING);
    super.setDocument(document);
  }
}
