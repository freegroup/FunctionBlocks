/*
 * Created on 04.01.2007
 *
 */
package de.netallied.functionblock.contribution.codeeditor;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import de.netallied.functionblock.model.BasisFunctionBlockModel;

public interface ICodeEditorFactory
{
  
  public ICodeEditor createCodeEditor(Composite parent, BasisFunctionBlockModel model);
  public Image       getImage();
}
