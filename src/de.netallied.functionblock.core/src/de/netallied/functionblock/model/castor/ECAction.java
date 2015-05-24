/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.6</a>, using an XML
 * Schema.
 * $Id: ECAction.java,v 1.3 2007/02/14 19:23:03 freegroup Exp $
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
 * Class ECAction.
 * 
 * @version $Revision: 1.3 $ $Date: 2007/02/14 19:23:03 $
 */
public class ECAction implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _algorithm
     */
    private java.lang.String _algorithm;

    /**
     * Field _output
     */
    private java.lang.String _output;


      //----------------/
     //- Constructors -/
    //----------------/

    public ECAction() {
        super();
    } //-- de.netallied.functionblock.model.castor.ECAction()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'algorithm'.
     * 
     * @return String
     * @return the value of field 'algorithm'.
     */
    public java.lang.String getAlgorithm()
    {
        return this._algorithm;
    } //-- java.lang.String getAlgorithm() 

    /**
     * Returns the value of field 'output'.
     * 
     * @return String
     * @return the value of field 'output'.
     */
    public java.lang.String getOutput()
    {
        return this._output;
    } //-- java.lang.String getOutput() 

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
     * Sets the value of field 'algorithm'.
     * 
     * @param algorithm the value of field 'algorithm'.
     */
    public void setAlgorithm(java.lang.String algorithm)
    {
        this._algorithm = algorithm;
    } //-- void setAlgorithm(java.lang.String) 

    /**
     * Sets the value of field 'output'.
     * 
     * @param output the value of field 'output'.
     */
    public void setOutput(java.lang.String output)
    {
        this._output = output;
    } //-- void setOutput(java.lang.String) 

    /**
     * Method unmarshalECAction
     * 
     * 
     * 
     * @param reader
     * @return Object
     */
    public static java.lang.Object unmarshalECAction(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.netallied.functionblock.model.castor.ECAction) Unmarshaller.unmarshal(de.netallied.functionblock.model.castor.ECAction.class, reader);
    } //-- java.lang.Object unmarshalECAction(java.io.Reader) 

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
