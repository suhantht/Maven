package maven;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
public class javaScript {

	public static void main(String[] args)  {
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\Java Workspace\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://Facebook.com");
		driver.manage().window().maximize();
		for(int i=0;i<=2000;i++)
		{
			JavascriptExecutor j = (JavascriptExecutor)driver;
			String exe  = j.executeScript("return document.readyState").toString();
			if(exe.equalsIgnoreCase("complete")) {
				System.out.println("Page Loaded");
				break;
			}
		}
		

		WebElement create = driver.findElement(By.xpath("//a[text()='Create new account']"));
	//	Main.inputMethod("abc@gmail.com","//input[@id='email']");
		WebElement fb = driver.findElement(By.xpath("//img[@class='fb_logo _8ilh img']"));
		String ans = fb.getAttribute("alt");
		System.out.println(ans);
		JavascriptExecutor  js =  (JavascriptExecutor)driver;
		//reload entire application
		js.executeScript("location.reload()");
		//gives the entire text present in the particular web page
//		String sText =  js.executeScript("return document.documentElement.innerText;").toString(); 
//		System.out.println(sText);
	WebElement email = driver.findElement(By.id("email"));
		js.executeScript("document.getElementById('email').value='Java';");
		js.executeScript("document.getElementById('pass').value='password';");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		String v = js.executeScript("return document.getElementById('email').value").toString();
		System.out.println(v);
		//driver.findElement(By.linkText("Log in")).click();
		try {
			js.executeScript("document.getElementBylinkText('Log in').click();");
		
		}
		catch(Exception e)
		{
			
		}
		js.executeScript("window.scrollBy(0,200)");
		js.executeScript("window.scrollBy(0,-100)");
		WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(3));
		js.executeScript("arguments[0].setAttribute('style','border:4px solid red;background:yellow')", email);
		
		TakesScreenshot t = (TakesScreenshot)driver;
		try {
			File src = t.getScreenshotAs(OutputType.FILE);
			File img = new File("D:\\Java Workspace\\maven\\Screenshots\\facebook.png");
			FileUtils.copyFile(src, img);
		}
		catch(Exception e)
		{
			
		}
		js.executeScript("alert('hi');");
	}

}
