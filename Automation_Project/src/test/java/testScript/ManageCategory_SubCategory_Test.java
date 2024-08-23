package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.Login_Page;
import pages.ManageCategory_SubCategory_New;
import utilities.Excel_Utilities;

public class ManageCategory_SubCategory_Test extends Base{
  @Test
  public void verify_UserCan_SelectCategory() throws IOException 
  {
	  String userNameValue=Excel_Utilities.getStringData(1, 0, "Login page");
      String passwordValue=Excel_Utilities.getStringData(1, 1, "Login page");
	  Login_Page loginPage=new Login_Page(driver);
	  loginPage.enterUserNameField(userNameValue);
	  loginPage.enterPasswordField(passwordValue);
	  loginPage.clickSubmitButton();
	  
	  ManageCategory_SubCategory_New subCategory=new ManageCategory_SubCategory_New(driver);
	  subCategory.subManageCategoryClick();
	  subCategory.newCategoryClick();
	  String categoryValue=Excel_Utilities.getStringData(1, 0, "ManageCategory- Sub Category");
	  String subCategoryValue=Excel_Utilities.getStringData(1, 1, "ManageCategory- Sub Category");
	  String imagePth=Excel_Utilities.getStringData(1, 2, "ManageCategory- Sub Category");
	  subCategory.categorySelect(categoryValue);
	  subCategory.subCategoryData(subCategoryValue);
	  subCategory.imageUpload(imagePth);
	  subCategory.saveData();
	  boolean issubCategoryDisplayed=subCategory.isDataAddedToSubCategory();
	  assertTrue(issubCategoryDisplayed,Constants.ERRORMESSAGE_SUBCATEGORY);
  }
}
