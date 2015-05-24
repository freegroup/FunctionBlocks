/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.6</a>, using an XML
 * Schema.
 * $Id: ServiceSequence.java,v 1.3 2007/02/14 19:23:01 freegroup Exp $
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
 * Class ServiceSequence.
 * 
 * @version $Revision: 1.3 $ $Date: 2007/02/14 19:23:01 $
 */
public class ServiceSequence implements java.io.Serializable {


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
     * Field _serviceTransactionList
     */
    private java.util.Vector _serviceTransactionList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ServiceSequence() {
        super();
        _serviceTransactionList = new Vector();
    } //-- de.netallied.functionblock.model.castor.ServiceSequence()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addServiceTransaction
     * 
     * 
     * 
     * @param vServiceTransaction
     */
    public void addServiceTransaction(de.netallied.functionblock.model.castor.ServiceTransaction vServiceTransaction)
        throws java.lang.IndexOutOfBoundsException
    {
        _serviceTransactionList.addElement(vServiceTransaction);
    } //-- void addServiceTransaction(de.netallied.functionblock.model.castor.ServiceTransaction) 

    /**
     * Method addServiceTransaction
     * 
     * 
     * 
     * @param index
     * @param vServiceTransaction
     */
    public void addServiceTransaction(int index, de.netallied.functionblock.model.castor.ServiceTransaction vServiceTransaction)
        throws java.lang.IndexOutOfBoundsException
    {
        _serviceTransactionList.insertElementAt(vServiceTransaction, index);
    } //-- void addServiceTransaction(int, de.netallied.functionblock.model.castor.ServiceTransaction) 

    /**
     * Method enumerateServiceTransaction
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateServiceTransaction()
    {
        return _serviceTransactionList.elements();
    } //-- java.util.Enumeration enumerateServiceTransaction() 

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
     * Method getServiceTransaction
     * 
     * 
     * 
     * @param index
     * @return ServiceTransaction
     */
    public de.netallied.functionblock.model.castor.ServiceTransaction getServiceTransaction(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _serviceTransactionList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (de.netallied.functionblock.model.castor.ServiceTransaction) _serviceTransactionList.elementAt(index);
    } //-- de.netallied.functionblock.model.castor.ServiceTransaction getServiceTransaction(int) 

    /**
     * Method getServiceTransaction
     * 
     * 
     * 
     * @return ServiceTransaction
     */
    public de.netallied.functionblock.model.castor.ServiceTransaction[] getServiceTransaction()
    {
        int size = _serviceTransactionList.size();
        de.netallied.functionblock.model.castor.ServiceTransaction[] mArray = new de.netallied.functionblock.model.castor.ServiceTransaction[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (de.netallied.functionblock.model.castor.ServiceTransaction) _serviceTransactionList.elementAt(index);
        }
        return mArray;
    } //-- de.netallied.functionblock.model.castor.ServiceTransaction[] getServiceTransaction() 

    /**
     * Method getServiceTransactionCount
     * 
     * 
     * 
     * @return int
     */
    public int getServiceTransactionCount()
    {
        return _serviceTransactionList.size();
    } //-- int getServiceTransactionCount() 

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
     * Method removeAllServiceTransaction
     * 
     */
    public void removeAllServiceTransaction()
    {
        _serviceTransactionList.removeAllElements();
    } //-- void removeAllServiceTransaction() 

    /**
     * Method removeServiceTransaction
     * 
     * 
     * 
     * @param index
     * @return ServiceTransaction
     */
    public de.netallied.functionblock.model.castor.ServiceTransaction removeServiceTransaction(int index)
    {
        java.lang.Object obj = _serviceTransactionList.elementAt(index);
        _serviceTransactionList.removeElementAt(index);
        return (de.netallied.functionblock.model.castor.ServiceTransaction) obj;
    } //-- de.netallied.functionblock.model.castor.ServiceTransaction removeServiceTransaction(int) 

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
     * Method setServiceTransaction
     * 
     * 
     * 
     * @param index
     * @param vServiceTransaction
     */
    public void setServiceTransaction(int index, de.netallied.functionblock.model.castor.ServiceTransaction vServiceTransaction)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _serviceTransactionList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _serviceTransactionList.setElementAt(vServiceTransaction, index);
    } //-- void setServiceTransaction(int, de.netallied.functionblock.model.castor.ServiceTransaction) 

    /**
     * Method setServiceTransaction
     * 
     * 
     * 
     * @param serviceTransactionArray
     */
    public void setServiceTransaction(de.netallied.functionblock.model.castor.ServiceTransaction[] serviceTransactionArray)
    {
        //-- copy array
        _serviceTransactionList.removeAllElements();
        for (int i = 0; i < serviceTransactionArray.length; i++) {
            _serviceTransactionList.addElement(serviceTransactionArray[i]);
        }
    } //-- void setServiceTransaction(de.netallied.functionblock.model.castor.ServiceTransaction) 

    /**
     * Method unmarshalServiceSequence
     * 
     * 
     * 
     * @param reader
     * @return Object
     */
    public static java.lang.Object unmarshalServiceSequence(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.netallied.functionblock.model.castor.ServiceSequence) Unmarshaller.unmarshal(de.netallied.functionblock.model.castor.ServiceSequence.class, reader);
    } //-- java.lang.Object unmarshalServiceSequence(java.io.Reader) 

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
