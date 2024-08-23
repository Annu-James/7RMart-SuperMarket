package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.Login_Page;
import pages.ManageProduct_New;
import utilities.Excel_Utilities;

public class ManageProductNew_Test extends Base{
  @Test(description = "Check whether user can add new Product to the List")
 
  public void verify_UserCan_Add_NewProduct() throws IOException 
  {
	  String userNameValue=Excel_Utilities.getStringData(1, 0, "Login page");
      String passwordValue=Excel_Utilities.getStringData(1, 1, "Login page");
	  Login_Page loginPage=new Login_Page(driver);
	  loginPage.enterUserNameField(userNameValue);
	  loginPage.enterPasswordField(passwordValue);
	  loginPage.clickSubmitButton();
	  
	  ManageProduct_New product=new ManageProduct_New(driver);
	  String titleVal=Excel_Utilities.getStringData(1, 0, "Manage Product-New");
	  String categoryVal=Excel_Utilities.getStringData(1, 1, "Manage Product-New");
	  String subCateValue=Excel_Utilities.getStringData(1, 2,"Manage Product-New");
	  String weightVal=Excel_Utilities.getIntegerData(1, 3, "Manage Product-New");
	  String weightUnitVal=Excel_Utilities.getStringData(1, 4, "Manage Product-New");
	  String maxiOrderqty=Excel_Utilities.getIntegerData(1, 5, "Manage Product-New");
	  String price=Excel_Utilities.getIntegerData(1, 6, "Manage Product-New");
	  String stock=Excel_Utilities.getIntegerData(1, 7, "Manage Product-New");
	  product.gotoManageProduct();
	  product.newProductClick();
	  product.productTitle(titleVal);
	  product.productType();
	  product.productCategory(categoryVal);
	  product.subCategory(subCateValue);
	  product.priceType();
	  product.weightValue(weightVal);
	  product.weightUnit(weightUnitVal);
	  product.quantity(maxiOrderqty);
	  product.price(price);
	  product.stockAvail(stock);
	  //product.stockRadio();
	  //product.featuredRadio();
	  product.comboPack();
	  product.save();
	  boolean isprductAdded=product.isPrdouctadded();
	  assertTrue(isprductAdded,Constants.ERRORMESSAGE_MANAGEPRODUCT_NEW);
  }
}
