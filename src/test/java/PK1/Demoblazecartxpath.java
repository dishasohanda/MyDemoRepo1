package PK1;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

public class Demoblazecartxpath {
  
	@Test(dataProvider = "dp")
	  public void AddmobiletocartAbsolutexpath(Integer n, String MobileName) throws InterruptedException {
		  Reporter.log("Set chrome Driver"); //In the Report it will show the exact text which is there in Inverted commas
		  System.setProperty("webdriver.chrome.driver", "./Browsers/chromedriver.exe"); //where chromedriver exists(path)
		  Reporter.log("Open chrome Driver");
			WebDriver driver= new ChromeDriver(); //To open Chrome Browser
			Reporter.log("Open Website URL");
			driver.get("https://www.demoblaze.com/index.html"); //To open Website URL
			Thread.sleep(5000); //wait Element basically to wait for 5 seconds and add exception at 1st Line
			driver.manage().window().maximize();// To maximize the window
			driver.findElement(By.xpath("/html/body/nav/div[1]/ul/li[5]/a")).click();// Click on Login Link-Absolute Xpath
			Thread.sleep(2000);//wait Element basically to wait for 2 seconds
			driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/form/div[1]/input")).sendKeys("DishaSohanda");//Login Field-Absolute Xpath
			Thread.sleep(2000);//wait Element basically to wait for 2 seconds
			driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/form/div[2]/input")).sendKeys("DishaSohanda");//Password-Absolute Xpath
			Reporter.log("Login button");
			driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();//Login Button-Absolute Xpath
			Thread.sleep(5000);//wait Element basically to wait for 5 seconds
			Reporter.log("Selected Mobile is " + MobileName);
			driver.findElement(By.linkText(MobileName)).click();
			Thread.sleep(2000);
			Reporter.log("Add to Cart");
			driver.findElement(By.linkText("Add to cart")).click();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();// To handle Popup
			Reporter.log("View cart");
			driver.findElement(By.linkText("Cart")).click();
			Thread.sleep(5000);
			Reporter.log("Logout");
			driver.findElement(By.xpath("/html/body/nav/div/div/ul/li[6]/a")).click();//Logout Link or button-Absolute Xpath
			Thread.sleep(2000);
			driver.close();// To Close Chrome Browser
	  }
	
	@Test(dataProvider = "dp")
	  public void AddmobiletocartRelativexpath(Integer n, String MobileName) throws InterruptedException {
		  Reporter.log("Set chrome Driver"); //In the Report it will show the exact text which is there in Inverted commas
		  System.setProperty("webdriver.chrome.driver", "./Browsers/chromedriver.exe"); //where chromedriver exists(path)
		  Reporter.log("Open chrome Driver");
			WebDriver driver= new ChromeDriver(); //To open Chrome Browser
			Reporter.log("Open Website URL");
			driver.get("https://www.demoblaze.com/index.html"); //To open Website URL
			Thread.sleep(5000); //wait Element basically to wait for 5 seconds and add exception at 1st Line
			driver.manage().window().maximize();// To maximize the window
			driver.findElement(By.xpath("//a[@id='login2']")).click();// Click on Login Link-Relative Xpath
			Thread.sleep(2000);//wait Element basically to wait for 2 seconds
			driver.findElement(By.xpath("//input[@id='loginusername']")).sendKeys("DishaSohanda");//Login Field-Relative Xpath
			Thread.sleep(2000);//wait Element basically to wait for 2 seconds
			driver.findElement(By.xpath("//input[@id='loginpassword']")).sendKeys("DishaSohanda");//Password-Relative Xpath
			Reporter.log("Login button");
			driver.findElement(By.xpath("(//button)[9]")).click();//Login Button--Relative Xpath using index
			Thread.sleep(5000);//wait Element basically to wait for 5 seconds
			Reporter.log("Selected Mobile is " + MobileName);
			driver.findElement(By.linkText(MobileName)).click();
			Thread.sleep(2000);
			Reporter.log("Add to Cart");
			driver.findElement(By.linkText("Add to cart")).click();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();// To handle Popup
			Reporter.log("View cart");
			driver.findElement(By.linkText("Cart")).click();
			Thread.sleep(5000);
			Reporter.log("Logout");
			driver.findElement(By.xpath("(//a)[7]")).click();//Logout Link or button-Relative Xpath using index
			Thread.sleep(2000);
			driver.close();// To Close Chrome Browser
	  }

	  @DataProvider
	  public Object[][] dp() {
	    return new Object[][] {
	      new Object[] { 1, "Samsung galaxy s6" },
	      //new Object[] { 2, "Nokia lumia 1529" },
	    };
	  }
}
