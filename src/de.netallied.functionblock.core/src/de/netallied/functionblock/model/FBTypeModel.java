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
/*
 * Created on 20.07.2006
 *
 */
package de.netallied.functionblock.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.exolab.castor.xml.Unmarshaller;
import de.netallied.functionblock.model.castor.FBType;
import de.netallied.functionblock.util.xml.EntityResolver;
import de.netallied.functionblock.util.FastStringWriter;

import org.exolab.castor.xml.Marshaller;
import org.w3c.dom.Document;
import java.io.StringBufferInputStream;
import org.apache.axis.utils.XMLUtils;

public class FBTypeModel extends ObjectModel 
{
	AbstractFunctionBlockModel fb;
	private IProject project;
	
	public FBTypeModel(IProject  project, InputStream is) throws Exception 
	{
		this.project = project;
		Unmarshaller m = new Unmarshaller(FBType.class);
		m.setEntityResolver(EntityResolver.RESOLVER);
		FBType castor = (FBType) m.unmarshal(new InputStreamReader(is,"ISO-8859-1"));

    if(castor.getFBTypeChoice()!=null && castor.getFBTypeChoice().getBasicFB()!=null)
      fb = new BasisFunctionBlockModel(castor);
    else if(castor.getFBTypeChoice()!=null && castor.getFBTypeChoice().getFBNetwork()!=null)
      fb = new CompositeFunctionBlockModel(project, castor);
    else if(castor.getService()!=null)
      fb = new SystemInterfaceFunctionBlockModel(castor);
	}
	
	public List getElements()
	{
		return Collections.singletonList(fb);
	}

  public AbstractFunctionBlockModel getFunctionBlockModel()
  {
    return fb;
  }
  
  public FBType getCastor()
  {
    return fb.getCastor();
  }

	public IProject getProject() 
	{
		return project;
	}
  
  public void doSave(IFile file, IProgressMonitor monitor) throws Exception
  {
    file.refreshLocal(IResource.DEPTH_ONE,monitor);
    
    Document doc = XMLUtils.newDocument();
    Marshaller.marshal(getCastor(), doc);
    
    FastStringWriter writer = new FastStringWriter(1024 * 100);
    org.apache.xml.serialize.OutputFormat outFormat = new org.apache.xml.serialize.OutputFormat();
    outFormat.setIndenting(true);
    outFormat.setIndent(2);
    outFormat.setLineWidth(200);
    outFormat.setEncoding("ISO-8859-1");
    org.apache.xml.serialize.XMLSerializer xmlser = new org.apache.xml.serialize.XMLSerializer(writer, outFormat);
    
    xmlser.serialize(doc); // replace your_document with reference to
                           // document you want to serialize

    if(file.exists())
      file.setContents(new StringBufferInputStream(new String(writer.toCharArray())), true, true, monitor);
    else
      file.create(new StringBufferInputStream(new String(writer.toCharArray())), true, monitor);
  }
}
