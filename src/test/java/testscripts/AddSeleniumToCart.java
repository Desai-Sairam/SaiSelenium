package testscripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;

public class AddSeleniumToCart extends BaseClass{
	@Test
	public void test2() throws InterruptedException {
		SoftAssert soft= new SoftAssert();
		
		home.clickGearsTab();
		home.clickSkillraryDemoApp();
		web.handleChildBrowser();
		Thread.sleep(3000);
		soft.assertEquals(demoApp.getPageHeader(), "SkillRary-ECommerce");
		Thread.sleep(3000);
		demoApp.selectCategory(web, 1);
		Thread.sleep(3000);
		soft.assertEquals(testing.getPageHeader(), "Testing");
		Thread.sleep(3000);
		web.dragAndDropElement(testing. getSeleniumTainingImage(), testing.getCartArea());
		Thread.sleep(3000);
		web.scrollTillElement(testing.getFacebookIcon());
		testing.clickFacebookIcon();
		
		soft.assertAll();
	}
}
