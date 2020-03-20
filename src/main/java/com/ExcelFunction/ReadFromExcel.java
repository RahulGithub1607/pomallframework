package com.ExcelFunction;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromExcel {
	
	public String readExcel(int row, int col, String FileName,String SheetName) throws IOException
	{
		File file =new File(FileName);
		
		FileInputStream input_stream =new FileInputStream(file);
				
		XSSFWorkbook excel_workbook =new XSSFWorkbook(input_stream);
		
		XSSFSheet excelsheet  = excel_workbook.getSheet(SheetName);
		
		String cell_value =excelsheet.getRow(row).getCell(col).getStringCellValue().toString();
		
		excel_workbook.close();
		
		return cell_value; //add return string fetched value
	}

}
