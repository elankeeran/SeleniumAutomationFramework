package com.elankeeran.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.elankeeran.qa.base.TestBase;
import com.elankeeran.qa.pages.HomePage;
import com.elankeeran.qa.util.TestUtil;



public class HomePageTest extends TestBase {
	WebDriver driver;

	HomePage homePage;

	TestUtil testUtil;


	public HomePageTest() {
		super();
	}

	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
	@BeforeTest
	public void setUp() {
		driver = initialization(driver);
		
		testUtil = new TestUtil();
		
	}
	

//	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		homePage = new HomePage(driver);
		homePage.clickOnAcceptCookies();
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Facebook – log in or sign up");
	}
	
	
	@Test(priority=2)
	public void verifyUserLoginFailTest(){
		homePage = new HomePage(driver);
		String erroMessage  = homePage.verifyUserLogin("test@test.comn", "Test123");
		Assert.assertEquals(erroMessage, "The email address you entered isn't connected to an account. Find your account and log in.");
	}
	
	
	@AfterTest
	public void tearDown(){
		driver.quit();
		
	}
	
	


}
