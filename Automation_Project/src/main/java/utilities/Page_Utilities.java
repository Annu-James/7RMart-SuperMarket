package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Page_Utilities {
//Reuseable codes.
	WebDriver driver;
	public void selectionMethods(WebElement element,String elementText)
	{
	Select selectField=new Select(element);
	selectField.selectByVisibleText(elementText);;;
	}
	public void selectIndex(WebElement element,int elementNum)
	{
		Select select=new Select(element);
		select.selectByIndex(elementNum);
	}
	public void selectElementByValue(WebElement element,String elementName)
	{
		Select select=new Select(element);
		select.selectByValue(elementName);
	}
	
	public void drag_Drop(WebElement element1,WebElement element2)
	{
		Actions action=new Actions(driver);
		action.dragAndDrop(element1, element2).perform();
	}
	public void javaScriptExecutor(WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight", "");
		js.executeScript("arguments[0].click()", element);
		element.click();
	}
}
