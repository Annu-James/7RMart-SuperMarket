package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUpload_Utilities;
import utilities.Page_Utilities;
import utilities.Wait_Utilities;

public class ManageCategory {
WebDriver driver;
public ManageCategory(WebDriver driver)
{
this.driver=driver;
PageFactory.initElements(driver, this);
}
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category'][@class='small-box-footer']")WebElement clickCategory1;
@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement clickNew;
@FindBy(xpath="//input[@id='category']")WebElement enterCatergory;
@FindBy(xpath="//li[@id='134-selectable']")WebElement dragInput;
@FindBy(xpath="//div[@class='ms-selection']")WebElement dropInput;
@FindBy(xpath="//input[@id='main_img']")WebElement uploadImage;
@FindBy(xpath="//input[@name='top_menu'][@value='yes']")WebElement radioTopMenu;
@FindBy(xpath="//input[@name='show_home'][@value='yes']")WebElement radioLeftMenu;
@FindBy(xpath="//button[@type='submit']")WebElement clickSaveButton;
FileUpload_Utilities input=new FileUpload_Utilities();
public ManageCategory goToCategory1()
{
	clickCategory1.click();
	return this;
}
public ManageCategory clickNewButton()
{
	clickNew.click();
	return this;
}
public ManageCategory inputCategory(String categoryValue)
{
	input.usingSendKeys(enterCatergory, categoryValue);
	return this;
}
public ManageCategory clickDiscount()
{
	dragInput.click();
	return this;
}
public ManageCategory imageUpload(String image)
{
	input.usingSendKeys(uploadImage, image);
	return this;
}
public ManageCategory clickRadioButton()
{
	radioTopMenu.click();
	return this;
}
public ManageCategory clickRadioLeftMenu()
{
	radioLeftMenu.click();
	return this;
}
public ManageCategory clickSave()
{
	Wait_Utilities wait=new Wait_Utilities();
	wait.waitforAnElementtoBeClick(driver, clickSaveButton);
	clickSaveButton.click();
	return new ManageCategory(driver);
}
public boolean isCategoryisSaved()
{
return clickSaveButton.isDisplayed();	
}
}
