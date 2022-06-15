package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteExcelData {
	public static void main(String[] args) throws Throwable  {
	
	FileInputStream f =new FileInputStream("./data/data.xlsx");

	//open the work book 
	Workbook wb = new WorkbookFactory().create(f);
	//control of sheet
	 Sheet s = wb.getSheet("Sheet1");
	
		 Row row = s.getRow(1);
		 Cell cell = row.createCell(5);
		 cell.setCellValue("Krishna");
		 FileOutputStream fos = new FileOutputStream("./data/data.xlsx");
		 wb.write(fos);
		 
	
	wb.close();
	}
}
