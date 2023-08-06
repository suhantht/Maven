package maven;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.navigate().to("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		//simple Alert
		driver.findElement(By.id("alertButton")).click();
		Alert a = driver.switchTo().alert();
		System.out.println(a.getText());
		a.accept();
		
		driver.findElement(By.id("timerAlertButton")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		String txt = a.getText();
		System.out.println(txt);
		a.accept();
		
		driver.findElement(By.id("confirmButton")).click();
		String t = a.getText();
		System.out.println(t);
		a.dismiss();

		driver.findElement(By.id("promtButton")).click();
		String e = a.getText();
		System.out.println(e);
		a.sendKeys("vanakkam");
		a.accept();
		
	}

}
