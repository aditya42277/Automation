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

public class MouseOver {
	
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.way2automation.com");
		driver.manage().window().maximize();		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		String allCoursesXpath = "//li[@id = 'menu-item-27580']//span[normalize-space() = 'All Courses']";
		WebElement menu = driver.findElement(By.xpath(allCoursesXpath));
		
		Actions act = new Actions(driver);
		act.moveToElement(menu).perform();	
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("DevOps"))).click();
		//driver.findElement(By.linkText("DevOps")).click();
		
		String headingText = driver.findElement(By.xpath("//h1[normalize-space() = 'DevOps']")).getText();
		System.out.println("The heading is : " + headingText);
		

	}

}
