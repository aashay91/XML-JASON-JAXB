package commonUtilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

import XmlToJsonProjectException.XmlToJasonConversionProjectException;

/**
 * Utility class to read given file from resources package.
 */
public class ReadWriteFileUtility
{
   private final static Logger LOG = Logger.getLogger(ReadWriteFileUtility.class.getName());
   private final static String seperator = File.separator;
   public final static String RESOURCE_DIRECTORY = "src" + seperator + "main" + seperator + "resources" + seperator;

   /**
    * @param fileName
    *           input file name.
    * @return file content in string format.
    * @throws XmlToJasonConversionProjectException
    */
   public String readFile(String fileName) throws XmlToJasonConversionProjectException
   {
      LOG.info("entering readFile to read file: " + fileName);

      StringBuilder fileContent;
      BufferedReader br;
      try
      {
         br = new BufferedReader(new FileReader(fileName));
         String line;
         fileContent = new StringBuilder();
         while ((line = br.readLine()) != null)
         {
            fileContent.append(line);
         }
      }
      catch (IOException e)
      {
         throw new XmlToJasonConversionProjectException("Error while reading input file" + fileName);
      }

      LOG.info("leaving readFile with file content: " + fileContent.toString());
      return fileContent.toString();
   }
}
