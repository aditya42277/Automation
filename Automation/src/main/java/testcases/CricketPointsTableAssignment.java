package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CricketPointsTableAssignment {
	
	public static WebDriver driver;
	

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.espncricinfo.com/series/icc-women-s-championship-2022-23-2025-1308225/points-table-standings");
		driver.manage().window().maximize();
		
		List<WebElement> rows = driver.findElements(By.xpath("//tbody[@class = 'ds-text-center']//td[@class = 'ds-sticky ds-left-0 ds-z-10 ds-table-row-sticky ds-min-w-max ds-bg-fill-content-prime']"));
		int numberOfRows = rows.size();
	//	System.out.println(numberOfRows);
		
		List<WebElement> cols = driver.findElements(By.xpath("//thead[@class = 'ds-bg-fill-content-alternate ds-text-left ds-text-right']//th[@class = 'ds-w-0 ds-whitespace-nowrap ds-min-w-max']"));
		int numberOfCols = cols.size();
	//	System.out.println(numberOfCols);
		
		for(int i = 0; i < numberOfRows; i++) {
			System.out.print((i+1) + " " + driver.findElement(By.xpath("(//tr[@class = 'ds-text-tight-s'])[" + (i+1) + "]//td//span[@class = 'ds-text-tight-s ds-font-bold ds-uppercase ds-text-left']")).getText() + "		");
			for(int j = 0; j < numberOfCols; j++) {
				System.out.print(driver.findElement(By.xpath("((//tr[@class = 'ds-text-tight-s'])[" + (i+1) + "]//td[contains(@class , 'ds-w-0 ds-whitespace-nowrap ds-min-w-max')])[" + (j + 1) + "]")).getText() + " ");
			}
			System.out.println();
		}
		
		
		
		 

	}

}
