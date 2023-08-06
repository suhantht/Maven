package maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class drag_drop {

	public static void main(String[] args) {
		WebDriver driver = Main.launchBrowser("https://demo.guru99.com/test/drag_drop.html");
		WebElement dr = driver.findElement(By.xpath("//a[contains(text(),'SALES')]"));
		WebElement dp = driver.findElement(By.xpath("(//li[@class='placeholder'])[3]"));
		
		WebElement dr1 = driver.findElement(By.xpath("//a[contains(text(),'BANK')]"));
		WebElement dp1= driver.findElement(By.xpath("(//li[@class='placeholder'])[1]"));
		
		WebElement dr2 = driver.findElement(By.xpath("(//a[contains(text(),'5000')])[2]"));
		WebElement dp2= driver.findElement(By.xpath("(//li[@class='placeholder'])[2]"));

		
		WebElement dr3 = driver.findElement(By.xpath("(//a[contains(text(),'5000')])[4]"));
		WebElement dp3 =driver.findElement(By.xpath("(//li[@class='placeholder'])[4]"));
		
		Actions ac = new Actions(driver);
		ac.dragAndDrop(dr, dp).build().perform();
		ac.dragAndDrop(dr1, dp1).build().perform();
		ac.dragAndDrop(dr2, dp2).build().perform();
		ac.dragAndDrop(dr3, dp3).build().perform();
	}

}
