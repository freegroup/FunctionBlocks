package de.netallied.functionblock.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.axis.utils.XMLUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.w3c.dom.Document;
import de.netallied.functionblock.model.castor.Device;
import de.netallied.functionblock.model.castor.Link;
import de.netallied.functionblock.model.castor.Segment;
import de.netallied.functionblock.model.castor.System;
import de.netallied.functionblock.util.FastStringWriter;
import de.netallied.functionblock.util.StringUtil;
import de.netallied.functionblock.util.xml.EntityResolver;

public class SystemModel extends ObjectModel 
{
  System castor;
  List<SegmentModel> segments;
  List<DeviceModel>  devices;
  List<LinkModel>    links;
  
	private IProject project;
	
	public SystemModel(IProject  project, InputStream is) throws Exception 
	{
		Unmarshaller m = new Unmarshaller(System.class);
		m.setEntityResolver(EntityResolver.RESOLVER);
    this.project = project;
		this.castor = (System) m.unmarshal(new InputStreamReader(is,"ISO-8859-1"));
    
    this.segments = new ArrayList<SegmentModel>();
    for(Segment segment :castor.getSegment())
    {
      segments.add(new SegmentModel(this,segment));
    }

    this.devices = new ArrayList<DeviceModel>();
    for(Device segment :castor.getDevice())
    {
      devices.add(new DeviceModel(this,segment));
    }
    
    this.links = new ArrayList<LinkModel>();
    for(Link link : castor.getLink())
    {
      links.add(new LinkModel(this, link));
    }
	}

 
  public System getCastor()
  {
    return castor;
  }

	public IProject getProject() 
	{
		return project;
	}
  
  public List<ObjectModel> getElements()
  {
    List<ObjectModel> elements = new ArrayList<ObjectModel>();
    
    elements.addAll(devices);
    elements.addAll(segments);
    
    return elements;
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


  public boolean removeElement(SegmentModel model)
  {
    int index = segments.indexOf(model);
    if (index >= 0)
    {
      segments.remove(model);
      castor.removeSegment(index);
      firePropertyChange(PROPERTY_ELEMENT_REMOVED, null, model);
      return true;
    }
    return false;
  }


  public boolean addElement(SegmentModel child)
  {
    segments.add(child);
    castor.addSegment(child.getCastor());
    child.setSystemModel(this);
    firePropertyChange(PROPERTY_ELEMENT_ADDED, null, child);
    return true;
  }


  public boolean addElement(LinkModel child)
  {
    links.add(child);
    castor.addLink(child.getCastor());
    child.setSystemModel(this);
    firePropertyChange(PROPERTY_ELEMENT_ADDED, null, child);
    child.getSource().firePropertyChange(ObjectModel.SOURCE_CONNECTIONS_PROP, null, child);
    child.getTarget().firePropertyChange(ObjectModel.TARGET_CONNECTIONS_PROP, null, child);
    return true;
  }

  public boolean addElement(DeviceModel child)
  {
    devices.add(child);
    castor.addDevice(child.getCastor());
    child.setSystemModel(this);
    firePropertyChange(PROPERTY_ELEMENT_ADDED, null, child);
    return true;
  }


  public boolean removeElement(DeviceModel model)
  {
    int index = devices.indexOf(model);
    if (index >= 0)
    {
      devices.remove(model);
      castor.removeDevice(index);
      firePropertyChange(PROPERTY_ELEMENT_REMOVED, null, model);
      return true;
    }
    return false;
  }
  
  public boolean removeElement(LinkModel model)
  {
    int index = links.indexOf(model);
    if (index >= 0)
    {
      links.remove(model);
      castor.removeLink(index);
      firePropertyChange(PROPERTY_ELEMENT_REMOVED, null, model);
      model.getSource().firePropertyChange(ObjectModel.SOURCE_CONNECTIONS_PROP, null, model);
      model.getTarget().firePropertyChange(ObjectModel.TARGET_CONNECTIONS_PROP, null, model);
      return true;
    }
    return false;
  }
  
  public DeviceModel getDeviceModel(String name)
  {
    for (DeviceModel device : devices)
    {
     if(device.getName().equals(name))
       return device;
    }
    return null;
  }

  public SegmentModel getSegmentModel(String name)
  {
    for (SegmentModel segment : segments)
    {
     if(segment.getName().equals(name))
       return segment;
    }
    return null;
  }
  
  public List<LinkModel> getLinkModels(DeviceModel device)
  {
    List<LinkModel> result = new ArrayList<LinkModel>();
    for (LinkModel link : links)
    {
     if(link.getSource() == device)
       result.add(link);
    }
    return result;
  }  


  public List<LinkModel> getLinkModels(SegmentModel segment)
  {
    List<LinkModel> result = new ArrayList<LinkModel>();
    for (LinkModel link : links)
    {
     if(link.getTarget() == segment)
       result.add(link);
    }
    return result;
  }  
}

