package maven;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {
	static WebDriver driver;
	
	public static void launchBrowser() {
		System.setProperty("webdriver.edge.driver", "D:\\\\Java Workspace\\\\edgedriver_win64\\\\msedgedriver.exe");
		EdgeOptions options = new EdgeOptions();
		WebDriver driverLocal = new EdgeDriver(options);
		driverLocal.manage().window().maximize();
		driverLocal.get("https://www.google.com");
		
	}
	
	public static WebDriver launchBrowser(String url) {
		System.setProperty("webdriver.edge.driver", "D:\\\\Java Workspace\\\\edgedriver_win64\\\\msedgedriver.exe");
		EdgeOptions option = new EdgeOptions();
		WebDriver driverLocal = new EdgeDriver(option);
		driverLocal.manage().window().maximize();
		driverLocal.get(url);
		driver=driverLocal;
		return driver;
		
	}
	
	public static void  emailValidationbyID(String ID,String value)
	{
		WebElement user = driver.findElement(By.id(ID));
		if(user.isDisplayed())
		{
			user.sendKeys(value);
			String attribute = user.getAttribute("value");
			System.out.println(attribute);
		}
		else {
			System.out.println("Field could not be found");
		}
	}
	
	
	
	public static void flipkartSearch(String xpath,String message) throws InterruptedException
	{
		WebElement user = driver.findElement(By.xpath(xpath));
		if(user.isDisplayed())
		{
			user.sendKeys(message,Keys.ENTER);	
		}
		Thread.sleep(3000);
	}
	
	public static void listOfSearchedName(String xpath,String location,String xpath1,String sheet) throws IOException, InterruptedException {
		String text="";
		String text1="";
		List<WebElement> l = driver.findElements(By.xpath(xpath));
		Map<String,String> map=new HashMap<String,String>();  
		Set<Entry<String,String> >entr = new HashSet<>();	
		for(int i=0;i<l.size();i++)
		{		
			WebElement link = l.get(i);
			if(link.isDisplayed())
			{
				text=link.getText();		
			}
			List<WebElement> l1 = driver.findElements(By.xpath(xpath1));
			WebElement link1 = l1.get(i);
			if(link1.isDisplayed())
			{
				text1=link1.getText();		
			}
			  map.put(text, text1);
			  	entr=map.entrySet();
		
			}
		for(Entry<String,String> e : entr)
		{
			 System.out.println(e);
		}
		 
		  File f = new File(location);
			Workbook w = new XSSFWorkbook();
			FileOutputStream createExcel = new FileOutputStream(f);
			Sheet s= w.createSheet(sheet);
			Row r =  s.createRow(0);
			Cell c = r.createCell(0);
			c.setCellValue("Mobile Name");
			Cell c1 = r.createCell(1);
			c1.setCellValue("Price");
			w.write(createExcel);
			createExcel.close();
			//System.out.println("Excel creation done");
			//createExcel.close();
		int i=1;
		for(Map.Entry<String,String> e : entr) {
			FileInputStream fmob = new FileInputStream(f);
			Workbook  bookmob = new XSSFWorkbook(fmob);
			Sheet sheetmob = bookmob.getSheet(sheet);
			Row rowMob = sheetmob.createRow(i);
			Cell cellMob = rowMob.createCell(0);
			cellMob.setCellValue(e.getKey());
			FileOutputStream f4 = new FileOutputStream(f);
			bookmob.write(f4);
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
			f4.close();
			i++;
		}
			int j=1;
			for(Map.Entry<String,String> e1 : entr) {
				FileInputStream f5 = new FileInputStream(f);
				Workbook  book1 = new XSSFWorkbook(f5);
				Sheet ss = book1.getSheet(sheet);
				Row rrr = ss.createRow(j);
				Cell ccc = rrr.createCell(1);
				ccc.setCellValue(e1.getValue());
				FileOutputStream f6 = new FileOutputStream(f);
				WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
				book1.write(f6);
				f6.close();
				j++;
		}
		  
	}
	
	public static void excelCreation(String location , String sheet)  {
		try {
			File f = new File(location);
//			FileInputStream f6 = new FileInputStream(f);
			Workbook w = new XSSFWorkbook();
			FileOutputStream createExcel = new FileOutputStream(f);
			Sheet s= w.createSheet(sheet);
			Row r =  s.createRow(0);
			Cell c = r.createCell(0);
			c.setCellValue("Mobile Name");
			Cell c1 = r.createCell(1);
			c1.setCellValue("Price");
			w.write(createExcel);
			System.out.println("Excel creation done");
			createExcel.close();
		}
	catch (Exception e)
		{
		
		}
//		Main.excelWrite(location, sheet, 0, 0, "Mobile Name");
//		Main.excelWrite(location, sheet, 0, 1, "Price");
		
	}
	
	public static void excelWrite(String location,String sheet , int row, int cell,String value) throws IOException, InterruptedException {
		File f = new File(location);
		FileInputStream write = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(write);
		Sheet s = w.getSheet(sheet);
		//Thread.sleep(1000);
			Row r = s.createRow(row);
			Cell c = r.createCell(cell);
			c.setCellValue(value);
			FileOutputStream f1 = new FileOutputStream(f);
			w.write(f1);
			//f1.close();
		
	}
	
	public static void excelRead(String location,String sheet , int row, int cell) throws IOException {
		File f = new File(location);
		FileInputStream read = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(read);
		Sheet s =  w.getSheet(sheet);
		Row r = s.getRow(row);
		Cell c = r.getCell(cell);
		String value = c.getStringCellValue();		
		System.out.println("Excel Read : " + value);
		
	}
	
	public static void inputMethod(String value,String xpath) {
		driver.findElement(By.xpath(xpath)).sendKeys(value);
		String attribute = 	driver.findElement(By.xpath(xpath)).getText();
		System.out.println(attribute);
		}

	public static void actions(String xpath) throws AWTException {
		
		
	}
	
	
}
	

