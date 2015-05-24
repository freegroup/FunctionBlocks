/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.6</a>, using an XML
 * Schema.
 * $Id: FBTypeChoice.java,v 1.3 2007/02/14 19:23:01 freegroup Exp $
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
 * Class FBTypeChoice.
 * 
 * @version $Revision: 1.3 $ $Date: 2007/02/14 19:23:01 $
 */
public class FBTypeChoice implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _basicFB
     */
    private de.netallied.functionblock.model.castor.BasicFB _basicFB;

    /**
     * Field _FBNetwork
     */
    private de.netallied.functionblock.model.castor.FBNetwork _FBNetwork;


      //----------------/
     //- Constructors -/
    //----------------/

    public FBTypeChoice() {
        super();
    } //-- de.netallied.functionblock.model.castor.FBTypeChoice()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'basicFB'.
     * 
     * @return BasicFB
     * @return the value of field 'basicFB'.
     */
    public de.netallied.functionblock.model.castor.BasicFB getBasicFB()
    {
        return this._basicFB;
    } //-- de.netallied.functionblock.model.castor.BasicFB getBasicFB() 

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
     * Sets the value of field 'basicFB'.
     * 
     * @param basicFB the value of field 'basicFB'.
     */
    public void setBasicFB(de.netallied.functionblock.model.castor.BasicFB basicFB)
    {
        this._basicFB = basicFB;
    } //-- void setBasicFB(de.netallied.functionblock.model.castor.BasicFB) 

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
     * Method unmarshalFBTypeChoice
     * 
     * 
     * 
     * @param reader
     * @return Object
     */
    public static java.lang.Object unmarshalFBTypeChoice(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.netallied.functionblock.model.castor.FBTypeChoice) Unmarshaller.unmarshal(de.netallied.functionblock.model.castor.FBTypeChoice.class, reader);
    } //-- java.lang.Object unmarshalFBTypeChoice(java.io.Reader) 

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
