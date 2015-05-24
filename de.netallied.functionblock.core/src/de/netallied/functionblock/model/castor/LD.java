/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.6</a>, using an XML
 * Schema.
 * $Id: LD.java,v 1.3 2007/02/14 19:23:08 freegroup Exp $
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
 * Class LD.
 * 
 * @version $Revision: 1.3 $ $Date: 2007/02/14 19:23:08 $
 */
public class LD implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _rungList
     */
    private java.util.Vector _rungList;


      //----------------/
     //- Constructors -/
    //----------------/

    public LD() {
        super();
        _rungList = new Vector();
    } //-- de.netallied.functionblock.model.castor.LD()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addRung
     * 
     * 
     * 
     * @param vRung
     */
    public void addRung(de.netallied.functionblock.model.castor.Rung vRung)
        throws java.lang.IndexOutOfBoundsException
    {
        _rungList.addElement(vRung);
    } //-- void addRung(de.netallied.functionblock.model.castor.Rung) 

    /**
     * Method addRung
     * 
     * 
     * 
     * @param index
     * @param vRung
     */
    public void addRung(int index, de.netallied.functionblock.model.castor.Rung vRung)
        throws java.lang.IndexOutOfBoundsException
    {
        _rungList.insertElementAt(vRung, index);
    } //-- void addRung(int, de.netallied.functionblock.model.castor.Rung) 

    /**
     * Method enumerateRung
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateRung()
    {
        return _rungList.elements();
    } //-- java.util.Enumeration enumerateRung() 

    /**
     * Method getRung
     * 
     * 
     * 
     * @param index
     * @return Rung
     */
    public de.netallied.functionblock.model.castor.Rung getRung(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _rungList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (de.netallied.functionblock.model.castor.Rung) _rungList.elementAt(index);
    } //-- de.netallied.functionblock.model.castor.Rung getRung(int) 

    /**
     * Method getRung
     * 
     * 
     * 
     * @return Rung
     */
    public de.netallied.functionblock.model.castor.Rung[] getRung()
    {
        int size = _rungList.size();
        de.netallied.functionblock.model.castor.Rung[] mArray = new de.netallied.functionblock.model.castor.Rung[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (de.netallied.functionblock.model.castor.Rung) _rungList.elementAt(index);
        }
        return mArray;
    } //-- de.netallied.functionblock.model.castor.Rung[] getRung() 

    /**
     * Method getRungCount
     * 
     * 
     * 
     * @return int
     */
    public int getRungCount()
    {
        return _rungList.size();
    } //-- int getRungCount() 

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
     * Method removeAllRung
     * 
     */
    public void removeAllRung()
    {
        _rungList.removeAllElements();
    } //-- void removeAllRung() 

    /**
     * Method removeRung
     * 
     * 
     * 
     * @param index
     * @return Rung
     */
    public de.netallied.functionblock.model.castor.Rung removeRung(int index)
    {
        java.lang.Object obj = _rungList.elementAt(index);
        _rungList.removeElementAt(index);
        return (de.netallied.functionblock.model.castor.Rung) obj;
    } //-- de.netallied.functionblock.model.castor.Rung removeRung(int) 

    /**
     * Method setRung
     * 
     * 
     * 
     * @param index
     * @param vRung
     */
    public void setRung(int index, de.netallied.functionblock.model.castor.Rung vRung)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _rungList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _rungList.setElementAt(vRung, index);
    } //-- void setRung(int, de.netallied.functionblock.model.castor.Rung) 

    /**
     * Method setRung
     * 
     * 
     * 
     * @param rungArray
     */
    public void setRung(de.netallied.functionblock.model.castor.Rung[] rungArray)
    {
        //-- copy array
        _rungList.removeAllElements();
        for (int i = 0; i < rungArray.length; i++) {
            _rungList.addElement(rungArray[i]);
        }
    } //-- void setRung(de.netallied.functionblock.model.castor.Rung) 

    /**
     * Method unmarshalLD
     * 
     * 
     * 
     * @param reader
     * @return Object
     */
    public static java.lang.Object unmarshalLD(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.netallied.functionblock.model.castor.LD) Unmarshaller.unmarshal(de.netallied.functionblock.model.castor.LD.class, reader);
    } //-- java.lang.Object unmarshalLD(java.io.Reader) 

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
