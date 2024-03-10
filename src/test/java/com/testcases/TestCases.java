package com.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.baseSetup.BaseTest;
import com.pages.AmazonHomePage;
import com.pages.CartPage;

public class TestCases extends BaseTest {

	String appUrl;
	AmazonHomePage hp;
	CartPage cp;
	
	@BeforeTest
	public void setup() {
		appUrl= props.getProperty("url");
		hp=new AmazonHomePage(driver);
		cp=new CartPage(driver);
	}
	
	@Test(priority=1)
	public void searchProduct() throws InterruptedException {
		hp.openURL(appUrl);
		hp.searchProduct("Samsung mobile phones under 5000");
		Thread.sleep(5000);
	}
	@Test(priority=2)
	public void verifyCartPage() {
		hp.openURL(appUrl);
		cp.validateCartPage();
	}
}
