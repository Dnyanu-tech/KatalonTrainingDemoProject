package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage {
	WebDriver driver;
	
	@FindBy(xpath="//input[contains(@id,'searchtextbox')]")
	WebElement searchTextBox;
	
	@FindBy(xpath="//input[contains(@id,'search-submit-button')]")
	WebElement searchButton;
	
	public AmazonHomePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void searchProduct(String prod) {
		searchTextBox.sendKeys(prod);
		searchButton.click();
	}
	
	public void openURL(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}
}

