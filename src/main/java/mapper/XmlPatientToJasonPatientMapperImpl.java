package mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import Enums.Sex;
import Enums.States;
import XmlToJsonProjectException.XmlToJasonConversionProjectException;
import beans.JasonPatient;
import beans.XmlPatients;
import beans.XmlPatients.XmlPatient;

import commonUtilities.AgeCalculatorUtil;

/**
 * It converts XML file associated xmlpatient object into intended jason business object.
 */
public class XmlPatientToJasonPatientMapperImpl implements XmlPatientToJasonPatientMapper
{
   private final static Logger LOG = Logger.getLogger(XmlPatientToJasonPatientMapperImpl.class.getName());

   private final AgeCalculatorUtil ageCalculatorUtil;

   public XmlPatientToJasonPatientMapperImpl(AgeCalculatorUtil ageCalculatorUtil)
   {
      this.ageCalculatorUtil = ageCalculatorUtil;
   }

   @Override
   public List<JasonPatient> mapXmlPatientToJasonPatient(XmlPatients xmlPatients) throws XmlToJasonConversionProjectException
   {
      LOG.info("entering mapXmlPatientToJasonPatient with Xml patient: " + xmlPatients);

      List<JasonPatient> jasonPatients;
      if (xmlPatients.getPatient() == null || xmlPatients.getPatient().isEmpty())
      {
         jasonPatients = null;
      }
      else
      {
         jasonPatients = new ArrayList<JasonPatient>(xmlPatients.getPatient().size());
         for (XmlPatient xmlPatient : xmlPatients.getPatient())
         {
            JasonPatient jasonPatient = new JasonPatient();
            jasonPatient.setName(xmlPatient.getName());
            jasonPatient.setPatientId(xmlPatient.getId());
            jasonPatient.setSex(getPatientSex(xmlPatient.getGender()));
            jasonPatient.setState(getPatientState(xmlPatient.getState()));
            jasonPatient.setAge(ageCalculatorUtil.calculateAgeUsingDob(xmlPatient.getDob()));

            jasonPatients.add(jasonPatient);
         }
      }

      LOG.info("leaving mapXmlPatientToJasonPatient with jason patient: " + jasonPatients);
      return jasonPatients;
   }

   private String getPatientSex(String sex)
   {
      return Sex.valueOfName(sex).getSex();
   }

   private String getPatientState(String state)
   {
      return States.valueOfName(state).getAbbreviation();
   }
}
