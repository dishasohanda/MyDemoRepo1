package PK2demoguru99;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class MyProjectScreenshot {

	int count=0;
	public void DemoGuru99Screenshots(WebDriver driver,String TID) {
		
		TakesScreenshot screenshot1 = (TakesScreenshot)driver;
		  //Saving the screenshot in desired location
		  File source1 = screenshot1.getScreenshotAs(OutputType.FILE);
		  //Path to the location to save screenshot
		  String Destination1 = "./Screenshots/" + TID + count+ ".png" ;
		  File FinalDestination1 = new File(Destination1);
		  try {
			FileHandler.copy(source1,FinalDestination1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		count++;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
