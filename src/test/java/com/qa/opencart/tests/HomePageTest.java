package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencat.constraints.AppConstraints;


public class HomePageTest extends BaseTest {

	
	@Test(priority = 1)
	public void homePageTitleTest() {
		String actualTile = homePage.getHomePageTitle();
		Assert.assertEquals(actualTile, AppConstraints.HOME_PAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void homePageUrlTest() {
		String actualUrl = homePage.getHomePageUrl();
		Assert.assertEquals(actualUrl, prop.getProperty("url"));
	}
	
	@DataProvider
	public Object[][] getProductData() {
		return new Object[][] {
			{"Macbook"},
			{"iMac"},
			{"Samsung"}
		};
		
	}
	
	@Test(dataProvider = "getProductData",priority = 3)
	public void homePageSearchTest(String productName) {
		String actualHeader = homePage.doSearch(productName);
		Assert.assertEquals(actualHeader, "Search - "+productName);
	}
	
}
