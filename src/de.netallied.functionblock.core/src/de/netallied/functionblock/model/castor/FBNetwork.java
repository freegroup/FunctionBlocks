/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.6</a>, using an XML
 * Schema.
 * $Id: FBNetwork.java,v 1.3 2007/02/14 19:23:01 freegroup Exp $
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
 * Class FBNetwork.
 * 
 * @version $Revision: 1.3 $ $Date: 2007/02/14 19:23:01 $
 */
public class FBNetwork implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _FBList
     */
    private java.util.Vector _FBList;

    /**
     * Field _eventConnections
     */
    private de.netallied.functionblock.model.castor.EventConnections _eventConnections;

    /**
     * Field _dataConnections
     */
    private de.netallied.functionblock.model.castor.DataConnections _dataConnections;

    /**
     * Field _adapterConnections
     */
    private de.netallied.functionblock.model.castor.AdapterConnections _adapterConnections;


      //----------------/
     //- Constructors -/
    //----------------/

    public FBNetwork() {
        super();
        _FBList = new Vector();
    } //-- de.netallied.functionblock.model.castor.FBNetwork()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addFB
     * 
     * 
     * 
     * @param vFB
     */
    public void addFB(de.netallied.functionblock.model.castor.FB vFB)
        throws java.lang.IndexOutOfBoundsException
    {
        _FBList.addElement(vFB);
    } //-- void addFB(de.netallied.functionblock.model.castor.FB) 

    /**
     * Method addFB
     * 
     * 
     * 
     * @param index
     * @param vFB
     */
    public void addFB(int index, de.netallied.functionblock.model.castor.FB vFB)
        throws java.lang.IndexOutOfBoundsException
    {
        _FBList.insertElementAt(vFB, index);
    } //-- void addFB(int, de.netallied.functionblock.model.castor.FB) 

    /**
     * Method enumerateFB
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateFB()
    {
        return _FBList.elements();
    } //-- java.util.Enumeration enumerateFB() 

    /**
     * Returns the value of field 'adapterConnections'.
     * 
     * @return AdapterConnections
     * @return the value of field 'adapterConnections'.
     */
    public de.netallied.functionblock.model.castor.AdapterConnections getAdapterConnections()
    {
        return this._adapterConnections;
    } //-- de.netallied.functionblock.model.castor.AdapterConnections getAdapterConnections() 

    /**
     * Returns the value of field 'dataConnections'.
     * 
     * @return DataConnections
     * @return the value of field 'dataConnections'.
     */
    public de.netallied.functionblock.model.castor.DataConnections getDataConnections()
    {
        return this._dataConnections;
    } //-- de.netallied.functionblock.model.castor.DataConnections getDataConnections() 

    /**
     * Returns the value of field 'eventConnections'.
     * 
     * @return EventConnections
     * @return the value of field 'eventConnections'.
     */
    public de.netallied.functionblock.model.castor.EventConnections getEventConnections()
    {
        return this._eventConnections;
    } //-- de.netallied.functionblock.model.castor.EventConnections getEventConnections() 

    /**
     * Method getFB
     * 
     * 
     * 
     * @param index
     * @return FB
     */
    public de.netallied.functionblock.model.castor.FB getFB(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _FBList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (de.netallied.functionblock.model.castor.FB) _FBList.elementAt(index);
    } //-- de.netallied.functionblock.model.castor.FB getFB(int) 

    /**
     * Method getFB
     * 
     * 
     * 
     * @return FB
     */
    public de.netallied.functionblock.model.castor.FB[] getFB()
    {
        int size = _FBList.size();
        de.netallied.functionblock.model.castor.FB[] mArray = new de.netallied.functionblock.model.castor.FB[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (de.netallied.functionblock.model.castor.FB) _FBList.elementAt(index);
        }
        return mArray;
    } //-- de.netallied.functionblock.model.castor.FB[] getFB() 

    /**
     * Method getFBCount
     * 
     * 
     * 
     * @return int
     */
    public int getFBCount()
    {
        return _FBList.size();
    } //-- int getFBCount() 

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
     * Method removeAllFB
     * 
     */
    public void removeAllFB()
    {
        _FBList.removeAllElements();
    } //-- void removeAllFB() 

    /**
     * Method removeFB
     * 
     * 
     * 
     * @param index
     * @return FB
     */
    public de.netallied.functionblock.model.castor.FB removeFB(int index)
    {
        java.lang.Object obj = _FBList.elementAt(index);
        _FBList.removeElementAt(index);
        return (de.netallied.functionblock.model.castor.FB) obj;
    } //-- de.netallied.functionblock.model.castor.FB removeFB(int) 

    /**
     * Sets the value of field 'adapterConnections'.
     * 
     * @param adapterConnections the value of field
     * 'adapterConnections'.
     */
    public void setAdapterConnections(de.netallied.functionblock.model.castor.AdapterConnections adapterConnections)
    {
        this._adapterConnections = adapterConnections;
    } //-- void setAdapterConnections(de.netallied.functionblock.model.castor.AdapterConnections) 

    /**
     * Sets the value of field 'dataConnections'.
     * 
     * @param dataConnections the value of field 'dataConnections'.
     */
    public void setDataConnections(de.netallied.functionblock.model.castor.DataConnections dataConnections)
    {
        this._dataConnections = dataConnections;
    } //-- void setDataConnections(de.netallied.functionblock.model.castor.DataConnections) 

    /**
     * Sets the value of field 'eventConnections'.
     * 
     * @param eventConnections the value of field 'eventConnections'
     */
    public void setEventConnections(de.netallied.functionblock.model.castor.EventConnections eventConnections)
    {
        this._eventConnections = eventConnections;
    } //-- void setEventConnections(de.netallied.functionblock.model.castor.EventConnections) 

    /**
     * Method setFB
     * 
     * 
     * 
     * @param index
     * @param vFB
     */
    public void setFB(int index, de.netallied.functionblock.model.castor.FB vFB)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _FBList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _FBList.setElementAt(vFB, index);
    } //-- void setFB(int, de.netallied.functionblock.model.castor.FB) 

    /**
     * Method setFB
     * 
     * 
     * 
     * @param FBArray
     */
    public void setFB(de.netallied.functionblock.model.castor.FB[] FBArray)
    {
        //-- copy array
        _FBList.removeAllElements();
        for (int i = 0; i < FBArray.length; i++) {
            _FBList.addElement(FBArray[i]);
        }
    } //-- void setFB(de.netallied.functionblock.model.castor.FB) 

    /**
     * Method unmarshalFBNetwork
     * 
     * 
     * 
     * @param reader
     * @return Object
     */
    public static java.lang.Object unmarshalFBNetwork(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.netallied.functionblock.model.castor.FBNetwork) Unmarshaller.unmarshal(de.netallied.functionblock.model.castor.FBNetwork.class, reader);
    } //-- java.lang.Object unmarshalFBNetwork(java.io.Reader) 

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
