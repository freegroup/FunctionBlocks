/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.6</a>, using an XML
 * Schema.
 * $Id: DeviceType.java,v 1.3 2007/02/14 19:23:01 freegroup Exp $
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
 * Class DeviceType.
 * 
 * @version $Revision: 1.3 $ $Date: 2007/02/14 19:23:01 $
 */
public class DeviceType implements java.io.Serializable {


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
     * Field _varDeclarationList
     */
    private java.util.Vector _varDeclarationList;

    /**
     * Field _resourceTypeNameList
     */
    private java.util.Vector _resourceTypeNameList;

    /**
     * Field _resourceList
     */
    private java.util.Vector _resourceList;

    /**
     * Field _FBNetwork
     */
    private de.netallied.functionblock.model.castor.FBNetwork _FBNetwork;


      //----------------/
     //- Constructors -/
    //----------------/

    public DeviceType() {
        super();
        _versionInfoList = new Vector();
        _varDeclarationList = new Vector();
        _resourceTypeNameList = new Vector();
        _resourceList = new Vector();
    } //-- de.netallied.functionblock.model.castor.DeviceType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addResource
     * 
     * 
     * 
     * @param vResource
     */
    public void addResource(de.netallied.functionblock.model.castor.Resource vResource)
        throws java.lang.IndexOutOfBoundsException
    {
        _resourceList.addElement(vResource);
    } //-- void addResource(de.netallied.functionblock.model.castor.Resource) 

    /**
     * Method addResource
     * 
     * 
     * 
     * @param index
     * @param vResource
     */
    public void addResource(int index, de.netallied.functionblock.model.castor.Resource vResource)
        throws java.lang.IndexOutOfBoundsException
    {
        _resourceList.insertElementAt(vResource, index);
    } //-- void addResource(int, de.netallied.functionblock.model.castor.Resource) 

    /**
     * Method addResourceTypeName
     * 
     * 
     * 
     * @param vResourceTypeName
     */
    public void addResourceTypeName(de.netallied.functionblock.model.castor.ResourceTypeName vResourceTypeName)
        throws java.lang.IndexOutOfBoundsException
    {
        _resourceTypeNameList.addElement(vResourceTypeName);
    } //-- void addResourceTypeName(de.netallied.functionblock.model.castor.ResourceTypeName) 

    /**
     * Method addResourceTypeName
     * 
     * 
     * 
     * @param index
     * @param vResourceTypeName
     */
    public void addResourceTypeName(int index, de.netallied.functionblock.model.castor.ResourceTypeName vResourceTypeName)
        throws java.lang.IndexOutOfBoundsException
    {
        _resourceTypeNameList.insertElementAt(vResourceTypeName, index);
    } //-- void addResourceTypeName(int, de.netallied.functionblock.model.castor.ResourceTypeName) 

    /**
     * Method addVarDeclaration
     * 
     * 
     * 
     * @param vVarDeclaration
     */
    public void addVarDeclaration(de.netallied.functionblock.model.castor.VarDeclaration vVarDeclaration)
        throws java.lang.IndexOutOfBoundsException
    {
        _varDeclarationList.addElement(vVarDeclaration);
    } //-- void addVarDeclaration(de.netallied.functionblock.model.castor.VarDeclaration) 

    /**
     * Method addVarDeclaration
     * 
     * 
     * 
     * @param index
     * @param vVarDeclaration
     */
    public void addVarDeclaration(int index, de.netallied.functionblock.model.castor.VarDeclaration vVarDeclaration)
        throws java.lang.IndexOutOfBoundsException
    {
        _varDeclarationList.insertElementAt(vVarDeclaration, index);
    } //-- void addVarDeclaration(int, de.netallied.functionblock.model.castor.VarDeclaration) 

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
     * Method enumerateResource
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateResource()
    {
        return _resourceList.elements();
    } //-- java.util.Enumeration enumerateResource() 

    /**
     * Method enumerateResourceTypeName
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateResourceTypeName()
    {
        return _resourceTypeNameList.elements();
    } //-- java.util.Enumeration enumerateResourceTypeName() 

    /**
     * Method enumerateVarDeclaration
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateVarDeclaration()
    {
        return _varDeclarationList.elements();
    } //-- java.util.Enumeration enumerateVarDeclaration() 

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
     * Returns the value of field 'FBNetwork'.
     * 
     * @return FBNetwork
     * @return the value of field 'FBNetwork'.
     */
    public de.netallied.functionblock.model.castor.FBNetwork getFBNetwork()
    {
        return this._FBNetwork;
    } //-- de.netallied.functionblock.model.castor.FBNetwork getFBNetwork() 

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
     * Method getResource
     * 
     * 
     * 
     * @param index
     * @return Resource
     */
    public de.netallied.functionblock.model.castor.Resource getResource(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _resourceList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (de.netallied.functionblock.model.castor.Resource) _resourceList.elementAt(index);
    } //-- de.netallied.functionblock.model.castor.Resource getResource(int) 

