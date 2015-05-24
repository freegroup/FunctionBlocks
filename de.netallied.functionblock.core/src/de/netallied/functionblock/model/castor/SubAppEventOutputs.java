/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.6</a>, using an XML
 * Schema.
 * $Id: SubAppEventOutputs.java,v 1.3 2007/02/14 19:23:03 freegroup Exp $
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
 * Class SubAppEventOutputs.
 * 
 * @version $Revision: 1.3 $ $Date: 2007/02/14 19:23:03 $
 */
public class SubAppEventOutputs implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _subAppEventList
     */
    private java.util.Vector _subAppEventList;


      //----------------/
     //- Constructors -/
    //----------------/

    public SubAppEventOutputs() {
        super();
        _subAppEventList = new Vector();
    } //-- de.netallied.functionblock.model.castor.SubAppEventOutputs()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addSubAppEvent
     * 
     * 
     * 
     * @param vSubAppEvent
     */
    public void addSubAppEvent(de.netallied.functionblock.model.castor.SubAppEvent vSubAppEvent)
        throws java.lang.IndexOutOfBoundsException
    {
        _subAppEventList.addElement(vSubAppEvent);
    } //-- void addSubAppEvent(de.netallied.functionblock.model.castor.SubAppEvent) 

    /**
     * Method addSubAppEvent
     * 
     * 
     * 
     * @param index
     * @param vSubAppEvent
     */
    public void addSubAppEvent(int index, de.netallied.functionblock.model.castor.SubAppEvent vSubAppEvent)
        throws java.lang.IndexOutOfBoundsException
    {
        _subAppEventList.insertElementAt(vSubAppEvent, index);
    } //-- void addSubAppEvent(int, de.netallied.functionblock.model.castor.SubAppEvent) 

    /**
     * Method enumerateSubAppEvent
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateSubAppEvent()
    {
        return _subAppEventList.elements();
    } //-- java.util.Enumeration enumerateSubAppEvent() 

    /**
     * Method getSubAppEvent
     * 
     * 
     * 
     * @param index
     * @return SubAppEvent
     */
    public de.netallied.functionblock.model.castor.SubAppEvent getSubAppEvent(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _subAppEventList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (de.netallied.functionblock.model.castor.SubAppEvent) _subAppEventList.elementAt(index);
    } //-- de.netallied.functionblock.model.castor.SubAppEvent getSubAppEvent(int) 

    /**
     * Method getSubAppEvent
     * 
     * 
     * 
     * @return SubAppEvent
     */
    public de.netallied.functionblock.model.castor.SubAppEvent[] getSubAppEvent()
    {
        int size = _subAppEventList.size();
        de.netallied.functionblock.model.castor.SubAppEvent[] mArray = new de.netallied.functionblock.model.castor.SubAppEvent[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (de.netallied.functionblock.model.castor.SubAppEvent) _subAppEventList.elementAt(index);
        }
        return mArray;
    } //-- de.netallied.functionblock.model.castor.SubAppEvent[] getSubAppEvent() 

    /**
     * Method getSubAppEventCount
     * 
     * 
     * 
     * @return int
     */
    public int getSubAppEventCount()
    {
        return _subAppEventList.size();
    } //-- int getSubAppEventCount() 

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
     * Method removeAllSubAppEvent
     * 
     */
    public void removeAllSubAppEvent()
    {
        _subAppEventList.removeAllElements();
    } //-- void removeAllSubAppEvent() 

    /**
     * Method removeSubAppEvent
     * 
     * 
     * 
     * @param index
     * @return SubAppEvent
     */
    public de.netallied.functionblock.model.castor.SubAppEvent removeSubAppEvent(int index)
    {
        java.lang.Object obj = _subAppEventList.elementAt(index);
        _subAppEventList.removeElementAt(index);
        return (de.netallied.functionblock.model.castor.SubAppEvent) obj;
    } //-- de.netallied.functionblock.model.castor.SubAppEvent removeSubAppEvent(int) 

    /**
     * Method setSubAppEvent
     * 
     * 
     * 
     * @param index
     * @param vSubAppEvent
     */
    public void setSubAppEvent(int index, de.netallied.functionblock.model.castor.SubAppEvent vSubAppEvent)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _subAppEventList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _subAppEventList.setElementAt(vSubAppEvent, index);
    } //-- void setSubAppEvent(int, de.netallied.functionblock.model.castor.SubAppEvent) 

    /**
     * Method setSubAppEvent
     * 
     * 
     * 
     * @param subAppEventArray
     */
    public void setSubAppEvent(de.netallied.functionblock.model.castor.SubAppEvent[] subAppEventArray)
    {
        //-- copy array
        _subAppEventList.removeAllElements();
        for (int i = 0; i < subAppEventArray.length; i++) {
            _subAppEventList.addElement(subAppEventArray[i]);
        }
    } //-- void setSubAppEvent(de.netallied.functionblock.model.castor.SubAppEvent) 

    /**
     * Method unmarshalSubAppEventOutputs
     * 
     * 
     * 
     * @param reader
     * @return Object
     */
    public static java.lang.Object unmarshalSubAppEventOutputs(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.netallied.functionblock.model.castor.SubAppEventOutputs) Unmarshaller.unmarshal(de.netallied.functionblock.model.castor.SubAppEventOutputs.class, reader);
    } //-- java.lang.Object unmarshalSubAppEventOutputs(java.io.Reader) 

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
