package maven;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Flipkart {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver;
		driver = Main.launchBrowser("https://flipkart.com");
		try {
			driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		}
		catch(Exception e)
		{
			
		}
		Main.flipkartSearch("//input[@type=\"text\"]", "Redmi Mobiles");
		Main.excelCreation("D:\\Java Workspace\\Excel data\\dataSheet.xlsx", "sheet1");
		Main.listOfSearchedName("//div[@class='_4rR01T']","D:\\\\Java Workspace\\\\Excel data\\\\dataSheet.xlsx", "//div[@class='_30jeq3 _1_WHN1']","sheet1");
	
	//	Main.listOfSearchedPrice("//div[@class='_30jeq3 _1_WHN1']");
		
		
	}
	
}