    /**
     * Method getResource
     * 
     * 
     * 
     * @return Resource
     */
    public de.netallied.functionblock.model.castor.Resource[] getResource()
    {
        int size = _resourceList.size();
        de.netallied.functionblock.model.castor.Resource[] mArray = new de.netallied.functionblock.model.castor.Resource[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (de.netallied.functionblock.model.castor.Resource) _resourceList.elementAt(index);
        }
        return mArray;
    } //-- de.netallied.functionblock.model.castor.Resource[] getResource() 

    /**
     * Method getResourceCount
     * 
     * 
     * 
     * @return int
     */
    public int getResourceCount()
    {
        return _resourceList.size();
    } //-- int getResourceCount() 

    /**
     * Method getResourceTypeName
     * 
     * 
     * 
     * @param index
     * @return ResourceTypeName
     */
    public de.netallied.functionblock.model.castor.ResourceTypeName getResourceTypeName(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _resourceTypeNameList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (de.netallied.functionblock.model.castor.ResourceTypeName) _resourceTypeNameList.elementAt(index);
    } //-- de.netallied.functionblock.model.castor.ResourceTypeName getResourceTypeName(int) 

    /**
     * Method getResourceTypeName
     * 
     * 
     * 
     * @return ResourceTypeName
     */
    public de.netallied.functionblock.model.castor.ResourceTypeName[] getResourceTypeName()
    {
        int size = _resourceTypeNameList.size();
        de.netallied.functionblock.model.castor.ResourceTypeName[] mArray = new de.netallied.functionblock.model.castor.ResourceTypeName[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (de.netallied.functionblock.model.castor.ResourceTypeName) _resourceTypeNameList.elementAt(index);
        }
        return mArray;
    } //-- de.netallied.functionblock.model.castor.ResourceTypeName[] getResourceTypeName() 

    /**
     * Method getResourceTypeNameCount
     * 
     * 
     * 
     * @return int
     */
    public int getResourceTypeNameCount()
    {
        return _resourceTypeNameList.size();
    } //-- int getResourceTypeNameCount() 

    /**
     * Method getVarDeclaration
     * 
     * 
     * 
     * @param index
     * @return VarDeclaration
     */
    public de.netallied.functionblock.model.castor.VarDeclaration getVarDeclaration(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _varDeclarationList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (de.netallied.functionblock.model.castor.VarDeclaration) _varDeclarationList.elementAt(index);
    } //-- de.netallied.functionblock.model.castor.VarDeclaration getVarDeclaration(int) 

    /**
     * Method getVarDeclaration
     * 
     * 
     * 
     * @return VarDeclaration
     */
    public de.netallied.functionblock.model.castor.VarDeclaration[] getVarDeclaration()
    {
        int size = _varDeclarationList.size();
        de.netallied.functionblock.model.castor.VarDeclaration[] mArray = new de.netallied.functionblock.model.castor.VarDeclaration[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (de.netallied.functionblock.model.castor.VarDeclaration) _varDeclarationList.elementAt(index);
        }
        return mArray;
    } //-- de.netallied.functionblock.model.castor.VarDeclaration[] getVarDeclaration() 

    /**
     * Method getVarDeclarationCount
     * 
     * 
     * 
     * @return int
     */
    public int getVarDeclarationCount()
    {
        return _varDeclarationList.size();
    } //-- int getVarDeclarationCount() 

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
     * Method removeAllResource
     * 
     */
    public void removeAllResource()
    {
        _resourceList.removeAllElements();
    } //-- void removeAllResource() 

    /**
     * Method removeAllResourceTypeName
     * 
     */
    public void removeAllResourceTypeName()
    {
        _resourceTypeNameList.removeAllElements();
    } //-- void removeAllResourceTypeName() 

    /**
     * Method removeAllVarDeclaration
     * 
     */
    public void removeAllVarDeclaration()
    {
        _varDeclarationList.removeAllElements();
    } //-- void removeAllVarDeclaration() 

    /**
     * Method removeAllVersionInfo
     * 
     */
    public void removeAllVersionInfo()
    {
        _versionInfoList.removeAllElements();
    } //-- void removeAllVersionInfo() 

    /**
     * Method removeResource
     * 
     * 
     * 
     * @param index
     * @return Resource
     */
    public de.netallied.functionblock.model.castor.Resource removeResource(int index)
    {
        java.lang.Object obj = _resourceList.elementAt(index);
        _resourceList.removeElementAt(index);
        return (de.netallied.functionblock.model.castor.Resource) obj;
    } //-- de.netallied.functionblock.model.castor.Resource removeResource(int) 

