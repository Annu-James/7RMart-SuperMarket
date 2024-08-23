package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.Login_Page;
import pages.Manage_Pages;
import utilities.Excel_Utilities;

public class ManagePages_Test extends Base {
  @Test
  public void verify_user_Can_Add_NewProduct() throws IOException 
  {
	  String userNameValue=Excel_Utilities.getStringData(1, 0, "Login page");
      String passwordValue=Excel_Utilities.getStringData(1, 1, "Login page");
	  Login_Page loginPage=new Login_Page(driver);
	  loginPage.enterUserNameField(userNameValue);
	  loginPage.enterPasswordField(passwordValue);
	  loginPage.clickSubmitButton();
	  
	  Manage_Pages managePages=new Manage_Pages(driver);
	  managePages.clickManageContent();;
	  managePages.clickManagePage();
	  managePages.clickNewListPage();
	  String productTitle=Excel_Utilities.getStringData(1, 0, "Manage Pages-NewClick");
	  String productDescription=Excel_Utilities.getStringData(1, 1, "Manage Pages-NewClick");
	  String productPageName=Excel_Utilities.getStringData(1, 2, "Manage Pages-NewClick");
	  String filePath=Excel_Utilities.getStringData(1, 3, "Manage Pages-NewClick");
	  managePages.enterProductTitle(productTitle);
	  managePages.enterProductDetails(productDescription);
	  managePages.enterProductPageName(productPageName);
	  managePages.uploadProductImage(filePath);
	  managePages.clickSaveButton();
	  boolean isNewProductisVisible=managePages.isNewProductAdded();
	  assertTrue(isNewProductisVisible, Constants.ERRORMESSAGEMANAGEPAGES);
  }
}
