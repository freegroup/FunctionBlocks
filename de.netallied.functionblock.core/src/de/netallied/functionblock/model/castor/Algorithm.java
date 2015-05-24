/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.6</a>, using an XML
 * Schema.
 * $Id: Algorithm.java,v 1.3 2007/02/14 19:23:08 freegroup Exp $
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
 * Class Algorithm.
 * 
 * @version $Revision: 1.3 $ $Date: 2007/02/14 19:23:08 $
 */
public class Algorithm implements java.io.Serializable {


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
     * Field _FBD
     */
    private de.netallied.functionblock.model.castor.FBD _FBD;

    /**
     * Field _ST
     */
    private de.netallied.functionblock.model.castor.ST _ST;

    /**
     * Field _LD
     */
    private de.netallied.functionblock.model.castor.LD _LD;

    /**
     * Field _other
     */
    private de.netallied.functionblock.model.castor.Other _other;


      //----------------/
     //- Constructors -/
    //----------------/

    public Algorithm() {
        super();
    } //-- de.netallied.functionblock.model.castor.Algorithm()


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
     * Returns the value of field 'FBD'.
     * 
     * @return FBD
     * @return the value of field 'FBD'.
     */
    public de.netallied.functionblock.model.castor.FBD getFBD()
    {
        return this._FBD;
    } //-- de.netallied.functionblock.model.castor.FBD getFBD() 

    /**
     * Returns the value of field 'LD'.
     * 
     * @return LD
     * @return the value of field 'LD'.
     */
    public de.netallied.functionblock.model.castor.LD getLD()
    {
        return this._LD;
    } //-- de.netallied.functionblock.model.castor.LD getLD() 

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
     * Returns the value of field 'other'.
     * 
     * @return Other
     * @return the value of field 'other'.
     */
    public de.netallied.functionblock.model.castor.Other getOther()
    {
        return this._other;
    } //-- de.netallied.functionblock.model.castor.Other getOther() 

    /**
     * Returns the value of field 'ST'.
     * 
     * @return ST
     * @return the value of field 'ST'.
     */
    public de.netallied.functionblock.model.castor.ST getST()
    {
        return this._ST;
    } //-- de.netallied.functionblock.model.castor.ST getST() 

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
     * Sets the value of field 'FBD'.
     * 
     * @param FBD the value of field 'FBD'.
     */
    public void setFBD(de.netallied.functionblock.model.castor.FBD FBD)
    {
        this._FBD = FBD;
    } //-- void setFBD(de.netallied.functionblock.model.castor.FBD) 

    /**
     * Sets the value of field 'LD'.
     * 
     * @param LD the value of field 'LD'.
     */
    public void setLD(de.netallied.functionblock.model.castor.LD LD)
    {
        this._LD = LD;
    } //-- void setLD(de.netallied.functionblock.model.castor.LD) 

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
     * Sets the value of field 'other'.
     * 
     * @param other the value of field 'other'.
     */
    public void setOther(de.netallied.functionblock.model.castor.Other other)
    {
        this._other = other;
    } //-- void setOther(de.netallied.functionblock.model.castor.Other) 

    /**
     * Sets the value of field 'ST'.
     * 
     * @param ST the value of field 'ST'.
     */
    public void setST(de.netallied.functionblock.model.castor.ST ST)
    {
        this._ST = ST;
    } //-- void setST(de.netallied.functionblock.model.castor.ST) 

    /**
     * Method unmarshalAlgorithm
     * 
     * 
     * 
     * @param reader
     * @return Object
     */
    public static java.lang.Object unmarshalAlgorithm(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.netallied.functionblock.model.castor.Algorithm) Unmarshaller.unmarshal(de.netallied.functionblock.model.castor.Algorithm.class, reader);
    } //-- java.lang.Object unmarshalAlgorithm(java.io.Reader) 

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
