package PK3OrangeHRM;

import org.testng.annotations.Test;

import com.google.common.collect.Table.Cell;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

public class OrangeHRM {
	
	WebDriver driver;
	
  @Test(dataProvider = "dp1",priority = 1)
  public void CreateOrganeHRM(String UserName,String PassWord,String FirstName,String MiddleName,String LastName) throws InterruptedException {
	  
	  Reporter.log("Set chrome Driver"); //In the Report it will show the exact text which is there in Inverted commas
	  System.setProperty("webdriver.chrome.driver", "./Browsers/chromedriver.exe"); //where chromedriver exists(path)
	  Reporter.log("Open chrome Driver");//In the Report it will show the exact text which is there in Inverted commas
	  driver = new ChromeDriver(); //To open Chrome Browser
	  Reporter.log("Open Website URL");//In the Report it will show the exact text which is there in Inverted commas
	  driver.get("https://opensource-demo.orangehrmlive.com/"); //To open Website URL
	  Thread.sleep(5000); //wait Element basically to wait for 5 seconds and add exception at 1st Line
	  driver.manage().window().maximize();// To maximize the window
	  driver.findElement(By.xpath("//input[@name='username']")).sendKeys(UserName);//User Name field using Relative Xpath
	  Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(PassWord);//Password field using Relative Xpath
	  Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
	  driver.findElement(By.xpath("//button[@type='submit']")).click();//Click on Login button using Relative Xpath
	  Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
	  driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");//Navigate to this URL
	  Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
	  
	  //driver.findElement(By.xpath("//a[@href='/web/index.php/pim/viewPimModule']")).click();//Click on Leftside PIM Link using Relative Xpath
	  //Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
	  
	  driver.findElement(By.xpath("(//button)[7]")).click();//Click on Add button using Relative Xpath
	  Thread.sleep(3000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
	  driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(FirstName);//FirstName field using Relative Xpath
	  Thread.sleep(3000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
	  driver.findElement(By.xpath("//input[@name='middleName']")).sendKeys(MiddleName);//MiddleName field using Relative Xpath
	  Thread.sleep(3000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
	  driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(LastName);//LastName field using Relative Xpath
	  Thread.sleep(3000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
	  
	  driver.findElement(By.xpath("(//input)[6]")).sendKeys(Keys.CONTROL+"A"+ Keys.BACK_SPACE);//To clear any Text Field
	  Thread.sleep(3000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
	  
	  driver.findElement(By.xpath("//button[@type='submit']")).click();//Click on Save button using Relative Xpath
	  Thread.sleep(5000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
	  
	  
  }
  
  @Test(dataProvider = "dp2",priority = 2)
  public void EditOrganeHRM(String OtherID) throws InterruptedException {
	  
	  driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");//Navigate to this URL
	  Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
	  
	     Actions Act = new Actions(driver);// To perform actions basically keyboards keys eg:Enter,down arrow key.
		 Act.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")),"Guls" );//Entered value as Dis - Employee Name field using Relative Xpath
		 Act.build().perform();
		 Thread.sleep(3000);
		 Act.sendKeys(Keys.ARROW_DOWN);
		 Act.build().perform();
		 Act.sendKeys(Keys.ENTER);
		 Act.build().perform();
		 Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line	 
		 driver.findElement(By.xpath("//button[@type='submit']")).click();//Click on Search button using Relative Xpath
		 Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver; // To scroll down
		 js.executeScript("window.scrollBy(0,300)", "");// To scroll down
		 Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
		 
		 driver.findElement(By.xpath("(//button)[8]")).click();//Click on Edit button using Relative Xpath
		 Thread.sleep(5000);//wait Element basically to wait for 5 seconds and add exception at 1st Line
		 
		 
		 driver.findElement(By.xpath("(//input)[6]")).sendKeys(OtherID);//Other ID Field using Relative Xpath
		 Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
		 
		 driver.findElement(By.xpath("(//button)[4]")).click();//Click on Save button using Relative Xpath
		 Thread.sleep(5000);//wait Element basically to wait for 5 seconds and add exception at 1st Line
		 
		
		  
  }
  
  
 // @Test(dataProvider = "dp3",priority = 3)
  public void DeleteOrganeHRM(String TEST) throws InterruptedException {
	  
	  driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");//Navigate to this URL
	  Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
	  
	     Actions Act = new Actions(driver);// To perform actions basically keyboards keys eg:Enter,down arrow key.
		 Act.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")),"Guls" );//Entered value as  - Employee Name field using Relative Xpath
		 Act.build().perform();
		 Thread.sleep(3000);
		 Act.sendKeys(Keys.ARROW_DOWN);
		 Act.build().perform();
		 Act.sendKeys(Keys.ENTER);
		 Act.build().perform();
		 Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line	 
		 driver.findElement(By.xpath("//button[@type='submit']")).click();//Click on Search button using Relative Xpath
		 Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver; // To scroll down
		 js.executeScript("window.scrollBy(0,300)", "");// To scroll down
		 Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
		 
		 driver.findElement(By.xpath("(//button)[9]")).click();//Click on Delete button using Relative Xpath
		 Thread.sleep(5000);//wait Element basically to wait for 5 seconds and add exception at 1st Line
		 
		 driver.findElement(By.xpath("(//button)[12]")).click();//Click on Yes,Delete button using Relative Xpath
		 Thread.sleep(5000);//wait Element basically to wait for 5 seconds and add exception at 1st Line
	  
	
		  
  }
  
  
  @Test(dataProvider = "dp4",priority = 4)
  public void AddLeave(String TEST,String Entitlement) throws InterruptedException {
	  
	  driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/leave/addLeaveEntitlement");//Navigate to this URL
	  Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
	  
	  
	     Actions Act = new Actions(driver);// To perform actions basically keyboards keys eg:Enter,down arrow key.
		 Act.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")),"Guls" );//Entered value as  - Employee Name field using Relative Xpath
		 Act.build().perform();
		 Thread.sleep(3000);
		 Act.sendKeys(Keys.ARROW_DOWN);
		 Act.build().perform();
		 Act.sendKeys(Keys.ENTER);
		 Act.build().perform();
		 Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line	
		 
		 Act.click(driver.findElement(By.xpath("//div[text()='-- Select --']")));
		 Act.build().perform();
		 Act.sendKeys(Keys.ARROW_DOWN);
		 Act.build().perform();
		 Act.sendKeys(Keys.ARROW_DOWN);
		 Act.build().perform();
		 Act.sendKeys(Keys.ARROW_DOWN);
		 Act.build().perform();
		 Act.sendKeys(Keys.ARROW_DOWN);
		 Act.build().perform();
		 Act.sendKeys(Keys.ENTER);
		 Act.build().perform();
		 Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
		 
		 driver.findElement(By.xpath("(//input)[5]")).sendKeys(Entitlement);//Entitlement Field using Relative Xpath
		 Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
		 driver.findElement(By.xpath("//button[@type='submit']")).click();//Save button using Relative Xpath
		 Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
		 
		 driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]")).click();//Confirm button using Absolute Xpath
		 Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
		 
		
		 
		 
		
		 
		 
		
		 
	  
	  
 
  }
  
  @DataProvider
  public Object[][] dp1() {
    return new Object[][] {
      new Object[] {"Admin","admin123","Gulshan","XYZ","Sohanda" },
      //new Object[] {"b" },
    };
  }
  
  
  @DataProvider
  public Object[][] dp2() {
    return new Object[][] {
      new Object[] {"50"},
      //new Object[] {"b" },
    };
  }
  
  @DataProvider
  public Object[][] dp3() {
    return new Object[][] {
      new Object[] {""},
      //new Object[] {"b" },
    };
  }
  
  @DataProvider
  public Object[][] dp4() {
    return new Object[][] {
      new Object[] {"TC1","5"},
      //new Object[] {"b" },
    };
  }
  
 
  
  
}
