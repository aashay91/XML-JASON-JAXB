package mapper;

import java.util.List;

import XmlToJsonProjectException.XmlToJasonConversionProjectException;
import beans.JasonPatient;
import beans.XmlPatients;

/**
 * Interface has method to map Xml patient object into jason patient object in order to store into
 * jason file.
 */
public interface XmlPatientToJasonPatientMapper
{
   List<JasonPatient> mapXmlPatientToJasonPatient(XmlPatients xmlPatients) throws XmlToJasonConversionProjectException;
}
