package testscripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;

public class addToCart extends BaseClass {
	@Test
	public void test1() throws InterruptedException {
		SoftAssert soft= new SoftAssert();
		
		home.clickGearsTab();
		home.clickSkillraryDemoApp();
		home.chooseEng();
		web.handleChildBrowser();
		soft.assertTrue(demoApp.getPageHeader().contains("ECommerce"));
		
		
		demoApp.mouseHoverToCourse(web);
		demoApp.clickSeleniumTraining();
		
		soft.assertEquals(selenium.getPageHeader(),"Selenium Training");
		int initialQuantity= Integer.parseInt(selenium.getQuantity());
		selenium.doubleClickAdd(web);
		int finalQuantity=Integer.parseInt(selenium.getQuantity());
		soft.assertEquals(finalQuantity, initialQuantity+1);
		selenium.clickAddToCart();
		
		
		
		web.handleAlert("ok");
		
		Thread.sleep(2000);
		
		
		soft.assertEquals(selenium.getItemAddedMessage(), "Item added to cart");
		
		soft.assertAll();
	}

}
