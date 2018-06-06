import configuration.Configuration;
import parser.WordCounter;
import utils.ExcelUtil;
import utils.FileUtils;

import java.util.Map;

public class Main {

   public static void main(String[] args) {
      String pathToFile = System.getProperty("user.dir") + Configuration.getTxtFilePath();
      FileUtils.putUrlTextToFile(pathToFile);
      Map<String, Integer> words = WordCounter.countSimilarWords(pathToFile);
      ExcelUtil.writeResultsToExcelFile(words);
   }
}
