package TestNG_RedBus_project;

import org.testng.annotations.Test;

import ObjectRepository.searchPageFactory;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class SearchPage_Testcase {
	WebDriver driver;
	searchPageFactory s;
	
  @Test
  @Parameters({"source","dest","dinput"})
  public void search(String src,String des,String date) throws Exception {
	 
	  s=PageFactory.initElements(driver,searchPageFactory.class);
	  s.searchpage(src, des, driver, date);
	  
  }
  @BeforeMethod
  @Parameters({"browser","website"})
  public void beforeMethod(String browser_name,String url) {
	  switch(browser_name)
	  {
	  case "chrome":
	  {
		  WebDriverManager.chromedriver().setup();
		  driver=new ChromeDriver();
		  Reporter.log("Browser launghed");
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.get(url);
		  Reporter.log("WebSite got Open");
		  break;
		  }
	  
	  case "firebox":
	  {
		  WebDriverManager.firefoxdriver().setup();
		  driver=new FirefoxDriver();
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.get(url);
		  break;
	  }
	  case "edge":
	  {
		  WebDriverManager.edgedriver().setup();
		  driver=new EdgeDriver();
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.get(url);
		  break;
	  }
	  
	  }
	  
	  
  }

  @AfterMethod
  public void afterMethod() throws Exception {
	  Thread.sleep(3000);
	  driver.quit();
  }

  @BeforeClass
  public void beforeClass() {
	  
  }

  @AfterClass
  public void afterClass() {
  }

}
