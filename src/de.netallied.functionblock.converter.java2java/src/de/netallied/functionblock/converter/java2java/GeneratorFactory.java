/*
 * Created on 08.01.2007
 *
 */
package de.netallied.functionblock.converter.java2java;

import de.netallied.functionblock.contribution.generator.IGenerator;
import de.netallied.functionblock.contribution.generator.IGeneratorFactory;

public class GeneratorFactory implements IGeneratorFactory
{
  public GeneratorFactory()
  {
    System.out.println("created.");
  }
  
  public IGenerator createGenerator()
  {
    return new Generator();
  }
}
