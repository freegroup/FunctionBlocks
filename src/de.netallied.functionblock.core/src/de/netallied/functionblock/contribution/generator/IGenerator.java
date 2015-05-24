/*
 * Created on 08.01.2007
 *
 */
package de.netallied.functionblock.contribution.generator;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import de.netallied.functionblock.model.FBTypeModel;

public interface IGenerator
{

  void convert(IProject project, FBTypeModel model, IProgressMonitor monitor) throws Exception;
}
