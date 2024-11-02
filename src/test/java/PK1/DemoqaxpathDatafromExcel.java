package PK1;

import org.testng.annotations.Test;

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


public class DemoqaxpathDatafromExcel {
	WebDriver driver;
	@Test(dataProvider = "excelData",enabled = true)
  public void DemoqaRelativexpath(String Browser,String Name, String LastName, String Email,String MobileNumber,String Address) throws InterruptedException {
	  //Reporter.log("Set chrome Driver"); //In the Report it will show the exact text which is there in Inverted commas
		// System.setProperty("webdriver.chrome.driver", "./Browsers/chromedriver.exe"); //where chromedriver exists(path)
		//Reporter.log("Open chrome Driver");//In the Report it will show the exact text which is there in Inverted commas
		// WebDriver driver= new ChromeDriver(); //To open Chrome Browser
	  
	 if (Browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Browsers/chromedriver.exe"); //where chromedriver exists(path)
			 driver = new ChromeDriver(); //To open Chrome Browser
			
		}
		
		if (Browser.equals("Edge")) {
			System.setProperty("webdriver.edge.driver", "./Browsers/msedgedriver.exe");//where Edge exists(path)
			 driver = new EdgeDriver(); //To open Edge Browser
		}
	  
	  
	  
	  
	  
	  
	  
	  Reporter.log("Open Website URL");//In the Report it will show the exact text which is there in Inverted commas
	  driver.get("https://demoqa.com/automation-practice-form/"); //To open Website URL
	  Thread.sleep(5000); //wait Element basically to wait for 5 seconds and add exception at 1st Line
	  driver.manage().window().maximize();// To maximize the window
	 driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(Name);//Name Field using Relative Xpath
	  Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
	  driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(LastName);//LastName Field using Relative Xpath
	  Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
	  driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(Email);//Email Field using Relative Xpath
	  Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
	  
	  JavascriptExecutor js = (JavascriptExecutor) driver; // To scroll down
		 js.executeScript("window.scrollBy(0,300)", "");// To scroll down
		 Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line 
		 
		 driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[3]/div[2]/div[2]/label")).click();//Gender Radiobutton using Absolute Xpath
		 Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
		 driver.findElement(By.xpath("//input[@id='userNumber']")).sendKeys(MobileNumber);//Mobile Number Field using Relative Xpath
		 Thread.sleep(3000);//wait Element basically to wait for 3 seconds and add exception at 1st Line
		 
		 driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[7]/div[2]/div[1]/label")).click();//Hobbies Checkbox using Absolute Xpath
		 Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
		 driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys(Address);//Current Address Field using Relative Xpath
		 Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
		 driver.findElement(By.xpath("//input[@id='dateOfBirthInput']")).click();//Date of Birth field using Relative Xpath
		 Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line 
		 driver.findElement(By.xpath("//button[@aria-label='Previous Month']")).click();//from calendar selecting previous month using Relative Xpath
		 Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line 
		 driver.findElement(By.xpath("//div[text()='14']")).click();//Text value as 14 it means selecting 14th date of the month using Relative Xpath
		 Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line 
		 driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\Dell\\Desktop\\Ganpati Bappa.jpg");//Adding Image using Relative Xpath
		 Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
		 js.executeScript("window.scrollBy(0,300)", "");// To scroll down
		 Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
		 driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[6]/div[2]/div/div/div[1]")).click();//click on subject field using Relative Xpath
		 Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line 
		 
		// driver.findElement(By.xpath("//input[@id='subjectsInput']")).sendKeys("Com" + Keys.ARROW_DOWN + Keys.RETURN);//Current Address Field using Relative Xpath
		 Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line
		 Actions Act = new Actions(driver);// To perform actions basically keyboards keys eg:Enter,down arrow key.
		 Act.sendKeys(driver.findElement(By.xpath("//input[@id='subjectsInput']")),"Com" );//Entered value as Com - subject field using Relative Xpath
		 Act.build().perform();
		 Act.sendKeys(Keys.ARROW_DOWN);
		 Act.build().perform();
		 Act.sendKeys(Keys.ENTER);
		 Act.build().perform();
		 Thread.sleep(1000);//wait Element basically to wait for 1 seconds and add exception at 1st Line
		 driver.findElement(By.xpath("//button[@id='submit']")).click();//Submit Button using Relative Xpath
		 Thread.sleep(2000);//wait Element basically to wait for 2 seconds and add exception at 1st Line 
		 driver.close();// To Close Chrome browser
		 
			  
  }
  
	//Below code is to pass the data from Excel
 @DataProvider(name = "excelData")
  public Object[][] excelDataProvider() throws IOException {

      // We are creating an object from the excel sheet data by calling a method that
      // reads data from the excel stored locally in our system
      Object[][] arrObj = getExcelData(
              "D:\\Disha Sohanda-Projects\\SeleniumTestNG\\TestData\\TestDataSheet.xlsx","DemoQA");
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
