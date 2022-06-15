package practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcelData {
	public static void main(String[] args) throws Throwable  {
	
	FileInputStream f =new FileInputStream("./data/data.xlsx");

	//open the work book 
	Workbook wb = new WorkbookFactory().create(f);
	//control of sheet
	 String url = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
	 //for(i=0;i<=sheet1.getL; i++)
	System.out.println(url);
	String un = wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
	System.out.println(un);
	String pwd = wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
	System.out.println(pwd);
	
	wb.close();
	}
}
