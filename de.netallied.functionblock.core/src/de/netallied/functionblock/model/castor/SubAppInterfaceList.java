/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.6</a>, using an XML
 * Schema.
 * $Id: SubAppInterfaceList.java,v 1.3 2007/02/14 19:23:03 freegroup Exp $
 */

package de.netallied.functionblock.model.castor;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

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
 * Class SubAppInterfaceList.
 * 
 * @version $Revision: 1.3 $ $Date: 2007/02/14 19:23:03 $
 */
public class SubAppInterfaceList implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _subAppEventInputs
     */
    private de.netallied.functionblock.model.castor.SubAppEventInputs _subAppEventInputs;

    /**
     * Field _subAppEventOutputs
     */
    private de.netallied.functionblock.model.castor.SubAppEventOutputs _subAppEventOutputs;

    /**
     * Field _inputVars
     */
    private de.netallied.functionblock.model.castor.InputVars _inputVars;

    /**
     * Field _outputVars
     */
    private de.netallied.functionblock.model.castor.OutputVars _outputVars;


      //----------------/
     //- Constructors -/
    //----------------/

    public SubAppInterfaceList() {
        super();
    } //-- de.netallied.functionblock.model.castor.SubAppInterfaceList()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'inputVars'.
     * 
     * @return InputVars
     * @return the value of field 'inputVars'.
     */
    public de.netallied.functionblock.model.castor.InputVars getInputVars()
    {
        return this._inputVars;
    } //-- de.netallied.functionblock.model.castor.InputVars getInputVars() 

    /**
     * Returns the value of field 'outputVars'.
     * 
     * @return OutputVars
     * @return the value of field 'outputVars'.
     */
    public de.netallied.functionblock.model.castor.OutputVars getOutputVars()
    {
        return this._outputVars;
    } //-- de.netallied.functionblock.model.castor.OutputVars getOutputVars() 

    /**
     * Returns the value of field 'subAppEventInputs'.
     * 
     * @return SubAppEventInputs
     * @return the value of field 'subAppEventInputs'.
     */
    public de.netallied.functionblock.model.castor.SubAppEventInputs getSubAppEventInputs()
    {
        return this._subAppEventInputs;
    } //-- de.netallied.functionblock.model.castor.SubAppEventInputs getSubAppEventInputs() 

    /**
     * Returns the value of field 'subAppEventOutputs'.
     * 
     * @return SubAppEventOutputs
     * @return the value of field 'subAppEventOutputs'.
     */
    public de.netallied.functionblock.model.castor.SubAppEventOutputs getSubAppEventOutputs()
    {
        return this._subAppEventOutputs;
    } //-- de.netallied.functionblock.model.castor.SubAppEventOutputs getSubAppEventOutputs() 

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
     * Sets the value of field 'inputVars'.
     * 
     * @param inputVars the value of field 'inputVars'.
     */
    public void setInputVars(de.netallied.functionblock.model.castor.InputVars inputVars)
    {
        this._inputVars = inputVars;
    } //-- void setInputVars(de.netallied.functionblock.model.castor.InputVars) 

    /**
     * Sets the value of field 'outputVars'.
     * 
     * @param outputVars the value of field 'outputVars'.
     */
    public void setOutputVars(de.netallied.functionblock.model.castor.OutputVars outputVars)
    {
        this._outputVars = outputVars;
    } //-- void setOutputVars(de.netallied.functionblock.model.castor.OutputVars) 

    /**
     * Sets the value of field 'subAppEventInputs'.
     * 
     * @param subAppEventInputs the value of field
     * 'subAppEventInputs'.
     */
    public void setSubAppEventInputs(de.netallied.functionblock.model.castor.SubAppEventInputs subAppEventInputs)
    {
        this._subAppEventInputs = subAppEventInputs;
    } //-- void setSubAppEventInputs(de.netallied.functionblock.model.castor.SubAppEventInputs) 

    /**
     * Sets the value of field 'subAppEventOutputs'.
     * 
     * @param subAppEventOutputs the value of field
     * 'subAppEventOutputs'.
     */
    public void setSubAppEventOutputs(de.netallied.functionblock.model.castor.SubAppEventOutputs subAppEventOutputs)
    {
        this._subAppEventOutputs = subAppEventOutputs;
    } //-- void setSubAppEventOutputs(de.netallied.functionblock.model.castor.SubAppEventOutputs) 

    /**
     * Method unmarshalSubAppInterfaceList
     * 
     * 
     * 
     * @param reader
     * @return Object
     */
    public static java.lang.Object unmarshalSubAppInterfaceList(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.netallied.functionblock.model.castor.SubAppInterfaceList) Unmarshaller.unmarshal(de.netallied.functionblock.model.castor.SubAppInterfaceList.class, reader);
    } //-- java.lang.Object unmarshalSubAppInterfaceList(java.io.Reader) 

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
