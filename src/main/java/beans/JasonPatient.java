package beans;

/**
 * Bean class to store patient data and used to marshal into jason format file.
 */
public class JasonPatient
{
   private int patientId;
   private String name;
   private String state;
   private String sex;
   private int age;

   public int getPatientId()
   {
      return patientId;
   }

   public void setPatientId(int patientId)
   {
      this.patientId = patientId;
   }

   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public String getState()
   {
      return state;
   }

   public void setState(String state)
   {
      this.state = state;
   }

   public String getSex()
   {
      return sex;
   }

   public void setSex(String sex)
   {
      this.sex = sex;
   }

   public int getAge()
   {
      return age;
   }

   public void setAge(int age)
   {
      this.age = age;
   }

   @Override
   public String toString()
   {
      return "JasonPatient [patientId=" + patientId + ", name=" + name + ", state=" + state + ", sex=" + sex + ", age=" + age + "]";
   }

}
