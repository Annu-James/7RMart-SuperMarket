package testScript;

import static org.testng.Assert.assertThrows;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import constants.Constants;
import utilities.Excel_Utilities;

import pages.Admin_User;
import pages.Login_Page;

public class AdminUser_Test extends Base {
	@Test(description = "Verify whether user can add new admin User")
  @Parameters({"User name","Password"})
  public void verify_User_can_ClickAdminUser(String userName,String password) throws IOException
  {
	  Login_Page loginPage=new Login_Page(driver);
	  loginPage.enterUserNameField(userName);
	  loginPage.enterPasswordField(password);
	  loginPage.clickSubmitButton();
	  
	  Admin_User adminUser=new Admin_User(driver);
	  adminUser.adminUserClick();
	  adminUser.newUserClick();
	  String userNameValue1=Excel_Utilities.getStringData(1, 0,"Admin");
	  String passwordValue1=Excel_Utilities.getStringData(1, 1, "Admin");
	  String userTypeValue=Excel_Utilities.getStringData(1, 2, "Admin");
      adminUser.enterUserName(userNameValue1);
	  adminUser.enterPassword(passwordValue1);
	  adminUser.userType(userTypeValue);
	  adminUser.clickSubmitButton1();
      boolean isNewUserCreated= adminUser.isNewUserIsAdded();
	   assertTrue(isNewUserCreated, Constants.ERRORMESSAGEADMIN);
	  
  }
}
