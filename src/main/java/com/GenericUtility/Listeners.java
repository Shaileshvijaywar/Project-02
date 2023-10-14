package com.GenericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Listeners implements ITestListener{
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String MethodName = result.getMethod().getMethodName();
		System.out.println(MethodName+"----"+"Test Script Execution started ");
		test=report.createTest(MethodName);
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		JavaUtility jUtil=new JavaUtility();
		WebDriverUtility wUtil=new WebDriverUtility();
		
		String MethodName = result.getMethod().getMethodName();
		//System.out.println(MethodName+"----"+"Test Script is pass ");
		
		test.log(Status.PASS, MethodName+"----"+"Test Script is pass ");
        
		String ScreenshotName = MethodName+"---"+jUtil.getSystemDateInFormat();
		
		try {
			//wUtil.screenShot(BaseClass.sDriver, ScreenshotName);
			String Path = wUtil.screenShot(BaseClass.sDriver, ScreenshotName);
			test.addScreenCaptureFromPath(Path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		JavaUtility jUtil=new JavaUtility();
		WebDriverUtility wUtil=new WebDriverUtility();
		
		String MethodName = result.getMethod().getMethodName();
		//System.out.println(MethodName+"----"+"Test Script is fail ");
		
		test.log(Status.FAIL, MethodName+"----"+"Test Script is fail ");
		test.log(Status.INFO, result.getThrowable());
		
		String ScreenshotName = MethodName+"---"+jUtil.getSystemDateInFormat();
		
		try {
			//wUtil.screenShot(BaseClass.sDriver, ScreenshotName);
			String Path = wUtil.screenShot(BaseClass.sDriver, ScreenshotName);
			test.addScreenCaptureFromPath(Path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String MethodName = result.getMethod().getMethodName();
		//System.out.println(MethodName+"----"+"Test Script is skip ");
		
		test.log(Status.SKIP, MethodName+"----"+"Test Script is skip ");
		
	}
		
	

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Suite execution started");
		
		ExtentSparkReporter htmlReports=new ExtentSparkReporter(".\\ExtentReport\\Report-"+new JavaUtility().getSystemDateInFormat());
		htmlReports.config().setDocumentTitle("Project1 Execution Reports");
		htmlReports.config().setTheme(Theme.DARK);
		htmlReports.config().setReportName("PROJECT1 Execution");
		
	    report=new ExtentReports();
		report.attachReporter(htmlReports);
		report.setSystemInfo("Base URL", "https//localhost:8888");
		report.setSystemInfo("Base Browser", "Firefox");
		report.setSystemInfo("Reporter Name", "shailesh");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("suite finished");
		report.flush();
	}
	
	

}
