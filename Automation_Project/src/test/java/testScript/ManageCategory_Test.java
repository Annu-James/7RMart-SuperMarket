package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.Login_Page;
import pages.ManageCategory;
import utilities.Excel_Utilities;

public class ManageCategory_Test extends Base {
  @Test
  public void verify_UserCan_ManageCategory() throws IOException 
  {
	  String userNameValue=Excel_Utilities.getStringData(1, 0, "Login page");
      String passwordValue=Excel_Utilities.getStringData(1, 1, "Login page");
	  Login_Page loginPage=new Login_Page(driver);
	  loginPage.enterUserNameField(userNameValue);
	  loginPage.enterPasswordField(passwordValue);
	  loginPage.clickSubmitButton();
	  
	  ManageCategory manageNew=new ManageCategory(driver);
	  manageNew.goToCategory();
	  manageNew.clickNewButton();
	  String categoryValue=Excel_Utilities.getStringData(1, 0, "Manage Category");
	  String selectGroupValue=Excel_Utilities.getStringData(1, 1, "Manage Category");
	  String image=Excel_Utilities.getStringData(1, 2, "Manage Category");
	  manageNew.inputCategory(categoryValue);
	  manageNew.clickDiscount();
	  manageNew.imageUpload(image);
	  manageNew.clickRadioButton();
	  manageNew.clickRadioLeftMenu();
	  manageNew.clickSave();
	  boolean issaveDisplayed=manageNew.isCategoryisSaved();
	  assertTrue(issaveDisplayed,Constants.ERRORMESSAGE_MANAGECATEGORY);
	  
  }
}
