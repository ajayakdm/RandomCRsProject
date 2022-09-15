package com.courseFlow;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllPageElements 
{
public WebDriver ldriver;
	
	public Actions moveSliderBar;
	public Action action1;
	
	public AllPageElements(WebDriver driver)
	{
		this.ldriver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userName")
	WebElement userNameTextbox;
	
	public void enterUserName(String un)
	{
		userNameTextbox.sendKeys(un);	
	}
	
	@FindBy(id="passwd")
	
	WebElement passWordTextbox;
	
	public void enterPassword(String pw)
	{
     	passWordTextbox.sendKeys(pw);	
	}
	
	@FindBy(xpath="//*[@id=\"LoginForm\"]/div[3]/input")
	WebElement loginButton;
	
	public void clickOnLoginButton()
	{
		loginButton.click();
	}
	
	@FindBy(id="startIcon")
	WebElement startTheCourse;
	
	public void startTheClass() 
	{
		startTheCourse.click();
	}
	
	@FindBy(id="4623")
	WebElement start4623;
	
	public void start4623() 
	{
		start4623.click();
	}
	
	@FindBy(id="startText")
	WebElement skipAndStart;
	public void skipAndStartNextTopic()
	{
		skipAndStart.click();
	}
	
	@FindBy(xpath="//*[@id=\"startIcon\"]")
	WebElement startModule;
	
	public void clickOnStartToNextTopic() 
	{
		startModule.click();
	}
	
	@FindBy(xpath="//div[text()='Move Forward']")
	WebElement move;
	public void clickOnMoveForwardButton()
	{
		move.click();
	}
	
	@FindBy(xpath="//*[@id=\"4232\"]")
	WebElement course;
	
	public void clickOn4232()
	{
		course.click();
	}
	
	@FindBy(xpath="//*[contains(text(),\"Show list view\")]")
	WebElement listViewBtn;
	
	@FindBy(xpath="//*[@class=\"commentIcon cbColobbutton-normal\"]")
	WebElement collToolBtn;
	
	@FindBy(id="startIcon")
	WebElement startCourseButton;
	
	@FindBy(xpath="//div[contains(text(),\"Resume Course\")]")
	WebElement resumeCourseButton;
	
	
	
	@FindBy(id="sec_rsm_txt")
	WebElement startResumeButton;
	
	@FindBy(xpath="//div[contains(text(),\"Resume\")]")
	private WebElement resumeButton;
	
	@FindBy(xpath="//div[@role=\"slider\"]")
	WebElement slider;
	
	@FindBy(id="1093")
	WebElement courseId;
	
	@FindBy(id="reviewBtn")
	WebElement reviewButton;
	
	@FindBy(id="courseStatus")
	WebElement startResumeModuleBtn;
	
	@FindBy(xpath="//*[contains(text(),\"Drag Me\")]")
	WebElement dragMeButton;
	
	@FindBy(xpath="//*[contains(text(),\"I want to continue without submitting\")]")
	WebElement withoutSubmitLink;
	
	@FindBy(xpath="//*[@id=\"imageCorrectAnsIndx0\"]")
	WebElement ansOption;
	
	@FindBy(id="submitBtnText")
	WebElement submitAnsBtn;
	
	@FindBy(id="nextActivityCont")
	WebElement upNext; 
	
	@FindBy(xpath="//*[@id=\"startTextTop\"]")
	WebElement sliderStartButton; 
	
	@FindBy(id="nextActivityTitleName")
	WebElement answerStartButton;
	
	@FindBy(xpath="//*[@class=\"learningsectid\"]")
	WebElement learningSectionNo;
	
	@FindBy(xpath="//*[@id=\"nextSecText\"]")
	WebElement nextModuleText;    
	
	@FindBy(xpath="//*[@id=\"showTestContentText\"]/span[1]")
	WebElement seeOtherOptionLink; 
	
	@FindBy(id="actCntIframe_child")
	WebElement frameID;
	
	@FindBy(id="draganddrop")
	WebElement dragAndDropInFrame;
	
	public void doDragAndDropInFrame() 
	{
		moveSliderBar=new Actions(ldriver);
		WebDriverWait wait = new WebDriverWait(ldriver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(dragAndDropInFrame));
    	action1=moveSliderBar.dragAndDropBy(dragAndDropInFrame,736,660).build();
    	action1.perform();	   
	}
	public void moveSliderBar() 
	{
		moveSliderBar=new Actions(ldriver);
		WebDriverWait wait = new WebDriverWait(ldriver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(slider));
    	action1=moveSliderBar.dragAndDropBy(slider, 350, 0).build();
    	action1.perform();	                                        
	}
	
	public void moveSliderBarLessthan50() 
	{
		moveSliderBar=new Actions(ldriver);
		WebDriverWait wait = new WebDriverWait(ldriver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(slider));
    	action1=moveSliderBar.dragAndDropBy(slider, 200, 0).build();
    	action1.perform();	                                        
	}
	
	public boolean ToVerifyCollTool() 
	{
		boolean tool = collToolBtn.isEnabled();
		return tool;
	}
	
	public void clickOnListViewBtn() 
	{
		listViewBtn.click();
	}
	
	public void clickOnStartCourseButton() 
	{
		startCourseButton.click();
	}
	
	public void clickOnResumeCourseBtn() 
	{
		resumeCourseButton.click();
	}
	
	public void clickToStartOrResumeSubModule()
	{
     	startResumeModuleBtn.click();	
	}
	
	public void clickToStarOrResumeActivity() 
	{
		startResumeModuleBtn.click();
	}
	
	public void clickOnStartCourse() 
	{
		if(startCourseButton.getText().equals("Start Course")) 
		{
			startCourseButton.click();
			
			if(startResumeButton.getText().equals("Start")) 
			{
				startResumeButton.click();
				clickOnStart();
			}
			else if(startResumeButton.getText().equals("Resume"))
			{
				startResumeButton.click();
			}
			
		}
		else 
		{
			resumeCourseButton.click();
		}
	}	
	public void clickOnStart() 
	{
		if(startResumeButton.getText().equals("Start")) 
		{
			startResumeButton.click();
		}
		else 
		{
			resumeButton.click();
		}
	}
	
	public void clickOnCourseTitle() 
	{
		courseId.click();
	}
	
	public void clickOnStartButtonOfSlider() 
	{
		WebDriverWait wait = new WebDriverWait(ldriver, 4);
		wait.until(ExpectedConditions.elementToBeClickable(sliderStartButton));
		sliderStartButton.click();
	}
	
	public void clickOnAnswerStartButton() 
	{
	    WebDriverWait wait = new WebDriverWait(ldriver, 4);
		wait.until(ExpectedConditions.elementToBeClickable(answerStartButton));
		answerStartButton.click();
	}
	
	public void clickOnReview() 
	{
		reviewButton.click();
	}
	
	public void clickOnwithoutSubmit() 
	{
		withoutSubmitLink.click();
	}
	
	public void switchToFrame() 
	{
		WebDriverWait wait = new WebDriverWait(ldriver,5);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameID));
	//	driver.switchTo().frame("actCntIframe_child");
	}
	public void selectAnswer() 
	{   
		WebDriverWait wait = new WebDriverWait(ldriver, 4);
		wait.until(ExpectedConditions.elementToBeClickable(ansOption));
		ansOption.click();
	}
	public void clickOnSubmitBtn()
	{
		submitAnsBtn.click();
	}
	public void switchBackToWindow() 
	{
		ldriver.switchTo().defaultContent();
	}
	
	public String getTextLearningSection() 
	{
	    String number=learningSectionNo.getText();	
	    return number;
	}
	
	public String getNextModuleText() 
	{
		String sectionId=nextModuleText.getText();
		//double sectionId=Double.parseDouble(j); 
		return sectionId;
	}
	
	public void clickOnUpNext() 
	{
		upNext.click();
	}
	
	public void clickOnSeeOtherOptionLink() 
	{
		seeOtherOptionLink.click();
	}
	
}
