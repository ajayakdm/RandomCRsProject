package com.courseFlow;


import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class TestCasesForCourseFlowLessthan50 extends BaseClass
{

AllPageElements elements;
public ExtentHtmlReporter htmlReporter;
public ExtentReports extent;
public ExtentTest extentTest;
//ReadConfigData readConfig;

@BeforeClass
public void beforeClass() 
{
	Date d=new Date();

	htmlReporter=new ExtentHtmlReporter("./TestCaseReports/CourseId-4623<50(Prod).html");
	htmlReporter.config().setEncoding("utf-8");
	htmlReporter.config().setDocumentTitle("Automation");
	htmlReporter.config().setReportName("Automation Test Result for ID 4623(Prod)");
	htmlReporter.config().setTheme(Theme.DARK);
	
	extent =new ExtentReports();
	extent.setSystemInfo("Course ID", "42623(Prod)");
	extent.setSystemInfo("Browser", "Chrome");
	extent.attachReporter(htmlReporter);
	
}

@AfterClass
public void afterClass()
{
	//driver.quit();
	extent.flush();
}
	
	@Parameters({"un","pw"})
	
	@Test (priority=1)
	public void LoginIntoCourse(String un, String pw) throws Exception 
	{
		driver.get("https://www.cogbooks.com/sign-in.html");
		elements=new AllPageElements(driver);
		elements.enterUserName(un);
		elements.enterPassword(pw);
		elements.clickOnLoginButton();
		 Thread.sleep(3000);
		 elements.start4623();
		  Thread.sleep(3000);
		  Set<String> allWindows = driver.getWindowHandles();
		 ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
	     //switch to new tab
		 
	     //driver.switchTo().window(newTb.get(1));
	    // Thread.sleep(2000);
		  
		// driver.get("https://www.cogbooks.com/communicog/handler?action=courseBranding&COURSEID=4232");
		 System.out.println(driver.getTitle());
		 Thread.sleep(2000);
		 elements.startTheClass();
		 
		extentTest=extent.createTest("loginLearner");
		extentTest.log(Status.INFO, "Executing the test case......");
		extentTest.log(Status.PASS,"Learner logged in into production server succesfully");
	}
	
	@Test (priority = 2)
	public void startCourseFlow() throws Exception 
	{
		elements=new AllPageElements(driver);
		/*
		 * ExcelData exl=new ExcelData(); PrintScreen scr= new PrintScreen(); LTIPage
		 * ltiPage=new LTIPage(driver);
		 */
		
		//ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		extentTest=extent.createTest("CourseFlow");
		extentTest.log(Status.INFO, "Executing the test case......");
		extentTest.log(Status.INFO, MarkupHelper.createLabel("Doing Learner Flow for course id 4232.....", ExtentColor.GREEN));
		 int n=0;
	for (int i = 1; i <= 60; i++) {
			n=i;
			Thread.sleep(4000);
			
			try		{
					elements.moveSliderBarLessthan50();
					Thread.sleep(3000);
				
				try {
					elements.skipAndStartNextTopic();
					Thread.sleep(3000);
					}
			   catch (Exception e3) 
					{
				   elements.clickOnReview();
					Thread.sleep(5000);
					
					elements.clickOnStartToNextTopic();
					
				    }

			   } 
			catch (Exception e1) {
				try 
					{
					elements.clickOnMoveForwardButton();
					try {
						elements.clickOnStartButtonOfSlider();}
					catch(Exception e6) 
					{
						elements.clickOnReview();
						Thread.sleep(3000);
						if(elements.getNextModuleText().equalsIgnoreCase("Next Sub-Topic in your learning path")) 
							{
							elements.clickOnStartToNextTopic();
							}
						else if(elements.getNextModuleText().equalsIgnoreCase("Next Topic in your learning path"))
							{
							elements.clickOnStartToNextTopic();
							}	
					}
					Thread.sleep(3000);
					} 
				catch (Exception e2) 
					{
					elements.switchToFrame();
					
					elements.selectAnswer();
					
					Thread.sleep(3000);
				
					//driver.switchTo().defaultContent();
					Thread.sleep(3000);
					elements.switchBackToWindow();
					elements.clickOnSubmitBtn();
					
				try {
					Alert alert = driver.switchTo().alert();
					alert.accept();
					
					Thread.sleep(3000);
					 try
					 	{
							try {
								elements.clickOnAnswerStartButton();
								Thread.sleep(3000);
								} 
							catch (Exception e5) 
								{
								elements.clickOnUpNext();
								} 
						
						} 
					catch (Exception e4) 
						{
						elements.clickOnReview();
						Thread.sleep(5000);
						
						elements.clickOnStartToNextTopic();
						
						}}
					 
					 catch(Exception e6) 
					 {
						 try
						 	{
								try {
									elements.clickOnAnswerStartButton();
									Thread.sleep(3000);
									} 
								catch (Exception e5) 
									{
									elements.clickOnUpNext();
									} 
							
							} 
						catch (Exception e4) 
							{
							elements.clickOnReview();
							Thread.sleep(5000);
							
							elements.clickOnStartToNextTopic();
							
							}
					 }
				}
			}
			
			
			
			

			  

		}
		
	//extentTest.log(Status.INFO, MarkupHelper.createLabel(str, ExtentColor.ORANGE));
	extentTest.log(Status.INFO, MarkupHelper.createLabel("Learner have completed " +n+" Concepts", ExtentColor.GREEN));
	}
}
