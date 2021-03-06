/*******************************************************************************
 * Copyright (c) 2004 Elias Volanakis.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 �* http://www.eclipse.org/legal/cpl-v10.html
 �*
 �* Contributors:
 �*����Elias Volanakis - initial API and implementation
 �*******************************************************************************/
package de.netallied.functionblock.modeleditor.fbt.basicinterface.contributor;

import org.eclipse.gef.ui.actions.ActionBarContributor;
import org.eclipse.gef.ui.actions.RedoRetargetAction;
import org.eclipse.gef.ui.actions.UndoRetargetAction;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.ui.actions.ActionFactory;

/**
 * Contributes actions to a toolbar. This class is tied to the editor in the
 * definition of editor-extension (see plugin.xml).
 * 
 */
public class EditorContributor extends ActionBarContributor
{

  /**
   * Create actions managed by this contributor.
   * 
   * @see org.eclipse.gef.ui.actions.ActionBarContributor#buildActions()
   */
  protected void buildActions()
  {
    addRetargetAction(new UndoRetargetAction());
    addRetargetAction(new RedoRetargetAction());
//    addRetargetAction(new DeleteRetargetAction());
  }

  /**
   * Add actions to the given toolbar.
   * 
   * @see org.eclipse.ui.part.EditorActionBarContributor#contributeToToolBar(org.eclipse.jface.action.IToolBarManager)
   */
  public void contributeToToolBar(IToolBarManager toolBarManager)
  {
//    super.contributeToToolBar(toolBarManager);
    toolBarManager.add(getAction(ActionFactory.UNDO.getId()));
    toolBarManager.add(getAction(ActionFactory.REDO.getId()));
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gef.ui.actions.ActionBarContributor#declareGlobalActionKeys()
   */
  protected void declareGlobalActionKeys()
  {
//  	addGlobalActionKey(ActionFactory.PRINT.getId());
  }
}