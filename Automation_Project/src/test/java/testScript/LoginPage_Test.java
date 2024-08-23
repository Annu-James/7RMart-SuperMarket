package testScript;

import static org.testng.Assert.assertEquals; 
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constants;
import pages.Login_Page;
import utilities.Excel_Utilities;

public class LoginPage_Test extends Base{
	@Test(retryAnalyzer = retry.Retry.class)
	@Parameters({"User name","Password"})
	public void verify_User_is_Able_To_Login_Using_Valid_Credentials(String userName, String password) throws IOException {
	    Login_Page loginPage = new Login_Page(driver);
	  // String userName=Excel_Utilities.getStringData(1, 0, "Login page");
	   // String password=Excel_Utilities.getStringData(1, 1, "Login page");
	    loginPage.enterUserNameField(userName);
	    loginPage.enterPasswordField(password);
	    loginPage.clickSubmitButton();
	    boolean isHomePageLoaded = loginPage.isDashboardisLoaded();
	    assertTrue(isHomePageLoaded, Constants.ERRORMESSAGELOGIN);
	  
	}

	@Test(groups = {"Smoke testing"})
	public void verify_User_is_Able_toLoginUsing_Invalid_UserName_and_Validpassword() throws IOException {
	    Login_Page loginPage = new Login_Page(driver);
	   String username=Excel_Utilities.getStringData(2, 0, "Login page");
	   String password=Excel_Utilities.getStringData(2, 1, "Login page");
	    loginPage.enterUserNameField(username);
	    loginPage.enterPasswordField(password);
	    loginPage.clickSubmitButton();  
	    boolean isAlertDisplayed = loginPage.isAlertisDisplayed();
	    assertTrue(isAlertDisplayed, "Alert is not displayed");
	}
  @Test
  public void verify_User_is_Able_toLoginUsing_Valid_UserName_and_Invalidpassword()
  {
	  String userVal="admin";
	  String passwordVal="Abc123";
	  Login_Page loginpage2=new Login_Page(driver);
	  loginpage2.enterUserNameField(userVal);
	  loginpage2.enterPasswordField(passwordVal);
	  loginpage2.clickSubmitButton();
	  boolean isAlertDisplayed=loginpage2.isAlertisDisplayed();
	  assertTrue(isAlertDisplayed,"Alert is not Displayed");
  }
  @Test
  public void verify_User_is_Able_toLoginUsing_Invalid_Crendentials()
  {
	  String userVal="Abcxyz";
	 // String passwordVal="Abc*123";
	  Login_Page loginpage3=new Login_Page(driver);
	  loginpage3.enterUserNameField(userVal);
	  loginpage3.enterPasswordField("Abc*123");
	  loginpage3.clickSubmitButton();
	  boolean isAlertDisplayed=loginpage3.isAlertisDisplayed();
	  assertTrue(isAlertDisplayed,"Alert is not Displayed");
  }
}
