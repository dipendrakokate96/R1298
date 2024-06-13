package UtilityStudy;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Utility 
{  static Sheet MySheet;
   public static String getDataFromExcel(int rowindex,int cellindex) throws EncryptedDocumentException, IOException
   {
	   FileInputStream MyFile = new FileInputStream("C:\\Selenium\\Excel\\Book1.Xlsx");
	    MySheet = WorkbookFactory.create(MyFile).getSheet("Sheet3");
	     String value = MySheet.getRow(rowindex).getCell(cellindex).getStringCellValue();
	     return value;
   }
  
}
