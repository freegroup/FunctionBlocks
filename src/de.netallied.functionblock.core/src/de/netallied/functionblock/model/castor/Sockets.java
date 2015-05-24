/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.6</a>, using an XML
 * Schema.
 * $Id: Sockets.java,v 1.3 2007/02/14 19:23:04 freegroup Exp $
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
 * Class Sockets.
 * 
 * @version $Revision: 1.3 $ $Date: 2007/02/14 19:23:04 $
 */
public class Sockets implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _adapterDeclarationList
     */
    private java.util.Vector _adapterDeclarationList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Sockets() {
        super();
        _adapterDeclarationList = new Vector();
    } //-- de.netallied.functionblock.model.castor.Sockets()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addAdapterDeclaration
     * 
     * 
     * 
     * @param vAdapterDeclaration
     */
    public void addAdapterDeclaration(de.netallied.functionblock.model.castor.AdapterDeclaration vAdapterDeclaration)
        throws java.lang.IndexOutOfBoundsException
    {
        _adapterDeclarationList.addElement(vAdapterDeclaration);
    } //-- void addAdapterDeclaration(de.netallied.functionblock.model.castor.AdapterDeclaration) 

    /**
     * Method addAdapterDeclaration
     * 
     * 
     * 
     * @param index
     * @param vAdapterDeclaration
     */
    public void addAdapterDeclaration(int index, de.netallied.functionblock.model.castor.AdapterDeclaration vAdapterDeclaration)
        throws java.lang.IndexOutOfBoundsException
    {
        _adapterDeclarationList.insertElementAt(vAdapterDeclaration, index);
    } //-- void addAdapterDeclaration(int, de.netallied.functionblock.model.castor.AdapterDeclaration) 

    /**
     * Method enumerateAdapterDeclaration
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateAdapterDeclaration()
    {
        return _adapterDeclarationList.elements();
    } //-- java.util.Enumeration enumerateAdapterDeclaration() 

    /**
     * Method getAdapterDeclaration
     * 
     * 
     * 
     * @param index
     * @return AdapterDeclaration
     */
    public de.netallied.functionblock.model.castor.AdapterDeclaration getAdapterDeclaration(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _adapterDeclarationList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (de.netallied.functionblock.model.castor.AdapterDeclaration) _adapterDeclarationList.elementAt(index);
    } //-- de.netallied.functionblock.model.castor.AdapterDeclaration getAdapterDeclaration(int) 

    /**
     * Method getAdapterDeclaration
     * 
     * 
     * 
     * @return AdapterDeclaration
     */
    public de.netallied.functionblock.model.castor.AdapterDeclaration[] getAdapterDeclaration()
    {
        int size = _adapterDeclarationList.size();
        de.netallied.functionblock.model.castor.AdapterDeclaration[] mArray = new de.netallied.functionblock.model.castor.AdapterDeclaration[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (de.netallied.functionblock.model.castor.AdapterDeclaration) _adapterDeclarationList.elementAt(index);
        }
        return mArray;
    } //-- de.netallied.functionblock.model.castor.AdapterDeclaration[] getAdapterDeclaration() 

    /**
     * Method getAdapterDeclarationCount
     * 
     * 
     * 
     * @return int
     */
    public int getAdapterDeclarationCount()
    {
        return _adapterDeclarationList.size();
    } //-- int getAdapterDeclarationCount() 

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
     * Method removeAdapterDeclaration
     * 
     * 
     * 
     * @param index
     * @return AdapterDeclaration
     */
    public de.netallied.functionblock.model.castor.AdapterDeclaration removeAdapterDeclaration(int index)
    {
        java.lang.Object obj = _adapterDeclarationList.elementAt(index);
        _adapterDeclarationList.removeElementAt(index);
        return (de.netallied.functionblock.model.castor.AdapterDeclaration) obj;
    } //-- de.netallied.functionblock.model.castor.AdapterDeclaration removeAdapterDeclaration(int) 

    /**
     * Method removeAllAdapterDeclaration
     * 
     */
    public void removeAllAdapterDeclaration()
    {
        _adapterDeclarationList.removeAllElements();
    } //-- void removeAllAdapterDeclaration() 

    /**
     * Method setAdapterDeclaration
     * 
     * 
     * 
     * @param index
     * @param vAdapterDeclaration
     */
    public void setAdapterDeclaration(int index, de.netallied.functionblock.model.castor.AdapterDeclaration vAdapterDeclaration)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _adapterDeclarationList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _adapterDeclarationList.setElementAt(vAdapterDeclaration, index);
    } //-- void setAdapterDeclaration(int, de.netallied.functionblock.model.castor.AdapterDeclaration) 

    /**
     * Method setAdapterDeclaration
     * 
     * 
     * 
     * @param adapterDeclarationArray
     */
    public void setAdapterDeclaration(de.netallied.functionblock.model.castor.AdapterDeclaration[] adapterDeclarationArray)
    {
        //-- copy array
        _adapterDeclarationList.removeAllElements();
        for (int i = 0; i < adapterDeclarationArray.length; i++) {
            _adapterDeclarationList.addElement(adapterDeclarationArray[i]);
        }
    } //-- void setAdapterDeclaration(de.netallied.functionblock.model.castor.AdapterDeclaration) 

    /**
     * Method unmarshalSockets
     * 
     * 
     * 
     * @param reader
     * @return Object
     */
    public static java.lang.Object unmarshalSockets(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.netallied.functionblock.model.castor.Sockets) Unmarshaller.unmarshal(de.netallied.functionblock.model.castor.Sockets.class, reader);
    } //-- java.lang.Object unmarshalSockets(java.io.Reader) 

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
