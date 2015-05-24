/*
 * Created on 04.12.2005
 *
 */
package de.netallied.functionblock.model;

import java.beans.PropertyChangeListener;

import org.eclipse.ui.views.properties.IPropertySource;

public interface AbstractTargetModel  extends AbstractPortModel
{
  public String getIdentifierName(NetworkModel networkModel);
}
