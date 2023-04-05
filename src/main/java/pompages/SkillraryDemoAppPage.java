package pompages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtility;

/**
 * This class contain all elements and respective business
 * libraries of Skillrary demo app page
 * @author Desai Sairam
 *
 */

public class SkillraryDemoAppPage {

	//Declaration
	@FindBy(xpath = "//div[@class='navbar-header']")
	private WebElement pageHeader;
	
	@FindBy(id= "course")
	private WebElement courseTab;
	
	@FindBy(xpath = "//span/a[text()='Selenium Training']")
	private WebElement seleniumTrainingLink;
	
	@FindBy(name="addresstype")
	private WebElement categoryDropdown;
	
	@FindBy(xpath = "//a[text()='Contact Us']")
	private WebElement contactUsLink;

	//INITIALIZATION
	public SkillraryDemoAppPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Utilization
	/**
	 * This method is returns page header text
	 * @return
	 */
	public String getPageHeader()
	{
		return pageHeader.getText();
	}
	/**
	 * This method is uesd to mouse hover to course Tab
	 * @param web
	 */
	public void mouseHoverToCourse(WebDriverUtility web)
	{
		web.mouseHover(courseTab);
	}
	/**
	 * This method is used to click on selenium Trainin link
	 */
	public void clickSeleniumTraining() {
		seleniumTrainingLink.click();
	}
	/**
	 * This method is used to choose the category from dropdown
	 * @param web
	 * @param index
	 */
	public void selectCategory(WebDriverUtility web,int index)
	{
		web.dropdown(categoryDropdown, index);
	}
	/**
	 * This method is used to get the contact us link
	 * @return
	 */
	public WebElement getContactUsLink() {
		return contactUsLink;
	}
	/**
	 * This method is used to click on contact us link
	 */
	public void clickContactUs()
	{
		contactUsLink.click();
	}
}
