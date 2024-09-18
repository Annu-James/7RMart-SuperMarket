package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constants;
import pages.Category_Search;
import pages.Login_Page;
import utilities.Excel_Utilities;

public class CategorySearch_Test extends Base{
	Login_Page loginPage;
	 Category_Search search;
  @Test
  @Parameters({"User name","Password"})
  public void verifyUserCanSearchCategory(String userName,String password) throws IOException
  {
	  //String userNameValue=Excel_Utilities.getStringData(1, 0, "Login page");
      //String passwordValue=Excel_Utilities.getStringData(1, 1, "Login page");
	  loginPage=new Login_Page(driver);
	  loginPage.enterUserNameField(userName).enterPasswordField(password).clickSubmitButton();
	  String searchData=Excel_Utilities.getStringData(1, 0, "Category-Search");
	  search=loginPage.goToCategory().clickSearchDetail().enterCategory(searchData).clickSearchButton();
	  
	 /* search.goToCategory();
	  search.clickSearchDetail();
	  search.enterCategory(searchData);
	  search.clickSearchButton();*/
	  boolean isDetailDisplayed=search.isSearchisDisplayed();
	  assertTrue(isDetailDisplayed,Constants.ERRORMESSAGE_CATEGORY_SEARCH);
  }
}
