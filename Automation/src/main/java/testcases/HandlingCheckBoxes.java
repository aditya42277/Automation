package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class HandlingCheckBoxes {
	
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
	
	public static void checkAllCheckBoxes(By by) {
		List<WebElement> allChkBoxes = driver.findElements(by);
		for(int i = 0; i < allChkBoxes.size(); i++) {
			allChkBoxes.get(i).click();
		}
	}
	
	public static void checkParticularCheckBox(By by, int index) {
		List<WebElement> allChkBoxes = driver.findElements(by);
		if(index > allChkBoxes.size()) {
			System.out.println("Nothing will be selected, as the index is greater than the number of checkboxes in the DOM");
			return;
		}
		allChkBoxes.get(index).click();
	}
	
	public static void checkOnlyThoseCheckBoxesWhichIsUnchecked(By by) {
		List<WebElement> allChkBoxes = driver.findElements(by);
		for(int i = 0; i < allChkBoxes.size(); i++) {
			if(allChkBoxes.get(i).isSelected()) {
				//allChkBoxes.get(i).click();
				continue;
			}else {
				allChkBoxes.get(i).click();
			}
		}
	}
	
	public static void checkTheCheckBox(String x) {
		
		int i = 1;
		int count = 0;
		while(isElementPresent(By.xpath(x+"["+i+"]"))) {
			driver.findElement(By.xpath(x+"["+i+"]")).click();
			i++;
			count++;
		}
		
		System.out.println("Total Number of check boxes : " + count);
		
	}
	
	public static void printCheckBoxNames(By by) {
		List<WebElement> chkBox = driver.findElements(by);
		for(int i = 0; i < chkBox.size(); i++) {
			System.out.println("Value : " + chkBox.get(i).getAttribute("value"));
			    
		}
	}

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://tizag.com/htmlT/htmlcheckboxes.php");
		driver.manage().window().maximize();
		
		String xpath = "(//div[@class ='display'])[1]//input";
		//checkAllCheckBoxes(By.xpath(xpath));
		//checkParticularCheckBox(By.xpath(xpath), 9);
		
		/*
		 * String xpath1 = "(//div[@class ='display'])[2]//input";
		 * checkOnlyThoseCheckBoxesWhichIsUnchecked(By.xpath(xpath1));
		 */
		
		checkTheCheckBox(xpath);

	}

}
