package commonUtilities;

import XmlToJsonProjectException.XmlToJasonConversionProjectException;

public class VerifyUtil
{
   public static void verifyString(String input, String exceptionMessage) throws XmlToJasonConversionProjectException
   {
      if (input == null || input == "" || input == " ")
      {
         throw new XmlToJasonConversionProjectException(exceptionMessage);
      }
   }
}
