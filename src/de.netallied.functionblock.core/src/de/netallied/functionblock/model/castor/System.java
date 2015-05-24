/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.6</a>, using an XML
 * Schema.
 * $Id: System.java,v 1.3 2007/02/14 19:23:08 freegroup Exp $
 */

package de.netallied.functionblock.model.castor;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Vector;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.ContentHandler;

/**
 * Class System.
 * 
 * @version $Revision: 1.3 $ $Date: 2007/02/14 19:23:08 $
 */
public class System implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _name
     */
    private java.lang.String _name;

    /**
     * Field _comment
     */
    private java.lang.String _comment;

    /**
     * Field _identification
     */
    private de.netallied.functionblock.model.castor.Identification _identification;

    /**
     * Field _versionInfoList
     */
    private java.util.Vector _versionInfoList;

    /**
     * Field _applicationList
     */
    private java.util.Vector _applicationList;

    /**
     * Field _deviceList
     */
    private java.util.Vector _deviceList;

    /**
     * Field _mappingList
     */
    private java.util.Vector _mappingList;

    /**
     * Field _segmentList
     */
    private java.util.Vector _segmentList;

    /**
     * Field _linkList
     */
    private java.util.Vector _linkList;


      //----------------/
     //- Constructors -/
    //----------------/

    public System() {
        super();
        _versionInfoList = new Vector();
        _applicationList = new Vector();
        _deviceList = new Vector();
        _mappingList = new Vector();
        _segmentList = new Vector();
        _linkList = new Vector();
    } //-- de.netallied.functionblock.model.castor.System()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addApplication
     * 
     * 
     * 
     * @param vApplication
     */
    public void addApplication(de.netallied.functionblock.model.castor.Application vApplication)
        throws java.lang.IndexOutOfBoundsException
    {
        _applicationList.addElement(vApplication);
    } //-- void addApplication(de.netallied.functionblock.model.castor.Application) 

    /**
     * Method addApplication
     * 
     * 
     * 
     * @param index
     * @param vApplication
     */
    public void addApplication(int index, de.netallied.functionblock.model.castor.Application vApplication)
        throws java.lang.IndexOutOfBoundsException
    {
        _applicationList.insertElementAt(vApplication, index);
    } //-- void addApplication(int, de.netallied.functionblock.model.castor.Application) 

    /**
     * Method addDevice
     * 
     * 
     * 
     * @param vDevice
     */
    public void addDevice(de.netallied.functionblock.model.castor.Device vDevice)
        throws java.lang.IndexOutOfBoundsException
    {
        _deviceList.addElement(vDevice);
    } //-- void addDevice(de.netallied.functionblock.model.castor.Device) 

    /**
     * Method addDevice
     * 
     * 
     * 
     * @param index
     * @param vDevice
     */
    public void addDevice(int index, de.netallied.functionblock.model.castor.Device vDevice)
        throws java.lang.IndexOutOfBoundsException
    {
        _deviceList.insertElementAt(vDevice, index);
    } //-- void addDevice(int, de.netallied.functionblock.model.castor.Device) 

    /**
     * Method addLink
     * 
     * 
     * 
     * @param vLink
     */
    public void addLink(de.netallied.functionblock.model.castor.Link vLink)
        throws java.lang.IndexOutOfBoundsException
    {
        _linkList.addElement(vLink);
    } //-- void addLink(de.netallied.functionblock.model.castor.Link) 

    /**
     * Method addLink
     * 
     * 
     * 
     * @param index
     * @param vLink
     */
    public void addLink(int index, de.netallied.functionblock.model.castor.Link vLink)
        throws java.lang.IndexOutOfBoundsException
    {
        _linkList.insertElementAt(vLink, index);
    } //-- void addLink(int, de.netallied.functionblock.model.castor.Link) 

    /**
     * Method addMapping
     * 
     * 
     * 
     * @param vMapping
     */
    public void addMapping(de.netallied.functionblock.model.castor.Mapping vMapping)
        throws java.lang.IndexOutOfBoundsException
    {
        _mappingList.addElement(vMapping);
    } //-- void addMapping(de.netallied.functionblock.model.castor.Mapping) 

    /**
     * Method addMapping
     * 
     * 
     * 
     * @param index
     * @param vMapping
     */
    public void addMapping(int index, de.netallied.functionblock.model.castor.Mapping vMapping)
        throws java.lang.IndexOutOfBoundsException
    {
        _mappingList.insertElementAt(vMapping, index);
    } //-- void addMapping(int, de.netallied.functionblock.model.castor.Mapping) 

    /**
     * Method addSegment
     * 
     * 
     * 
     * @param vSegment
     */
    public void addSegment(de.netallied.functionblock.model.castor.Segment vSegment)
        throws java.lang.IndexOutOfBoundsException
    {
        _segmentList.addElement(vSegment);
    } //-- void addSegment(de.netallied.functionblock.model.castor.Segment) 

    /**
     * Method addSegment
     * 
     * 
     * 
     * @param index
     * @param vSegment
     */
    public void addSegment(int index, de.netallied.functionblock.model.castor.Segment vSegment)
        throws java.lang.IndexOutOfBoundsException
    {
        _segmentList.insertElementAt(vSegment, index);
    } //-- void addSegment(int, de.netallied.functionblock.model.castor.Segment) 

    /**
     * Method addVersionInfo
     * 
     * 
     * 
     * @param vVersionInfo
     */
    public void addVersionInfo(de.netallied.functionblock.model.castor.VersionInfo vVersionInfo)
        throws java.lang.IndexOutOfBoundsException
    {
        _versionInfoList.addElement(vVersionInfo);
    } //-- void addVersionInfo(de.netallied.functionblock.model.castor.VersionInfo) 

    /**
     * Method addVersionInfo
     * 
     * 
     * 
     * @param index
     * @param vVersionInfo
     */
    public void addVersionInfo(int index, de.netallied.functionblock.model.castor.VersionInfo vVersionInfo)
        throws java.lang.IndexOutOfBoundsException
    {
        _versionInfoList.insertElementAt(vVersionInfo, index);
    } //-- void addVersionInfo(int, de.netallied.functionblock.model.castor.VersionInfo) 

    /**
     * Method enumerateApplication
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateApplication()
    {
        return _applicationList.elements();
    } //-- java.util.Enumeration enumerateApplication() 

    /**
     * Method enumerateDevice
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateDevice()
    {
        return _deviceList.elements();
    } //-- java.util.Enumeration enumerateDevice() 

    /**
     * Method enumerateLink
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateLink()
    {
        return _linkList.elements();
    } //-- java.util.Enumeration enumerateLink() 

    /**
     * Method enumerateMapping
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateMapping()
    {
        return _mappingList.elements();
    } //-- java.util.Enumeration enumerateMapping() 

    /**
     * Method enumerateSegment
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateSegment()
    {
        return _segmentList.elements();
    } //-- java.util.Enumeration enumerateSegment() 

    /**
     * Method enumerateVersionInfo
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateVersionInfo()
    {
        return _versionInfoList.elements();
    } //-- java.util.Enumeration enumerateVersionInfo() 

    /**
     * Method getApplication
     * 
     * 
     * 
     * @param index
     * @return Application
     */
    public de.netallied.functionblock.model.castor.Application getApplication(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _applicationList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (de.netallied.functionblock.model.castor.Application) _applicationList.elementAt(index);
    } //-- de.netallied.functionblock.model.castor.Application getApplication(int) 

    /**
     * Method getApplication
     * 
     * 
     * 
     * @return Application
     */
    public de.netallied.functionblock.model.castor.Application[] getApplication()
    {
        int size = _applicationList.size();
        de.netallied.functionblock.model.castor.Application[] mArray = new de.netallied.functionblock.model.castor.Application[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (de.netallied.functionblock.model.castor.Application) _applicationList.elementAt(index);
        }
        return mArray;
    } //-- de.netallied.functionblock.model.castor.Application[] getApplication() 

    /**
     * Method getApplicationCount
     * 
     * 
     * 
     * @return int
     */
    public int getApplicationCount()
    {
        return _applicationList.size();
    } //-- int getApplicationCount() 

    /**
     * Returns the value of field 'comment'.
     * 
     * @return String
     * @return the value of field 'comment'.
     */
    public java.lang.String getComment()
    {
        return this._comment;
    } //-- java.lang.String getComment() 

    /**
     * Method getDevice
     * 
     * 
     * 
     * @param index
     * @return Device
     */
    public de.netallied.functionblock.model.castor.Device getDevice(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _deviceList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (de.netallied.functionblock.model.castor.Device) _deviceList.elementAt(index);
    } //-- de.netallied.functionblock.model.castor.Device getDevice(int) 

    /**
     * Method getDevice
     * 
     * 
     * 
     * @return Device
     */
    public de.netallied.functionblock.model.castor.Device[] getDevice()
    {
        int size = _deviceList.size();
        de.netallied.functionblock.model.castor.Device[] mArray = new de.netallied.functionblock.model.castor.Device[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (de.netallied.functionblock.model.castor.Device) _deviceList.elementAt(index);
        }
        return mArray;
    } //-- de.netallied.functionblock.model.castor.Device[] getDevice() 

    /**
     * Method getDeviceCount
     * 
     * 
     * 
     * @return int
     */
    public int getDeviceCount()
    {
        return _deviceList.size();
    } //-- int getDeviceCount() 

    /**
     * Returns the value of field 'identification'.
     * 
     * @return Identification
     * @return the value of field 'identification'.
     */
    public de.netallied.functionblock.model.castor.Identification getIdentification()
    {
        return this._identification;
    } //-- de.netallied.functionblock.model.castor.Identification getIdentification() 

    /**
     * Method getLink
     * 
     * 
     * 
     * @param index
     * @return Link
     */
    public de.netallied.functionblock.model.castor.Link getLink(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _linkList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (de.netallied.functionblock.model.castor.Link) _linkList.elementAt(index);
    } //-- de.netallied.functionblock.model.castor.Link getLink(int) 

    /**
     * Method getLink
     * 
     * 
     * 
     * @return Link
     */
    public de.netallied.functionblock.model.castor.Link[] getLink()
    {
        int size = _linkList.size();
        de.netallied.functionblock.model.castor.Link[] mArray = new de.netallied.functionblock.model.castor.Link[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (de.netallied.functionblock.model.castor.Link) _linkList.elementAt(index);
        }
        return mArray;
    } //-- de.netallied.functionblock.model.castor.Link[] getLink() 

    /**
     * Method getLinkCount
     * 
     * 
     * 
     * @return int
     */
    public int getLinkCount()
    {
        return _linkList.size();
    } //-- int getLinkCount() 

    /**
     * Method getMapping
     * 
     * 
     * 
     * @param index
     * @return Mapping
     */
    public de.netallied.functionblock.model.castor.Mapping getMapping(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _mappingList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (de.netallied.functionblock.model.castor.Mapping) _mappingList.elementAt(index);
    } //-- de.netallied.functionblock.model.castor.Mapping getMapping(int) 

    /**
     * Method getMapping
     * 
     * 
     * 
     * @return Mapping
     */
    public de.netallied.functionblock.model.castor.Mapping[] getMapping()
    {
        int size = _mappingList.size();
        de.netallied.functionblock.model.castor.Mapping[] mArray = new de.netallied.functionblock.model.castor.Mapping[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (de.netallied.functionblock.model.castor.Mapping) _mappingList.elementAt(index);
        }
        return mArray;
    } //-- de.netallied.functionblock.model.castor.Mapping[] getMapping() 

    /**
     * Method getMappingCount
     * 
     * 
     * 
     * @return int
     */
    public int getMappingCount()
    {
        return _mappingList.size();
    } //-- int getMappingCount() 

    /**
     * Returns the value of field 'name'.
     * 
     * @return String
     * @return the value of field 'name'.
     */
    public java.lang.String getName()
    {
        return this._name;
    } //-- java.lang.String getName() 

    /**
     * Method getSegment
     * 
     * 
     * 
     * @param index
     * @return Segment
     */
    public de.netallied.functionblock.model.castor.Segment getSegment(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _segmentList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (de.netallied.functionblock.model.castor.Segment) _segmentList.elementAt(index);
    } //-- de.netallied.functionblock.model.castor.Segment getSegment(int) 

    /**
     * Method getSegment
     * 
     * 
     * 
     * @return Segment
     */
    public de.netallied.functionblock.model.castor.Segment[] getSegment()
    {
        int size = _segmentList.size();
        de.netallied.functionblock.model.castor.Segment[] mArray = new de.netallied.functionblock.model.castor.Segment[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (de.netallied.functionblock.model.castor.Segment) _segmentList.elementAt(index);
        }
        return mArray;
    } //-- de.netallied.functionblock.model.castor.Segment[] getSegment() 

    /**
     * Method getSegmentCount
     * 
     * 
     * 
     * @return int
     */
    public int getSegmentCount()
    {
        return _segmentList.size();
    } //-- int getSegmentCount() 

    /**
     * Method getVersionInfo
     * 
     * 
     * 
     * @param index
     * @return VersionInfo
     */
    public de.netallied.functionblock.model.castor.VersionInfo getVersionInfo(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _versionInfoList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (de.netallied.functionblock.model.castor.VersionInfo) _versionInfoList.elementAt(index);
    } //-- de.netallied.functionblock.model.castor.VersionInfo getVersionInfo(int) 

    /**
     * Method getVersionInfo
     * 
     * 
     * 
     * @return VersionInfo
     */
    public de.netallied.functionblock.model.castor.VersionInfo[] getVersionInfo()
    {
        int size = _versionInfoList.size();
        de.netallied.functionblock.model.castor.VersionInfo[] mArray = new de.netallied.functionblock.model.castor.VersionInfo[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (de.netallied.functionblock.model.castor.VersionInfo) _versionInfoList.elementAt(index);
        }
        return mArray;
    } //-- de.netallied.functionblock.model.castor.VersionInfo[] getVersionInfo() 

    /**
     * Method getVersionInfoCount
     * 
     * 
     * 
     * @return int
     */
    public int getVersionInfoCount()
    {
        return _versionInfoList.size();
    } //-- int getVersionInfoCount() 

    /**
     * Method isValid
     * 
     * 
     * 
     * @return boolean
     */
    public boolean isValid()
    {
        try {
            validate();
        }
        catch (org.exolab.castor.xml.ValidationException vex) {
            return false;
        }
        return true;
    } //-- boolean isValid() 

    /**
     * Method marshal
     * 
     * 
     * 
     * @param out
     */
    public void marshal(java.io.Writer out)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        
        Marshaller.marshal(this, out);
    } //-- void marshal(java.io.Writer) 

    /**
     * Method marshal
     * 
     * 
     * 
     * @param handler
     */
    public void marshal(org.xml.sax.ContentHandler handler)
        throws java.io.IOException, org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        
        Marshaller.marshal(this, handler);
    } //-- void marshal(org.xml.sax.ContentHandler) 

    /**
     * Method removeAllApplication
     * 
     */
    public void removeAllApplication()
    {
        _applicationList.removeAllElements();
    } //-- void removeAllApplication() 

    /**
     * Method removeAllDevice
     * 
     */
    public void removeAllDevice()
    {
        _deviceList.removeAllElements();
    } //-- void removeAllDevice() 

    /**
     * Method removeAllLink
     * 
     */
    public void removeAllLink()
    {
        _linkList.removeAllElements();
    } //-- void removeAllLink() 

    /**
     * Method removeAllMapping
     * 
     */
    public void removeAllMapping()
    {
        _mappingList.removeAllElements();
    } //-- void removeAllMapping() 

    /**
     * Method removeAllSegment
     * 
     */
    public void removeAllSegment()
    {
        _segmentList.removeAllElements();
    } //-- void removeAllSegment() 

    /**
     * Method removeAllVersionInfo
     * 
     */
    public void removeAllVersionInfo()
    {
        _versionInfoList.removeAllElements();
    } //-- void removeAllVersionInfo() 

    /**
     * Method removeApplication
     * 
     * 
     * 
     * @param index
     * @return Application
     */
    public de.netallied.functionblock.model.castor.Application removeApplication(int index)
    {
        java.lang.Object obj = _applicationList.elementAt(index);
        _applicationList.removeElementAt(index);
        return (de.netallied.functionblock.model.castor.Application) obj;
    } //-- de.netallied.functionblock.model.castor.Application removeApplication(int) 

    /**
     * Method removeDevice
     * 
     * 
     * 
     * @param index
     * @return Device
     */
    public de.netallied.functionblock.model.castor.Device removeDevice(int index)
    {
        java.lang.Object obj = _deviceList.elementAt(index);
        _deviceList.removeElementAt(index);
        return (de.netallied.functionblock.model.castor.Device) obj;
    } //-- de.netallied.functionblock.model.castor.Device removeDevice(int) 

    /**
     * Method removeLink
     * 
     * 
     * 
     * @param index
     * @return Link
     */
    public de.netallied.functionblock.model.castor.Link removeLink(int index)
    {
        java.lang.Object obj = _linkList.elementAt(index);
        _linkList.removeElementAt(index);
        return (de.netallied.functionblock.model.castor.Link) obj;
    } //-- de.netallied.functionblock.model.castor.Link removeLink(int) 

    /**
     * Method removeMapping
     * 
     * 
     * 
     * @param index
     * @return Mapping
     */
    public de.netallied.functionblock.model.castor.Mapping removeMapping(int index)
    {
        java.lang.Object obj = _mappingList.elementAt(index);
        _mappingList.removeElementAt(index);
        return (de.netallied.functionblock.model.castor.Mapping) obj;
    } //-- de.netallied.functionblock.model.castor.Mapping removeMapping(int) 

    /**
     * Method removeSegment
     * 
     * 
     * 
     * @param index
     * @return Segment
     */
    public de.netallied.functionblock.model.castor.Segment removeSegment(int index)
    {
        java.lang.Object obj = _segmentList.elementAt(index);
        _segmentList.removeElementAt(index);
        return (de.netallied.functionblock.model.castor.Segment) obj;
    } //-- de.netallied.functionblock.model.castor.Segment removeSegment(int) 

    /**
     * Method removeVersionInfo
     * 
     * 
     * 
     * @param index
     * @return VersionInfo
     */
    public de.netallied.functionblock.model.castor.VersionInfo removeVersionInfo(int index)
    {
        java.lang.Object obj = _versionInfoList.elementAt(index);
        _versionInfoList.removeElementAt(index);
        return (de.netallied.functionblock.model.castor.VersionInfo) obj;
    } //-- de.netallied.functionblock.model.castor.VersionInfo removeVersionInfo(int) 

    /**
     * Method setApplication
     * 
     * 
     * 
     * @param index
     * @param vApplication
     */
    public void setApplication(int index, de.netallied.functionblock.model.castor.Application vApplication)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _applicationList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _applicationList.setElementAt(vApplication, index);
    } //-- void setApplication(int, de.netallied.functionblock.model.castor.Application) 

    /**
     * Method setApplication
     * 
     * 
     * 
     * @param applicationArray
     */
    public void setApplication(de.netallied.functionblock.model.castor.Application[] applicationArray)
    {
        //-- copy array
        _applicationList.removeAllElements();
        for (int i = 0; i < applicationArray.length; i++) {
            _applicationList.addElement(applicationArray[i]);
        }
    } //-- void setApplication(de.netallied.functionblock.model.castor.Application) 

    /**
     * Sets the value of field 'comment'.
     * 
     * @param comment the value of field 'comment'.
     */
    public void setComment(java.lang.String comment)
    {
        this._comment = comment;
    } //-- void setComment(java.lang.String) 

    /**
     * Method setDevice
     * 
     * 
     * 
     * @param index
     * @param vDevice
     */
    public void setDevice(int index, de.netallied.functionblock.model.castor.Device vDevice)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _deviceList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _deviceList.setElementAt(vDevice, index);
    } //-- void setDevice(int, de.netallied.functionblock.model.castor.Device) 

    /**
     * Method setDevice
     * 
     * 
     * 
     * @param deviceArray
     */
    public void setDevice(de.netallied.functionblock.model.castor.Device[] deviceArray)
    {
        //-- copy array
        _deviceList.removeAllElements();
        for (int i = 0; i < deviceArray.length; i++) {
            _deviceList.addElement(deviceArray[i]);
        }
    } //-- void setDevice(de.netallied.functionblock.model.castor.Device) 

    /**
     * Sets the value of field 'identification'.
     * 
     * @param identification the value of field 'identification'.
     */
    public void setIdentification(de.netallied.functionblock.model.castor.Identification identification)
    {
        this._identification = identification;
    } //-- void setIdentification(de.netallied.functionblock.model.castor.Identification) 

    /**
     * Method setLink
     * 
     * 
     * 
     * @param index
     * @param vLink
     */
    public void setLink(int index, de.netallied.functionblock.model.castor.Link vLink)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _linkList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _linkList.setElementAt(vLink, index);
    } //-- void setLink(int, de.netallied.functionblock.model.castor.Link) 

    /**
     * Method setLink
     * 
     * 
     * 
     * @param linkArray
     */
    public void setLink(de.netallied.functionblock.model.castor.Link[] linkArray)
    {
        //-- copy array
        _linkList.removeAllElements();
        for (int i = 0; i < linkArray.length; i++) {
            _linkList.addElement(linkArray[i]);
        }
    } //-- void setLink(de.netallied.functionblock.model.castor.Link) 

    /**
     * Method setMapping
     * 
     * 
     * 
     * @param index
     * @param vMapping
     */
    public void setMapping(int index, de.netallied.functionblock.model.castor.Mapping vMapping)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _mappingList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _mappingList.setElementAt(vMapping, index);
    } //-- void setMapping(int, de.netallied.functionblock.model.castor.Mapping) 

    /**
     * Method setMapping
     * 
     * 
     * 
     * @param mappingArray
     */
    public void setMapping(de.netallied.functionblock.model.castor.Mapping[] mappingArray)
    {
        //-- copy array
        _mappingList.removeAllElements();
        for (int i = 0; i < mappingArray.length; i++) {
            _mappingList.addElement(mappingArray[i]);
        }
    } //-- void setMapping(de.netallied.functionblock.model.castor.Mapping) 

    /**
     * Sets the value of field 'name'.
     * 
     * @param name the value of field 'name'.
     */
    public void setName(java.lang.String name)
    {
        this._name = name;
    } //-- void setName(java.lang.String) 

    /**
     * Method setSegment
     * 
     * 
     * 
     * @param index
     * @param vSegment
     */
    public void setSegment(int index, de.netallied.functionblock.model.castor.Segment vSegment)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _segmentList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _segmentList.setElementAt(vSegment, index);
    } //-- void setSegment(int, de.netallied.functionblock.model.castor.Segment) 

    /**
     * Method setSegment
     * 
     * 
     * 
     * @param segmentArray
     */
    public void setSegment(de.netallied.functionblock.model.castor.Segment[] segmentArray)
    {
        //-- copy array
        _segmentList.removeAllElements();
        for (int i = 0; i < segmentArray.length; i++) {
            _segmentList.addElement(segmentArray[i]);
        }
    } //-- void setSegment(de.netallied.functionblock.model.castor.Segment) 

    /**
     * Method setVersionInfo
     * 
     * 
     * 
     * @param index
     * @param vVersionInfo
     */
    public void setVersionInfo(int index, de.netallied.functionblock.model.castor.VersionInfo vVersionInfo)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _versionInfoList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _versionInfoList.setElementAt(vVersionInfo, index);
    } //-- void setVersionInfo(int, de.netallied.functionblock.model.castor.VersionInfo) 

    /**
     * Method setVersionInfo
     * 
     * 
     * 
     * @param versionInfoArray
     */
    public void setVersionInfo(de.netallied.functionblock.model.castor.VersionInfo[] versionInfoArray)
    {
        //-- copy array
        _versionInfoList.removeAllElements();
        for (int i = 0; i < versionInfoArray.length; i++) {
            _versionInfoList.addElement(versionInfoArray[i]);
        }
    } //-- void setVersionInfo(de.netallied.functionblock.model.castor.VersionInfo) 

    /**
     * Method unmarshalSystem
     * 
     * 
     * 
     * @param reader
     * @return Object
     */
    public static java.lang.Object unmarshalSystem(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.netallied.functionblock.model.castor.System) Unmarshaller.unmarshal(de.netallied.functionblock.model.castor.System.class, reader);
    } //-- java.lang.Object unmarshalSystem(java.io.Reader) 

    /**
     * Method validate
     * 
     */
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
