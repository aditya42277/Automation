package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBrowser {
	
	public static String browser = "edge";
	public static WebDriver driver;
	//public static SearchContext driver;
	//public static RemoteWebDriver driver;
	
	public static void main(String[] args) {
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();			
		}else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();			
		}else if(browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();			
		}
		
		driver.get("http://way2automation.com");
		driver.manage().window().maximize();
		System.out.println("Title of the page : " + driver.getTitle());
		
		
	}

}
