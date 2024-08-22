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
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category'][@class='small-box-footer']")WebElement clickCategory;
@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement clickNew;
@FindBy(xpath="//input[@id='category']")WebElement enterCatergory;
@FindBy(xpath="//li[@id='134-selectable']")WebElement dragInput;
@FindBy(xpath="//div[@class='ms-selection']")WebElement dropInput;
@FindBy(xpath="//input[@id='main_img']")WebElement uploadImage;
@FindBy(xpath="//input[@name='top_menu'][@value='yes']")WebElement radioTopMenu;
@FindBy(xpath="//input[@name='show_home'][@value='yes']")WebElement radioLeftMenu;
@FindBy(xpath="//button[@type='submit']")WebElement clickSaveButton;
FileUpload_Utilities input=new FileUpload_Utilities();
public void goToCategory()
{
	clickCategory.click();
}
public void clickNewButton()
{
	clickNew.click();
}
public void inputCategory(String categoryValue)
{
	input.usingSendKeys(enterCatergory, categoryValue);
}
public void clickDiscount()
{
	dragInput.click();
}
public void imageUpload(String image)
{
	input.usingSendKeys(uploadImage, image);
}
public void clickRadioButton()
{
	radioTopMenu.click();
}
public void clickRadioLeftMenu()
{
	radioLeftMenu.click();
}
public void clickSave()
{
	Wait_Utilities wait=new Wait_Utilities();
	wait.waitforAnElementtoBeClick(driver, clickSaveButton);
	clickSaveButton.click();
}
public boolean isCategoryisSaved()
{
return clickSaveButton.isDisplayed();	
}
}
