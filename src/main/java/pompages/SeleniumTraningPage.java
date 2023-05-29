package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtility;
/**
 * This class contains all the elements and respective business
 * libraries of Selenium Traning Page
 * @author Desai Sairam
 *
 */

public class SeleniumTraningPage {

	//Declarartion 
	@FindBy(xpath = "//h1[@class='page-header']")
	private WebElement pageHeader;
	
	@FindBy(id = "quantity")
	private WebElement quantity;
	
	@FindBy(xpath= "//button[@id='add']")
	private WebElement plusButton;
	
	@FindBy(xpath = "//button[text()=' Add to Cart']")
	private WebElement addToCartButton;
	
	@FindBy(xpath = "//span[text()='Item added to cart']")
	private WebElement itemAddedMessage;
	
	//Initialization
	public SeleniumTraningPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	/**
	 * This method is returns page header text
	 * @return
	 */
	public String getPageHeader() {
		return pageHeader.getText();
	}
	/**
	 * This method is used to fetch the quantity of product
	 * @return
	 */
	public String getQuantity() {
		return quantity.getAttribute("value");
	}
	
	public void doubleClickAdd(WebDriverUtility web) {
		web.doubleClickOnElement(plusButton);
	}
	/**
	 * This method is used to click add to cart button
	 */
	public void clickAddToCart() {
		addToCartButton.click();
		
	}
	/**
	 * This method is returns item added message
	 * @return
	 */
	public String getItemAddedMessage() {
		return itemAddedMessage.getText();
	}	
}
