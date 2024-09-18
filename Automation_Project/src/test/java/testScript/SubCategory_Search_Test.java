package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constants;
import pages.Login_Page;
import pages.SubCategory_Search;
import utilities.Excel_Utilities;

public class SubCategory_Search_Test extends Base {
	Login_Page loginPage;
	SubCategory_Search search;
	@Test(description = "Verify whether user can search a product from sub category")
	 @Parameters({"User name","Password"})
	public void verifyUserCanSearchSubCategory(String userName,String password) throws IOException {
		//String userNameValue = Excel_Utilities.getStringData(1, 0, "Login page");
		//String passwordValue = Excel_Utilities.getStringData(1, 1, "Login page");
		loginPage = new Login_Page(driver);
		loginPage.enterUserNameField(userName).enterPasswordField(password).clickSubmitButton();

		String categoryValu = Excel_Utilities.getStringData(1, 0, "Sub Category Search");
		String subcategoryValue = Excel_Utilities.getStringData(1, 1, "Sub Category Search");
		search = loginPage.subManageCategoryClick().searchClick().enterCategorydetail(categoryValu).subCategoryData(subcategoryValue).clickSearchButton();
		/*search.subManageCategoryClick();
		search.searchClick();
		
		search.enterCategorydetail(categoryValu);
		search.subCategoryData(subcategoryValue);
		search.clickSearchButton();*/
		boolean isSearchpossible = search.isSearchDataisDisplayed();
		assertTrue(isSearchpossible, Constants.ERRORMESSAGE_SUBCATEGORY_SEARCH);
	}
}
