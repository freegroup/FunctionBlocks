/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.6</a>, using an XML
 * Schema.
 * $Id: ResourceType.java,v 1.3 2007/02/14 19:23:02 freegroup Exp $
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
 * Class ResourceType.
 * 
 * @version $Revision: 1.3 $ $Date: 2007/02/14 19:23:02 $
 */
public class ResourceType implements java.io.Serializable {


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
     * Field _FBTypeNameList
     */
    private java.util.Vector _FBTypeNameList;

    /**
     * Field _varDeclarationList
     */
    private java.util.Vector _varDeclarationList;

    /**
     * Field _FBNetwork
     */
    private de.netallied.functionblock.model.castor.FBNetwork _FBNetwork;


      //----------------/
     //- Constructors -/
    //----------------/

    public ResourceType() {
        super();
        _versionInfoList = new Vector();
        _FBTypeNameList = new Vector();
        _varDeclarationList = new Vector();
    } //-- de.netallied.functionblock.model.castor.ResourceType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addFBTypeName
     * 
     * 
     * 
     * @param vFBTypeName
     */
    public void addFBTypeName(de.netallied.functionblock.model.castor.FBTypeName vFBTypeName)
        throws java.lang.IndexOutOfBoundsException
    {
        _FBTypeNameList.addElement(vFBTypeName);
    } //-- void addFBTypeName(de.netallied.functionblock.model.castor.FBTypeName) 

    /**
     * Method addFBTypeName
     * 
     * 
     * 
     * @param index
     * @param vFBTypeName
     */
    public void addFBTypeName(int index, de.netallied.functionblock.model.castor.FBTypeName vFBTypeName)
        throws java.lang.IndexOutOfBoundsException
    {
        _FBTypeNameList.insertElementAt(vFBTypeName, index);
    } //-- void addFBTypeName(int, de.netallied.functionblock.model.castor.FBTypeName) 

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
     * Method enumerateFBTypeName
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateFBTypeName()
    {
        return _FBTypeNameList.elements();
    } //-- java.util.Enumeration enumerateFBTypeName() 

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
     * Method getFBTypeName
     * 
     * 
     * 
     * @param index
     * @return FBTypeName
     */
    public de.netallied.functionblock.model.castor.FBTypeName getFBTypeName(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _FBTypeNameList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (de.netallied.functionblock.model.castor.FBTypeName) _FBTypeNameList.elementAt(index);
    } //-- de.netallied.functionblock.model.castor.FBTypeName getFBTypeName(int) 

    /**
     * Method getFBTypeName
     * 
     * 
     * 
     * @return FBTypeName
     */
    public de.netallied.functionblock.model.castor.FBTypeName[] getFBTypeName()
    {
        int size = _FBTypeNameList.size();
        de.netallied.functionblock.model.castor.FBTypeName[] mArray = new de.netallied.functionblock.model.castor.FBTypeName[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (de.netallied.functionblock.model.castor.FBTypeName) _FBTypeNameList.elementAt(index);
        }
        return mArray;
    } //-- de.netallied.functionblock.model.castor.FBTypeName[] getFBTypeName() 

    /**
     * Method getFBTypeNameCount
     * 
     * 
     * 
     * @return int
     */
    public int getFBTypeNameCount()
    {
        return _FBTypeNameList.size();
    } //-- int getFBTypeNameCount() 

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
     * Method removeAllFBTypeName
     * 
     */
    public void removeAllFBTypeName()
    {
        _FBTypeNameList.removeAllElements();
    } //-- void removeAllFBTypeName() 

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
     * Method removeFBTypeName
     * 
     * 
     * 
     * @param index
     * @return FBTypeName
     */
    public de.netallied.functionblock.model.castor.FBTypeName removeFBTypeName(int index)
    {
        java.lang.Object obj = _FBTypeNameList.elementAt(index);
        _FBTypeNameList.removeElementAt(index);
        return (de.netallied.functionblock.model.castor.FBTypeName) obj;
    } //-- de.netallied.functionblock.model.castor.FBTypeName removeFBTypeName(int) 

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
     * Method setFBTypeName
     * 
     * 
     * 
     * @param index
     * @param vFBTypeName
     */
    public void setFBTypeName(int index, de.netallied.functionblock.model.castor.FBTypeName vFBTypeName)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _FBTypeNameList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _FBTypeNameList.setElementAt(vFBTypeName, index);
    } //-- void setFBTypeName(int, de.netallied.functionblock.model.castor.FBTypeName) 

    /**
     * Method setFBTypeName
     * 
     * 
     * 
     * @param FBTypeNameArray
     */
    public void setFBTypeName(de.netallied.functionblock.model.castor.FBTypeName[] FBTypeNameArray)
    {
        //-- copy array
        _FBTypeNameList.removeAllElements();
        for (int i = 0; i < FBTypeNameArray.length; i++) {
            _FBTypeNameList.addElement(FBTypeNameArray[i]);
        }
    } //-- void setFBTypeName(de.netallied.functionblock.model.castor.FBTypeName) 

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
     * Method unmarshalResourceType
     * 
     * 
     * 
     * @param reader
     * @return Object
     */
    public static java.lang.Object unmarshalResourceType(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.netallied.functionblock.model.castor.ResourceType) Unmarshaller.unmarshal(de.netallied.functionblock.model.castor.ResourceType.class, reader);
    } //-- java.lang.Object unmarshalResourceType(java.io.Reader) 

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
