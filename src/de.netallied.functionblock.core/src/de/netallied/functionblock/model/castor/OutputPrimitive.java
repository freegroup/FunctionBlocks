/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.6</a>, using an XML
 * Schema.
 * $Id: OutputPrimitive.java,v 1.3 2007/02/14 19:23:04 freegroup Exp $
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
 * Class OutputPrimitive.
 * 
 * @version $Revision: 1.3 $ $Date: 2007/02/14 19:23:04 $
 */
public class OutputPrimitive implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _interface
     */
    private java.lang.Object _interface;

    /**
     * Field _event
     */
    private java.lang.Object _event;

    /**
     * Field _parameters
     */
    private java.lang.Object _parameters;


      //----------------/
     //- Constructors -/
    //----------------/

    public OutputPrimitive() {
        super();
    } //-- de.netallied.functionblock.model.castor.OutputPrimitive()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'event'.
     * 
     * @return Object
     * @return the value of field 'event'.
     */
    public java.lang.Object getEvent()
    {
        return this._event;
    } //-- java.lang.Object getEvent() 

    /**
     * Returns the value of field 'interface'.
     * 
     * @return Object
     * @return the value of field 'interface'.
     */
    public java.lang.Object getInterface()
    {
        return this._interface;
    } //-- java.lang.Object getInterface() 

    /**
     * Returns the value of field 'parameters'.
     * 
     * @return Object
     * @return the value of field 'parameters'.
     */
    public java.lang.Object getParameters()
    {
        return this._parameters;
    } //-- java.lang.Object getParameters() 

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
     * Sets the value of field 'event'.
     * 
     * @param event the value of field 'event'.
     */
    public void setEvent(java.lang.Object event)
    {
        this._event = event;
    } //-- void setEvent(java.lang.Object) 

    /**
     * Sets the value of field 'interface'.
     * 
     * @param _interface
     * @param interface the value of field 'interface'.
     */
    public void setInterface(java.lang.Object _interface)
    {
        this._interface = _interface;
    } //-- void setInterface(java.lang.Object) 

    /**
     * Sets the value of field 'parameters'.
     * 
     * @param parameters the value of field 'parameters'.
     */
    public void setParameters(java.lang.Object parameters)
    {
        this._parameters = parameters;
    } //-- void setParameters(java.lang.Object) 

    /**
     * Method unmarshalOutputPrimitive
     * 
     * 
     * 
     * @param reader
     * @return Object
     */
    public static java.lang.Object unmarshalOutputPrimitive(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.netallied.functionblock.model.castor.OutputPrimitive) Unmarshaller.unmarshal(de.netallied.functionblock.model.castor.OutputPrimitive.class, reader);
    } //-- java.lang.Object unmarshalOutputPrimitive(java.io.Reader) 

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
