package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utilities.FileUpload_Utilities;
import utilities.Page_Utilities;

public class ManageCategory_SubCategory_New {
WebDriver driver;
public ManageCategory_SubCategory_New(WebDriver driver)
{
this.driver=driver;
PageFactory.initElements(driver, this);
}
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category'][@class='small-box-footer']")WebElement clickSubManageCategory;
@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement clickNewCategory;
@FindBy(xpath="//select[@id='cat_id']")WebElement selectCategory;
@FindBy(xpath="//input[@id='subcategory']")WebElement enterSubCategory;
@FindBy(xpath="//input[@id='main_img']")WebElement uploadImage;
@FindBy(xpath="//button[@type='submit']")WebElement clickSave;
FileUpload_Utilities data=new FileUpload_Utilities();
public void subManageCategoryClick()
{
	clickSubManageCategory.click();
}
public void newCategoryClick()
{
	clickNewCategory.click();
}
public void categorySelect(String inputValue)
{
Page_Utilities page=new Page_Utilities();
page.selectionMethods(selectCategory, inputValue);
}
public void subCategoryData(String inputData)
{
	data.usingSendKeys(enterSubCategory, inputData);
}
public void imageUpload(String image)
{
	data.usingSendKeys(uploadImage, image);
}
public void saveData()
{
	clickSave.click();
}
public boolean isDataAddedToSubCategory()
{
	return clickSave.isDisplayed();
}
}
