package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * * This class contain all elements and respective business
 * libraries of Testing page
 * @author Desai Sairam
 *
 */

public class TestingPage {

	//Declaration 
	@FindBy(xpath = "//h1[@class='page-header']")
	private WebElement pageHeader;
	
	@FindBy(xpath = "//img[@id='Selenium Training']")
	private WebElement seleniumTrainingImage;
	
	@FindBy(id= "cartArea")
	private WebElement cartArea;
	
	@FindBy(xpath = "//ul[@class='list-socialicons']/descendant::i[@class='fa fa-facebook']")
	private WebElement facebookIcon;
	//Initialization
	public TestingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Utilization
	/**
	 * This method returns pageHeader text
	 * @return
	 */
	public String getPageHeader() {
		return pageHeader.getText();
		
	}
	/**
	 * This method is returns Selenium Training image
	 * @return
	 */
	public WebElement getSeleniumTainingImage() {
		return seleniumTrainingImage;
	}
	/**
	 * This method returns cart Area WebElemet
	 * @return
	 */
	public WebElement getCartArea() {
		return cartArea;
		
	}
	/**
	 * This method returns facebook icon
	 * @return
	 */
	public WebElement getFacebookIcon() {
		return facebookIcon;
	}
	/**
	 * This method is used to click facebook icon
	 */
	public void clickFacebookIcon()
	{
		facebookIcon.click();
	}
}
