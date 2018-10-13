package form_Elements;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class checkbox {
	
	
	public void check(WebDriver driver) throws Exception 
	{
		
		driver.findElement(By.xpath("//*[@id=\"treemenu\"]/li/ul/li[1]/a")).click();
		System.out.println("Button 1 clicked");
		driver.findElement(By.xpath("//*[@id=\"treemenu\"]/li/ul/li[1]/ul/li[2]")).click();
		System.out.println("Link clicked");
		
		driver.findElement(By.id("isAgeSelected")).click();
		List<WebElement> Checkbox = driver.findElements(By.className("cb1-element"));
		for(int i=0;i < Checkbox.size();i++){
			Checkbox.get(i).click();
		  }
		driver.findElement(By.id("check1")).click();
		
		TakesScreenshot	 ts = (TakesScreenshot)driver;
		File source	= ts.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(source, new File("./Screenshots/check.png"));
		
		System.out.println("----------------------------");
		System.out.println("-- Test Passed : Checkbox --");
		System.out.println("----------------------------");
	}

}
