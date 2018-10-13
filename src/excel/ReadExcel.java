package excel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ReadExcel {

	public static void main(String[] args) {
		
		ChromeOptions chromeOptions= new ChromeOptions();
		chromeOptions.setBinary("C:\\Program Files (x86)\\Google\\Chrome Beta\\Application\\chrome.exe");
		
		String exePath = "F:\\Software\\Selenium\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		

	}

}
