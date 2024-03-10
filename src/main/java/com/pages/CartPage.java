package com.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
WebDriver driver;
	
	@FindBy(xpath="//a[contains(@id,'nav-cart')]")
	WebElement cartButton;
	
	@FindBy(xpath="//div[@id='sc-active-cart']//span[@class='a-list-item']//a//span[@class='a-truncate-cut']")
	WebElement cartProductName;
	
	public CartPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void validateCartPage() {
		if(cartButton.isDisplayed()) {
			cartButton.click();
			if(cartProductName.isDisplayed()) {
				System.out.println("Product name "+cartProductName.getText());
				assertTrue(!cartProductName.getText().isEmpty());
			}
			
		}
	}
}
