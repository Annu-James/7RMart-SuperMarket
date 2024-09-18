package pages;
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page{
WebDriver driver;

public Login_Page(WebDriver driver){
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//input[@type='text']")WebElement userNameField;
@FindBy(xpath="//input[@type='password']")WebElement passwordField;
@FindBy(xpath="//button[@type='submit']")WebElement submitButton;
@FindBy(xpath="//p[text()='Dashboard']")WebElement dashBoard;
@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")WebElement alert;
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'][@class='small-box-footer']")WebElement clickAdminUser;
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'][@class='small-box-footer']")WebElement clickAdminUser1;
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'][@class='small-box-footer']")WebElement clickAdminUser2;
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category'][@class='small-box-footer']")WebElement clickCategory;
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category'][@class='small-box-footer']")WebElement clickSubManageCategory;
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category'][@class='small-box-footer']")WebElement clickSubManageCategory2;
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category'][@class='small-box-footer']")WebElement clickCategory1;
public Login_Page enterUserNameField(String userName){
	userNameField.sendKeys(userName);
	return this;
}
public Login_Page enterPasswordField(String password){
passwordField.sendKeys(password);
return this;	
}
public Login_Page clickSubmitButton(){
submitButton.click();
return new Login_Page(driver);	
}

public boolean isDashboardisLoaded(){
	return dashBoard.isDisplayed();
}
public boolean isAlertisDisplayed(){
return alert.isDisplayed();	
}

public Admin_User adminUserClick()
{
clickAdminUser.click();
return new Admin_User(driver);	
}
public AdminUser_Edit adminUserClick1()
{
clickAdminUser1.click();
return new AdminUser_Edit(driver);
}
public Admin_User_Search adminUserClick2()
{
clickAdminUser2.click();
return new Admin_User_Search(driver);
}
public Category_Search goToCategory()
{
	clickCategory.click();
	return new Category_Search(driver);
}
public SubCategory_Search subManageCategoryClick()
{
	clickSubManageCategory.click();
	return new SubCategory_Search(driver);
}
public ManageCategory_SubCategory_New subManageCategoryClick2()
{
	clickSubManageCategory2.click();
	return new ManageCategory_SubCategory_New(driver);
}
public ManageCategory goToCategory1()
{
	clickCategory1.click();
	return new ManageCategory(driver);
}
}
