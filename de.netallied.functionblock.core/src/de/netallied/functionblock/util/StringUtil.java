/*
 * Created on 05.12.2006
 *
 */
package de.netallied.functionblock.util;


import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

/**
 * StringUtil - String utility class
 */

/* ToDo
 * ====
 * replace(String, String, String) method
 *  Explore indexing the replaces and allocating a buffer of exactly the right size.
 *  Explore using String.substring rather than String.toCharArray() if
 *   a small number of large sections are being replaced.
 * Search
 *  Simple wildcarded search...
 * Replace
 *  replace(String, char, char)
 *  replace(String, char[], char[])
 *  replace(String, String[], String[])
 *  Simple wildcarded search and replace (# and *)...
 * Stripping
 *  stripTrailingWhitespace
 *  stripLeadingWhitespace
 *  stripSurroundingingWhitespace
 *  stripAllSpaces
 * Padding
 *  padLeft(java.lang.String s, int length)
 *  padRight(java.lang.String s, int length)
 *  center(java.lang.String s, int length)
 * Misc
 *  repeat(String s, int n)
 *  reverse(String)
 *  rot13(String)
 *  boolean isValidEmail(String email_address)
 *  concat(Object[] objects, String separator)
 *  String split(String list, String separator) - version of the JDK method that allows null strings...
 *  distance(String, String) - calculates hamming distance
 *  count(String string, String search)
 *
 * Notes
 * =====
 * This class amy contain some "junk" methods.
 * I use an automated tool that rips out any unused
 *  methods, so this is not a concern to me.
 * Use of new StringBuffer(string) wastes 16 bytes - use StringBuffer(String, int) instead when it arrives...
 *
 */
 public class StringUtil 
 {
    static public final transient String RCS_ID = "$Id: StringUtil.java,v 1.1 2007/01/17 09:38:45 freegroup Exp $";
    static public final transient String RCS_REV = "$Revision: 1.1 $";

    /**
     * Search an array for a given string
     * @param array Array of strings to search
     * @param value Value to search for
     * @return Index where value was found in array, or -1 if not found
     */
    public static int indexOf(String[] array, String value) 
    {
      if (array == null)
        return -1;
      for (int i = 0; i < array.length; i++) 
      {
        if (equals(array[i], value))
          return i;
      }
      return -1;
    }


    /**
     * Null-safe equality test
     */
    public static boolean equals(Object o1, Object o2) 
    {
      if (o1 == null)
        return o2 == null;
      else
        return o1.equals(o2);
    }
    
    /* ...
    *
    */

    /**
     * Return a String with all occurrences of the "from" String
     * within "original" replaced with the "to" String.
     * If the "original" string contains no occurrences of "from",
     * "original" is itself returned, rather than a copy.
     *
     * @param original the original String
     * @param from the String to replace within "original"
     * @param to the String to replace "from" with
     *
     * @returns a version of "original" with all occurrences of
     * the "from" parameter being replaced with the "to" parameter.
     */
      public static String replace(String original, String from, String to) {
         int from_length = from.length();

         if (from_length != to.length()) {
            if (from_length == 0) {
               if (to.length() != 0) {
                  throw new IllegalArgumentException("Replacing the empty string with something was attempted");
               }
            }

            int start = original.indexOf(from);

            if (start == -1) {
               return original;
            }

            char[] original_chars = original.toCharArray();

            StringBuffer buffer = new StringBuffer(original.length());

            int copy_from = 0;
            while (start != -1) {
               buffer.append(original_chars, copy_from, start - copy_from);
               buffer.append(to);
               copy_from = start + from_length;
               start = original.indexOf(from, copy_from);
            }

            buffer.append(original_chars, copy_from, original_chars.length - copy_from);

            return buffer.toString();
         }
         else
         {
            if (from.equals(to)) {
               return original;
            }

            int start = original.indexOf(from);

            if (start == -1) {
               return original;
            }

            StringBuffer buffer = new StringBuffer(original);

         // Use of the following Java 2 code is desirable on performance grounds...

         /*
         // Start of Java >= 1.2 code...
            while (start != -1) {
               buffer.replace(start, start + from_length, to);
               start = original.indexOf(from, start + from_length);
            }
         // End of Java >= 1.2 code...
         */

         // The *ALTERNATIVE* code that follows is included for backwards compatibility with Java 1.0.2...

         // Start of Java 1.0.2-compatible code...
            char[] to_chars = to.toCharArray();
            while (start != -1) {
               for (int i = 0; i < from_length; i++) {
                  buffer.setCharAt(start + i, to_chars[i]);
               }

               start = original.indexOf(from, start + from_length);
            }
          // End of Java 1.0.2-compatible code...

            return buffer.toString();
         }
      }


    /**
     * Return a String with all occurrences of the "search" String
     * within "original" removed.
     * If the "original" string contains no occurrences of "search",
     * "original" is itself returned, rather than a copy.
     *
     * @param original the original String
     * @param search the String to be removed
     *
     * @returns a version of "original" with all occurrences of
     * the "from" parameter removed.
     */
      static String remove(String original, String search) {
         return replace(original, search, "");
      }


    /**
     * Return the first String found sandwiched between
     * "leading" and "trailing" in "string", or null if
     * no such string is found.
     *
     * @param string the original String
     * @param leading the String to replace within "original"
     * @param trailing the String to replace "from" with
     *
     * @returns the first String sandwiched between
     * "leading" and "trailing" in "string" - or null if
     * no such string is found.
     */
      static String getSandwichedString(String string, String leading, String trailing) {
         int i_start = string.indexOf(leading);

         if (i_start < 0) {
            return null;
         }

         i_start += leading.length();

         int i_end = string.indexOf(trailing, i_start);

         if (i_end < 0) {
            return null;
         }

         return string.substring(i_start, i_end);
      }


    /**
     * Takes a list of objects and concatenates the toString()
     * representation of each object and returns the result.
     *
     * @param objects an array of objects
     *
     * @returns a string formed by concatenating string
     * representations of the objects in the array.
     */
      static public String concat(Object[] objects) {
         StringBuffer buffer = new StringBuffer ();
         for (int i=0; i < objects.length; i++) {
            buffer.append (objects[i].toString());
         }

         return buffer.toString();
      }


    /**
     * Creates a string of length "length" composed of the character "c",
     * or the null string if c <= 0.
     *
     * @param length the length of the returned string
     * @param c the character is solely consists of
     *
     * @returns a string of length "length" composed of the character "c".
     */
      public static String fill(char c, int length) {
         if (length <= 0 ) {
            return "";
         }

         char[] chars = new char[length];
         for (int i = 0; i < length; i++) {
            chars[i] = c;
         }

         return new String(chars);
      }


   /**
     * Return true if  "string" contains "find".
     *
     * @param string the string whose contents are searched
     * @param find the string to be located as a substring
     *
     * @returns true if  "string" contains "find".
     */
      static boolean contains(String string, String find) {
         return (string.indexOf(find) >= 0);
      }


    /**
     * Return reversed version of "string".
     *
     * @param string the string to be reversed
     * @param find the string to be located as a substring
     *
     * @returns reversed version of "string"
     */
      static String reverse(String string) {
         return new StringBuffer(string).reverse().toString();
      }

      /**
       * 
       * @param input
       * @return
       */
      public static String toJavascriptString(String input)
      {
        if (input == null || input.length() == 0)
          return "&nbsp;";

        StringBuffer erg = new StringBuffer(input);
        int pos = 0;
        while (pos < erg.length())
        {
          if (erg.charAt(pos) == '\\')
          {
            if (((pos + 1) == erg.length()) || erg.charAt(pos + 1) != '\\')
            {
              erg.insert(pos + 1, '\\');
            }
            pos++;
          }
          pos++;
        }
        return erg.toString();
      }
      
      /**
       * Returns "" for an null string
       * 
       * @param input
       * @return
       */
      public static String toSaveString(String input)
      {
        return input == null ? "" : input;
      }
      
      public static boolean saveEquals(String input, String input2)
      {
        return toSaveString(input).equals(toSaveString(input2));
      }
      
      public static int saveCompareTo(String input, String input2)
      {
        return toSaveString(input).compareTo(toSaveString(input2));
      }
      
      private final static char[] hexCharacters = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
      
      /**
       * Converts a byte array into a hexadecimal string.
       * @param input the byte array to convert
       * @return the hexadecimal representation
       */
      public static String toHexString(byte[] input)
      {
        if (input == null)
          return null;
        StringBuffer buffer = new StringBuffer(2*input.length);
        for (int i=0; i<input.length; i++)
        {
          buffer.append(hexCharacters[(input[i] >> 4) & 0xf]);
          buffer.append(hexCharacters[input[i] & 0xf]);
        }
        return buffer.toString();
      }
      
      /**
       * Converts a String to HTML by converting all special characters to
       * HTML-entities.
       */
  public final static String htmlEncode(String s)
  {
    return htmlEncode(s, "\n");
  }

  /**
   * Converts a String to HTML by converting all special characters to
   * HTML-entities.
   */
  public final static String htmlEncode(String s, String cr)
  {
    if (s == null)
    {
      return "";
    }
    // Unicode benötigt im Schnitt ~ doppelt so viel Platz
    StringWriter sw = new StringWriter(s.length() * 2);
    try
    {
      htmlEncode(sw, s, cr);
    }
    catch (IOException ex)
    {
      // should never occur
      throw new RuntimeException(ex);
    }
    return sw.toString();
  }

  /**
   * Converts a String to HTML by converting all special characters to
   * HTML-entities.
   */
  public final static void htmlEncode(Writer w, String s) throws IOException
  {
    htmlEncode(w, s, "\n");
  }

  /**
   * Converts a String to HTML by converting all special characters to
   * HTML-entities.
   */
  private final static void htmlEncode(Writer w, String s, String cr) throws IOException
  {
    if (s != null)
    {
      for (int i = 0; i < s.length(); ++i)
      {
        char ch = s.charAt(i);
        if (ch >= 'a' && ch <= 'z' || ch >= '0' && ch <= '9' || ch >= 'A' && ch <= 'Z' || ch == ' ')
        {
          w.write(ch);
        }
        else
        {
          switch (ch)
          {
            case '\n':
              w.write(cr);
              break;
            case '>':
              w.write("&gt;");
              break;
            case '<':
              w.write("&lt;");
              break;
            case '&':
              w.write("&amp;");
              break;
            case '"':
              w.write("&quot;");
              break;
            case '\u00a9':
              w.write("&copy;");
              break;
            case '\u00ae':
              w.write("&reg;");
              break;
            default:
              // es ist kein 7bit/SpezialHTML Zeichen -> unicode
              w.write("&#");
              w.write(Integer.toString(ch));
              w.write(';');
              break;
          }
        }
      }
    }
  }
}