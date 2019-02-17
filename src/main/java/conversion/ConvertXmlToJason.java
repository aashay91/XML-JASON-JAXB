
package conversion;

import XmlToJsonProjectException.XmlToJasonConversionProjectException;
/**
 * 
 * Interface have method to convert XML file into Jason file format.
 *
 */
public interface ConvertXmlToJason
{
   void convertXmlToJason(String inputFileName, String outputFileName) throws XmlToJasonConversionProjectException;;
}
