package PK1;

import org.testng.annotations.Test;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

public class DataProviderTest {
  @Test(dataProvider = "dp")
  public void LoginTest(String US, String PW) {
	  Reporter.log("LoginTest");
	  Reporter.log("Username is " + US);
	  Reporter.log("Password is " + PW);
  }
  
  @Test(dataProvider = "reg")
  public void Registration(String Mailid, String Phone, String Name) {
	  
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "WrongUserName", "RightPassword" },
      new Object[] { "UserName", "Password" },
      new Object[] { "RightUserName", "WrongPassword" }
    };
  }
  
  @DataProvider
  public Object[][] reg() {
    return new Object[][] {
      new Object[] { "Wrongmailid", "Rightphone" , "RightName" },
  
    };
  }
  
}
