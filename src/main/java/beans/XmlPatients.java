package beans;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This bean stores unmarshalled XML patient information. 
 * 
 */
@XmlRootElement(name = "patients")
public class XmlPatients
{
   @Override
   public String toString()
   {
      return "Patients [Patient=" + Patient + "]";
   }

   public List<XmlPatient> getPatient()
   {
      return Patient;
   }

   @XmlElement(name = "patient")
   public void setPatient(List<XmlPatient> patient)
   {
      Patient = patient;
   }

   List<XmlPatient> Patient;
   
   public static class XmlPatient
   {
      private int id;
      private String name;
      private String state;
      private String gender;
      private String dateOfBirth;

      public String getDob()
      {
         return dateOfBirth;
      }

      @XmlElement(name = "dob")
      public void setDob(String dob)
      {
         this.dateOfBirth = dob;
      }

      public String getGender()
      {
         return gender;
      }

      @XmlElement(name = "gender")
      public void setGender(String gender)
      {
         this.gender = gender;
      }

      public int getId()
      {
         return id;
      }

      @XmlElement(name = "id")
      public void setId(int id)
      {
         this.id = id;
      }

      public String getName()
      {
         return name;
      }

      @XmlElement(name = "name")
      public void setName(String name)
      {
         this.name = name;
      }

      public String getState()
      {
         return state;
      }

      @XmlElement(name = "state")
      public void setState(String state)
      {
         this.state = state;
      }

      @Override
      public String toString()
      {
         return "XmlPatient [id=" + id + ", name=" + name + ", state=" + state + ", gender=" + gender + ", dateOfBirth="
               + dateOfBirth + "]";
      }
   }
}