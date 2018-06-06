package utils;

import configuration.Configuration;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
   public static List<String> getTextFromFile(String pathToFile) {
      List<String> lines = new ArrayList<>();
      try {
         lines = Files.readAllLines(FileSystems.getDefault().getPath(pathToFile));
      } catch (IOException e) {
         e.printStackTrace();
      }
      return lines;
   }

   public static void putUrlTextToFile(String filePath) {
      Document doc;
      try (BufferedWriter out = Files.newBufferedWriter(Paths.get(filePath), StandardCharsets.UTF_8)) {
         Connection.Response html = Jsoup.connect(Configuration.getURL()).execute();
         doc = html.parse();
         out.write(doc.body().text());
      } catch (IOException ioe) {
         ioe.printStackTrace();
      }
   }
}
