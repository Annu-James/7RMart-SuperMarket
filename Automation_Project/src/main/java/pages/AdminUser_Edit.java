package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.FileUpload_Utilities;
import utilities.Page_Utilities;

public class AdminUser_Edit {
WebDriver driver;
public AdminUser_Edit(WebDriver driver)
{
this.driver=driver;
PageFactory.initElements(driver, this);
}
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'][@class='small-box-footer']")WebElement clickAdminUser1;
@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']")WebElement editAdminUser;
@FindBy(xpath="//input[@name='username']")WebElement editUserName;
@FindBy(xpath="//input[@id='password']")WebElement editPassword;
@FindBy(xpath="//select[@name='user_type']")WebElement editUserType;
@FindBy(xpath="//button[@name='Update']")WebElement clickUpdate;
FileUpload_Utilities select=new FileUpload_Utilities();
public AdminUser_Edit adminUserClick1()
{
clickAdminUser1.click();	
return this;
}
public AdminUser_Edit adminUserEdit()
{
	editAdminUser.click();
	return this;
}
public AdminUser_Edit editUserName(String userName)
{
	editUserName.clear();
	select.usingSendKeys(editUserName, userName);
	return this;
}
public AdminUser_Edit editPasswordField(String password)
{
	editPassword.clear();
	select.usingSendKeys(editPassword, password);
	return this;
}
public AdminUser_Edit editUserType(String userTypefield)
{
 Page_Utilities userType=new Page_Utilities();
 userType.selectionMethods(editUserType, userTypefield);
 return this;
}
public AdminUser_Edit updatingAdminUserClick()
{
	clickUpdate.click();
	return new AdminUser_Edit(driver);
}
public boolean isAdminUserisUpdated()
{
return 	clickUpdate.isDisplayed();
}
}