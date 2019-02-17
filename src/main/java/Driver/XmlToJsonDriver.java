package Driver;

import conversion.ConvertXmlToJason;
import conversion.ConvertXmlToJasonFactory;

public class XmlToJsonDriver
{
   private static final String INPUT_XML_FILE = "data.xml";
   private static final String OUTPUT_JASON_FILE = "jason";

   public static void main(String[] args) throws Exception
   {
      ConvertXmlToJason convertXmlToJason = ConvertXmlToJasonFactory.createInstance();
      convertXmlToJason.convertXmlToJason(INPUT_XML_FILE, OUTPUT_JASON_FILE);
   }
}
