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
/*
 * Created on 18.09.2004
 * 
 * To change the template for this generated file go to Window - Preferences - Java - Code Generation - Code and Comments
 */
package de.netallied.functionblock.util;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Andreas
 * 
 * To change the template for this generated type comment go to Window - Preferences - Java - Code Generation - Code and Comments
 */
public final class FastStringWriter extends Writer
{
  static public final transient String RCS_ID = "$Id: FastStringWriter.java,v 1.1 2007/01/17 09:38:45 freegroup Exp $";
  static public final transient String RCS_REV = "$Revision: 1.1 $";

  private static final int MIN_MIN_BUFFER_RELOCATE_SIZE = 64;
  private static final int MIN_MAX_BUFFER_RELOCATE_SIZE = 128 * 1024;

  /**
	 * The value is used for character storage.
	 * 
	 * @serial
	 */
  private char buffer[];

  /**
	 * The number of the remaining (free) characters in the buffer.
	 * 
	 * @serial
	 */
  private int remaining;

  private List bufferList;

  private int nextMinRelocSize;

  private int totalLength = 0;

  public FastStringWriter(int initialSize)
  {
    if (initialSize < 0)
    {
      throw new IllegalArgumentException("Negative buffer size");
    }
    this.nextMinRelocSize = determineRelocSize(initialSize);
    if (initialSize / MIN_MAX_BUFFER_RELOCATE_SIZE > 10)
      this.bufferList = new ArrayList(initialSize / MIN_MAX_BUFFER_RELOCATE_SIZE);
    this.remaining = 0;
    this.buffer = null;
  }

  private static int determineRelocSize(int initialSize)
  {
    if (initialSize < MIN_MIN_BUFFER_RELOCATE_SIZE)
    {
      return MIN_MIN_BUFFER_RELOCATE_SIZE;
    }
    else
    {
      if (initialSize > MIN_MAX_BUFFER_RELOCATE_SIZE)
      {
        return MIN_MAX_BUFFER_RELOCATE_SIZE;
      }
      else
      {
        return initialSize;
      }
    }
  }

  /**
	 *  
	 */
  public FastStringWriter()
  {
    this.nextMinRelocSize = MIN_MIN_BUFFER_RELOCATE_SIZE;
    this.remaining = 0;
    this.buffer = null;
    this.bufferList = null;
  }

  /*
	 * (non-Javadoc)
	 * 
	 * @see java.io.Writer#close()
	 */
  public void close()
  {
    // nothing to do here
  }

  /*
	 * (non-Javadoc)
	 * 
	 * @see java.io.Writer#flush()
	 */
  public void flush()
  {
    // nothing to do here
  }

  /*
	 * (non-Javadoc)
	 * 
	 * @see java.io.Writer#write(char[], int, int)
	 */
  public void write(char[] cbuf, int off, int len)
  {
    if (this.remaining == 0)
    {
      relocate(len);
      System.arraycopy(cbuf, off, this.buffer, 0, len);
      this.remaining -= len;
    }
    else
    {
      if (this.remaining >= len)
      {
        System.arraycopy(cbuf, off, this.buffer, buffer.length - this.remaining, len);
        this.remaining -= len;
      }
      else
      {
        System.arraycopy(cbuf, off, this.buffer, buffer.length - this.remaining, this.remaining);
        int offset = this.remaining;
        relocate(len - offset);
        System.arraycopy(cbuf, off + offset, this.buffer, 0, len - offset);
        this.remaining -= len - offset;
      }
    }
    this.totalLength += len;
  }

  private void relocate(int size)
  {
    if (size < this.nextMinRelocSize)
    {
      this.remaining = this.nextMinRelocSize;
    }
    else
    {
      this.remaining = size;
    }
    if (this.buffer != null)
    {
      if (this.bufferList == null)
      {
        this.bufferList = new ArrayList();
      }
      this.bufferList.add(this.buffer);
    }
    this.buffer = new char[this.remaining];
    this.nextMinRelocSize = determineRelocSize(2 * this.nextMinRelocSize);
  }

  /*
	 * (non-Javadoc)
	 * 
	 * @see java.io.Writer#write(java.lang.String)
	 */
  //  public void write(String str) throws IOException
  //  {
  //    int len = str.length();
  //    if (this.remaining == 0)
  //    {
  //      relocate(len);
  //      str.getChars(0, len, buffer, 0);
  //      this.remaining -= len;
  //    }
  //    else
  //    {
  //      if (this.remaining >= len)
  //      {
  //        str.getChars(0, len, buffer, buffer.length - this.remaining);
  //        this.remaining -= len;
  //      }
  //      else
  //      {
  //        str.getChars(0, this.remaining, buffer, buffer.length - this.remaining);
  //        int offset = this.remaining;
  //        relocate(len-offset);
  //        str.getChars(offset, len, buffer, 0);
  //        this.remaining -= len - offset;
  //      }
  //    }
  //  }

