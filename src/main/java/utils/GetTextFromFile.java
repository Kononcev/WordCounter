package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class GetTextFromFile {
   public static List<String> getTextFromFile(File file){
      List<String> lines = new ArrayList<>();
      try {
         lines = Files.readAllLines(file.toPath());
      } catch (IOException e) {
         e.printStackTrace();
      }
      return lines;
   }
}
