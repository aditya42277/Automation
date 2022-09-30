package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {
	
public static WebDriver driver;
	
	public static void startUp(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	public static void dragAndDrop(WebElement draggable, WebElement droppable) {
		Actions act = new Actions(driver);
		act.dragAndDrop(draggable, droppable).perform();
	}
	
	public static void dragAndDropElseWhere(WebElement draggable, int x, int y) {
		Actions act = new Actions(driver);
		act.dragAndDropBy(draggable, x, y).perform();
	}

	public static void main(String[] args) {
		
		startUp("https://jqueryui.com/resources/demos/droppable/default.html");
		
		WebElement dragSrc = driver.findElement(By.xpath("//div[@id = 'draggable']"));
		WebElement dropSrc = driver.findElement(By.xpath("//div[@id = 'droppable']"));
		
		//dragAndDrop(dragSrc, dropSrc);
		dragAndDropElseWhere(dragSrc, 100, 200);
		
		
		
		

	}

}
