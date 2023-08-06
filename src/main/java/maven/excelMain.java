package maven;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class excelMain {
	public static void main(String[] args) throws IOException, InterruptedException {
//		Main.excelCreation("D:\\Java Workspace\\Excel data\\dataSheet.xlsx", "sheet1");
//		Main.excelRead("D:\\Java Workspace\\Excel data\\read.xlsx", "Sheet1", 0,0);
//		Main.excelRead("D:\\Java Workspace\\Excel data\\read.xlsx", "Sheet1", 6, 4);
//		Main.excelWrite("D:\\Java Workspace\\Excel data\\dataSheet.xlsx", "sheet1", 0, 0, "excel write");
//		Main.excelWrite("D:\\Java Workspace\\Excel data\\dataSheet.xlsx", "sheet1", 5, 7, "vanakkam");
		
		File f = new File("D:\\Java Workspace\\Excel data\\sheet.xlsx");
		FileOutputStream f1 = new FileOutputStream(f);
		Workbook wb = new XSSFWorkbook();
		Sheet s = wb.createSheet("Sheet1");
		Row r = s.createRow(0);
		Cell c = r.createCell(0);
		c.setCellValue("Mobile Name");
		Cell c1 = r.createCell(1);
		c1.setCellValue("Price");
		//wb.write(f1);
		
		for(int i=1;i<=5;i++)
		{
			Row r1 = s.createRow(i);
			Cell c2 = r1.createCell(0);
			c2.setCellValue("Value");
			
		}
		for(int j=1;j<5;j++)
		{
			Row r2 = s.createRow(1);
			Cell c3 = r2.createCell(j);
			c3.setCellValue("12000");
		}
		wb.write(f1);
		
	}
}
