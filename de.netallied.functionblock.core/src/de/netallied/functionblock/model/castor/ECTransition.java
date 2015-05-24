/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.6</a>, using an XML
 * Schema.
 * $Id: ECTransition.java,v 1.3 2007/02/14 19:23:04 freegroup Exp $
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
 * Class ECTransition.
 * 
 * @version $Revision: 1.3 $ $Date: 2007/02/14 19:23:04 $
 */
public class ECTransition implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _source
     */
    private java.lang.String _source;

    /**
     * Field _destination
     */
    private java.lang.String _destination;

    /**
     * Field _condition
     */
    private java.lang.String _condition;

    /**
     * Field _comment
     */
    private java.lang.String _comment;

    /**
     * Field _x
     */
    private float _x;

    /**
     * keeps track of state for field: _x
     */
    private boolean _has_x;

    /**
     * Field _y
     */
    private float _y;

    /**
     * keeps track of state for field: _y
     */
    private boolean _has_y;


      //----------------/
     //- Constructors -/
    //----------------/

    public ECTransition() {
        super();
    } //-- de.netallied.functionblock.model.castor.ECTransition()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method deleteX
     * 
     */
    public void deleteX()
    {
        this._has_x= false;
    } //-- void deleteX() 

    /**
     * Method deleteY
     * 
     */
    public void deleteY()
    {
        this._has_y= false;
    } //-- void deleteY() 

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
     * Returns the value of field 'condition'.
     * 
     * @return String
     * @return the value of field 'condition'.
     */
    public java.lang.String getCondition()
    {
        return this._condition;
    } //-- java.lang.String getCondition() 

    /**
     * Returns the value of field 'destination'.
     * 
     * @return String
     * @return the value of field 'destination'.
     */
    public java.lang.String getDestination()
    {
        return this._destination;
    } //-- java.lang.String getDestination() 

    /**
     * Returns the value of field 'source'.
     * 
     * @return String
     * @return the value of field 'source'.
     */
    public java.lang.String getSource()
    {
        return this._source;
    } //-- java.lang.String getSource() 

    /**
     * Returns the value of field 'x'.
     * 
     * @return float
     * @return the value of field 'x'.
     */
    public float getX()
    {
        return this._x;
    } //-- float getX() 

    /**
     * Returns the value of field 'y'.
     * 
     * @return float
     * @return the value of field 'y'.
     */
    public float getY()
    {
        return this._y;
    } //-- float getY() 

    /**
     * Method hasX
     * 
     * 
     * 
     * @return boolean
     */
    public boolean hasX()
    {
        return this._has_x;
    } //-- boolean hasX() 

    /**
     * Method hasY
     * 
     * 
     * 
     * @return boolean
     */
    public boolean hasY()
    {
        return this._has_y;
    } //-- boolean hasY() 

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
     * Sets the value of field 'condition'.
     * 
     * @param condition the value of field 'condition'.
     */
    public void setCondition(java.lang.String condition)
    {
        this._condition = condition;
    } //-- void setCondition(java.lang.String) 

    /**
     * Sets the value of field 'destination'.
     * 
     * @param destination the value of field 'destination'.
     */
    public void setDestination(java.lang.String destination)
    {
        this._destination = destination;
    } //-- void setDestination(java.lang.String) 

    /**
     * Sets the value of field 'source'.
     * 
     * @param source the value of field 'source'.
     */
    public void setSource(java.lang.String source)
    {
        this._source = source;
    } //-- void setSource(java.lang.String) 

    /**
     * Sets the value of field 'x'.
     * 
     * @param x the value of field 'x'.
     */
    public void setX(float x)
    {
        this._x = x;
        this._has_x = true;
    } //-- void setX(float) 

    /**
     * Sets the value of field 'y'.
     * 
     * @param y the value of field 'y'.
     */
    public void setY(float y)
    {
        this._y = y;
        this._has_y = true;
    } //-- void setY(float) 

    /**
     * Method unmarshalECTransition
     * 
     * 
     * 
     * @param reader
     * @return Object
     */
    public static java.lang.Object unmarshalECTransition(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.netallied.functionblock.model.castor.ECTransition) Unmarshaller.unmarshal(de.netallied.functionblock.model.castor.ECTransition.class, reader);
    } //-- java.lang.Object unmarshalECTransition(java.io.Reader) 

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
