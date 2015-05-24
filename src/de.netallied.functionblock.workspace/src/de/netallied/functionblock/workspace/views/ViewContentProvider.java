/*
 * Created on 17.01.2007
 *
 */
package de.netallied.functionblock.workspace.views;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

class ViewContentProvider implements IStructuredContentProvider, ITreeContentProvider 
{
		/**
     * 
     */
    private final ProjectView view;

    /**
     * @param view
     */
    ViewContentProvider(ProjectView view)
    {
      IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
      System.out.println(projects.length);
      this.view = view;
    }
    
    private TreeParent invisibleRoot;

		public void inputChanged(Viewer v, Object oldInput, Object newInput) 
    {
		}
    
		public void dispose() 
    {
		}
    
		public Object[] getElements(Object parent) 
    {
			if (parent.equals(this.view.getViewSite())) 
      {
				if (invisibleRoot==null) initialize();
				return getChildren(invisibleRoot);
			}
			return getChildren(parent);
		}
    
		public Object getParent(Object child) 
    {
			if (child instanceof TreeObject) 
      {
				return ((TreeObject)child).getParent();
			}
			return null;
		}
    
		public Object [] getChildren(Object parent) 
    {
			if (parent instanceof TreeParent) 
      {
				return ((TreeParent)parent).getChildren();
			}
			return new Object[0];
		}
    
		public boolean hasChildren(Object parent) 
    {
			if (parent instanceof TreeParent)
				return ((TreeParent)parent).hasChildren();
			return false;
		}
/*
 * We will set up a dummy model to initialize tree heararchy.
 * In a real code, you will connect to a real model and
 * expose its hierarchy.
 */
		private void initialize() {
			TreeObject to1 = new TreeObject("Leaf 1");
			TreeObject to2 = new TreeObject("Leaf 2");
			TreeObject to3 = new TreeObject("Leaf 3");
			TreeParent p1 = new TreeParent("Parent 1");
			p1.addChild(to1);
			p1.addChild(to2);
			p1.addChild(to3);
			
			TreeObject to4 = new TreeObject("Leaf 4");
			TreeParent p2 = new TreeParent("Parent 2");
			p2.addChild(to4);
			
			TreeParent root = new TreeParent("Root");
			root.addChild(p1);
			root.addChild(p2);
			
			invisibleRoot = new TreeParent("");
			invisibleRoot.addChild(root);
		}
	}