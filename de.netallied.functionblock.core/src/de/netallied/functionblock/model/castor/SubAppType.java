/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.6</a>, using an XML
 * Schema.
 * $Id: SubAppType.java,v 1.3 2007/02/14 19:23:02 freegroup Exp $
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
 * Class SubAppType.
 * 
 * @version $Revision: 1.3 $ $Date: 2007/02/14 19:23:02 $
 */
public class SubAppType implements java.io.Serializable {


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
     * Field _compilerInfo
     */
    private de.netallied.functionblock.model.castor.CompilerInfo _compilerInfo;

    /**
     * Field _subAppInterfaceList
     */
    private de.netallied.functionblock.model.castor.SubAppInterfaceList _subAppInterfaceList;

    /**
     * Field _subAppNetwork
     */
    private de.netallied.functionblock.model.castor.SubAppNetwork _subAppNetwork;


      //----------------/
     //- Constructors -/
    //----------------/

    public SubAppType() {
        super();
        _versionInfoList = new Vector();
    } //-- de.netallied.functionblock.model.castor.SubAppType()


      //-----------/
     //- Methods -/
    //-----------/

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
     * Returns the value of field 'compilerInfo'.
     * 
     * @return CompilerInfo
     * @return the value of field 'compilerInfo'.
     */
    public de.netallied.functionblock.model.castor.CompilerInfo getCompilerInfo()
    {
        return this._compilerInfo;
    } //-- de.netallied.functionblock.model.castor.CompilerInfo getCompilerInfo() 

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
     * Returns the value of field 'subAppInterfaceList'.
     * 
     * @return SubAppInterfaceList
     * @return the value of field 'subAppInterfaceList'.
     */
    public de.netallied.functionblock.model.castor.SubAppInterfaceList getSubAppInterfaceList()
    {
        return this._subAppInterfaceList;
    } //-- de.netallied.functionblock.model.castor.SubAppInterfaceList getSubAppInterfaceList() 

    /**
     * Returns the value of field 'subAppNetwork'.
     * 
     * @return SubAppNetwork
     * @return the value of field 'subAppNetwork'.
     */
    public de.netallied.functionblock.model.castor.SubAppNetwork getSubAppNetwork()
    {
        return this._subAppNetwork;
    } //-- de.netallied.functionblock.model.castor.SubAppNetwork getSubAppNetwork() 

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
     * Method removeAllVersionInfo
     * 
     */
    public void removeAllVersionInfo()
    {
        _versionInfoList.removeAllElements();
    } //-- void removeAllVersionInfo() 

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
     * Sets the value of field 'comment'.
     * 
     * @param comment the value of field 'comment'.
     */
    public void setComment(java.lang.String comment)
    {
        this._comment = comment;
    } //-- void setComment(java.lang.String) 

    /**
     * Sets the value of field 'compilerInfo'.
     * 
     * @param compilerInfo the value of field 'compilerInfo'.
     */
    public void setCompilerInfo(de.netallied.functionblock.model.castor.CompilerInfo compilerInfo)
    {
        this._compilerInfo = compilerInfo;
    } //-- void setCompilerInfo(de.netallied.functionblock.model.castor.CompilerInfo) 

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
     * Sets the value of field 'name'.
     * 
     * @param name the value of field 'name'.
     */
    public void setName(java.lang.String name)
    {
        this._name = name;
    } //-- void setName(java.lang.String) 

    /**
     * Sets the value of field 'subAppInterfaceList'.
     * 
     * @param subAppInterfaceList the value of field
     * 'subAppInterfaceList'.
     */
    public void setSubAppInterfaceList(de.netallied.functionblock.model.castor.SubAppInterfaceList subAppInterfaceList)
    {
        this._subAppInterfaceList = subAppInterfaceList;
    } //-- void setSubAppInterfaceList(de.netallied.functionblock.model.castor.SubAppInterfaceList) 

    /**
     * Sets the value of field 'subAppNetwork'.
     * 
     * @param subAppNetwork the value of field 'subAppNetwork'.
     */
    public void setSubAppNetwork(de.netallied.functionblock.model.castor.SubAppNetwork subAppNetwork)
    {
        this._subAppNetwork = subAppNetwork;
    } //-- void setSubAppNetwork(de.netallied.functionblock.model.castor.SubAppNetwork) 

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
     * Method unmarshalSubAppType
     * 
     * 
     * 
     * @param reader
     * @return Object
     */
    public static java.lang.Object unmarshalSubAppType(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.netallied.functionblock.model.castor.SubAppType) Unmarshaller.unmarshal(de.netallied.functionblock.model.castor.SubAppType.class, reader);
    } //-- java.lang.Object unmarshalSubAppType(java.io.Reader) 

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
