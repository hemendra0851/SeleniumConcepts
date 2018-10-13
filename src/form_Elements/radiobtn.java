package form_Elements;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class radiobtn {
	
	
	public void radio(WebDriver driver) throws Exception
	{
		
		
		driver.findElement(By.xpath("//*[@id=\"treemenu\"]/li/ul/li[1]/a")).click();
		System.out.println("Button 1 clicked");
		driver.findElement(By.xpath("//*[@id=\"treemenu\"]/li/ul/li[1]/ul/li[3]")).click();
		System.out.println("Link clicked");
		
		List<WebElement> Radio = driver.findElements(By.name("optradio"));
			Radio.get(0).click();
			driver.findElement(By.id("buttoncheck"));
			
		List<WebElement> Gender = driver.findElements(By.name("gender"));
		Gender.get(0).click();			
		List<WebElement> Age = driver.findElements(By.name("ageGroup"));
		Age.get(2).click();	
		driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/button")).click();
		
		TakesScreenshot	 ts = (TakesScreenshot)driver;
		File source	= ts.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(source, new File("./Screenshots/radio.png"));
		
		System.out.println("----------------------------");
		System.out.println("-- Test Passed : RadioBtn --");
		System.out.println("----------------------------");
	}

}