  /*
	 * (non-Javadoc)
	 * 
	 * @see java.io.Writer#write(int)
	 */
  public void write(int c)
  {
    if (this.remaining == 0)
    {
      relocate(1);
      this.buffer[0] = (char) c;
    }
    else
    {
      this.buffer[this.buffer.length - this.remaining] = (char) c;
    }
    this.remaining--;

    this.totalLength += 1;
  }

  /*
	 * (non-Javadoc)
	 * 
	 * @see java.io.Writer#write(java.lang.String)
	 */
  public void write(String str)
  {
    write(str, 0, str.length());
  }

  /*
	 * (non-Javadoc)
	 * 
	 * @see java.io.Writer#write(java.lang.String, int, int)
	 */
  public void write(String str, int off, int len)
  {
    if (this.remaining == 0)
    {
      relocate(len);
      str.getChars(off, off + len, buffer, 0);
      this.remaining -= len;
    }
    else
    {
      if (this.remaining >= len)
      {
        str.getChars(off, off + len, buffer, buffer.length - this.remaining);
        this.remaining -= len;
      }
      else
      {
        str.getChars(off, off + this.remaining, buffer, buffer.length - this.remaining);
        int offset = this.remaining;
        relocate(len - offset);
        str.getChars(off + offset, off + len, buffer, 0);
        this.remaining -= len - offset;
      }
    }
    this.totalLength += len;
  }

  public int length()
  {
    return this.totalLength;
  }

  public char[] toCharArray()
  {
    int offset = 0;
    char result[] = new char[this.totalLength];
    if (this.bufferList != null)
     {
      for (int i = 0; i < bufferList.size(); i++)
       {
        char[] b = (char[]) bufferList.get(i);
        System.arraycopy(b, 0, result, offset, b.length);
        offset += b.length;
      }
    }
    if (this.buffer != null)
     {
      System.arraycopy(this.buffer, 0, result, offset, this.buffer.length - this.remaining);
    }
    return result;
  }

  public void writeTo(Writer w)  throws IOException
  {
    if (this.bufferList != null)
    {
      for (int i = 0; i < bufferList.size(); i++)
      {
        w.write((char[]) bufferList.get(i));
      }
    }
    if (this.buffer != null)
    {
      w.write(this.buffer, 0, this.buffer.length - this.remaining);
    }
  }

  private static final String strings[] = { "bb", "jshdfjgsddhhd", "jsghsgdhsgdh", "agshgas", "jsgfdhsdghsgdsddddbxbbbxbyybhfdsghsd", "sjdhaaasjd" };

  private static void test(int n, int count, int initialSize)
  {
    System.out.println("--- Test: n=" + n + "; count=" + count + (initialSize == 0 ? "" : ("; initialSize=" + initialSize)));
    
    // -----------------------------
    {
      long start = System.currentTimeMillis();
      for (int i = 0; i < count; i++)
      {
        StringWriter buf = initialSize == 0 ?  new StringWriter() :  new StringWriter(initialSize) ;
        for (int h = 0; h < n; h++)
        {
          for (int j = 0; j < strings.length; j++)
          {
            buf.write(strings[j]);
          }
        }
        buf.toString().toCharArray();
      }
      System.out.println("Normal: " + (System.currentTimeMillis() - start) + "ms");
      System.gc();
    }
    // -------------------------------------------
    {
      long start = System.currentTimeMillis();
      for (int i = 0; i < count; i++)
      {
        FastStringWriter buf = initialSize == 0 ? new FastStringWriter() : new FastStringWriter(initialSize);
        for (int h = 0; h < n; h++)
        {
          for (int j = 0; j < strings.length; j++)
          {
            buf.write(strings[j]);
          }
        }
        //buf.toCharArray();
      }
      System.out.println("Fast: " + (System.currentTimeMillis() - start) + "ms");
      System.gc();
     }
    // -----------------------------
    {
      long start = System.currentTimeMillis();
      for (int i = 0; i < count; i++)
      {
        StringWriter buf = initialSize == 0 ? new StringWriter() : new StringWriter(initialSize);
        for (int h = 0; h < n; h++)
        {
          for (int j = 0; j < strings.length; j++)
          {
            buf.write(strings[j]);
          }
        }
        //buf.toString().toCharArray();
      }
      System.out.println("Normal: " + (System.currentTimeMillis() - start) + "ms");
      System.gc();
     }
  }

  public static void main(String[] args)
  {
    try
    {
      int n[] = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 1000, 2000, 5000, 10000, 20000 };
      int count = 200000;
      for (int i = 0; i < n.length; i++)
       {
        test(n[i], count/n[i], 0);
      }
      for (int i = 0; i < n.length; i++)
       {
        test(n[i], count/n[i], n[i]*100);
      }
     }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }

  }
}
