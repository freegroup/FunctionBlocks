/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.6</a>, using an XML
 * Schema.
 * $Id: ServiceTransaction.java,v 1.3 2007/02/14 19:23:03 freegroup Exp $
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
 * Class ServiceTransaction.
 * 
 * @version $Revision: 1.3 $ $Date: 2007/02/14 19:23:03 $
 */
public class ServiceTransaction implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _inputPrimitive
     */
    private de.netallied.functionblock.model.castor.InputPrimitive _inputPrimitive;

    /**
     * Field _outputPrimitiveList
     */
    private java.util.Vector _outputPrimitiveList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ServiceTransaction() {
        super();
        _outputPrimitiveList = new Vector();
    } //-- de.netallied.functionblock.model.castor.ServiceTransaction()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addOutputPrimitive
     * 
     * 
     * 
     * @param vOutputPrimitive
     */
    public void addOutputPrimitive(de.netallied.functionblock.model.castor.OutputPrimitive vOutputPrimitive)
        throws java.lang.IndexOutOfBoundsException
    {
        _outputPrimitiveList.addElement(vOutputPrimitive);
    } //-- void addOutputPrimitive(de.netallied.functionblock.model.castor.OutputPrimitive) 

    /**
     * Method addOutputPrimitive
     * 
     * 
     * 
     * @param index
     * @param vOutputPrimitive
     */
    public void addOutputPrimitive(int index, de.netallied.functionblock.model.castor.OutputPrimitive vOutputPrimitive)
        throws java.lang.IndexOutOfBoundsException
    {
        _outputPrimitiveList.insertElementAt(vOutputPrimitive, index);
    } //-- void addOutputPrimitive(int, de.netallied.functionblock.model.castor.OutputPrimitive) 

    /**
     * Method enumerateOutputPrimitive
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateOutputPrimitive()
    {
        return _outputPrimitiveList.elements();
    } //-- java.util.Enumeration enumerateOutputPrimitive() 

    /**
     * Returns the value of field 'inputPrimitive'.
     * 
     * @return InputPrimitive
     * @return the value of field 'inputPrimitive'.
     */
    public de.netallied.functionblock.model.castor.InputPrimitive getInputPrimitive()
    {
        return this._inputPrimitive;
    } //-- de.netallied.functionblock.model.castor.InputPrimitive getInputPrimitive() 

    /**
     * Method getOutputPrimitive
     * 
     * 
     * 
     * @param index
     * @return OutputPrimitive
     */
    public de.netallied.functionblock.model.castor.OutputPrimitive getOutputPrimitive(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _outputPrimitiveList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (de.netallied.functionblock.model.castor.OutputPrimitive) _outputPrimitiveList.elementAt(index);
    } //-- de.netallied.functionblock.model.castor.OutputPrimitive getOutputPrimitive(int) 

    /**
     * Method getOutputPrimitive
     * 
     * 
     * 
     * @return OutputPrimitive
     */
    public de.netallied.functionblock.model.castor.OutputPrimitive[] getOutputPrimitive()
    {
        int size = _outputPrimitiveList.size();
        de.netallied.functionblock.model.castor.OutputPrimitive[] mArray = new de.netallied.functionblock.model.castor.OutputPrimitive[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (de.netallied.functionblock.model.castor.OutputPrimitive) _outputPrimitiveList.elementAt(index);
        }
        return mArray;
    } //-- de.netallied.functionblock.model.castor.OutputPrimitive[] getOutputPrimitive() 

    /**
     * Method getOutputPrimitiveCount
     * 
     * 
     * 
     * @return int
     */
    public int getOutputPrimitiveCount()
    {
        return _outputPrimitiveList.size();
    } //-- int getOutputPrimitiveCount() 

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
     * Method removeAllOutputPrimitive
     * 
     */
    public void removeAllOutputPrimitive()
    {
        _outputPrimitiveList.removeAllElements();
    } //-- void removeAllOutputPrimitive() 

    /**
     * Method removeOutputPrimitive
     * 
     * 
     * 
     * @param index
     * @return OutputPrimitive
     */
    public de.netallied.functionblock.model.castor.OutputPrimitive removeOutputPrimitive(int index)
    {
        java.lang.Object obj = _outputPrimitiveList.elementAt(index);
        _outputPrimitiveList.removeElementAt(index);
        return (de.netallied.functionblock.model.castor.OutputPrimitive) obj;
    } //-- de.netallied.functionblock.model.castor.OutputPrimitive removeOutputPrimitive(int) 

    /**
     * Sets the value of field 'inputPrimitive'.
     * 
     * @param inputPrimitive the value of field 'inputPrimitive'.
     */
    public void setInputPrimitive(de.netallied.functionblock.model.castor.InputPrimitive inputPrimitive)
    {
        this._inputPrimitive = inputPrimitive;
    } //-- void setInputPrimitive(de.netallied.functionblock.model.castor.InputPrimitive) 

    /**
     * Method setOutputPrimitive
     * 
     * 
     * 
     * @param index
     * @param vOutputPrimitive
     */
    public void setOutputPrimitive(int index, de.netallied.functionblock.model.castor.OutputPrimitive vOutputPrimitive)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _outputPrimitiveList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _outputPrimitiveList.setElementAt(vOutputPrimitive, index);
    } //-- void setOutputPrimitive(int, de.netallied.functionblock.model.castor.OutputPrimitive) 

    /**
     * Method setOutputPrimitive
     * 
     * 
     * 
     * @param outputPrimitiveArray
     */
    public void setOutputPrimitive(de.netallied.functionblock.model.castor.OutputPrimitive[] outputPrimitiveArray)
    {
        //-- copy array
        _outputPrimitiveList.removeAllElements();
        for (int i = 0; i < outputPrimitiveArray.length; i++) {
            _outputPrimitiveList.addElement(outputPrimitiveArray[i]);
        }
    } //-- void setOutputPrimitive(de.netallied.functionblock.model.castor.OutputPrimitive) 

    /**
     * Method unmarshalServiceTransaction
     * 
     * 
     * 
     * @param reader
     * @return Object
     */
    public static java.lang.Object unmarshalServiceTransaction(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.netallied.functionblock.model.castor.ServiceTransaction) Unmarshaller.unmarshal(de.netallied.functionblock.model.castor.ServiceTransaction.class, reader);
    } //-- java.lang.Object unmarshalServiceTransaction(java.io.Reader) 

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
