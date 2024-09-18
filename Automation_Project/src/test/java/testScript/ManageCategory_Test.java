package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constants;
import pages.Login_Page;
import pages.ManageCategory;
import utilities.Excel_Utilities;

public class ManageCategory_Test extends Base {
	Login_Page loginPage;
	ManageCategory manageNew;
  @Test
  @Parameters({"User name","Password"})
  public void verify_UserCan_ManageCategory(String userName,String password) throws IOException {
	 // String userNameValue=Excel_Utilities.getStringData(1, 0, "Login page");
     // String passwordValue=Excel_Utilities.getStringData(1, 1, "Login page");
	  loginPage=new Login_Page(driver);
	  loginPage.enterUserNameField(userName).enterPasswordField(password).clickSubmitButton();
	
	  String categoryValue=Excel_Utilities.getStringData(1, 0, "Manage Category");
	  String selectGroupValue=Excel_Utilities.getStringData(1, 1, "Manage Category");
	  String image=Excel_Utilities.getStringData(1, 2, "Manage Category");
	  manageNew= loginPage.goToCategory1().clickNewButton()
			  .inputCategory(categoryValue).clickDiscount()
			  .imageUpload(image).clickRadioButton()
			  .clickRadioLeftMenu().clickSave();
	
	  /* manageNew.goToCategory();
	  manageNew.clickNewButton();
	  manageNew.inputCategory(categoryValue);
	  manageNew.clickDiscount();
	  manageNew.imageUpload(image);
	  manageNew.clickRadioButton();
	  manageNew.clickRadioLeftMenu();
	  manageNew.clickSave();*/
	  boolean issaveDisplayed=manageNew.isCategoryisSaved();
	  assertTrue(issaveDisplayed,Constants.ERRORMESSAGE_MANAGECATEGORY);
	  
  }
}
