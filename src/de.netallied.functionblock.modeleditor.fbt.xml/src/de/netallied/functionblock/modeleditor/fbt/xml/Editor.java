/*******************************************************************************
 * Copyright (c) 2005, 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package de.netallied.functionblock.modeleditor.fbt.xml;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.editors.text.TextEditor;
import de.netallied.functionblock.contribution.fbteditor.IFunctionBlockEditorPart;

public class Editor extends TextEditor implements IFunctionBlockEditorPart
{
	private ColorManager colorManager;

	public Editor() 
  {
		super();
		colorManager = new ColorManager();
		setSourceViewerConfiguration(new XMLConfiguration(colorManager));
		setDocumentProvider(new XMLDocumentProvider());
	}
  
	public void dispose() 
  {
		colorManager.dispose();
		super.dispose();
	}

  @Override
  protected void doSetInput(IEditorInput input) throws CoreException
  {
    super.doSetInput(input);
    setPartName("XML");
    setTitleImage(Activator.getDefault().getImage("editor.png"));
  }

  public void markSaveLocation()
  {
    // This view is readonly....so - noch saveLocation necessary
  }

  public void selectionChanged(IWorkbenchPart part, ISelection selection)
  {
  }
}
