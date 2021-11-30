package Tests;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class LoginTest extends BaseTest{

	
	//added a new line

	@Test
	public void Login() throws Exception
	{
		test=extent.createTest("login functionality");
		
		test.log(Status.INFO, "Reached to login page");
		pages.getLoginPage().getURL("https://qa-prolution.innolution.de:8009/login");
		
		
		test.log(Status.INFO, "Email and password has been entered.");
		pages.getLoginPage().SetEmailAndPassword("8447883807", "a12345678");
	
	
	
		test.log(Status.INFO, "Login button has been clicked");
		pages.getLoginPage().ClickOnLoginButton();
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}