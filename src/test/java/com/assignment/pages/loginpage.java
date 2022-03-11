package com.assignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {

	WebDriver driver;
	
	
	@FindBy(name="user_login")
	WebElement username;
	@FindBy(id="user_password")
	WebElement password;
	@FindBy(name="submit") 
	WebElement submitbtn;
	@FindBy(name="xxx")
	WebElement logout;


	
//	By UserID=By.name("user_login");
//	By password=By.id("user_password");
//	By Submit=By.name("submit");
	
	
	public loginpage(WebDriver ldriver)
	{
		this.driver=ldriver;
		 PageFactory.initElements(driver, this);
	}	
	

	public void loginTosite(String Username,String Password) {
		this.enterUsername(Username);
		this.enterPasssword(Password);
		this.clickSubmit();
	}

	private void enterUsername(String uname) {
	
		username.sendKeys(uname);
		// TODO Auto-generated method stub
		
	}
	private void enterPasssword(String Password) {
		password.sendKeys(Password);
		// TODO Auto-generated method stub
		
	}
	private void clickSubmit() {
		// TODO Auto-generated method stub
		submitbtn.click();
		
	}

public void clicklogout()
{
	logout.click();
}
	


}
