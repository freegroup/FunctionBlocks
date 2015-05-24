
package de.netallied.functionblock.converter.java2java.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.io.FileUtils;
/*******************************************************************************
 *    This file is part of Open-jACOB
 *    Copyright (C) 2005-2006 Tarragon GmbH
 * 
 *    This program is free software; you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation; version 2 of the License.
 * 
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 * 
 *    You should have received a copy of the GNU General Public License     
 *    along with this program; if not, write to the Free Software
 *    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  
 *    USA
 *******************************************************************************/

public class Directory
{
  static public final transient String RCS_ID = "$Id: Directory.java,v 1.1 2007/01/17 09:25:41 freegroup Exp $";
  static public final transient String RCS_REV = "$Revision: 1.1 $";

  /**
   * 
   * @param folder
   * @param recursive
   * @return ArrayList[File]
   */
  public static ArrayList getAll(File folder, boolean recursive)
  {
    ArrayList list = new ArrayList();
    File[] files = folder.listFiles();
    // directory doesn't exists -> return empty set
    if(files==null)
      return list;
//    String inhalt= FileUtils.readFileToString(file,"ISO-8859-1");
    for(int i=0; i<files.length; i++)
    {
      if(files[i].isDirectory())
      {
        if(recursive)
        {
          list.addAll(getAll(files[i], recursive));
        }
      }
      else
      {
        list.add(files[i]);
      }
    }
    return list;
  }

  /**
   *
   */
  public static ArrayList getAllDirs(File folder, boolean recursive)
  {
    ArrayList list = new ArrayList();
    File[] files = folder.listFiles();
    if(files==null)
      return list;
    for(int i=0; i<files.length; i++)
    {
      if(files[i].isDirectory())
      {
        list.add(files[i]);
        if(recursive)
          list.addAll(getAllDirs(files[i], recursive));
      }
    }
    return list;
  }

  public static void main(String[] params)
  {
    File temp = new File("C:\\Temp");
    ArrayList list = Directory.getAll(temp, true);
    Iterator it = list.iterator();
    while(it.hasNext())
    {
      System.out.println(((File)(it.next())).getAbsolutePath());
    }
    System.out.println( "Number of Files: " +  list.size());
  }
}
