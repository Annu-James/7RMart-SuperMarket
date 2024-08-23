package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.Admin_User_Search;
import pages.Login_Page;
import utilities.Excel_Utilities;

public class Search_AdminUser_Test extends Base {
  @Test(description = "Veridy whether user can search AdminUser")
  public void verify_UserSearch_with_Valid_Credentials() throws IOException 
  {
	  String userNameValue=Excel_Utilities.getStringData(1, 0, "Login page");
      String passwordValue=Excel_Utilities.getStringData(1, 1, "Login page");
	  Login_Page loginPage=new Login_Page(driver);
	  loginPage.enterUserNameField(userNameValue);
	  loginPage.enterPasswordField(passwordValue);
	  loginPage.clickSubmitButton();
	  
	  Admin_User_Search userSearch=new Admin_User_Search(driver);
	  userSearch.adminUserClick();
	  userSearch.clickSearch();
	  String userNameVal=Excel_Utilities.getStringData(1, 0, "Admin Search");
	  String userTypeVal=Excel_Utilities.getStringData(1, 1, "Admin Search");
	  userSearch.enterUserName(userNameVal);
	  userSearch.selectUserType(userTypeVal);
	  userSearch.clickSearchButton();
	  boolean adminSearch=userSearch.isEnteredAdminInSearchisDisplayed();
	  assertTrue(adminSearch, Constants.ERRORMESSAGE_ADMINSEARCH);
  }
}
