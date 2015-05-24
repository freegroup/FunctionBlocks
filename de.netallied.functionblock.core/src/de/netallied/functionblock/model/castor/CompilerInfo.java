/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.6</a>, using an XML
 * Schema.
 * $Id: CompilerInfo.java,v 1.3 2007/02/14 19:23:04 freegroup Exp $
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
 * Class CompilerInfo.
 * 
 * @version $Revision: 1.3 $ $Date: 2007/02/14 19:23:04 $
 */
public class CompilerInfo implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _header
     */
    private java.lang.String _header;

    /**
     * Field _classdef
     */
    private java.lang.String _classdef;

    /**
     * Field _compilerList
     */
    private java.util.Vector _compilerList;


      //----------------/
     //- Constructors -/
    //----------------/

    public CompilerInfo() {
        super();
        _compilerList = new Vector();
    } //-- de.netallied.functionblock.model.castor.CompilerInfo()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addCompiler
     * 
     * 
     * 
     * @param vCompiler
     */
    public void addCompiler(de.netallied.functionblock.model.castor.Compiler vCompiler)
        throws java.lang.IndexOutOfBoundsException
    {
        _compilerList.addElement(vCompiler);
    } //-- void addCompiler(de.netallied.functionblock.model.castor.Compiler) 

    /**
     * Method addCompiler
     * 
     * 
     * 
     * @param index
     * @param vCompiler
     */
    public void addCompiler(int index, de.netallied.functionblock.model.castor.Compiler vCompiler)
        throws java.lang.IndexOutOfBoundsException
    {
        _compilerList.insertElementAt(vCompiler, index);
    } //-- void addCompiler(int, de.netallied.functionblock.model.castor.Compiler) 

    /**
     * Method enumerateCompiler
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateCompiler()
    {
        return _compilerList.elements();
    } //-- java.util.Enumeration enumerateCompiler() 

    /**
     * Returns the value of field 'classdef'.
     * 
     * @return String
     * @return the value of field 'classdef'.
     */
    public java.lang.String getClassdef()
    {
        return this._classdef;
    } //-- java.lang.String getClassdef() 

    /**
     * Method getCompiler
     * 
     * 
     * 
     * @param index
     * @return Compiler
     */
    public de.netallied.functionblock.model.castor.Compiler getCompiler(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _compilerList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (de.netallied.functionblock.model.castor.Compiler) _compilerList.elementAt(index);
    } //-- de.netallied.functionblock.model.castor.Compiler getCompiler(int) 

    /**
     * Method getCompiler
     * 
     * 
     * 
     * @return Compiler
     */
    public de.netallied.functionblock.model.castor.Compiler[] getCompiler()
    {
        int size = _compilerList.size();
        de.netallied.functionblock.model.castor.Compiler[] mArray = new de.netallied.functionblock.model.castor.Compiler[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (de.netallied.functionblock.model.castor.Compiler) _compilerList.elementAt(index);
        }
        return mArray;
    } //-- de.netallied.functionblock.model.castor.Compiler[] getCompiler() 

    /**
     * Method getCompilerCount
     * 
     * 
     * 
     * @return int
     */
    public int getCompilerCount()
    {
        return _compilerList.size();
    } //-- int getCompilerCount() 

    /**
     * Returns the value of field 'header'.
     * 
     * @return String
     * @return the value of field 'header'.
     */
    public java.lang.String getHeader()
    {
        return this._header;
    } //-- java.lang.String getHeader() 

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
     * Method removeAllCompiler
     * 
     */
    public void removeAllCompiler()
    {
        _compilerList.removeAllElements();
    } //-- void removeAllCompiler() 

    /**
     * Method removeCompiler
     * 
     * 
     * 
     * @param index
     * @return Compiler
     */
    public de.netallied.functionblock.model.castor.Compiler removeCompiler(int index)
    {
        java.lang.Object obj = _compilerList.elementAt(index);
        _compilerList.removeElementAt(index);
        return (de.netallied.functionblock.model.castor.Compiler) obj;
    } //-- de.netallied.functionblock.model.castor.Compiler removeCompiler(int) 

    /**
     * Sets the value of field 'classdef'.
     * 
     * @param classdef the value of field 'classdef'.
     */
    public void setClassdef(java.lang.String classdef)
    {
        this._classdef = classdef;
    } //-- void setClassdef(java.lang.String) 

    /**
     * Method setCompiler
     * 
     * 
     * 
     * @param index
     * @param vCompiler
     */
    public void setCompiler(int index, de.netallied.functionblock.model.castor.Compiler vCompiler)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _compilerList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _compilerList.setElementAt(vCompiler, index);
    } //-- void setCompiler(int, de.netallied.functionblock.model.castor.Compiler) 

    /**
     * Method setCompiler
     * 
     * 
     * 
     * @param compilerArray
     */
    public void setCompiler(de.netallied.functionblock.model.castor.Compiler[] compilerArray)
    {
        //-- copy array
        _compilerList.removeAllElements();
        for (int i = 0; i < compilerArray.length; i++) {
            _compilerList.addElement(compilerArray[i]);
        }
    } //-- void setCompiler(de.netallied.functionblock.model.castor.Compiler) 

    /**
     * Sets the value of field 'header'.
     * 
     * @param header the value of field 'header'.
     */
    public void setHeader(java.lang.String header)
    {
        this._header = header;
    } //-- void setHeader(java.lang.String) 

    /**
     * Method unmarshalCompilerInfo
     * 
     * 
     * 
     * @param reader
     * @return Object
     */
    public static java.lang.Object unmarshalCompilerInfo(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.netallied.functionblock.model.castor.CompilerInfo) Unmarshaller.unmarshal(de.netallied.functionblock.model.castor.CompilerInfo.class, reader);
    } //-- java.lang.Object unmarshalCompilerInfo(java.io.Reader) 

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
