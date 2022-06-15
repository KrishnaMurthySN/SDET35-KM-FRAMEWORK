package com.crm.comcast.generic_utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utilities {
	
	public String getExcelData(String sheetName,int rowNum,int cellNum) throws Throwable {
		
		FileInputStream fis =new FileInputStream("./data/data.xlsx");

		Workbook wb = new WorkbookFactory().create(fis);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).toString();
		return data;
		
		
//		 DataFormatter format = new DataFormatter();
//		String value = format.formatCellValue(wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum));
//		return value;
		 
	}

}
