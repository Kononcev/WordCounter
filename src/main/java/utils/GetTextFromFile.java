package utils;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class GetTextFromFile {
   public static List<String> getTextFromFile(String pathToFile){
      List<String> lines = new ArrayList<>();
      try {
         lines = Files.readAllLines(FileSystems.getDefault().getPath(pathToFile));
      } catch (IOException e) {
         e.printStackTrace();
      }
      return lines;
   }
}
