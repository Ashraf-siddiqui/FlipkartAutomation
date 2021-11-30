package Tests;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Page.PageCollection;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	
	public RemoteWebDriver driver;
	public PageCollection pages;
	 
	public ChromeOptions options;
	public ExtentReports extent;
	public ExtentTest test;
	String path=System.getProperty("user.dir")+"\\Report\\"+"index.html";
	
	//@BeforeTest
	public void SetUp()
	{
		 
		WebDriverManager.chromedriver().setup();
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		options=new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		options.addArguments("lang=en-GB");
		extent=new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(path);
		spark.config().setReportName("PROlution Test Automation Report");
		spark.config().setDocumentTitle("Test Results");
		
		extent.attachReporter(spark);
		extent.setSystemInfo("Tester", "Mohd Ashraf");
	//	driver=new ChromeDriver(options);	
		
		
		
		
	}
	
	
	@BeforeTest
	public void Remote() throws MalformedURLException
	{
		options=new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		options.addArguments("lang=en-GB");
		DesiredCapabilities cap=DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		
		URL url=new URL("http://localhost:4444/wd/hub");
		extent=new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(path);
		spark.config().setReportName("PROlution Test Automation Report");
		spark.config().setDocumentTitle("Test Results");
		
		extent.attachReporter(spark);
		extent.setSystemInfo("Tester", "Mohd Ashraf");
		driver=new RemoteWebDriver(url, cap);
		
	}
	
	@BeforeMethod(alwaysRun = true)
	public void initialie()
	{
		pages=new PageCollection(driver);
		}
	
	
	@AfterTest
	public void flush()
	{
		extent.flush();
	}
	
	@AfterSuite
	public void TearDown()
	{
		driver.close();
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
}