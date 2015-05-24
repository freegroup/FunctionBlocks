/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.6</a>, using an XML
 * Schema.
 * $Id: FBType.java,v 1.3 2007/02/14 19:23:03 freegroup Exp $
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
 * Class FBType.
 * 
 * @version $Revision: 1.3 $ $Date: 2007/02/14 19:23:03 $
 */
public class FBType implements java.io.Serializable {


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
     * Field _interfaceList
     */
    private de.netallied.functionblock.model.castor.InterfaceList _interfaceList;

    /**
     * Field _FBTypeChoice
     */
    private de.netallied.functionblock.model.castor.FBTypeChoice _FBTypeChoice;

    /**
     * Field _service
     */
    private de.netallied.functionblock.model.castor.Service _service;


      //----------------/
     //- Constructors -/
    //----------------/

    public FBType() {
        super();
        _versionInfoList = new Vector();
    } //-- de.netallied.functionblock.model.castor.FBType()


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
     * Returns the value of field 'FBTypeChoice'.
     * 
     * @return FBTypeChoice
     * @return the value of field 'FBTypeChoice'.
     */
    public de.netallied.functionblock.model.castor.FBTypeChoice getFBTypeChoice()
    {
        return this._FBTypeChoice;
    } //-- de.netallied.functionblock.model.castor.FBTypeChoice getFBTypeChoice() 

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
     * Returns the value of field 'interfaceList'.
     * 
     * @return InterfaceList
     * @return the value of field 'interfaceList'.
     */
    public de.netallied.functionblock.model.castor.InterfaceList getInterfaceList()
    {
        return this._interfaceList;
    } //-- de.netallied.functionblock.model.castor.InterfaceList getInterfaceList() 

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
     * Returns the value of field 'service'.
     * 
     * @return Service
     * @return the value of field 'service'.
     */
    public de.netallied.functionblock.model.castor.Service getService()
    {
        return this._service;
    } //-- de.netallied.functionblock.model.castor.Service getService() 

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
     * Sets the value of field 'FBTypeChoice'.
     * 
     * @param FBTypeChoice the value of field 'FBTypeChoice'.
     */
    public void setFBTypeChoice(de.netallied.functionblock.model.castor.FBTypeChoice FBTypeChoice)
    {
        this._FBTypeChoice = FBTypeChoice;
    } //-- void setFBTypeChoice(de.netallied.functionblock.model.castor.FBTypeChoice) 

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
     * Sets the value of field 'interfaceList'.
     * 
     * @param interfaceList the value of field 'interfaceList'.
     */
    public void setInterfaceList(de.netallied.functionblock.model.castor.InterfaceList interfaceList)
    {
        this._interfaceList = interfaceList;
    } //-- void setInterfaceList(de.netallied.functionblock.model.castor.InterfaceList) 

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
     * Sets the value of field 'service'.
     * 
     * @param service the value of field 'service'.
     */
    public void setService(de.netallied.functionblock.model.castor.Service service)
    {
        this._service = service;
    } //-- void setService(de.netallied.functionblock.model.castor.Service) 

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
     * Method unmarshalFBType
     * 
     * 
     * 
     * @param reader
     * @return Object
     */
    public static java.lang.Object unmarshalFBType(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.netallied.functionblock.model.castor.FBType) Unmarshaller.unmarshal(de.netallied.functionblock.model.castor.FBType.class, reader);
    } //-- java.lang.Object unmarshalFBType(java.io.Reader) 

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
