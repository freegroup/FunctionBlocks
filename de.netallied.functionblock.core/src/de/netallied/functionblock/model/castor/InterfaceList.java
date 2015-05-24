/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.6</a>, using an XML
 * Schema.
 * $Id: InterfaceList.java,v 1.3 2007/02/14 19:23:01 freegroup Exp $
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
 * Class InterfaceList.
 * 
 * @version $Revision: 1.3 $ $Date: 2007/02/14 19:23:01 $
 */
public class InterfaceList implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _eventInputs
     */
    private de.netallied.functionblock.model.castor.EventInputs _eventInputs;

    /**
     * Field _eventOutputs
     */
    private de.netallied.functionblock.model.castor.EventOutputs _eventOutputs;

    /**
     * Field _inputVars
     */
    private de.netallied.functionblock.model.castor.InputVars _inputVars;

    /**
     * Field _outputVars
     */
    private de.netallied.functionblock.model.castor.OutputVars _outputVars;

    /**
     * Field _sockets
     */
    private de.netallied.functionblock.model.castor.Sockets _sockets;

    /**
     * Field _plugs
     */
    private de.netallied.functionblock.model.castor.Plugs _plugs;


      //----------------/
     //- Constructors -/
    //----------------/

    public InterfaceList() {
        super();
    } //-- de.netallied.functionblock.model.castor.InterfaceList()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'eventInputs'.
     * 
     * @return EventInputs
     * @return the value of field 'eventInputs'.
     */
    public de.netallied.functionblock.model.castor.EventInputs getEventInputs()
    {
        return this._eventInputs;
    } //-- de.netallied.functionblock.model.castor.EventInputs getEventInputs() 

    /**
     * Returns the value of field 'eventOutputs'.
     * 
     * @return EventOutputs
     * @return the value of field 'eventOutputs'.
     */
    public de.netallied.functionblock.model.castor.EventOutputs getEventOutputs()
    {
        return this._eventOutputs;
    } //-- de.netallied.functionblock.model.castor.EventOutputs getEventOutputs() 

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
     * Returns the value of field 'plugs'.
     * 
     * @return Plugs
     * @return the value of field 'plugs'.
     */
    public de.netallied.functionblock.model.castor.Plugs getPlugs()
    {
        return this._plugs;
    } //-- de.netallied.functionblock.model.castor.Plugs getPlugs() 

    /**
     * Returns the value of field 'sockets'.
     * 
     * @return Sockets
     * @return the value of field 'sockets'.
     */
    public de.netallied.functionblock.model.castor.Sockets getSockets()
    {
        return this._sockets;
    } //-- de.netallied.functionblock.model.castor.Sockets getSockets() 

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
     * Sets the value of field 'eventInputs'.
     * 
     * @param eventInputs the value of field 'eventInputs'.
     */
    public void setEventInputs(de.netallied.functionblock.model.castor.EventInputs eventInputs)
    {
        this._eventInputs = eventInputs;
    } //-- void setEventInputs(de.netallied.functionblock.model.castor.EventInputs) 

    /**
     * Sets the value of field 'eventOutputs'.
     * 
     * @param eventOutputs the value of field 'eventOutputs'.
     */
    public void setEventOutputs(de.netallied.functionblock.model.castor.EventOutputs eventOutputs)
    {
        this._eventOutputs = eventOutputs;
    } //-- void setEventOutputs(de.netallied.functionblock.model.castor.EventOutputs) 

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
     * Sets the value of field 'plugs'.
     * 
     * @param plugs the value of field 'plugs'.
     */
    public void setPlugs(de.netallied.functionblock.model.castor.Plugs plugs)
    {
        this._plugs = plugs;
    } //-- void setPlugs(de.netallied.functionblock.model.castor.Plugs) 

    /**
     * Sets the value of field 'sockets'.
     * 
     * @param sockets the value of field 'sockets'.
     */
    public void setSockets(de.netallied.functionblock.model.castor.Sockets sockets)
    {
        this._sockets = sockets;
    } //-- void setSockets(de.netallied.functionblock.model.castor.Sockets) 

    /**
     * Method unmarshalInterfaceList
     * 
     * 
     * 
     * @param reader
     * @return Object
     */
    public static java.lang.Object unmarshalInterfaceList(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.netallied.functionblock.model.castor.InterfaceList) Unmarshaller.unmarshal(de.netallied.functionblock.model.castor.InterfaceList.class, reader);
    } //-- java.lang.Object unmarshalInterfaceList(java.io.Reader) 

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
