/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.6</a>, using an XML
 * Schema.
 * $Id: Link.java,v 1.3 2007/02/14 19:23:08 freegroup Exp $
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
 * Class Link.
 * 
 * @version $Revision: 1.3 $ $Date: 2007/02/14 19:23:08 $
 */
public class Link implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _segmentName
     */
    private java.lang.String _segmentName;

    /**
     * Field _commResource
     */
    private java.lang.String _commResource;

    /**
     * Field _comment
     */
    private java.lang.String _comment;

    /**
     * Field _parameterList
     */
    private java.util.Vector _parameterList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Link() {
        super();
        _parameterList = new Vector();
    } //-- de.netallied.functionblock.model.castor.Link()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addParameter
     * 
     * 
     * 
     * @param vParameter
     */
    public void addParameter(de.netallied.functionblock.model.castor.Parameter vParameter)
        throws java.lang.IndexOutOfBoundsException
    {
        _parameterList.addElement(vParameter);
    } //-- void addParameter(de.netallied.functionblock.model.castor.Parameter) 

    /**
     * Method addParameter
     * 
     * 
     * 
     * @param index
     * @param vParameter
     */
    public void addParameter(int index, de.netallied.functionblock.model.castor.Parameter vParameter)
        throws java.lang.IndexOutOfBoundsException
    {
        _parameterList.insertElementAt(vParameter, index);
    } //-- void addParameter(int, de.netallied.functionblock.model.castor.Parameter) 

    /**
     * Method enumerateParameter
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateParameter()
    {
        return _parameterList.elements();
    } //-- java.util.Enumeration enumerateParameter() 

    /**
     * Returns the value of field 'commResource'.
     * 
     * @return String
     * @return the value of field 'commResource'.
     */
    public java.lang.String getCommResource()
    {
        return this._commResource;
    } //-- java.lang.String getCommResource() 

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
     * Method getParameter
     * 
     * 
     * 
     * @param index
     * @return Parameter
     */
    public de.netallied.functionblock.model.castor.Parameter getParameter(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _parameterList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (de.netallied.functionblock.model.castor.Parameter) _parameterList.elementAt(index);
    } //-- de.netallied.functionblock.model.castor.Parameter getParameter(int) 

    /**
     * Method getParameter
     * 
     * 
     * 
     * @return Parameter
     */
    public de.netallied.functionblock.model.castor.Parameter[] getParameter()
    {
        int size = _parameterList.size();
        de.netallied.functionblock.model.castor.Parameter[] mArray = new de.netallied.functionblock.model.castor.Parameter[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (de.netallied.functionblock.model.castor.Parameter) _parameterList.elementAt(index);
        }
        return mArray;
    } //-- de.netallied.functionblock.model.castor.Parameter[] getParameter() 

    /**
     * Method getParameterCount
     * 
     * 
     * 
     * @return int
     */
    public int getParameterCount()
    {
        return _parameterList.size();
    } //-- int getParameterCount() 

    /**
     * Returns the value of field 'segmentName'.
     * 
     * @return String
     * @return the value of field 'segmentName'.
     */
    public java.lang.String getSegmentName()
    {
        return this._segmentName;
    } //-- java.lang.String getSegmentName() 

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
     * Method removeAllParameter
     * 
     */
    public void removeAllParameter()
    {
        _parameterList.removeAllElements();
    } //-- void removeAllParameter() 

    /**
     * Method removeParameter
     * 
     * 
     * 
     * @param index
     * @return Parameter
     */
    public de.netallied.functionblock.model.castor.Parameter removeParameter(int index)
    {
        java.lang.Object obj = _parameterList.elementAt(index);
        _parameterList.removeElementAt(index);
        return (de.netallied.functionblock.model.castor.Parameter) obj;
    } //-- de.netallied.functionblock.model.castor.Parameter removeParameter(int) 

    /**
     * Sets the value of field 'commResource'.
     * 
     * @param commResource the value of field 'commResource'.
     */
    public void setCommResource(java.lang.String commResource)
    {
        this._commResource = commResource;
    } //-- void setCommResource(java.lang.String) 

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
     * Method setParameter
     * 
     * 
     * 
     * @param index
     * @param vParameter
     */
    public void setParameter(int index, de.netallied.functionblock.model.castor.Parameter vParameter)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _parameterList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _parameterList.setElementAt(vParameter, index);
    } //-- void setParameter(int, de.netallied.functionblock.model.castor.Parameter) 

    /**
     * Method setParameter
     * 
     * 
     * 
     * @param parameterArray
     */
    public void setParameter(de.netallied.functionblock.model.castor.Parameter[] parameterArray)
    {
        //-- copy array
        _parameterList.removeAllElements();
        for (int i = 0; i < parameterArray.length; i++) {
            _parameterList.addElement(parameterArray[i]);
        }
    } //-- void setParameter(de.netallied.functionblock.model.castor.Parameter) 

    /**
     * Sets the value of field 'segmentName'.
     * 
     * @param segmentName the value of field 'segmentName'.
     */
    public void setSegmentName(java.lang.String segmentName)
    {
        this._segmentName = segmentName;
    } //-- void setSegmentName(java.lang.String) 

    /**
     * Method unmarshalLink
     * 
     * 
     * 
     * @param reader
     * @return Object
     */
    public static java.lang.Object unmarshalLink(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.netallied.functionblock.model.castor.Link) Unmarshaller.unmarshal(de.netallied.functionblock.model.castor.Link.class, reader);
    } //-- java.lang.Object unmarshalLink(java.io.Reader) 

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
