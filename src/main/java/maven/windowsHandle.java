package maven;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
public class windowsHandle {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.navigate().to("https:flipkart.com");
		driver.manage().window().maximize();
		try {
			driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		}
		catch(Exception e)
		{
			
		}
		driver.findElement(By.name("q")).sendKeys("Redmi mobiles",Keys.ENTER);
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='_4rR01T'])[1]")));
		driver.findElement(By.xpath("(//div[@class='_4rR01T'])[1]")).click();
		driver.findElement(By.xpath("(//div[@class='_4rR01T'])[2]")).click();
		driver.findElement(By.xpath("(//div[@class='_4rR01T'])[3]")).click();
		WebDriverWait w1 = new WebDriverWait(driver,Duration.ofSeconds(5));
		String parent = driver.getWindowHandle();
		Set<String> child = driver.getWindowHandles();
		
		for(String x : child)
		{
			if(!parent.equals(x))
			{
				driver.switchTo().window(x);
				String e = driver.findElement(By.xpath("//span[@class='B_NuCI']")).getText();
				System.out.println(e);
			}
		}
	}

}
