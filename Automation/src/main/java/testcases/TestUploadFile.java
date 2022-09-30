package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestUploadFile {
	
	public static WebDriver driver;
	
	public static void startUp(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);			
	}
	

	public static void main(String[] args) {
		
		startUp("https://www.way2automation.com/way2auto_jquery/registration.php#load_box");
		driver.findElement(By.xpath("//input[@type = 'file']")).sendKeys("C:\\Users\\14845\\Dropbox\\Training\\DataDrivenTestingWithTestNG\\DataFiles\\dates.xlsx");
		
		

	}

}
