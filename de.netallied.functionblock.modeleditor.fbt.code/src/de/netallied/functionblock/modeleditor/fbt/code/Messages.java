/*
 * Created on 30.01.2007
 *
 */
package de.netallied.functionblock.modeleditor.fbt.code;
import org.eclipse.osgi.util.NLS;
public class Messages extends NLS
{
  private static final String BUNDLE_NAME = "de.netallied.functionblock.modeleditor.fbt.code.messages"; //$NON-NLS-1$
  public static String Editor_Code;
  public static String Editor_Delete;
  public static String Editor_Name;
  public static String Editor_New;
  public static String Editor_Title;
  public static String Editor_Type;
  static
  {
    // initialize resource bundle
    NLS.initializeMessages(BUNDLE_NAME, Messages.class);
  }

  private Messages()
  {
  }
}
