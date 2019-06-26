package utilities;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Browser {
	public static WebDriver driver;
	
	/**
	 * This Method starts the Browser
	 * @author B. Goranov 
	 * @since 02.05.2019
	 */
	public static void openBrowser()  {
		String browser = PropertyManager.getInstance().getBrowser();
		
		if (browser.equals("Chrome")) {
		System.setProperty("webdriver.chrome.driver", 
				"D:\\CMS_3_1\\QAAutomation\\automation-task" + "\\src\\main\\resources\\webdrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		} else if(browser.equals("FireFox")){ 
		System.setProperty("webdriver.gecko.driver", 
				"D:\\CMS_3_1\\QAAutomation\\automation-task" + "\\src\\main\\resources\\webdrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
	
		} else {
			System.err.println("Please add  as Property Browser one of: \"Chrome\" or \"FireFox\" /n in \"configuration.properties\" file!");
		}
	}
	
	/**
	 * This Method scrolls to the end to the page
	 * @author B. Goranov
	 * @since 02.05.2019
	 */
	
	public static void scrollToEnd()  {
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	/**
	 * This Method scrolls to the end to the page 
	 * @param tabNumber Tab number starting from "0" as first opened
	 * @author B. Goranov
	 * @since 02.05.2019
	 */
	public static void switchTab(int tabNumber)  {
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(tabNumber));
	}
	
	/**
	 * This Method closes the Browser
	 * @author B. Goranov
	 * @since 30.04.2019
	 */
	public static void quit() {
		driver.quit();
	}
}
