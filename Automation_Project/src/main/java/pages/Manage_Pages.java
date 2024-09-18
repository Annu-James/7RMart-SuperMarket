package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Wait_Utilities;

public class Manage_Pages {
	WebDriver driver;

	public Manage_Pages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='nav-icon fas fa-edit']")
	WebElement clickManageContent;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-page']")
	WebElement clickManagePages;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/pages/add']")
	WebElement newListPageClick;
	@FindBy(xpath = "//input[@id='title']")
	WebElement productTitle;
	@FindBy(xpath = "//div[@class='note-editable card-block']")
	WebElement productDescription;
	@FindBy(xpath = "//input[@id='page']")
	WebElement enterPageName;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement productImageUpload;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveProductDetail;

	public void clickManageContent() {
		clickManageContent.click();
	}

	public void clickManagePage() {
		clickManagePages.click();
	}

	public void clickNewListPage() {
		newListPageClick.click();
	}

	public void enterProductTitle(String productName) {
		productTitle.sendKeys(productName);
	}

	public void enterProductDetails(String productDetail) {
		productDescription.sendKeys(productDetail);
	}

	public void enterProductPageName(String pageName) {
		enterPageName.sendKeys(pageName);
	}

	public void uploadProductImage(String image) {
		productImageUpload.sendKeys(image);
	}

	public void clickSaveButton() {
		Wait_Utilities wait1 = new Wait_Utilities();
		wait1.waitforAnElementtoBeClick(driver, saveProductDetail);
		saveProductDetail.click();
	}

	public boolean isNewProductAdded() {
		return saveProductDetail.isDisplayed();
	}
}
