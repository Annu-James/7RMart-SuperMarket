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
  @Test
  public void verifyUserCanSearchCategory() throws IOException
  {
	  String userNameValue=Excel_Utilities.getStringData(1, 0, "Login page");
      String passwordValue=Excel_Utilities.getStringData(1, 1, "Login page");
	  Login_Page loginPage=new Login_Page(driver);
	  loginPage.enterUserNameField(userNameValue);
	  loginPage.enterPasswordField(passwordValue);
	  loginPage.clickSubmitButton();
	  
	  Category_Search search=new Category_Search(driver);
	  search.goToCategory();
	  search.clickSearchDetail();
	  String searchData=Excel_Utilities.getStringData(1, 0, "Category-Search");
	  search.enterCategory(searchData);
	  search.clickSearchButton();
	  boolean isDetailDisplayed=search.isSearchisDisplayed();
	  assertTrue(isDetailDisplayed,Constants.ERRORMESSAGE_CATEGORY_SEARCH);
  }
}
