package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class LoginPage {

	private Page page;
	//1. Locators
	private String emailId = "input#input-email";
	private String password = "input#input-password";
	private String forgotPasswordLink = "//div[@class='form-group']//a[text()='Forgotten Password']";
	private String loginBtn = "//input[@value='Login']";
	private String logoutLink = "//a[@class='list-group-item'][text()='Logout']";
	
	//2. Constructor
	public LoginPage(Page page) {
		this.page=page;
	}
	
	public String getLoginPageTitle() {
		return page.title();
	}
	
	public boolean isForgotPasswordExists() {
		return page.isVisible(forgotPasswordLink);
	}
	public boolean doLogin(String username, String apppassword) {
		System.out.println("Login credential are Username: "+username+" Password: "+apppassword);
		page.fill(emailId, username);
		page.fill(password, apppassword);
		page.click(loginBtn);
		if(page.isVisible(logoutLink)) {
			System.out.println("Succesfully Logged in ");
			return true;
		}
		else
			return false;
	}
}
