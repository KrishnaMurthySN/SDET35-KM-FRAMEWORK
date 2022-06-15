package practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcelData2 {
	public static void main(String[] args) throws Throwable  {
	
	FileInputStream f =new FileInputStream("./data/data.xlsx");

	//open the work book 
	Workbook wb = new WorkbookFactory().create(f);
	//control of sheet
	 Sheet s = wb.getSheet("Sheet1");
	 for(int i=0;i<=s.getLastRowNum(); i++)
	 {
		 Row row = s.getRow(i);
		 Cell cell = row.getCell(0);
		 String value = cell.getStringCellValue();
		 System.out.println(value);
		 
	 }
//	System.out.println(url);
//	String un = wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
//	System.out.println(un);
//	String pwd = wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
//	System.out.println(pwd);
	
	wb.close();
	}
}
