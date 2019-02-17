package commonUtilities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Logger;

import XmlToJsonProjectException.XmlToJasonConversionProjectException;

/**
 * Utility class has functionality to calculate age from date of birth.
 */
public class AgeCalculatorUtil
{
   private final static Logger LOG = Logger.getLogger(AgeCalculatorUtil.class.getName());

   /**
    * @param dob
    *           in dd/MM/yyyy format
    * @return int age
    * @throws XmlToJasonConversionProjectException
    */
   public int calculateAgeUsingDob(String dob) throws XmlToJasonConversionProjectException
   {
      LOG.info("entering calculateAgeUsingDob with string date of birth: " + dob);

      DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

      Calendar calenarDob = Calendar.getInstance();
      try
      {
         calenarDob.setTime(formatter.parse(dob));
      }
      catch (ParseException e)
      {
         throw new XmlToJasonConversionProjectException("Invalid input DOB enter into dd/MM/yyyy format.");
      }

      Calendar today = Calendar.getInstance();
      int curYear = today.get(Calendar.YEAR);
      int dobYear = calenarDob.get(Calendar.YEAR);

      int age = curYear - dobYear;
      int curMonth = today.get(Calendar.MONTH);

      int dobMonth = calenarDob.get(Calendar.MONTH);

      if (dobMonth > curMonth)
      {
         age--;
      }
      else if (dobMonth == curMonth)
      {
         int curDay = today.get(Calendar.DAY_OF_MONTH);
         int dobDay = calenarDob.get(Calendar.DAY_OF_MONTH);
         if (dobDay > curDay)
         {
            age--;
         }
      }

      LOG.info("leaving calculateAgeUsingDob with calculated age: " + age);
      return age;
   }
}
