package parser;

import configuration.Configuration;
import utils.FileUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounter {
   private static String word = "";
   private static Pattern ONLY_WORD_CHARACTERS = Pattern.compile("'?\\w[\\w']*(?:-\\w+)*'?");

   public static Map<String, Integer> countSimilarWords(String pathToFile) {
      Map<String, Integer> wordsMap = new HashMap<>();
      List<String> text = FileUtils.getTextFromFile(pathToFile);
      text.forEach(line -> {
         Matcher matcher = ONLY_WORD_CHARACTERS.matcher(line);
         while (matcher.find()) {
            word = matcher.group();
            if (!Boolean.valueOf(Configuration.getCaseSensitivity()))
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
