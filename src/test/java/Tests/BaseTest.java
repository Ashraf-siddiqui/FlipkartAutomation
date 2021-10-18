package Tests;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
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

	
	public WebDriver driver;
	public PageCollection pages;
	 
	public ChromeOptions options;
	public ExtentReports extent;
	public ExtentTest test;
	String path=System.getProperty("user.dir")+"\\Report\\"+"index.html";
	
	@BeforeTest
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
		driver=new ChromeDriver(options);	
		
		
		
		
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