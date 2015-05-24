/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.6</a>, using an XML
 * Schema.
 * $Id: EventInputs.java,v 1.3 2007/02/14 19:23:03 freegroup Exp $
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
 * Class EventInputs.
 * 
 * @version $Revision: 1.3 $ $Date: 2007/02/14 19:23:03 $
 */
public class EventInputs implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _eventList
     */
    private java.util.Vector _eventList;


      //----------------/
     //- Constructors -/
    //----------------/

    public EventInputs() {
        super();
        _eventList = new Vector();
    } //-- de.netallied.functionblock.model.castor.EventInputs()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addEvent
     * 
     * 
     * 
     * @param vEvent
     */
    public void addEvent(de.netallied.functionblock.model.castor.Event vEvent)
        throws java.lang.IndexOutOfBoundsException
    {
        _eventList.addElement(vEvent);
    } //-- void addEvent(de.netallied.functionblock.model.castor.Event) 

    /**
     * Method addEvent
     * 
     * 
     * 
     * @param index
     * @param vEvent
     */
    public void addEvent(int index, de.netallied.functionblock.model.castor.Event vEvent)
        throws java.lang.IndexOutOfBoundsException
    {
        _eventList.insertElementAt(vEvent, index);
    } //-- void addEvent(int, de.netallied.functionblock.model.castor.Event) 

    /**
     * Method enumerateEvent
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateEvent()
    {
        return _eventList.elements();
    } //-- java.util.Enumeration enumerateEvent() 

    /**
     * Method getEvent
     * 
     * 
     * 
     * @param index
     * @return Event
     */
    public de.netallied.functionblock.model.castor.Event getEvent(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _eventList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (de.netallied.functionblock.model.castor.Event) _eventList.elementAt(index);
    } //-- de.netallied.functionblock.model.castor.Event getEvent(int) 

    /**
     * Method getEvent
     * 
     * 
     * 
     * @return Event
     */
    public de.netallied.functionblock.model.castor.Event[] getEvent()
    {
        int size = _eventList.size();
        de.netallied.functionblock.model.castor.Event[] mArray = new de.netallied.functionblock.model.castor.Event[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (de.netallied.functionblock.model.castor.Event) _eventList.elementAt(index);
        }
        return mArray;
    } //-- de.netallied.functionblock.model.castor.Event[] getEvent() 

    /**
     * Method getEventCount
     * 
     * 
     * 
     * @return int
     */
    public int getEventCount()
    {
        return _eventList.size();
    } //-- int getEventCount() 

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
     * Method removeAllEvent
     * 
     */
    public void removeAllEvent()
    {
        _eventList.removeAllElements();
    } //-- void removeAllEvent() 

    /**
     * Method removeEvent
     * 
     * 
     * 
     * @param index
     * @return Event
     */
    public de.netallied.functionblock.model.castor.Event removeEvent(int index)
    {
        java.lang.Object obj = _eventList.elementAt(index);
        _eventList.removeElementAt(index);
        return (de.netallied.functionblock.model.castor.Event) obj;
    } //-- de.netallied.functionblock.model.castor.Event removeEvent(int) 

    /**
     * Method setEvent
     * 
     * 
     * 
     * @param index
     * @param vEvent
     */
    public void setEvent(int index, de.netallied.functionblock.model.castor.Event vEvent)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _eventList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _eventList.setElementAt(vEvent, index);
    } //-- void setEvent(int, de.netallied.functionblock.model.castor.Event) 

    /**
     * Method setEvent
     * 
     * 
     * 
     * @param eventArray
     */
    public void setEvent(de.netallied.functionblock.model.castor.Event[] eventArray)
    {
        //-- copy array
        _eventList.removeAllElements();
        for (int i = 0; i < eventArray.length; i++) {
            _eventList.addElement(eventArray[i]);
        }
    } //-- void setEvent(de.netallied.functionblock.model.castor.Event) 

    /**
     * Method unmarshalEventInputs
     * 
     * 
     * 
     * @param reader
     * @return Object
     */
    public static java.lang.Object unmarshalEventInputs(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.netallied.functionblock.model.castor.EventInputs) Unmarshaller.unmarshal(de.netallied.functionblock.model.castor.EventInputs.class, reader);
    } //-- java.lang.Object unmarshalEventInputs(java.io.Reader) 

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
