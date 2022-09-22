package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestWebElements {
	
	public static String browser = "edge";
    public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException  {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://gmail.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
		WebElement userNameTextBox = driver.findElement(By.cssSelector("#identifierId"));
		userNameTextBox.sendKeys("addy.ranjan@gmail.com");		
		
		WebElement googleText = driver.findElement(By.cssSelector("div#logo"));	
		System.out.println("Text on the page : " + googleText.getAttribute("title"));
		
		WebElement signInText = driver.findElement(By.cssSelector("div.rQszV "));
		System.out.println("Sign In Text : " + signInText.getText());
		
		WebElement otherText = driver.findElement(By.cssSelector("span div.CX6Ruf.ataLTc div.PrDSKc"));
		System.out.println(otherText.getText());
		
		//Thread.sleep(5000);
		
		
		WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.F9NWFb button")));
		nextButton.click();
		
		Thread.sleep(3000);
		driver.navigate().back();
		
		//Thread.sleep(3000);	
		WebElement forgotEmailLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[jsname*='Cuz2Ue']")));
		forgotEmailLink.click();
		System.out.println("Forgot Email link clicked");
		
		
		

	}

}
