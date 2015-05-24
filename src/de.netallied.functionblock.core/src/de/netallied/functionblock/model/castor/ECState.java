/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.6</a>, using an XML
 * Schema.
 * $Id: ECState.java,v 1.3 2007/02/14 19:23:09 freegroup Exp $
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
 * Class ECState.
 * 
 * @version $Revision: 1.3 $ $Date: 2007/02/14 19:23:09 $
 */
public class ECState implements java.io.Serializable {


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

    /**
     * Field _ECActionList
     */
    private java.util.Vector _ECActionList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ECState() {
        super();
        _ECActionList = new Vector();
    } //-- de.netallied.functionblock.model.castor.ECState()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addECAction
     * 
     * 
     * 
     * @param vECAction
     */
    public void addECAction(de.netallied.functionblock.model.castor.ECAction vECAction)
        throws java.lang.IndexOutOfBoundsException
    {
        _ECActionList.addElement(vECAction);
    } //-- void addECAction(de.netallied.functionblock.model.castor.ECAction) 

    /**
     * Method addECAction
     * 
     * 
     * 
     * @param index
     * @param vECAction
     */
    public void addECAction(int index, de.netallied.functionblock.model.castor.ECAction vECAction)
        throws java.lang.IndexOutOfBoundsException
    {
        _ECActionList.insertElementAt(vECAction, index);
    } //-- void addECAction(int, de.netallied.functionblock.model.castor.ECAction) 

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
     * Method enumerateECAction
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateECAction()
    {
        return _ECActionList.elements();
    } //-- java.util.Enumeration enumerateECAction() 

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
     * Method getECAction
     * 
     * 
     * 
     * @param index
     * @return ECAction
     */
    public de.netallied.functionblock.model.castor.ECAction getECAction(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _ECActionList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (de.netallied.functionblock.model.castor.ECAction) _ECActionList.elementAt(index);
    } //-- de.netallied.functionblock.model.castor.ECAction getECAction(int) 

    /**
     * Method getECAction
     * 
     * 
     * 
     * @return ECAction
     */
    public de.netallied.functionblock.model.castor.ECAction[] getECAction()
    {
        int size = _ECActionList.size();
        de.netallied.functionblock.model.castor.ECAction[] mArray = new de.netallied.functionblock.model.castor.ECAction[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (de.netallied.functionblock.model.castor.ECAction) _ECActionList.elementAt(index);
        }
        return mArray;
    } //-- de.netallied.functionblock.model.castor.ECAction[] getECAction() 

    /**
     * Method getECActionCount
     * 
     * 
     * 
     * @return int
     */
    public int getECActionCount()
    {
        return _ECActionList.size();
    } //-- int getECActionCount() 

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
     * Method removeAllECAction
     * 
     */
    public void removeAllECAction()
    {
        _ECActionList.removeAllElements();
    } //-- void removeAllECAction() 

    /**
     * Method removeECAction
     * 
     * 
     * 
     * @param index
     * @return ECAction
     */
    public de.netallied.functionblock.model.castor.ECAction removeECAction(int index)
    {
        java.lang.Object obj = _ECActionList.elementAt(index);
        _ECActionList.removeElementAt(index);
        return (de.netallied.functionblock.model.castor.ECAction) obj;
    } //-- de.netallied.functionblock.model.castor.ECAction removeECAction(int) 

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
     * Method setECAction
     * 
     * 
     * 
     * @param index
     * @param vECAction
     */
    public void setECAction(int index, de.netallied.functionblock.model.castor.ECAction vECAction)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _ECActionList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _ECActionList.setElementAt(vECAction, index);
    } //-- void setECAction(int, de.netallied.functionblock.model.castor.ECAction) 

    /**
     * Method setECAction
     * 
     * 
     * 
     * @param ECActionArray
     */
    public void setECAction(de.netallied.functionblock.model.castor.ECAction[] ECActionArray)
    {
        //-- copy array
        _ECActionList.removeAllElements();
        for (int i = 0; i < ECActionArray.length; i++) {
            _ECActionList.addElement(ECActionArray[i]);
        }
    } //-- void setECAction(de.netallied.functionblock.model.castor.ECAction) 

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
     * Method unmarshalECState
     * 
     * 
     * 
     * @param reader
     * @return Object
     */
    public static java.lang.Object unmarshalECState(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.netallied.functionblock.model.castor.ECState) Unmarshaller.unmarshal(de.netallied.functionblock.model.castor.ECState.class, reader);
    } //-- java.lang.Object unmarshalECState(java.io.Reader) 

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
