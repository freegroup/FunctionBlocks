/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.6</a>, using an XML
 * Schema.
 * $Id: CompilerLanguageType.java,v 1.3 2007/02/14 19:23:09 freegroup Exp $
 */

package de.netallied.functionblock.model.castor.types;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class CompilerLanguageType.
 * 
 * @version $Revision: 1.3 $ $Date: 2007/02/14 19:23:09 $
 */
public class CompilerLanguageType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The Java type
     */
    public static final int JAVA_TYPE = 0;

    /**
     * The instance of the Java type
     */
    public static final CompilerLanguageType JAVA = new CompilerLanguageType(JAVA_TYPE, "Java");

    /**
     * The Cpp type
     */
    public static final int CPP_TYPE = 1;

    /**
     * The instance of the Cpp type
     */
    public static final CompilerLanguageType CPP = new CompilerLanguageType(CPP_TYPE, "Cpp");

    /**
     * The C type
     */
    public static final int C_TYPE = 2;

    /**
     * The instance of the C type
     */
    public static final CompilerLanguageType C = new CompilerLanguageType(C_TYPE, "C");

    /**
     * The Other type
     */
    public static final int OTHER_TYPE = 3;

    /**
     * The instance of the Other type
     */
    public static final CompilerLanguageType OTHER = new CompilerLanguageType(OTHER_TYPE, "Other");

    /**
     * Field _memberTable
     */
    private static java.util.Hashtable _memberTable = init();

    /**
     * Field type
     */
    private int type = -1;

    /**
     * Field stringValue
     */
    private java.lang.String stringValue = null;


      //----------------/
     //- Constructors -/
    //----------------/

    private CompilerLanguageType(int type, java.lang.String value) {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- de.netallied.functionblock.model.castor.types.CompilerLanguageType(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerate
     * 
     * Returns an enumeration of all possible instances of
     * CompilerLanguageType
     * 
     * @return Enumeration
     */
    public static java.util.Enumeration enumerate()
    {
        return _memberTable.elements();
    } //-- java.util.Enumeration enumerate() 

    /**
     * Method getType
     * 
     * Returns the type of this CompilerLanguageType
     * 
     * @return int
     */
    public int getType()
    {
        return this.type;
    } //-- int getType() 

    /**
     * Method init
     * 
     * 
     * 
     * @return Hashtable
     */
    private static java.util.Hashtable init()
    {
        Hashtable members = new Hashtable();
        members.put("Java", JAVA);
        members.put("Cpp", CPP);
        members.put("C", C);
        members.put("Other", OTHER);
        return members;
    } //-- java.util.Hashtable init() 

    /**
     * Method readResolve
     * 
     *  will be called during deserialization to replace the
     * deserialized object with the correct constant instance.
     * <br/>
     * 
     * @return Object
     */
    private java.lang.Object readResolve()
    {
        return valueOf(this.stringValue);
    } //-- java.lang.Object readResolve() 

    /**
     * Method toString
     * 
     * Returns the String representation of this
     * CompilerLanguageType
     * 
     * @return String
     */
    public java.lang.String toString()
    {
        return this.stringValue;
    } //-- java.lang.String toString() 

    /**
     * Method valueOf
     * 
     * Returns a new CompilerLanguageType based on the given String
     * value.
     * 
     * @param string
     * @return CompilerLanguageType
     */
    public static de.netallied.functionblock.model.castor.types.CompilerLanguageType valueOf(java.lang.String string)
    {
        java.lang.Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid CompilerLanguageType";
            throw new IllegalArgumentException(err);
        }
        return (CompilerLanguageType) obj;
    } //-- de.netallied.functionblock.model.castor.types.CompilerLanguageType valueOf(java.lang.String) 

}
