package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pages.HomePage;
import utilities.Browser;
import utilities.ConsolePrinter;
import utilities.Verifications;

public class ArchiveTests {
	
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
	public void archiveInformationTest() {
		HomePage.openArchive();
		Browser.scrollToEnd();
		HomePage.openLastEventInArchive();
		Verifications.verifyUrl("The Page URL si Wrong/Not Present!", "https://masters.musala.com/event/master-class");
		ConsolePrinter.eventPrinter();
		
	}



}
