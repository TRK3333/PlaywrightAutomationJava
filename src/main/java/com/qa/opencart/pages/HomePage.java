package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class HomePage {

	Page page;
	//String Locators
	
	private String search = "input[name='search']";
	private String searchIcon = "div#search button";
	private String searchPageHeader = "div#content h1";
	private String myAccountLink = "//a[@title='My Account']";
	private String loginClick = "a:text('Login')";
	
	// Page Constructor
	
	public HomePage(Page page) {
		this.page=page;
	}
	
	public String getHomePageTitle() {
		String pageTitle = page.title();
		System.out.println("Page Title is " +pageTitle);
		return pageTitle;
	}
	
	public String getHomePageUrl() {
		String url = page.url();
		System.out.println("Url is "+url);
		return url;
	}
	
	public String doSearch(String productName) {
		page.fill(search, productName);
		page.click(searchIcon);
		return page.textContent(searchPageHeader);
	}
	
	public LoginPage navigateToLoginPage() {
		page.click(myAccountLink);
		page.click(loginClick);
		return new LoginPage(page);
	}
	
}
