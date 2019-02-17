package conversion;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import mapper.XmlPatientToJasonPatientMapperImpl;
import beans.XmlPatients;

import com.fasterxml.jackson.databind.ObjectMapper;

import commonUtilities.AgeCalculatorUtil;
import commonUtilities.ReadWriteFileUtility;

public class ConvertXmlToJasonFactory
{
   private static ConvertXmlToJason convertXmlToJasonInstance;

   private ConvertXmlToJasonFactory()
   {
   }

   public static ConvertXmlToJason createInstance() throws JAXBException
   {
      if (convertXmlToJasonInstance == null)
      {
         convertXmlToJasonInstance = new ConvertXmlToJasonImpl(JAXBContext.newInstance(XmlPatients.class),
               new ReadWriteFileUtility(), new ObjectMapper(), new XmlPatientToJasonPatientMapperImpl(
                     new AgeCalculatorUtil()));
      }
      return convertXmlToJasonInstance;
   }
}
