/*
 * Created on 19.12.2006
 *
 */
package de.netallied.functionblock.converter.java2java.util;

import java.util.StringTokenizer;

public class JavaUtil
{
  public static String toJava(String tc)
  {
    if(tc==null)
      return "true";
    if(tc.equals("1"))
      return "true";
    
    StringBuffer sb= new StringBuffer(1024);
    StringTokenizer t = new StringTokenizer(tc, " !|&()<=>+-*/", true);
    while(t.hasMoreElements()) 
    {
        String s = t.nextToken();
        if(!s.equals(" "))
        {
            String su = s.toUpperCase();
            if(su.equals("AND"))
              sb.append("&");
            else if(su.equals("OR"))
              sb.append("|");
            else if(su.equals("NOT"))
              sb.append("!");
            else if(su.equals("TRUE"))
              sb.append("true");
            else if(su.equals("="))
              sb.append("==");
            else
            {
                String s2 = "";
                if(s.equals("<") && t.hasMoreElements())
                {
                    s2 = t.nextToken();
                    if(s2.equals(">"))
                    {
                      sb.append("!=");
                        s = t.nextToken();
                    } else
                    {
                      sb.append(s);
                        s = s2;
                    }
                } else
                if(s.equals(">") && t.hasMoreElements())
                {
                  sb.append(s);
                    s = t.nextToken();
                }
                
                sb.append(s);
                sb.append(".getValue()");
            }
        }
    }
    return sb.toString();
  }
}

