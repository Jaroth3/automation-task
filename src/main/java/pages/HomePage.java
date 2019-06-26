package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.*;

public class HomePage {
	
	public static void openPage() {
		String url = PropertyManager.getInstance().getURL();
		Browser.driver.get(url);
	}
	
	public static void openLoginForm() {
		Browser.driver.findElement(By.cssSelector(".nav > li:nth-child(5) > a:nth-child(1)")).click();
	}
	
	public static void openArchive() {
		Browser.driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/header/div/div/nav[1]/ul/li[3]/a")).click();

	}
	
	public static void usernameInput(String inputUsername) {
		WebElement username = Browser.driver.findElement(By.id("login-form_username"));
		username.sendKeys(inputUsername);
	}
	
	public static void passwordInput(String inputPassword) {
		WebElement password = Browser.driver.findElement(By.id("login-form_password"));
		password.sendKeys(inputPassword);
	}
	
	public static void signInButtonClick() {
		Browser.driver.findElement(By.id("btn-sign-in")).click();
	}
	
	public static void hyperLinkMusalaSoft() {
		Browser.driver.findElement(By.cssSelector(".leftPartFooter > a:nth-child(1)")).click();
	}
	public static void hyperLinkFb() {
		Browser.driver.findElement(By.cssSelector(".pull-right")).click();
	}
	
	public static void openLastEventInArchive() {
		int xpathCount = Browser.driver.findElements(By.xpath("html/body/div/div[3]/div[2]/div")).size();
		Browser.driver.findElement(By.xpath("html/body/div/div[3]/div[2]/div["+xpathCount+"]")).click();
	}
	
}

