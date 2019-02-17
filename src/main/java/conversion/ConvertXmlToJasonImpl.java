package conversion;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import mapper.XmlPatientToJasonPatientMapperImpl;
import XmlToJsonProjectException.XmlToJasonConversionProjectException;
import beans.JasonPatient;
import beans.XmlPatients;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.logging.Logger;
import commonUtilities.VerifyUtil;
import commonUtilities.ReadWriteFileUtility;

/**
 * This class implements the business logic to convert xml file into jason file format.
 * 
 * @author [System Integration]
 */
public class ConvertXmlToJasonImpl implements ConvertXmlToJason
{
   private final static Logger LOG = Logger.getLogger(ConvertXmlToJasonImpl.class.getName());
   private final JAXBContext jaxbContext;
   private final ReadWriteFileUtility fileUtility;
   private final ObjectMapper jasonObjectMapper;
   private final XmlPatientToJasonPatientMapperImpl xmlPatientToJasonPatientMapper;

   public ConvertXmlToJasonImpl(JAXBContext jaxbContext, ReadWriteFileUtility fileUtility, ObjectMapper jasonObjectMapper,
         XmlPatientToJasonPatientMapperImpl xmlPatientToJasonPatientMapper)
   {
      this.jaxbContext = jaxbContext;
      this.fileUtility = fileUtility;
      this.jasonObjectMapper = jasonObjectMapper;
      this.xmlPatientToJasonPatientMapper = xmlPatientToJasonPatientMapper;
   }

   @Override
   public void convertXmlToJason(final String inputFileName, final String outPutFileName)
         throws XmlToJasonConversionProjectException
   {
      LOG.info("entering into convertXmlToJason");
      
      VerifyUtil.verifyString(inputFileName, "Invalid input file name");
      VerifyUtil.verifyString(outPutFileName, "Invalid outpuf file name");

      XmlPatients xmlPatients = convertXmlToXmlPatients(inputFileName);
      List<JasonPatient> jasonPatients = xmlPatientToJasonPatientMapper.mapXmlPatientToJasonPatient(xmlPatients);
      convertJasonPatientToJasonFile(jasonPatients, outPutFileName);

      LOG.info("Leaving convertXmlToJason check file: " + ReadWriteFileUtility.RESOURCE_DIRECTORY + outPutFileName);
   }

   protected XmlPatients convertXmlToXmlPatients(String inputFileName) throws XmlToJasonConversionProjectException
   {
      LOG.info("entering into convertXmlToXmlPatients");

      XmlPatients xmlPatients = null;
      try
      {
         Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
         String xmlFileContent = fileUtility.readFile(ReadWriteFileUtility.RESOURCE_DIRECTORY + inputFileName);
         xmlPatients = (XmlPatients) jaxbUnmarshaller.unmarshal(new StringReader(xmlFileContent));
      }
      catch (JAXBException e)
      {
         throw new XmlToJasonConversionProjectException("Error occured while unmarshaling XML" + e);
      }

      LOG.info("Leaving convertXmlToXmlPatients with XmlPatient" + xmlPatients);
      return xmlPatients;
   }

   protected void convertJasonPatientToJasonFile(Object jasonPatients, String outPutFileName)
         throws XmlToJasonConversionProjectException
   {
      LOG.info("entering into convertJasonPatientToJasonFile with jason object: " + jasonPatients);

      try
      {
         jasonObjectMapper.writerWithDefaultPrettyPrinter().writeValue(
               new File(ReadWriteFileUtility.RESOURCE_DIRECTORY + outPutFileName), jasonPatients);
      }
      catch (IOException e)
      {
         throw new XmlToJasonConversionProjectException("Error occured while marshaling object into jason file" + e);
      }

      LOG.info("Leaving convertJasonPatientToJasonFile ");
   }
}
