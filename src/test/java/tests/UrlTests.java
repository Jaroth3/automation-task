package tests;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pages.HomePage;
import utilities.Browser;
import utilities.Verifications;

public class UrlTests {
	
	@Before
	public void setup() {
	System.out.println("\n");
	Browser.openBrowser();
	HomePage.openPage();
	}

	@After
	public void tearDown() {
	Browser.quit();
	System.out.println("\n");
	}
	
	@Test
	public void footerMusalaSoftLinkTest() {
		HomePage.hyperLinkMusalaSoft();
		Browser.switchTab(1);
		Verifications.verifyUrl("The Page URL si Wrong/Not Present!", "http://www.musala.com/");
		Verifications.verifyCompanyLogoIsDisplayed("The Company Logo is missing!", ".brand > p:nth-child(1) > span:nth-child(1)");
		Browser.switchTab(0);
		HomePage.hyperLinkFb();
		Browser.switchTab(2);
		Verifications.verifyUrl("The Page URL si Wrong/Not Present!", "https://www.facebook.com/MUFFINconference/");
		Verifications.verifyCompanyLogoIsDisplayed("The Company Logo is missing!", "._6tb5");
	}
	



}
