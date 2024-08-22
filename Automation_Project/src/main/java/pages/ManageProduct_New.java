package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUpload_Utilities;
import utilities.Page_Utilities;

public class ManageProduct_New {
WebDriver driver;
public ManageProduct_New(WebDriver driver)
{
this.driver=driver;
PageFactory.initElements(driver, this);
}
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product'][@class='small-box-footer']")WebElement clickManageProduct;
@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement clickNewProduct;
@FindBy(xpath="//input[@id='title']")WebElement enterProductTitle;
@FindBy(xpath="//input[@value='Others']")WebElement selectProductType;
@FindBy(xpath="//select[@id='cat_id']")WebElement selectCategory;
@FindBy(xpath="//select[@id='sub_id']")WebElement selectSubCategory;
@FindBy(xpath="//input[@id='purpose']")WebElement selectPriceType;
@FindBy(xpath="//input[@id='m_weight']")WebElement enterWeightValue;
@FindBy(xpath="//select[@id='w_unit']")WebElement selectWeightUnit;
@FindBy(xpath="//input[@id='max_weight']")WebElement maxQuantity;
@FindBy(xpath="//input[@id='w_price']")WebElement enterWeightPrice;
@FindBy(xpath="//input[@id='w_stock']")WebElement enterStockAvailability;
@FindBy(xpath="//input[@name='stock'][@value='yes']")WebElement radioStock;
@FindBy(xpath="//input[@name='featured'][@value='yes']")WebElement radioFeatured;
@FindBy(xpath="//input[@name='featured'][@value='no']")WebElement radioComboPack;
@FindBy(xpath="//button[@name='create']")WebElement clickSaveButton;
FileUpload_Utilities inputP=new FileUpload_Utilities();
Page_Utilities select=new Page_Utilities();
public void gotoManageProduct()
{
	clickManageProduct.click();
}
public void newProductClick()
{
	clickNewProduct.click();
}
public void productTitle(String productName)
{
	inputP.usingSendKeys(enterProductTitle, productName);
}
public void productType()
{
	selectProductType.click();
}
public void productCategory(String selectData) 
{
	select.selectionMethods(selectCategory, selectData);
}
public void subCategory(String selectSub)
{
    select.selectionMethods(selectSubCategory, selectSub);	
}
public void priceType()
{
	selectPriceType.click();
}
public void weightValue(String num)
{
	inputP.usingSendKeys(enterWeightValue,num);
}
public void weightUnit(String qty)
{
select.selectionMethods(selectWeightUnit, qty);	
}
public void quantity(String capacity)
{
	inputP.usingSendKeys(maxQuantity, capacity);
}
public void price(String amount)
{
    inputP.usingSendKeys(enterWeightPrice, amount);	
}
public void stockAvail(String available)
{
	inputP.usingSendKeys(enterStockAvailability, available);
}
public void stockRadio()
{
	radioStock.click();
}
public void featuredRadio()
{
	radioFeatured.click();
}
public void comboPack()
{
	radioComboPack.click();
}
public void save()
{
	clickSaveButton.click();
}
public boolean isPrdouctadded()
{
return 	clickSaveButton.isDisplayed();
}
}
