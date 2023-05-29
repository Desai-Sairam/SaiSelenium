package pompages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contain all elements and respective business libraries of HomePage
 * @author Desai Sairam
 */

public class HomePage {
    //Declaration
	@FindBy(xpath = "//img[@alt='SkillRary']")
	private WebElement logo;
	
	@FindBy(xpath = "//ul[contains(@class,'home_menu')]/li[1]")
	private WebElement langIcon;
	
	@FindBy(xpath = "//ul[contains(@class,'home_menu')]/descendant::a[text()=' English']")
	private WebElement English;
	
	@FindBy(xpath = "//a[text()=' GEARS ']")
	private WebElement gearsTab;
	
	@FindBy(xpath = "//ul[@class='dropdown-menu gear_menu']/descendant::a[text()=' SkillRary Demo APP']")
	private WebElement skillraryDemoAppLink;
	
	@FindBy(xpath = "//input[@placeholder='Search for Product']")
	private WebElement searchTF;
	
	@FindBy(xpath = "//input[@value='go']")
	private WebElement searchButton;
	
	
	
	//Initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Utilization
	/**
	 * This method returns the SkillRary logo
	 * @return
	 */
	public WebElement getLogo()
	{
		return logo;
	}
	/**
	 * This method will click on the language drop down and select English from it
	 */
	public void chooseEng() {
		langIcon.click();
		English.click();
	}
	/**
	 * This method is used to click on Gears tab
	 */
	public void clickGearsTab() {
		gearsTab.click();
	}
	/**
	 * This method is used to click on skillRary demo app link
	 */
	public void clickSkillraryDemoApp()
	{
		skillraryDemoAppLink.click();
	}
	public void searchFor(String data) {
		searchTF.sendKeys(data);
		searchButton.click();
	}
}
