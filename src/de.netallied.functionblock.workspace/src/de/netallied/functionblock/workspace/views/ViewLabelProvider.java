/*
 * Created on 17.01.2007
 *
 */
package de.netallied.functionblock.workspace.views;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

class ViewLabelProvider extends LabelProvider {

	/**
   * 
   */
  private final ProjectView view;
  /**
   * @param view
   */
  ViewLabelProvider(ProjectView view)
  {
    this.view = view;
  }
  public String getText(Object obj) {
		return obj.toString();
	}
	public Image getImage(Object obj) {
		String imageKey = ISharedImages.IMG_OBJ_ELEMENT;
		if (obj instanceof TreeParent)
		   imageKey = ISharedImages.IMG_OBJ_FOLDER;
		return PlatformUI.getWorkbench().getSharedImages().getImage(imageKey);
	}
}