package testCases;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilities.ExcelFileReader;

public class DDT_FileReader {	
	
	static WebDriver driver= new ChromeDriver();

	@BeforeTest
	public void launchBrowser() throws InterruptedException {
		
		System.getProperty("user.dir", System.getProperty("chromeDriver"));
		Thread.sleep(2000);
		driver.get("http://122.170.14.195:8080/uth/gadgetsgallery/catalog/index.php");
		
//		driver.get("http://automationpractice.com/index.php?controller=authentication");
		driver.manage().window().maximize();

	}
	
	@Test(dataProvider = "getTestdata")
	public void FileReader(String username, String password) throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"top_menu\"]/span[1]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div[1]/a[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"loginModules\"]/div[1]/div/form/table/tbody/tr[1]/td[2]/input")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id=\"loginModules\"]/div[1]/div/form/table/tbody/tr[2]/td[2]/input")).sendKeys(password);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\'tdb1\']")).click();	
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"top_menu\"]/span[6]/a")).click();

	
	}
	
	@DataProvider
	public Object[][] getTestdata(){
		
		ExcelFileReader excel= new ExcelFileReader("./src/files/excelFileData.xlsx");
		
		int Rows= excel.totalRow("DDTData");
		int Columns = excel.totalColumn("DDTData");
		
		System.out.println("Number of Rows and Columns are:" +Rows+ " and " +Columns);
		
		Object[][] data= new Object[Rows-1][Columns];
		
		for(int row=1; row<Rows ; row++) {
			
			for(int col=0 ; col<Columns ; col++) {
								
				data[row-1][col]= excel.getData("DDTData", row, col);
				System.out.println(excel.getData("DDTData", row, col));
			}
			
		}		
		
		return data;
		
	}
}


























