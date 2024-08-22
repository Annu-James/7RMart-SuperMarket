package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUpload_Utilities;

public class Category_Search {
WebDriver driver;
public Category_Search(WebDriver driver)
{
this.driver=driver;
PageFactory.initElements(driver, this);
}
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category'][@class='small-box-footer']")WebElement clickCategory;
@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")WebElement clickSearch;
@FindBy(xpath="//input[@class='form-control']")WebElement enterCategoryData;
@FindBy(xpath="//button[@class='btn btn-danger btn-fix']")WebElement clickSearchButton;

public void goToCategory()
{
	clickCategory.click();
}
public void clickSearchDetail()
{
	clickSearch.click();
}
public void enterCategory(String searchInput)
{
FileUpload_Utilities input=new FileUpload_Utilities();
input.usingSendKeys(enterCategoryData, searchInput);
}
public void clickSearchButton()
{
	clickSearchButton.click();
}
public boolean isSearchisDisplayed()
{
return 	clickSearchButton.isDisplayed();
}
}
