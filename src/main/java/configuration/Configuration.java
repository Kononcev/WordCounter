package configuration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configuration extends Properties {

   private static Properties prop = new Properties();

   static {
      try {
         prop.load(Configuration.class.getClassLoader().getResourceAsStream("config.properties"));
      } catch (FileNotFoundException e) {
         System.err.println("File not found");
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public static String getTxtFilePath() {
      return prop.getProperty("fileToWriteTextPath");
   }

   public static String getExcelFilePath() {
      return prop.getProperty("excelFilePath");
   }

   public static String getURL() {
      return prop.getProperty("URL");
   }

   public static String getEncoding() {
      return prop.getProperty("encoding");
   }

   public static String getCaseSensitivity() {
      return prop.getProperty("caseSensitivity");
   }

   @Override
   public String getProperty(String key) {
      String property = System.getenv(key);
      if (property == null) property = System.getProperty(key);
      return property == null ? prop.getProperty(key) : property;
   }
}
