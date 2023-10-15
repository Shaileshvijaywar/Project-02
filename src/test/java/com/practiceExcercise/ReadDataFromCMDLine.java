package com.practiceExcercise;

import org.testng.annotations.Test;

public class ReadDataFromCMDLine {

	@Test
	public void readData()
	{
		String Bvalue = System.getProperty("browser");
		System.out.println(Bvalue);
		
		String Uvalue = System.getProperty("url");
		System.out.println(Uvalue);
		
		String Pvalue01 = System.getProperty("password");
		System.out.println(Pvalue01);
	}
}
