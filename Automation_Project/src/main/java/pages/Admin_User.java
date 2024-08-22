package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.Page_Utilities;

public class Admin_User {
	WebDriver driver;
	public Admin_User(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'][@class='small-box-footer']")WebElement clickAdminUser;
@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement clickNewUser;
@FindBy(xpath="//input[@id='username']")WebElement userNameField;
@FindBy(xpath="//input[@id='password']")WebElement passwordField;
@FindBy(xpath="//select[@name='user_type']")WebElement userTypeField;
@FindBy(xpath="//button[@name='Create']")WebElement submitButton;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alertForNewUSer;
public void adminUserClick()
{
clickAdminUser.click();	
}
public void newUserClick()
{
	clickNewUser.click();	
}
public void enterUserName(String userName)
{
	userNameField.sendKeys(userName);
}
public void enterPassword(String password)
{
	passwordField.sendKeys(password);
}
public void userType(String userValue)
{
Page_Utilities page=new Page_Utilities();
page.selectionMethods(userTypeField, userValue);
}
public void clickSubmitButton1()
{
submitButton.click();	
}
public boolean isNewUserIsAdded()
{
return 	alertForNewUSer.isDisplayed();
}
}
