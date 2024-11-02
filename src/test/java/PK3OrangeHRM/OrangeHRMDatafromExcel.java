package PK3OrangeHRM;

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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PK2demoguru99.MyProjectScreenshot;

public class OrangeHRMDatafromExcel {
	
	MyProjectScreenshot M= new MyProjectScreenshot();
	String Name = "";
	
	WebDriver driver;
	@Test(dataProvider = "excelData",priority = 1,enabled = true)
	public void CreateOrganeHRM(String Browser,String UserName,String PassWord,String FirstName,String MiddleName,String LastName) throws InterruptedException {
		
		//Reporter.log("Set chrome Driver"); //In the Report it will show the exact text which is there in Inverted commas
		if (Browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Browsers/chromedriver.exe"); //where chromedriver exists(path)
			 driver = new ChromeDriver(); //To open Chrome Browser
			
		}
		
		if (Browser.equals("Edge")) {
			System.setProperty("webdriver.edge.driver", "./Browsers/msedgedriver.exe");//where Edge exists(path)
			 driver = new EdgeDriver(); //To open Edge Browser
		}
		 
		  
		  //Reporter.log("Open chrome Driver");//In the Report it will show the exact text which is there in Inverted commas
		 
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
		  Name = FirstName;
		  driver.findElement(By.xpath("//input[@name='middleName']")).sendKeys(MiddleName);//MiddleName field using Relative Xpath
		  Thread.sleep(3000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
		  driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(LastName);//LastName field using Relative Xpath
		  Thread.sleep(3000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
		  
		  driver.findElement(By.xpath("(//input)[6]")).sendKeys(Keys.CONTROL+"A"+ Keys.BACK_SPACE);//To clear any Text Field
		  Thread.sleep(3000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
		  
		  driver.findElement(By.xpath("//button[@type='submit']")).click();//Click on Save button using Relative Xpath
		  Thread.sleep(5000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
		
  }
	@Test(dataProvider = "dp2",priority = 2,enabled = true)
	  public void EditOrganeHRM(String OtherID) throws InterruptedException {
		  
		  driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");//Navigate to this URL
		  Thread.sleep(5000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
		  
		     Actions Act = new Actions(driver);// To perform actions basically keyboards keys eg:Enter,down arrow key.
			 Act.sendKeys(driver.findElement(By.xpath("(//input)[@placeholder='Type for hints...'][1]")),Name );//Entered value as Dis - Employee Name field using Relative Xpath
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
			 Thread.sleep(6000);//wait Element basically to wait for 5 seconds and add exception at 1st Line
			 
			 
			 driver.findElement(By.xpath("(//input)[6]")).sendKeys(OtherID);//Other ID Field using Relative Xpath
			 Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
			 
			 driver.findElement(By.xpath("(//button)[4]")).click();//Click on Save button using Relative Xpath
			 Thread.sleep(5000);//wait Element basically to wait for 5 seconds and add exception at 1st Line
			 
			
			  
	  }
	  
	  
	 // @Test(dataProvider = "dp3",priority = 3,enabled = true)
	  public void DeleteOrganeHRM(String TEST) throws InterruptedException {
		  
		  driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");//Navigate to this URL
		  Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
		  
		     Actions Act = new Actions(driver);// To perform actions basically keyboards keys eg:Enter,down arrow key.
			 Act.sendKeys(driver.findElement(By.xpath("(//input)[@placeholder='Type for hints...'][1]")),Name );//Entered value as  - Employee Name field using Relative Xpath
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
	  
	  
	  @Test(dataProvider = "dp4",priority = 4,enabled = true)
	  public void AddLeave(String TEST,String Entitlement) throws InterruptedException {
		  
		  driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/leave/addLeaveEntitlement");//Navigate to this URL
		  Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
		  
		  
		     Actions Act = new Actions(driver);// To perform actions basically keyboards keys eg:Enter,down arrow key.
			 Act.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")),Name);//Entered value as  - Employee Name field using Relative Xpath
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
	  
	  @Test(dataProvider = "dp5",priority = 5,enabled = true)
	  public void EditLeave(String TEST2,String Entitlement2) throws InterruptedException {
		  
		  Thread.sleep(5000);//wait Element basically to wait for 5 seconds and add exception at 1st Line
		    JavascriptExecutor js = (JavascriptExecutor) driver; // To scroll down
			 js.executeScript("window.scrollBy(0,300)", "");// To scroll down
			 Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
		  
		  driver.findElement(By.xpath("(//button)[8]")).click();//Edit button using Relative Xpath
		  Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
		  
		  driver.findElement(By.xpath("(//input)[3]")).sendKeys(Keys.CONTROL+"A"+ Keys.BACK_SPACE);//To clear any Text Field
		  Thread.sleep(3000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
		  
		  driver.findElement(By.xpath("(//input)[3]")).sendKeys(Entitlement2);//To clear any Text Field
		  Thread.sleep(3000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
		  
		  driver.findElement(By.xpath("//button[@type='submit']")).click();//Save button using Relative Xpath
		  Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
		  
	  
		  
	  }
	  
	  
	  @Test(dataProvider = "dp6",priority = 6,enabled = true)
	  public void DeleteLeave(String TEST3) throws InterruptedException {
		  
		    Thread.sleep(5000);//wait Element basically to wait for 5 seconds and add exception at 1st Line
		    JavascriptExecutor js = (JavascriptExecutor) driver; // To scroll down
			 js.executeScript("window.scrollBy(0,300)", "");// To scroll down
			 Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
		  
		  driver.findElement(By.xpath("(//button)[7]")).click();//Delete button using Relative Xpath
		  Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
		  
		  driver.findElement(By.xpath("(//button)[11]")).click();//Click on Yes,Delete button using Relative Xpath
	       Thread.sleep(5000);//wait Element basically to wait for 5 seconds and add exception at 1st Line
		  

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
	  
	  @DataProvider
	  public Object[][] dp5() {
	    return new Object[][] {
	      new Object[] {"","6"},
	      //new Object[] {"b" },
	    };
	  }
	  
	  @DataProvider
	  public Object[][] dp6() {
	    return new Object[][] {
	      new Object[] {""},
	      //new Object[] {"b" },
	    };
	  }
	  
	  
	  
	//Below code is to pass the data from Excel
	  @DataProvider(name = "excelData")
	  public Object[][] excelDataProvider() throws IOException {

	      // We are creating an object from the excel sheet data by calling a method that
	      // reads data from the excel stored locally in our system
	      Object[][] arrObj = getExcelData(
	              "D:\\Disha Sohanda-Projects\\SeleniumTestNG\\TestData\\TestDataSheet.xlsx","OrangeHRM");
	      return arrObj;
	}

	  // This method handles the excel - opens it and reads the data from the
	  // respective cells using a for-loop & returns it in the form of a string array
	  public String[][] getExcelData(String fileName, String sheetName) throws IOException {
	      String[][] data = null;
	      try {

	          FileInputStream fis = new FileInputStream(fileName);
	          XSSFWorkbook workbook = new XSSFWorkbook(fis);
	          XSSFSheet sheet = workbook.getSheet(sheetName);
	          XSSFRow row = sheet.getRow(0);
	          int noOfRows = sheet.getPhysicalNumberOfRows();
	          int noOfCols = row.getLastCellNum();
	          XSSFCell cell;
	          data = new String[noOfRows - 1][noOfCols];

	          for (int i = 1; i < noOfRows; i++) {
	              for (int j = 0; j < noOfCols; j++) {
	                  row = sheet.getRow(i);
	                  cell = row.getCell(j);
	                  data[i - 1][j] = cell.getStringCellValue();
	              }
	          }
	      } catch (Exception e) {
	          System.out.println("The exception is: " + e.getMessage());
	      }
	      return data;
	  }
	  
	  
	  
	
	
}
