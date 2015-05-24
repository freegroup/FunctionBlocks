package de.netallied.functionblock.util.xml;

import java.io.IOException;
import java.net.URL;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

//Einfache eigene Implementierung eines EntityResolvers
public class EntityResolver implements org.xml.sax.EntityResolver 
{
  private final static String LIB_DTD  = "LibraryElement.dtd";
  private final static String TYPE_DTD = "DataType.dtd";
  final static String SYSTEM_ID_START = "http://www.holobloc.com/xml/";
  
	public final static EntityResolver RESOLVER = new EntityResolver();

	public EntityResolver() 
	{
	}

	public InputSource resolveEntity(String pub, String sys)throws SAXException, IOException 
	{
		if (sys != null && sys.endsWith(LIB_DTD)) 
		{
			SAXParserFactory parserFactory = SAXParserFactory.newInstance();

			parserFactory.setValidating(false);
			parserFactory.setNamespaceAware(true);
			URL jarPath = getClass().getResource( LIB_DTD);
			return jarPath != null ? new InputSource(jarPath.toString()) : null;
		} 
		else
			return null;
	}
}
