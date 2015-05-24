/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.6</a>, using an XML
 * Schema.
 * $Id: Event.java,v 1.3 2007/02/14 19:23:03 freegroup Exp $
 */

package de.netallied.functionblock.model.castor;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Vector;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.ContentHandler;

/**
 * Class Event.
 * 
 * @version $Revision: 1.3 $ $Date: 2007/02/14 19:23:03 $
 */
public class Event implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _name
     */
    private java.lang.String _name;

    /**
     * Field _type
     */
    private java.lang.String _type;

    /**
     * Field _comment
     */
    private java.lang.String _comment;

    /**
     * Field _withList
     */
    private java.util.Vector _withList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Event() {
        super();
        _withList = new Vector();
    } //-- de.netallied.functionblock.model.castor.Event()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addWith
     * 
     * 
     * 
     * @param vWith
     */
    public void addWith(de.netallied.functionblock.model.castor.With vWith)
        throws java.lang.IndexOutOfBoundsException
    {
        _withList.addElement(vWith);
    } //-- void addWith(de.netallied.functionblock.model.castor.With) 

    /**
     * Method addWith
     * 
     * 
     * 
     * @param index
     * @param vWith
     */
    public void addWith(int index, de.netallied.functionblock.model.castor.With vWith)
        throws java.lang.IndexOutOfBoundsException
    {
        _withList.insertElementAt(vWith, index);
    } //-- void addWith(int, de.netallied.functionblock.model.castor.With) 

    /**
     * Method enumerateWith
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateWith()
    {
        return _withList.elements();
    } //-- java.util.Enumeration enumerateWith() 

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
     * Method getWith
     * 
     * 
     * 
     * @param index
     * @return With
     */
    public de.netallied.functionblock.model.castor.With getWith(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _withList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (de.netallied.functionblock.model.castor.With) _withList.elementAt(index);
    } //-- de.netallied.functionblock.model.castor.With getWith(int) 

    /**
     * Method getWith
     * 
     * 
     * 
     * @return With
     */
    public de.netallied.functionblock.model.castor.With[] getWith()
    {
        int size = _withList.size();
        de.netallied.functionblock.model.castor.With[] mArray = new de.netallied.functionblock.model.castor.With[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (de.netallied.functionblock.model.castor.With) _withList.elementAt(index);
        }
        return mArray;
    } //-- de.netallied.functionblock.model.castor.With[] getWith() 

    /**
     * Method getWithCount
     * 
     * 
     * 
     * @return int
     */
    public int getWithCount()
    {
        return _withList.size();
    } //-- int getWithCount() 

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
     * Method removeAllWith
     * 
     */
    public void removeAllWith()
    {
        _withList.removeAllElements();
    } //-- void removeAllWith() 

    /**
     * Method removeWith
     * 
     * 
     * 
     * @param index
     * @return With
     */
    public de.netallied.functionblock.model.castor.With removeWith(int index)
    {
        java.lang.Object obj = _withList.elementAt(index);
        _withList.removeElementAt(index);
        return (de.netallied.functionblock.model.castor.With) obj;
    } //-- de.netallied.functionblock.model.castor.With removeWith(int) 

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
     * Sets the value of field 'name'.
     * 
     * @param name the value of field 'name'.
     */
    public void setName(java.lang.String name)
    {
        this._name = name;
    } //-- void setName(java.lang.String) 

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
     * Method setWith
     * 
     * 
     * 
     * @param index
     * @param vWith
     */
    public void setWith(int index, de.netallied.functionblock.model.castor.With vWith)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _withList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _withList.setElementAt(vWith, index);
    } //-- void setWith(int, de.netallied.functionblock.model.castor.With) 

    /**
     * Method setWith
     * 
     * 
     * 
     * @param withArray
     */
    public void setWith(de.netallied.functionblock.model.castor.With[] withArray)
    {
        //-- copy array
        _withList.removeAllElements();
        for (int i = 0; i < withArray.length; i++) {
            _withList.addElement(withArray[i]);
        }
    } //-- void setWith(de.netallied.functionblock.model.castor.With) 

    /**
     * Method unmarshalEvent
     * 
     * 
     * 
     * @param reader
     * @return Object
     */
    public static java.lang.Object unmarshalEvent(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.netallied.functionblock.model.castor.Event) Unmarshaller.unmarshal(de.netallied.functionblock.model.castor.Event.class, reader);
    } //-- java.lang.Object unmarshalEvent(java.io.Reader) 

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
