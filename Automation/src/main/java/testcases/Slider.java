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

public class Slider {
	
	public static WebDriver driver;
	
	public static void moveTheSlider(By by, int width, int height) {
		WebElement slider = driver.findElement(by);
		Actions act = new Actions(driver);
		act.dragAndDropBy(slider, width, height).perform();
	}
	
	public static void moveTheSliderByWebElement(WebElement slider, int width, int height) {
		Actions act = new Actions(driver);
		act.dragAndDropBy(slider, width, height).perform();		
	}
	
	public static void main(String[] args) throws InterruptedException {
		

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resources/demos/slider/default.html");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(35));
		
		String xpath = "//div[@id = 'slider']";
		
		WebElement mainSlider = driver.findElement(By.xpath(xpath));
		
	/*	moveTheSlider(By.xpath(xpath), 400, 0);
		Thread.sleep(2000);				
		moveTheSlider(By.xpath(xpath), -100, 0); */
		
		moveTheSliderByWebElement(mainSlider, 400, 0);
		moveTheSliderByWebElement(wait.until(ExpectedConditions.elementToBeClickable(mainSlider)), -100, 0);
		
		
		
		
				
	}

}
