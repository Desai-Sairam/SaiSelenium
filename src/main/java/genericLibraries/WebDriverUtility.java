package genericLibraries;

import java.io.File;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class contains all reusable methods of WebDriver
 * 
 * @author Desai Sairam
 *
 */

public class WebDriverUtility {

	private WebDriver driver;
	private Actions a;
	private Select s;

	/**
	 * This method is used to launch browsers
	 * @param browser
	 * 
	 * @return 
	 */

	public WebDriver openApplication(String browser) {
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Invalid browser info");
		}
		return driver;
	}
	/**
	 * This method maximizes the browser
	 */
	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}
	/**
	 * This method launches the application via url
	 * @param url
	 * @return 
	 */
	public WebDriver launchBrowser(String url) {
		driver.get(url);
		return driver;
	}
	/**
	 * This method waits until the element/elements is/are found
	 * @param time
	 */
	public void waitUntilElementFound(long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	/**
	 * This method is used to wait until element is displayed
	 * 
	 * @param element
	 * @param time
	 * @return
	 */
	public WebElement explicitWait(WebElement element, long time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		WebElement e = wait.until(ExpectedConditions.visibilityOf(element));
		return e;
	}
	/**
	 * This method is used to wait until element is enabled
	 * @param time
	 * @param element
	 * @return
	 */
	public WebElement explicitWait(long time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		WebElement e = wait.until(ExpectedConditions.elementToBeClickable(element));
		return e;
	}
	/**
	 * This method is used to wait until web page title is displayed 
	 * @param time
	 * @param title
	 * @return
	 */
	public Boolean explicitWait(long time, String title) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		Boolean e = wait.until(ExpectedConditions.titleContains(title));
		return e;
	}
	/**
	 * This method is used to mouseHover to the element
	 * @param Element
	 */
	public void mouseHover(WebElement element) {
		a = new Actions(driver);
		a.moveToElement(element).perform();
	}
	/**
	 * This method is used to double click on an element
	 * @param Element
	 */
	public void doubleClickOnElement(WebElement element) {
		a = new Actions(driver);
		a.doubleClick(element).perform();
	}
	/**
	 * This method is used to right click on an Element
	 */
	public void rightClick(WebElement element) {
		a = new Actions(driver);
		a.contextClick(element).perform();
	}
	/**
	 * This method is used to drag and drop an element from specified element to target
	 * @param element
	 * @param target
	 */
	public void dragAndDropElement(WebElement element, WebElement target) {
		a = new Actions(driver);
		a.dragAndDrop(element, target).perform();
	}
	/**
	 * This method is used to select an element from drop down based on index 
	 * @param element
	 * @param index
	 */
	public void dropdown(WebElement element, int index) {
		s = new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * This method is used to select an element from drop down based on value 
	 * @param element
	 * @param value
	 */
	public void dropdown(WebElement element, String value) {
		s = new Select(element);
		s.selectByValue(value);
	}

	/**
	 * This method is used to select an element from drop down based on visibleText
	 * @param text
	 * @param element
	 */
	public void dropdown(String text, WebElement element) {
		s = new Select(element);
		s.selectByVisibleText(text);
	}
	 /**
     * This method is used to scroll till the specified elemen 
     * @param element
     */
	public void scrollTillElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	/**
	 * This method is used to switch to frame using on index
	 * @param index
	 */
	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * This method is used to switch to frame using name or id
	 * @param nameOrId
	 */
	public void switchToFrame(String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	/**
	 * This method is used to switch to frame using frame element
	 * 
	 * @param frameElement
	 */
	public void switchToFrame(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}
	/**
	 * This method is used to switch back from frame to frame
	 */
	public void switchBackFromFrame() {
		driver.switchTo().defaultContent();
	}
    /**
     * This method is used to capture screenshot of window 
     * @param javaUtil
     */
	public void takeScreenshot(JavaUtility javaUtil) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshot/ss_" + javaUtil.getCurrentTime() + ".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    /**
     * This method is used to handle alert pop up
     * @param status
     */
	public void handleAlert(String status) {
		Alert al = driver.switchTo().alert();
		if (status.equalsIgnoreCase("ok"))

			al.accept();

		else
			al.dismiss();
	}

	public void switchToParentWindow() {
		driver.switchTo().window(driver.getWindowHandle());
	}
	/**
	 * This method is used to switch to child browser
	 */
	public void handleChildBrowser() {
		Set<String> set = driver.getWindowHandles();
		for (String wId : set) {
			driver.switchTo().window(wId);
		}
	}
	/**
	 * This method is used to close the current window
	 */
	public void closeCurrentTab() {
		driver.close();
	}
	/**
	 * This method is used to exit all the windows
	 */
	public void quitBrowser() {
		driver.quit();
	}
}
