package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Registration {
	
	public static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://way2automation.com/way2auto_jquery/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Enter the Name
		driver.findElement(By.cssSelector("input[name = name]")).sendKeys("Aditya");
		
		//Enter the phone
		driver.findElement(By.cssSelector("input[name = phone]")).sendKeys("4845242689");
		
		//Enter the email
		driver.findElement(By.cssSelector("input[name = email]")).sendKeys("addy.ranjan@gmail.com");
		
		//Select the drop down
		WebElement ctryDropDown = driver.findElement(By.cssSelector("select[name = country]"));
		
		Select sel = new Select(ctryDropDown);
		sel.selectByVisibleText("Philippines");
		
		//Enter the city
		driver.findElement(By.cssSelector("input[name = city]")).sendKeys("Manila");
		
		//Enter User Name
		driver.findElement(By.xpath("(//input[@name='username'])[2]")).sendKeys("aditya42277");
		
		//Enter Password
		driver.findElement(By.xpath("(//input[@name='password'])[2]")).sendKeys("password12");
		
		
		//Click the submit button
		driver.findElement(By.xpath("(//input[@type = 'submit' and @class = 'button'])[2]")).click();
		
		String expectedText = "This is just a dummy form, you just clicked SUBMIT BUTTON";
		
		String actualText = driver.findElement(By.xpath("//p[normalize-space() ='This is just a dummy form, you just clicked SUBMIT BUTTON']")).getText();
		//System.out.println("Actual Text :" + actualText);
		
		if(actualText.equalsIgnoreCase(expectedText)) {
			System.out.println("Submit button clicked successfully!");
		}
		
		
		
	}

}
