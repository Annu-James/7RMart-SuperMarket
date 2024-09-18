package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constants;
import pages.Admin_User_Search;
import pages.Login_Page;
import utilities.Excel_Utilities;

public class Search_AdminUser_Test extends Base {
	Login_Page loginpage;
	Admin_User_Search adminSearch;
  @Test(description = "Veridy whether user can search AdminUser")
  @Parameters({ "User name", "Password" })
  public void verify_UserSearch_with_Valid_Credentials(String userNameValue,String passwordValue) throws IOException 
  {
	 loginpage=new Login_Page(driver);
	  loginpage.enterUserNameField(userNameValue).enterPasswordField(passwordValue).clickSubmitButton();

	  String userNameVal=Excel_Utilities.getStringData(1, 0, "Admin Search");
	  String userTypeVal=Excel_Utilities.getStringData(1, 1, "Admin Search");
	  adminSearch=loginpage.adminUserClick2().clickSearch().enterUserName(userNameVal).selectUserType(userTypeVal).clickSearchButton();
	  /*adminSearch=loginpage.enterUserNameField(userNameValue)
			  .enterPasswordField(passwordValue)
			  .clickAdminSubmit()
			  .adminUserClick()
			  .clickSearch()
			  .enterUserName(userNameVal)
			  .selectUserType(userTypeVal)
			  .clickSearchButton();*/
	  boolean adminSearch1=adminSearch.isEnteredAdminInSearchisDisplayed();
	  assertTrue(adminSearch1, Constants.ERRORMESSAGE_ADMINSEARCH);
	 
	  /*loginpage.clickSubmitButton();
	  // String userNameValue=Excel_Utilities.getStringData(1, 0, "Login page");
     // String passwordValue=Excel_Utilities.getStringData(1, 1, "Login page");
	  Admin_User_Search userSearch=new Admin_User_Search(driver);
	  userSearch.adminUserClick();
	  userSearch.clickSearch();
	  String userNameVal=Excel_Utilities.getStringData(1, 0, "Admin Search");
	  String userTypeVal=Excel_Utilities.getStringData(1, 1, "Admin Search");
	  userSearch.enterUserName(userNameVal);
	  userSearch.selectUserType(userTypeVal);
	  userSearch.clickSearchButton();*/
	  
  }
}
