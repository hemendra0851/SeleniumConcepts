package form_Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class home {

	public static void main(String[] args) throws Exception {
		// Test Project
		
		ChromeOptions chromeOptions= new ChromeOptions();
		chromeOptions.setBinary("C:\\Program Files (x86)\\Google\\Chrome Beta\\Application\\chrome.exe");
		
		String exePath = "F:\\Software\\Selenium\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		/*
		simpleform obj1 = new simpleform();
		checkbox obj2 = new checkbox();
		radiobtn obj3 = new radiobtn();
		SimpleDropdown obj4 = new SimpleDropdown();
		jQueryDropdown_1 obj5 = new jQueryDropdown_1();
		jQueryDropdown_2 obj6 = new jQueryDropdown_2();
		jQueryDropdown_3 obj7 = new jQueryDropdown_3();
		*/
		AjaxForm obj8 = new AjaxForm();
				
		WebDriver driver = new ChromeDriver(chromeOptions);
		
		driver.manage().window().maximize();
		driver.get("http:\\www.seleniumeasy.com\\test");
		
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/nav/div/div[1]/div/a")).click();
		System.out.println("Demo clicked");
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
				
		//obj1.simple(driver);
		//obj2.check(driver);
		//obj3.radio(driver);
		//obj4.select(driver);
		//obj5.select(driver);
		//obj6.select(driver);
		//obj7.select(driver);
		obj8.select(driver);
		
		driver.quit();

	}

}
