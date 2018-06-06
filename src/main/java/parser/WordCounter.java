package parser;

import configuration.Configuration;
import constant.Constants;
import utils.GetTextFromFile;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;

public class WordCounter {
   private static String word = "";

   public static Map<String, Integer> countSimilarWords(String pathToFile) {
      Map<String, Integer> wordsMap = new HashMap<>();
      List<String> text = GetTextFromFile.getTextFromFile(pathToFile);
      text.forEach(line -> {
         Matcher matcher = Constants.ONLY_WORD_CHARACTERS.matcher(line);
         while (matcher.find()) {
            word = matcher.group();
            if (!Boolean.valueOf(Configuration.getProperty("caseSensitivity")))
               word = matcher.group().toLowerCase();
            if (wordsMap.keySet().contains(word)) {
               Integer wordCount = wordsMap.get(word);
               wordsMap.put(word, ++wordCount);
            } else
               wordsMap.put(word, 1);
         }
      });
      return wordsMap;
   }
}
