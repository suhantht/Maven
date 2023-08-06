package maven;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class robots {

	public static void main(String[] args) throws AWTException {
		WebDriver driver ;
		driver = Main.launchBrowser("https://facebook.com");
		WebElement user = driver.findElement(By.xpath("//input[@id='email']"));
		user.sendKeys("java");
		Actions ac = new Actions(driver);
		
		ac.doubleClick(user).build().perform();
		ac.contextClick(user).build().perform();
		
		Robot r = new Robot();
		
		for(int i=0;i<=3;i++){
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}


		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
//		r.keyPress(KeyEvent.VK_ENTER);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		driver.findElement(By.xpath("//div[@class='_9lsb _9ls8']")).click();
	}

}
