package utils;

import configuration.Configuration;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

public class ExcelUtil {
   private static XSSFWorkbook workbook = new XSSFWorkbook();
   private static int rowNum = 0;

   public static void writeResultsToExcelFile(Map<String, Integer> words) {
      try (FileOutputStream out = new FileOutputStream(new File(System.getProperty("user.dir")+Configuration.getExcelFilePath()))) {
         workbook.createSheet();
         XSSFSheet sheet = workbook.getSheetAt(0);

         words.forEach((key, value) -> {
            int cellNum = 0;
            XSSFRow row = sheet.createRow(rowNum++);
            Cell cellKey = row.createCell(cellNum);
            Cell cellValue = row.createCell(++cellNum);
            if (null != cellKey) {
               cellKey.setCellValue(key);
               cellValue.setCellValue(value);
            }
         });

         workbook.write(out);
      } catch (IOException e) {
         e.printStackTrace();
      }

   }
}
