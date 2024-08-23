package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.Login_Page;
import pages.SubCategory_Search;
import utilities.Excel_Utilities;

public class SubCategory_Search_Test extends Base {
	@Test(description = "Verify whether user can search a product from sub category")
	public void verifyUserCanSearchSubCategory() throws IOException {
		String userNameValue = Excel_Utilities.getStringData(1, 0, "Login page");
		String passwordValue = Excel_Utilities.getStringData(1, 1, "Login page");
		Login_Page loginPage = new Login_Page(driver);
		loginPage.enterUserNameField(userNameValue);
		loginPage.enterPasswordField(passwordValue);
		loginPage.clickSubmitButton();

		SubCategory_Search search = new SubCategory_Search(driver);
		search.subManageCategoryClick();
		search.searchClick();
		String categoryValu = Excel_Utilities.getStringData(1, 0, "Sub Category Search");
		String subcategoryValue = Excel_Utilities.getStringData(1, 1, "Sub Category Search");
		search.enterCategorydetail(categoryValu);
		search.subCategoryData(subcategoryValue);
		search.clickSearchButton();
		boolean isSearchpossible = search.isSearchDataisDisplayed();
		assertTrue(isSearchpossible, Constants.ERRORMESSAGE_SUBCATEGORY_SEARCH);
	}
}
