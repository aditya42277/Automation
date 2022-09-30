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

public class TestRightClick {
	
public static WebDriver driver;
	
	public static void startUp(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);			
		driver.manage().window().maximize();
	}
	
	public static void doRightClick(WebElement web) {
		Actions act = new Actions(driver);
		act.contextClick(web).perform();		
	}
	
	public static void mouseOver(WebElement web) {
		Actions act = new Actions(driver);
		act.moveToElement(web).perform();		
	}
	
	public static void click(WebElement web) {
		web.click();
	}

	public static void main(String[] args) {
		
		startUp("https://deluxe-menu.com/popup-mode-sample.html");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		String firstLevelXPath = "//img[@src = 'data-samples/images/popup_pic.gif']";
		WebElement w = driver.findElement(By.xpath(firstLevelXPath));
		doRightClick(w);
		
		String secondLevelXpath = "//td[@id = 'dm2m1i1tdT']";
		WebElement w1 = driver.findElement(By.xpath(secondLevelXpath));
		mouseOver(w1);
		
		String thirdLevelXpath = "//td[@id = 'dm2m2i1tdT']";
		WebElement w2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(thirdLevelXpath)));
		mouseOver(w2);
		
		String fourthLevelXpath = "//td[@id = 'dm2m3i0tdT' and normalize-space() = 'Description of Files']";
		WebElement w3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(fourthLevelXpath)));
		System.out.println(w3.getText());
		click(w3);

	}

}
