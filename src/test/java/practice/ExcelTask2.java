package practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelTask2 {
	public static void main(String[] args) throws Throwable  {

		FileInputStream f =new FileInputStream("./data/data.xlsx");


		Workbook wb = new WorkbookFactory().create(f);
		Sheet s = wb.getSheet("Sheet1");
		Row row = s.getRow(1);
		String actual="admin";
		for(int i=0;i<2; i++)
		{
			Cell cell = row.getCell(i);
			String value = cell.getStringCellValue();
			if(actual.equalsIgnoreCase(value))
			{
				Row row1 = s.getRow(1);
				Cell cell1 = row1.getCell(i+1);
				String value1 = cell1.getStringCellValue();
				System.out.println(value1);

			}

			wb.close();
		}
	}
}

