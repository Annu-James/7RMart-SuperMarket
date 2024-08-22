package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUpload_Utilities;
import utilities.Page_Utilities;

public class SubCategory_Search {
WebDriver driver;
public SubCategory_Search(WebDriver driver) 
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category'][@class='small-box-footer']")WebElement clickSubManageCategory;
@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")WebElement clickSearch;
@FindBy(xpath="//select[@id='un']")WebElement enterCategory;
@FindBy(xpath="//input[@class='form-control']")WebElement enterSubCategory;
@FindBy(xpath="//button[@class='btn btn-danger btn-fix']")WebElement clickSearchButton;

public void subManageCategoryClick()
{
	clickSubManageCategory.click();
}
public void searchClick()
{
	clickSearch.click();
}
public void enterCategorydetail(String categoryValue)
{
Page_Utilities category=new Page_Utilities();
category.selectionMethods(enterCategory, categoryValue);
}
public void subCategoryData(String subCategoryValue)
{
FileUpload_Utilities data=new FileUpload_Utilities();
data.usingSendKeys(enterSubCategory, subCategoryValue);
}
public void clickSearchButton()
{
	clickSearchButton.click();
}
public boolean isSearchDataisDisplayed()
{
	return clickSearchButton.isDisplayed();
}
}
