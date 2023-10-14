package com.GenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelUtility {
	/**
	 * This method will read the data from excel file/sheet
	 * @param Sheet
	 * @param RowNum
	 * @param CellNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String excelRead(String Sheet, int RowNum, int CellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(CommonFilePath.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(Sheet);
		Row r = sh.getRow(RowNum);
	    Cell c = r.getCell(CellNum);
	    String value = c.getStringCellValue();
	    return value;
	}
	/**
	 * This method will write the data in excel sheet/file
	 * @param Sheet1
	 * @param RowNum
	 * @param CellNum
	 * @param value
	 * @throws IOException
	 */
	
	public void excelWrite(String Sheet1, int RowNum, int CellNum, String value) throws IOException
	{
		FileInputStream fis=new FileInputStream(CommonFilePath.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.createSheet(Sheet1);
	    Row r = sh.createRow(RowNum);
	    Cell c = r.createCell(CellNum);
	    c.setCellValue(value);
		FileOutputStream fos=new FileOutputStream(CommonFilePath.excelFilePath);
		wb.write(fos);
		wb.close();
		
	}
	
	public Object[][] readMultipleDataFromExcel(String sheet) throws EncryptedDocumentException, IOException
	{
	FileInputStream fis=new FileInputStream(CommonFilePath.excelFilePath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheet);
	int LastRow = sh.getLastRowNum();
	int LastCell = sh.getRow(0).getLastCellNum();
	
	Object[][] data = new Object[LastRow][LastCell];
	
	for(int i=0;i<LastRow;i++)
	{
		for(int j=0;j<LastCell;j++) 
		{
			data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
		}
	}
	return data;
	}
   
}
