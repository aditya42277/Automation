package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumWaitsImplicit {
	
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com");
		driver.manage().window().maximize();
		
		//Add Implicit Wait	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Click on Sign In Button
		WebElement signInButton = driver.findElement(By.cssSelector("a.login"));
		signInButton.click();
		
		//Enter UserName
		WebElement userName = driver.findElement(By.cssSelector("input#email"));
		userName.sendKeys("adityab42277@gmail.com");
		
		
		
		//Enter Password
		WebElement password = driver.findElement(By.cssSelector("input#passwd"));		
		password.sendKeys("password12");
		
		//Click On Submit Button
		WebElement submitBtn = driver.findElement(By.cssSelector("button#SubmitLogin"));
		submitBtn.click();
		
		//Thread.sleep(2000);
		//Get Text
		WebElement text = driver.findElement(By.xpath("//span[normalize-space()='Aditya Bhattacharya']"));
		System.out.println("Account Holder Name : " + text.getText());
		
		WebElement search = driver.findElement(By.cssSelector("input#search_query_top"));
		search.sendKeys("t-shirts");
		
		WebElement searchBtn = driver.findElement(By.cssSelector("button[name='submit_search']"));
		searchBtn.click();
		
		WebElement noOfElementsFound = driver.findElement(By.xpath("//span[normalize-space() = '1 result has been found.']"));
		System.out.println(noOfElementsFound.getText());
		
		WebElement chifonDress = driver.findElement(By.xpath("(//a[normalize-space() = 'Printed Chiffon Dress'])[1]"));
		System.out.println("Dress Type  : " + chifonDress.getText());
		
		WebElement prodDesc = driver.findElement(By.xpath("//p[normalize-space() = 'Printed chiffon knee length dress with tank straps. Deep v-neckline.']"));
		System.out.println("Product Description : " + prodDesc.getText());
		
		
		
		
		
		
		
		

	}

}
