import excel.ExcelUtil;
import parser.WordCounter;
import textgathering.GetTextFromURL;

import java.util.Map;

public class Main {

   public static void main(String[] args) {
      Map<String, Integer> words = WordCounter.countSimilarWords(new GetTextFromURL().putUrlTextToFile());
      ExcelUtil.writeResultsToExcelFile(words);
   }
}
