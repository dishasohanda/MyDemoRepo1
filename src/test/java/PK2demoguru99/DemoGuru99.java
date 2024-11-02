package PK2demoguru99;

import org.testng.annotations.Test;

import java.io.File;
import java.security.PublicKey;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

public class DemoGuru99 {
	MyProjectScreenshot M= new MyProjectScreenshot();
	WebDriver driver;
	String CustID = "";
	String ACCID = "";
	
  @Test(dataProvider = "dp1", priority = 1)
  public void DemoGuruNewCustomerRegistration(String TID,String UserID,String PassWord,String CustName,String DOB,String Address,String City,String State,String PINNumber,String MobileNumber,String EmailID,String PassWord2) throws InterruptedException {
	  Reporter.log("Set chrome Driver"); //In the Report it will show the exact text which is there in Inverted commas
	  System.setProperty("webdriver.chrome.driver", "./Browsers/chromedriver.exe"); //where chromedriver exists(path)
	  Reporter.log("Open chrome Driver");//In the Report it will show the exact text which is there in Inverted commas
	  driver = new ChromeDriver(); //To open Chrome Browser
	  Reporter.log("Open Website URL");//In the Report it will show the exact text which is there in Inverted commas
	  driver.get("https://demo.guru99.com/V4/"); //To open Website URL
	  Thread.sleep(5000); //wait Element basically to wait for 5 seconds and add exception at 1st Line
	  driver.manage().window().maximize();// To maximize the window
	  driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(UserID);//User ID field using Relative Xpath
	  Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(PassWord);//Password field using Relative Xpath
	  Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
	  driver.findElement(By.xpath("//input[@name='btnLogin']")).click();//Click on Login button using Relative Xpath
	  Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
	  driver.findElement(By.xpath("//a[@href='addcustomerpage.php']")).click();//Click on New Customer Left Side using Relative Xpath
	  Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
	  driver.findElement(By.xpath("//input[@name='name']")).sendKeys(CustName);//Customer Name field using Relative Xpath
	  Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
	  driver.findElement(By.xpath("//input[@value='f']")).click();//Selecting radio button for gender as Female
	  Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
	  driver.findElement(By.xpath("//input[@name='dob']")).sendKeys(DOB);//Date of Birth field using Relative Xpath
	  Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
	  driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys(Address);//Address field using Relative Xpath
	  Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
	  driver.findElement(By.xpath("//input[@name='city']")).sendKeys(City);//City field using Relative Xpath
	  Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
	  driver.findElement(By.xpath("//input[@name='state']")).sendKeys(State);//State field using Relative Xpath
	  Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
	  driver.findElement(By.xpath("//input[@name='pinno']")).sendKeys(PINNumber);//Pin Number(PIN) field using Relative Xpath
	  Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
	  driver.findElement(By.xpath("//input[@name='telephoneno']")).sendKeys(MobileNumber);//Mobile Number field using Relative Xpath
	  Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
	  driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(EmailID);//Mobile Number field using Relative Xpath
	  Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(PassWord2);//Another Password field using Relative Xpath
	  Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
	  
	  M.DemoGuru99Screenshots(driver, TID);
	
	  driver.findElement(By.xpath("//input[@name='sub']")).click();//Click on Submit button using Relative Xpath
	  Thread.sleep(4000);//wait Element basically to wait for 4 seconds and add exception at 1st Line
	  try {
		String Msg = driver.findElement(By.xpath("(//p)[1]")).getText();
		  Reporter.log("Message is" + Msg);
		  CustID = driver.findElement(By.xpath("(//td)[6]")).getText();//Storing the value from the table into this variable ie CustID
		  Reporter.log("Customer ID is " + CustID);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	  //Assert.assertEquals("Customer Registered Successfully!!!", Msg);//To Verify
	  M.DemoGuru99Screenshots(driver, TID);
	  System.out.println("Screenshot is captured");
	   
	  
  }
  
  @Test(dataProvider = "dp2",priority = 2)
  public void DemoGuruNewAccount(String TID) throws InterruptedException {
	  
	
	  driver.navigate().to("https://demo.guru99.com/V4/manager/addAccount.php");
	  Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line 
	  driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys(CustID);//Customer ID field using Relative Xpath
	  Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line 
	  driver.findElement(By.xpath("//input[@name=\"inideposit\"]")).sendKeys("1000");//Amount Field field using Relative Xpath
	  Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
	  M.DemoGuru99Screenshots(driver, TID);
	  driver.findElement(By.xpath("//input[@name='button2']")).click();//Customer ID field using Relative Xpath
	  Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line 
	  M.DemoGuru99Screenshots(driver, TID);
	  
	  ACCID = driver.findElement(By.xpath("(//td)[6]")).getText();//Storing the value from the table into this variable ie ACCID
	  Reporter.log("Account ID is " + ACCID);
	  
  
  }
  @DataProvider
  public Object[][] dp1() {
    return new Object[][] {
      new Object[] {"TC1","mngr597347","vEquqej","Disha Sohanda","14-10-1997","Landscape Garden","Mumbai","Maharashtra","421501","9876543572","DishaSohanda1997@gmail.com","Disha1423" },
      //new Object[] {"TC2","mngr596120","zUdAqus","Disha Sohanda","14-10-1997","Landscape Garden","Mumbai","Maharashtra","421501","1234567894","DishaSohanda6@gmail.com","Dishaa" },
      //new Object[] {"TC3","mngr596120","zUdAqus","Disha Sohanda","14-10-1997","Landscape Garden","Mumbai","Maharashtra","421501","1234567893","DishaSohanda7@gmail.com","Dishaa" },
     
    };
  }
  
  @DataProvider
  public Object[][] dp2() {
    return new Object[][] {
      new Object[] {"TC1"},
      //new Object[] {"TC2","mngr596120","zUdAqus","Disha Sohanda","14-10-1997","Landscape Garden","Mumbai","Maharashtra","421501","1234567894","DishaSohanda6@gmail.com","Dishaa" },
      //new Object[] {"TC3","mngr596120","zUdAqus","Disha Sohanda","14-10-1997","Landscape Garden","Mumbai","Maharashtra","421501","1234567893","DishaSohanda7@gmail.com","Dishaa" },
     
    };
  }
  
  
  
  
}
