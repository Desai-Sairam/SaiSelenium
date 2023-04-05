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
 * This Contains All reusable methods of WebDriver
 * 
 * @author Desai Sairam
 *
 */

public class WebDriverUtility {

	private WebDriver driver;
	private Actions a;
	private Select s;

	/**
	 * 
	 * @param browser
	 * @param url
	 * @param time
	 * @return
	 */

	public WebDriver openApplication(String browser, String url, long time) {
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
			System.out.println();
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		return driver;
	}

	/**
	 * This method is used to Wait until
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
	 * This method is used to mouseHover the element
	 * 
	 * @param Element
	 */
	public void mouseHover(WebElement Element) {
		a = new Actions(driver);
		a.moveToElement(Element).perform();
	}

	/**
	 * This method is used to double click on an element
	 * 
	 * @param Element
	 */
	public void doubleClickOnElement(WebElement Element) {
		a = new Actions(driver);
		a.doubleClick(Element).perform();
	}

	/**
	 * This method is used to right click on an Element
	 */
	public void rightClick() {
		a = new Actions(driver);
		a.contextClick().perform();
	}

	/**
	 * This method is used to drag and drop an Element in Specified element to
	 * target
	 * 
	 * @param element
	 * @param target
	 */
	public void dragAndDropElement(WebElement element, WebElement target) {
		a = new Actions(driver);
		a.dragAndDrop(element, target).perform();
	}

	/**
	 * This method is used to select an element from dropdown based on index
	 * 
	 * @param element
	 * @param index
	 */
	public void dropdown(WebElement element, int index) {
		s = new Select(element);
		s.selectByIndex(index);
	}

	/**
	 * This method is used to select an element from dropdown based on value
	 * 
	 * @param element
	 * @param value
	 */
	public void dropdown(WebElement element, String value) {
		s = new Select(element);
		s.selectByValue(value);
	}

	/**
	 * This method is used to select an element from dropdown based on visibleText
	 * 
	 * @param text
	 * @param element
	 */
	public void dropdown(String text, WebElement element) {
		s = new Select(element);
		s.selectByVisibleText(text);
	}

	/**
	 * This method is used to switch to frameBased on index
	 * 
	 * @param index
	 */
	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * This method is used to switch to frameBased on element
	 * 
	 * @param nameOrId
	 */
	public void switchToFrame(String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}

	/**
	 * This method is used to switch to frameBased on element
	 * 
	 * @param frameElement
	 */
	public void switchToFrame(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}

	/**
	 * This method is used to switch back to frame to frame
	 */
	public void switchBackFromFrame() {
		driver.switchTo().defaultContent();
	}

	public void scrollTillElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}

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

	public void handleAlert(String status) {
		Alert a1 = driver.switchTo().alert();
		if (status.equalsIgnoreCase("ok"))

			a1.accept();

		else
			a1.dismiss();
	}

	public void switchToParentWindow() {
		driver.switchTo().window(driver.getWindowHandle());
	}

	public void handleChildBrowser() {
		Set<String> set = driver.getWindowHandles();
		for (String wId : set) {
			driver.switchTo().window(wId);
		}
	}

	public void closeCurrentTab() {
		driver.close();
	}

	public void quitBrowser() {
		driver.quit();
	}
}
