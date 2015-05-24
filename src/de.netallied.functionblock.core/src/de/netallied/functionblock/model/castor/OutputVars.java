/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.6</a>, using an XML
 * Schema.
 * $Id: OutputVars.java,v 1.3 2007/02/14 19:23:04 freegroup Exp $
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
 * Class OutputVars.
 * 
 * @version $Revision: 1.3 $ $Date: 2007/02/14 19:23:04 $
 */
public class OutputVars implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _varDeclarationList
     */
    private java.util.Vector _varDeclarationList;


      //----------------/
     //- Constructors -/
    //----------------/

    public OutputVars() {
        super();
        _varDeclarationList = new Vector();
    } //-- de.netallied.functionblock.model.castor.OutputVars()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addVarDeclaration
     * 
     * 
     * 
     * @param vVarDeclaration
     */
    public void addVarDeclaration(de.netallied.functionblock.model.castor.VarDeclaration vVarDeclaration)
        throws java.lang.IndexOutOfBoundsException
    {
        _varDeclarationList.addElement(vVarDeclaration);
    } //-- void addVarDeclaration(de.netallied.functionblock.model.castor.VarDeclaration) 

    /**
     * Method addVarDeclaration
     * 
     * 
     * 
     * @param index
     * @param vVarDeclaration
     */
    public void addVarDeclaration(int index, de.netallied.functionblock.model.castor.VarDeclaration vVarDeclaration)
        throws java.lang.IndexOutOfBoundsException
    {
        _varDeclarationList.insertElementAt(vVarDeclaration, index);
    } //-- void addVarDeclaration(int, de.netallied.functionblock.model.castor.VarDeclaration) 

    /**
     * Method enumerateVarDeclaration
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateVarDeclaration()
    {
        return _varDeclarationList.elements();
    } //-- java.util.Enumeration enumerateVarDeclaration() 

    /**
     * Method getVarDeclaration
     * 
     * 
     * 
     * @param index
     * @return VarDeclaration
     */
    public de.netallied.functionblock.model.castor.VarDeclaration getVarDeclaration(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _varDeclarationList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (de.netallied.functionblock.model.castor.VarDeclaration) _varDeclarationList.elementAt(index);
    } //-- de.netallied.functionblock.model.castor.VarDeclaration getVarDeclaration(int) 

    /**
     * Method getVarDeclaration
     * 
     * 
     * 
     * @return VarDeclaration
     */
    public de.netallied.functionblock.model.castor.VarDeclaration[] getVarDeclaration()
    {
        int size = _varDeclarationList.size();
        de.netallied.functionblock.model.castor.VarDeclaration[] mArray = new de.netallied.functionblock.model.castor.VarDeclaration[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (de.netallied.functionblock.model.castor.VarDeclaration) _varDeclarationList.elementAt(index);
        }
        return mArray;
    } //-- de.netallied.functionblock.model.castor.VarDeclaration[] getVarDeclaration() 

    /**
     * Method getVarDeclarationCount
     * 
     * 
     * 
     * @return int
     */
    public int getVarDeclarationCount()
    {
        return _varDeclarationList.size();
    } //-- int getVarDeclarationCount() 

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
     * Method removeAllVarDeclaration
     * 
     */
    public void removeAllVarDeclaration()
    {
        _varDeclarationList.removeAllElements();
    } //-- void removeAllVarDeclaration() 

    /**
     * Method removeVarDeclaration
     * 
     * 
     * 
     * @param index
     * @return VarDeclaration
     */
    public de.netallied.functionblock.model.castor.VarDeclaration removeVarDeclaration(int index)
    {
        java.lang.Object obj = _varDeclarationList.elementAt(index);
        _varDeclarationList.removeElementAt(index);
        return (de.netallied.functionblock.model.castor.VarDeclaration) obj;
    } //-- de.netallied.functionblock.model.castor.VarDeclaration removeVarDeclaration(int) 

    /**
     * Method setVarDeclaration
     * 
     * 
     * 
     * @param index
     * @param vVarDeclaration
     */
    public void setVarDeclaration(int index, de.netallied.functionblock.model.castor.VarDeclaration vVarDeclaration)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _varDeclarationList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _varDeclarationList.setElementAt(vVarDeclaration, index);
    } //-- void setVarDeclaration(int, de.netallied.functionblock.model.castor.VarDeclaration) 

    /**
     * Method setVarDeclaration
     * 
     * 
     * 
     * @param varDeclarationArray
     */
    public void setVarDeclaration(de.netallied.functionblock.model.castor.VarDeclaration[] varDeclarationArray)
    {
        //-- copy array
        _varDeclarationList.removeAllElements();
        for (int i = 0; i < varDeclarationArray.length; i++) {
            _varDeclarationList.addElement(varDeclarationArray[i]);
        }
    } //-- void setVarDeclaration(de.netallied.functionblock.model.castor.VarDeclaration) 

    /**
     * Method unmarshalOutputVars
     * 
     * 
     * 
     * @param reader
     * @return Object
     */
    public static java.lang.Object unmarshalOutputVars(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.netallied.functionblock.model.castor.OutputVars) Unmarshaller.unmarshal(de.netallied.functionblock.model.castor.OutputVars.class, reader);
    } //-- java.lang.Object unmarshalOutputVars(java.io.Reader) 

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
