package genericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pompages.ContactUsPage;
import pompages.CoreJavaForSeleniumPage;
import pompages.CoreJavaVideoPage;
import pompages.HomePage;
import pompages.SeleniumTraningPage;
import pompages.SkillraryDemoAppPage;
import pompages.TestingPage;

public class BaseClass {
	
	protected WebDriverUtility web;
	protected PropertyFileUtility property;
	protected ExcelUtilty excel;
	protected JavaUtility jUtil;
	protected WebDriver driver;
	protected HomePage home;
	 
	protected SkillraryDemoAppPage demoApp;
	protected SeleniumTraningPage selenium;
	protected TestingPage testing;
	protected ContactUsPage contact;
	protected CoreJavaForSeleniumPage coreJava;
	protected CoreJavaVideoPage javaVideo;
	

	//@BeforeSuite
	//@BeforeTest
	
	@BeforeClass

	public void classConfiguration() {
		web = new WebDriverUtility();
		property = new PropertyFileUtility();
		excel = new ExcelUtilty();
		jUtil = new JavaUtility();
		
		property.propertyConfig(IConstantPath.PROPERTIES_PATH);
		excel.excelInitialization(IConstantPath.EXCEL_PATH);
		
	}
	@BeforeMethod
	public void methodConfiguration() {
		driver= web.openApplication(property.fetchProperty("browser"));
		web.maximizeBrowser();
		web.launchBrowser(property.fetchProperty("url"));
		web.waitUntilElementFound(Long.parseLong(property.fetchProperty("time")));
		
		
		home = new HomePage(driver);
		demoApp= new SkillraryDemoAppPage(driver);
		selenium= new SeleniumTraningPage(driver);
		testing= new TestingPage(driver);
		contact = new ContactUsPage(driver);	
	}
	
	@AfterMethod
	public void methodTearDown() {
		web.quitBrowser();
	}
	@AfterClass
	public void classTearDown() {
		excel.closeWorkbook();
		
	}
	//@AfterTest
	//@AfterSuite

}
