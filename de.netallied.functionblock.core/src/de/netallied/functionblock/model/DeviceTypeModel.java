package de.netallied.functionblock.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.exolab.castor.xml.Unmarshaller;
import de.netallied.functionblock.model.castor.DeviceType;
import de.netallied.functionblock.model.castor.FBType;
import de.netallied.functionblock.model.castor.Identification;
import de.netallied.functionblock.model.castor.Resource;
import de.netallied.functionblock.model.castor.ResourceType;
import de.netallied.functionblock.util.xml.EntityResolver;
import de.netallied.functionblock.util.FastStringWriter;
import de.netallied.functionblock.util.StringUtil;

import org.exolab.castor.xml.Marshaller;
import org.w3c.dom.Document;
import java.io.StringBufferInputStream;
import org.apache.axis.utils.XMLUtils;

public class DeviceTypeModel extends ObjectModel 
{
  DeviceType castor;
  private List<ResourceModel> elements;
  
	private IProject project;
	
	public DeviceTypeModel(IProject  project, InputStream is) throws Exception 
	{
		Unmarshaller m = new Unmarshaller(DeviceType.class);
		m.setEntityResolver(EntityResolver.RESOLVER);
    this.project = project;
		this.castor = (DeviceType) m.unmarshal(new InputStreamReader(is,"ISO-8859-1"));
	}

  public DeviceType getCastor()
  {
    return castor;
  }

  public List<ResourceModel> getElements()
  {
    if(elements==null)
    {
      elements = new ArrayList<ResourceModel>();
      for(Resource resource : this.castor.getResource())
      {
        elements.add(new ResourceModel(project,resource));
      }
    }
    return elements;
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

  public String getType()
  {
    return castor.getIdentification().getType();
  }
  
  public String getClassification()
  {
    if(castor.getIdentification()==null)
      return "Common";
    if(castor.getIdentification().getClassification()==null)
      return "Common";

    return castor.getIdentification().getClassification();
  }
  
  public void setClassification(String c)
  {
    if(castor.getIdentification()==null)
      castor.setIdentification(new Identification());
    
    castor.getIdentification().setClassification(c);
  }

  public void removeElement(ResourceModel var)
  {
    int index = getElements().indexOf(var);
    if(index!=-1)
    {
      elements.remove(index);
      this.castor.removeResource(index);
      firePropertyChange(PROPERTY_ELEMENT_REMOVED,var,null);
    }
  }

  public void addElement(ResourceModel resource)
  {
    this.castor.addResource(resource.getCastor());
    getElements().add(resource);
    firePropertyChange(PROPERTY_ELEMENT_ADDED,null,resource);
  }

  public ResourceModel getElement(String newName)
  {
    for (ResourceModel resource : getElements())
    {
      if(resource.getName().equals(newName))
        return resource;
    }
    return null;
  }
}
