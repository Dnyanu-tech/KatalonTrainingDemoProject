package com.baseSetup;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	public Properties props=new Properties();
	public FileReader reader;

	@BeforeTest
	public void InitializeBrowser() throws IOException {
		if(driver==null) {
			reader=new FileReader(System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties");
			props.load(reader);
		}
		if(props.getProperty("browser").equalsIgnoreCase("chrome")) {
			ChromeOptions chromeOptions = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(chromeOptions);
		}
		else if(props.getProperty("browser").equalsIgnoreCase("firefox")) {
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(firefoxOptions);
		}
		else if(props.getProperty("browser").equalsIgnoreCase("edge")) {
			EdgeOptions edgeOptions = new EdgeOptions();
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(edgeOptions);
		}
		
	}
	@AfterTest
	public void TearDown() {
		driver.quit();
	}

}
