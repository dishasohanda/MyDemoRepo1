package PK1;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

public class Demoblazecart {
  @Test(dataProvider = "dp")
  public void Addmobiletocart(Integer n, String MobileName) throws InterruptedException {
	  Reporter.log("Set chrome Driver"); //In the Report it will show the exact text which is there in Inverted commas
	  System.setProperty("webdriver.chrome.driver", "./Browsers/chromedriver.exe"); //where chromedriver exists(path)
	  Reporter.log("Open chrome Driver");
		WebDriver driver= new ChromeDriver(); //To open Chrome Browser
		Reporter.log("Open Website URL");
		driver.get("https://www.demoblaze.com/index.html"); //To open Website URL
		Thread.sleep(5000); //wait Element basically to wait for 5 seconds and add exception at 1st Line
		driver.manage().window().maximize();// To maximize the window
		driver.findElement(By.id("login2")).click();// Click on Login Link
		Thread.sleep(2000);//wait Element basically to wait for 2 seconds
		driver.findElement(By.id("loginusername")).sendKeys("DishaSohanda");//Login Field
		Thread.sleep(2000);//wait Element basically to wait for 2 seconds
		driver.findElement(By.id("loginpassword")).sendKeys("DishaSohanda");//Password Field
		Reporter.log("Login button");
		driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();//Login Button
		Thread.sleep(5000);//wait Element basically to wait for 5 seconds
		Reporter.log("Selected Mobile is " + MobileName);
		driver.findElement(By.linkText(MobileName)).click();
		Thread.sleep(2000);
		Reporter.log("Add to Cart");
		driver.findElement(By.linkText("Add to cart")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Reporter.log("View cart");
		driver.findElement(By.linkText("Cart")).click();
		Thread.sleep(5000);
		Reporter.log("Logout");
		driver.findElement(By.id("logout2")).click();//Logout Link or button
		Thread.sleep(2000);
		driver.close();// To Close Chrome Browser
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "Samsung galaxy s6" },
      new Object[] { 2, "Nokia lumia 1529" },
    };
  }
}
