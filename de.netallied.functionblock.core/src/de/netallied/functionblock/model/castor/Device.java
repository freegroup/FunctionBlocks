/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.6</a>, using an XML
 * Schema.
 * $Id: Device.java,v 1.3 2007/02/14 19:23:04 freegroup Exp $
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
 * Class Device.
 * 
 * @version $Revision: 1.3 $ $Date: 2007/02/14 19:23:04 $
 */
public class Device implements java.io.Serializable {


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
    private java.lang.String _type;

    /**
     * Field _comment
     */
    private java.lang.String _comment;

    /**
     * Field _x
     */
    private float _x;

    /**
     * keeps track of state for field: _x
     */
    private boolean _has_x;

    /**
     * Field _y
     */
    private float _y;

    /**
     * keeps track of state for field: _y
     */
    private boolean _has_y;

    /**
     * Field _parameterList
     */
    private java.util.Vector _parameterList;

    /**
     * Field _resourceList
     */
    private java.util.Vector _resourceList;

    /**
     * Field _FBNetwork
     */
    private de.netallied.functionblock.model.castor.FBNetwork _FBNetwork;


      //----------------/
     //- Constructors -/
    //----------------/

    public Device() {
        super();
        _parameterList = new Vector();
        _resourceList = new Vector();
    } //-- de.netallied.functionblock.model.castor.Device()


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
     * Method addResource
     * 
     * 
     * 
     * @param vResource
     */
    public void addResource(de.netallied.functionblock.model.castor.Resource vResource)
        throws java.lang.IndexOutOfBoundsException
    {
        _resourceList.addElement(vResource);
    } //-- void addResource(de.netallied.functionblock.model.castor.Resource) 

    /**
     * Method addResource
     * 
     * 
     * 
     * @param index
     * @param vResource
     */
    public void addResource(int index, de.netallied.functionblock.model.castor.Resource vResource)
        throws java.lang.IndexOutOfBoundsException
    {
        _resourceList.insertElementAt(vResource, index);
    } //-- void addResource(int, de.netallied.functionblock.model.castor.Resource) 

    /**
     * Method deleteX
     * 
     */
    public void deleteX()
    {
        this._has_x= false;
    } //-- void deleteX() 

    /**
     * Method deleteY
     * 
     */
    public void deleteY()
    {
        this._has_y= false;
    } //-- void deleteY() 

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
     * Method enumerateResource
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateResource()
    {
        return _resourceList.elements();
    } //-- java.util.Enumeration enumerateResource() 

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
     * Returns the value of field 'FBNetwork'.
     * 
     * @return FBNetwork
     * @return the value of field 'FBNetwork'.
     */
    public de.netallied.functionblock.model.castor.FBNetwork getFBNetwork()
    {
        return this._FBNetwork;
    } //-- de.netallied.functionblock.model.castor.FBNetwork getFBNetwork() 

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
     * Method getResource
     * 
     * 
     * 
     * @param index
     * @return Resource
     */
    public de.netallied.functionblock.model.castor.Resource getResource(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _resourceList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (de.netallied.functionblock.model.castor.Resource) _resourceList.elementAt(index);
    } //-- de.netallied.functionblock.model.castor.Resource getResource(int) 

    /**
     * Method getResource
     * 
     * 
     * 
     * @return Resource
     */
    public de.netallied.functionblock.model.castor.Resource[] getResource()
    {
        int size = _resourceList.size();
        de.netallied.functionblock.model.castor.Resource[] mArray = new de.netallied.functionblock.model.castor.Resource[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (de.netallied.functionblock.model.castor.Resource) _resourceList.elementAt(index);
        }
        return mArray;
    } //-- de.netallied.functionblock.model.castor.Resource[] getResource() 

    /**
     * Method getResourceCount
     * 
     * 
     * 
     * @return int
     */
    public int getResourceCount()
    {
        return _resourceList.size();
    } //-- int getResourceCount() 

    /**
     * Returns the value of field 'type'.
     * 
     * @return String
     * @return the value of field 'type'.
     */
    public java.lang.String getType()
    {
        return this._type;
    } //-- java.lang.String getType() 

    /**
     * Returns the value of field 'x'.
     * 
     * @return float
     * @return the value of field 'x'.
     */
    public float getX()
    {
        return this._x;
    } //-- float getX() 

    /**
     * Returns the value of field 'y'.
     * 
     * @return float
     * @return the value of field 'y'.
     */
    public float getY()
    {
        return this._y;
    } //-- float getY() 

    /**
     * Method hasX
     * 
     * 
     * 
     * @return boolean
     */
    public boolean hasX()
    {
        return this._has_x;
    } //-- boolean hasX() 

    /**
     * Method hasY
     * 
     * 
     * 
     * @return boolean
     */
    public boolean hasY()
    {
        return this._has_y;
    } //-- boolean hasY() 

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
     * Method removeAllResource
     * 
     */
    public void removeAllResource()
    {
        _resourceList.removeAllElements();
    } //-- void removeAllResource() 

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
     * Method removeResource
     * 
     * 
     * 
     * @param index
     * @return Resource
     */
    public de.netallied.functionblock.model.castor.Resource removeResource(int index)
    {
        java.lang.Object obj = _resourceList.elementAt(index);
        _resourceList.removeElementAt(index);
        return (de.netallied.functionblock.model.castor.Resource) obj;
    } //-- de.netallied.functionblock.model.castor.Resource removeResource(int) 

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
     * Sets the value of field 'FBNetwork'.
     * 
     * @param FBNetwork the value of field 'FBNetwork'.
     */
    public void setFBNetwork(de.netallied.functionblock.model.castor.FBNetwork FBNetwork)
    {
        this._FBNetwork = FBNetwork;
    } //-- void setFBNetwork(de.netallied.functionblock.model.castor.FBNetwork) 

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
     * Method setResource
     * 
     * 
     * 
     * @param index
     * @param vResource
     */
    public void setResource(int index, de.netallied.functionblock.model.castor.Resource vResource)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _resourceList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _resourceList.setElementAt(vResource, index);
    } //-- void setResource(int, de.netallied.functionblock.model.castor.Resource) 

    /**
     * Method setResource
     * 
     * 
     * 
     * @param resourceArray
     */
    public void setResource(de.netallied.functionblock.model.castor.Resource[] resourceArray)
    {
        //-- copy array
        _resourceList.removeAllElements();
        for (int i = 0; i < resourceArray.length; i++) {
            _resourceList.addElement(resourceArray[i]);
        }
    } //-- void setResource(de.netallied.functionblock.model.castor.Resource) 

    /**
     * Sets the value of field 'type'.
     * 
     * @param type the value of field 'type'.
     */
    public void setType(java.lang.String type)
    {
        this._type = type;
    } //-- void setType(java.lang.String) 

    /**
     * Sets the value of field 'x'.
     * 
     * @param x the value of field 'x'.
     */
    public void setX(float x)
    {
        this._x = x;
        this._has_x = true;
    } //-- void setX(float) 

    /**
     * Sets the value of field 'y'.
     * 
     * @param y the value of field 'y'.
     */
    public void setY(float y)
    {
        this._y = y;
        this._has_y = true;
    } //-- void setY(float) 

    /**
     * Method unmarshalDevice
     * 
     * 
     * 
     * @param reader
     * @return Object
     */
    public static java.lang.Object unmarshalDevice(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.netallied.functionblock.model.castor.Device) Unmarshaller.unmarshal(de.netallied.functionblock.model.castor.Device.class, reader);
    } //-- java.lang.Object unmarshalDevice(java.io.Reader) 

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
