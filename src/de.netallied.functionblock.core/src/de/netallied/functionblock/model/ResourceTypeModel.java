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
import de.netallied.functionblock.model.castor.ResourceType;
import de.netallied.functionblock.util.xml.EntityResolver;
import de.netallied.functionblock.util.FastStringWriter;
import de.netallied.functionblock.util.StringUtil;

import org.exolab.castor.xml.Marshaller;
import org.w3c.dom.Document;
import java.io.StringBufferInputStream;
import org.apache.axis.utils.XMLUtils;

public class ResourceTypeModel extends ObjectModel 
{
	NetworkModel network;
  ResourceType castor;
  
	private IProject project;
	
	public ResourceTypeModel(IProject  project, InputStream is) throws Exception 
	{
		Unmarshaller m = new Unmarshaller(ResourceType.class);
		m.setEntityResolver(EntityResolver.RESOLVER);
    this.project = project;
		this.castor = (ResourceType) m.unmarshal(new InputStreamReader(is,"ISO-8859-1"));
		this.network = new NetworkModel(project, this, castor.getFBNetwork());
	}

  public NetworkModel getNetworkModel()
  {
    return network;
  }
  
  public ResourceType getCastor()
  {
    return castor;
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

  public String getName()
  {
    return castor.getName();
  }

  public void setName(String text)
  {
    castor.setName(text);
  }

  public String getComment()
  {
    return castor.getComment();
  }

  public void setComment(String comment)
  {
    castor.setComment(comment);
  }

  public String getStandard()
  {
    return StringUtil.toSaveString(castor.getIdentification().getStandard());
  }

  public void setStandard(String c)
  {
    castor.getIdentification().setStandard(c);
  }
}
