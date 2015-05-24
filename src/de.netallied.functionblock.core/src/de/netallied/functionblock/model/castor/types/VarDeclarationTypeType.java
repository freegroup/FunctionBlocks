/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.6</a>, using an XML
 * Schema.
 * $Id: VarDeclarationTypeType.java,v 1.3 2007/02/14 19:23:10 freegroup Exp $
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
 * Class VarDeclarationTypeType.
 * 
 * @version $Revision: 1.3 $ $Date: 2007/02/14 19:23:10 $
 */
public class VarDeclarationTypeType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The BOOL type
     */
    public static final int BOOL_TYPE = 0;

    /**
     * The instance of the BOOL type
     */
    public static final VarDeclarationTypeType BOOL = new VarDeclarationTypeType(BOOL_TYPE, "BOOL");

    /**
     * The SINT type
     */
    public static final int SINT_TYPE = 1;

    /**
     * The instance of the SINT type
     */
    public static final VarDeclarationTypeType SINT = new VarDeclarationTypeType(SINT_TYPE, "SINT");

    /**
     * The INT type
     */
    public static final int INT_TYPE = 2;

    /**
     * The instance of the INT type
     */
    public static final VarDeclarationTypeType INT = new VarDeclarationTypeType(INT_TYPE, "INT");

    /**
     * The DINT type
     */
    public static final int DINT_TYPE = 3;

    /**
     * The instance of the DINT type
     */
    public static final VarDeclarationTypeType DINT = new VarDeclarationTypeType(DINT_TYPE, "DINT");

    /**
     * The LINT type
     */
    public static final int LINT_TYPE = 4;

    /**
     * The instance of the LINT type
     */
    public static final VarDeclarationTypeType LINT = new VarDeclarationTypeType(LINT_TYPE, "LINT");

    /**
     * The USINT type
     */
    public static final int USINT_TYPE = 5;

    /**
     * The instance of the USINT type
     */
    public static final VarDeclarationTypeType USINT = new VarDeclarationTypeType(USINT_TYPE, "USINT");

    /**
     * The UINT type
     */
    public static final int UINT_TYPE = 6;

    /**
     * The instance of the UINT type
     */
    public static final VarDeclarationTypeType UINT = new VarDeclarationTypeType(UINT_TYPE, "UINT");

    /**
     * The UDINT type
     */
    public static final int UDINT_TYPE = 7;

    /**
     * The instance of the UDINT type
     */
    public static final VarDeclarationTypeType UDINT = new VarDeclarationTypeType(UDINT_TYPE, "UDINT");

    /**
     * The ULINT type
     */
    public static final int ULINT_TYPE = 8;

    /**
     * The instance of the ULINT type
     */
    public static final VarDeclarationTypeType ULINT = new VarDeclarationTypeType(ULINT_TYPE, "ULINT");

    /**
     * The REAL type
     */
    public static final int REAL_TYPE = 9;

    /**
     * The instance of the REAL type
     */
    public static final VarDeclarationTypeType REAL = new VarDeclarationTypeType(REAL_TYPE, "REAL");

    /**
     * The LREAL type
     */
    public static final int LREAL_TYPE = 10;

    /**
     * The instance of the LREAL type
     */
    public static final VarDeclarationTypeType LREAL = new VarDeclarationTypeType(LREAL_TYPE, "LREAL");

    /**
     * The TIME type
     */
    public static final int TIME_TYPE = 11;

    /**
     * The instance of the TIME type
     */
    public static final VarDeclarationTypeType TIME = new VarDeclarationTypeType(TIME_TYPE, "TIME");

    /**
     * The DATE type
     */
    public static final int DATE_TYPE = 12;

    /**
     * The instance of the DATE type
     */
    public static final VarDeclarationTypeType DATE = new VarDeclarationTypeType(DATE_TYPE, "DATE");

    /**
     * The TIME_OF_DAY type
     */
    public static final int TIME_OF_DAY_TYPE = 13;

    /**
     * The instance of the TIME_OF_DAY type
     */
    public static final VarDeclarationTypeType TIME_OF_DAY = new VarDeclarationTypeType(TIME_OF_DAY_TYPE, "TIME_OF_DAY");

    /**
     * The TOD type
     */
    public static final int TOD_TYPE = 14;

    /**
     * The instance of the TOD type
     */
    public static final VarDeclarationTypeType TOD = new VarDeclarationTypeType(TOD_TYPE, "TOD");

    /**
     * The DATE_AND_TIME type
     */
    public static final int DATE_AND_TIME_TYPE = 15;

    /**
     * The instance of the DATE_AND_TIME type
     */
    public static final VarDeclarationTypeType DATE_AND_TIME = new VarDeclarationTypeType(DATE_AND_TIME_TYPE, "DATE_AND_TIME");

    /**
     * The DT type
     */
    public static final int DT_TYPE = 16;

    /**
     * The instance of the DT type
     */
    public static final VarDeclarationTypeType DT = new VarDeclarationTypeType(DT_TYPE, "DT");

    /**
     * The STRING type
     */
    public static final int STRING_TYPE = 17;

    /**
     * The instance of the STRING type
     */
    public static final VarDeclarationTypeType STRING = new VarDeclarationTypeType(STRING_TYPE, "STRING");

    /**
     * The BYTE type
     */
    public static final int BYTE_TYPE = 18;

    /**
     * The instance of the BYTE type
     */
    public static final VarDeclarationTypeType BYTE = new VarDeclarationTypeType(BYTE_TYPE, "BYTE");

    /**
     * The WORD type
     */
    public static final int WORD_TYPE = 19;

    /**
     * The instance of the WORD type
     */
    public static final VarDeclarationTypeType WORD = new VarDeclarationTypeType(WORD_TYPE, "WORD");

    /**
     * The DWORD type
     */
    public static final int DWORD_TYPE = 20;

    /**
     * The instance of the DWORD type
     */
    public static final VarDeclarationTypeType DWORD = new VarDeclarationTypeType(DWORD_TYPE, "DWORD");

    /**
     * The LWORD type
     */
    public static final int LWORD_TYPE = 21;

    /**
     * The instance of the LWORD type
     */
    public static final VarDeclarationTypeType LWORD = new VarDeclarationTypeType(LWORD_TYPE, "LWORD");

    /**
     * The WSTRING type
     */
    public static final int WSTRING_TYPE = 22;

    /**
     * The instance of the WSTRING type
     */
    public static final VarDeclarationTypeType WSTRING = new VarDeclarationTypeType(WSTRING_TYPE, "WSTRING");

    /**
     * The COLOR type
     */
    public static final int COLOR_TYPE = 23;

    /**
     * The instance of the COLOR type
     */
    public static final VarDeclarationTypeType COLOR = new VarDeclarationTypeType(COLOR_TYPE, "COLOR");

    /**
     * The MATRIX type
     */
    public static final int MATRIX_TYPE = 24;

    /**
     * The instance of the MATRIX type
     */
    public static final VarDeclarationTypeType MATRIX = new VarDeclarationTypeType(MATRIX_TYPE, "MATRIX");

    /**
     * The ANY type
     */
    public static final int ANY_TYPE = 25;

    /**
     * The instance of the ANY type
     */
    public static final VarDeclarationTypeType ANY = new VarDeclarationTypeType(ANY_TYPE, "ANY");

    /**
     * The ARRAY type
     */
    public static final int ARRAY_TYPE = 26;

    /**
     * The instance of the ARRAY type
     */
    public static final VarDeclarationTypeType ARRAY = new VarDeclarationTypeType(ARRAY_TYPE, "ARRAY");

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

    private VarDeclarationTypeType(int type, java.lang.String value) {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- de.netallied.functionblock.model.castor.types.VarDeclarationTypeType(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerate
     * 
     * Returns an enumeration of all possible instances of
     * VarDeclarationTypeType
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
     * Returns the type of this VarDeclarationTypeType
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
        members.put("BOOL", BOOL);
        members.put("SINT", SINT);
        members.put("INT", INT);
        members.put("DINT", DINT);
        members.put("LINT", LINT);
        members.put("USINT", USINT);
        members.put("UINT", UINT);
        members.put("UDINT", UDINT);
        members.put("ULINT", ULINT);
        members.put("REAL", REAL);
        members.put("LREAL", LREAL);
        members.put("TIME", TIME);
        members.put("DATE", DATE);
        members.put("TIME_OF_DAY", TIME_OF_DAY);
        members.put("TOD", TOD);
        members.put("DATE_AND_TIME", DATE_AND_TIME);
        members.put("DT", DT);
        members.put("STRING", STRING);
        members.put("BYTE", BYTE);
        members.put("WORD", WORD);
        members.put("DWORD", DWORD);
        members.put("LWORD", LWORD);
        members.put("WSTRING", WSTRING);
        members.put("COLOR", COLOR);
        members.put("MATRIX", MATRIX);
        members.put("ANY", ANY);
        members.put("ARRAY", ARRAY);
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
     * VarDeclarationTypeType
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
     * Returns a new VarDeclarationTypeType based on the given
     * String value.
     * 
     * @param string
     * @return VarDeclarationTypeType
     */
    public static de.netallied.functionblock.model.castor.types.VarDeclarationTypeType valueOf(java.lang.String string)
    {
        java.lang.Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid VarDeclarationTypeType";
            throw new IllegalArgumentException(err);
        }
        return (VarDeclarationTypeType) obj;
    } //-- de.netallied.functionblock.model.castor.types.VarDeclarationTypeType valueOf(java.lang.String) 

}
