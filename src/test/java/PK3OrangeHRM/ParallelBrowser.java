package PK3OrangeHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class ParallelBrowser {
	WebDriver driver;
  @Test
  public void f1() {
	  
	     System.setProperty("webdriver.chrome.driver", "./Browsers/chromedriver.exe"); //where chromedriver exists(path)
		 driver = new ChromeDriver(); //To open Chrome Browser
		 driver.get("https://opensource-demo.orangehrmlive.com/"); //To open Website URL
  }
  
  @Test
  public void f2() {
	  
	  System.setProperty("webdriver.edge.driver", "./Browsers/msedgedriver.exe");//where Edge exists(path)
		 driver = new EdgeDriver(); //To open Edge Browser
		 driver.get("https://demoqa.com/automation-practice-form/");
	  
  }
  
  
}
