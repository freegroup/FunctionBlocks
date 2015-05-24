/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.6</a>, using an XML
 * Schema.
 * $Id: Application.java,v 1.3 2007/02/14 19:23:08 freegroup Exp $
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
 * Class Application.
 * 
 * @version $Revision: 1.3 $ $Date: 2007/02/14 19:23:08 $
 */
public class Application implements java.io.Serializable {


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
     * Field _FBNetwork
     */
    private de.netallied.functionblock.model.castor.FBNetwork _FBNetwork;


      //----------------/
     //- Constructors -/
    //----------------/

    public Application() {
        super();
    } //-- de.netallied.functionblock.model.castor.Application()


      //-----------/
     //- Methods -/
    //-----------/

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
     * Sets the value of field 'comment'.
     * 
     * @param comment the value of field 'comment'.
     */
    public void setComment(java.lang.String comment)
    {
        this._comment = comment;
    } //-- void setComment(java.lang.String) 

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
     * Sets the value of field 'name'.
     * 
     * @param name the value of field 'name'.
     */
    public void setName(java.lang.String name)
    {
        this._name = name;
    } //-- void setName(java.lang.String) 

    /**
     * Method unmarshalApplication
     * 
     * 
     * 
     * @param reader
     * @return Object
     */
    public static java.lang.Object unmarshalApplication(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.netallied.functionblock.model.castor.Application) Unmarshaller.unmarshal(de.netallied.functionblock.model.castor.Application.class, reader);
    } //-- java.lang.Object unmarshalApplication(java.io.Reader) 

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
