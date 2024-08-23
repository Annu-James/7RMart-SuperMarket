package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.Login_Page;
import pages.ManagePages_Search;
import utilities.Excel_Utilities;

public class ManagePagesSearch_Test extends Base {
  @Test
  public void verifySearchProductisVisible() throws IOException
  {
	  String userNameValue=Excel_Utilities.getStringData(1, 0, "Login page");
      String passwordValue=Excel_Utilities.getStringData(1, 1, "Login page");
	  Login_Page loginPage=new Login_Page(driver);
	  loginPage.enterUserNameField(userNameValue);
	  loginPage.enterPasswordField(passwordValue);
	  loginPage.clickSubmitButton();
	  
	  ManagePages_Search manageSearch=new ManagePages_Search(driver);
	  manageSearch.manageContentClick();
	  manageSearch.managePagesClick();
	  String titleValue=Excel_Utilities.getStringData(1, 0, "ManagePages-Search");
	  manageSearch.searchManagePages();
	  manageSearch.enterTitle(titleValue);
	  manageSearch.clickSearchButton();
	  boolean productVisible=manageSearch.isEnterProductisVisible();
	  assertTrue(productVisible,Constants.ERRORMESSAGESEARCH);
  }
}
