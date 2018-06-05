package configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
   private static Properties prop = new Properties();

   static {
      try(InputStream input = new FileInputStream("C:\\Users\\Volodymyr_konontsev\\IdeaProjects\\WordCounter\\src\\main\\resources\\config.properties")) {
         prop.load(input);
      } catch (FileNotFoundException e) {
         System.out.println("File not found");
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public static String getProperty(String key){
      return prop.getProperty(key);
   }
}
