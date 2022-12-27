package com.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base;


public class LoginPage extends Base {

	@FindBy(id="id_email")
	 WebElement userName;
	
	@FindBy(id="id_password")
	 WebElement password;
	
	@FindBy(xpath="//button[@class='sign-in-button']")
	 WebElement LoginBtn;
	
	
	public LoginPage()
	
	{
		PageFactory.initElements(driver,this);	
	}
	
	public HomePage userLogin(String Email,String Psword)
	
	{
		userName.sendKeys(Email);
		password.sendKeys(Psword);
		LoginBtn.click();
		return new HomePage();
	}
	
}
