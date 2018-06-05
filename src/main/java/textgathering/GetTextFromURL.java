package textgathering;

import configuration.Configuration;
import org.apache.commons.io.FileUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;

public class GetTextFromURL {

   public File putUrlTextToFile() {
      File input = new File(System.getenv("ROOT_PROJECT_DIR")+Configuration.getProperty("fileToWriteTextPath"));
      Document doc;
      try {
         input.createNewFile();
         Connection.Response html = Jsoup.connect(Configuration.getProperty("URL")).execute();
         doc = html.parse();
         FileUtils.writeStringToFile(input, doc.body().text(), Configuration.getProperty("encoding"));
      } catch (IOException ioe) {
         ioe.printStackTrace();
      }
      return input;
   }
}
