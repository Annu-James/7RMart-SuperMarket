package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constants;
import pages.Login_Page;
import pages.ManageCategory_SubCategory_New;
import utilities.Excel_Utilities;

public class ManageCategory_SubCategory_Test extends Base{
	Login_Page loginPage;
	ManageCategory_SubCategory_New subCategory;
  @Test
  @Parameters({ "User name", "Password" })
  public void verify_UserCan_SelectCategory(String userName, String password) throws IOException 
  {
	  loginPage=new Login_Page(driver);
	  loginPage.enterUserNameField(userName).enterPasswordField(password).clickSubmitButton();
	  
	  String categoryValue=Excel_Utilities.getStringData(1, 0, "ManageCategory- Sub Category");
	  String subCategoryValue=Excel_Utilities.getStringData(1, 1, "ManageCategory- Sub Category");
	  String imagePth=Excel_Utilities.getStringData(1, 2, "ManageCategory- Sub Category");
	  
	  subCategory= loginPage.subManageCategoryClick2().newCategoryClick().categorySelect(categoryValue).subCategoryData(subCategoryValue).imageUpload(imagePth).saveData();
	 /* subCategory.subManageCategoryClick2();
	  subCategory.newCategoryClick();
	  
	  subCategory.categorySelect(categoryValue);
	  subCategory.subCategoryData(subCategoryValue);
	  subCategory.imageUpload(imagePth);
	  subCategory.saveData();*/
	  boolean issubCategoryDisplayed=subCategory.isDataAddedToSubCategory();
	  assertTrue(issubCategoryDisplayed,Constants.ERRORMESSAGE_SUBCATEGORY);
  }
}
