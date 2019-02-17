package Enums;

/**
 * Gender enum
 */
public enum Sex
{

   /**
    * Male
    */
   M("Male"),

   /**
    * Female
    */
   F("Female"),

   /**
    * Not Specified or Unknown
    */
   U("Unknown");

   private Sex(String sex)
   {
      this.sex = sex;
   }

   public String getSex()
   {
      return sex;
   }

   public static Sex valueOfName(final String sex)
   {
      final String enumName = sex.toUpperCase();
      try
      {
         return valueOf(enumName);
      }
      catch (final IllegalArgumentException e)
      {
         return Sex.U;
      }
   }

   private String sex;

   public String value()
   {
      return name();
   }

   public static Sex fromValue(String v)
   {
      return valueOf(v);
   }
}
