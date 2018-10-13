package locators;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TagName {

	public static void main(String[] args) {
		
		ChromeOptions chromeOptions= new ChromeOptions();
		chromeOptions.setBinary("C:\\Program Files (x86)\\Google\\Chrome Beta\\Application\\chrome.exe");
		 		
		String chromePath = "F:\\Software\\Selenium\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		
		WebDriver driver = new ChromeDriver(chromeOptions);
		
		 driver.get("http://www.google.com");
		 
		 List <WebElement> list = driver.findElements(By.tagName("a"));
		 
		 System.out.println("Number of links: "+list.size());
		 
		 for(int i = 0; i < list.size(); i++){
			 
		 System.out.println(list.get(i).getText());
		 
		 }
		 
		 list.get(1).click();
		 
		 System.out.println(driver.getTitle());
		 
		 driver.quit();
	}

}
