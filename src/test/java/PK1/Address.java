package PK1;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

public class Address {
	@Test(dataProvider = "dp")
	  public void DemoqaRelativexpath(String Address) throws InterruptedException {
		  Reporter.log("Set chrome Driver"); //In the Report it will show the exact text which is there in Inverted commas
		  System.setProperty("webdriver.chrome.driver", "./Browsers/chromedriver.exe"); //where chromedriver exists(path)
		  Reporter.log("Open chrome Driver");
		  WebDriver driver= new ChromeDriver(); //To open Chrome Browser
		  Reporter.log("Open Website URL");
		  driver.get("https://demoqa.com/automation-practice-form/"); //To open Website URL
		  Thread.sleep(5000); //wait Element basically to wait for 5 seconds and add exception at 1st Line
		  driver.manage().window().maximize();// To maximize the window
		  Thread.sleep(5000);//wait Element basically to wait for 5 seconds and add exception at 1st Line
		  driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys(Address);//Current Address Field using Relative Xpath
		  Thread.sleep(5000);//wait Element basically to wait for 5 seconds and add exception at 1st Line
		  
		  
		  
	  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] {"Flat No.701,Landscape Garden"},
     // new Object[] { 2, "b" },
    };
  }
}
