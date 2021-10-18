package Page;

import org.openqa.selenium.WebDriver;

public class PageCollection {

	WebDriver driver;
	public PageCollection(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	
	private LoginPage loginPage;
	
	
	public LoginPage getLoginPage() {
		
		return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
	}

	
}