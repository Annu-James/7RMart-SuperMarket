package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagePages_Search {
WebDriver driver;

public ManagePages_Search(WebDriver driver)
{
this.driver=driver;
PageFactory.initElements(driver, this);
}
@FindBy(xpath="//i[@class='nav-icon fas fa-edit']")WebElement clickManageContent;
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-page']")WebElement clickManagePages;
@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")WebElement clickManageSearch;
@FindBy(xpath="//input[@class='form-control']")WebElement inputTitle;
@FindBy(xpath="//button[@class='btn btn-danger btn-fix']")WebElement clickSearchButton;

public void manageContentClick()
{
	clickManageContent.click();
}
public void managePagesClick()
{
	clickManagePages.click();
}
public void searchManagePages()
{
	clickManageSearch.click();
}
public void enterTitle(String productTitle)
{
	inputTitle.sendKeys(productTitle);
}
public void clickSearchButton()
{
	clickSearchButton.click();
}
public boolean isEnterProductisVisible()
{
return 	clickSearchButton.isDisplayed();
}
}
