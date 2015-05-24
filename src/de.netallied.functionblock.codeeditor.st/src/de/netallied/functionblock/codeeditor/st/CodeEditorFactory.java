/*
 * Created on 04.01.2007
 *
 */
package de.netallied.functionblock.codeeditor.st;

import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import de.netallied.functionblock.contribution.codeeditor.ICodeEditor;
import de.netallied.functionblock.contribution.codeeditor.ICodeEditorFactory;
import de.netallied.functionblock.model.BasisFunctionBlockModel;

public class CodeEditorFactory implements ICodeEditorFactory
{
  public ICodeEditor createCodeEditor(Composite parent, BasisFunctionBlockModel model)
  {
    STCodeEditor editor= new STCodeEditor(parent, null, null, false, SWT.V_SCROLL | SWT.H_SCROLL);
    editor.configure(new STSourceViewerConfig());
    
    return editor;
  }

  public Image getImage()
  {
    return Activator.getDefault().getImage("editor.png");
  }
}
