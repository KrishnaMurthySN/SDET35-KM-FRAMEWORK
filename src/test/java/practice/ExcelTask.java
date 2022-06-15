package practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelTask {
	public static void main(String[] args) throws Throwable  {
	
	FileInputStream f =new FileInputStream("./data/data.xlsx");

	//open the work book 
	Workbook wb = new WorkbookFactory().create(f);
	//control of sheet
	 Sheet s = wb.getSheet("Sheet1");
	
	 for(int i=0;i<=2; i++)
	 {
		 
			 Row row = s.getRow(i);
			 for(int j=0 ;j<=2; j++)
			 {
			 Cell cell = row.getCell(j);
			 String value = cell.getStringCellValue();
			 System.out.println(value);  
		     
		 
	 }

	wb.close();
	}
	}
}

