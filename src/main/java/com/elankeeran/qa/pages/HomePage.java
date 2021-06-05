package com.elankeeran.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.elankeeran.qa.base.TestBase;

public class HomePage extends TestBase {
	
	WebDriver driver;
	
	@FindBy(xpath = "/html/body/div[3]/div[2]/div/div/div/div/div[3]/button[2]")
	WebElement acceptCookies;

	@FindBy(id = "email")
	WebElement emailAddress;
	
	@FindBy(id = "pass")
	WebElement pass;
	

	@FindBy(xpath = "//button[contains(text(),'Log In')]")
	WebElement login;

	@FindBy(xpath = "//*[@id=\"email_container\"]/div[2]")
	WebElement errorMessage;

	// Initializing the Page Objects:
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return this.driver.getTitle();
	}
	
	
	
	public void clickOnAcceptCookies() {
		acceptCookies.click();
	}
	
	public String verifyUserLogin(String email, String password) {
		
		emailAddress.sendKeys(email);
		pass.sendKeys(password);
		login.click();
		return errorMessage.getText();
	}


	
	
	
	
	
	
	

}