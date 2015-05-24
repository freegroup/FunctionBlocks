/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.6</a>, using an XML
 * Schema.
 * $Id: ECC.java,v 1.3 2007/02/14 19:23:03 freegroup Exp $
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
 * Class ECC.
 * 
 * @version $Revision: 1.3 $ $Date: 2007/02/14 19:23:03 $
 */
public class ECC implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ECStateList
     */
    private java.util.Vector _ECStateList;

    /**
     * Field _ECTransitionList
     */
    private java.util.Vector _ECTransitionList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ECC() {
        super();
        _ECStateList = new Vector();
        _ECTransitionList = new Vector();
    } //-- de.netallied.functionblock.model.castor.ECC()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addECState
     * 
     * 
     * 
     * @param vECState
     */
    public void addECState(de.netallied.functionblock.model.castor.ECState vECState)
        throws java.lang.IndexOutOfBoundsException
    {
        _ECStateList.addElement(vECState);
    } //-- void addECState(de.netallied.functionblock.model.castor.ECState) 

    /**
     * Method addECState
     * 
     * 
     * 
     * @param index
     * @param vECState
     */
    public void addECState(int index, de.netallied.functionblock.model.castor.ECState vECState)
        throws java.lang.IndexOutOfBoundsException
    {
        _ECStateList.insertElementAt(vECState, index);
    } //-- void addECState(int, de.netallied.functionblock.model.castor.ECState) 

    /**
     * Method addECTransition
     * 
     * 
     * 
     * @param vECTransition
     */
    public void addECTransition(de.netallied.functionblock.model.castor.ECTransition vECTransition)
        throws java.lang.IndexOutOfBoundsException
    {
        _ECTransitionList.addElement(vECTransition);
    } //-- void addECTransition(de.netallied.functionblock.model.castor.ECTransition) 

    /**
     * Method addECTransition
     * 
     * 
     * 
     * @param index
     * @param vECTransition
     */
    public void addECTransition(int index, de.netallied.functionblock.model.castor.ECTransition vECTransition)
        throws java.lang.IndexOutOfBoundsException
    {
        _ECTransitionList.insertElementAt(vECTransition, index);
    } //-- void addECTransition(int, de.netallied.functionblock.model.castor.ECTransition) 

    /**
     * Method enumerateECState
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateECState()
    {
        return _ECStateList.elements();
    } //-- java.util.Enumeration enumerateECState() 

    /**
     * Method enumerateECTransition
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateECTransition()
    {
        return _ECTransitionList.elements();
    } //-- java.util.Enumeration enumerateECTransition() 

    /**
     * Method getECState
     * 
     * 
     * 
     * @param index
     * @return ECState
     */
    public de.netallied.functionblock.model.castor.ECState getECState(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _ECStateList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (de.netallied.functionblock.model.castor.ECState) _ECStateList.elementAt(index);
    } //-- de.netallied.functionblock.model.castor.ECState getECState(int) 

    /**
     * Method getECState
     * 
     * 
     * 
     * @return ECState
     */
    public de.netallied.functionblock.model.castor.ECState[] getECState()
    {
        int size = _ECStateList.size();
        de.netallied.functionblock.model.castor.ECState[] mArray = new de.netallied.functionblock.model.castor.ECState[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (de.netallied.functionblock.model.castor.ECState) _ECStateList.elementAt(index);
        }
        return mArray;
    } //-- de.netallied.functionblock.model.castor.ECState[] getECState() 

    /**
     * Method getECStateCount
     * 
     * 
     * 
     * @return int
     */
    public int getECStateCount()
    {
        return _ECStateList.size();
    } //-- int getECStateCount() 

    /**
     * Method getECTransition
     * 
     * 
     * 
     * @param index
     * @return ECTransition
     */
    public de.netallied.functionblock.model.castor.ECTransition getECTransition(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _ECTransitionList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (de.netallied.functionblock.model.castor.ECTransition) _ECTransitionList.elementAt(index);
    } //-- de.netallied.functionblock.model.castor.ECTransition getECTransition(int) 

    /**
     * Method getECTransition
     * 
     * 
     * 
     * @return ECTransition
     */
    public de.netallied.functionblock.model.castor.ECTransition[] getECTransition()
    {
        int size = _ECTransitionList.size();
        de.netallied.functionblock.model.castor.ECTransition[] mArray = new de.netallied.functionblock.model.castor.ECTransition[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (de.netallied.functionblock.model.castor.ECTransition) _ECTransitionList.elementAt(index);
        }
        return mArray;
    } //-- de.netallied.functionblock.model.castor.ECTransition[] getECTransition() 

    /**
     * Method getECTransitionCount
     * 
     * 
     * 
     * @return int
     */
    public int getECTransitionCount()
    {
        return _ECTransitionList.size();
    } //-- int getECTransitionCount() 

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
     * Method removeAllECState
     * 
     */
    public void removeAllECState()
    {
        _ECStateList.removeAllElements();
    } //-- void removeAllECState() 

    /**
     * Method removeAllECTransition
     * 
     */
    public void removeAllECTransition()
    {
        _ECTransitionList.removeAllElements();
    } //-- void removeAllECTransition() 

    /**
     * Method removeECState
     * 
     * 
     * 
     * @param index
     * @return ECState
     */
    public de.netallied.functionblock.model.castor.ECState removeECState(int index)
    {
        java.lang.Object obj = _ECStateList.elementAt(index);
        _ECStateList.removeElementAt(index);
        return (de.netallied.functionblock.model.castor.ECState) obj;
    } //-- de.netallied.functionblock.model.castor.ECState removeECState(int) 

    /**
     * Method removeECTransition
     * 
     * 
     * 
     * @param index
     * @return ECTransition
     */
    public de.netallied.functionblock.model.castor.ECTransition removeECTransition(int index)
    {
        java.lang.Object obj = _ECTransitionList.elementAt(index);
        _ECTransitionList.removeElementAt(index);
        return (de.netallied.functionblock.model.castor.ECTransition) obj;
    } //-- de.netallied.functionblock.model.castor.ECTransition removeECTransition(int) 

    /**
     * Method setECState
     * 
     * 
     * 
     * @param index
     * @param vECState
     */
    public void setECState(int index, de.netallied.functionblock.model.castor.ECState vECState)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _ECStateList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _ECStateList.setElementAt(vECState, index);
    } //-- void setECState(int, de.netallied.functionblock.model.castor.ECState) 

    /**
     * Method setECState
     * 
     * 
     * 
     * @param ECStateArray
     */
    public void setECState(de.netallied.functionblock.model.castor.ECState[] ECStateArray)
    {
        //-- copy array
        _ECStateList.removeAllElements();
        for (int i = 0; i < ECStateArray.length; i++) {
            _ECStateList.addElement(ECStateArray[i]);
        }
    } //-- void setECState(de.netallied.functionblock.model.castor.ECState) 

    /**
     * Method setECTransition
     * 
     * 
     * 
     * @param index
     * @param vECTransition
     */
    public void setECTransition(int index, de.netallied.functionblock.model.castor.ECTransition vECTransition)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _ECTransitionList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _ECTransitionList.setElementAt(vECTransition, index);
    } //-- void setECTransition(int, de.netallied.functionblock.model.castor.ECTransition) 

    /**
     * Method setECTransition
     * 
     * 
     * 
     * @param ECTransitionArray
     */
    public void setECTransition(de.netallied.functionblock.model.castor.ECTransition[] ECTransitionArray)
    {
        //-- copy array
        _ECTransitionList.removeAllElements();
        for (int i = 0; i < ECTransitionArray.length; i++) {
            _ECTransitionList.addElement(ECTransitionArray[i]);
        }
    } //-- void setECTransition(de.netallied.functionblock.model.castor.ECTransition) 

    /**
     * Method unmarshalECC
     * 
     * 
     * 
     * @param reader
     * @return Object
     */
    public static java.lang.Object unmarshalECC(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.netallied.functionblock.model.castor.ECC) Unmarshaller.unmarshal(de.netallied.functionblock.model.castor.ECC.class, reader);
    } //-- java.lang.Object unmarshalECC(java.io.Reader) 

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
