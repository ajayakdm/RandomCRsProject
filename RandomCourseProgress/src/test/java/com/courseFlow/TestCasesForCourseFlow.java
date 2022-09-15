package com.courseFlow;

import java.awt.Robot;
import java.awt.event.KeyEvent;
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
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class TestCasesForCourseFlow extends BaseClass
{
	AllPageElements elements;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest extentTest;
	
	@BeforeClass
	public void beforeClass() 
	{
		Date d=new Date();
	//	String name="Wiris Report id-3406" +" "+d.toString()+".html";
		htmlReporter=new ExtentHtmlReporter("./TestCaseReports/CourseId-4623(Prod).html");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Automation");
		htmlReporter.config().setReportName("Automation Test Result for ID 4623(Prod)");
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent =new ExtentReports();
		extent.setSystemInfo("Course ID", "4623(Prod)");
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
	
	//Test case 1
	@Test (priority=1)
	public void LoginIntoCourse(String un, String pw) throws Exception 
	{
		driver.get("https://www.cogbooks.com/sign-in.html");
		elements=new AllPageElements(driver);
		elements.enterUserName(un);
		elements.enterPassword(pw);
		Thread.sleep(3000);
		elements.clickOnLoginButton();
		 Thread.sleep(3000);
		 
		extentTest=extent.createTest("loginLearner");
		extentTest.log(Status.INFO, "Executing the test case......");
		extentTest.log(Status.PASS,"Learnerr logged in into production server succesfully");
		//extentTest.log(Status.PASS,"Author Username : "+readConfig.getAuthor1UserName());
		extentTest.log(Status.PASS,"Course ID is : 4623");
		//extentTest.log(Status.INFO, un);
		elements.start4623();
		Thread.sleep(3000);
		/*
		 * Robot r=new Robot(); r.keyPress(KeyEvent.VK_CONTROL);
		 * r.keyPress(KeyEvent.VK_T); r.keyRelease(KeyEvent.VK_T);
		 * r.keyRelease(KeyEvent.VK_CONTROL); Thread.sleep(3000); Set<String> allWindows
		 * = driver.getWindowHandles(); ArrayList<String> newTb = new
		 * ArrayList<String>(driver.getWindowHandles()); //switch to new tab
		 * 
		 * driver.switchTo().window(newTb.get(1)); Thread.sleep(2000);
		 * 
		 * driver.get(
		 * "https://www.cogbooks.com/communicog/handler?action=courseBranding&COURSEID=4623"
		 * );
		 */
		 System.out.println(driver.getTitle());
		 Thread.sleep(2000);
		 elements.startTheClass();
	}
	//Test case 2
	@Test (priority = 2)
	public void startCourseFlow() throws Exception 
	{
		AllPageElements page=new AllPageElements(driver);
		/*
		 * ExcelData exl=new ExcelData(); PrintScreen scr= new PrintScreen(); LTIPage
		 * ltiPage=new LTIPage(driver);
		 */
		
		//ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		extentTest=extent.createTest("startCourseFlow");
		extentTest.log(Status.INFO, "Executing the test case......");
		extentTest.log(Status.INFO, "Learner started the learning activities");
	for (int i = 1; i <= 16; i++) {
			
			Thread.sleep(4000);
			
			try {
				
				
				page.moveSliderBar();
				Thread.sleep(3000);
				
				try {
					page.clickOnStartButtonOfSlider();
					Thread.sleep(3000);
					}
			   catch (Exception e3) 
					{
					page.clickOnReview();
					Thread.sleep(3000);
					if(page.getNextModuleText().equalsIgnoreCase("Next Sub-Topic in your learning path")) 
						{
							page.clickOnStartToNextTopic();
						}
					else if(page.getNextModuleText().equalsIgnoreCase("Next Topic in your learning path"))
						{
							page.clickOnStartToNextTopic();
						}
				    }

			   } 
			catch (Exception e1) {
				try 
					{
					page.clickOnMoveForwardButton();
					try {
					page.clickOnStartButtonOfSlider();}
					catch(Exception e6) 
					{
						page.clickOnReview();
						Thread.sleep(3000);
						if(page.getNextModuleText().equalsIgnoreCase("Next Sub-Topic in your learning path")) 
							{
								page.clickOnStartToNextTopic();
							}
						else if(page.getNextModuleText().equalsIgnoreCase("Next Topic in your learning path"))
							{
								page.clickOnStartToNextTopic();
							}	
					}
					Thread.sleep(3000);
					} 
				catch (Exception e2) 
					{
					page.switchToFrame();
					
					page.selectAnswer();
					
					Thread.sleep(3000);
				
					//driver.switchTo().defaultContent();
					Thread.sleep(3000);
					page.switchBackToWindow();
					page.clickOnSubmitBtn();
					Alert alert = driver.switchTo().alert();
					alert.accept();
					Thread.sleep(3000);
					 try
					 	{
							try {
								page.clickOnAnswerStartButton();
								Thread.sleep(3000);
								} 
							catch (Exception e5) 
								{
								page.clickOnUpNext();
								} 
						
						} 
					catch (Exception e4) 
						{
						page.clickOnReview();
						Thread.sleep(3000);
						if(page.getNextModuleText().equalsIgnoreCase("The Next Sub-Topic in your learning path")) 
							{
								page.clickOnStartToNextTopic();
							}
						else if(page.getNextModuleText().equalsIgnoreCase("The Next Topic in your learning path"))
							{
								page.clickOnStartToNextTopic();
							}
						}
				}
			}
			
			
			
			

			  

		}
		
		

	}
	
	
	
	
}
