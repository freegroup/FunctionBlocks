/*
 * Created on 04.12.2005
 *
 */
package de.netallied.functionblock.model;

import org.eclipse.ui.views.properties.IPropertySource;

public interface AbstractPortModel  extends IPropertySource
{
  public void firePropertyChange(String propertyName, Object oldValue, Object newValue);
  
  /*
   * can be NetworkFunctionBlock or TypedFunctionBlock
   */
  public AbstractFunctionBlockModel getAbstractFunctionBlockModel();
  public String getName();
}
