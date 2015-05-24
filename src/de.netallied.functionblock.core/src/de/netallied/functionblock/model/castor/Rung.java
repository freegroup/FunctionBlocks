/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.6</a>, using an XML
 * Schema.
 * $Id: Rung.java,v 1.3 2007/02/14 19:23:01 freegroup Exp $
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
 * Class Rung.
 * 
 * @version $Revision: 1.3 $ $Date: 2007/02/14 19:23:01 $
 */
public class Rung implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _output
     */
    private java.lang.Object _output;

    /**
     * Field _expression
     */
    private java.lang.Object _expression;

    /**
     * Field _comment
     */
    private java.lang.String _comment;


      //----------------/
     //- Constructors -/
    //----------------/

    public Rung() {
        super();
    } //-- de.netallied.functionblock.model.castor.Rung()


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
     * Returns the value of field 'expression'.
     * 
     * @return Object
     * @return the value of field 'expression'.
     */
    public java.lang.Object getExpression()
    {
        return this._expression;
    } //-- java.lang.Object getExpression() 

    /**
     * Returns the value of field 'output'.
     * 
     * @return Object
     * @return the value of field 'output'.
     */
    public java.lang.Object getOutput()
    {
        return this._output;
    } //-- java.lang.Object getOutput() 

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
     * Sets the value of field 'expression'.
     * 
     * @param expression the value of field 'expression'.
     */
    public void setExpression(java.lang.Object expression)
    {
        this._expression = expression;
    } //-- void setExpression(java.lang.Object) 

    /**
     * Sets the value of field 'output'.
     * 
     * @param output the value of field 'output'.
     */
    public void setOutput(java.lang.Object output)
    {
        this._output = output;
    } //-- void setOutput(java.lang.Object) 

    /**
     * Method unmarshalRung
     * 
     * 
     * 
     * @param reader
     * @return Object
     */
    public static java.lang.Object unmarshalRung(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.netallied.functionblock.model.castor.Rung) Unmarshaller.unmarshal(de.netallied.functionblock.model.castor.Rung.class, reader);
    } //-- java.lang.Object unmarshalRung(java.io.Reader) 

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
