package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Resizable {
	
	public static WebDriver driver;
	
	public static void startUp(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	public static void resizable(WebElement web, int width, int height) {
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(web, width, height).perform();
		
	}

	public static void main(String[] args) {
		
		startUp("https://jqueryui.com/resources/demos/resizable/default.html");
		
		String xpath = "//div[@class = 'ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']";
		WebElement resize = driver.findElement(By.xpath(xpath));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		resizable(resize, 400, 400);
		resizable(wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))), -200, -200);
		
		
		
		

	}

}
