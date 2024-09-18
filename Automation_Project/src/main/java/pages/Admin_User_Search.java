package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Admin_User_Search{
WebDriver driver;
public Admin_User_Search(WebDriver driver){
this.driver=driver;
PageFactory.initElements(driver, this);
}
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")WebElement clickAdminUser2;
@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")WebElement clickSearchButton;
@FindBy(xpath="//input[@id='un']")WebElement enterUserNameField;
@FindBy(xpath="//select[@id='ut']")WebElement selectUserTypeField;
@FindBy(xpath="//button[@name='Search']")WebElement searchAdminUser;
public Admin_User_Search adminUserClick2()
{
clickAdminUser2.click();
return this;
}
public Admin_User_Search clickSearch()
{
	clickSearchButton.click();
	return this;
}
public Admin_User_Search enterUserName(String userName)
{
	enterUserNameField.sendKeys(userName);
	return this;
}
public Admin_User_Search selectUserType(String userTypeValue)
{
	Select user=new Select(selectUserTypeField);
	user.selectByVisibleText(userTypeValue);
	return this;
}
public Admin_User_Search clickSearchButton()
{
	searchAdminUser.click();
	return new Admin_User_Search(driver);
}
public boolean isEnteredAdminInSearchisDisplayed()
{
	return searchAdminUser.isDisplayed();
}
}
