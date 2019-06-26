package utilities;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class Verifications {
	
	 public static void verifySignInFormIsPresent(String messageOnFailure) {
			WebElement actualElement = Browser.driver.findElement(By.id("login-tabs"));
			Assert.assertTrue(messageOnFailure, actualElement.isDisplayed());
		}
	
	 public static void verifyNegativeLogin(String messageOnFailure, String expectedValidationMessage) {
			String actualValidationMessage = Browser.driver.findElement(By.cssSelector("div.bs-muffin-callout:nth-child(2) > p:nth-child(1)")).getText();
			Assert.assertTrue(messageOnFailure, actualValidationMessage.equals(expectedValidationMessage));
		}
	 
	 public static void  verifyUrl(String messageOnFailure, String expectedValidationMessage) {
		// Added Sleep to be sure that the page is loaded
		 try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String actualValidationMessage = Browser.driver.getCurrentUrl();
			Assert.assertTrue(messageOnFailure, actualValidationMessage.equals(expectedValidationMessage));
		}
	 
	 public static void verifyCompanyLogoIsDisplayed(String messageOnFailure, String selector) {
			WebElement actualElement = Browser.driver.findElement(By.cssSelector(selector));
			Assert.assertTrue(messageOnFailure, actualElement.isDisplayed());
	 	}
	 
}
	 
