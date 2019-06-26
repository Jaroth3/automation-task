package utilities;

import org.openqa.selenium.By;


public class ConsolePrinter {
	
	
	
	/**
	 * This Method Prints the Opened Event Shedule
	 * @author B. Goranov
	 * @since 02.05.2019
	 */
	
	public static void eventPrinter(){
		
		int xpathCount = Browser.driver.findElements(By.xpath("/html/body/div/div[3]/ul")).size();
		int num=1;
		while (num <= xpathCount) {
			String text = Browser.driver.findElement(By.xpath("/html/body/div/div[3]/ul["+ num +"]/li/span")).getText();
			Boolean isPresent = Browser.driver.findElements(By.xpath("/html/body/div/div[3]/ul["+ num +"]/div/li/div[1]/div[2]")).size()>0;
			
			if(text.startsWith("Day")) {
				String outputDayOne = Browser.driver.findElement(By.xpath("/html/body/div/div[3]/ul["+ num +"]/li/span")).getText();
				System.out.println("----------------------------------------");
				System.out.println(outputDayOne);
				System.out.println("----------------------------------------");
			} else {
				
			}
			
			if(isPresent) {
				String outputEventOne = Browser.driver.findElement(By.xpath("/html/body/div/div[3]/ul["+ num +"]/div/li/div[1]/div[2]")).getText();
				String outputEventTwo = Browser.driver.findElement(By.xpath("/html/body/div/div[3]/ul["+ num +"]/div/li/div[1]/div[2]/span")).getText();
				outputEventOne= outputEventOne.replace(outputEventTwo,"");		
				System.out.println(outputEventOne);
			}else{
			
			}
		
			num++;	
				
		}
			
	}
		
}
	


