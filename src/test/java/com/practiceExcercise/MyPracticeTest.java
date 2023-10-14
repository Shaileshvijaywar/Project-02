package com.practiceExcercise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class MyPracticeTest {
	@Test(groups="RegressionSuite")
	public void date1()
	{
		Date d=new Date();
		System.out.println(d.toString());	
	}
	
	@Test(groups="SmokeSuite")
	public void getSystemInDate()
	{
		Date d=new Date();
		String[] dArr = d.toString().split(" ");
		String day=dArr[2];
		String month=dArr[1];
		String year=dArr[5];
		String time=dArr[3].replace(":", "-");
		String date = day+"-"+month+"-"+year+"--"+time;
	    System.out.println(date);
	}
	@Test(groups="RegressionSuite")
	public void randomnumber()
	{
		Random random=new Random();
		int r = random.nextInt(1000);
		System.out.println(r);
		
	}
	
	@Test(groups="RegressionSuite")
	public void excelRead() throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\October.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Organization");
		Row r = sh.getRow(7);
		Cell c = r.getCell(4);
		String value = c.getStringCellValue();
		System.out.println(value);	
	}
	
	@Test
	public void excelWrite() throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\October.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.createSheet("India");
		Row r = sh.createRow(1);
		Cell c = r.createCell(3);
		c.setCellValue("hi");
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\October.xlsx");
		wb.write(fos);
		wb.close();
	}
	@Test
	public void propertyFile() throws IOException
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\october.properties");
		Properties pObj=new Properties();
		pObj.load(fis);
		String value = pObj.getProperty("url");
		System.out.println(value);
		
	}
	
	@Test(dataProvider="company",groups="RegressionSuite")
	public void dataProvider(String phonename, int price)
	{
		System.out.println(phonename+"---------"+price);
	}
    @DataProvider(name="company")
    public Object[][]  getData()
   {
        Object[][] data=new Object[4][2]; 
                data[0][0]="Iphone";
                data[0][1]=2000;
                data[1][0]="Samsung";
                data[1][1]=1000;
                data[2][0]="philips";
                data[2][1]=800;
                data[3][0]="toshiba";
                data[3][1]=700;
                return data;
   }            
}
