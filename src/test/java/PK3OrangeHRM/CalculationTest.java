package PK3OrangeHRM;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class CalculationTest {
  //@Test(dataProvider = "dp")
  public void Add(int FirstNumber,int SecondNumber,int Expected) {
	  
	  int result =  FirstNumber + SecondNumber;
	  System.out.println("Add is " + result);
	  Assert.assertEquals(result, Expected);
	  
  }
  
  
  
  @Test(dataProvider = "dp2")
  public void TaxCalculation(String Case,int FirstNumber,int SecondNumber,int Expected) {
	  int Tax = 0;
	  switch(Case) {
	  
	  case "India" :
		  Tax = 18;
		  //If I need to do any calculations we can specify here.
		  System.out.println("India Tax is " + Tax);
		break;  
		
	  case "US" :
		  Tax = 1;
		  //If I need to do any calculation we can specify here.
		  
		  System.out.println("US Tax is " + Tax);
		break;  
	  
	  default:
		  System.out.println("Default Tax is " + Tax);
	  
	  }
	  
	//  int result =  FirstNumber + SecondNumber;
	//  System.out.println("Add is " + result);
	  Assert.assertEquals(Tax, Expected);
	  
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, 1, 2 },
      new Object[] { 2, 2, 4 },
      new Object[] { 3, 3, 5 },
      
      //new Object[] { 2, "b" },
    };
  }
  
  @DataProvider
  public Object[][] dp2() {
    return new Object[][] {
      new Object[] {"India",1 ,1,18},
      new Object[] {"US",2,2,1},
      new Object[] {"UK",2,2,5},
      
      //new Object[] { 2, "b" },
    };
  }
  
  
  
  
}
