package maven;



import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class basics {

	public static void main(String[] args) throws IOException {
		WebDriver driver;
		driver = Main.launchBrowser("https://facebook.com");
		Main.emailValidationbyID("email", "abc@gmail.com");
		
		
	}
	
}
