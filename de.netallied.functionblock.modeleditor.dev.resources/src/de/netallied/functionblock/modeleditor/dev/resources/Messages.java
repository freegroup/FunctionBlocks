/*
 * Created on 24.01.2007
 *
 */
package de.netallied.functionblock.modeleditor.dev.resources;
import org.eclipse.osgi.util.NLS;
public class Messages extends NLS
{
  private static final String BUNDLE_NAME = "de.netallied.functionblock.modeleditor.dev.resources.messages"; //$NON-NLS-1$
  public static String Editor_Comment;
  public static String Editor_Add;
  public static String Editor_Delete;
  public static String Editor_Name;
  public static String Editor_Type;
  public static String Editor_Resource;
  static
  {
    // initialize resource bundle
    NLS.initializeMessages(BUNDLE_NAME, Messages.class);
  }

  private Messages()
  {
  }
}
