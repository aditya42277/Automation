package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDropDown {
	
	public static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.wikipedia.org/");
		driver.manage().window().maximize();
		
		WebElement langDropDown = driver.findElement(By.xpath("//select[@id = 'searchLanguage']"));
		
		Select sel = new Select(langDropDown);
		//sel.selectByVisibleText("Hrvatski");
		//sel.selectByValue("hi");
		
		//Find out all the options as displayed in the drodown list.
		List<WebElement> allOptions = driver.findElements(By.xpath("//select[@id = 'searchLanguage']//option"));
		
		for(int i = 0; i < allOptions.size(); i++) {
			System.out.println(allOptions.get(i).getAttribute("value") + "-------"+ allOptions.get(i).getText());
		}
		
		//All the links in the page.
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		System.out.println("Total links on the page : " + links.size());
		
		for(int i = 0; i < links.size(); i++) {
			System.out.println(links.get(i).getText() + "---URL is----" + links.get(i).getAttribute("href"));
		}
		
		
		
		 

	}

}
