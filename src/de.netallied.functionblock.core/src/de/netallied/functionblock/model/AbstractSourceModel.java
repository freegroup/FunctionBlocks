/*
 * Created on 04.12.2005
 *
 */
package de.netallied.functionblock.model;

import org.eclipse.ui.views.properties.IPropertySource;

public interface AbstractSourceModel  extends AbstractPortModel
{
  public String getIdentifierName(NetworkModel networkModel);
}
