package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinksInPage {
	
	public static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.wikipedia.org/");
		driver.manage().window().maximize();
		
		//Get the links from a particular portion of the page.
		WebElement section = driver.findElement(By.cssSelector("div.other-projects"));
		List<WebElement> lnksSection = section.findElements(By.tagName("a"));
		System.out.println("Number of links in the Section : " + lnksSection.size());
		
		for(WebElement lnk : lnksSection) {
			System.out.println(lnk.getText() + "----URL----" + lnk.getAttribute("href"));
		}
		
		WebElement dropDown = driver.findElement(By.xpath("//select[@id = 'searchLanguage']"));
		List<WebElement> lst = dropDown.findElements(By.tagName("option"));
		System.out.println("Number of options in the dropdown : " + lst.size());
		
		driver.findElement(By.xpath("//span[normalize-space() = 'Read Wikipedia in your language']")).click();
		
		WebElement footerSection = driver.findElement(By.xpath("(//div[@id = 'js-lang-lists']/child :: div[@class = 'langlist langlist-large hlist'])[1]"));
		List<WebElement> lnksFooterSection = footerSection.findElements(By.tagName("a"));
		System.out.println("Total Number of links in the first footer section : " + lnksFooterSection.size());
		
		for(int i = 0; i < lnksFooterSection.size(); i++) {
			System.out.println(lnksFooterSection.get(i).getAttribute("lang") + "--------------" + lnksFooterSection.get(i).getAttribute("href") + "--------------" +lnksFooterSection.get(i).getText());
		}

		
		/*
		 * List<WebElement> ftLinks = driver.findElements(By.
		 * xpath("(//div[@id = 'js-lang-lists']/child :: div[@class = 'langlist langlist-large hlist'])[1]/descendant:: a"
		 * )); for(int i = 0; i < ftLinks.size(); i++) {
		 * System.out.println(ftLinks.get(i).getText()); }
		 */

	}

}
