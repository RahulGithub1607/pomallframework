package com.ReportsUtility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentsReport {
	ExtentReports ex_report;
	ExtentTest ex_logger;
	
	
	public void setUpReport()
	{
		ex_report =new ExtentReports(System.getProperty("user.dir") +"/test-output/ExecutionReport.html", true);		
	}

	
	public void StartTestCase(String TestCaseName)
	{
		ex_logger =ex_report.startTest(TestCaseName);
		
	}
	
	public void logEventPass(String Value)
	{
		ex_logger.log(LogStatus.PASS, Value);
		
	}
	public void logEvenetFail (String Value)
	{
		ex_logger.log(LogStatus.FAIL, Value);
		
	}
	
	public void craeteFinalReport()
	{
		
		ex_report.flush();
	}
	
		
	
	
}