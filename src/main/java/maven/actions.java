package maven;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class actions {
	 
	public static void main(String[] args) throws IOException, InterruptedException, AWTException {
		WebDriver driver;
		driver=Main.launchBrowser("https://facebook.com");
	
		
		WebElement emailInput = driver.findElement(By.xpath("//input[@id='email']"));
		Main.inputMethod("abc@gmail.com","//input[@id='email']");
		Actions ac = new Actions(driver);
		ac.doubleClick(emailInput).build().perform();
		ac.contextClick(emailInput).build().perform();
		driver.findElement(By.xpath("//div[@class='_8esl']"));
		WebElement tamil = driver.findElement(By.xpath("//a[text()='தமிழ்']"));
		ac.moveToElement(tamil).doubleClick();
		System.out.println(tamil.getText()  + "Tag Name " + tamil.getTagName());
		tamil.click();
		
		
		driver.close();
		driver = Main.launchBrowser("https://Amazon.com");
//		try {
//			driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
//		}
//		catch(Exception e)
//		{
//			
//		}
		WebElement elec = driver.findElement(By.xpath("//span[text()='Hello, sign in']"));
		Actions ac1 = new Actions(driver);
		ac1.moveToElement(elec).perform();
		WebElement elec1 = driver.findElement(By.xpath("(//span[text()='EN'])[1]"));
		ac1.click(elec1);
		
		
	}
	
	
}
