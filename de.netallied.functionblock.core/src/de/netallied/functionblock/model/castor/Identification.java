/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.6</a>, using an XML
 * Schema.
 * $Id: Identification.java,v 1.3 2007/02/14 19:23:04 freegroup Exp $
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
 * Class Identification.
 * 
 * @version $Revision: 1.3 $ $Date: 2007/02/14 19:23:04 $
 */
public class Identification implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _standard
     */
    private java.lang.String _standard;

    /**
     * Field _classification
     */
    private java.lang.String _classification;

    /**
     * Field _applicationDomain
     */
    private java.lang.String _applicationDomain;

    /**
     * Field _function
     */
    private java.lang.String _function;

    /**
     * Field _type
     */
    private java.lang.String _type;

    /**
     * Field _description
     */
    private java.lang.String _description;


      //----------------/
     //- Constructors -/
    //----------------/

    public Identification() {
        super();
    } //-- de.netallied.functionblock.model.castor.Identification()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'applicationDomain'.
     * 
     * @return String
     * @return the value of field 'applicationDomain'.
     */
    public java.lang.String getApplicationDomain()
    {
        return this._applicationDomain;
    } //-- java.lang.String getApplicationDomain() 

    /**
     * Returns the value of field 'classification'.
     * 
     * @return String
     * @return the value of field 'classification'.
     */
    public java.lang.String getClassification()
    {
        return this._classification;
    } //-- java.lang.String getClassification() 

    /**
     * Returns the value of field 'description'.
     * 
     * @return String
     * @return the value of field 'description'.
     */
    public java.lang.String getDescription()
    {
        return this._description;
    } //-- java.lang.String getDescription() 

    /**
     * Returns the value of field 'function'.
     * 
     * @return String
     * @return the value of field 'function'.
     */
    public java.lang.String getFunction()
    {
        return this._function;
    } //-- java.lang.String getFunction() 

    /**
     * Returns the value of field 'standard'.
     * 
     * @return String
     * @return the value of field 'standard'.
     */
    public java.lang.String getStandard()
    {
        return this._standard;
    } //-- java.lang.String getStandard() 

    /**
     * Returns the value of field 'type'.
     * 
     * @return String
     * @return the value of field 'type'.
     */
    public java.lang.String getType()
    {
        return this._type;
    } //-- java.lang.String getType() 

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
     * Sets the value of field 'applicationDomain'.
     * 
     * @param applicationDomain the value of field
     * 'applicationDomain'.
     */
    public void setApplicationDomain(java.lang.String applicationDomain)
    {
        this._applicationDomain = applicationDomain;
    } //-- void setApplicationDomain(java.lang.String) 

    /**
     * Sets the value of field 'classification'.
     * 
     * @param classification the value of field 'classification'.
     */
    public void setClassification(java.lang.String classification)
    {
        this._classification = classification;
    } //-- void setClassification(java.lang.String) 

    /**
     * Sets the value of field 'description'.
     * 
     * @param description the value of field 'description'.
     */
    public void setDescription(java.lang.String description)
    {
        this._description = description;
    } //-- void setDescription(java.lang.String) 

    /**
     * Sets the value of field 'function'.
     * 
     * @param function the value of field 'function'.
     */
    public void setFunction(java.lang.String function)
    {
        this._function = function;
    } //-- void setFunction(java.lang.String) 

    /**
     * Sets the value of field 'standard'.
     * 
     * @param standard the value of field 'standard'.
     */
    public void setStandard(java.lang.String standard)
    {
        this._standard = standard;
    } //-- void setStandard(java.lang.String) 

    /**
     * Sets the value of field 'type'.
     * 
     * @param type the value of field 'type'.
     */
    public void setType(java.lang.String type)
    {
        this._type = type;
    } //-- void setType(java.lang.String) 

    /**
     * Method unmarshalIdentification
     * 
     * 
     * 
     * @param reader
     * @return Object
     */
    public static java.lang.Object unmarshalIdentification(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.netallied.functionblock.model.castor.Identification) Unmarshaller.unmarshal(de.netallied.functionblock.model.castor.Identification.class, reader);
    } //-- java.lang.Object unmarshalIdentification(java.io.Reader) 

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
