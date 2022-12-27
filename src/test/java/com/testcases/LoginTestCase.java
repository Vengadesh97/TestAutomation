package com.testcases;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.base.Base;
import com.pageobjects.LoginPage;

public class LoginTestCase extends Base {

	
	
	@Test(dataProvider="sheet1",dataProviderClass=DataProvider.class)
	public void loginPage(String name,String pass) 
	{
		
		LoginPage login = new LoginPage();
		
		login.userLogin(name,pass);
		
	}
	
	
}
