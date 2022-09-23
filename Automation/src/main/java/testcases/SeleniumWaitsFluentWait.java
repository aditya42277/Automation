package testcases;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumWaitsFluentWait {
	
	public static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("http://automationpractice.com");
		driver.manage().window().maximize();
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofSeconds(1)).withMessage("User defined message : Timed out!").ignoring(NoSuchElementException.class);

		// Click on Sign In Button
		WebElement signInButton = driver.findElement(By.cssSelector("a.login"));
		signInButton.click();

		// Enter UserName
		WebElement userName = driver.findElement(By.cssSelector("input#email"));
		userName.sendKeys("adityab42277@gmail.com");

		// Enter Password
		WebElement password = driver.findElement(By.cssSelector("input#passwd"));
		password.sendKeys("password12");

		// Click On Submit Button
		WebElement submitBtn = driver.findElement(By.cssSelector("button#SubmitLogin"));
		submitBtn.click();
		
		WebElement search = driver.findElement(By.cssSelector("input#search_query_top"));
		search.sendKeys("t-shirts");
		
		WebElement searchBtn = driver.findElement(By.cssSelector("button[name='submit_search']"));
		searchBtn.click();
		
		WebElement womenButton = driver.findElement(By.xpath("//div[@id = 'block_top_menu']//a[normalize-space() = 'Women']"));
		womenButton.click();
		
		
		/*boolean elementFound = wait.until(ExpectedConditions.textToBePresentInElementValue(By.xpath("//span[normalize-space() = 'There are 7 products.']"), "There are 7 products."));
		System.out.println("The number of products is found : " + elementFound);*/
		/*
		 * WebElement items = driver.findElement(By.
		 * xpath("//span[normalize-space() = 'There are 7 products.']"));
		 * System.out.println("Total number of dresses : " + items.getText());
		 */
		
		WebElement quickView = driver.findElement(By.xpath("//a[normalize-space() = 'Faded Short Sleeve T-shirts']"));
		quickView.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space() = 'Add to cart']"))).click();
		WebElement txt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[normalize-space() = 'Product successfully added to your shopping cart']")));		 
		System.out.println("Final Text : " + txt.getText());

	}

}
