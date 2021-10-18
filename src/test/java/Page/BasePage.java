package Page;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class  BasePage {
	
	WebDriver driver;
	PageCollection pages;
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public PageCollection initializePages() {
		return pages = new PageCollection(driver);
		// uiActions = new UIActions(driver);
	}
	
	public WebElement waitforPresenceOFElement(By locator)
	{
		System.out.println();
		WebElement firstResult = new WebDriverWait(driver,60)
		        .until(ExpectedConditions.presenceOfElementLocated(locator));
		return firstResult;
		
	}
	
	
	public WebElement waitforPresenceOFElementUntilCLickable(By locator)
	{
		//System.out.println();
		WebElement firstResult = new WebDriverWait(driver,60)
		        .until(ExpectedConditions.elementToBeClickable(locator));
		return firstResult;
		
	}
	
	
	
	public void clickandwait(By locator)
	{
		WebElement el=waitforPresenceOFElementUntilCLickable(locator);
		el.click();
		
	}
	
	
	public void SeTText(By locator, String keysToSend)
	{
		WebElement el=waitforPresenceOFElement(locator);
		el.sendKeys(keysToSend);
	}
	
	
	public  void switchTab(int i) {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			
		driver.switchTo().window(tabs.get(i));
	}
	
	
	public void waitforelementtoBecomePresent(By locator)
	{
		WebDriverWait wait=new WebDriverWait(driver,60);
		WebElement el=wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		
		
	}
	
	
	public void waitforelementtoBecomeclickable(By locator)
	{
		WebDriverWait wait=new WebDriverWait(driver,60);
		WebElement el=wait.until(ExpectedConditions.elementToBeClickable(locator));
		
		
	}
	
	
	public void waitforelementtoBecomeVisible(By locator)
	{
		WebDriverWait wait=new WebDriverWait(driver,60);
		WebElement el=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
		
	}
	
	
	
	
	public void SetText(By locator,String text)
	{
		waitforelementtoBecomePresent(locator);
		waitforelementtoBecomeclickable(locator);
		
		driver.findElement(locator).sendKeys(text);
	}
	
	
	
	public void Clickandwait(By locator)
	{
		waitforelementtoBecomePresent(locator);
		waitforelementtoBecomeclickable(locator);
		
		driver.findElement(locator).click();
	}
	
	
	
	public void ClickOnDesiredOptions(By locator,int optionNumber)
	{
		Actions act=new Actions(driver);
		for(int i=1;i<=optionNumber;i++)
		{
			driver.findElement(locator).sendKeys(Keys.ARROW_DOWN);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		driver.findElement(locator).sendKeys(Keys.RETURN);
		
	}
	
	
	
	
	
	

}
