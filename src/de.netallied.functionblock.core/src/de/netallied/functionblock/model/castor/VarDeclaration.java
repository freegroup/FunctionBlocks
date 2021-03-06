/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.6</a>, using an XML
 * Schema.
 * $Id: VarDeclaration.java,v 1.3 2007/02/14 19:23:03 freegroup Exp $
 */

package de.netallied.functionblock.model.castor;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import de.netallied.functionblock.model.castor.types.VarDeclarationTypeType;
import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.ContentHandler;

/**
 * Class VarDeclaration.
 * 
 * @version $Revision: 1.3 $ $Date: 2007/02/14 19:23:03 $
 */
public class VarDeclaration implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _name
     */
    private java.lang.String _name;

    /**
     * Field _type
     */
    private de.netallied.functionblock.model.castor.types.VarDeclarationTypeType _type;

    /**
     * Field _arraySize
     */
    private java.lang.String _arraySize;

    /**
     * Field _initialValue
     */
    private java.lang.String _initialValue;

    /**
     * Field _comment
     */
    private java.lang.String _comment;


      //----------------/
     //- Constructors -/
    //----------------/

    public VarDeclaration() {
        super();
    } //-- de.netallied.functionblock.model.castor.VarDeclaration()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'arraySize'.
     * 
     * @return String
     * @return the value of field 'arraySize'.
     */
    public java.lang.String getArraySize()
    {
        return this._arraySize;
    } //-- java.lang.String getArraySize() 

    /**
     * Returns the value of field 'comment'.
     * 
     * @return String
     * @return the value of field 'comment'.
     */
    public java.lang.String getComment()
    {
        return this._comment;
    } //-- java.lang.String getComment() 

    /**
     * Returns the value of field 'initialValue'.
     * 
     * @return String
     * @return the value of field 'initialValue'.
     */
    public java.lang.String getInitialValue()
    {
        return this._initialValue;
    } //-- java.lang.String getInitialValue() 

    /**
     * Returns the value of field 'name'.
     * 
     * @return String
     * @return the value of field 'name'.
     */
    public java.lang.String getName()
    {
        return this._name;
    } //-- java.lang.String getName() 

    /**
     * Returns the value of field 'type'.
     * 
     * @return VarDeclarationTypeType
     * @return the value of field 'type'.
     */
    public de.netallied.functionblock.model.castor.types.VarDeclarationTypeType getType()
    {
        return this._type;
    } //-- de.netallied.functionblock.model.castor.types.VarDeclarationTypeType getType() 

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
     * Sets the value of field 'arraySize'.
     * 
     * @param arraySize the value of field 'arraySize'.
     */
    public void setArraySize(java.lang.String arraySize)
    {
        this._arraySize = arraySize;
    } //-- void setArraySize(java.lang.String) 

    /**
     * Sets the value of field 'comment'.
     * 
     * @param comment the value of field 'comment'.
     */
    public void setComment(java.lang.String comment)
    {
        this._comment = comment;
    } //-- void setComment(java.lang.String) 

    /**
     * Sets the value of field 'initialValue'.
     * 
     * @param initialValue the value of field 'initialValue'.
     */
    public void setInitialValue(java.lang.String initialValue)
    {
        this._initialValue = initialValue;
    } //-- void setInitialValue(java.lang.String) 

    /**
     * Sets the value of field 'name'.
     * 
     * @param name the value of field 'name'.
     */
    public void setName(java.lang.String name)
    {
        this._name = name;
    } //-- void setName(java.lang.String) 

    /**
     * Sets the value of field 'type'.
     * 
     * @param type the value of field 'type'.
     */
    public void setType(de.netallied.functionblock.model.castor.types.VarDeclarationTypeType type)
    {
        this._type = type;
    } //-- void setType(de.netallied.functionblock.model.castor.types.VarDeclarationTypeType) 

    /**
     * Method unmarshalVarDeclaration
     * 
     * 
     * 
     * @param reader
     * @return Object
     */
    public static java.lang.Object unmarshalVarDeclaration(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.netallied.functionblock.model.castor.VarDeclaration) Unmarshaller.unmarshal(de.netallied.functionblock.model.castor.VarDeclaration.class, reader);
    } //-- java.lang.Object unmarshalVarDeclaration(java.io.Reader) 

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
