/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.6</a>, using an XML
 * Schema.
 * $Id: BasicFB.java,v 1.3 2007/02/14 19:23:03 freegroup Exp $
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
 * Class BasicFB.
 * 
 * @version $Revision: 1.3 $ $Date: 2007/02/14 19:23:03 $
 */
public class BasicFB implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _internalVars
     */
    private de.netallied.functionblock.model.castor.InternalVars _internalVars;

    /**
     * Field _ECC
     */
    private de.netallied.functionblock.model.castor.ECC _ECC;

    /**
     * Field _algorithmList
     */
    private java.util.Vector _algorithmList;


      //----------------/
     //- Constructors -/
    //----------------/

    public BasicFB() {
        super();
        _algorithmList = new Vector();
    } //-- de.netallied.functionblock.model.castor.BasicFB()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addAlgorithm
     * 
     * 
     * 
     * @param vAlgorithm
     */
    public void addAlgorithm(de.netallied.functionblock.model.castor.Algorithm vAlgorithm)
        throws java.lang.IndexOutOfBoundsException
    {
        _algorithmList.addElement(vAlgorithm);
    } //-- void addAlgorithm(de.netallied.functionblock.model.castor.Algorithm) 

    /**
     * Method addAlgorithm
     * 
     * 
     * 
     * @param index
     * @param vAlgorithm
     */
    public void addAlgorithm(int index, de.netallied.functionblock.model.castor.Algorithm vAlgorithm)
        throws java.lang.IndexOutOfBoundsException
    {
        _algorithmList.insertElementAt(vAlgorithm, index);
    } //-- void addAlgorithm(int, de.netallied.functionblock.model.castor.Algorithm) 

    /**
     * Method enumerateAlgorithm
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateAlgorithm()
    {
        return _algorithmList.elements();
    } //-- java.util.Enumeration enumerateAlgorithm() 

    /**
     * Method getAlgorithm
     * 
     * 
     * 
     * @param index
     * @return Algorithm
     */
    public de.netallied.functionblock.model.castor.Algorithm getAlgorithm(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _algorithmList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (de.netallied.functionblock.model.castor.Algorithm) _algorithmList.elementAt(index);
    } //-- de.netallied.functionblock.model.castor.Algorithm getAlgorithm(int) 

    /**
     * Method getAlgorithm
     * 
     * 
     * 
     * @return Algorithm
     */
    public de.netallied.functionblock.model.castor.Algorithm[] getAlgorithm()
    {
        int size = _algorithmList.size();
        de.netallied.functionblock.model.castor.Algorithm[] mArray = new de.netallied.functionblock.model.castor.Algorithm[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (de.netallied.functionblock.model.castor.Algorithm) _algorithmList.elementAt(index);
        }
        return mArray;
    } //-- de.netallied.functionblock.model.castor.Algorithm[] getAlgorithm() 

    /**
     * Method getAlgorithmCount
     * 
     * 
     * 
     * @return int
     */
    public int getAlgorithmCount()
    {
        return _algorithmList.size();
    } //-- int getAlgorithmCount() 

    /**
     * Returns the value of field 'ECC'.
     * 
     * @return ECC
     * @return the value of field 'ECC'.
     */
    public de.netallied.functionblock.model.castor.ECC getECC()
    {
        return this._ECC;
    } //-- de.netallied.functionblock.model.castor.ECC getECC() 

    /**
     * Returns the value of field 'internalVars'.
     * 
     * @return InternalVars
     * @return the value of field 'internalVars'.
     */
    public de.netallied.functionblock.model.castor.InternalVars getInternalVars()
    {
        return this._internalVars;
    } //-- de.netallied.functionblock.model.castor.InternalVars getInternalVars() 

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
     * Method removeAlgorithm
     * 
     * 
     * 
     * @param index
     * @return Algorithm
     */
    public de.netallied.functionblock.model.castor.Algorithm removeAlgorithm(int index)
    {
        java.lang.Object obj = _algorithmList.elementAt(index);
        _algorithmList.removeElementAt(index);
        return (de.netallied.functionblock.model.castor.Algorithm) obj;
    } //-- de.netallied.functionblock.model.castor.Algorithm removeAlgorithm(int) 

    /**
     * Method removeAllAlgorithm
     * 
     */
    public void removeAllAlgorithm()
    {
        _algorithmList.removeAllElements();
    } //-- void removeAllAlgorithm() 

    /**
     * Method setAlgorithm
     * 
     * 
     * 
     * @param index
     * @param vAlgorithm
     */
    public void setAlgorithm(int index, de.netallied.functionblock.model.castor.Algorithm vAlgorithm)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _algorithmList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _algorithmList.setElementAt(vAlgorithm, index);
    } //-- void setAlgorithm(int, de.netallied.functionblock.model.castor.Algorithm) 

    /**
     * Method setAlgorithm
     * 
     * 
     * 
     * @param algorithmArray
     */
    public void setAlgorithm(de.netallied.functionblock.model.castor.Algorithm[] algorithmArray)
    {
        //-- copy array
        _algorithmList.removeAllElements();
        for (int i = 0; i < algorithmArray.length; i++) {
            _algorithmList.addElement(algorithmArray[i]);
        }
    } //-- void setAlgorithm(de.netallied.functionblock.model.castor.Algorithm) 

    /**
     * Sets the value of field 'ECC'.
     * 
     * @param ECC the value of field 'ECC'.
     */
    public void setECC(de.netallied.functionblock.model.castor.ECC ECC)
    {
        this._ECC = ECC;
    } //-- void setECC(de.netallied.functionblock.model.castor.ECC) 

    /**
     * Sets the value of field 'internalVars'.
     * 
     * @param internalVars the value of field 'internalVars'.
     */
    public void setInternalVars(de.netallied.functionblock.model.castor.InternalVars internalVars)
    {
        this._internalVars = internalVars;
    } //-- void setInternalVars(de.netallied.functionblock.model.castor.InternalVars) 

    /**
     * Method unmarshalBasicFB
     * 
     * 
     * 
     * @param reader
     * @return Object
     */
    public static java.lang.Object unmarshalBasicFB(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.netallied.functionblock.model.castor.BasicFB) Unmarshaller.unmarshal(de.netallied.functionblock.model.castor.BasicFB.class, reader);
    } //-- java.lang.Object unmarshalBasicFB(java.io.Reader) 

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
