import configuration.Configuration;
import excel.ExcelUtil;
import parser.WordCounter;
import textgathering.GetTextFromURL;

import java.util.Map;

public class Main {

   public static void main(String[] args) {
      String pathToFile = System.getenv("ROOT_PROJECT_DIR")+ Configuration.getProperty("fileToWriteTextPath");
      new GetTextFromURL().putUrlTextToFile(pathToFile);
      Map<String, Integer> words = WordCounter.countSimilarWords(pathToFile);
      ExcelUtil.writeResultsToExcelFile(words);
   }
}
