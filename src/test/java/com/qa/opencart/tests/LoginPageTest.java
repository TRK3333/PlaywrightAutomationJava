package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencat.constraints.AppConstraints;

public class LoginPageTest extends BaseTest {
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		//Page chaining 
		loginPage =homePage.navigateToLoginPage();
		String actualLoginPageTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actualLoginPageTitle, AppConstraints.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void forgotPasswordLinkExistsTest() {
		Assert.assertTrue(loginPage.isForgotPasswordExists());
	}
	
	@Test(priority = 3)
	public void appLoginTest() {
		Assert.assertTrue(loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim()));
	}
}