    /**
     * Method removeResourceTypeName
     * 
     * 
     * 
     * @param index
     * @return ResourceTypeName
     */
    public de.netallied.functionblock.model.castor.ResourceTypeName removeResourceTypeName(int index)
    {
        java.lang.Object obj = _resourceTypeNameList.elementAt(index);
        _resourceTypeNameList.removeElementAt(index);
        return (de.netallied.functionblock.model.castor.ResourceTypeName) obj;
    } //-- de.netallied.functionblock.model.castor.ResourceTypeName removeResourceTypeName(int) 

    /**
     * Method removeVarDeclaration
     * 
     * 
     * 
     * @param index
     * @return VarDeclaration
     */
    public de.netallied.functionblock.model.castor.VarDeclaration removeVarDeclaration(int index)
    {
        java.lang.Object obj = _varDeclarationList.elementAt(index);
        _varDeclarationList.removeElementAt(index);
        return (de.netallied.functionblock.model.castor.VarDeclaration) obj;
    } //-- de.netallied.functionblock.model.castor.VarDeclaration removeVarDeclaration(int) 

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
     * Sets the value of field 'FBNetwork'.
     * 
     * @param FBNetwork the value of field 'FBNetwork'.
     */
    public void setFBNetwork(de.netallied.functionblock.model.castor.FBNetwork FBNetwork)
    {
        this._FBNetwork = FBNetwork;
    } //-- void setFBNetwork(de.netallied.functionblock.model.castor.FBNetwork) 

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
     * Method setResource
     * 
     * 
     * 
     * @param index
     * @param vResource
     */
    public void setResource(int index, de.netallied.functionblock.model.castor.Resource vResource)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _resourceList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _resourceList.setElementAt(vResource, index);
    } //-- void setResource(int, de.netallied.functionblock.model.castor.Resource) 

    /**
     * Method setResource
     * 
     * 
     * 
     * @param resourceArray
     */
    public void setResource(de.netallied.functionblock.model.castor.Resource[] resourceArray)
    {
        //-- copy array
        _resourceList.removeAllElements();
        for (int i = 0; i < resourceArray.length; i++) {
            _resourceList.addElement(resourceArray[i]);
        }
    } //-- void setResource(de.netallied.functionblock.model.castor.Resource) 

    /**
     * Method setResourceTypeName
     * 
     * 
     * 
     * @param index
     * @param vResourceTypeName
     */
    public void setResourceTypeName(int index, de.netallied.functionblock.model.castor.ResourceTypeName vResourceTypeName)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _resourceTypeNameList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _resourceTypeNameList.setElementAt(vResourceTypeName, index);
    } //-- void setResourceTypeName(int, de.netallied.functionblock.model.castor.ResourceTypeName) 

    /**
     * Method setResourceTypeName
     * 
     * 
     * 
     * @param resourceTypeNameArray
     */
    public void setResourceTypeName(de.netallied.functionblock.model.castor.ResourceTypeName[] resourceTypeNameArray)
    {
        //-- copy array
        _resourceTypeNameList.removeAllElements();
        for (int i = 0; i < resourceTypeNameArray.length; i++) {
            _resourceTypeNameList.addElement(resourceTypeNameArray[i]);
        }
    } //-- void setResourceTypeName(de.netallied.functionblock.model.castor.ResourceTypeName) 

    /**
     * Method setVarDeclaration
     * 
     * 
     * 
     * @param index
     * @param vVarDeclaration
     */
    public void setVarDeclaration(int index, de.netallied.functionblock.model.castor.VarDeclaration vVarDeclaration)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _varDeclarationList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _varDeclarationList.setElementAt(vVarDeclaration, index);
    } //-- void setVarDeclaration(int, de.netallied.functionblock.model.castor.VarDeclaration) 

    /**
     * Method setVarDeclaration
     * 
     * 
     * 
     * @param varDeclarationArray
     */
    public void setVarDeclaration(de.netallied.functionblock.model.castor.VarDeclaration[] varDeclarationArray)
    {
        //-- copy array
        _varDeclarationList.removeAllElements();
        for (int i = 0; i < varDeclarationArray.length; i++) {
            _varDeclarationList.addElement(varDeclarationArray[i]);
        }
    } //-- void setVarDeclaration(de.netallied.functionblock.model.castor.VarDeclaration) 

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
     * Method unmarshalDeviceType
     * 
     * 
     * 
     * @param reader
     * @return Object
     */
    public static java.lang.Object unmarshalDeviceType(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.netallied.functionblock.model.castor.DeviceType) Unmarshaller.unmarshal(de.netallied.functionblock.model.castor.DeviceType.class, reader);
    } //-- java.lang.Object unmarshalDeviceType(java.io.Reader) 

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
