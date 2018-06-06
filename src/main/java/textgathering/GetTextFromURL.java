package textgathering;

import configuration.Configuration;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GetTextFromURL {

   public void putUrlTextToFile(String filePath) {
      Document doc;
      try (BufferedWriter br = new BufferedWriter(new FileWriter(filePath))) {
         Connection.Response html = Jsoup.connect(Configuration.getProperty("URL")).execute();
         doc = html.parse();
         br.write(doc.body().text());
      } catch (IOException ioe) {
         ioe.printStackTrace();
      }
   }
}
