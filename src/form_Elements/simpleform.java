package form_Elements;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class simpleform {
	
	public void simple(WebDriver driver) throws Exception
	{
		
		driver.findElement(By.xpath("//*[@id=\"treemenu\"]/li/ul/li[1]/a")).click();
		System.out.println("Button 1 clicked");
		driver.findElement(By.xpath("//*[@id=\"treemenu\"]/li/ul/li[1]/ul/li[1]")).click();
		System.out.println("Link clicked");
		
		driver.findElement(By.id("user-message")).sendKeys("Hello Text");
		driver.findElement(By.xpath("//*[@id=\"get-input\"]/button")).click();
		TakesScreenshot	 ts = (TakesScreenshot)driver;
		File source	= ts.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(source, new File("./Screenshots/simple.png"));
		
		System.out.println("----------------------------");
		System.out.println("--Test Passed : SimpleForm--");
		System.out.println("----------------------------");
	}

}
