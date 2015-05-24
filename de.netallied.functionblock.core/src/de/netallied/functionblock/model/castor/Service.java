/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.6</a>, using an XML
 * Schema.
 * $Id: Service.java,v 1.3 2007/02/14 19:23:03 freegroup Exp $
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
 * Class Service.
 * 
 * @version $Revision: 1.3 $ $Date: 2007/02/14 19:23:03 $
 */
public class Service implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _rightInterface
     */
    private java.lang.String _rightInterface;

    /**
     * Field _leftInterface
     */
    private java.lang.String _leftInterface;

    /**
     * Field _comment
     */
    private java.lang.String _comment;

    /**
     * Field _serviceSequenceList
     */
    private java.util.Vector _serviceSequenceList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Service() {
        super();
        _serviceSequenceList = new Vector();
    } //-- de.netallied.functionblock.model.castor.Service()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addServiceSequence
     * 
     * 
     * 
     * @param vServiceSequence
     */
    public void addServiceSequence(de.netallied.functionblock.model.castor.ServiceSequence vServiceSequence)
        throws java.lang.IndexOutOfBoundsException
    {
        _serviceSequenceList.addElement(vServiceSequence);
    } //-- void addServiceSequence(de.netallied.functionblock.model.castor.ServiceSequence) 

    /**
     * Method addServiceSequence
     * 
     * 
     * 
     * @param index
     * @param vServiceSequence
     */
    public void addServiceSequence(int index, de.netallied.functionblock.model.castor.ServiceSequence vServiceSequence)
        throws java.lang.IndexOutOfBoundsException
    {
        _serviceSequenceList.insertElementAt(vServiceSequence, index);
    } //-- void addServiceSequence(int, de.netallied.functionblock.model.castor.ServiceSequence) 

    /**
     * Method enumerateServiceSequence
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateServiceSequence()
    {
        return _serviceSequenceList.elements();
    } //-- java.util.Enumeration enumerateServiceSequence() 

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
     * Returns the value of field 'leftInterface'.
     * 
     * @return String
     * @return the value of field 'leftInterface'.
     */
    public java.lang.String getLeftInterface()
    {
        return this._leftInterface;
    } //-- java.lang.String getLeftInterface() 

    /**
     * Returns the value of field 'rightInterface'.
     * 
     * @return String
     * @return the value of field 'rightInterface'.
     */
    public java.lang.String getRightInterface()
    {
        return this._rightInterface;
    } //-- java.lang.String getRightInterface() 

    /**
     * Method getServiceSequence
     * 
     * 
     * 
     * @param index
     * @return ServiceSequence
     */
    public de.netallied.functionblock.model.castor.ServiceSequence getServiceSequence(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _serviceSequenceList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (de.netallied.functionblock.model.castor.ServiceSequence) _serviceSequenceList.elementAt(index);
    } //-- de.netallied.functionblock.model.castor.ServiceSequence getServiceSequence(int) 

    /**
     * Method getServiceSequence
     * 
     * 
     * 
     * @return ServiceSequence
     */
    public de.netallied.functionblock.model.castor.ServiceSequence[] getServiceSequence()
    {
        int size = _serviceSequenceList.size();
        de.netallied.functionblock.model.castor.ServiceSequence[] mArray = new de.netallied.functionblock.model.castor.ServiceSequence[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (de.netallied.functionblock.model.castor.ServiceSequence) _serviceSequenceList.elementAt(index);
        }
        return mArray;
    } //-- de.netallied.functionblock.model.castor.ServiceSequence[] getServiceSequence() 

    /**
     * Method getServiceSequenceCount
     * 
     * 
     * 
     * @return int
     */
    public int getServiceSequenceCount()
    {
        return _serviceSequenceList.size();
    } //-- int getServiceSequenceCount() 

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
     * Method removeAllServiceSequence
     * 
     */
    public void removeAllServiceSequence()
    {
        _serviceSequenceList.removeAllElements();
    } //-- void removeAllServiceSequence() 

    /**
     * Method removeServiceSequence
     * 
     * 
     * 
     * @param index
     * @return ServiceSequence
     */
    public de.netallied.functionblock.model.castor.ServiceSequence removeServiceSequence(int index)
    {
        java.lang.Object obj = _serviceSequenceList.elementAt(index);
        _serviceSequenceList.removeElementAt(index);
        return (de.netallied.functionblock.model.castor.ServiceSequence) obj;
    } //-- de.netallied.functionblock.model.castor.ServiceSequence removeServiceSequence(int) 

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
     * Sets the value of field 'leftInterface'.
     * 
     * @param leftInterface the value of field 'leftInterface'.
     */
    public void setLeftInterface(java.lang.String leftInterface)
    {
        this._leftInterface = leftInterface;
    } //-- void setLeftInterface(java.lang.String) 

    /**
     * Sets the value of field 'rightInterface'.
     * 
     * @param rightInterface the value of field 'rightInterface'.
     */
    public void setRightInterface(java.lang.String rightInterface)
    {
        this._rightInterface = rightInterface;
    } //-- void setRightInterface(java.lang.String) 

    /**
     * Method setServiceSequence
     * 
     * 
     * 
     * @param index
     * @param vServiceSequence
     */
    public void setServiceSequence(int index, de.netallied.functionblock.model.castor.ServiceSequence vServiceSequence)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _serviceSequenceList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _serviceSequenceList.setElementAt(vServiceSequence, index);
    } //-- void setServiceSequence(int, de.netallied.functionblock.model.castor.ServiceSequence) 

    /**
     * Method setServiceSequence
     * 
     * 
     * 
     * @param serviceSequenceArray
     */
    public void setServiceSequence(de.netallied.functionblock.model.castor.ServiceSequence[] serviceSequenceArray)
    {
        //-- copy array
        _serviceSequenceList.removeAllElements();
        for (int i = 0; i < serviceSequenceArray.length; i++) {
            _serviceSequenceList.addElement(serviceSequenceArray[i]);
        }
    } //-- void setServiceSequence(de.netallied.functionblock.model.castor.ServiceSequence) 

    /**
     * Method unmarshalService
     * 
     * 
     * 
     * @param reader
     * @return Object
     */
    public static java.lang.Object unmarshalService(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.netallied.functionblock.model.castor.Service) Unmarshaller.unmarshal(de.netallied.functionblock.model.castor.Service.class, reader);
    } //-- java.lang.Object unmarshalService(java.io.Reader) 

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
