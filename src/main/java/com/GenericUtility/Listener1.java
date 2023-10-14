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

public class Listener1 implements ITestListener {
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String MethodName = result.getMethod().getMethodName();
		System.out.println(MethodName+"---Test Started");
		
		test=report.createTest(MethodName);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		WebDriverUtility wUtil=new WebDriverUtility();
		JavaUtility jUtil=new JavaUtility();
		String MethodName = result.getMethod().getMethodName();
		System.out.println(MethodName+"Test Script Results Pass");
		test.log(Status.PASS, MethodName+"Test Script Results Pass");
		String ScreenshotName = MethodName+jUtil.getSystemDateInFormat();
		
		try {
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
		WebDriverUtility wUtil=new WebDriverUtility();
		JavaUtility jUtil=new JavaUtility();
		String MethodName = result.getMethod().getMethodName();
		System.out.println(MethodName+"Test Script Results Fail");
		test.log(Status.FAIL, MethodName+"Test Script Results Fail");
		test.log(Status.INFO, result.getThrowable());
		
		String ScreenshotName = MethodName+jUtil.getSystemDateInFormat();
		
		try {
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
		WebDriverUtility wUtil=new WebDriverUtility();
		JavaUtility jUtil=new JavaUtility();
		String MethodName = result.getMethod().getMethodName();
		System.out.println(MethodName+"Test Script Results Skipped");
		test.log(Status.SKIP, MethodName+"Test Script Results skipped");
		
		String ScreenshotName = MethodName+jUtil.getSystemDateInFormat();
		
		try {
			String Path = wUtil.screenShot(BaseClass.sDriver, ScreenshotName);
			test.addScreenCaptureFromPath(Path);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Suite Execeution Started");
		
		ExtentSparkReporter htmlReport=new ExtentSparkReporter(".\\ExtentReport\\Report-"+new JavaUtility().getSystemDateInFormat());
		htmlReport.config().setDocumentTitle("Project 01 Report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("Project02");
		
		        report=new ExtentReports();
				report.attachReporter(htmlReport);
		        report.setSystemInfo("Base Browser", "Chrome");
		        report.setSystemInfo("Base Url", "https://Google.com");
		        report.setSystemInfo("ReporterName", "Shailesh");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Suite Execeution Finished");
		report.flush();
		
	}
	
	
	
	

}
