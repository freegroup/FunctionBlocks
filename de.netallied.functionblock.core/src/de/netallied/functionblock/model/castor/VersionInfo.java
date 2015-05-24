/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.6</a>, using an XML
 * Schema.
 * $Id: VersionInfo.java,v 1.3 2007/02/14 19:23:03 freegroup Exp $
 */

package de.netallied.functionblock.model.castor;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.ContentHandler;

/**
 * Class VersionInfo.
 * 
 * @version $Revision: 1.3 $ $Date: 2007/02/14 19:23:03 $
 */
public class VersionInfo implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _organization
     */
    private java.lang.Object _organization;

    /**
     * Field _version
     */
    private java.lang.Object _version;

    /**
     * Field _author
     */
    private java.lang.Object _author;

    /**
     * Field _date
     */
    private java.lang.Object _date;

    /**
     * Field _remarks
     */
    private java.lang.Object _remarks;


      //----------------/
     //- Constructors -/
    //----------------/

    public VersionInfo() {
        super();
    } //-- de.netallied.functionblock.model.castor.VersionInfo()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'author'.
     * 
     * @return Object
     * @return the value of field 'author'.
     */
    public java.lang.Object getAuthor()
    {
        return this._author;
    } //-- java.lang.Object getAuthor() 

    /**
     * Returns the value of field 'date'.
     * 
     * @return Object
     * @return the value of field 'date'.
     */
    public java.lang.Object getDate()
    {
        return this._date;
    } //-- java.lang.Object getDate() 

    /**
     * Returns the value of field 'organization'.
     * 
     * @return Object
     * @return the value of field 'organization'.
     */
    public java.lang.Object getOrganization()
    {
        return this._organization;
    } //-- java.lang.Object getOrganization() 

    /**
     * Returns the value of field 'remarks'.
     * 
     * @return Object
     * @return the value of field 'remarks'.
     */
    public java.lang.Object getRemarks()
    {
        return this._remarks;
    } //-- java.lang.Object getRemarks() 

    /**
     * Returns the value of field 'version'.
     * 
     * @return Object
     * @return the value of field 'version'.
     */
    public java.lang.Object getVersion()
    {
        return this._version;
    } //-- java.lang.Object getVersion() 

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
     * Sets the value of field 'author'.
     * 
     * @param author the value of field 'author'.
     */
    public void setAuthor(java.lang.Object author)
    {
        this._author = author;
    } //-- void setAuthor(java.lang.Object) 

    /**
     * Sets the value of field 'date'.
     * 
     * @param date the value of field 'date'.
     */
    public void setDate(java.lang.Object date)
    {
        this._date = date;
    } //-- void setDate(java.lang.Object) 

    /**
     * Sets the value of field 'organization'.
     * 
     * @param organization the value of field 'organization'.
     */
    public void setOrganization(java.lang.Object organization)
    {
        this._organization = organization;
    } //-- void setOrganization(java.lang.Object) 

    /**
     * Sets the value of field 'remarks'.
     * 
     * @param remarks the value of field 'remarks'.
     */
    public void setRemarks(java.lang.Object remarks)
    {
        this._remarks = remarks;
    } //-- void setRemarks(java.lang.Object) 

    /**
     * Sets the value of field 'version'.
     * 
     * @param version the value of field 'version'.
     */
    public void setVersion(java.lang.Object version)
    {
        this._version = version;
    } //-- void setVersion(java.lang.Object) 

    /**
     * Method unmarshalVersionInfo
     * 
     * 
     * 
     * @param reader
     * @return Object
     */
    public static java.lang.Object unmarshalVersionInfo(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.netallied.functionblock.model.castor.VersionInfo) Unmarshaller.unmarshal(de.netallied.functionblock.model.castor.VersionInfo.class, reader);
    } //-- java.lang.Object unmarshalVersionInfo(java.io.Reader) 

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
