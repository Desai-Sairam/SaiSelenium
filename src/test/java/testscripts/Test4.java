package testscripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;

public class Test4 extends BaseClass{

	@Test
	public void test4() throws InterruptedException {
		SoftAssert soft=new SoftAssert();
		
		home.searchFor("core java for selenium");
		soft.assertEquals(coreJava.getPageHeader(), "CORE JAVA FOR SELENIUM");
		
		coreJava.clickCoreJavaForSeleniumLink();
		soft.assertEquals(javaVideo.getPageHeader(), "Core Java For Selenium Training");
		
		javaVideo.clickCloseCookis();
		web.switchToFrame(1);
		javaVideo.clickPlayButton();
		Thread.sleep(2000);
		javaVideo.clickPauseButton();
		
		web.switchBackFromFrame();
		
		javaVideo.clickAddToWishlist();
		
		soft.assertAll();
		
	}
}
