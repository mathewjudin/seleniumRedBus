package ObjectRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class searchPageFactory {
WebDriver Driver;
public searchPageFactory(WebDriver driver)
{
	this.Driver=driver;
}
@FindBy(id="src")
WebElement sourcecity;
@FindBy(id="dest")
WebElement destinationcity;
@FindBy(id="onward_cal")
WebElement dateselection;
@FindBy(xpath="//*[@id=\"rb-calendar_onward_cal\"]/table/tbody/tr[1]/td[2]")
WebElement monthyear;
@FindBy(xpath="//*[@id=\"rb-calendar_onward_cal\"]/table/tbody/tr[6]/td[5]")
WebElement day;
@FindBy(id="search_btn")
WebElement search_button;
@FindBy(xpath="//*[@id=\"result-section\"]")
WebElement searchresults;
public void searchpage(String src,String desc,WebDriver driver,String d) throws Exception
{
	sourcecity.sendKeys(src);
	Actions a=new Actions(driver);
	Thread.sleep(2000);
	a.sendKeys(Keys.DOWN, Keys.DOWN,Keys.ENTER).build().perform();
	destinationcity.sendKeys(desc);
	Thread.sleep(2000);
	a.sendKeys(Keys.DOWN, Keys.DOWN,Keys.ENTER).build().perform();
	Thread.sleep(2000);
	dateselection.click();
	Thread.sleep(2000);
	monthyear.click();
	Thread.sleep(2000);
	String dt=day.getText();
	System.out.println(dt);
	 SimpleDateFormat f=new SimpleDateFormat("dd-MMMM-yyyy");
	  Date date1=f.parse(d);
	  String date2=f.format(date1);
	  String spliter[]=date2.split("-");
	  String day1=spliter[0];
	  System.out.println(day1);
	  String month=spliter[1];
	  String year=spliter[2];
	  String month_year=month+" "+year;
	  System.out.println(month_year);
	  String my=monthyear.getText();
	  System.out.println(my);
	  if(my.equals(month_year))
	  {
		 if(dt.equals(day1))
		 {
			 System.out.println("valid");
			 day.click();
			 Thread.sleep(2000);
		 }
	  }
	  
	  search_button.click();
	  Thread.sleep(3000);
	  String print=searchresults.getText();
	  System.out.println(print);
	
}

}
