package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CiricInfo {

	public static WebDriver driver;

	public static void displayScoreCard(By by) {
		List<WebElement> scoreCardList = driver.findElements(by);
		for (int i = 0; i < scoreCardList.size(); i++) {
			System.out.print(scoreCardList.get(i).getText() + " ");
		}

	}

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(
				"https://www.espncricinfo.com/series/australia-in-india-2022-1327497/india-vs-australia-3rd-t20i-1327505/full-scorecard");
		driver.manage().window().maximize();

		String xpath = "(//tbody)[1]//tr[not(contains(@class, 'hidden'))]//td[contains(@class , 'ds-w-0 ds-whitespace-nowrap ds-min-w-max') and not(contains(@class, 'hidden'))]";
		displayScoreCard(By.xpath(xpath));

	}
}
