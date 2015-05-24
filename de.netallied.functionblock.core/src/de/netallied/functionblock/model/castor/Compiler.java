/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.6</a>, using an XML
 * Schema.
 * $Id: Compiler.java,v 1.3 2007/02/14 19:23:04 freegroup Exp $
 */

package de.netallied.functionblock.model.castor;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import de.netallied.functionblock.model.castor.types.CompilerLanguageType;
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
 * Class Compiler.
 * 
 * @version $Revision: 1.3 $ $Date: 2007/02/14 19:23:04 $
 */
public class Compiler implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _language
     */
    private de.netallied.functionblock.model.castor.types.CompilerLanguageType _language;

    /**
     * Field _vendor
     */
    private java.lang.String _vendor;

    /**
     * Field _product
     */
    private java.lang.String _product;

    /**
     * Field _version
     */
    private java.lang.String _version;


      //----------------/
     //- Constructors -/
    //----------------/

    public Compiler() {
        super();
    } //-- de.netallied.functionblock.model.castor.Compiler()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'language'.
     * 
     * @return CompilerLanguageType
     * @return the value of field 'language'.
     */
    public de.netallied.functionblock.model.castor.types.CompilerLanguageType getLanguage()
    {
        return this._language;
    } //-- de.netallied.functionblock.model.castor.types.CompilerLanguageType getLanguage() 

    /**
     * Returns the value of field 'product'.
     * 
     * @return String
     * @return the value of field 'product'.
     */
    public java.lang.String getProduct()
    {
        return this._product;
    } //-- java.lang.String getProduct() 

    /**
     * Returns the value of field 'vendor'.
     * 
     * @return String
     * @return the value of field 'vendor'.
     */
    public java.lang.String getVendor()
    {
        return this._vendor;
    } //-- java.lang.String getVendor() 

    /**
     * Returns the value of field 'version'.
     * 
     * @return String
     * @return the value of field 'version'.
     */
    public java.lang.String getVersion()
    {
        return this._version;
    } //-- java.lang.String getVersion() 

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
     * Sets the value of field 'language'.
     * 
     * @param language the value of field 'language'.
     */
    public void setLanguage(de.netallied.functionblock.model.castor.types.CompilerLanguageType language)
    {
        this._language = language;
    } //-- void setLanguage(de.netallied.functionblock.model.castor.types.CompilerLanguageType) 

    /**
     * Sets the value of field 'product'.
     * 
     * @param product the value of field 'product'.
     */
    public void setProduct(java.lang.String product)
    {
        this._product = product;
    } //-- void setProduct(java.lang.String) 

    /**
     * Sets the value of field 'vendor'.
     * 
     * @param vendor the value of field 'vendor'.
     */
    public void setVendor(java.lang.String vendor)
    {
        this._vendor = vendor;
    } //-- void setVendor(java.lang.String) 

    /**
     * Sets the value of field 'version'.
     * 
     * @param version the value of field 'version'.
     */
    public void setVersion(java.lang.String version)
    {
        this._version = version;
    } //-- void setVersion(java.lang.String) 

    /**
     * Method unmarshalCompiler
     * 
     * 
     * 
     * @param reader
     * @return Object
     */
    public static java.lang.Object unmarshalCompiler(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.netallied.functionblock.model.castor.Compiler) Unmarshaller.unmarshal(de.netallied.functionblock.model.castor.Compiler.class, reader);
    } //-- java.lang.Object unmarshalCompiler(java.io.Reader) 

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
