package datePicker;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BootstrapDatePicker {

	public static void main(String[] args) {
		
		ChromeOptions chromeOptions= new ChromeOptions();
		chromeOptions.setBinary("C:\\Program Files (x86)\\Google\\Chrome Beta\\Application\\chrome.exe");
		
		String exePath = "F:\\Software\\Selenium\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		
		String url = "http://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
		//Single Date
		WebElement date = driver.findElement(By.xpath("//*[@class='glyphicon glyphicon-th']"));
		
		((JavascriptExecutor) driver).executeScript("argument[0].scrollIntoView(true);", date);
		
		
	}

}
