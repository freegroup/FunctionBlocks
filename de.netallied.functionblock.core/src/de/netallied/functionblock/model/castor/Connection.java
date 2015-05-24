/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.6</a>, using an XML
 * Schema.
 * $Id: Connection.java,v 1.4 2007/02/14 19:23:03 freegroup Exp $
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
 * Class Connection.
 * 
 * @version $Revision: 1.4 $ $Date: 2007/02/14 19:23:03 $
 */
public class Connection implements java.io.Serializable {


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
     * Field _comment
     */
    private java.lang.String _comment;

    /**
     * Field _dx1
     */
    private float _dx1;

    /**
     * keeps track of state for field: _dx1
     */
    private boolean _has_dx1;

    /**
     * Field _dx2
     */
    private float _dx2;

    /**
     * keeps track of state for field: _dx2
     */
    private boolean _has_dx2;

    /**
     * Field _dy
     */
    private float _dy;

    /**
     * keeps track of state for field: _dy
     */
    private boolean _has_dy;


      //----------------/
     //- Constructors -/
    //----------------/

    public Connection() {
        super();
    } //-- de.netallied.functionblock.model.castor.Connection()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method deleteDx1
     * 
     */
    public void deleteDx1()
    {
        this._has_dx1= false;
    } //-- void deleteDx1() 

    /**
     * Method deleteDx2
     * 
     */
    public void deleteDx2()
    {
        this._has_dx2= false;
    } //-- void deleteDx2() 

    /**
     * Method deleteDy
     * 
     */
    public void deleteDy()
    {
        this._has_dy= false;
    } //-- void deleteDy() 

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
     * Returns the value of field 'dx1'.
     * 
     * @return float
     * @return the value of field 'dx1'.
     */
    public float getDx1()
    {
        return this._dx1;
    } //-- float getDx1() 

    /**
     * Returns the value of field 'dx2'.
     * 
     * @return float
     * @return the value of field 'dx2'.
     */
    public float getDx2()
    {
        return this._dx2;
    } //-- float getDx2() 

    /**
     * Returns the value of field 'dy'.
     * 
     * @return float
     * @return the value of field 'dy'.
     */
    public float getDy()
    {
        return this._dy;
    } //-- float getDy() 

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
     * Method hasDx1
     * 
     * 
     * 
     * @return boolean
     */
    public boolean hasDx1()
    {
        return this._has_dx1;
    } //-- boolean hasDx1() 

    /**
     * Method hasDx2
     * 
     * 
     * 
     * @return boolean
     */
    public boolean hasDx2()
    {
        return this._has_dx2;
    } //-- boolean hasDx2() 

    /**
     * Method hasDy
     * 
     * 
     * 
     * @return boolean
     */
    public boolean hasDy()
    {
        return this._has_dy;
    } //-- boolean hasDy() 

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
     * Sets the value of field 'destination'.
     * 
     * @param destination the value of field 'destination'.
     */
    public void setDestination(java.lang.String destination)
    {
        this._destination = destination;
    } //-- void setDestination(java.lang.String) 

    /**
     * Sets the value of field 'dx1'.
     * 
     * @param dx1 the value of field 'dx1'.
     */
    public void setDx1(float dx1)
    {
        this._dx1 = dx1;
        this._has_dx1 = true;
    } //-- void setDx1(float) 

    /**
     * Sets the value of field 'dx2'.
     * 
     * @param dx2 the value of field 'dx2'.
     */
    public void setDx2(float dx2)
    {
        this._dx2 = dx2;
        this._has_dx2 = true;
    } //-- void setDx2(float) 

    /**
     * Sets the value of field 'dy'.
     * 
     * @param dy the value of field 'dy'.
     */
    public void setDy(float dy)
    {
        this._dy = dy;
        this._has_dy = true;
    } //-- void setDy(float) 

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
     * Method unmarshalConnection
     * 
     * 
     * 
     * @param reader
     * @return Object
     */
    public static java.lang.Object unmarshalConnection(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.netallied.functionblock.model.castor.Connection) Unmarshaller.unmarshal(de.netallied.functionblock.model.castor.Connection.class, reader);
    } //-- java.lang.Object unmarshalConnection(java.io.Reader) 

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
