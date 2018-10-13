package locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Id {

	public static void main(String[] args) {

		ChromeOptions chromeOptions= new ChromeOptions();
		chromeOptions.setBinary("C:\\Program Files (x86)\\Google\\Chrome Beta\\Application\\chrome.exe");
		 		
		String chromePath = "F:\\Software\\Selenium\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		
		WebDriver driver = new ChromeDriver(chromeOptions);
		
		driver.quit();
	}

}
