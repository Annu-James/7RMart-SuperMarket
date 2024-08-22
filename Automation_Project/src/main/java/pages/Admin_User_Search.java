package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Admin_User_Search{
WebDriver driver;
public Admin_User_Search(WebDriver driver)
{
this.driver=driver;
PageFactory.initElements(driver, this);
}
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")WebElement clickAdminUser;
@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")WebElement clickSearchButton;
@FindBy(xpath="//input[@id='un']")WebElement enterUserNameField;
@FindBy(xpath="//select[@id='ut']")WebElement selectUserTypeField;
@FindBy(xpath="//button[@name='Search']")WebElement searchAdminUser;
public void adminUserClick()
{
clickAdminUser.click();	
}
public void clickSearch()
{
	clickSearchButton.click();
}
public void enterUserName(String userName)
{
	enterUserNameField.sendKeys(userName);
}
public void selectUserType(String userTypeValue)
{
	Select user=new Select(selectUserTypeField);
	user.selectByVisibleText(userTypeValue);
}
public void clickSearchButton()
{
	searchAdminUser.click();
}
public boolean isEnteredAdminInSearchisDisplayed()
{
	return searchAdminUser.isDisplayed();
}
}
