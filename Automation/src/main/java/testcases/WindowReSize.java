package testcases;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowReSize {
	
	public static WebDriver driver;
	
	public static void startUp(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);			
	}
	
	public static void setWindowSize(WebDriver driver, int x, int y) {
		Point pt = new Point(x, y);
		driver.manage().window().setPosition(pt);
	}
	
	
	

	public static void main(String[] args) throws InterruptedException {
		
		startUp("https://www.way2automation.com/");
		setWindowSize(driver, 250, 350);
		//Thread.sleep(3000);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofSeconds(100)).withMessage("User defined message : Timed out!").ignoring(NoSuchElementException.class);
		setWindowSize(driver, 550, 650);
		
		

	}

}
