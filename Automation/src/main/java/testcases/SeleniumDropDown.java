package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumDropDown {
	
	public static WebDriver driver;
	
	public static boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
		
	}

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.wikipedia.org/");
		driver.manage().window().maximize();
		
		WebElement drpDwn = driver.findElement(By.xpath("//select[@id= 'searchLanguage']"));
		System.out.println(drpDwn.isDisplayed());
		
		
		System.out.println("The element is present or not :" + isElementPresent(By.xpath("//select[@id= 'searchLanguage']")));
		
		
		

	}

}
