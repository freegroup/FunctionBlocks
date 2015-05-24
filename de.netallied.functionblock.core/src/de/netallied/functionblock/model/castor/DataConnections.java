/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.6</a>, using an XML
 * Schema.
 * $Id: DataConnections.java,v 1.4 2007/02/14 19:23:02 freegroup Exp $
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
 * Class DataConnections.
 * 
 * @version $Revision: 1.4 $ $Date: 2007/02/14 19:23:02 $
 */
public class DataConnections implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _connectionList
     */
    private java.util.Vector _connectionList;


      //----------------/
     //- Constructors -/
    //----------------/

    public DataConnections() {
        super();
        _connectionList = new Vector();
    } //-- de.netallied.functionblock.model.castor.DataConnections()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addConnection
     * 
     * 
     * 
     * @param vConnection
     */
    public void addConnection(de.netallied.functionblock.model.castor.Connection vConnection)
        throws java.lang.IndexOutOfBoundsException
    {
        _connectionList.addElement(vConnection);
    } //-- void addConnection(de.netallied.functionblock.model.castor.Connection) 

    /**
     * Method addConnection
     * 
     * 
     * 
     * @param index
     * @param vConnection
     */
    public void addConnection(int index, de.netallied.functionblock.model.castor.Connection vConnection)
        throws java.lang.IndexOutOfBoundsException
    {
        _connectionList.insertElementAt(vConnection, index);
    } //-- void addConnection(int, de.netallied.functionblock.model.castor.Connection) 

    /**
     * Method enumerateConnection
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateConnection()
    {
        return _connectionList.elements();
    } //-- java.util.Enumeration enumerateConnection() 

    /**
     * Method getConnection
     * 
     * 
     * 
     * @param index
     * @return Connection
     */
    public de.netallied.functionblock.model.castor.Connection getConnection(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _connectionList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (de.netallied.functionblock.model.castor.Connection) _connectionList.elementAt(index);
    } //-- de.netallied.functionblock.model.castor.Connection getConnection(int) 

    /**
     * Method getConnection
     * 
     * 
     * 
     * @return Connection
     */
    public de.netallied.functionblock.model.castor.Connection[] getConnection()
    {
        int size = _connectionList.size();
        de.netallied.functionblock.model.castor.Connection[] mArray = new de.netallied.functionblock.model.castor.Connection[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (de.netallied.functionblock.model.castor.Connection) _connectionList.elementAt(index);
        }
        return mArray;
    } //-- de.netallied.functionblock.model.castor.Connection[] getConnection() 

    /**
     * Method getConnectionCount
     * 
     * 
     * 
     * @return int
     */
    public int getConnectionCount()
    {
        return _connectionList.size();
    } //-- int getConnectionCount() 

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
     * Method removeAllConnection
     * 
     */
    public void removeAllConnection()
    {
        _connectionList.removeAllElements();
    } //-- void removeAllConnection() 

    /**
     * Method removeConnection
     * 
     * 
     * 
     * @param index
     * @return Connection
     */
    public de.netallied.functionblock.model.castor.Connection removeConnection(int index)
    {
        java.lang.Object obj = _connectionList.elementAt(index);
        _connectionList.removeElementAt(index);
        return (de.netallied.functionblock.model.castor.Connection) obj;
    } //-- de.netallied.functionblock.model.castor.Connection removeConnection(int) 

    /**
     * Method setConnection
     * 
     * 
     * 
     * @param index
     * @param vConnection
     */
    public void setConnection(int index, de.netallied.functionblock.model.castor.Connection vConnection)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _connectionList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _connectionList.setElementAt(vConnection, index);
    } //-- void setConnection(int, de.netallied.functionblock.model.castor.Connection) 

    /**
     * Method setConnection
     * 
     * 
     * 
     * @param connectionArray
     */
    public void setConnection(de.netallied.functionblock.model.castor.Connection[] connectionArray)
    {
        //-- copy array
        _connectionList.removeAllElements();
        for (int i = 0; i < connectionArray.length; i++) {
            _connectionList.addElement(connectionArray[i]);
        }
    } //-- void setConnection(de.netallied.functionblock.model.castor.Connection) 

    /**
     * Method unmarshalDataConnections
     * 
     * 
     * 
     * @param reader
     * @return Object
     */
    public static java.lang.Object unmarshalDataConnections(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.netallied.functionblock.model.castor.DataConnections) Unmarshaller.unmarshal(de.netallied.functionblock.model.castor.DataConnections.class, reader);
    } //-- java.lang.Object unmarshalDataConnections(java.io.Reader) 

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
